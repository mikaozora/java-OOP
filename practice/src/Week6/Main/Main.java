package Week6.Main;

import Week6.Pion;
import Week6.Sel;
import Week6.WarnaEnum;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
        overloading
        - nama function sama
        - parameter berbeda

        overriding
        - nama function sama
        - beda class

        1. abstract class -> class yang memiliki abstract method
        2. abstract method -> method yang belum dijelaskan
        3. Interface -> semua methodnya adalah abstract
                     -> semua atributnya constant
         */
//        Perwira p = new Perwira('A', 1, WarnaEnum.putih);
        Pion pion = new Pion('A', 2, WarnaEnum.putih);
        ArrayList<Sel> jalan = pion.kemungkinanJalan();
        for (Sel sel : jalan) {
            System.out.println(sel.col + "" + sel.row);
        }
    }
}
