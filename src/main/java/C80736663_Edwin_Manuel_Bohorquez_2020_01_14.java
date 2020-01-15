
import java.util.Scanner;
import java.util.Stack;
import java.util.InputMismatchException;

public class C80736663_Edwin_Manuel_Bohorquez_2020_01_14 {

    Scanner teclado;
    int[][] matriz;
    int filas;
    int columnas;

    public void inicio() {
        teclado = new Scanner(System.in);
        System.out.print("Ingrese numero de filas:");
        filas = teclado.nextInt();
        System.out.print("Ingrese numero de columnas:");
        columnas = teclado.nextInt();
        Stack< Integer> pMatriz = new Stack< Integer>();
        matriz = new int[filas][columnas];

        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                matriz[f][c] = (int) Math.floor(Math.random() * (filas * columnas) + 1);
                while (pMatriz.contains(matriz[f][c])) {
                    matriz[f][c] = (int) Math.floor(Math.random() * (filas * columnas) + 1);
                }
                pMatriz.push(matriz[f][c]);
            }
        }
    }

    public void imprimir() {

        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c++) {
                System.out.print(matriz[f][c] + " ");
            }
            System.out.println();
        }
    }

    public void sumColumnas() {

        for (int c = 0; c < columnas; c++) {
            int suma = 0;
            for (int f = 0; f < filas; f++) {
                suma += matriz[f][c];
            }
            System.out.print(+suma + "   ");
        }
        System.out.println();
    }

    public void sumColumnasImpar() {

        for (int c = 0; c < columnas; c++) {
            int suma = 0;
            for (int f = 0; f < filas; f++) {
                suma += matriz[f][c];
            }
            if (c % 2 == 0) {
                System.out.print(+suma + "   ");
            }
        }
        System.out.println();
    }

    public void promColumnasImpar() {

        int res = 0;
        int suma = 0;
        double divisor = 0;
        double total = 0;

        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                if (c % 2 == 0) {
                    suma += matriz[f][c];
                    divisor = c;
                    total = suma / divisor;
                }
            }
        }
        System.out.println("Promedio columnas impares " + total);
        ColumnaMayorPromedioPar(total);
        //System.out.println("columnas" + divisor);
    }

    public void ColumnaMayorPromedioPar(double total) {

//if (suma > total)
        int divisor = 0;
        int count = 0;

        for (int c = 0; c < columnas; c++) {
            int suma = 0;
            for (int f = 0; f < filas; f++) {
                suma += matriz[f][c];
                divisor = c + 1;
            }
            if (suma > total) {
                count += 1;
            }
        }
        System.out.print("Cantidad de columnas cuyo total es mayor que " + total + " = " + count);
    }

    public static void main(String[] ar) {
        C80736663_Edwin_Manuel_Bohorquez_2020_01_14 menu = new C80736663_Edwin_Manuel_Bohorquez_2020_01_14();
        menu.inicio();
        System.out.println("==== matriz N * M ====");
        menu.imprimir();
        System.out.println("==== suma de columnas =====");
        menu.sumColumnas();
        System.out.println("==== suma de columnas impares====");
        menu.sumColumnasImpar();
        menu.promColumnasImpar();
    }
}
