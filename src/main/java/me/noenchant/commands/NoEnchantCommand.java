package me.noenchant.commands;

import me.noenchant.NoEnchant;
import me.noenchant.managers.EnchantManager;
import me.noenchant.utils.EnchantUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class NoEnchantCommand implements CommandExecutor {

    private final NoEnchant plugin;

    public NoEnchantCommand(NoEnchant plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player) || !sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "You must be an OP to use this command.");
            return true;
        }

        if (args.length != 2) {
            sender.sendMessage(ChatColor.YELLOW + "Usage: /noenchant <enchant> <on/off>");
            return true;
        }

        String enchantName = args[0].toUpperCase();
        String action = args[1].toLowerCase();

        Enchantment enchant = EnchantUtils.getEnchantment(enchantName);
        if (enchant == null) {
            sender.sendMessage(ChatColor.RED + "Invalid enchantment: " + enchantName);
            return true;
        }

        EnchantManager manager = plugin.getEnchantManager();
        if (action.equals("on")) {
            if (manager.isEnabled(enchant)) {
                sender.sendMessage(ChatColor.YELLOW + enchant.getKey().getKey() + " is already enabled.");
            } else {
                manager.setEnabled(enchant, true);
                sender.sendMessage(ChatColor.GREEN + enchant.getKey().getKey() + " has been enabled!");
            }
        } else if (action.equals("off")) {
            if (!manager.isEnabled(enchant)) {
                sender.sendMessage(ChatColor.YELLOW + enchant.getKey().getKey() + " is already disabled.");
            } else {
                manager.setEnabled(enchant, false);
                sender.sendMessage(ChatColor.RED + enchant.getKey().getKey() + " has been disabled!");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Invalid action: " + action + ". Use on/off.");
        }

        return true;
    }
}
