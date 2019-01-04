package me.thedoffman.essentialspro.commands;

import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TP_Position
implements CommandExecutor {
    private Main plugin = (Main)Main.getPlugin(Main.class);

    public TP_Position(Main plugin) {
        Bukkit.getPluginCommand((String)"tpc").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] arg) {
        this.plugin.prefix = this.plugin.prefix.replaceAll("&", "§");
        Player player = (Player)sender;
        if (!(sender instanceof Player)) {
            sender.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "Only players can perform this command!");
        } else if (cmd.getName().equalsIgnoreCase("tpc") && player.isOp()) {
            if (!sender.hasPermission("ep.tpc")) {
                sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            if (arg.length < 3) {
                player.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "Too few arguements. /tpc <x> <y> <z>");
            } else if (arg.length > 3) {
                player.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "Too many arguements. /tpc <x> <y> <z>");
            } else {
                try {
                    double x = Integer.parseInt(arg[0]);
                    double y = Integer.parseInt(arg[1]);
                    double z = Integer.parseInt(arg[2]);
                    Location loc = new Location(player.getWorld(), x, y, z);
                    player.teleport(loc);
                    player.sendMessage(String.valueOf(this.plugin.prefix) + "Teleporting to X:" + x + " Y:" + y + " Z:" + z);
                }
                catch (NumberFormatException e) {
                    player.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "The numbers may not have decimals!");
                }
            }
        } else {
            player.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "You do not have permission to use this command");
        }
        return true;
    }
}

