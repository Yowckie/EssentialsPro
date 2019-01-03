package me.thedoffman.essentialspro.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.thedoffman.essentialspro.main.Main;

public class Vanish implements CommandExecutor, Listener {
	
	private Main plugin = Main.getPlugin(Main.class);
	
    public Vanish(Main plugin) {
    	
        Bukkit.getPluginCommand("vanish").setExecutor(this);
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

	 private ArrayList<Player> vanished = new ArrayList<>();
	 
     @SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
 		plugin.prefix = plugin.prefix.replaceAll("&", "\u00A7");
            
             if (!(sender instanceof Player)) {
                     sender.sendMessage(plugin.prefix + ChatColor.RED + "You cannot vanish!");
                     return true;
             }
            
             Player p = (Player) sender;
            
             if (cmd.getName().equalsIgnoreCase("vanish")) {
                     // Check perms
                    
                     if (!vanished.contains(p)) {
                             for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
                                     pl.hidePlayer(p);
                             }
                             vanished.add(p);
                             p.sendMessage(plugin.prefix + ChatColor.GREEN + "POOF! You have been vanished!");
                             return true;
                     }
                     else {
                             for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
                                     pl.showPlayer(p);
                             }
                             vanished.remove(p);
                             p.sendMessage(plugin.prefix + ChatColor.GREEN + "POOF! You have been unvanished!");
                             return true;
                     }
             }
             return true;
     }
     

	@SuppressWarnings("deprecation")
	@EventHandler
     public void onPlayerJoin(PlayerJoinEvent e) {
             for (Player p : vanished) {
                     e.getPlayer().hidePlayer(p);
             }
     }
    
     @EventHandler
     public void onPlayerLeave(PlayerQuitEvent e) {
             vanished.remove(e.getPlayer());
     }
}
