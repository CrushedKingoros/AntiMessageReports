package me.bearfrommars.AntiMsgReports;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.java.JavaPlugin;

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
    
    public static Main getPlugin() {
        return instance;
    }
}
