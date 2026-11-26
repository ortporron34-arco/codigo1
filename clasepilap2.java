import java.util.Scanner;

public class clasepilap2 {

    int limitePila = 10;
    int[] ArregloPila = new int[limitePila];
    int indice = -1;

    Scanner entrada = new Scanner(System.in);

    void VerificarLleno() {
        if (indice == limitePila - 1) {
            System.out.println("Pila llena");
        }
    }

    void VerificarVacio() {
        if (indice == -1) {
            System.out.println("Pila esta vacia");
        }
    }

    void Insertar() {
        VerificarLleno();

        if (indice < limitePila - 1) {
            System.out.print("Inserta un numero: ");
            int valor = entrada.nextInt();

            indice++;
            ArregloPila[indice] = valor;

            System.out.println("Dato insertado correctamente");
        }
    }

    void Borrar() {
        VerificarVacio();

        if (indice >= 0) {
            System.out.println("Elemento borrado: " + ArregloPila[indice]);

            indice--;

            System.out.println("Dato eliminado correctamente");
        }
    }

    void Listar() {
        VerificarVacio();

        if (indice >= 0) {
            System.out.println("\nElementos de la pila:");

            for (int i = indice; i >= 0; i--) {
                System.out.println("| " + ArregloPila[i] + " |");
            }

            System.out.println("-----");
        }
    }

    public static void main(String[] args) {

        clasepilap2 objeto = new clasepilap2();

        int opcion;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Insertar");
            System.out.println("2. Borrar");
            System.out.println("3. Listar");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opcion: ");

            opcion = objeto.entrada.nextInt();

            switch (opcion) {

                case 1:
                    objeto.Insertar();
                    break;

                case 2:
                    objeto.Borrar();
                    break;

                case 3:
                    objeto.Listar();
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (opcion != 4);

        objeto.entrada.close();
    }
}