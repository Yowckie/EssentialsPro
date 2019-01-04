package me.thedoffman.essentialspro.commands;

import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal
implements CommandExecutor {
    private Main plugin = (Main)Main.getPlugin(Main.class);

    public Heal(Main plugin) {
        Bukkit.getPluginCommand((String)"heal").setExecutor((CommandExecutor)this);
    }

    @SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player target;
        this.plugin.prefix = this.plugin.prefix.replaceAll("&", "§");
        if (cmd.getName().equalsIgnoreCase("heal")) {
            if (!sender.hasPermission("ep.heal")) {
                sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            if (args.length == 0 && !(sender instanceof Player)) {
                String eplayer = this.plugin.getlang().getString("Messages.EPlayer");
                eplayer = eplayer.replaceAll("&", "§");
                sender.sendMessage(String.valueOf(this.plugin.prefix) + eplayer);
                return true;
            }
        }
        if (args.length == 0) {
            target = (Player)sender;
        } else {
            target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null) {
                String nplayer = this.plugin.getlang().getString("Messages.NPlayer").replaceAll("%player%", args[0]);
                nplayer = nplayer.replaceAll("&", "§");
                sender.sendMessage(String.valueOf(this.plugin.prefix) + nplayer);
                return true;
            }
        }
        target.setHealth(target.getMaxHealth());
        sender.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.GREEN + " You have healed " + target.getName());
        target.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.GREEN + " You have been healed by" + sender.getName());
        return true;
    }
}

