package cn.zlb.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Throughput：整体吞吐量，每秒执行了多少次调用，单位为 ops/time
 * AverageTime：用的平均时间，每次操作的平均时间，单位为 time/ops
 * SampleTime：随机取样，最后输出取样结果的分布
 * SingleShotTime：只运行一次，往往同时把 Warmup 次数设为 0，用于测试冷启动时的性能
 * All：上面的所有模式都执行一次
 */
@BenchmarkMode({Mode.AverageTime, Mode.Throughput})
/**
 * iterations：预热的次数
 * time：每次预热的时间
 * timeUnit：时间的单位，默认秒
 * batchSize：批处理大小，每次操作调用几次方法
 *
 * 为什么需要预热？
 * 因为 JVM 的 JIT 机制的存在，如果某个函数被调用多次之后，JVM 会尝试将其编译为机器码，从而提高执行速度，
 * 所以为了让 benchmark 的结果更加接近真实情况就需要进行预热
 */
@Warmup(iterations = 2, time = 1)
/**
 * 实际调用方法所需要配置的一些基本测试参数，可用于类或者方法上，参数和 @Warmup 相同。
 */
@Measurement(iterations = 2, time = 1)
/**
 * 每个进程中的测试线程，可用于类或者方法上
 */
@Threads(2)
/**
 * 进行 fork 的次数，可用于类或者方法上。如果 fork 数是 2 的话，则 JMH 会 fork 出两个进程来进行测试
 */
@Fork(1)
/**
 * Scope.Benchmark：所有测试线程共享一个实例，测试有状态实例在多线程共享下的性能
 * Scope.Group：同一个线程在同一个 group 里共享实例
 * Scope.Thread：默认的 State，每个测试线程分配一个实例
 */
@State(value = Scope.Benchmark)
/**
 * 为统计结果的时间单位，可用于类或者方法注解
 */
@OutputTimeUnit(TimeUnit.SECONDS)
public class StringConnectTest {
    /**
     * 指定某项参数的多种情况，特别适合用来测试一个函数在不同的参数输入的情况下的性能，
     * 只能作用在字段上，使用该注解必须定义 @State 注解
     */
    @Param(value = {"10", "50"})
    private int length;

    @Benchmark
    public void testStringAdd(Blackhole blackhole) {
        String a = "test";
        for (int i = 0; i < length; i++) {
            a += i;
        }
        blackhole.consume(a);
    }

    @Benchmark
    public void testStringBuilderAdd(Blackhole blackhole) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(i);
        }
        blackhole.consume(sb.toString());
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StringConnectTest.class.getSimpleName())
                .result("src/main/java/cn/zlb/jmh/result.json")
                .resultFormat(ResultFormatType.JSON).build();
        new Runner(opt).run();
    }
}