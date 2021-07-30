package me.moomoo.worldstats;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.text.DecimalFormat;
import java.util.Calendar;

public class Commands implements CommandExecutor, Listener {
    private final Main plugin;

    public Commands(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1 || !args[0].equals("reload")) {
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
                if (sender instanceof Player && Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
                    sender.sendMessage(PlaceholderAPI.setPlaceholders((OfflinePlayer) sender, ChatColor.translateAlternateColorCodes('&', s)
                            .replace("%years%", String.valueOf(mYear))
                            .replace("%months%", String.valueOf(mMonth))
                            .replace("%days%", String.valueOf(mDay))
                            .replace("%fileSize%", new DecimalFormat("#.##").format(plugin.size))
                            .replace("%fileSize_spoof%", new DecimalFormat("#.##").format(plugin.size + plugin.getConfig().getLong("spoofsize")))
                            .replace("%totalPlayers%", String.valueOf(plugin.offlinePlayers))));
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', s)
                            .replace("%years%", String.valueOf(mYear))
                            .replace("%months%", String.valueOf(mMonth))
                            .replace("%days%", String.valueOf(mDay))
                            .replace("%fileSize%", new DecimalFormat("#.##").format(plugin.size))
                            .replace("%fileSize_spoof%", new DecimalFormat("#.##").format(plugin.size + plugin.getConfig().getLong("spoofsize")))
                            .replace("%totalPlayers%", String.valueOf(plugin.offlinePlayers)));
                }
            }
        } else {
            plugin.reloadConfig();
            sender.sendMessage(ChatColor.GOLD + "WorldStats config reloaded.");
        }
        return true;
    }
}
