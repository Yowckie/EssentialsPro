package me.thedoffman.essentialspro.commands;

import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Time
implements CommandExecutor {
    private Main plugin = (Main)Main.getPlugin(Main.class);

    public Time(Main plugin) {
        Bukkit.getPluginCommand((String)"time").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        this.plugin.prefix = this.plugin.prefix.replaceAll("&", "§");
        if (cmd.getName().equalsIgnoreCase("time") && !sender.hasPermission("ep.time")) {
            sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
            return true;
        }
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (args.length == 0) {
                player.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "usage: /time [day:night:noon]");
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("day")) {
                    player.getWorld().setTime(0L);
                    player.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.DARK_GREEN + "Time set to Day.");
                } else if (args[0].equalsIgnoreCase("night")) {
                    player.getWorld().setTime(14000L);
                    player.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.DARK_GREEN + "Time set to Night.");
                } else if (args[0].equalsIgnoreCase("noon")) {
                    player.getWorld().setTime(6000L);
                    player.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.DARK_GREEN + "Time set to Noon.");
                } else {
                    player.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "usage: /time [day:night]");
                    return true;
                }
            }
        }
        return true;
    }
}

