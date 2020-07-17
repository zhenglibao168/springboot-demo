package cn.zlb.biz.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocalAndPool {
    private static ThreadLocal<Integer> variableLocal = ThreadLocal.withInitial(() -> 0);

    public static void increment() {
        variableLocal.set(variableLocal.get() + 1);
    }

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>(12));
        for (int i = 0; i < 50; i++) {
            executorService.execute(() -> {
                long threadId = Thread.currentThread().getId();
                int before = variableLocal.get();
                increment();
                int after = variableLocal.get();
                System.out.println("threadid " + threadId + "  before " + before + ", after " + after);
                variableLocal.remove();
            });
        }

        executorService.shutdown();
    }


}