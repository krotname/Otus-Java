package ru.otus.hw33executors;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PrintOneToOne {

    private final Lock lock = new ReentrantLock();
    private final AtomicInteger integer = new AtomicInteger(1);
    private final AtomicLong threadId = new AtomicLong();
    private final AtomicInteger counter = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        PrintOneToOne printOneToOne = new PrintOneToOne();

        Thread t0 = new Thread(printOneToOne::count);
        Thread t1 = new Thread(printOneToOne::count);

        t0.start();
        t1.start();
        t0.join();
        t1.join();

        long end = System.currentTimeMillis();
        System.out.println("time taken " + (end - start) + " milliseconds");
    }

    private void count() {
        while (integer.get() < 10) {
            print(Type.INC);
        }
        while (integer.get() > 1) {
            print(Type.DEC);
        }
    }

    private void print(Type type) {
        if (threadId.get() != Thread.currentThread().getId()) {
            lock.lock();
            try {
                log.info(String.valueOf(integer.get()));
                counter.getAndIncrement();
            } finally {
                threadId.set(Thread.currentThread().getId());
                if (counter.get() == 2) {
                    if (Type.INC.equals(type)) {
                        integer.incrementAndGet();
                    } else {
                        integer.decrementAndGet();
                    }
                    counter.set(0);
                }
                lock.unlock();
            }
        }
    }

    enum Type {INC, DEC}
}
