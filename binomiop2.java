import java.util.Scanner;

public class binomiop2 {

    public static long factorial(int n) {
        long resultado = 1;

        for (int i = 1; i <= n; i++) {
            resultado = resultado * i;
        }

        return resultado;
    }

    public static long combinacion(int n, int k) {
        return factorial(n) /
        (factorial(k) * factorial(n - k));
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingresa el exponente n: ");
        int n = entrada.nextInt();

        if (n < 0 || n > 15) {
            System.out.println("Ingresa un numero entre 0 y 15.");
            entrada.close();
            return;
        }

        System.out.println("\nDesarrollo del binomio:");

        for (int k = 0; k <= n; k++) {

            long coeficiente = combinacion(n, k);
            int exponenteX = n - k;
            int exponenteY = k;

            if (k > 0) {
                System.out.print(" + ");
            }

            if (coeficiente != 1 ||
                (exponenteX == 0 && exponenteY == 0)) {
                System.out.print(coeficiente);
            }

            if (exponenteX > 0) {
                System.out.print("x");

                if (exponenteX > 1) {
                    System.out.print("^" + exponenteX);
                }
            }

            if (exponenteY > 0) {
                System.out.print("y");

                if (exponenteY > 1) {
                    System.out.print("^" + exponenteY);
                }
            }
        }

        System.out.println();
        entrada.close();
    }
}
