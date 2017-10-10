package com.xuanwu.demo.multithread;
/**
 * @Description �߳�yield()����demo(�̵߳����ȼ����߳��ò�yield())
 * 		�̵߳��ò���ͨ��Thread.yield()��ʵ�ֵġ�
 * 		yield()�����������Ƿ�����ǰ��CPU��Դ�������ø�����������ȥռ��CPUִ��ʱ�䣬ͨ�׽�����ͣ��ǰ��
 * 		��ִ�е��̶߳��󣬲�ִ�������̡߳����Ƿ�����ʱ�䲻ȷ�����п��ܸոշ����������ֻ��CPUʱ��Ƭ��
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
