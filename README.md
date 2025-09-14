📖 NoEnchant

NoEnchant is a lightweight and flexible Minecraft plugin that lets server owners disable specific enchantments completely. Whether it’s Mending, Curse of Vanishing, or any other enchant, you have full control over your server’s enchantment balance.

✨ Features

🚫 Block any enchantment from being used.

🛡 Works across all sources:

Enchanting table

Anvils

Loot chests

Mob drops

Item pickups

⚡ Lightweight & efficient – no performance impact.

📝 Easy-to-edit config with reload support.

🔑 Simple commands & permissions for admins.

📥 Installation

Download the latest NoEnchant.jar.

Drop it into your server’s /plugins folder.

Restart the server.

Open the generated config.yml and list the enchantments you want to disable.

⚙️ Configuration

config.yml

# List of enchantments you want to disable
disabled-enchants:
  - MENDING
  - VANISHING_CURSE
  - FROST_WALKER


👉 Use the official Spigot/Bukkit enchantment names (always uppercase).
📜 Full list: Spigot Enchantment API Docs

⌨️ Commands
Command	Description	Permission
/noenchant reload	Reloads the configuration	noenchant.reload
🔐 Permissions

noenchant.reload → Allows using /noenchant reload

📌 Example Use Cases

Disable Mending to encourage trading & repairing instead of infinite tools.

Remove Curses for a cleaner survival experience.

Block Frost Walker to protect server performance.

Customize enchantment availability for custom gamemodes.

📜 Plugin.yml Description (for Spigot page)

NoEnchant is a simple but powerful plugin that gives you control over enchantments on your server. Disable any enchantment from being applied or obtained through enchanting tables, anvils, loot, or mob drops. Perfect for server owners who want to balance gameplay, remove overpowered enchants, or customize their survival experience.
