package practice.Generic;

import practice.Generic.utils.MyData;

public class CovariantApp {
    /**
     * covariant bisa menerima param type dengan syarat merupakan turunan dari class tersebut.
     * contoh seperti di bawah, karena String merupakan turunan dari object maka diterima
     * kekurangan dari covariant adalah tidak bisa mengubah data, karena bisa berbahaya jika data yg baru berbeda tipe data
     */
    public static void main(String[] args) {
        MyData<String> data1 = new MyData<>("mika");
        process(data1);
    }
    public static void process(MyData<? extends Object> data){
        System.out.println(data.getData());
//        data.setData("aryo");
    }
}
