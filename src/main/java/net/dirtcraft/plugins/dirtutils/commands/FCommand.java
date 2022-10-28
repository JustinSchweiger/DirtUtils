package net.dirtcraft.plugins.dirtutils.commands;

import net.dirtcraft.plugins.dirtutils.utils.Strings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Strings.NO_CONSOLE);
			return false;
		}

		for (Player player : Bukkit.getOnlinePlayers()) {
			player.sendMessage(ChatColor.GOLD + sender.getName() + ChatColor.GRAY + " pays their respect.");
			player.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "Another day, another dirt death");
		}
		return true;
	}
}
