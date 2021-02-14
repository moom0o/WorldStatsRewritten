package me.moomoo.worldstats;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;

public class Expansions extends PlaceholderExpansion {
    private final Main plugin;

    public Expansions(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public @NotNull String getAuthor() {
        return "moo";
    }

    @Override
    public @NotNull String getIdentifier() {
        return "worldstats";
    }

    @Override
    public @NotNull String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String identifier) {
        if (identifier.equals("filesize")) {
            return String.valueOf(new DecimalFormat("#.##").format(plugin.size));
        }
        if (identifier.equals("players")) {
            return String.valueOf(plugin.offlinePlayers);
        }
        return null;
    }
}
