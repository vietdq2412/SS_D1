package org.example.test2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test2 {
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

            fill(arr);
            printMatrix(arr);
            System.out.println();
        }

    }

    private static void fill(int[][] arr) {
        int[] nextPos = {0, arr.length / 2 };
        int nextJ = arr.length / 2;
        int num = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[nextPos[0]][nextPos[1]] = num;
                num++;
                nextPos = findPos(arr, nextPos, arr.length);
            }
        }
    }

    public static int[] findPos(int[][] arr, int[] prePos, int size) {
        int x = prePos[1];
        int y = prePos[0];
        int[] nextPos = new int[2];

        if (x != 0) {
            if (y != size - 1) {
                if (arr[y + 1][x - 1] == 0) { //qt11
                    nextPos[1] = x - 1;
                    nextPos[0] = y + 1;
                }else { //qt21
                    nextPos = qt2(arr,x,y);
//                    if (arr[x][y-1] == 0){
//                        nextPos[0] = x;
//                        nextPos[1] = y -1;
//                    }else { //qt22
//                        nextPos[0] = x;
//                        nextPos[1] = size-1;
//                    }
                }
            }else { //qt12
                if (arr[0][x-1] == 0){
                    nextPos[0] = x - 1;
                    nextPos[1] = 0;
                }else {
                    nextPos = qt2(arr,x,y);
//                    if (arr[x][y-1] == 0){//qt21
//                        nextPos[0] = x;
//                        nextPos[1] = y -1;
//                    }else {//qt22
//                        nextPos[0] = x;
//                        nextPos[1] = size-1;
//                    }
                }
            }
        } else { // x = 0
            if (y != size-1){ //qt13
                if (arr[y+1][size-1] ==0){
                    nextPos[1] = size-1;
                    nextPos[0] = y+1;
                }else {
                    nextPos = qt2(arr, x,y);
                }
            }else {//qt14 y dưới đáy
                if (arr[0][size-1] ==0){
                    nextPos[1] = size-1;
                    nextPos[0] = 0;
                }else {
                    nextPos = qt2(arr,x,y);
                }
            }
        }
        return nextPos;
    }

    public static int[] qt2(int[][] arr, int x, int y){
        int size = arr.length;
        int[] nextPos = new int[2];
        boolean checkSize = x-1 >= 0  &&  y-1>=0;
        if (checkSize){//qt21
            nextPos[1] = x;
            nextPos[0] = y -1;
        }else {//qt22
            nextPos[1] = x;
            nextPos[0] = size-1;
        }
        return nextPos;
    }
    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }
    }
}
