package practice.Generic;

import practice.Generic.utils.MyData;

public class WildcardApp {

    /**
     * bebas menerima type parameter apapun.
     *
     */
    public static void main(String[] args) {
        MyData<Integer> data1 = new MyData<>(100);
        MyData<String> data2 = new MyData<>("mika");
        MyData<MultipleConstraintApp.Manager> data3 = new MyData<>(new MultipleConstraintApp.Manager("gata"));
        printData(data1);
        printData(data2);
        printData(data3);
    }
    public static void printData(MyData<?> data){
        System.out.println(data.getData());
    }
}
