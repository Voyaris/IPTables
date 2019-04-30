package de.Flubbii.Plugin.Utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.Flubbii.Plugin.Main.Main;

public class Config {
	public static File File = new File(Main.getInstance().getDataFolder(), "Messages.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(File);

	public static void save() {
		try {
			cfg.save(File);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
