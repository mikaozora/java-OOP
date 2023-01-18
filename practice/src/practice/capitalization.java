package practice;

public class capitalization {

    static void checkCapital(String str){
        String[] strArr = str.split(" ", 2);
        boolean result = true;
        for (int i = 0; i < 2; i++) {
            char [] charStr = strArr[i].toCharArray();
            if(!Character.isUpperCase(charStr[0])){
                result = false;
            }
        }
        if(result){
            System.out.println("2 Word Capital");
        }else{
            System.out.println("No Capital");
        }
    }
    public static void main(String[] args) {
        String str = "Nathan poris";
        checkCapital(str);
    }
}
