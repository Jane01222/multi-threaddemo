package com.xuanwu.demo.multithread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ��֤ExecutorService���ɶ��߳�
 * 		Executors�࣬�ṩ��һϵ�й����������ڴ����̳߳أ����ص��̳߳ض�ʵ����ExecutorService�ӿ�
 * 
 * ʹ��ExecutorService��Callable��Futureʵ���з��ؽ�����߳�
	ExecutorService��Callable��Future�����ӿ�ʵ���϶�������Executor��ܡ����ؽ�����߳�����JDK1.5����������������������������Ͳ���Ҫ��Ϊ�˵õ�����ֵ����������ˡ������Լ�ʵ����Ҳ����©���ٳ���
	�ɷ���ֵ���������ʵ��Callable�ӿڡ����Ƶģ��޷���ֵ���������ʵ��Runnable�ӿڡ�
	ִ��Callable����󣬿��Ի�ȡһ��Future�Ķ����ڸö����ϵ���get�Ϳ��Ի�ȡ��Callable���񷵻ص�Object�ˡ�
	ע�⣺get�����������ģ������߳��޷��ؽ����get������һֱ�ȴ���
	�ٽ���̳߳ؽӿ�ExecutorService�Ϳ���ʵ�ִ�˵���з��ؽ���Ķ��߳��ˡ�
 * @author Jane1222
 * @Date 2017-09-29
 *
 */
public class ExecutorServiceTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Date date1 = new Date();
		int taskSize=5;
		//����һ���̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		//��������з���ֵ������
		List<Future> list = new ArrayList<Future>();
		for(int i=0;i<taskSize;i++){
			Callable c = new MyCallable(i+"");
			//ִ�����񲢻�ȡFuture����
			Future f = pool.submit(c);
			list.add(f);
		}
		//�ر��̳߳�
		pool.shutdown();
		//��ȡ������������н��
		for(Future f:list){
			//��Future�����ϻ�ȡ����ķ���ֵ�����������̨
			System.out.println(f.get().toString());
		}
		Date date2 = new Date();
		System.out.println("===�������н���===������ʱ��"+(date2.getTime()-date1.getTime())+"����");
	}
}
/**
 * ����˵����
 * ����������Executors�࣬�ṩ��һϵ�й����������ڴ����̳߳أ����ص��̳߳ض�ʵ����ExecutorService�ӿڡ�
	public static ExecutorService newFixedThreadPool(int nThreads) 
	�����̶���Ŀ�̵߳��̳߳ء�
	public static ExecutorService newCachedThreadPool() 
	����һ���ɻ�����̳߳أ�����execute ��������ǰ������̣߳�����߳̿��ã�����������߳�û�п��õģ��򴴽�һ�����̲߳���ӵ����С���ֹ���ӻ������Ƴ���Щ���� 60 ����δ��ʹ�õ��̡߳�
	public static ExecutorService newSingleThreadExecutor() 
	����һ�����̻߳���Executor��
	public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) 
	����һ��֧�ֶ�ʱ�������Ե�����ִ�е��̳߳أ���������¿��������Timer�ࡣ

	ExecutoreService�ṩ��submit()����������һ��Callable����Runnable������Future�����Executor��̨�̳߳ػ�û�����Callable�ļ��㣬����÷���Future�����get()������������ֱ���������
 */


/**
 * 
 * @Description ʵ��Callable�ӿ�ͨ��FutureTask��װ��������Thread�߳�
 * 
 */
class MyCallable implements Callable<Object> {  
	private String taskName;  
	MyCallable(String taskName) {  
	   this.taskName = taskName;  
	}  
  
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


 
