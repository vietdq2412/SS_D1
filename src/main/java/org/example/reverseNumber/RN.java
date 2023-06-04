package org.example.reverseNumber;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RN {
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("C:\\Users\\vietd\\Desktop\\S\\SS\\W_01\\IOnumber\\src\\main\\java\\org\\example\\reverseNumber\\data"));
//            System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\vietd\\Desktop\\S\\SS\\W_01\\IOnumber\\src\\main\\java\\org\\example\\OutputData")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(System.in);
        int tcNum = scanner.nextInt();
        for (int i = 1; i <= tcNum; i++) {
            int n = scanner.nextInt();
            int sum = 0;
            while (true) {
                int left = n % 10;
                System.out.print(left + " ");
                sum += left;
                if (n / 10 == 0) break;
                n = n / 10;

            }
            System.out.println("- Sum: "+ sum);
            System.out.println();
        }
    }
}
