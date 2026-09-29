import java.util.Scanner;

public class calse5{

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingresa el primer dato: ");
        String dato1 = teclado.nextLine();

        System.out.print("Ingresa el segundo dato: ");
        String dato2 = teclado.nextLine();

        // Si alguno es booleano, no se realizan operaciones
        if (dato1.equalsIgnoreCase("true") || dato1.equalsIgnoreCase("false") ||
            dato2.equalsIgnoreCase("true") || dato2.equalsIgnoreCase("false")) {

            System.out.println("No se pueden hacer operaciones con valores booleanos.");

        } else {
            try {
                // Intenta convertir a número para realizar operaciones básicas
                double num1 = Double.parseDouble(dato1);
                double num2 = Double.parseDouble(dato2);

                System.out.print("Ingresa la operación (S = Suma, R = Resta, M = Multiplicación): ");
                String operacion = teclado.nextLine();

                if (operacion.equalsIgnoreCase("S")) {
                    System.out.println("Suma: " + (num1 + num2));
                } else if (operacion.equalsIgnoreCase("R")) {
                    System.out.println("Resta: " + (num1 - num2));
                } else if (operacion.equalsIgnoreCase("M")) {
                    System.out.println("Multiplicación: " + (num1 * num2));
                } else {
                    System.out.println("Operación no válida.");
                }

            } catch (Exception e) {
                // Si falla la conversión numérica, se trata como cadena o carácter y concatena
                System.out.println("Con cadenas o caracteres solo se puede concatenar.");
                System.out.println("Resultado concatenado: " + dato1 + dato2);
            }
        }

        teclado.close();
    }
}
