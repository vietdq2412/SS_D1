package org.example.soNen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("C:\\Users\\vietd\\Desktop\\S\\SS\\W_01\\IOnumber\\src\\main\\java\\org\\example\\soNen\\data"));
//            System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\vietd\\Desktop\\S\\SS\\W_01\\IOnumber\\src\\main\\java\\org\\example\\OutputData")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(System.in);
        int tcNum = scanner.nextInt();

        for (int i = 1; i <= tcNum; i++) {
            int num = scanner.nextInt();
            int sum = 0;
            while (true) {
                while (true) {
                    int last = num % 10;
                    sum += last;
                    if (num / 10 == 0) break;
                    num = num / 10;
                }
                if (sum / 10 > 0) {
                    num = sum;
                    sum = 0;
                } else break;
            }
            System.out.println("#" + i + " " + sum);
        }
    }
}
