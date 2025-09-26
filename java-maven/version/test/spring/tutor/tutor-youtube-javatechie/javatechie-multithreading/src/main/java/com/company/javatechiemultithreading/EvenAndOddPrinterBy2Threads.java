package com.company.javatechiemultithreading;

public class EvenAndOddPrinterBy2Threads implements Runnable {

    private static int count = 1;
    final Object object;

    public EvenAndOddPrinterBy2Threads(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        while (count <= 100) {
            if (count % 2 == 0 && Thread.currentThread().getName().equals("even")) {
                synchronized (object) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " value: " + count);
                    count++;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            if (count % 2 != 0 && Thread.currentThread().getName().equals("odd")) {
                synchronized (object) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " value: " + count);
                    count++;
                    object.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        Runnable r1 = new EvenAndOddPrinterBy2Threads(lock);
        Runnable r2 = new EvenAndOddPrinterBy2Threads(lock);
        Thread t1 = new Thread(r1, "even");
        Thread t2 = new Thread(r2, "odd");
        t1.start();
        t2.start();
    }
}
