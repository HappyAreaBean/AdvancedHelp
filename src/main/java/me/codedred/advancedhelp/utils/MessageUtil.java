package me.codedred.advancedhelp.utils;

import me.codedred.advancedhelp.Main;
import net.kyori.adventure.audience.Audience;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageUtil {

	private static SimpleDateFormat format = new SimpleDateFormat(Main.getInstance().getConfig().getString("dateFormat"));

	public static void sendHelpMessage(CommandSender sender, String msg) {
		Date now = new Date();
		if (Main.getInstance().hasPAPI() && sender instanceof Player) {
			Player player = (Player) sender;
			msg = PlaceholdersUtil.setPlaceholders(player, msg);
		}
		Audience aSender = Main.getInstance().getAdventure().sender(sender);
		aSender.sendMessage(Main.getInstance().getMiniMessage().deserialize(Main.getInstance().format(msg).replace("%player%", sender.getName()).replace("%time%", format.format(now))));
	}
}
