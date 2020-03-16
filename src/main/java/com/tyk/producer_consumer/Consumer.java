package com.tyk.producer_consumer;

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
