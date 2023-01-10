package Week3;

import java.util.*;

public class Main {
     static Scanner input = new Scanner(System.in);
    static void arrList(){
        int[] arr = new int[3];
//        System.out.println(arr.length);
//        Scanner input = new Scanner(System.in);
//        for(int i = 0; i < arr.length; i++){
//            arr[i] = input.nextInt();
//        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }

        int[][] arrTwo = new int[3][3]; //dua dimensi
        ArrayList<Integer> score = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            score.add((int) (1 + Math.random() * 10));
        }

//        score.set(0, 10);
        score.sort((a, b) -> a - b);   // a - b = asc, b - a = desc or a > b ? 1 : (a < b ? -1 : 0)
//        Collections.sort(score, Collections.reverseOrder()); // desc
//        Collections.sort(score);  // asc
        for (int i = 0; i < score.size(); i++) {
            System.out.println(score.get(i));
        }
        System.out.println("-------------");
//        score.remove(7); // by index
//        score.remove(Integer.valueOf(10)); // by element
        score.removeIf(a -> a < 5);
//        score.clear(); // == removeAll()
//        score.removeAll(score);
        for (int i = 0; i < score.size(); i++) {
            System.out.println(score.get(i));
        }
    }

    static void vec(){
        Vector<String> vector = new Vector<>();
        vector.add("John Doe");
        vector.add(0, "Rudi Hartono");
        System.out.println(vector.get(0));
        vector.set(0, "Jason Joel");
        System.out.println(vector.get(0));
        System.out.println(vector.size());
        System.out.println(vector.capacity());
    }

    public static void main(String[] args) {
//        arrList();
        vec();
    }
}
