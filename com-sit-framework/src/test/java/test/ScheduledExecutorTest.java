package test;

/**
 * omplatform
 * test
 * @{#} testetest.java Create on  2013-7-10 上午5:15:55
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">张光明</a>
 * @version 1.0
 * 功能说明：
 *
 */
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ScheduledExecutorTest {
	//线程池能按时间计划来执行任务，允许用户设定计划执行任务的时间，int类型的参数是设定
	//线程池中线程的最小数目。当任务较多时，线程池可能会自动创建更多的工作线程来执行任务
	public ScheduledExecutorService scheduExec = Executors.newScheduledThreadPool(1);
	
	private boolean taskstop;
	//启动计时器
	public void lanuchTimer(){
		Runnable task = new Runnable() {
			public void run() {
				throw new RuntimeException();
			}
		};
		scheduExec.scheduleWithFixedDelay(task, 5, 10, TimeUnit.SECONDS);
	}
	//添加新任务
	public void addOneTask(long slpfeq ,long runfeq) throws Exception{
		Runnable task = new Runnable() {
			public void run() {
				
				System.out.println("welcome to china");
				taskstop=true;
				System.out.println("stop status is :"+taskstop);
				
				if(taskstop)
				{
					scheduExec.shutdown();
					System.out.println("job has been shotdowned!");
				}
			}
		};
		scheduExec.scheduleWithFixedDelay(task, slpfeq, runfeq, TimeUnit.SECONDS);
	}
	
	public void runjob(long slpfeq ,long runfeq,String filepath) throws Exception
	{
		ScheduledExecutorTest test = new ScheduledExecutorTest();
		test.lanuchTimer();
//		Thread.sleep(5);//5秒钟之后添加新任务
		test.addOneTask(5,5);
		System.out.println("continue...");
	}
}

