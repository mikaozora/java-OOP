package practice.Generic;

import practice.Generic.utils.MyData;

public class ContraVariantApp {

    /**
     * contravariant adalah kebalikan dari covariant
     * pram type yg diterima adalah superclass dari class tersebut.
     * contoh seperti di bawah. karena object adalah superclass dari String, maka tidak ada error
     * pada contravariant bisa mengubah data tetapi, harus berhati-hati saat get data
     */
    public static void main(String[] args) {
        MyData<Object> data1 = new MyData<>("mikka");
        process(data1);

        System.out.println(data1.getData()); //di sini aman
    }
    public static void process(MyData<? super String> data){
//        String value = (String) data.getData(); // typecast seperti ini berbahaya, karena jika ternyata data yg dikirim integer maka akan error
        Object value = data.getData(); //lebih aman seperti ini
        System.out.println(value);
        data.setData("gata");
    }
}
