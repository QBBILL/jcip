package net.jcip.examples;

public class Main {

    LoggingWidget loggingWidget = new LoggingWidget();

    class ThreadObj extends Thread {
        @Override
        public void run() {
            try {
                loggingWidget.doSomething();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    /*String lockObj = "lockMe";

    void testSynMethod() throws InterruptedException {
        synchronized (lockObj) {
            System.out.println(Thread.currentThread().getName());
            //确保两个另一线程也进入了此方法
            Thread.currentThread().sleep(2000);
            throw new RuntimeException("i am an Exception");
        }
    }*/

    public static void main(String[] args) {
        Main m = new Main();
        Main.ThreadObj t1 = m.new ThreadObj();
        t1.setName("thread1");
        Main.ThreadObj t2 = m.new ThreadObj();
        t2.setName("thread2");
        t1.start();
        t2.start();
    }
}