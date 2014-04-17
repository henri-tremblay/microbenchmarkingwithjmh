package pro.tremblay;

import org.openjdk.jmh.annotations.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Fork(1)
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 2, time = 2, timeUnit = TimeUnit.SECONDS)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class Demo3 {

    private int a = 1, b = 2;

    @GenerateMicroBenchmark
    public void baseline() {
    }

    @GenerateMicroBenchmark
    public int benchMax() {
        return max(a,b);
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
}
