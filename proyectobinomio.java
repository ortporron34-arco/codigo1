import java.util.Scanner;
public class proyectobinomio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int k;
        int i;
        int coeficiente;
        System.out.print("Ingresa el exponente n: ");
        n = sc.nextInt();
        for (k = 0; k <= n; k++) {
            coeficiente = 1;
            for (i = 1; i <= k; i++) {
                coeficiente = coeficiente * (n - i + 1) / i;
            }
            System.out.print(coeficiente);
            if (n - k > 0) {
                System.out.print("x^" + (n - k));
            }
            if (k > 0) {
                System.out.print("y^" + k);
            }
            if (k < n) {
                System.out.print(" + ");
            }
        }
        System.out.println();
        sc.close();
    }
}
