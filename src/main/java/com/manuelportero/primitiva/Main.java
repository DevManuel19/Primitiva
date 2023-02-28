package com.manuelportero.primitiva;
import java.util.Scanner;

public class Main {
    public static Scanner lector = new Scanner(System.in);
    public static Boleto boleto = new Boleto();
    public static  Game game = new Game();
    private static String boletoUsuario = "";
    /**
     * Bucle principal donde se llama a los menú. Pide si quiere jugar con números aleatorios o introducidos manualmente. Seguidamente,
     * solicita los numeros en caso de que sean introducidos manualmente. Para finalizar muestra un segundo menú con las modalidades a elegir.
     * @param args
     */

    public static void main(String[] args) {
        
        int numLector = 0;
        while(numLector == 0) {
            do {
                menuPrimitiva();
                numLector = lector.nextInt();
                lector.nextLine();
                switch (numLector) {
                    case 1:
                        boletoUsuarioIntroducido();
                        System.out.println("Este es tu boleto de la suerte: " + boletoUsuario);
                        break;

                    case 2:
                        boletoUsuario = boleto.crearBoletoUsuarioAleatorio();
                        break;
                    default:
                        System.out.println("ERROR. INTRODUCE UN CARACTER VALIDO");
                        break;
                }
            } while (numLector != 1 && numLector != 2);
            do {
                menuModalidad();
                numLector = lector.nextInt();
                lector.nextLine();
                switch (numLector) {
                    case 1:
                        /*Jugaremos a un único sorteo y al finalizar mostrará la
                        combinación ganadora y si hemos obtenido algún premio.*/
                        System.out.println(boletoUsuario);
                        System.out.println(game.comprobarJuegoUnico(boletoUsuario));
                        break;
                    case 2:
                        /*El programa realizará varios sorteos hasta
                        que obtengamos algún tipo de premio (reintegro incluido)*/
                        System.out.println(game.hastaPremio(boletoUsuario));
                        break;
                    case 3:
                        /*El programa realizará
                        varios sorteos hasta que obtengamos algún tipo de premio (reintegro
                        excluido).*/
                        System.out.println(game.hastaPremioSinReintegro(boletoUsuario));
                        break;
                    case 4:
                        /*El programa realizará un ciclo de 10000 sorteos
                        y al final mostrará un resumen de los premios obtenidos de cada categoría*/
                        System.out.println(game.hastaDiezMil(boletoUsuario));
                        break;
                    case 5:
                        /*El programa jugará
                        sorteos hasta obtener un premio de la categoría especial. Al final mostrará
                        la combinación ganadora y el número de sorteos jugados hasta alcanzar el
                        premio.
                        */
                        System.out.println(game.hastaPremioEspecial(boletoUsuario));
                        break;
                    case 0:
                        //vuelve hacia atras
                        break;
                    default:
                        System.out.println("ERROR. INTRODUCE UN CARACTER VALIDO");
                        break;
                }
            } while (numLector > 5 || numLector < 0);
        }

    }

    /**
     * Primer menu de la primitiva. Solo muestra por pantalla si desea introducir tus numeros de la suerte manuelmente o
     * de forma aleatoria.
     */
    public static void menuPrimitiva(){
        System.out.println("■──────────────────────────────────────────────────────■");
        System.out.println("│                     MENU PRIMITIVA                   │");
        System.out.println("■──────────────────────────────────────────────────────■");
        System.out.println("[Desea introducir tus numeros de la suerte manuelmente?]");
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("■ 1 Si,deseo introducirlos.");
        System.out.println("■ 2 No,deseo que sean aleatorios.");
        System.out.println("────────────────────────────────────────────────────────");
    }

    /**
     * Segundo menu. Solo muestra por pantalla las diferentes modalidades de juego que hay y el numero a introducir para
     * seleccionar cada una de ellas.
     */
    public static void menuModalidad(){
        System.out.println("■──────────────────────────────────────────────────────■");
        System.out.println("│                     MENU MODALIDAD                   │");
        System.out.println("■──────────────────────────────────────────────────────■");
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("■ 1 Juego único.");
        System.out.println("■ 2 Jugar hasta obtener premio.");
        System.out.println("■ 3 Jugar hasta obtener premio (sin reintegro).");
        System.out.println("■ 4 Ciclo de 10k sorteos.");
        System.out.println("■ 5 Jugar hasta obtener premio categoría especial.");
        System.out.println("■ 0 Volver al menú primitiva.");
        System.out.println("────────────────────────────────────────────────────────");
    }
    
    private static void boletoUsuarioIntroducido(){
        int[] tamanyo = new int[6];
        for (int i = 1; i < tamanyo.length + 1; i++) {
            System.out.println("Introduce tu numero " + i + " de la suerte:");
            boleto.rellenarBoleto(lector.nextInt(), i-1);
            lector.nextLine();
        }
        boletoUsuario = boleto.combinarValoresUsuario();
    }
}



