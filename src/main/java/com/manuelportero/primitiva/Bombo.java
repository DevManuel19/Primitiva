package com.manuelportero.primitiva;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Bombo {

    private static Random random = new Random();
    private int[] bombo1;
    private int[] bombo2;


    public Bombo(){
        bombo1 = new int[49];
        this.bombo1 = rellenarBombo1();
        bombo2 = new int[10];
        this.bombo2 = rellenarBombo2();
    }
    public int[] rellenarBombo1() {
        for (int i = 0; i < bombo1.length; i++) {
            this.bombo1[i] = i + 1;
        }
        return bombo1;
    }

    public int[] rellenarBombo2(){
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
    public int generarComplementario(int[] boleto){
        int posicion = 0;
        for (int i = 0; i <boleto.length ; i++) {
            for (int j = 0; j < bombo1.length; j++) {
                if (boleto[i]==bombo1[j]){
                    bombo1[j]=0;
                }
            }
        }
        do {posicion = random.nextInt(bombo1.length);}
        while(bombo1[posicion]== 0);

        return bombo1[posicion];
    }
    public int generarReintegro(){
       int posicion = random.nextInt(bombo2.length) ;
        return bombo2[posicion];
    }
    public String combinarValores(){
        StringBuilder sb = new StringBuilder();
        int[] boletoSeis = generarSeisBoletoGanador(bombo1);
        int complementario = generarComplementario(boletoSeis);
        int reintegro = generarReintegro();
        for(int i = 0;i < boletoSeis.length;i++){
            sb.append(boletoSeis[i]).append(" ");
        }
        sb.append(complementario).append(" ").append(reintegro);
        return sb.toString();
    }

}
