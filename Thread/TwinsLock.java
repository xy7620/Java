package Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TwinsLock implements Lock {

	private final Sync sync = new Sync(2);
	private static final class Sync extends AbstractQueuedSynchronizer{ //内部同步组件
		Sync(int count){
			if(count < 0){
				throw new IllegalArgumentException("count must large than zero");
			}
			setState(count);//设置初始状态，即本例中state代表同步资源数
		}
		public int tryAcquiredShared(int reduceCount){
			for(;;){
				int current = getState();
				int newCount = current - reduceCount; //计算新的state
				if(newCount < 0 || compareAndSetState(current, newCount)){//state < 0 就直接返回，否则把现在state设置成新的state，返回新state
					return newCount;
				}
			}
		}
		public boolean tryReleaseShared(int returnCount){
			for(;;){
				int current = getState();
				int newCount = current+returnCount;
				if(compareAndSetState(current, newCount)){ //把现在的state设置成新的
					return true;
				}
			}
		}
	}
	@Override
	public void lock() {
		// TODO Auto-generated method stub
		sync.tryAcquiredShared(1);
	}
	@Override
	public void unlock() {
		// TODO Auto-generated method stub
		sync.tryReleaseShared(1);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean tryLock() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit)
			throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}

}
