package org.example.utils;

public class Counter implements AutoCloseable{
    static int sum;

    public void add() {
        sum++;
    }

    @Override
    public void close() throws Exception {
        System.out.println("Counter is closed");
    }
}
