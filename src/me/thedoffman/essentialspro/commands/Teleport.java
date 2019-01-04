package me.thedoffman.essentialspro.commands;

import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleport
implements CommandExecutor {
    private Main plugin = (Main)Main.getPlugin(Main.class);

    public Teleport(Main plugin) {
        Bukkit.getPluginCommand((String)"teleport").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        this.plugin.prefix = this.plugin.prefix.replaceAll("&", "§");
        if (!(sender instanceof Player)) {
            sender.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "Error: Only players can teleport!");
            return true;
        }
        Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("teleport")) {
            if (!sender.hasPermission("ep.teleport")) {
                sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            if (sender instanceof Player) {
                if (args.length == 0) {
                    p.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "Please specify a player.");
                    return true;
                }
                @SuppressWarnings("deprecation")
				Player target = Bukkit.getServer().getPlayer(args[0]);
                if (target == null) {
                    p.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "Could not find player " + args[0] + "!");
                    return true;
                }
                p.teleport(target.getLocation());
                return true;
            }
            sender.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "Error: Command use only in game.");
            return true;
        }
        return true;
    }
}

