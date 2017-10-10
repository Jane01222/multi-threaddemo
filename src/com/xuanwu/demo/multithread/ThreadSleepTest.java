package com.xuanwu.demo.multithread;
/**
 * @Description 线程sleep()方法
 * 		Thread.sleep(long millis)和Thread.sleep(long millis, int nanos)静态方法强制当前正在执行的线程
 * 休眠（暂停执行），以“减慢线程”。当线程睡眠时，它入睡在某个地方，在苏醒之前不会返回到可运行状态。当睡眠时间到期，则返回
 * 到可运行状态
 * @author Jane1222
 * @Date 2017-10-09
 */
public class ThreadSleepTest {
	public static void main(String[] args) {
		MyThread2 a1 = new MyThread2("AAA");
		a1.start();
		
		MyThread2 a2 = new MyThread2("BBB");
		a2.start();
		
		MyThread2 a3 = new MyThread2("CCC");
		Thread m = new Thread(a3);
		m.start();
	}
}

class MyThread2 extends Thread{
	private String threadName;
	private int i=1;
	public MyThread2(String threadName){
		this.threadName=threadName;
	}
	public void run(){
		while(i<10){
			System.out.println(currentThread().getName()+threadName+"---->开始执行任务"+(++i));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(currentThread().getName()+threadName+"---->睡眠3s后完成任务"+i);
		}
	}
}
