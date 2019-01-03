package me.thedoffman.essentialspro.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thedoffman.essentialspro.main.Main;

public class Teleport implements CommandExecutor {
	
	private Main plugin = Main.getPlugin(Main.class);
	
    public Teleport(Main plugin) {
        Bukkit.getPluginCommand("teleport").setExecutor(this);
    }

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		plugin.prefix = plugin.prefix.replaceAll("&", "\u00A7");
		
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.prefix + ChatColor.RED + "Error: Only players can teleport!");
            return true;
    }
       
        Player p = (Player) sender;
       
        if (cmd.getName().equalsIgnoreCase("teleport")) {
            if (sender instanceof Player) {
                if (args.length == 0) {
                        p.sendMessage(plugin.prefix + ChatColor.RED + "Please specify a player.");
                        return true;
                }
				@SuppressWarnings("deprecation")
				Player target = Bukkit.getServer().getPlayer(args[0]);
                if (target == null) {
                        p.sendMessage(plugin.prefix + ChatColor.RED + "Could not find player " + args[0] + "!");
                        return true;
                }
                p.teleport(target.getLocation());
                return true;
        } else sender.sendMessage(plugin.prefix + ChatColor.RED + "Error: Command use only in game.");
            return true;
        }
		return true;
	}
}
