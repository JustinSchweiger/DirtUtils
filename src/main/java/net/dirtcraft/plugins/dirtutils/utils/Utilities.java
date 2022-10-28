package net.dirtcraft.plugins.dirtutils.utils;

import com.moandjiezana.toml.Toml;
import net.dirtcraft.plugins.dirtutils.DirtUtils;
import net.dirtcraft.plugins.dirtutils.commands.FCommand;
import net.dirtcraft.plugins.dirtutils.commands.PrintAllItemsCommand;
import net.dirtcraft.plugins.dirtutils.config.Config;
import org.bukkit.ChatColor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;

public class Utilities {
	public static Config config;

	public static void loadConfig() {
		if (!DirtUtils.getPlugin().getDataFolder().exists()) {
			DirtUtils.getPlugin().getDataFolder().mkdirs();
		}
		File file = new File(DirtUtils.getPlugin().getDataFolder(), "config.toml");
		if (!file.exists()) {
			try {
				Files.copy(DirtUtils.getPlugin().getResource("config.toml"), file.toPath());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		config = new Toml(new Toml().read(DirtUtils.getPlugin().getResource("config.toml"))).read(file).to(Config.class);
	}

	public static void registerListener() {

	}

	public static void registerCommands() {
		DirtUtils.getPlugin().getCommand("printallitems").setExecutor(new PrintAllItemsCommand());
		DirtUtils.getPlugin().getCommand("f").setExecutor(new FCommand());
	}

	public static void log(Level level, String msg) {
		String consoleMessage;
		if (Level.INFO.equals(level)) {
			consoleMessage = Strings.INTERNAL_PREFIX + ChatColor.WHITE + msg;
		} else if (Level.WARNING.equals(level)) {
			consoleMessage = Strings.INTERNAL_PREFIX + ChatColor.YELLOW + msg;
		} else if (Level.SEVERE.equals(level)) {
			consoleMessage = Strings.INTERNAL_PREFIX + ChatColor.RED + msg;
		} else {
			consoleMessage = Strings.INTERNAL_PREFIX + ChatColor.GRAY + msg;
		}

		if (!config.general.coloredDebug) {
			consoleMessage = ChatColor.stripColor(msg);
		}

		DirtUtils.getPlugin().getServer().getConsoleSender().sendMessage(consoleMessage);
	}

	public static void disablePlugin() {
		DirtUtils.getPlugin().getServer().getPluginManager().disablePlugin(DirtUtils.getPlugin());
	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException | NullPointerException e) {
			return false;
		}

		return true;
	}

	public static String format(String message) {
		return net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', message);
	}
}
