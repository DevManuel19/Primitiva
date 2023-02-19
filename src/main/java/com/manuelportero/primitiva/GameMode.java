package com.manuelportero.primitiva;

public class GameMode {
    public void juegoUnico(int[] num, int[] premio, int reintegro , int bonificacion ,int premioReintegro, int premioBonificacion){
        int premios = 0;
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

    }
}
