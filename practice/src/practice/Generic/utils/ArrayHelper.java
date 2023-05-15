package practice.Generic.utils;

public class ArrayHelper {
    public static <T> int count(T[] array){
        return array.length;
    }

    public static <T> T viewData(T[] array, int index){
        return array[index];
    }
}
