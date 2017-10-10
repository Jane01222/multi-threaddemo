package com.xuanwu.demo.multithread;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description ���̵߳ļ���ʵ�ַ�ʽ���е�����˵���֣��е�˵���֣��������£�
 * 		1.�̳�Thread�ഴ���߳�
 * 		2.ʵ��Runnable�ӿڴ����߳�
 * 		3.ʵ��Callable�ӿ�ͨ��FutureTask��װ��������Thread�߳�
 * 		4.ʹ��ExecutorService��Callable��Futureʵ���з��ؽ�����߳�
 * @author Jane1222
 * @Date 2017-09-28
 */
public class MultipleThread {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		String taskName="A";
		Callable<Object> oneCallable = new SomeCallable<Object>(taskName);
		//��Callable<Object>����һ��FutureTask<Object>����
		FutureTask<Object> oneTask = new FutureTask<Object>(oneCallable);
		//FutureTask<Object>,��ͨ������Callable<Object>����������ͬʱʵ����Future��Runnable�ӿڡ���FutureTask<Object>������һ��Thread����
		Thread thread = new Thread(oneTask);
		//����һ���߳̾ʹ��������
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
	   System.out.println(">>>" + taskName + "��������");  
	   Date dateTmp1 = new Date();  
	   Thread.sleep(1000);  
	   Date dateTmp2 = new Date();  
	   long time = dateTmp2.getTime() - dateTmp1.getTime();  
	   System.out.println(">>>" + taskName + "������ֹ");  
	   return  (Object) (taskName + "���񷵻����н��,��ǰ����ʱ�䡾" + time + "���롿"); 
	}
	
}

/**
 * 
 * ʵ��Callable�ӿ�ͨ��FutureTask��װ��������Thread�߳�
 *
 */
class SomeCallable2 extends MultiThread implements Callable<Object>{
	private String taskName; 
	public SomeCallable2(String taskName){
		this.taskName = taskName;
	}

	@Override
	public Object call() throws Exception {
	   System.out.println(">>>" + taskName + "��������");  
	   Date dateTmp1 = new Date();  
	   Thread.sleep(1000);  
	   Date dateTmp2 = new Date();  
	   long time = dateTmp2.getTime() - dateTmp1.getTime();  
	   System.out.println(">>>" + taskName + "������ֹ");  
	   return taskName + "���񷵻����н��,��ǰ����ʱ�䡾" + time + "���롿"; 
	}
	
}
