package com.manuelportero.primitiva;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RandomNumbers {
    private static Random random = new Random();
    private int[] bombo1 = new int[49];
    private int[] bombo2 = new int[10];

    public RandomNumbers() {
        this.bombo1 = rellenarBombo1();
        this.bombo2 = rellenarBombo2();
    }
    public int[] rellenarBombo1() {
        for (int i = 0; i < 49; i++) {
            this.bombo1[i] = i + 1;
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
        int posicion = 0;
        for (int i = 0;i < boleto.length;i++){
            posicion = random.nextInt(48 - 0 + 1) + 0;
            while(bombo1[posicion]==0){
                posicion = random.nextInt(48 - 0 + 1) + 0;
            }
            boleto[i] = bombo1[posicion];
            bombo1[posicion] = 0;
        }
        return boleto;
    }
    public int generarComplementario(){
        int posicion = 0;
        do {posicion = random.nextInt(48 - 0 + 1) + 0;}
        while(bombo1[posicion]== 0);
        int complementario = bombo1[posicion];

        return complementario;
    }
    public int generarReintegro(){
       int posicion = random.nextInt(9 - 0 + 1) + 0;
       int reintegro = bombo2[posicion];
       return reintegro;
    }

}
