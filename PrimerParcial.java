public class PrimerParcial {

    static class Identificador<T> {
        T dato;

        Identificador(T dato) {
            this.dato = dato;
        }

        String identificar() {
            if (dato instanceof Integer) return "Ingresaste un Entero";
            if (dato instanceof Float) return "Ingresaste un float";
            if (dato instanceof Double) return "Ingresaste un Double";
            if (dato instanceof Character) return "Ingresaste un Carácter";
            return "Ingresaste una cadena";
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: java PrimerParcial <valor>");
            return;
        }

        String v = args[0].trim();

        if (v.length() == 1) {
            char c = v.charAt(0);
            Identificador<Character> id = new Identificador<>(c);
            System.out.println(id.identificar());
            return;
        }

        try {
            int entero = Integer.parseInt(v);
            Identificador<Integer> id = new Identificador<>(entero);
            System.out.println(id.identificar());
            return;
        } catch (NumberFormatException e) {
        }

        try {
            if (v.contains(".")) {
                if (v.toLowerCase().endsWith("f")) {
                    float flotante = Float.parseFloat(v.substring(0, v.length() - 1));
                    Identificador<Float> id = new Identificador<>(flotante);
                    System.out.println(id.identificar());
                } else {
                    double doble = Double.parseDouble(v);
                    Identificador<Double> id = new Identificador<>(doble);
                    System.out.println(id.identificar());
                }
                return;
            }
        } catch (NumberFormatException e) {
        }

        Identificador<String> id = new Identificador<>(v);
        System.out.println(id.identificar());
    }
}
