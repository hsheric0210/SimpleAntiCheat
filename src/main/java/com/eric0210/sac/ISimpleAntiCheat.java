package com.eric0210.sac;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

@SuppressWarnings("InterfaceWithOnlyOneDirectInheritor")
public interface ISimpleAntiCheat {
	void unload();
	JavaPlugin getPlugin();
	File getDataFolder();
}
