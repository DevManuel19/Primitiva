package com.manuelportero.primitiva;

public class Boleto {
    private int[] boletoUsuario;

    public Boleto(int num1, int num2, int num3, int num4, int num5, int num6) {
        boletoUsuario = new int[]{num1, num2, num3, num4, num5, num6};
    }

    public int[] getBoletoUsuario() {
        return boletoUsuario;
    }
}
