package practice.Generic;

import practice.Generic.utils.MyData;

public class GenericClassApp {
    public static void main(String[] args) {
        //single param
        MyData<String> data1 = new MyData<>("mika");
        MyData<Integer> data2 = new MyData<>(100);

        System.out.println(data1.getData());
        System.out.println(data2.getData());

        //multiple param type
        Pair<String, Integer> data3 = new Pair<>("Aryo", 500);
        Pair<Integer, Integer> data4 = new Pair<>(200, 300);
        System.out.println("first: " + data3.getFirst() + ", Second: " + data3.getSecond());
        System.out.println("first: " + data4.getFirst() + ", Second: " + data4.getSecond());
    }
}
