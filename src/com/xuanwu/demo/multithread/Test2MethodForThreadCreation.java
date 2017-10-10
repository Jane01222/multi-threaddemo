package com.xuanwu.demo.multithread;
/**
 * @Description �̵߳�����ʵ�ַ�ʽ���ӱȽ�
 * @author Jane1222
 * @Date 2017-09-29
 *
 */
public class Test2MethodForThreadCreation {
	public static void main(String[] args) {
		/**
		 * ���������߳�û�й������񣬶���CPU����˳��ȷ���������߳��и��Ե�ִ��·�������Ṳ��
		 */
		new MyThreadA().start();
		new MyThreadA().start();
		
		/**
		 * ���������߳�û�й�������,ֻ��ÿ���̶߳�����ͬһ��ʵ�����������£��������ͬһ����Ч���ͺ������һ����
		 */
		new Thread(new MyThreadB()).start();
		new Thread(new MyThreadB()).start();
		
		/**
		 * Runnable��run������һ���շ���������������κ��߳���Ϊ��������ʽ�ؽ�һ�������ŵ��߳���.
		 * ���£�
		 * 	���������̹߳���һ�����񣬶���û��ͬ������
		 */
		MyThreadB task = new MyThreadB();
		new Thread(task).start();
		new Thread(task).start();
		
		System.out.println("���굹��ʱ����ʼ��");
	}
		

}

class MyThreadA extends Thread{
	private int countDown = 10;  
    @Override  
    public void run() {  
        while (countDown-- > 0) {  
            System.out.println("#" + Thread.currentThread().getName() + "("  
                    + countDown + ")");  
        }  
    }  
}


class MyThreadB implements Runnable{
	private int countDown = 10; 
	@Override
	public void run() {
		while (countDown-- > 0) {  
            System.out.println("#" + Thread.currentThread().getName() + "("  
                    + countDown + ")");  
        }  
	}
	
}

/**
 * �ܽ᣺
 * ���ü̳�Thread�෽ʽ��
��1���ŵ㣺��д�򵥣������Ҫ���ʵ�ǰ�̣߳�����ʹ��Thread.currentThread()������ֱ��ʹ��this�����ɻ�õ�ǰ�̡߳�
��2��ȱ�㣺��Ϊ�߳����Ѿ��̳���Thread�࣬���Բ����ټ̳������ĸ��ࡣ
����ʵ��Runnable�ӿڷ�ʽ��
��1���ŵ㣺�߳���ֻ��ʵ����Runable�ӿڣ������Լ̳��������ࡣ�����ַ�ʽ�£����Զ���̹߳���ͬһ��Ŀ��������Էǳ��ʺ϶����ͬ�߳�������ͬһ����Դ��������Ӷ����Խ�CPU��������ݷֿ����γ�������ģ�ͣ��Ϻõ���������������˼�롣
��2��ȱ�㣺�����΢���ӣ������Ҫ���ʵ�ǰ�̣߳�����ʹ��Thread.currentThread()������
*/
