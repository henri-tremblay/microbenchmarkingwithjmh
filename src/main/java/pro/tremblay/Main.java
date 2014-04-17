package pro.tremblay;

import org.easymock.EasyMock;
import org.mockito.Mockito;

import java.util.List;

public class Main {

    private static final int LOOPS = 1_000_000;

    public static void main(String[] args) {
        easyMockBench();
        mockitoBench();
        easyMockBench();
        mockitoBench();
    }

    private static void easyMockBench() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < LOOPS; i++) {
            EasyMock.createMock(List.class);
        }
        long end = System.currentTimeMillis();
        System.out.println("EasyMock: " + (end - start) + "ms");
    }

    private static void mockitoBench() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < LOOPS; i++) {
            Mockito.mock(List.class);
        }
        long end = System.currentTimeMillis();
        System.out.println("Mockito: " + (end - start) + "ms");
    }
}
