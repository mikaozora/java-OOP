package practice.Generic;

import practice.Generic.utils.NumberData;

public class ConstraintApp {
    // bounded parameter type

    /**
     * bounded parameter type adalah membuat parameter type dengan batasan. contoh seperti Number, String
     * Jadi, yg parameter type yg bisa diterima hanya turunan dari batas tersebut
     */
    public static void main(String[] args) {
        NumberData<Integer> data1 = new NumberData<>(50);
        System.out.println(data1.getData());

        NumberData<Double> data2 = new NumberData<>(10.57);
        System.out.println(data2.getData());
//        NumberData<String> data3 = new NumberData<String>("mika"); //error karena String bukan turunan Number
    }
}

