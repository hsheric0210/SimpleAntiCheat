package com.eric0210.sac.checks;

import java.util.LinkedList;
import java.util.List;

import com.eric0210.sac.config.CheckConfiguration;
import com.eric0210.sac.events.EventListener;
import com.eric0210.sac.events.EventListenerData;
import com.eric0210.sac.events.GlobalEventListener;

import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public abstract class Check implements EventListener
{
	private static final List<Check> REGISTRY = new LinkedList<>();

	private CheckConfiguration configuration;

	private boolean enabled;

	public Check(final CheckType checkType, final String checkName)
	{
		configuration = new CheckConfiguration(checkType, checkName);
		enabled = configuration.getSection().getBoolean("enabled", true);

		GlobalEventListener.onPlayerJoin.add(new EventListenerData(this, Integer.MAX_VALUE - 1));
		GlobalEventListener.onPlayerQuit.add(new EventListenerData(this, Integer.MAX_VALUE));

		REGISTRY.add(this);
	}

	public final CheckConfiguration getConfiguration()
	{
		return configuration;
	}

	public final boolean isEnabled()
	{
		return enabled;
	}

	public final boolean handleEvent(final Event event, final int condition)
	{
		switch (condition)
		{
			case Integer.MAX_VALUE - 1:
				onPlayerJoin((PlayerJoinEvent) event);
				return false;
			case Integer.MAX_VALUE:
				onPlayerQuit((PlayerQuitEvent) event);
				return false;
		}
		return onEvent(event, condition);
	}

	protected abstract boolean onEvent(final Event event, final int condition);

	// 대부분의 Check에서 쓰이는 이벤트들은 따로 모아서 전용 핸들링 메서드를 만들어 놓으면 좋습니다
	protected void onPlayerJoin(final PlayerJoinEvent event)
	{
	}

	protected void onPlayerQuit(final PlayerQuitEvent event)
	{
	}
}
