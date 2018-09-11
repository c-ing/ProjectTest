package com.java.java_8_in_action.chapter7_of_action_java_8;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by cdc on 2018/4/23.
 */
public class PerformanceTest {

    public long measureSumPerf(Function<Long, Long> addr, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i =0; i<10; i++) {
            long start = System.nanoTime();
            long sum = addr.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            //System.out.println("Result:" + sum);
            if (duration < fastest) {fastest = duration;}
        }
        return fastest;
    }

    //1
    public static long sequentialSum(long n) {
        return Stream.iterate(1L,i -> i + 1)
                .limit(n)
                .reduce(0L,Long::sum);
    }

    //2
    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    //3
    public static long parellelSum(long n) {
        return Stream.iterate(1L, i -> i+1)
                .limit(n)
                .parallel()
                .reduce(0L,Long::sum);
    }

    //4
    public static long rangSum(long n) {
        return LongStream.rangeClosed(1,n)
                .reduce(1L,Long::sum);
    }

    //5
    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        PerformanceTest pt = new PerformanceTest();
        System.out.println("Sequential sum done in: " +
            pt.measureSumPerf(PerformanceTest::sequentialSum,1_000_000) + " msecs");

        System.out.println("Iterative sum done in: " +
                pt.measureSumPerf(PerformanceTest::iterativeSum, 1_000_000) + " msecs");

        System.out.println("Paraller sum done in: " +
            pt.measureSumPerf(PerformanceTest::parellelSum,1_000_000) + " msecs");

        System.out.println("rangSum sum done in: " +
            pt.measureSumPerf(PerformanceTest::rangSum,1_000_000));

        System.out.println("ParallerRangSum sum done in: " +
            pt.measureSumPerf(PerformanceTest::parallelRangedSum,1_000_000));
    }
}
