package practice.Thread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new MyThread("Thread One");
        MyRunnable runnable1 = new MyRunnable();
        Thread thread2 = new Thread(runnable1);
        Thread thread3 = new MyThread("Thread Three");
        thread2.setName("Thread two");
//        System.out.println("New Thread: " + thread1);

//        System.out.println(thread1.getState());
//        thread1.setPriority(1);
//        thread2.setPriority(9);
//        thread3.setPriority(1);
        thread2.setDaemon(true); //ketika diubah menjadi daemon thread, maka tidak akan ditunggu sampai selesai jika semua user thread selesai
        thread1.start();
        thread2.start();
        thread3.start();
//        thread2.sleep(7000);
//        thread2.interrupt();
        thread1.join();
//        thread2.join();
        thread3.join();
//        System.out.println(thread1.getState());
        Thread.sleep(1000);
        System.out.println("Main Exiting.");
    }
}
