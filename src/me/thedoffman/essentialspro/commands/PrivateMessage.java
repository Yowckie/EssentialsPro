package me.thedoffman.essentialspro.commands;

import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PrivateMessage
implements CommandExecutor {
    private static Main plugin = (Main)Main.getPlugin(Main.class);

    public PrivateMessage(Main plugin) {
        Bukkit.getPluginCommand((String)"pm").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        PrivateMessage.plugin.prefix = PrivateMessage.plugin.prefix.replaceAll("&", "§");
        if (cmd.getName().equalsIgnoreCase("pm")) {
            if (!sender.hasPermission("ep.pm")) {
                sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            if (sender instanceof Player) {
                Player p = (Player)sender;
                if (args.length == 0) {
                    p.sendMessage(String.valueOf(PrivateMessage.plugin.prefix) + (Object)ChatColor.RED + "Syntax: /pm <To> <Message>");
                } else {
                    @SuppressWarnings("deprecation")
					Player target = Bukkit.getPlayer((String)args[0]);
                    if (target != null) {
                        String message = "";
                        int i = 1;
                        while (i != args.length) {
                            message = String.valueOf(message) + args[1] + " ";
                            ++i;
                        }
                        target.sendMessage(String.valueOf(PrivateMessage.plugin.prefix) + (Object)ChatColor.BLUE + sender.getName() + (Object)ChatColor.WHITE + " > " + (Object)ChatColor.BLUE + "YOU " + (Object)ChatColor.WHITE + ": " + (Object)ChatColor.GREEN + message);
                    } else {
                        sender.sendMessage(String.valueOf(PrivateMessage.plugin.prefix) + (Object)ChatColor.RED + "ERROR: This player is not connected on the server!");
                    }
                }
            } else {
                sender.sendMessage(String.valueOf(PrivateMessage.plugin.prefix) + "You're not a player");
            }
        }
        return true;
    }
}

