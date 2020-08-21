package cn.zlb.queue;

import org.testng.annotations.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列
 * 先进先出
 *
 * @author libao.zheng
 * @date 2020/7/21 1:47 下午
 */
public class BlockingQueue {
    /**
     * 插入 add
     */
    @Test
    public void testAdd() {
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(2, true);
      // System.out.println(blockingQueue.add(1));//返回true
      // System.out.println(blockingQueue.add(2));//返回true
      // System.out.println(blockingQueue.add(3));//抛异常 java.lang.IllegalStateException: Queue full
    }

    /**
     * 插入 put
     */
    @Test
    public void testPut() throws InterruptedException {
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(2);
        blockingQueue.put(1);
        blockingQueue.put(2);
        blockingQueue.put(3);//一直阻塞，直到队列有元素被取走
    }

    /**
     * 插入 offer
     */
    @Test
    public void testOffer() {
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(2);
      // System.out.println(blockingQueue.offer(1));//返回true
      // System.out.println(blockingQueue.offer(2));//返回true
      // System.out.println(blockingQueue.offer(3));//插入失败返回false
    }

    /**
     * 插入 offer,超时返回失败
     */
    @Test
    public void testOfferWithTimeout() throws InterruptedException {
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(2);
      // System.out.println(blockingQueue.offer(1, 1000, TimeUnit.MILLISECONDS));//返回true
      // System.out.println(blockingQueue.offer(2, 1000, TimeUnit.MILLISECONDS));//返回true
      // System.out.println(blockingQueue.offer(3, 1000, TimeUnit.MILLISECONDS));//等待1000ms队列还是满的，返回false
    }

    /**
     * 删除 remove
     */
    @Test
    public void testRemove() {
        ArrayBlockingQueue<Integer> blockingQueue = createArrayBlockingQueue();
      // System.out.println(blockingQueue.remove(2));//返回true
      // System.out.println(blockingQueue.remove(5));//元素不存在返回false
      // System.out.println(blockingQueue.remove(1));//返回true
      // System.out.println(blockingQueue.remove(3));//队列为空返回false
    }

    /**
     * 删除 take
     */
    @Test
    public void testTake() throws InterruptedException {
        ArrayBlockingQueue<Integer> blockingQueue = createArrayBlockingQueue();
      // System.out.println(blockingQueue.take());//获取并移除此队列的头
      // System.out.println(blockingQueue.take());//获取并移除此队列的头
      // System.out.println(blockingQueue.take());//一直阻塞，直到队列非空
    }

    /**
     * 只查询不删除 peek
     */
    @Test
    public void testPeek() {
        ArrayBlockingQueue<Integer> blockingQueue = createArrayBlockingQueue();
      // System.out.println(blockingQueue.peek());//返回但不移除队列的头
      // System.out.println(blockingQueue.peek());//返回但不移除队列的头
        blockingQueue.clear();
      // System.out.println(blockingQueue.peek());//队列为空，返回null
    }

    /**
     * 删除 poll
     */
    @Test
    public void testPoll() {
        ArrayBlockingQueue<Integer> blockingQueue = createArrayBlockingQueue();
      // System.out.println(blockingQueue.poll());//获取并移除此队列的头
      // System.out.println(blockingQueue.poll());//获取并移除此队列的头
        blockingQueue.clear();
      // System.out.println(blockingQueue.poll());//队列为空，返回null
    }

    /**
     * 删除 poll,超时返回失败
     */
    @Test
    public void testPollWithTimeout() throws InterruptedException {
        ArrayBlockingQueue<Integer> blockingQueue = createArrayBlockingQueue();
      // System.out.println(blockingQueue.poll(1000, TimeUnit.MILLISECONDS));//获取并移除此队列的头
      // System.out.println(blockingQueue.poll(1000, TimeUnit.MILLISECONDS));//获取并移除此队列的头
      // System.out.println(blockingQueue.poll(1000, TimeUnit.MILLISECONDS));//等待1000ms，队列还是为空返回null
    }

    /**
     * 创建阻塞队列
     *
     * @return 大小为2的阻塞队列
     */
    private ArrayBlockingQueue<Integer> createArrayBlockingQueue() {
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(2, true);
        blockingQueue.add(1);
        blockingQueue.add(2);
        return blockingQueue;
    }
}
