package me.thedoffman.essentialspro.commands;

import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpList
implements CommandExecutor {
    private Main plugin = (Main)Main.getPlugin(Main.class);

    public WarpList(Main plugin) {
        Bukkit.getPluginCommand((String)"warplist").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        this.plugin.prefix = this.plugin.prefix.replaceAll("&", "§");
        if (cmd.getName().equalsIgnoreCase("warplist")) {
            if (!sender.hasPermission("ep.warplist")) {
                sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            String CE = this.plugin.getlang().getString("Messages.ConsoleE");
            CE = CE.replaceAll("&", "§");
            if (sender instanceof Player) {
                Player p = (Player)sender;
                String warps = "";
                for (String s : this.plugin.getwarps().getConfigurationSection("warps").getKeys(false)) {
                    warps = String.valueOf(warps) + "\n" + s;
                }
                p.sendMessage((Object)ChatColor.DARK_BLUE + "---- Here is the list of current warps---- " + (Object)ChatColor.DARK_GREEN + warps);
            } else {
                sender.sendMessage(String.valueOf(this.plugin.prefix) + CE);
            }
            return true;
        }
        return false;
    }
}

