import java.util.Scanner;
public class clase8<T, U> {
    private T valor1;
    private U valor2;
    public clase8(T valor1, U valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public T getValor1() {
        return valor1;
    }

    public void setValor1(T valor1) {
        this.valor1 = valor1;
    }

    public U getValor2() {
        return valor2;
    }

    public void setValor2(U valor2) {
        this.valor2 = valor2;
    }
    public void verificatino() {
        if (valor1 instanceof String && valor2 instanceof String) {
            System.out.println("Ambos valores son de tipo String");
            System.out.println("Resultado: " + valor1 + valor2);
        } else if (valor1 instanceof Integer && valor2 instanceof Integer) {
            System.out.println("Ambos valores son de tipo Integer");
            operaciones();
        } else if (valor1 instanceof Double && valor2 instanceof Double) {
            System.out.println("Ambos valores son de tipo Double");
            operaciones();
        } else if (valor1 instanceof Boolean && valor2 instanceof Boolean) {
            System.out.println("Ambos valores son de tipo Boolean");
            System.out.println("No se pueden hacer operaciones");
        } else if (valor1 instanceof Character && valor2 instanceof Character) {
            System.out.println("Ambos valores son de tipo Character");
            System.out.println("Resultado: " + valor1 + valor2);
        } else if (valor1 instanceof Float && valor2 instanceof Float) {
            System.out.println("Ambos valores son de tipo Float");
            operaciones();
        } else {
            System.out.println("Los tipos de datos son mixtos o no compatibles");
        }
    }
    public void operaciones() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("Menu de opciones");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.print("Que opcion desea realizar: ");
        opcion = scanner.nextInt();

        double n1 = Double.parseDouble(valor1.toString());
        double n2 = Double.parseDouble(valor2.toString());

        switch (opcion) {
            case 1:
                System.out.println("La suma es: " + (n1 + n2));
                break;
            case 2:
                System.out.println("La resta es: " + (n1 - n2));
                break;
            case 3:
                System.out.println("La multiplicacion es: " + (n1 * n2));
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public static void main(String[] args) {
        clase8<Integer, Integer> objNum = new clase8<>(10, 5);
        objNum.verificatino();

    }
}
