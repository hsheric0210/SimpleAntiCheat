package com.eric0210.sac.config;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import com.eric0210.sac.ISimpleAntiCheat;
import com.eric0210.sac.SimpleAntiCheat;
import com.eric0210.sac.checks.CheckType;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public final class CheckConfiguration
{
	private static final Map<String, File> files = new LinkedHashMap<>();

	private final File file;

	private ConfigurationSection section;

	public CheckConfiguration(final CheckType checkType, final String checkName)
	{
		final ISimpleAntiCheat sac = SimpleAntiCheat.getInstance();

		final String fileName = Objects.requireNonNull(checkType).name().toLowerCase(Locale.ROOT) + ".yml";
		if (!files.containsKey(fileName))
		{
			file = new File(sac.getDataFolder(), fileName);
			files.put(fileName, file);
			if (!file.exists())
				try
				{
					if (!file.createNewFile())
						throw new IOException("createNewFile() returned false");
				}
				catch (final IOException ioe)
				{
					SimpleAntiCheat.exception(String.format("Can't create the configuration file '%s' in directory '%s'", fileName, sac.getDataFolder().getAbsolutePath()), ioe);
				}
		}
		else
			file = files.get(fileName);

		try
		{
			final YamlConfiguration yaml = new YamlConfiguration();
			yaml.load(file);

			final String sectionName = Objects.requireNonNull(checkName).toLowerCase(Locale.ROOT);
			section = yaml.getConfigurationSection(sectionName);
		}
		catch (final IOException | InvalidConfigurationException e)
		{
			SimpleAntiCheat.exception(String.format("Can't parse the configuration file '%s' in directory '%s'", fileName, sac.getDataFolder().getAbsolutePath()), e);
		}
	}

	public File getFile()
	{
		return file;
	}

	public ConfigurationSection getSection()
	{
		return section;
	}
}
