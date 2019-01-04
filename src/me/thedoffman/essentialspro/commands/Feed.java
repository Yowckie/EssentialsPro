package me.thedoffman.essentialspro.commands;

import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed
implements CommandExecutor {
    private Main plugin = (Main)Main.getPlugin(Main.class);

    public Feed(Main plugin) {
        Bukkit.getPluginCommand((String)"feed").setExecutor((CommandExecutor)this);
    }

    @SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player target;
        Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("feed")) {
            if (!sender.hasPermission("ep.feed")) {
                sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            p.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "Use: /feed <Name>");
            if (args.length == 0 && !(sender instanceof Player)) {
                return true;
            }
        }
        if (args.length == 0) {
            target = (Player)sender;
        } else {
            target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null) {
                p.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "Error: Could not find player " + args[0] + "!");
                return true;
            }
        }
        target.setFoodLevel(20);
        p.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.GREEN + "You have been healed!");
        target.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.GREEN + "You have been healed by " + p.getName() + "!");
        return true;
    }
}

