package com.tyk.demo;

public class Consumer implements Runnable{
    private Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
//        while (true) {
            storage.get();
//        }
    }
}
