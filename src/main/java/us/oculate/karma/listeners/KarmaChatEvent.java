package us.oculate.karma.listeners;

import me.johnzeh.plugins.pr.PlayerRating;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import us.oculate.karma.KarmaPlugin;

public class KarmaChatEvent implements Listener {

    @EventHandler
    public void onNegativeChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage().toLowerCase();
        for (String word : KarmaPlugin.getInstance().getConfig().getStringList("chat.negative")) {
            if (message.contains(word)) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(ChatColor.RED + "You have said a blacklisted word! -1 Karma");
                PlayerRating.setRating(event.getPlayer(), PlayerRating.getRating(event.getPlayer()) - 1);
            }
        }
    }

    @EventHandler
    public void onPositiveChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage().toLowerCase();
        for (String word : KarmaPlugin.getInstance().getConfig().getStringList("chat.positive")) {
            if (message.contains(word)) {
                event.getPlayer().sendMessage(ChatColor.GREEN + "You have said a positive word! +1 Karma");
                PlayerRating.setRating(event.getPlayer(), PlayerRating.getRating(event.getPlayer()) + 1);
            }
        }
    }
}
