package practice.Generic;

public class MultipleConstraintApp {
    public static void main(String[] args) {
//        Data<Manager> manager = new Data<>("mika"); // error karena class manager tidak implement interface sayHello
        Data<VP> vp = new Data<>(new VP("gata"));
        vp.getData().saying();
    }

    public static interface sayHello{
        void saying();
    }
    public static abstract class Employee{

    }

    public static class Manager extends Employee{
        private String name;
        public Manager(String name){
            this.name = name;
        }
        @Override
        public String toString() {
            return "name: " + this.name;
        }
    }

    public static class VP extends Employee implements sayHello{
        private String name;
        public VP(String name){
            this.name = name;
        }
        @Override
        public void saying() {
            System.out.println("VP: " + this.name);
        }

    }
    public static class Data<T extends Employee & sayHello>{
        // & adalah pengganti implement. jika ingin banyak implement method berarti & interface1 & interface2 ....
        private T data;
        public Data(T data){
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}
