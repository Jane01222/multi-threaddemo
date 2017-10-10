package com.xuanwu.demo.multithread;
/**
 * @Description �̵߳�����ʵ�ַ�ʽ
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
		 * Ϊ������ThreadB����Ҫ����ʵ����һ��Thread���������Լ���ThreadBʵ��.�鿴jdkԴ��֪��
		 *������һ��Runnable target������Thread��Thread��run()�����ͻ����target.run()
		 */
		new Thread(t).start();
	}

}

/**
 * 
 * �̳�Thread��
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
 *ʵ��Runnable�ӿ�
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
