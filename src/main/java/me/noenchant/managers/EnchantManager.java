package me.noenchant.managers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class EnchantManager {

    private final JavaPlugin plugin;
    private final Map<Enchantment, Boolean> enchantStatus = new HashMap<>();

    public EnchantManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Loads enchantment settings from config.
     * If not present, defaults to true (enabled).
     */
    public void loadEnchants() {
        FileConfiguration config = plugin.getConfig();

        for (Enchantment enchant : Enchantment.values()) {
            String path = "enchants." + enchant.getKey().getKey();
            boolean enabled = config.getBoolean(path, true); // default true
            enchantStatus.put(enchant, enabled);
            config.set(path, enabled); // ensure it's written to file
        }

        plugin.saveConfig();
    }

    /**
     * Saves enchantment settings back to config.yml
     */
    public void saveEnchants() {
        FileConfiguration config = plugin.getConfig();

        for (Map.Entry<Enchantment, Boolean> entry : enchantStatus.entrySet()) {
            String path = "enchants." + entry.getKey().getKey();
            config.set(path, entry.getValue());
        }

        plugin.saveConfig();
    }

    /**
     * Check if an enchant is enabled.
     */
    public boolean isEnabled(Enchantment enchant) {
        return enchantStatus.getOrDefault(enchant, true);
    }

    /**
     * Enable/disable a specific enchant.
     */
    public void setEnabled(Enchantment enchant, boolean enabled) {
        enchantStatus.put(enchant, enabled);
        saveEnchants();
    }

    /**
     * Get all enchantment settings.
     */
    public Map<Enchantment, Boolean> getAllEnchants() {
        return new HashMap<>(enchantStatus);
    }
}
