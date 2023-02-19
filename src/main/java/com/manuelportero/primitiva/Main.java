package com.manuelportero.primitiva;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int NUMEROS_JUGADOR = 6;
    public static Scanner lector = new Scanner(System.in);
    public static Random random = new Random();

    /**
     * Bucle principal donde se llama a los menú. Pide si quiere jugar con numeros aleatorios o intrudicidos manualmente. Seguidamente,
     * solicita los numeros en caso de que sean introducidos manualmente. Para finalizar muestra un segundo menú con las modalidades a elegir.
     * @param args
     */
    public static void main(String[] args) {
        int[] num = new int[NUMEROS_JUGADOR];
        int numLector;
        boolean valido;
        do {
            menuPrimitiva();
            numLector = lector.nextInt();
            lector.nextLine();
            switch (numLector){
                case 1:
                    for(int i = 1; i < num.length + 1; i++) {
                        System.out.println("Introduce tu numero " + i + " de la seurte:");
                        num[i] = lector.nextInt();
                        lector.nextLine();
                        System.out.println(Arrays.toString(num));
                    }
                    break;
                case 2:
                    for(int i = 0; i < num.length; i++) {
                        num[i] = random.nextInt(9 - 1 + 1) + 1;
                    }
                    System.out.println(Arrays.toString(num));
                    break;
                default:
                    System.out.println("ERROR. INTRODUCE UN CARACTER VALIDO");
                    break;
            }
            menuModalidad();
            numLector = lector.nextInt();
            lector.nextLine();
            switch (numLector) {
                case 1:
                    /*Jugaremos a un único sorteo y al finalizar mostrará la
                    combinación ganadora y si hemos obtenido algún premio.*/
                    break;
                case 2:
                    /*El programa realizará varios sorteos hasta
                    que obtengamos algún tipo de premio (reintegro incluido)*/
                    break;
                case 3:
                    /*El programa realizará
                    varios sorteos hasta que obtengamos algún tipo de premio (reintegro
                    excluido).*/
                    break;
                case 4:
                    /*El programa realizará un ciclo de 10000 sorteos
                    y al final mostrará un resumen de los premios obtenidos de cada categoría*/
                    break;
                case 5:
                    /*El programa jugará
                    sorteos hasta obtener un premio de la categoría especial. Al final mostrará
                    la combinación ganadora y el número de sorteos jugados hasta alcanzar el
                    premio.
                    */
                    break;
                case 0:
                    //vuelve hacia atras
                    return;
                default:
                    System.out.println("ERROR. INTRODUCE UN CARACTER VALIDO");
                    break;
            }
        }while(numLector == 1 || numLector == 2);

    }

    /**
     * Primer menu de la primitiva. Solo muestra por pantalla si desea introducir tus numeros de la suerte manuelmente o
     * de forma aleatoria.
     */
    public static void menuPrimitiva(){
        System.out.println("********************");
        System.out.println("** MENU PRIMITIVA **");
        System.out.println("********************");
        System.out.println("<<Desea introducir tus numeros de la suerte manuelmente?>>");
        System.out.println("------------------------------------------------------");
        System.out.println("1.-Si, deseo introducirlos.");
        System.out.println("2.-No, deseo que sean aleatorios.");
    }

    /**
     * Segundo menu. Solo muestra por pantalla las diferentes modalidades de juego que hay y el numero a introducir para
     * seleccionar cada una de ellas.
     */
    public static void menuModalidad(){
        System.out.println("********************");
        System.out.println("** MENU MODALIDAD **");
        System.out.println("********************");
        System.out.println("---------------------");
        System.out.println("1.-Juego único.");
        System.out.println("2.-Jugar hasta obtener premio..");
        System.out.println("3.-Jugar hasta obtener premio (sin reintegro).");
        System.out.println("4.-Ciclo de 10k sorteos.");
        System.out.println("5.-Jugar hasta obtener premio categoría especial.");
        System.out.println("0.-Volver al menú primitiva.");
    }
}



