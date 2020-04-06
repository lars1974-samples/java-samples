package com.company;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        System.out.print("interrupt: ");
        Thread taskThread1 = new Thread(Main.createTask(true));
        taskThread1.start();
        Thread.sleep(3_500);
        taskThread1.interrupt();
        Thread.sleep(500);
        System.out.print("\nno interrupt: ");
        Thread taskThread2 = new Thread(Main.createTask(false));
        taskThread2.start();
        Thread.sleep(3_500);
        taskThread2.interrupt();
    }

    public static Runnable createTask(boolean interrupt) {
        return () -> {
            for (int i = 0; i < 10; i++) {
                System.out.print(i);
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    if(interrupt) Thread.currentThread().interrupt();
                }
            }
        };
    }
}
