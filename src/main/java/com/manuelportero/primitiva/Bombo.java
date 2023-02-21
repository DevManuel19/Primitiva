package com.manuelportero.primitiva;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Bombo {
    public static int tamanyoBombo1 = 49;
    public static int tamanyoBombo2 = 10;
    private static Random random = new Random();
    private int[] bombo1;
    private int[] bombo2;

    public Bombo(int cantidadB1,int cantidadB2){
        bombo1 = new int[cantidadB1];
        this.bombo1 = rellenarBombo1();
        bombo2 = new int[cantidadB2];
        this.bombo2 = rellenarBombo2();
    }
    public static void setTamanyoBombo1(int tamanyoBombo1) {
        Bombo.tamanyoBombo1 = tamanyoBombo1;
    }

    public static void setTamanyoBombo2(int tamanyoBombo2) {
        Bombo.tamanyoBombo2 = tamanyoBombo2;
    }
    private int[] rellenarBombo1() {
        for (int i = 0; i < bombo1.length; i++) {
            this.bombo1[i] = i + 1;
        }
        return bombo1;
    }

    private int[] rellenarBombo2(){
        for(int i = 0;i < bombo2.length;i++){
            bombo2[i] = i;
        }
        return bombo2;
    }
    private int[] generarSeisBoletoGanador(int[] bombo1){
        int[] boletoGanador = new int[6];
        int posicion = 0;
        for (int i = 0;i < boletoGanador.length;i++){
            posicion = random.nextInt(bombo1.length);
            while(bombo1[posicion]==0){
                posicion = random.nextInt(bombo1.length) ;
            }
            boletoGanador[i] = bombo1[posicion];
            bombo1[posicion] = 0;
        }
        return boletoGanador;
    }
    private int generarComplementario(){
        int posicion = 0;
        do {posicion = random.nextInt(bombo1.length);}
        while(bombo1[posicion]== 0);

        return bombo1[posicion];
    }
    private int generarReintegro(){
       int posicion = random.nextInt(bombo2.length) ;
        return bombo2[posicion];
    }
    public String combinarValores(){
        StringBuilder sb = new StringBuilder();
        int[] boletoSeis = generarSeisBoletoGanador(bombo1);
        int complementario = generarComplementario();
        int reintegro = generarReintegro();
        for(int i = 0;i < boletoSeis.length;i++){
            sb.append(boletoSeis[i]).append(" ");
        }
        sb.append(complementario).append(" ").append(reintegro);
        return sb.toString();
    }

}
