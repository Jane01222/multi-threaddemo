package com.xuanwu.demo.multithread;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description 多线程的几种实现方式，有的资料说三种，有的说四种，归纳如下：
 * 		1.继承Thread类创建线程
 * 		2.实现Runnable接口创建线程
 * 		3.实现Callable接口通过FutureTask包装器来创建Thread线程
 * 		4.使用ExecutorService、Callable、Future实现有返回结果的线程
 * @author Jane1222
 * @Date 2017-09-28
 */
public class MultipleThread {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		String taskName="A";
		Callable<Object> oneCallable = new SomeCallable<Object>(taskName);
		//由Callable<Object>创建一个FutureTask<Object>对象：
		FutureTask<Object> oneTask = new FutureTask<Object>(oneCallable);
		//FutureTask<Object>,它通过接收Callable<Object>来创建，它同时实现了Future和Runnable接口。由FutureTask<Object>来创建一个Thread对象
		Thread thread = new Thread(oneTask);
		//至此一个线程就创建完成了
		thread.start();
		System.out.println(oneTask.get().toString());
		
		Callable<Object> oneCallable2 = new SomeCallable2("B");
		FutureTask<Object> oneTask2 = new FutureTask<Object>(oneCallable2);
		Thread thread2 = new Thread(oneTask2);
		thread2.start();
		System.out.println(oneTask2.get().toString());
		
	}
}


@SuppressWarnings("hiding")
class SomeCallable<Object> extends MultiThread implements Callable<Object>{
	private String taskName; 
	public SomeCallable(String taskName){
		this.taskName = taskName;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Object call() throws Exception {
	   System.out.println(">>>" + taskName + "任务启动");  
	   Date dateTmp1 = new Date();  
	   Thread.sleep(1000);  
	   Date dateTmp2 = new Date();  
	   long time = dateTmp2.getTime() - dateTmp1.getTime();  
	   System.out.println(">>>" + taskName + "任务终止");  
	   return  (Object) (taskName + "任务返回运行结果,当前任务时间【" + time + "毫秒】"); 
	}
	
}

/**
 * 
 * 实现Callable接口通过FutureTask包装器来创建Thread线程
 *
 */
class SomeCallable2 extends MultiThread implements Callable<Object>{
	private String taskName; 
	public SomeCallable2(String taskName){
		this.taskName = taskName;
	}

	@Override
	public Object call() throws Exception {
	   System.out.println(">>>" + taskName + "任务启动");  
	   Date dateTmp1 = new Date();  
	   Thread.sleep(1000);  
	   Date dateTmp2 = new Date();  
	   long time = dateTmp2.getTime() - dateTmp1.getTime();  
	   System.out.println(">>>" + taskName + "任务终止");  
	   return taskName + "任务返回运行结果,当前任务时间【" + time + "毫秒】"; 
	}
	
}
