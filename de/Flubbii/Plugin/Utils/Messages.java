package de.Flubbii.Plugin.Utils;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class Messages {
	public static FileConfiguration cfg = Config.cfg;

	public static void create() {
		if (cfg.getString("Config.Permission.Command") == null) {
			cfg.set("Config.Permission.Command", "IPTables.Use");
		}
		if (cfg.getString("Config.Prefix") == null) {
			cfg.set("Config.Prefix", "&8[&eIPTables&8]&7");
		}
		if (cfg.getString("Config.Syntax") == null) {
			cfg.set("Config.Syntax", "%Prefix% Syntax&8: &c/IPTables &c<&aadd&7/&cremove&8> <&eIP&8>");
		}
		if (cfg.getString("Config.NoPermission") == null) {
			cfg.set("Config.NoPermission", "%Prefix% &cYou don't have the permission to use this command.");
		}
		if (cfg.getString("Config.IP-Invalid") == null) {
			cfg.set("Config.IP-Invalid", "%Prefix% &cThis is not a valid IP!");
		}
		if (cfg.getString("Config.IP-Blocked") == null) {
			cfg.set("Config.IP-Blocked", "%Prefix% &7This IP has been blocked!");
		}
		if (cfg.getString("Config.IP-Released") == null) {
			cfg.set("Config.IP-Released", "%Prefix% &7This IP has been released!");
		}
		Config.save();
	}

	public static String getMessage(String Typ) {
		return ChatColor.translateAlternateColorCodes('&', cfg.getString("Config." + Typ));
	}
}
