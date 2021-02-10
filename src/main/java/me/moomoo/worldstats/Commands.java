package me.moomoo.worldstats;

import net.minecraft.server.v1_12_R1.CommandExecute;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

import java.text.DecimalFormat;
import java.util.Calendar;

public class Commands extends CommandExecute implements CommandExecutor, Listener {
    private final Main plugin;

    public Commands(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis() - plugin.getConfig().getLong("time"));
        int mYear = c.get(Calendar.YEAR) - 1970;
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH) - 1;
        if (mYear < 0) {
            mYear = 0;
            mMonth = 0;
            mDay = 0;
        }
        for (String s : plugin.getConfig().getStringList("message")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', s)
                    .replace("%years%", String.valueOf(mYear))
                    .replace("%months%", String.valueOf(mMonth))
                    .replace("%days%", String.valueOf(mDay))
                    .replace("%fileSize%", new DecimalFormat("#.##").format(plugin.size))
                    .replace("%totalPlayers%", String.valueOf(plugin.offlinePlayers)));
        }
        return true;
    }
}
