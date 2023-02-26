package com.manuelportero.primitiva;

public class Game {

    Bombo bombo = new Bombo();
    public String comprobarJuegoUnico(String boletoUsuario){
        String boletoGanador = bombo.combinarValores();
        String[] boletoGanadorStr = boletoGanador.split(" ");
        String[] boletoUsuarioStr = boletoUsuario.split(" ");
        int isReintegro = 0;
        int isComplementario = 0;
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
        int[] resultado ={aciertos,isComplementario,isReintegro};
        return comprobarPremio(resultado,1);
    }
    public String hastaPremio (String boletoUsuario) {
        String boletoGanador;
        int isReintegro = 0;
        int isComplementario;
        int aciertos;

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
        } while (aciertos < 3 && isReintegro==0);
        int[] resultado ={aciertos,isComplementario,isReintegro};
        return comprobarPremio(resultado,1);
    }
    public String hastaPremioSinReintegro (String boletoUsuario) {
        String boletoGanador;
        int isReintegro;
        int isComplementario;
        int aciertos;
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
        } while (aciertos < 3);
        int[] resultado ={aciertos,isComplementario,isReintegro};
        return comprobarPremio(resultado,0);
    }
    public String hastaDiezMil (String boletoUsuario) {
        String boletoGanador;
        int isReintegro = 0;
        int isComplementario;
        int aciertos;
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
            if (aciertos == 6 && isReintegro == 1){
                premioEspecial++;
            } else if (aciertos == 6) {
                primerPremio++;
            } else if (aciertos == 5 && isComplementario == 1)  {
                segundoPremio++;
            } else if (aciertos == 5) {
                tercerPremio++;
            } else if (aciertos == 4) {
                cuartoPremio++;
            } else if (aciertos == 3) {
                quintoPremio++;
            }

            rellenarBombos();
        }
        return "En 10000 tiradas has obtenido  "+ premioEspecial+"  premios especiales  "+primerPremio+"  primero  "+segundoPremio+"  segundo  "+tercerPremio+"  tercero  "+cuartoPremio+"  cuarto  "+quintoPremio+"  quintopuesto ";
    }
    public String hastaPremioEspecial (String boletoUsuario) {
        int count = 0;
        int isReintegro = 0;
        int aciertos = 0;
        String boletoGanador;
        StringBuilder sb=new StringBuilder();

        do {
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
                ;
            else if (boletoGanadorStr[boletoGanadorStr.length -1].equals(boletoUsuarioStr[boletoUsuarioStr.length -1])) {
                isReintegro++;
            }

            rellenarBombos();
            count++;
        } while (aciertos < 6 || isReintegro==0);
        return "Han hecho falta "+ count +" intentos con la combinacion ganadora "+ boletoGanador + " para obtener el premio de categoria especial";
    }

    private void rellenarBombos(){
         bombo.rellenarBombo1();
         bombo.rellenarBombo2();
    }
    private String comprobarPremio(int[] resultado,int num){

        if(num == 1){
            if(resultado[0] == 3 ){
                return "Has obtenido un premio de 5º categoria.";
            }else if(resultado[0] == 4){
                return "Has obtenido un premio de 4º categoria";
            }else if(resultado[0] == 5 ){
                return "Has obtenido un premio de 3º categoria";
            }else if(resultado[0] == 5 && resultado[1] == 1){
                return "Has obtenido un premio de 2º categoria";
            }else if(resultado[0] == 6){
                return "Has obtenido un premio de 1º categoria";
            }else if(resultado[0] == 6 && resultado[2] == 1){
                return "Has obtenido un premio de categoria especial";
            }else if(resultado[2] == 1){
                return "Ha obtenido un reintegro de su boleto";
            }
            return "No has obtenido ningun premio";
        }else{
            if(resultado[0] == 3){
                return "Has obtenido un premio de 5º categoria.";
            }else if(resultado[0] == 4){
                return "Has obtenido un premio de 4º categoria";
            }else if(resultado[0] == 5){
                return "Has obtenido un premio de 3º categoria";
            }else if(resultado[0] == 5){
                return "Has obtenido un premio de 2º categoria";
            }else if(resultado[0] == 6){
                return "Has obtenido un premio de 1º categoria";
            }else if(resultado[0] == 6){
                return "Has obtenido un premio de categoria especial";
            }else if(resultado[2] == 1){
                return "Se le ha devuelto el dinero de su boleto";
            }
            return "No has obtenido ningun premio";
        }
    }
}
