package com.eric0210.sac.utils;

import java.util.concurrent.*;

public final class Multithreading
{
	private static final ExecutorService defaultWorkers;
	private static final ForkJoinPool defaultForkJoinWorkers;

	static
	{
		final int processors = Runtime.getRuntime().availableProcessors();
		defaultWorkers = new ThreadPoolExecutor(processors, processors, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
		defaultForkJoinWorkers = new ForkJoinPool(processors);
	}

	public static ExecutorService getDefaultWorkers()
	{
		return defaultWorkers;
	}

	public static ForkJoinPool getDefaultForkJoinWorkers()
	{
		return defaultForkJoinWorkers;
	}

	private Multithreading()
	{

	}
}
