package me.thedoffman.essentialspro.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import me.thedoffman.essentialspro.main.Main;

public class Motd implements CommandExecutor, Listener {
	
	private Main plugin = Main.getPlugin(Main.class);
	
    public Motd(Main plugin) {
        Bukkit.getPluginCommand("motd").setExecutor(this);
        Bukkit.getPluginCommand("setmotd").setExecutor(this);
        
        Bukkit.getPluginManager().registerEvents(this, plugin);
        
    }
	
    @EventHandler
    public void onServerPing(ServerListPingEvent e) {
        String motd = plugin.getlang().getString("Messages.MOTD");
        motd = motd.replaceAll("&", "§");
            e.setMotd(motd);
    }

    
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		plugin.prefix = plugin.prefix.replaceAll("&", "\u00A7");
    	
        String motdA = plugin.getlang().getString("Messages.Access");
        motdA = motdA.replaceAll("&", "§");
        if (cmd.getName().equalsIgnoreCase("motd")) {
                if (!sender.hasPermission("ep.motd")) {
                        sender.sendMessage(plugin.prefix + motdA);
                        return true;
} 
                String system = plugin.getlang().getString("Messages.MOTD");
                system = system.replaceAll("&", "§");
                sender.sendMessage(plugin.prefix + ChatColor.GREEN + "MOTD: " + system);
                return true;
        }
        if (cmd.getName().equalsIgnoreCase("setmotd")) {
            if (!sender.hasPermission("ep.motdset")) {
                    sender.sendMessage(plugin.prefix + motdA);
                    return true;
            }
            if (args.length == 0) {
                    sender.sendMessage(ChatColor.DARK_RED + "Error: Please type a new MOTD!");
                    return true;
            }
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                    str.append(args[i] + " ");
            }
            String motd = str.toString();
            plugin.getlang().set("Messages.MOTD", motd);
            String system = plugin.getlang().getString("Messages.MOTD");
            system = system.replaceAll("&", "§");
            sender.sendMessage(plugin.prefix + ChatColor.GREEN + "MOTD: " + system);
            plugin.saveYamls();
            return true;
    }
		return false;
    }
}