package com.eric0210.sac.checks;

import java.util.ArrayDeque;
import java.util.Deque;

public class Check
{
	private static final Deque<Check> REGISTRY = new ArrayDeque<>();

	private boolean enabled;

	public Check()
	{

		REGISTRY.add(this);
	}

	public boolean isEnabled()
	{
		return enabled;
	}
}
