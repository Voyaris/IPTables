package de.Flubbii.Plugin.Main;

import org.bukkit.plugin.java.JavaPlugin;

import de.Flubbii.Plugin.Command.IPTables;
import de.Flubbii.Plugin.Utils.Config;
import de.Flubbii.Plugin.Utils.Messages;

public class Main extends JavaPlugin {
	private static Main Instance;

	@Override
	public void onEnable() {
		super.onEnable();
		Instance = this;
		if (!getDataFolder().exists()) {
			getDataFolder().mkdir();
		}
		Config.save();
		Messages.create();
		getCommand("iptables").setExecutor(new IPTables());
	}

	public static Main getInstance() {
		return Instance;
	}
}
