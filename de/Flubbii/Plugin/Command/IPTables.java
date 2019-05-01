package de.Flubbii.Plugin.Command;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Flubbii.Plugin.Utils.Messages;

public class IPTables implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs instanceof Player) {
			Player p = (Player) cs;
			if (p.hasPermission(Messages.getMessage("Permission.Command"))) {
				if (args.length == 2) {
					String IP = args[1];
					if (isIP(IP)) {
						if (args[0].equalsIgnoreCase("add")) {
							try {
								Runtime.getRuntime().exec("iptables -A INPUT -s " + IP + " -j DROP");
							} catch (IOException e) {
								e.printStackTrace();
							}
							p.sendMessage(Messages.getMessage("IP-Blocked").replace("%Prefix%", Messages.getMessage("Prefix")));
						} else if (args[0].equalsIgnoreCase("remove")) {
							try {
								Runtime.getRuntime().exec("iptables -D INPUT -s " + IP + " -j DROP");
							} catch (IOException e) {
								e.printStackTrace();
							}
							p.sendMessage(Messages.getMessage("IP-Released").replace("%Prefix%", Messages.getMessage("Prefix")));
						} else {
							p.sendMessage(Messages.getMessage("Syntax").replace("%Prefix%", Messages.getMessage("Prefix")));
						}
					} else {
						p.sendMessage(Messages.getMessage("IP-Invalid").replace("%Prefix%", Messages.getMessage("Prefix")));
					}
				} else {
					p.sendMessage(Messages.getMessage("Syntax").replace("%Prefix%", Messages.getMessage("Prefix")));
				}
			} else {
				p.sendMessage(Messages.getMessage("NoPermission").replace("%Prefix%", Messages.getMessage("Prefix")));
			}
		} else {
			if (args.length == 2) {
				String IP = args[1];
				if (isIP(IP)) {
					if (args[0].equalsIgnoreCase("add")) {
						try {
							Runtime.getRuntime().exec("iptables -A INPUT -s " + IP + " -j DROP");
						} catch (IOException e) {
							e.printStackTrace();
						}
						cs.sendMessage(Messages.getMessage("IP-Blocked").replace("%Prefix%", Messages.getMessage("Prefix")));
					} else if (args[0].equalsIgnoreCase("remove")) {
						try {
							Runtime.getRuntime().exec("iptables -D INPUT -s " + IP + " -j DROP");
						} catch (IOException e) {
							e.printStackTrace();
						}
						cs.sendMessage(Messages.getMessage("IP-Released").replace("%Prefix%", Messages.getMessage("Prefix")));
					} else {
						cs.sendMessage(Messages.getMessage("Syntax").replace("%Prefix%", Messages.getMessage("Prefix")));
					}
				} else {
					cs.sendMessage(Messages.getMessage("IP-Invalid").replace("%Prefix%", Messages.getMessage("Prefix")));
				}
			} else {
				cs.sendMessage(Messages.getMessage("Syntax").replace("%Prefix%", Messages.getMessage("Prefix")));
			}
		}
		return false;
	}

	private Boolean isIP(String IP) {
		Boolean Status = false;
		if (IP.matches("[1234567890._-]*")) {
			Status = true;
		} else {
			return false;
		}
		if (getPoints(IP).length() == 3) {
			Status = true;
		} else {
			return false;
		}
		return Status;
	}

	private String getPoints(String IP) {
		return IP.replace("0", "").replace("1", "").replace("2", "").replace("3", "").replace("4", "").replace("5", "")
				.replace("6", "").replace("7", "").replace("8", "").replace("9", "");
	}
}
