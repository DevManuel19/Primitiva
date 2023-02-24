package com.manuelportero.primitiva;

import java.util.Arrays;

public class Game {


    public int[] comprobarJuegoUnico(String boletoGanador, String boletoUsuario){
        //int[] boletoGanadorStr= new int[]{Integer.parseInt(Arrays.toString(boletoGanador.split(" ")))};
        String[] boletoGanadorStr= boletoGanador.split(" ");
        String[] boletoUsuarioStr =boletoUsuario.split(" ");
        int isReintegro = 0;
        int isComplementario = 0;
        StringBuilder sb = new StringBuilder();
        int aciertos=0;
        for (int i = 0; i <boletoGanadorStr.length-2 ; i++) {
            if (boletoGanadorStr[i].equals(boletoUsuarioStr[i])) {
                aciertos++;
            }
        }
        if(boletoGanadorStr[boletoGanadorStr.length-2].equals(boletoUsuarioStr[boletoUsuarioStr.length-2]))
            isReintegro= 1;
        else if (boletoGanadorStr[boletoGanadorStr.length -1].equals(boletoUsuarioStr[boletoUsuarioStr.length -1])) {
            isComplementario=1;
        }


        int[] resultado;
        return resultado = new int[]{aciertos, isReintegro, isComplementario};
    }




    /*public void juegoUnico(int[] num, int[] premio, int reintegro , int bonificacion ,int premioReintegro, int premioBonificacion){
        int premios = 0;

        for (int i = 0; i < 6; i++) {
            if (num[i] ==premio[i]);
            premios++;

        }
        if (premioReintegro == reintegro){
            isReintegros = true;
        }
        else if (bonificacion == premioBonificacion){
            isBonificaciones = true;
        }
        else if ((premios == 6 && isReintegros) == true){
            System.out.println("Premio especial");
        }
        else if (premios == 6) {
            System.out.println("primer premio");

        }
        else if (premios == 5 && isBonificaciones == true) {
            System.out.println("segundo premio");

        }
        else if (premios == 5) {
            System.out.println("tercer premio");

        }
        else if (premios == 4) {
            System.out.println("cuarto premio");

        }
        else if (premios == 3) {
            System.out.println("quinto premio");

        }
        //else MenuModalidad();

    }
    public void  UntilPrize(int[] num, int[] premio, int reintegro , int bonificacion ,int premioReintegro, int premioBonificacion){
       boolean isPremio= false;
        do{ int premios = 0;
        boolean isReintegros = false;
        boolean isBonificaciones = false;
        for (int i = 0; i < 6; i++) {
            if (num[i] ==premio[i]);
            premios++;

        }
        if (premioReintegro == reintegro){
            isReintegros = true;

        }
        else if (bonificacion == premioBonificacion){
            isBonificaciones = true;
        }
        else if ((premios == 6 && isReintegros) == true){
            System.out.println("Premio especial");
            isPremio= true;
        }
        else if (premios == 6) {
            System.out.println("primer premio");
            isPremio= true;

        }
        else if (premios == 5 && isBonificaciones == true) {
            System.out.println("segundo premio");
            isPremio= true;

        }
        else if (premios == 5) {
            System.out.println("tercer premio");
            isPremio= true;

        }
        else if (premios == 4) {
            System.out.println("cuarto premio");
            isPremio= true;

        }
        else if (premios == 3) {
            System.out.println("quinto premio");
            isPremio= true;

        }
        //else Main();


        }while (isPremio == false);
    }*/
}
