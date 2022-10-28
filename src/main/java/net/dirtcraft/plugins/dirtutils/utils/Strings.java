package net.dirtcraft.plugins.dirtutils.utils;

import org.bukkit.ChatColor;

public class Strings {
	// ---------------------------------------------------------- GENERAL ----------------------------------------------------------
	public static final String PREFIX = ChatColor.GRAY + "[" + ChatColor.RED + "Dirt" + ChatColor.BLUE + "Utils" + ChatColor.GRAY + "] ";
	public static final String INTERNAL_PREFIX = ChatColor.GRAY + "[" + ChatColor.RED + "Dirt" + ChatColor.BLUE + "Utils" + ChatColor.GRAY + "] ";
	public static final String NO_PERMISSION = PREFIX + ChatColor.RED + "You do not have permission to use this command.";
	public static final String NO_CONSOLE = PREFIX + ChatColor.RED + "You must be a player to use this command.";
	public static final String INVALID_ARGUMENTS_USAGE = PREFIX + ChatColor.DARK_RED + "Invalid arguments.\n" + ChatColor.GOLD + "Usage" + ChatColor.GRAY + ": " + ChatColor.RED;
	public static final String RELOAD_DONE = PREFIX + ChatColor.GREEN + "Config reloaded.";
	public static final String UNKNOWN_COMMAND = PREFIX + ChatColor.RED + "Unknown command. Type " + ChatColor.DARK_RED + "/dirtrestrict" + ChatColor.RED + " for a list of available commands.";

	// ---------------------------------------------------- PRINTALLITEMS COMMAND ----------------------------------------------------
	public static final String START_PRINT = PREFIX + ChatColor.RED + "Getting all items... This might take a few seconds!";
	public static final String END_PRINT = PREFIX + ChatColor.RED + "Saving items to file ...";
	public static final String SAVE_DONE = PREFIX + ChatColor.GREEN + "Items saved to file.";
}
