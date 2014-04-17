package pro.tremblay;

import org.easymock.EasyMock;
import org.mockito.Mockito;
import org.openjdk.jmh.annotations.*;

import java.lang.reflect.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Fork(2)
@Warmup(iterations = 4, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class Demo4 {

    private Class<?> anInterface = List.class;

    @GenerateMicroBenchmark
    public Object listWithProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(), new Class<?>[] {anInterface},
                (proxy, method, args) -> null);
    }

    @GenerateMicroBenchmark
    public Object listWithEasyMock() {
        return EasyMock.createMock(anInterface);
    }

    @GenerateMicroBenchmark
    public Object listWithMockito() {
        return Mockito.mock(anInterface);
    }
}
