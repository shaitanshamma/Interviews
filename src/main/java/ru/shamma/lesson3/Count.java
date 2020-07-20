package ru.shamma.lesson3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Count {
    private int a = 0;
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            System.out.println("Поток - пытается" + Thread.currentThread().getName());
            a++;
        } finally {
            lock.unlock();
            System.out.println("Поток - освободил " + Thread.currentThread().getName());
        }
    }

    public int getA() {
        return a;
    }
}

