package com.manuelportero.primitiva;
import java.util.Arrays;

public class Boleto {
    public Bombo bombo= new Bombo();
        public static final int TAMANYO_BOLETO = 6;
        public int[] boletoUsuario;
        private int reintegro;
        private int complementario;


        public void rellenarBoleto(int num, int cont){
            boletoUsuario[cont] = num;
        }

        public int[] getBoletoUsuario() {
            return boletoUsuario;
        }

    public int getReintegro() {
        return reintegro;
    }

    public int getComplementario() {
        return complementario;
    }
    public Boleto(){
        this.boletoUsuario=new int[TAMANYO_BOLETO];
        reintegro= bombo.generarReintegro();
        complementario= bombo.generarComplementario(boletoUsuario);

    }


    @Override
        public String toString() {
            return "Boleto{" +
                    "boletoUsuario=" + Arrays.toString(boletoUsuario) +
                    '}';
        }

}