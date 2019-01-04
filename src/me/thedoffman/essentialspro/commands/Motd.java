package me.thedoffman.essentialspro.commands;

import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.Plugin;

public class Motd
implements CommandExecutor,
Listener {
    private Main plugin = (Main)Main.getPlugin(Main.class);

    public Motd(Main plugin) {
        Bukkit.getPluginCommand((String)"motd").setExecutor((CommandExecutor)this);
        Bukkit.getPluginCommand((String)"setmotd").setExecutor((CommandExecutor)this);
        Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)plugin);
    }

    @EventHandler
    public void onServerPing(ServerListPingEvent e) {
        String motd = this.plugin.getlang().getString("Messages.MOTD");
        motd = motd.replaceAll("&", "§");
        e.setMotd(motd);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        this.plugin.prefix = this.plugin.prefix.replaceAll("&", "\u00a7");
        String motdA = this.plugin.getlang().getString("Messages.Access");
        motdA = motdA.replaceAll("&", "§");
        if (cmd.getName().equalsIgnoreCase("motd")) {
            if (!sender.hasPermission("ep.motd")) {
                sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            if (!sender.hasPermission("ep.motd")) {
                sender.sendMessage(String.valueOf(this.plugin.prefix) + motdA);
                return true;
            }
            String system = this.plugin.getlang().getString("Messages.MOTD");
            system = system.replaceAll("&", "§");
            sender.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.GREEN + "MOTD: " + system);
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("setmotd")) {
            if (!sender.hasPermission("ep.setmotd")) {
                sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            if (!sender.hasPermission("ep.setmotd")) {
                if (!sender.hasPermission("ep.setmotd")) {
                    sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
                    return true;
                }
                sender.sendMessage(String.valueOf(this.plugin.prefix) + motdA + (Object)ChatColor.GREEN + "- Has been set.");
                return true;
            }
            if (args.length == 0) {
                sender.sendMessage((Object)ChatColor.DARK_RED + "Error: Please type a new MOTD!");
                return true;
            }
            StringBuilder str = new StringBuilder();
            int i = 0;
            while (i < args.length) {
                str.append(String.valueOf(args[i]) + " ");
                ++i;
            }
            String motd = str.toString();
            this.plugin.getlang().set("Messages.MOTD", (Object)motd);
            String system = this.plugin.getlang().getString("Messages.MOTD");
            system = system.replaceAll("&", "\u00a7");
            sender.sendMessage(String.valueOf(this.plugin.prefix) + (Object)ChatColor.GREEN + "MOTD: " + system);
            this.plugin.saveYamls();
            return true;
        }
        return false;
    }
}

