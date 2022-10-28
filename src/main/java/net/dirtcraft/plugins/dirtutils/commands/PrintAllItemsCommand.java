package net.dirtcraft.plugins.dirtutils.commands;

import net.dirtcraft.plugins.dirtutils.DirtUtils;
import net.dirtcraft.plugins.dirtutils.utils.Permissions;
import net.dirtcraft.plugins.dirtutils.utils.Strings;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrintAllItemsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!sender.hasPermission(Permissions.PRINTALLITEMS)) {
			sender.sendMessage(Strings.NO_PERMISSION);
			return true;
		}

		sender.sendMessage(Strings.START_PRINT);

		Bukkit.getScheduler().runTaskAsynchronously(DirtUtils.getPlugin(), () -> {
			final List<String> items = new ArrayList<>();
			for (Material item : Material.values()) {
				items.add(item.getKey().toString());
			}

			Bukkit.getScheduler().runTask(DirtUtils.getPlugin(), () -> {
				sender.sendMessage(Strings.END_PRINT);
				try {
					FileWriter writer = new FileWriter(DirtUtils.getPlugin().getDataFolder() + "/items.txt");
					for (String item : items) {
						writer.write(item + System.lineSeparator());
					}
					writer.close();
					sender.sendMessage(Strings.SAVE_DONE);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			});
		});
		return true;
	}
}
