package com.xuanwu.demo.multithread;
/**
 * @Description �߳�sleep()����
 * 		Thread.sleep(long millis)��Thread.sleep(long millis, int nanos)��̬����ǿ�Ƶ�ǰ����ִ�е��߳�
 * ���ߣ���ִͣ�У����ԡ������̡߳������߳�˯��ʱ������˯��ĳ���ط���������֮ǰ���᷵�ص�������״̬����˯��ʱ�䵽�ڣ��򷵻�
 * ��������״̬
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
			System.out.println(currentThread().getName()+threadName+"---->��ʼִ������"+(++i));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(currentThread().getName()+threadName+"---->˯��3s���������"+i);
		}
	}
}
