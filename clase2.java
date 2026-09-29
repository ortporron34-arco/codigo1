public class clase2<T, U> {

    private T dato1;
    private U dato2;

    public clase2(T dato1, U dato2) {
        this.dato1 = dato1;
        this.dato2 = dato2;
    }

    public void verificarOperacion(String operacion) {
        // 1. Si alguno es booleano, no se pueden hacer operaciones
        if (dato1 instanceof Boolean || dato2 instanceof Boolean) {
            System.out.println("No se pueden realizar operaciones con Boolean.");
            
        // 2. Si ambos son cadenas o caracteres, se concatenan
        } else if ((dato1 instanceof String || dato1 instanceof Character) && 
                   (dato2 instanceof String || dato2 instanceof Character)) {
            System.out.println("Concatenación: " + dato1.toString() + dato2.toString() + (operacion != null ? operacion : ""));
            
        // 3. Si ambos son numéricos, se aplican las operaciones S, R o M
        } else if (esNumero(dato1) && esNumero(dato2)) {
            double v1 = ((Number) dato1).doubleValue();
            double v2 = ((Number) dato2).doubleValue();
            
            switch (operacion.toUpperCase()) {
                case "S":
                    System.out.println("Suma (" + v1 + " + " + v2 + "): " + (v1 + v2));
                    break;
                case "R":
                    System.out.println("Resta (" + v1 + " - " + v2 + "): " + (v1 - v2));
                    break;
                case "M":
                    System.out.println("Multiplicación (" + v1 + " * " + v2 + "): " + (v1 * v2));
                    break;
                default:
                    System.out.println("Operación no válida.");
            }
        } else {
            System.out.println("Combinación de tipos no soportada para operaciones.");
        }
    }

    private boolean esNumero(Object dato) {
        return dato instanceof Integer || 
               dato instanceof Double || 
               dato instanceof Float ||
               dato instanceof Long;
    }

    public static void main(String[] args) {
        // Prueba con números y la operación "S" (Suma)
        clase2<Integer, Double> obj1 = new clase2<>(10, 5.5);
        obj1.verificarOperacion("S");

        // Prueba con cadenas
        clase2<String, String> obj2 = new clase2<>("Hola ", "Mundo");
        obj2.verificarOperacion("R");

        // Prueba con booleano (bloqueado automáticamente)
        clase2<Boolean, Boolean> obj3 = new clase2<>(true, false);
        obj3.verificarOperacion("M");
    }
}