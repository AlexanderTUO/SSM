package com.tyk.demo;

import java.util.stream.IntStream;

public class StorageTest {
    public static void main(String[] args) {
        Storage storage = new Storage(10);
//        IntStream.range(0,9)
//                .forEach(i->new Thread(new Producer(storage),"Thread"+i).start());
//
//        IntStream.range(0,4)
//                .forEach(i->new Thread(new Consumer(storage),"Thread"+i).start());
        for (int i = 0; i < 5; i++) {
            new Thread(new Producer(storage), "Thread:Producer" + i).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(new Consumer(storage), "Thread:Consumer" + i).start();
        }
    }
}
