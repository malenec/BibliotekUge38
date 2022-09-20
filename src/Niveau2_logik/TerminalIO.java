package Niveau2_logik;

import java.util.Scanner;

public class TerminalIO {

    public static String getString(String s) {
        System.out.println(s);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int getInt(String s) {
        while (true) {
            try {
                int svar = Integer.parseInt(getString(s));
                return svar;
            } catch (NumberFormatException e) {
                System.out.println("Skriv det med tal, ikke bogstaver");
            }
        }
    }

}
