package Week14;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int []angka = new int[]{1,2,3,4,5,6,7,8,9,10};
        int total = Arrays.stream(angka).filter(a -> a%2 == 1).reduce(0, Integer::sum);
        int total2 = Arrays.stream(angka).filter(a -> a%2 == 1).sum();
        System.out.println(total);
        System.out.println(total2);

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        lists.add((new ArrayList<>(Arrays.stream(new Integer[]{1,2,3}).toList())));
        lists.add((new ArrayList<>(Arrays.stream(new Integer[]{4,5,6}).toList())));
        List<Integer> merge = lists.stream().flatMap(Collection::stream).toList();
        for(int a:merge){
            System.out.println(a);
        }
        List<Integer> dis = Arrays.stream(new int[]{1,1,2,2,3,3,4,4}).distinct().boxed().toList();
        System.out.println(dis.stream().map(Object::toString).reduce((a, b) -> a + ", " + b));
    }
}
