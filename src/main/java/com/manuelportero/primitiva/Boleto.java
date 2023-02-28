package com.manuelportero.primitiva;
import java.util.Arrays;

public class Boleto {
    public Bombo bombo= new Bombo();
    public static final int TAMANYO_BOLETO = 6;
    private int[] boletoUsuario;
    private String boletoAleatorio;
    private int reintegro;
    private int complementario;

    /**
     * Este constructor se encarga de generar un array con un tamaño predeterminado y generar un reintegrgo previamente a la combinación del usuario.
     */
    public Boleto(){
    this.boletoUsuario=new int[TAMANYO_BOLETO];
    this.reintegro = bombo.generarReintegro();
    }
    public String crearBoletoUsuarioAleatorio(){
        return this.boletoAleatorio= bombo.combinarValores();
    }

    /**
     * Este método se encarga de generar el complementario a partir del boleto introducido manuelamente por el usuario
     * ejecutando un método de la clase de generación de boletos.
     * @param boletoUsuario Le pasamos el boleto del usuario introducido manualmente.
     * @return Devuelve el numero complementario.
     */
    public int generarComplementario(int[] boletoUsuario){
        return complementario = bombo.generarComplementario(boletoUsuario);
    }

    /**
     * Se encarga de combinar el boleto manual del usuario con el complementario aleatorio y reintegro.
     * @return Devuelve un string con el boleto entero del usuario.
     */
    public String combinarValoresUsuario(){
        StringBuilder sb = new StringBuilder();
        complementario = generarComplementario(getBoletoUsuario());
        for(int i = 0;i < getBoletoUsuario().length;i++){
            sb.append(getBoletoUsuario()[i]).append(" ");
        }
        sb.append(complementario).append(" ").append(getReintegro());
        return sb.toString();
    }

    /**
     * Utilizamos este método para que el usuario pueda ir rellenando uno a uno los valores del boleto manualmente.
     * @param num Este parametro sirve para identificar los numeros que va a introducir el usuario.
     * @param cont Este parametro determina sobre que posicion del array tiene que establecer el numero introducido por el usuario.
     */
    public void rellenarBoleto(int num, int cont){
        boletoUsuario[cont] = num;
    }

    /**
     * Nos devuelve el Boleto del usuario para poder operar con dicha información.
     * @return Devuelve el boleto del usuario.
     */
    public int[] getBoletoUsuario() {
        return boletoUsuario;
    }
    /**
     * Nos devuelve el reitegro del usuario para poder operar con dicha información.
     * @return Devuelve el reintegrgo del boleto del usuario.
     */
    public int getReintegro() {
        return reintegro;
    }

    /**
     * Su funcion es sobre escribir el método to string para poder reresentar la información de esta clase con un System.out.println().
     * @return Devuelve el boleto de usuario convertido a String.
     */
    @Override
        public String toString() {
            return "Boleto{" +
                    "boletoUsuario=" + Arrays.toString(boletoUsuario) +
                    '}';
        }

}