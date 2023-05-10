package practice.Thread;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("This Thread Interupted!");
                throw new RuntimeException(e);
//                e.printStackTrace(); // ini ga menghentikan thread. hanya mengirim error message
            }
        }
        try{
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " Exiting.");
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }
}
