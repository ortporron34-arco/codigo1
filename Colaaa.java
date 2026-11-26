
import java.util.Scanner;

class ColaDatos {
    int limiteCola = 10;
    int[] cola = new int[limiteCola];
    int frente = 0;
    int fin = 0;

    public boolean verificallena() {
        return fin >= limiteCola;
    }

    public boolean verificavacio() {
        return frente == fin;
    }

    public void inserta(int valor) {
        if (verificallena()) {
            System.out.println("Cola llena, no se puede insertar.");
            return;
        }

        cola[fin] = valor;
        fin++;
        System.out.println("Elemento insertado: " + valor);
    }

    public void borrar() {
        if (verificavacio()) {
            System.out.println("La cola esta vacia.");
            return;
        }

        System.out.println("Elemento borrado: " + cola[frente]);
        frente++;

        if (frente == fin) {
            frente = 0;
            fin = 0;
        }
    }

    public void listar() {
        if (verificavacio()) {
            System.out.println("La cola no tiene elementos.");
            return;
        }

        System.out.print("Elementos de la Cola: ");

        for (int i = frente; i < fin; i++) {
            System.out.print("[" + cola[i] + "] ");
        }

        System.out.println();
    }
}

public class Colaaa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ColaDatos miCola = new ColaDatos();
        int opcion = 0;

        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Insertar");
            System.out.println("2. Borrar");
            System.out.println("3. Listar");
            System.out.println("4. Salir");
            System.out.print("Elija una opcion: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Pide valor de cola: ");

                        if (scanner.hasNextInt()) {
                            int valor = scanner.nextInt();
                            miCola.inserta(valor);
                        } else {
                            System.out.println("Ingrese un numero valido.");
                            scanner.next();
                        }
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
                        System.out.println("Opcion no valida.");
                }

            } else {
                System.out.println("Ingrese un numero valido.");
                scanner.next();
            }

        } while (opcion != 4);

        scanner.close();
    }
}
