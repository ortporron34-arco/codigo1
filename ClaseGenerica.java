public class ClaseGenerica<T, U> {

    private T dato1;
    private U dato2;

    public ClaseGenerica(T dato1, U dato2) {
        this.dato1 = dato1;
        this.dato2 = dato2;
    }

    public void verificarOperacion() {

        if (dato1 instanceof Boolean || dato2 instanceof Boolean) {

            if(dato1 instanceof String || dato2 instanceof String) {
                System.out.println("Sí se pueden concatenar String y Boolean.");
            } else {
                System.out.println("No se pueden realizar operaciones con Boolean.");
            }

        } else if (dato1 instanceof String && dato2 instanceof String) {
            System.out.println("Sí se pueden concatenar String.");

        } else if (esNumero(dato1) && esNumero(dato2)) {
            System.out.println("Sí se pueden realizar operaciones numéricas.");
        }

    }

    private boolean esNumero(Object dato) {
        return dato instanceof Integer ||
               dato instanceof Double ||
               dato instanceof Float;
    }

  public static void main(String[] args) {

    ClaseGenerica<Integer, Double> obj1 =
            new ClaseGenerica<>(10, 5.5);
    obj1.verificarOperacion();

    ClaseGenerica<String, Boolean> obj2 =
            new ClaseGenerica<>("Hola ", true);
    obj2.verificarOperacion();

    ClaseGenerica<Boolean, Boolean> obj3 =
            new ClaseGenerica<>(true, false);
    obj3.verificarOperacion();

    }
}