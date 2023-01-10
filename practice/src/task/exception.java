package task;

import javax.print.attribute.standard.MediaSize;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class exception {

    static void NPE(String a) {
        System.out.println(a.toUpperCase());
    }

    static void NFE(String a) {
        int x = Integer.parseInt(a);
        System.out.println(x);
    }

    static void IAE(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("number must be positive");
        }
    }

    static void AIOBE(int index) {
        int[] arr = new int[3];
        arr[0] = 10;
        System.out.println(arr[index]);
    }

    static void AE(int num) {
        System.out.println(num / 0);
    }

    static void NAE(int a) {
        int[] arr = new int[a];
    }

    static void PE(String a) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date date;
        try {
            date = dateFormat.parse(a);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    static void UOE(){
        Integer[] data = {1,2,3,4,5};
        List<Integer> list = Arrays.asList(data);
        list.add(new Integer(0));
    }

    static void NSEE(){
        List<Integer> list= new ArrayList<Integer>();
        Iterator<Integer> iterasi = list.iterator();
        System.out.println(iterasi.next());
    }

    static void ASE(){
        Object[] arr = new String[2];
        arr[0] = 10;
    }
    public static void main(String[] args) {
//        NPE(null);
//        NFE("");
//        IAE(-10);
//        AIOBE(3);
//        AE(10);
//        NAE(-1);
//        PE("2021 09 10");
//        UOE();
//        NSEE();
//        ASE();
    }
}
