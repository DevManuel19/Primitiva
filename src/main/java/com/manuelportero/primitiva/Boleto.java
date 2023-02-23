package com.manuelportero.primitiva;
import java.util.Arrays;

public class Boleto {
    public Bombo bombo= new Bombo();
    public static final int TAMANYO_BOLETO = 6;
    private int[] boletoUsuario;
    private int reintegro;
    private int complementario;

    public Boleto(){
    this.boletoUsuario=new int[TAMANYO_BOLETO];
    this.reintegro = bombo.generarReintegro();
    }
    public int generarComplementario(int[] boletoUsuario){
        return complementario = bombo.generarComplementario(boletoUsuario);
    }
    public String combinarValores(){
        StringBuilder sb = new StringBuilder();
        complementario = generarComplementario(getBoletoUsuario());
        for(int i = 0;i < getBoletoUsuario().length;i++){
            sb.append(getBoletoUsuario()[i]).append(" ");
        }
        sb.append(complementario).append(" ").append(getReintegro());
        return sb.toString();
    }

    public void rellenarBoleto(int num, int cont){
        boletoUsuario[cont] = num;
    }

    public int[] getBoletoUsuario() {
        return boletoUsuario;
    }

    public int getReintegro() {
        return reintegro;
    }

    @Override
        public String toString() {
            return "Boleto{" +
                    "boletoUsuario=" + Arrays.toString(boletoUsuario) +
                    '}';
        }

}