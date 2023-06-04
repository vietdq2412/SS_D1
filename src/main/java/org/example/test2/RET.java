package org.example.test2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RET {
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("C:\\Users\\vietd\\Desktop\\S\\SS\\W_01\\IOnumber\\src\\main\\java\\org\\example\\test2\\data"));
//            System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\vietd\\Desktop\\S\\SS\\W_01\\IOnumber\\src\\main\\java\\org\\example\\OutputData")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(System.in);
        int tcNum = scanner.nextInt();

        for (int i = 1; i <= tcNum; i++) {
            int size = scanner.nextInt();
            int[][] arr = new int[size][size];
            System.out.println("#" + i);
            fillMatrix(arr, size);
            printMatrix(arr);
        }
    }

    private static void fillMatrix(int[][] arr, int size) {
        int c = 0;
        int[] position = new int[]{0, size / 2};
        for (int i = 1; i <= size * size; i++) {
            int doc = position[0];
            int ngang = position[1];
            arr[doc][ngang] = i;
            position = getPosition(arr, position);
            //getPosition(arr, position);
        }
    }

    public static int[] getPosition(int[][] arr, int[] prePosition) {
        int ngang = prePosition[1];
        int doc = prePosition[0];
        int size = arr.length;
        int[] nextPosition = new int[2];

        if (ngang != 0) {
            if (doc != size - 1) { //pos y không ở đáy
                nextPosition = qt11(arr, ngang, doc);
            } else { //pos y ở đáy
                nextPosition = qt12(arr, ngang, doc);
            }
        } else {
            if (doc != size - 1) {
                ngang = size - 1;
                doc = doc + 1;
            } else {
                ngang = size - 1;
                doc = 0;
            }
            nextPosition[0] = doc;
            nextPosition[1] = ngang;
            if (arr[doc][ngang] != 0) {
                nextPosition = qt2(arr, prePosition[1], prePosition[0]);
            }
        }
        return nextPosition;
    }

    public static int[] qt11(int[][] arr, int ngang, int doc) {
        int[] nextPosition = new int[2];
        if (arr[doc + 1][ngang - 1] == 0) {
            nextPosition[0] = doc + 1;
            nextPosition[1] = ngang - 1;
        } else {
            nextPosition = qt2(arr, ngang, doc);
        }
        return nextPosition;
    }

    public static int[] qt12(int[][] arr, int ngang, int doc) {
        int[] nextPosition = new int[2];
        if (arr[0][ngang - 1] == 0) {
            nextPosition[0] = 0;
            nextPosition[1] = ngang - 1;
        } else {
            nextPosition = qt2(arr, ngang, doc);
        }
        return nextPosition;
    }

    public static int[] qt2(int[][] arr, int ngang, int doc) {
        int[] nextPosition = new int[2];
        if (doc != 0) {
            nextPosition[0] = doc - 1;
        } else {
            nextPosition[0] = arr.length - 1;
        }
        nextPosition[1] = ngang;
        return nextPosition;
    }

    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
    }

}
