// uso de memoria estatica
public class ejemplo7 {
    private int contador = 0;
public static int contadorEstatico = 0;

    public ejemplo7() {
        contador++;
    }

    public void incrementarContador() {
        contador++;
    }

    public int getContador() {
        return contador;
    }
    public static void incrementarContadorEstatico() {
        contadorEstatico++;
    }
    public static int getContadorEstatico() {
        return contadorEstatico;
    }

    public static void main(String[] args) {
        ejemplo7 obj1 = new ejemplo7();
        ejemplo7 obj2 = new ejemplo7();

        System.out.println("Contador del objeto 1: " + obj1.getContador());
        System.out.println("Contador del objeto 2: " + obj2.getContador());
        ejemplo7.incrementarContadorEstatico();


        obj1.incrementarContador();
        obj2.incrementarContador();

        System.out.println("Contador del objeto 1 después de incrementar: " + obj1.getContador());
        System.out.println("Contador del objeto 2 después de incrementar: " + obj2.getContador());
        System.out.println("Contador estático después de incrementar: " + ejemplo7.getContadorEstatico());
    }
}