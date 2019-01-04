package me.thedoffman.essentialspro.commands;

import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Weather
implements CommandExecutor {
    private Main plugin = (Main)Main.getPlugin(Main.class);

    public Weather(Main plugin) {
        Bukkit.getPluginCommand((String)"weather").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        this.plugin.prefix = this.plugin.prefix.replaceAll("&", "§");
        if (cmd.getName().equalsIgnoreCase("weather") && !sender.hasPermission("ep.weather")) {
            sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
            return true;
        }
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (args.length == 0) {
                player.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "usage: /weather [clear:rain]");
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("clear")) {
                    Bukkit.getWorld((String)"world").setStorm(false);
                    player.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.GRAY + "Weather set to" + (Object)ChatColor.DARK_GREEN + " Clear");
                } else if (args[0].equalsIgnoreCase("rain")) {
                    Bukkit.getWorld((String)"world").setStorm(true);
                    player.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.GRAY + "Time set to" + (Object)ChatColor.DARK_GREEN + " Rain");
                } else {
                    player.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "usage: /weather [clear:rain]");
                    return true;
                }
            }
        }
        return true;
    }
}

