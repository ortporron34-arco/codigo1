import java.util.Scanner;
public class clase7<T, U> {
    private T valor1;
    private U valor2;
    public clase7(T valor1, U valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }
    public T getValor1() {
        return valor1;
    }

    public U getValor2() {
        return valor2;
    }
    public void calcular(String operacion) {
        if (valor1 instanceof Boolean || valor2 instanceof Boolean) {
            System.out.println("No se pueden hacer operaciones con valores booleanos.");
        } 
        else if (valor1 instanceof Number && valor2 instanceof Number) {
            double n1 = ((Number) valor1).doubleValue();
            double n2 = ((Number) valor2).doubleValue();

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
        else if (valor1 instanceof String || valor2 instanceof String || 
                 valor1 instanceof Character || valor2 instanceof Character) {
            
            System.out.println("Con cadenas o caracteres solo se puede concatenar.");
            System.out.println("Resultado: " + valor1.toString() + valor2.toString());
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingresa el primer dato: ");
        String entrada1 = teclado.nextLine();

        System.out.print("Ingresa el segundo dato: ");
        String entrada2 = teclado.nextLine();

        System.out.print("Ingresa la operación (S = Suma, R = Resta, M = Multiplicación): ");
        String op = teclado.nextLine();

        Object d1 = convertir(entrada1);
        Object d2 = convertir(entrada2);

        clase7<Object, Object> opGen = new clase7<>(d1, d2);
        opGen.calcular(op);

        teclado.close();
    }

    private static Object convertir(String v) {
        if (v.equalsIgnoreCase("true") || v.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(v);
        }
        try {
            return Double.parseDouble(v);
        } catch (NumberFormatException e) {
            if (v.length() == 1) {
                return v.charAt(0);
            }
            return v;
        }
    }
}
