package me.thedoffman.essentialspro.commands;

import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    private Main plugin = Main.getPlugin(Main.class);

    public Fly(Main plugin) {
        Bukkit.getPluginCommand("fly").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        plugin.prefix = plugin.prefix.replaceAll("&", "\u00A7");
        if (cmd.getName().equalsIgnoreCase("fly")) {
            if (sender.hasPermission("ep.fly")) {
                sender.sendMessage(ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }  
            Player player = (Player) sender;
            if (player.getAllowFlight()) {
                player.setAllowFlight(true);
                player.sendMessage(plugin.prefix + ChatColor.DARK_BLUE + "Flying " + ChatColor.GREEN + "Enabled" + ChatColor.DARK_BLUE + "!");
                return true;
            } 
            player.setAllowFlight(false);
            player.sendMessage(plugin.prefix + ChatColor.DARK_BLUE + "Flying " + ChatColor.RED + "Disabled" + ChatColor.DARK_BLUE + "!");
            return true;
        } 
        
        return true;
    } 
}

