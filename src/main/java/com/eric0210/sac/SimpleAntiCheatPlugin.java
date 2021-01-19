package com.eric0210.sac;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Optional;

@SuppressWarnings("unused")
public final class SimpleAntiCheatPlugin extends JavaPlugin
{
	private static ISimpleAntiCheat sac;
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
		sac = new SimpleAntiCheat(this, getDataFolder());
	}

	@Override
	public void onDisable()
	{
		Optional.ofNullable(sac).ifPresent(ISimpleAntiCheat::unload);
	}

	@Override
	public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args)
	{
		return false;
	}
}
