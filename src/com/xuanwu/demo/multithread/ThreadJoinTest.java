package com.xuanwu.demo.multithread;
/**
 * @Description �߳�join()����
 * 		Thread�ķǾ�̬����join()��һ���߳�B�����롱������һ���߳�A��β������Aִ�����֮ǰ��B���ܹ�����
 * 		����join()��������֤��ǰ�߳�ִֹͣ�У�ֱ�����߳���������߳����Ϊֹ��Ȼ���������������߳�û�д���ǰ�̲߳���Ҫֹͣ��
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
			System.out.println(currentThread().getName()+threadName+"------>��ʼ��"+i+++"������ִ��");
	}
}
