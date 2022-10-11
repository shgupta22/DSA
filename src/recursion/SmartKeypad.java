package recursion;

public class SmartKeypad {

    static String[] keypad = new String[]{"","","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};

    public static void smartKeyboard(String  input, String output, int i) {
        if (i == input.length()) {
            System.out.print(output+"|");
            return;
        }
        //recursive
        int currentDigit = input.charAt(i) - '0';
        if (currentDigit ==1 || currentDigit ==0){
            smartKeyboard(input, output, i+1);
        }

        //keypad
        for (int k=0; k < keypad[currentDigit].length();k++) {
            smartKeyboard(input, output+keypad[currentDigit].charAt(k), i+1);
        }
    }

    public static void main(String[] args) {
        smartKeyboard("23", "", 0);
        System.out.println("\n*******");
        smartKeyboard("34","",0);
        System.out.println("\n*******");
        smartKeyboard("1345","",0);
    }
}
