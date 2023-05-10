package practice.Generic;

import practice.Generic.utils.MyData;

public class InvariantApp {
    public static void main(String[] args) {
        MyData<String> data1 = new MyData<>("mika");
//        doIt(data1); //error karena beda param type
//        MyData<Integer> data2 = data1; // error
        // hanya bisa param type yg sama, inheritance dan polymorphism param type tidak berpengaruh
    }
    public static void doIt(MyData<Object> obj){
        return;
    }
}
