package org.example.sochinhphuong;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("C:\\Users\\vietd\\Desktop\\S\\SS\\W_01\\IOnumber\\src\\main\\java\\org\\example\\sochinhphuong\\data"));
//            System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\vietd\\Desktop\\S\\SS\\W_01\\IOnumber\\src\\main\\java\\org\\example\\OutputData")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(System.in);
        int tcNum = scanner.nextInt();

        for (int i = 1; i <= tcNum; i++) {
            int begin = scanner.nextInt();
            int end = scanner.nextInt();
            boolean check = false;
            System.out.print("#" + i);
            System.out.print(" ");
            for (int j = begin; j <= end; j++) {
                if (checkSCP(j) || j == 1) {
                    check = true;
                    System.out.print(j);
                    System.out.print(" ");
                }
            }
            if (!check) System.out.print("NO NUMBER");
            System.out.println();
        }
    }

    public static boolean checkSCP(int num) {
        int temp = (int) Math.sqrt(num);
        if (temp * temp == num) return true;
        return false;
    }
}
