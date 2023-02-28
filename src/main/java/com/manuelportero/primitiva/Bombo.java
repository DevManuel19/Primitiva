package com.manuelportero.primitiva;
import java.util.Random;

public class Bombo {

    private static Random random = new Random();
    private int[] bombo1;
    private int[] bombo2;

    /**
     * Este constructor se encarga de rellenar los dos bombos cada vez que se crea un objeto de esta clase,
     */
    public Bombo(){
        bombo1 = new int[49];
        this.bombo1 = rellenarBombo1();
        bombo2 = new int[10];
        this.bombo2 = rellenarBombo2();
    }

    /**
     * Se encarga de rellenar de nuevo el array bombo1 de manera que podemos volver a sacar mas combinaciones.
     * @return Devuelve el array bombo1 rellenado.
     */
    public int[] rellenarBombo1() {
        for (int i = 0; i < bombo1.length; i++) {
            this.bombo1[i] = i + 1;
        }
        return bombo1;
    }
    /**
     * Se encarga de rellenar el otro bombo de combinaciones reintegro, de manera que podemos volver a sacar mas combinaciones.
     * @return Devuelve el array bombo2 rellenado.
     */
    public int[] rellenarBombo2(){
        for(int i = 0;i < bombo2.length;i++){
            bombo2[i] = i;
        }
        return bombo2;
    }

    /**
     * Se encarga de generar la combianción de los 6 numeros de la suerte con el primer bombo.
     * @param bombo1 Le pasamos el array bombo para escojer los valores especificados.
     * @return Devuelve un array con la combinación de los 6 numeros.
     */
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

    /**
     * Este método se encarga de generar el complementario que recojera de los numeros restantes de la combinación de 6 numeros.
     * @param boleto Le pasamos como parametro el boleto para poder elegir entre los numeros sobrantes.
     * @return Devuelve un valor que no sea seleccionado en la fase previa de la combinación de 6 numeros.
     */
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

    /**
     * Este método se encarga de generar el reintegro escogiendo un valor al azar del bombo 2, para posteriormente operar con el.
     * @return Devuelve un valor aleatorio del array del bombo2.
     */
    public int generarReintegro(){
       int posicion = random.nextInt(bombo2.length) ;
        return bombo2[posicion];
    }

    /**
     * Se encarga de combinar todos los valores anteriores, de manera que combina los 6 numeros,el numero complementario y el reintegro seleccionado.
     * @return Devuelve una String con la combinación del boleto completa ya generada.
     */
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
