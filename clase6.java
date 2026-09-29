import java.util.Scanner;

// Clase Genérica T
public class clase6<T> {

    public void procesarDatos(T obj1, T obj2, String operacion) {
        
        // 1. Si alguno es Booleano
        if (obj1 instanceof Boolean || obj2 instanceof Boolean) {
            System.out.println("No se pueden hacer operaciones con valores booleanos.");
        } 
        // 2. Si ambos son Números
        else if (obj1 instanceof Number && obj2 instanceof Number) {
            double n1 = ((Number) obj1).doubleValue();
            double n2 = ((Number) obj2).doubleValue();

            if (operacion.equalsIgnoreCase("S")) {
                System.out.println("Suma: " + (n1 + n2));
            } else if (operacion.equalsIgnoreCase("R")) {
                System.out.println("Resta: " + (n1 - n2));
            } else if (operacion.equalsIgnoreCase("M")) {
                System.out.println("Multiplicación: " + (n1 * n2));
            } else {
                System.out.println("Operación no válida.");
            }
        } 
        // 3. Si son Cadena (String) o Carácter (Character)
        else if (obj1 instanceof String || obj2 instanceof String || 
                 obj1 instanceof Character || obj2 instanceof Character) {
            
            System.out.println("Con cadenas o caracteres solo se puede concatenar.");
            System.out.println("Resultado: " + obj1.toString() + obj2.toString());
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Instancia de la clase genérica usando Object para recibir cualquier tipo
        clase6<Object> procesador = new clase6<>();

        System.out.print("Ingresa el primer dato: ");
        String entrada1 = teclado.nextLine();

        System.out.print("Ingresa el segundo dato: ");
        String entrada2 = teclado.nextLine();

        // Convertimos las entradas de texto al tipo real que representan
        Object dato1 = convertirTipo(entrada1);
        Object dato2 = convertirTipo(entrada2);

        System.out.print("Ingresa la operación (S = Suma, R = Resta, M = Multiplicación): ");
        String op = teclado.nextLine();

        // Ejecuta la lógica dentro de la clase genérica
        procesador.procesarDatos(dato1, dato2, op);

        teclado.close();
    }

    // Método auxiliar para detectar y empaquetar el String ingresado en su tipo Wrapper real
    private static Object convertirTipo(String valor) {
        if (valor.equalsIgnoreCase("true") || valor.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(valor);
        }
        try {
            return Double.parseDouble(valor);
        } catch (NumberFormatException e) {
            if (valor.length() == 1) {
                return valor.charAt(0); // Character
            }
            return valor; // String
        }
    }
}
