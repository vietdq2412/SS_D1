package org.example.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("C:\\Users\\vietd\\Desktop\\S\\SS\\W_01\\IOnumber\\src\\main\\java\\org\\example\\test\\data"));
//            System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\vietd\\Desktop\\S\\SS\\W_01\\IOnumber\\src\\main\\java\\org\\example\\OutputData")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(System.in);
        int tcNum = scanner.nextInt();

        for (int i = 1; i <= tcNum; i++) {
            int begin = scanner.nextInt();
            int end = scanner.nextInt();
            boolean isAnyNum = false;
            System.out.print("#" + i + " ");
            for (int j = begin; j <= end; j++) {
                if (checkSCP(j) && checkTong(j) && checkSoChan(j)) {
                    isAnyNum = true;
                    System.out.print(j + " ");
                }
            }
            if (!isAnyNum) System.out.println("NO NUMBER");
            System.out.println();
        }
    }

    public static boolean checkTong(int num) {
        int sum = 0;
        while (true) {
            int left = num % 10;
            sum += left;
            if (num / 10 == 0) break;
            num = num / 10;
        }
        if (sum > 5) return true;
        return false;
    }

    public static boolean checkSCP(int num) {
        int temp = (int) Math.sqrt(num);
        if (temp * temp == num) return true;
        return false;
    }

    public static boolean checkSoChan(int num) {
        if (num % 2 == 0) return true;
        return false;
    }
}
