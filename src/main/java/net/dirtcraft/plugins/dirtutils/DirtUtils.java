package net.dirtcraft.plugins.dirtutils;

import net.dirtcraft.plugins.dirtutils.utils.Utilities;
import org.bukkit.plugin.java.JavaPlugin;

public final class DirtUtils extends JavaPlugin {
	private static DirtUtils plugin;

	public static DirtUtils getPlugin() {
		return plugin;
	}

	@Override
	public void onEnable() {
		plugin = this;
		Utilities.loadConfig();
		Utilities.registerCommands();
		Utilities.registerListener();
	}

	@Override
	public void onDisable() {

	}
}
