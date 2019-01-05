package me.thedoffman.essentialspro.commands;

import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {
    private Main plugin = Main.getPlugin(Main.class);

    public Heal(Main plugin) {
        Bukkit.getPluginCommand("heal").setExecutor(this);
    }

    @SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player target;
        plugin.prefix = plugin.prefix.replaceAll("&", "\u00A7");
        if (cmd.getName().equalsIgnoreCase("heal")) {
            if (!sender.hasPermission("ep.heal")) {
                sender.sendMessage(ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            if (args.length == 0 && !(sender instanceof Player)) {
                String eplayer = plugin.getlang().getString("Messages.EPlayer");
                eplayer = eplayer.replaceAll("&", "\u00A7");
                sender.sendMessage(plugin.prefix + eplayer);
                return true;
            }
        }
        if (args.length == 0) {
            target = (Player)sender;
        } else {
            target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null) {
                String nplayer = plugin.getlang().getString("Messages.NPlayer").replaceAll("%player%", args[0]);
                nplayer = nplayer.replaceAll("&", "\u00A7");
                sender.sendMessage(plugin.prefix + nplayer);
                return true;
            }
        }
        target.setHealth(target.getMaxHealth());
        sender.sendMessage(plugin.prefix + ChatColor.GREEN + " You have healed " + target.getName());
        target.sendMessage(plugin.prefix + ChatColor.GREEN + " You have been healed by" + sender.getName());
        return true;
    }
}

