package com.xuanwu.demo.multithread;
/**
 * @Description 线程join()方法
 * 		Thread的非静态方法join()让一个线程B“加入”到另外一个线程A的尾部。在A执行完毕之前，B不能工作。
 * 		调用join()方法：保证当前线程停止执行，直到该线程所加入的线程完成为止。然而，如果它加入的线程没有存活，则当前线程不需要停止。
 * @author Jane1222
 * @Date 2017-10-09
 */
public class ThreadJoinTest {
	public static void main(String[] args) throws InterruptedException {
		MyThreadJ a1 = new MyThreadJ("AAA");
		a1.start();
		a1.join();
		
		MyThreadJ b = new MyThreadJ("BBB");
		b.start();
//		b.join();
		
		MyThreadJ c = new MyThreadJ("CCC");
		c.start();
//		c.join();
		
	}
}


class MyThreadJ extends Thread{
	private String threadName;
	private int i=0;
	public MyThreadJ(String threadName){
		this.threadName=threadName;
	}
	public void run(){
		while(i<10) 
			System.out.println(currentThread().getName()+threadName+"------>开始第"+i+++"次任务执行");
	}
}
