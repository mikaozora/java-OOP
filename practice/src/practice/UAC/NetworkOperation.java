package practice.UAC;

public class NetworkOperation implements Activity, Runnable{
    private boolean isRestart;
    public NetworkOperation(){
        this.isRestart = true;
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
        System.out.println(Thread.currentThread().getName() + ": === Create Connection ===");
    }

    @Override
    public void onResume() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + ": onResume()");
        System.out.println(Thread.currentThread().getName() + ": === Download Content ===");
    }

    @Override
    public void onPause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + ": onPause()");
        if(isRestart){
            System.out.println(Thread.currentThread().getName() + ": === Prompt for Failed Download ===");
//            this.isRestart = false;
        }else{
            System.out.println(Thread.currentThread().getName() + ": === Prompt for Succeed Download ===");
        }

    }

    @Override
    public void onStop() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + ": onStop()");
        System.out.println(Thread.currentThread().getName() + ": === Close Connection ===");
    }

    @Override
    public void onRestart() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + ": onRestart()");
        this.isRestart = false; //karena di soal hanya butuh sekali loop
        onStart();
        onResume();
        onPause();
        onStop();
        if(isRestart){
            onRestart();
        }else{
            onDestroy();
        }
    }

    @Override
    public void onDestroy() {
        System.out.println(Thread.currentThread().getName() + ": onDestroy()");
    }

    @Override
    public void run() {
        onCreate();
        onStart();
        onResume();
        onPause();
        onStop();
        if(isRestart){
            onRestart();
        }else{
            onDestroy();
        }
    }
}
