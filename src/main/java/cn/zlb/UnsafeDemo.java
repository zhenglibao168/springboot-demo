package cn.zlb;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Unsafe类提供了以下这些功能：
 * <p>
 * 一、内存管理。包括分配内存、释放内存等。
 * <p>
 * 该部分包括了allocateMemory（分配内存）、reallocateMemory（重新分配内存）、copyMemory（拷贝内存）、freeMemory（释放内存 ）、getAddress（获取内存地址）、addressSize、pageSize、getInt（获取内存地址指向的整数）、getIntVolatile（获取内存地址指向的整数，并支持volatile语义）、putInt（将整数写入指定内存地址）、putIntVolatile（将整数写入指定内存地址，并支持volatile语义）、putOrderedInt（将整数写入指定内存地址、有序或者有延迟的方法）等方法。getXXX和putXXX包含了各种基本类型的操作。
 * <p>
 * 利用copyMemory方法，我们可以实现一个通用的对象拷贝方法，无需再对每一个对象都实现clone方法，当然这通用的方法只能做到对象浅拷贝。
 * <p>
 * 二、非常规的对象实例化。
 * <p>
 * allocateInstance()方法提供了另一种创建实例的途径。通常我们可以用new或者反射来实例化对象，使用allocateInstance()方法可以直接生成对象实例，且无需调用构造方法和其它初始化方法。
 * <p>
 * 这在对象反序列化的时候会很有用，能够重建和设置final字段，而不需要调用构造方法。
 * <p>
 * 三、操作类、对象、变量。
 * <p>
 * 这部分包括了staticFieldOffset（静态域偏移）、defineClass（定义类）、defineAnonymousClass（定义匿名类）、ensureClassInitialized（确保类初始化）、objectFieldOffset（对象域偏移）等方法。
 * <p>
 * 通过这些方法我们可以获取对象的指针，通过对指针进行偏移，我们不仅可以直接修改指针指向的数据（即使它们是私有的），甚至可以找到JVM已经认定为垃圾、可以进行回收的对象。
 * <p>
 * 四、数组操作。
 * <p>
 * 这部分包括了arrayBaseOffset（获取数组第一个元素的偏移地址）、arrayIndexScale（获取数组中元素的增量地址）等方法。arrayBaseOffset与arrayIndexScale配合起来使用，就可以定位数组中每个元素在内存中的位置。
 * <p>
 * 由于Java的数组最大值为Integer.MAX_VALUE，使用Unsafe类的内存分配方法可以实现超大数组。实际上这样的数据就可以认为是C数组，因此需要注意在合适的时间释放内存。
 * <p>
 * 五、多线程同步。包括锁机制、CAS操作等。
 * <p>
 * 这部分包括了monitorEnter、tryMonitorEnter、monitorExit、compareAndSwapInt、compareAndSwap等方法。
 * <p>
 * 其中monitorEnter、tryMonitorEnter、monitorExit已经被标记为deprecated，不建议使用。
 * <p>
 * Unsafe类的CAS操作可能是用的最多的，它为Java的锁机制提供了一种新的解决办法，比如AtomicInteger等类都是通过该方法来实现的。compareAndSwap方法是原子的，可以避免繁重的锁机制，提高代码效率。这是一种乐观锁，通常认为在大部分情况下不出现竞态条件，如果操作失败，会不断重试直到成功。
 * <p>
 * 六、挂起与恢复。
 * <p>
 * 这部分包括了park、unpark等方法。
 * <p>
 * 将一个线程进行挂起是通过park方法实现的，调用 park后，线程将一直阻塞直到超时或者中断等条件出现。unpark可以终止一个挂起的线程，使其恢复正常。整个并发框架中对线程的挂起操作被封装在 LockSupport类中，LockSupport类中有各种版本pack方法，但最终都调用了Unsafe.park()方法。
 * <p>
 * 七、内存屏障。
 * <p>
 * 这部分包括了loadFence、storeFence、fullFence等方法。这是在Java 8新引入的，用于定义内存屏障，避免代码重排序。
 * <p>
 * loadFence() 表示该方法之前的所有load操作在内存屏障之前完成。同理storeFence()表示该方法之前的所有store操作在内存屏障之前完成。fullFence()表示该方法之前的所有load、store操作在内存屏障之前完成。
 */
public class UnsafeDemo {
    //获取Unsafe实例
    static final Unsafe unsafe;
    //记录state在类TestUsafe中的偏移值
    static final long stateOffset;

    static {
        try {
            //获取成员变量
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //设置为可访问
            field.setAccessible(true);
            //是静态字段,用null来获取Unsafe实例
            unsafe = (Unsafe) field.get(null);
            //获取state变量在类中的偏移值
            stateOffset = unsafe.objectFieldOffset(UnsafeDemo.class.getDeclaredField("result"));
            System.out.println("stateOffset = " + stateOffset);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    //变量
    public volatile long result = 0;
    public int[] arr = {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) {
        UnsafeDemo testUnsafe = new UnsafeDemo();
        //执行并返回结果
        for (int i = 0; i < 1000; i++) {
            unsafe.getAndAddLong(testUnsafe, stateOffset, 3L);
        }
        System.out.println("testUnsafe.result = " + testUnsafe.result);
        System.out.println(unsafe.arrayBaseOffset(testUnsafe.arr.getClass()));
        System.out.println(unsafe.arrayIndexScale(testUnsafe.arr.getClass()));
        System.out.println(unsafe.compareAndSwapLong(testUnsafe, stateOffset, 3000, 4000));
        System.out.println(unsafe.getLongVolatile(testUnsafe, stateOffset));
        unsafe.putLongVolatile(testUnsafe, stateOffset, 5000);
        System.out.println(testUnsafe.result);
        unsafe.putOrderedLong(testUnsafe, stateOffset, 5500);
        System.out.println(testUnsafe.result);
        Thread thread1 = new Thread(() -> {
            System.out.println("线程1开始沉睡");
            long start = System.currentTimeMillis();
            long end = System.currentTimeMillis() + 8000;
            unsafe.park(true, end);
            System.out.println("主线程在" + (System.currentTimeMillis() - start) + "ms后被线程2唤醒");
        });
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(3000);
                unsafe.unpark(thread1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
    }
}