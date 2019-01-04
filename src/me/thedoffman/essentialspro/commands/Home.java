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

public class Home
implements CommandExecutor {
    private static Main plugin = (Main)Main.getPlugin(Main.class);

    public Home(Main plugin) {
        Bukkit.getPluginCommand((String)"home").setExecutor((CommandExecutor)this);
        Bukkit.getPluginCommand((String)"sethome").setExecutor((CommandExecutor)this);
        Bukkit.getPluginCommand((String)"delhome").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Home.plugin.prefix = Home.plugin.prefix.replaceAll("&", "§");
        Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("home")) {
            if (!sender.hasPermission("ep.home")) {
                sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            if (!(sender instanceof Player)) {
                sender.sendMessage(String.valueOf(Home.plugin.prefix) + (Object)ChatColor.RED + "Error: Only players can go home!");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage(String.valueOf(Home.plugin.prefix) + (Object)ChatColor.RED + "Use: /home <Name>");
                return true;
            }
            if (plugin.getplayers().getConfigurationSection(String.valueOf(p.getName()) + ".homes." + args[0]) == null) {
                p.sendMessage(String.valueOf(Home.plugin.prefix) + (Object)ChatColor.RED + "Home " + args[0] + " does not exist!");
                return true;
            }
            World w = Bukkit.getServer().getWorld(plugin.getplayers().getString(String.valueOf(p.getName()) + ".homes." + args[0] + ".world"));
            double x = plugin.getplayers().getDouble(String.valueOf(p.getName()) + ".homes." + args[0] + ".x");
            double y = plugin.getplayers().getDouble(String.valueOf(p.getName()) + ".homes." + args[0] + ".y");
            double z = plugin.getplayers().getDouble(String.valueOf(p.getName()) + ".homes." + args[0] + ".z");
            p.teleport(new Location(w, x, y, z));
            p.sendMessage(String.valueOf(Home.plugin.prefix) + (Object)ChatColor.BLUE + "Welcome to " + (Object)ChatColor.GREEN + args[0] + (Object)ChatColor.BLUE + "!");
        }
        if (cmd.getName().equalsIgnoreCase("sethome")) {
            if (!sender.hasPermission("ep.sethome")) {
                sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            if (!(sender instanceof Player)) {
                sender.sendMessage(String.valueOf(Home.plugin.prefix) + (Object)ChatColor.RED + "Error: Only players can set a home!");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage(String.valueOf(Home.plugin.prefix) + (Object)ChatColor.RED + "Use: /sethome <Name>");
                return true;
            }
            plugin.getplayers().set(String.valueOf(p.getName()) + ".homes." + args[0] + ".world", (Object)p.getLocation().getWorld().getName());
            plugin.getplayers().set(String.valueOf(p.getName()) + ".homes." + args[0] + ".x", (Object)p.getLocation().getX());
            plugin.getplayers().set(String.valueOf(p.getName()) + ".homes." + args[0] + ".y", (Object)p.getLocation().getY());
            plugin.getplayers().set(String.valueOf(p.getName()) + ".homes." + args[0] + ".z", (Object)p.getLocation().getZ());
            plugin.saveYamls();
            p.sendMessage(String.valueOf(Home.plugin.prefix) + (Object)ChatColor.BLUE + "Home " + (Object)ChatColor.GREEN + args[0] + (Object)ChatColor.BLUE + " set!");
        }
        if (cmd.getName().equalsIgnoreCase("delhome")) {
            if (!sender.hasPermission("ep.deletehome")) {
                sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            if (!(sender instanceof Player)) {
                sender.sendMessage(String.valueOf(Home.plugin.prefix) + (Object)ChatColor.RED + "Error: Only players can delete a home!");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage(String.valueOf(Home.plugin.prefix) + (Object)ChatColor.RED + "Use: /delhome <Name>");
                return true;
            }
            if (plugin.getplayers().getConfigurationSection(String.valueOf(p.getName()) + ".homes." + args[0]) == null) {
                sender.sendMessage(String.valueOf(Home.plugin.prefix) + (Object)ChatColor.RED + "Home " + args[0] + " does not exist!");
                return true;
            }
            plugin.getplayers().set(String.valueOf(p.getName()) + ".homes." + args[0], null);
            plugin.saveYamls();
            sender.sendMessage(String.valueOf(Home.plugin.prefix) + (Object)ChatColor.GREEN + "Removed home " + args[0] + "!");
            return true;
        }
        return false;
    }
}

