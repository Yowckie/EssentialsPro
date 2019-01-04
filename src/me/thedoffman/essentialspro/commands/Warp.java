package me.thedoffman.essentialspro.commands;

import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Warp
implements CommandExecutor {
    private static Main plugin = (Main)Main.getPlugin(Main.class);

    public Warp(Main plugin) {
        Bukkit.getPluginCommand((String)"warp").setExecutor((CommandExecutor)this);
        Bukkit.getPluginCommand((String)"setwarp").setExecutor((CommandExecutor)this);
        Bukkit.getPluginCommand((String)"delwarp").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Warp.plugin.prefix = Warp.plugin.prefix.replaceAll("&", "§");
        Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("warp")) {
            if (!sender.hasPermission("ep.warp")) {
                sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage(String.valueOf(Warp.plugin.prefix) + (Object)ChatColor.RED + "Use: /warp <Name>");
                return true;
            }
            if (plugin.getwarps().getConfigurationSection("warps." + args[0]) == null) {
                p.sendMessage((Object)ChatColor.RED + "Warp " + args[0] + " does not exist!");
                return true;
            }
            World w = Bukkit.getServer().getWorld(plugin.getwarps().getString("warps." + args[0] + ".world"));
            double x = plugin.getwarps().getDouble("warps." + args[0] + ".x");
            double y = plugin.getwarps().getDouble("warps." + args[0] + ".y");
            double z = plugin.getwarps().getDouble("warps." + args[0] + ".z");
            p.teleport(new Location(w, x, y, z));
            p.sendMessage((Object)ChatColor.GREEN + "Teleported to " + args[0] + "!");
        }
        if (cmd.getName().equalsIgnoreCase("setwarp")) {
            if (!sender.hasPermission("ep.setwarp")) {
                sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage((Object)ChatColor.RED + "Please specify a name!");
                return true;
            }
            plugin.getwarps().set("warps." + args[0] + ".world", (Object)p.getLocation().getWorld().getName());
            plugin.getwarps().set("warps." + args[0] + ".x", (Object)p.getLocation().getX());
            plugin.getwarps().set("warps." + args[0] + ".y", (Object)p.getLocation().getY());
            plugin.getwarps().set("warps." + args[0] + ".z", (Object)p.getLocation().getZ());
            plugin.saveYamls();
            p.sendMessage(String.valueOf(Warp.plugin.prefix) + (Object)ChatColor.GREEN + "Warp " + args[0] + " set!");
        }
        if (cmd.getName().equalsIgnoreCase("delwarp")) {
            if (!sender.hasPermission("ep.deletewarp")) {
                sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            if (args.length == 0) {
                sender.sendMessage((Object)ChatColor.RED + "Please specify a warp name!");
                return true;
            }
            if (plugin.getwarps().getConfigurationSection("warps." + args[0]) == null) {
                sender.sendMessage((Object)ChatColor.RED + "Warp " + args[0] + " does not exist!");
                return true;
            }
            plugin.getwarps().set("warps." + args[0], null);
            plugin.saveYamls();
            sender.sendMessage((Object)ChatColor.GREEN + "Removed warp " + args[0] + "!");
            return true;
        }
        return false;
    }
}

