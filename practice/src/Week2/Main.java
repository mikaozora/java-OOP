package Week2;

public class Main {
    public static void main(String[] args) {
        Integer a = 7;
        // kelebihan wrapper = memiliki function sendiri seperti doubleValue() dll
        int b = Integer.MAX_VALUE;
        System.out.println(Math.pow(a, 2));

        // string compare
        String str = new String("hello world");
        System.out.println(str == "hallo");
        System.out.println(str.equals("hallo"));

        // split string
        String[] c = str.split(" ");
        System.out.println(c[0]);

        // string contains
        System.out.println(str.contains("al")); // true or false

        // string uppercase
        char[] kata = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                kata[i] = Character.toUpperCase(kata[i]);
            }
        }
        String newKata = new String(kata);
        System.out.println(newKata);

        // string replace
        String str2 = str.replaceFirst("e", "E");
        System.out.println(str2);

        // math random
        int high = 10;
        int low = 1;
        int range = high - low + 1;
        int rand = (int) (Math.random() * range) + low; // atau
        int rand2 = (int) (1 + Math.random() * 10);
        System.out.println(rand);
        System.out.println(rand2);
    }
}
