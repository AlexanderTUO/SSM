package com.tyk.demo;

public class Producer implements Runnable{
    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
//        while (true) {
            storage.put();
//        }
    }
}
