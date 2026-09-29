 public class clase3<T> {

    private T obj1;
    private T obj2;

    public clase3(T obj1, T obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void operar(String operacion) {

        // Si los dos objetos son numéricos
        if (obj1 instanceof Number && obj2 instanceof Number) {

            double num1 = ((Number) obj1).doubleValue();
            double num2 = ((Number) obj2).doubleValue();

            if (operacion.equalsIgnoreCase("suma")) {
                System.out.println("Resultado: " + (num1 + num2));

            } else if (operacion.equalsIgnoreCase("resta")) {
                System.out.println("Resultado: " + (num1 - num2));

            } else if (operacion.equalsIgnoreCase("multiplicacion")) {
                System.out.println("Resultado: " + (num1 * num2));

            } else {
                System.out.println("Operación no válida.");
            }

        // Si son String o Character
        } else if ((obj1 instanceof String || obj1 instanceof Character) &&
                   (obj2 instanceof String || obj2 instanceof Character)) {

            if (operacion.equalsIgnoreCase("concatenar")) {
                System.out.println("Resultado: " + obj1 + obj2);
            } else {
                System.out.println("Con cadenas o caracteres solo se puede concatenar.");
            }

        // Si alguno es Boolean
        } else if (obj1 instanceof Boolean || obj2 instanceof Boolean) {

            System.out.println("No se pueden realizar operaciones con Boolean.");

        // Tipos diferentes
        } else {

            System.out.println("Los tipos de datos no son compatibles.");
        }
    }

    public static void main(String[] args) {

        clase3<Integer> objNumeros =
                new clase3<>(27, 13);

        objNumeros.operar("suma");
        objNumeros.operar("resta");
        objNumeros.operar("multiplicacion");

        System.out.println();

        clase3<String> objCadenas =
                new clase3<>("Hola ", "Como estas?");

        objCadenas.operar("concatenar");

        System.out.println();

        clase3<Boolean> objBooleanos =
                new clase3<>(true, false);

        objBooleanos.operar("suma");
    }
}
