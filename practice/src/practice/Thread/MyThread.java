package practice.Thread;

public class MyThread extends Thread{
    private String name;
    public MyThread(String name){
        this.name = name;
        this.setName(name);
    }
    public void run(){
//        System.out.println(Thread.currentThread().getState());
        for (int i = 1; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
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
