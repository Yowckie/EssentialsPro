package me.thedoffman.essentialspro.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.thedoffman.essentialspro.main.Main;

public class PlayerCommandProcess implements Listener {
	
    public PlayerCommandProcess(Main plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    
 @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent e) {
            if (e.getPlayer().isOp()) {
                    return;
            }
           
            if (e.getMessage().startsWith("/?") || e.getMessage().startsWith("/pl") || e.getMessage().startsWith("/plugins") || e.getMessage().startsWith("/me") || e.getMessage().startsWith("/help")) {
                e.setCancelled(true);
                    e.getPlayer().sendMessage(ChatColor.RED + "Error: You may not run this command.");
            }
    }
 }

