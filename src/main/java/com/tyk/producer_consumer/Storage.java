package com.tyk.producer_consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {
    private int maxSize;
    private List<Object> buffer;
    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public Storage(int maxSize) {
        this.maxSize = maxSize;
        this.buffer = new ArrayList<>();
    }

    public void put() {
        try {
            while (true) {
                lock.lock();
                while (buffer.size() == maxSize) {
                    System.out.println("仓库产品满了，等待消费");
                    notFull.await();
                }
                buffer.add(new Object());
                System.out.println(Thread.currentThread().getName()+"生产了一个产品,现在产品数量为"+buffer.size());
                Thread.sleep(1000);
                notEmpty.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            while (true) {
                while (buffer.isEmpty()) {
                    System.out.println("仓库产品没了，等待生产");
                    notEmpty.await();
                }
                buffer.remove(0);
                System.out.println(Thread.currentThread().getName()+"消费了一个产品,现在产品数量为"+buffer.size());
                Thread.sleep(1000);
                notFull.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
