import java.util.Scanner;

class Cola {

int limiteCola = 10;
int[] cola = new int[limiteCola];
int frente = 0;
int fin = 0;
public boolean verificallena() {
    if (fin >= limiteCola) {
        System.out.println("Cola llena");
        return true;
    }
    return false;
}
public boolean verificavacio() {
    if (frente == fin) {
        System.out.println("Cola está vacía");
        return true;
    }
    return false;
}
public void inserta(int valor) {
    if (!verificallena()) {
        cola[fin] = valor;
        fin = fin + 1;
        System.out.println("Elemento insertado correctamente.");
    }
}
public void borrar() {
    if (!verificavacio()) {
        System.out.println("Elemento Borrado: " + cola[frente]);
        frente = frente + 1;
    }
}
public void listar() {
    if (frente == fin) {
        System.out.println("La cola no tiene elementos para mostrar.");
        return;
    }
    System.out.print("Elementos de la Cola: ");
    for (int i = frente; i < fin; i++) {
        System.out.print("[" + cola[i] + "] ");
    }
    System.out.println();
}

}

public class colap2 {

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Cola miCola = new Cola();
    int opcion = 0;
    do {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Insertar");
        System.out.println("2. Borrar");
        System.out.println("3. Listar");
        System.out.println("4. Salir");
        System.out.print("Elija una opción: ");
        if (scanner.hasNextInt()) {
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Pide valor de cola: ");
                    int valor = scanner.nextInt();
                    miCola.inserta(valor);
                    break;
                case 2:
                    miCola.borrar();
                    break;
                case 3:
                    miCola.listar();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } else {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();
        }
    } while (opcion != 4);
    scanner.close();
}

}