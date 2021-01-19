package com.eric0210.sac;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.eric0210.sac.config.CheckConfiguration;
import com.eric0210.sac.events.GlobalEventListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleAntiCheat implements ISimpleAntiCheat
{
	private static final Logger LOGGER = Logger.getLogger(SimpleAntiCheat.class.getSimpleName());

	private static ISimpleAntiCheat instance;
	private static JavaPlugin plugin;
	private static File dataFolder;
	private static List<CheckConfiguration> configurationList = new LinkedList<>();

	SimpleAntiCheat(final JavaPlugin plugin, final File dataFolder)
	{
		SimpleAntiCheat.plugin = plugin;
		SimpleAntiCheat.dataFolder = dataFolder;

		Bukkit.getPluginManager().registerEvents(new GlobalEventListener(), plugin);

		instance = this;
	}

	@Override
	public void unload()
	{

	}

	public static ISimpleAntiCheat getInstance()
	{
		return Objects.requireNonNull(instance, "SAC is not loaded yet.");
	}

	@Override
	public JavaPlugin getPlugin()
	{
		return plugin;
	}

	@Override
	public File getDataFolder()
	{
		return dataFolder;
	}

	public static void info(final String message)
	{
		LOGGER.info(message);
	}

	public static void exception(final String message, final Throwable thrown)
	{
		LOGGER.log(Level.SEVERE, message, thrown);
	}
}
