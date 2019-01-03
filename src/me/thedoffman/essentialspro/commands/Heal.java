package me.thedoffman.essentialspro.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thedoffman.essentialspro.main.Main;



public class Heal implements CommandExecutor {

	private Main plugin = Main.getPlugin(Main.class);
	
    public Heal(Main plugin) {
        Bukkit.getPluginCommand("heal").setExecutor(this);
    }
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		plugin.prefix = plugin.prefix.replaceAll("&", "§");
			
		Player target;
		if ( cmd.getName().equalsIgnoreCase("heal")){
			if (args.length == 0 && !(sender instanceof Player)){
				String eplayer = plugin.getlang().getString("Messages.EPlayer");
            	eplayer = eplayer.replaceAll("&", "§");
				sender.sendMessage(plugin.prefix + eplayer);
				return true;
			}
		}
				if (args.length == 0){
					target = (Player) sender;
		}
			
				else {
					target = Bukkit.getServer().getPlayer(args[0]);
					
					if(target == null){
						String nplayer = plugin.getlang().getString("Messages.NPlayer").replaceAll("%player%", args[0]);
                    	nplayer = nplayer.replaceAll("&", "§");
						sender.sendMessage(plugin.prefix + nplayer);
						return true;
					}
				}
				
				target.setHealth(target.getMaxHealth());
				
				String HS = plugin.getlang().getString(plugin.prefix +  "Messages.HealS").replaceAll("%targetplayer%", target.getName().toLowerCase());
		        HS = HS.replaceAll("&", "§");
		        
		        String HT = plugin.getlang().getString(plugin.prefix +  "Messages.HealT").replaceAll("%senderplayer%", sender.getName().toLowerCase());
		        HT = HT.replaceAll("&", "§");
		        
				sender.sendMessage(plugin.prefix +  HS);
				target.sendMessage(plugin.prefix +  HT);
		
		return true;
	}
}