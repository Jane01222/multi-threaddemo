package com.xuanwu.demo.multithread;
/**
 * @Description 线程的两种实现方式优劣比较
 * @author Jane1222
 * @Date 2017-09-29
 *
 */
public class Test2MethodForThreadCreation {
	public static void main(String[] args) {
		/**
		 * 由于两个线程没有共享任务，而且CPU调度顺序不确定，两个线程有各自的执行路径，不会共享
		 */
		new MyThreadA().start();
		new MyThreadA().start();
		
		/**
		 * 这里两个线程没有共享任务,只有每个线程都是用同一个实例化对象，如下，如果不是同一个，效果就和上面的一样了
		 */
		new Thread(new MyThreadB()).start();
		new Thread(new MyThreadB()).start();
		
		/**
		 * Runnable中run方法是一个空方法，并不会产生任何线程行为，必须显式地将一个任务附着到线程上.
		 * 如下：
		 * 	这里两个线程共享一个任务，而且没有同步操作
		 */
		MyThreadB task = new MyThreadB();
		new Thread(task).start();
		new Thread(task).start();
		
		System.out.println("新年倒计时，开始：");
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
 * 总结：
 * 采用继承Thread类方式：
（1）优点：编写简单，如果需要访问当前线程，无需使用Thread.currentThread()方法，直接使用this，即可获得当前线程。
（2）缺点：因为线程类已经继承了Thread类，所以不能再继承其他的父类。
采用实现Runnable接口方式：
（1）优点：线程类只是实现了Runable接口，还可以继承其他的类。在这种方式下，可以多个线程共享同一个目标对象，所以非常适合多个相同线程来处理同一份资源的情况，从而可以将CPU代码和数据分开，形成清晰的模型，较好地体现了面向对象的思想。
（2）缺点：编程稍微复杂，如果需要访问当前线程，必须使用Thread.currentThread()方法。
*/
