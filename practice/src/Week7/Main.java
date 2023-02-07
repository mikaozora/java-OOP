package Week7;

public class Main {
    public static void main(String[] args) {

    }

    /*
     * class vs abstract class vs interface
     * abstract class -> suatu class yang memiliki method yang belum di definisikan, variable bisa constant atau tidak,
                         cuma bisa extends satu kali (turunannya cuma boleh punya 1 parent)
     * interface -> semua methodnya adalah abstract, semua variable constant
                    implement -> boleh lebih dari 1
     *
     */
    public void start(){
        Iinterface1 i = new Coba();
        i.method1();
    }

    interface Iinterface{
        void method1();
        int constanta1 = 1;

    }
    interface Iinterface2{
        void method3();
        int constanta3 = 1;

    }

    interface Iinterface1 extends Iinterface, Iinterface2{
        void method2();
        int constanta2 = 5;

    }

    class ParentCoba{
        int a;
    }

    class Coba extends ParentCoba implements Iinterface1{

        @Override
        public void method2() {

        }


        @Override
        public void method1() {

        }

        @Override
        public void method3() {

        }
    }
}
