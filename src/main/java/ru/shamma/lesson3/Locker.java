package ru.shamma.lesson3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Locker {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 10; i++) {
            service.execute(count::increment);
            Thread.sleep(100);
        }
        service.shutdown();
        System.out.println("i = " + count.getA());
    }
}


