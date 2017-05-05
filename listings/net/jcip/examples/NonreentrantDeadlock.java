package net.jcip.examples;

/**
 * NonreentrantDeadlock
 * <p/>
 * Code that would deadlock if intrinsic locks were not reentrant
 *
 * @author Brian Goetz and Tim Peierls
 */

class Widget {
    public synchronized void doSomething() throws InterruptedException {
        System.out.println("Widget doSomething");
        Thread.sleep(5000);
    }
}
class LoggingWidget extends Widget {
    public synchronized void doSomething() throws InterruptedException {
        System.out.println(toString() + ": calling doSomething");
        Thread.sleep(5000);
        super.doSomething();
        System.out.println("super method exist");
        Thread.sleep(5000);
    }
}
