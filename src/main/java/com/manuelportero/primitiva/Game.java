package com.manuelportero.primitiva;

import java.util.Arrays;

public class Game {

    Bombo bombo =new Bombo();
    public int[] comprobarJuegoUnico(String boletoUsuario){
        String boletoGanador=bombo.combinarValores();
        String[] boletoGanadorStr = boletoGanador.split(" ");
        String[] boletoUsuarioStr = boletoUsuario.split(" ");
        int isReintegro = 0;
        int isComplementario = 0;
        StringBuilder sb = new StringBuilder();
        int aciertos=0;
        for (int i = 0; i <boletoGanadorStr.length-2 ; i++) {
            for (int j = 0; j <boletoGanadorStr.length-2 ; j++) {
                if (boletoGanadorStr[i].equals(boletoUsuarioStr[j])) {
                    aciertos++;
                }
            }
        }
        if(boletoGanadorStr[boletoGanadorStr.length-2].equals(boletoUsuarioStr[boletoUsuarioStr.length-2]))
            isComplementario= 1;
        else if (boletoGanadorStr[boletoGanadorStr.length -1].equals(boletoUsuarioStr[boletoUsuarioStr.length -1])) {
            isReintegro=1;
        }


        int[] resultado;
        return resultado = new int[]{aciertos, isComplementario, isReintegro};
    }
    public String hastaPremio (String boletoUsuario) {
        int count = 0;
        String boletoGanador;
        int isReintegro = 0;
        int isComplementario = 0;
        int aciertos = 0;
        String respuesta="";

        do {
            isComplementario=0;
            aciertos=0;
            boletoGanador = bombo.combinarValores();
            String[] boletoGanadorStr = boletoGanador.split(" ");
            String[] boletoUsuarioStr = boletoUsuario.split(" ");

            for (int i = 0; i <boletoGanadorStr.length-2 ; i++) {
                for (int j = 0; j <boletoGanadorStr.length-2 ; j++) {
                    if (boletoGanadorStr[i].equals(boletoUsuarioStr[j])) {
                        aciertos++;
                    }
                }
            }
            if(boletoGanadorStr[boletoGanadorStr.length-2].equals(boletoUsuarioStr[boletoUsuarioStr.length-2]))
                isComplementario++;
            else if (boletoGanadorStr[boletoGanadorStr.length -1].equals(boletoUsuarioStr[boletoUsuarioStr.length -1])) {
                isReintegro++;
            }

            rellenarBombos();
            count++;
        } while (aciertos < 3 && isReintegro==0);
        int[] resultado = new int[]{aciertos, isComplementario, isReintegro};
        if (aciertos == 6 && isReintegro==1){
            respuesta="Premio Especial, tu boleto es : "+ boletoUsuario+" y el ganador es : " + boletoGanador + " n veces"+ count;
        } else if (aciertos==6) {
            respuesta="primerPremio , tu boleto es : "+ boletoUsuario + " y el ganador es :  "+ boletoGanador + " n veces"+ count;
        } else if (aciertos== 5 && isComplementario==1)  {
            respuesta="Segundo premio, tu boleto es : "+ boletoUsuario+" y el ganador es : " + boletoGanador + " n veces"+ count;
        } else if (aciertos==5) {
            respuesta="Tercer premio, tu boleto es : "+ boletoUsuario+" y el ganador es : " + boletoGanador + " n veces"+ count;
        } else if (aciertos==4) {
            respuesta="Cuarto premio, tu boleto es : "+ boletoUsuario+" y el ganador es : " + boletoGanador + " n veces"+ count;
        } else if (aciertos==3) {
            respuesta="Quinto premio , tu boleto es : "+ boletoUsuario+" y el ganador es : " + boletoGanador + " n veces"+ count;
        } else if (isReintegro==1) {
            respuesta="solo reintegro  tu boleto es : "+ boletoUsuario+" y el ganador es : " + boletoGanador + " n veces"+ count;
        }
        return respuesta;
    }
    public String hastaPremioSinReintegro (String boletoUsuario) {
        int count = 0;
        String boletoGanador;
        int isReintegro = 0;
        int isComplementario = 0;
        int aciertos = 0;
        String respuesta="";
        do {
            isReintegro=0;
            isComplementario = 0;
            aciertos = 0;
            boletoGanador = bombo.combinarValores();
            String[] boletoGanadorStr = boletoGanador.split(" ");
            String[] boletoUsuarioStr = boletoUsuario.split(" ");

            for (int i = 0; i < boletoGanadorStr.length - 2; i++) {
                for (int j = 0; j < boletoGanadorStr.length - 2; j++) {
                    if (boletoGanadorStr[i].equals(boletoUsuarioStr[j])) {
                        aciertos++;
                    }
                }
            }
            if (boletoGanadorStr[boletoGanadorStr.length - 2].equals(boletoUsuarioStr[boletoUsuarioStr.length - 2]))
                isComplementario++;
            else if (boletoGanadorStr[boletoGanadorStr.length - 1].equals(boletoUsuarioStr[boletoUsuarioStr.length - 1])) {
                isReintegro++;
            }

            rellenarBombos();
            count++;
        } while (aciertos < 3);
        int[] resultado = new int[]{aciertos, isComplementario, isReintegro};
        if (aciertos == 6 && isReintegro==1){
            respuesta="Premio Especial, tu boleto es : "+ boletoUsuario+" y el ganador es : " + boletoGanador + " n veces"+ count;
        } else if (aciertos==6) {
            respuesta="primerPremio , tu boleto es : "+ boletoUsuario + " y el ganador es :  "+ boletoGanador+ " n veces "+ count ;
        } else if (aciertos== 5 && isComplementario==1)  {
            respuesta="Segundo premio, tu boleto es : "+ boletoUsuario+" y el ganador es : " + boletoGanador+ " n veces "+ count ;
        } else if (aciertos==5) {
            respuesta="Tercer premio, tu boleto es : "+ boletoUsuario+" y el ganador es : " + boletoGanador + " n veces "+ count;
        } else if (aciertos==4) {
            respuesta="Cuarto premio, tu boleto es : "+ boletoUsuario+" y el ganador es : " + boletoGanador + " n veces " + count;
        } else if (aciertos==3) {
            respuesta="Quinto premio , tu boleto es : "+ boletoUsuario+" y el ganador es : " + boletoGanador + " n veces "+ count;
        } else if (isReintegro==1) {
            respuesta="solo reintegro  tu boleto es : "+ boletoUsuario+" y el ganador es : " + boletoGanador + " n veces "+ count;
        }
        return respuesta;
    }
    public String hastaDiezMil (String boletoUsuario) {
        int count = 0;
        String boletoGanador;
        int isReintegro = 0;
        int isComplementario = 0;
        int aciertos = 0;
        int premioEspecial=0;
        int primerPremio=0;
        int segundoPremio=0;
        int tercerPremio=0;
        int cuartoPremio=0;
        int quintoPremio=0;
        for (int z = 0; z <10000 ; z++) {
            isComplementario = 0;
            aciertos = 0;
            boletoGanador = bombo.combinarValores();
            String[] boletoGanadorStr = boletoGanador.split(" ");
            String[] boletoUsuarioStr = boletoUsuario.split(" ");

            for (int i = 0; i < boletoGanadorStr.length - 2; i++) {
                for (int j = 0; j < boletoGanadorStr.length - 2; j++) {
                    if (boletoGanadorStr[i].equals(boletoUsuarioStr[j])) {
                        aciertos++;
                    }
                }
            }
            if (boletoGanadorStr[boletoGanadorStr.length - 2].equals(boletoUsuarioStr[boletoUsuarioStr.length - 2]))
                isComplementario++;
            else if (boletoGanadorStr[boletoGanadorStr.length - 1].equals(boletoUsuarioStr[boletoUsuarioStr.length - 1])) {
                isReintegro++;
            }
            if (aciertos == 6 && isReintegro==1){
                premioEspecial++;
            } else if (aciertos==6) {
                primerPremio++;
            } else if (aciertos== 5 && isComplementario==1)  {
                segundoPremio++;
            } else if (aciertos==5) {
                tercerPremio++;
            } else if (aciertos==4) {
                cuartoPremio++;
            } else if (aciertos==3) {
                quintoPremio++;
            }

            rellenarBombos();
            count++;
        }
        String resultado=("En 10000 tiradas has obtenido  "+ premioEspecial+"  premios especiales  "+primerPremio+"  primero  "+segundoPremio+"  segundo  "+tercerPremio+"  tercero  "+cuartoPremio+"  cuarto  "+quintoPremio+"  quintopuesto ");
        return resultado;
    }
    public String hastaPremioEspecial (String boletoUsuario) {
        int count = 0;
        int isReintegro = 0;
        int isComplementario = 0;
        int aciertos = 0;
        String boletoGanador;
        StringBuilder sb=new StringBuilder();

        do {
            isComplementario=0;
            aciertos=0;
            boletoGanador = bombo.combinarValores();
            String[] boletoGanadorStr = boletoGanador.split(" ");
            String[] boletoUsuarioStr = boletoUsuario.split(" ");

            for (int i = 0; i <boletoGanadorStr.length-2 ; i++) {
                for (int j = 0; j <boletoGanadorStr.length-2 ; j++) {
                    if (boletoGanadorStr[i].equals(boletoUsuarioStr[j])) {
                        aciertos++;
                    }
                }
            }
            if(boletoGanadorStr[boletoGanadorStr.length-2].equals(boletoUsuarioStr[boletoUsuarioStr.length-2]))
                isComplementario++;
            else if (boletoGanadorStr[boletoGanadorStr.length -1].equals(boletoUsuarioStr[boletoUsuarioStr.length -1])) {
                isReintegro++;
            }

            rellenarBombos();
            count++;
        } while (aciertos < 6 || isReintegro==0);
        int[] resultado = new int[]{aciertos, isComplementario, isReintegro};
        String respuesta="Han hecho falta "+ count +" intentos con la combinacion ganadora "+ boletoGanador;
        return respuesta;
    }

    private void rellenarBombos(){
         bombo.rellenarBombo1();
         bombo.rellenarBombo2();
    }

}
