package me.thedoffman.essentialspro.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.thedoffman.essentialspro.main.Main;

public class Invsee implements CommandExecutor {
	
	private Inventory inv;
	
	private Main plugin = Main.getPlugin(Main.class);
	
    public Invsee(Main plugin) {
    	
        Bukkit.getPluginCommand("invsee").setExecutor(this);
    }
        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(plugin.prefix + ChatColor.RED + "Error: Only players can see inventories!");
                return true;
        }
            if(cmd.getName().equalsIgnoreCase("invsee")){
                Player p = (Player) sender;
                if(args.length == 0){
                   
                    p.sendMessage(plugin.prefix + ChatColor.RED + "Invalid Syntax! Usage: /invsee <player...>");
                   
                    return false;
                }
            if(args.length == 1){
                @SuppressWarnings("deprecation")
				Player target = (Bukkit.getServer().getPlayer(args[0]));
                if(target == null){
                   
                    p.sendMessage(plugin.prefix + ChatColor.RED + "That player is not online");
                   
                    return false;
                }else
           
                    inv = target.getInventory();
                   
                p.openInventory(inv);
           

                    return true;
               
                }
            }
            return false;
        }
}
