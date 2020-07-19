package ru.shamma.lesson3;

public class Main {
    private final Object monitor = new Object();
    private String string = "ping";

    public static void main(String[] args) {
        Main main = new Main();
        Thread thread1 = new Thread(() -> main.printPing());
        Thread thread2 = new Thread(() -> main.printPong());
        thread1.start();
        thread2.start();
    }

    public void printPing() {
        synchronized (monitor) {
            for (int i = 0; i < 10; i++) {
                try {
                    while (!string.equals("ping")) {
                        monitor.wait();
                    }
                    Thread.sleep(300);
                    System.out.println("ping");
                    string="pong";
                    monitor.notify();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void printPong() {
        synchronized (monitor) {
            for (int i = 0; i < 10; i++) {
                try {
                    while (!string.equals("pong")) {
                        monitor.wait();
                    }
                    Thread.sleep(300);
                    System.out.println("pong");
                    string="ping";
                    monitor.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
