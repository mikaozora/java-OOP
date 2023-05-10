package practice.UAC;

public class ActivityUI implements Activity, Runnable{
    private Thread backgroundThread;
    public ActivityUI(Thread backgroundThread){
        this.backgroundThread = backgroundThread;
    }
    @Override
    public void onCreate() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + ": onCreate()");
    }

    @Override
    public void onStart() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + ": onStart()");
        System.out.println(Thread.currentThread().getName() + ": === Show Splash Screen ===");
    }

    @Override
    public void onResume() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + ": onResume()");
        System.out.println(Thread.currentThread().getName() + ": === Load Main Page ===");
        backgroundThread.start();
        try {
            backgroundThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + ": === Show Content ===");
    }

    @Override
    public void onPause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + ": onPause()");
    }

    @Override
    public void onStop() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + ": onStop()");
    }

    @Override
    public void onRestart() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + ": onRestart()");
    }

    @Override
    public void onDestroy() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + ": onDestroy()");
    }

    @Override
    public void run() {
        onCreate();
        onStart();
        onResume();
        onPause();
        onStop();
        onDestroy();
    }
}
