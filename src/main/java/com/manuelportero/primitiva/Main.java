package com.manuelportero.primitiva;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Scanner lector = new Scanner(System.in);
    public static Random random = new Random();
    public static void main(String[] args) {
        int[] num = new int[6];
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
        }while(numLector == 1 || numLector == 2);

    }

    public static void menuPrimitiva(){
        System.out.println("********************");
        System.out.println("** MENU PRIMITIVA **");
        System.out.println("********************");
        System.out.println("<<Desea introducir tus numeros de la suerte manuelmente?>>");
        System.out.println("------------------------------------------------------");
        System.out.println("1.-Si, deseo introducirlos.");
        System.out.println("2.-No, deseo que sean aleatorios.");
    }
}



