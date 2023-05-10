package practice.Generic;

import practice.Generic.utils.MyData;

public class TypeErasureApp {

    /**
     * typerasure bertujuan untuk menghapus penulisan parameter type saat deklarasi generic class (line 10)
     *
     */
    public static void main(String[] args) {
        MyData data = new MyData<>("mika");
        MyData<Integer> data2 = (MyData<Integer>) data;
        Integer val = data2.getData();
        System.out.println(val); // error saat di run, karena data(string) sedangkan data2(integer)
    }
}
