package me.noenchant.listeners;

import me.noenchant.NoEnchant;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandBlockerListener implements Listener {

    private final NoEnchant plugin;

    public CommandBlockerListener(NoEnchant plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        String msg = event.getMessage().toLowerCase();

        // Prevent using commands to bypass /noenchant restrictions
        // Example: you can add command block or plugin names here
        if (msg.contains("/somebypasscommand")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage("This command is blocked by NoEnchant!");
        }
    }
}
