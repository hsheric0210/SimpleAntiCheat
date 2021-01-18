package com.eric0210.sac.events;

import org.bukkit.event.Event;

public interface EventListener
{
	boolean handleEvent(final Event event, final int condition);
}
