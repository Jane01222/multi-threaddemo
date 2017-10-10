package com.xuanwu.demo.multithread;
/**
 * @Description 线程yield()方法demo(线程的优先级和线程让步yield())
 * 		线程的让步是通过Thread.yield()来实现的。
 * 		yield()方法的作用是放弃当前的CPU资源，将它让给其他的任务去占用CPU执行时间，通俗讲即暂停当前正
 * 		在执行的线程对象，并执行其他线程。但是放弃的时间不确定，有可能刚刚放弃，马上又获得CPU时间片。
 * @author Jane1222
 * @Date 2017-10-09
 */
public class ThreadYieldTest {
	public static void main(String[] args) {
		MyThread a1 = new MyThread("AAA");
		Thread t1 = new Thread(a1);
		t1.start();
		
		MyThread a2 = new MyThread("BBB");
		Thread t2 = new Thread(a2);
		t2.start();
		
		MyThread a3 = new MyThread("CCC");
		a3.start();
	}

}

class MyThread extends Thread{
	private String threadName;
	private long i=1;
	public MyThread(String threadName){
		this.threadName = threadName;
	}
	
	public void run(){
		while(i<10){
			System.out.println(threadName+"-------------->"+i++);
			Thread.yield();
		}
	}
	
}
