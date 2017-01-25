package Thread;

import java.util.concurrent.locks.Lock;

import org.junit.Test;

public class TwinsLockTest {
	@Test
	public void test(){
		final Lock lock = new TwinsLock();
		class Worker extends Thread{
			public void run(){
				while(true){
					lock.lock();
					try {
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName());
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						lock.unlock();
					}
				}
			}
		}
		for(int i=0; i< 10; i++){
			Worker w = new Worker();
			w.setDaemon(true);
			w.start();
		}
		for(int i=0; i<10; i++){
			try {
				Thread.sleep(1000);
				System.out.println();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
