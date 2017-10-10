package com.xuanwu.demo.multithread;
/**
 * @Description 线程的两种实现方式
 * @author Jane1222
 * @Date 2017-09-28
 *
 */
public class MultiThread {
	public static void main(String[] args) throws InterruptedException {
		ThreadA thread = new ThreadA();
		thread.setName("threadA--01");
		ThreadA thread2 = new ThreadA();
		thread2.setName("threadA--02");
		thread.start();
		thread2.start();
		ThreadB t = new ThreadB();
		/**
		 * 为了启动ThreadB，需要首先实例化一个Thread，并传入自己的ThreadB实例.查看jdk源码知，
		 *当传入一个Runnable target参数给Thread后，Thread的run()方法就会调用target.run()
		 */
		new Thread(t).start();
	}

}

/**
 * 
 * 继承Thread类
 *
 */
class ThreadA extends Thread{
	@Override
	public void run() {
		try {
			for(int i=0;i<5;i++){
				int time = (int)Math.random()*1000;
				Thread.sleep(time);
				System.out.println("threadA run="+Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

/**
 * 
 *实现Runnable接口
 *
 */
class ThreadB extends MultiThread implements Runnable{
	@Override
	public void run() {
		try {
			for(int i=0;i<5;i++){
				int time = (int)Math.random()*1000;
				Thread.sleep(time);
				System.out.println("threadB run="+Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
