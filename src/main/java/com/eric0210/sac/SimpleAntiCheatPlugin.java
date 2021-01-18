package com.eric0210.sac;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleAntiCheatPlugin extends JavaPlugin
{
	public SimpleAntiCheatPlugin()
	{
	}

	@Override
	public void onLoad()
	{
	}

	@Override
	public void onEnable()
	{
		// TODO: 이벤트 핸들러 등록
	}

	@Override
	public void onDisable()
	{
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		return false;
	}
}
