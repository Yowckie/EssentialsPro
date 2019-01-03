package me.thedoffman.essentialspro.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thedoffman.essentialspro.main.Main;

public class ClearInventory implements CommandExecutor {
	
	private Main plugin = Main.getPlugin(Main.class);
	
    public ClearInventory(Main plugin) {
        Bukkit.getPluginCommand("ci").setExecutor(this);
    }
    
<<<<<<< HEAD
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.prefix + ChatColor.RED + "Error: Only players can see inventories!");
            return true;
    }
        if(cmd.getName().equalsIgnoreCase("ci")){
        	if (!sender.hasPermission("ep.clearinventory")) {
        		sender.sendMessage(ChatColor.RED + "You do not have permission to use that command!");
        		return true;
        	}
            Player p = (Player) sender;
            if(args.length == 0){
               
                p.sendMessage(plugin.prefix + ChatColor.RED + "Invalid Syntax! Usage: /ci <player...>");
               
                return false;
            }
        if(args.length == 1){
            @SuppressWarnings("deprecation")
			Player target = (Bukkit.getServer().getPlayer(args[0]));
            if(target == null){
               
                p.sendMessage(plugin.prefix + ChatColor.RED + "That player is not online");
               
                return false;
            }else
       
                target.getInventory().clear();
       

                return true;
           
            }
        }
        return false;
    }
=======
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		plugin.prefix = plugin.prefix.replaceAll("&", "\u00A7");
			
		Player target;
		
		if ( cmd.getName().equalsIgnoreCase("ci")){
			if (args.length == 0 && !(sender instanceof Player)){
            	String eplayer = plugin.getlang().getString(plugin.prefix + "Messages.EPlayer");
            	eplayer = eplayer.replaceAll("&", "§");
                sender.sendMessage(eplayer);
				return true;
			}
		}
				if (args.length == 0){
					target = (Player) sender;
		}
			
				else {
					target = Bukkit.getServer().getPlayer(args[0]);
					
					if(target == null){
                    	String nplayer = plugin.getlang().getString(plugin.prefix + "Messages.NPlayer").replaceAll("%player%", args[0]);
                    	nplayer = nplayer.replaceAll("&", "§");
                            sender.sendMessage(nplayer);
						return true;
					}
				}
				
				target.getInventory().clear();
				
		        String CIS = plugin.getlang().getString("Messages.CIS").replaceAll("%targetplayer%", target.getName().toLowerCase());
		        CIS = CIS.replaceAll("&", "\u00A7");
		        
		        String CIT = plugin.getlang().getString("Messages.CIT").replaceAll("%senderplayer%", sender.getName().toLowerCase());
		        CIT = CIT.replaceAll("&", "\u00A7");
		        
				sender.sendMessage(plugin.prefix + CIS);
				target.sendMessage(plugin.prefix + CIT);
		return true;
	}
>>>>>>> parent of 0de8517... Permission Fix
}