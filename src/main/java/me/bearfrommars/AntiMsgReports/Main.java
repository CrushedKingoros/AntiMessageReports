package me.bearfrommars.AntiMsgReports;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener
{
    private static Main instance;
    @Override
    public void onEnable() {
        getLogger().info("No more player reports :)");
        getServer().getPluginManager().registerEvents(this, this);
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onMsg(PlayerChatEvent event) {
        event.setCancelled(true);
        Bukkit.broadcastMessage("<" + event.getPlayer().getName() + "> " + event.getMessage());
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDM(PlayerCommandPreprocessEvent event) {
        Player eventplayer = event.getPlayer();
        String cmd = event.getMessage();
        String[] splitcmd = cmd.split(" ");
        if(splitcmd[0].equalsIgnoreCase("/msg") || splitcmd[0].equalsIgnoreCase("/w") || splitcmd[0].equalsIgnoreCase("/tell")) {
            event.setCancelled(true);
            Player player=Bukkit.getPlayer(splitcmd[1]);
            if (player == null) {
                return;
            }
            eventplayer.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "You whisper to " + player.getName() + ": " + splitcmd[2]);
            player.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + eventplayer.getName() + " whispers to you: " + splitcmd[2]);
        }
    }
    
    public static Main getPlugin() {
        return instance;
    }
}
