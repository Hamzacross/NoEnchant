package me.noenchant.listeners;

import me.noenchant.NoEnchant;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.enchantments.Enchantment;

import java.util.Map;

public class PickupListener implements Listener {

    private final NoEnchant plugin;

    public PickupListener(NoEnchant plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPickup(PlayerPickupItemEvent event) {
        ItemStack item = event.getItem().getItemStack();
        if (item == null) return;

        Map<Enchantment, Integer> enchants = item.getEnchantments();
        boolean removed = false;
        for (Enchantment enchant : enchants.keySet()) {
            if (!plugin.getEnchantManager().isEnabled(enchant)) {
                item.removeEnchantment(enchant);
                removed = true;
            }
        }

        if (removed) {
            event.getPlayer().sendMessage("Some disabled enchants were removed from this item!");
        }
    }
}
