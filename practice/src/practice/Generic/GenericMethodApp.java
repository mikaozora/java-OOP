package practice.Generic;

import practice.Generic.utils.ArrayHelper;

public class GenericMethodApp {
    public static void main(String[] args) {
        String[] arr1 = {"mika", "bijo", "Aryo"};
        Integer[] arr2 = {1,2,3,4,5,6};
        System.out.println(ArrayHelper.<String>count(arr1));
        System.out.println(ArrayHelper.count(arr2));

        String str1 = ArrayHelper.viewData(arr1, 2);
        Integer num1 = ArrayHelper.viewData(arr2, 4);
        System.out.println(str1);
        System.out.println(num1);
    }
}
