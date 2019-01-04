package me.thedoffman.essentialspro.commands;

import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn
implements CommandExecutor {
    private Main plugin = (Main)Main.getPlugin(Main.class);

    public Spawn(Main plugin) {
        Bukkit.getPluginCommand((String)"spawn").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        this.plugin.prefix = this.plugin.prefix.replaceAll("&", "§");
        if (cmd.getName().equalsIgnoreCase("spawn")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.RED + "Error: Only players can go home!");
                return true;
            }
            if (sender instanceof Player) {
                Player p = (Player)sender;
                if (p.getWorld().getSpawnLocation() == null) {
                    String NS = this.plugin.getlang().getString("Messages.NoSpawn");
                    NS = NS.replaceAll("&", "§");
                    p.sendMessage(String.valueOf(this.plugin.prefix) + NS);
                    return false;
                }
                String WS = this.plugin.getlang().getString("Messages.WelcomeSpawn");
                WS = WS.replaceAll("&", "§");
                p.teleport(p.getWorld().getSpawnLocation());
                p.sendMessage(String.valueOf(this.plugin.prefix) + WS);
            }
        }
        return false;
    }
}

