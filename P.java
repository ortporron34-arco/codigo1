import java.util.Scanner;
class PILA {
    int LimitePila = 10;
    int[] pila = new int[LimitePila];
    int indice = 0;

    public boolean verificaLlena() {
        if (indice >= LimitePila) {
            System.out.println("pila llena");
            return true;
        }
        return false;
    }
    public boolean verificaVacia() {
        if (indice <= 0) {
            System.out.println("pila vacia");
            return true;
        }
        return false;
    }
    public void insertar (int valor) {
        if (!verificaLlena()) {
            pila[indice] = valor;
            indice = indice + 1;
            System.out.println("se inserto");
        }
    }
    public void borrar() {
        if (!verificaVacia()) {
            indice = indice - 1;
            System.out.println("se borro");
        }
    }
    public void listar() {
        if (indice ==0) {
            System.out.println("pila vacia");
            return;
        }
        System.out.println("Elementos de la pila:");
        for (int i = indice - 1; i >= 0; i--) {
            System.out.println("pila[" + i + "] = " + pila[i]);
        }
    }
}
public class P {
    public static void main(String[] args) {
        PILA pila = new PILA();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("1. Insertar");
            System.out.println("2. Borrar");
            System.out.println("3. Listar");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese un valor a insertar: ");
                        int valor = scanner.nextInt();
                        pila.insertar(valor);
                        break;
                    case 2:
                        pila.borrar();
                        break;
                    case 3:
                        pila.listar();
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); 
            }
        } while (opcion != 4);
        scanner.close();
    }
}