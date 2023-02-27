package com.manuelportero.primitiva;

public class Game {

    Bombo bombo = new Bombo();
    /**
     * Éste método comprueba una unica vez si el boleto del usuario ha ganado algún tipo de premio, sin saber aún cual es. Convierte el boleto ganador y el boleto del usuario
     * en dos arrays distintos slpiteados por espacios.
     * @param boletoUsuario El parametro boletoUsuario, es el String boleto que nos introducen a este método desde la clase Main para poder trabajar con el.
     * @return Para devolver este metodo, llamamos a un metodo privado que tenemos en la clase que nos comprueba que premio ha ganado o por lo contrario si no ha ganado ninguno.
     * Creamos un array de int llamado resultado el cual nos dice cauntos aciertos han habido, si hay complementario y si hay reintegro.
     */
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
    /**
     * Éste método ejecuta un bucle do while que esta en funcionamiento hasta que el usuario consiga ganar algún tipo premio sin saber aún cual es. Convierte el boleto ganador y
     * el boleto del usuario en dos arrays distintos slpiteados por espacios.
     * @param boletoUsuario El parametro boletoUsuario, es el String boleto que nos introducen a este método desde la clase Main para poder trabajar con el.
     * @return Para devolver este metodo, llamamos a un metodo privado que tenemos en la clase que nos comprueba que premio ha ganado o por lo contrario si no ha ganado ninguno.
     * Creamos un array de int llamado resultado el cual nos dice cauntos aciertos han habido, si hay complementario y si hay reintegro.
     */
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
    /**
     * Éste método ejecuta un bucle do while que esta en funcionamiento hasta que el usuario consiga ganar algún tipo premio sin saber aún cual es obviando el numero del reintegro.
     * Convierte el boleto ganador y el boleto del usuario en dos arrays distintos slpiteados por espacios.
     * @param boletoUsuario El parametro boletoUsuario, es el String boleto que nos introducen a este método desde la clase Main para poder trabajar con el.
     * @return Para devolver este metodo, llamamos a un metodo privado que tenemos en la clase que nos comprueba que premio ha ganado o por lo contrario si no ha ganado ninguno.
     * Creamos un array de int llamado resultado el cual nos dice cauntos aciertos han habido, si hay complementario y si hay reintegro.
     */
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
    /**
     * Éste método comprueba diez mil veces si el boleto del usuario ha ganado algún tipo de premio, sin saber aún cual es. Convierte el boleto ganador y el boleto del usuario
     * en dos arrays distintos slpiteados por espacios.
     * @param boletoUsuario El parametro boletoUsuario, es el String boleto que nos introducen a este método desde la clase Main para poder trabajar con el.
     * @return En este caso en vez de devolver la llamada al otro metodo, devolvemos directamente ya el mensaje de cuantos premios ha ganado de cada categoria, por ello,
     * creamos las categorias de los premios al principio del metodo y los inicializamos a 0.
     */
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
        return "En 10000 tiradas has obtenido:  "+ premioEspecial+"  premios especiales,  "+primerPremio+"  de primera categoria, "+segundoPremio+"  de primera segunda,  "+tercerPremio+"  de tercera categoria,  "+cuartoPremio+"  de cuarta categoria,  "+quintoPremio+"  de quinta categoria, ";
    }
    /**
     * Éste método ejecuta un bucle do while que esta en funcionamiento hasta que el usuario consiga ganar un premio especial. Convierte el boleto ganador y
     * el boleto del usuario en dos arrays distintos slpiteados por espacios.
     * @param boletoUsuario El parametro boletoUsuario, es el String boleto que nos introducen a este método desde la clase Main para poder trabajar con el.
     * @return En este caso, devolvemos directamente el texto con los intentos que han hecho falta para conseguir este premio especial y el boleto ganador.
     */
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

    /**
     * Este metodo renueva los bombos para poder crear nuevos boletos ganadores ya que en metodos anteriores nos es necesario llamarlo mas de una vez.
     */
    private void rellenarBombos(){
         bombo.rellenarBombo1();
         bombo.rellenarBombo2();
    }
    /**
     * Este ultimo metodo, es al metodo que todos llaman en los anteriores para comprobar la categoria del premio que ha ganado el usuario, o por lo contrario si no ha ganado
     * ningun premio de ninguna categoria. En este caso hay dos tipos, uno con el que contamos el reintegro y otro con el que no.
     * @param resultado El parmtro resultado, es el array que devolviamos en todos los anteriores metodos para saber el tipo de premio obtenido por el usuario.
     * @param num Este paramtro num lo necesitamos para determinar que tipo de condiciones vamos a hacer uso, ya que uno no cuenta con el reintegro para un metodo anterior.
     * @return Como observamos, contiene muchos return ya que dependiendo de que tipo de categoria ha ganado, imprime una cosa u otra. Por lo contrario si no obtiene premios,
     * también lo devuelve para posteriormente mostrarlo por pantalla en la clase Main.
     */
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
