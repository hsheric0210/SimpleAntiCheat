package com.eric0210.sac.events;

// 이벤트 핸들링 알고리즘 출처: VisualAbility(야생능력자) 플러그인 //
public class EventHandlerData
{
	private final EventListener listener;
	private final int condition;

	public EventHandlerData(final EventListener listener, final int condition)
	{
		this.listener = listener;
		this.condition = condition;
	}

	public EventListener getListener()
	{
		return listener;
	}

	public int getCondition()
	{
		return condition;
	}
}
