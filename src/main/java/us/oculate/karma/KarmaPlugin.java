package us.oculate.karma;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import us.oculate.karma.listeners.KarmaChatEvent;

public class KarmaPlugin extends JavaPlugin implements Listener {

    private static KarmaPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        this.getServer().getPluginManager().registerEvents(new KarmaChatEvent(), this);
    }

    public static KarmaPlugin getInstance() {
        return instance;
    }
}
