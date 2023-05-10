package practice.UAC;

public class main {
    public static void main(String[] args) throws InterruptedException {
        NetworkOperation networkOperation = new NetworkOperation();
        Thread networkThread = new Thread(networkOperation, "Network Operation");
        ActivityUI activityUI = new ActivityUI(networkThread);
        Thread UIThread = new Thread(activityUI, "ActivityUI");

        System.out.println("Main Thread Starting...");
        Thread.sleep(1000);
        UIThread.start();
        UIThread.join();
        Thread.sleep(1000);
        System.out.println("Main Thread Exiting...");
    }
}
