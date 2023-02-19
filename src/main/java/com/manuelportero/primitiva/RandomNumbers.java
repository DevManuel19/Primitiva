package com.manuelportero.primitiva;

import java.util.Random;
import java.util.Scanner;

public class RandomNumbers {
    private static Random random = new Random();
    private int[] bombo1;
    private int[] bombo2;
    private int max = 49;
    private int min = 1;

    public int[] rellenarBombo1(){
        for(int i = 0;i < 50;i++){
            bombo1[i] = i+1;
        }
        return bombo1;
    }
    public int[] rellenarBombo2(){
        for(int i = 0;i < 10;i++){
            bombo2[i] = i;
        }
        return bombo2;
    }
    public int[] generarSeis(int[] bombo1){
        int[] boleto = new int[6];
        for (int i = 0;i < boleto.length;i++){
             boleto[i] = random.nextInt(max - min + min) + 1;
        }
        return boleto;
    }
}
