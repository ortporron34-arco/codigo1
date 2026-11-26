public class primerpractica1 {
    public static void main(String[] args) {
if (args.length == 0) {
    System.out.println("POrfa ingrese un valor");
    return;
}
String input = args[0];
validartipo.analizarycontener(input);
    }
}
class contenervalor<T> {
    private T valor;
    public contenervalor(T valor) {
        this.valor = valor;
}
public T getValor() {
    return valor;
}
public String getTipo() {
    return valor.getClass().getSimpleName();
}
}
class validartipo {
    public static void analizarycontener(String input) {
        try {
            int valInt = Integer.parseInt(input);
            contenervalor<Integer> contenedor = new contenervalor<>(valInt);
            System.out.println("ingresaste un entero ");
            return;

        } catch (NumberFormatException e) {

        }
        if (input.toLowerCase(). endsWith("f")) {
            try {
                float valFloat = Float.parseFloat(input.substring(0, input.length() - 1));
                contenervalor<Float> contenedor = new contenervalor<>(valFloat);
                System.out.println("ingresaste un float");
                return;
            } catch (NumberFormatException e) {
               
            }
        }
        try {
            double valDouble = Double.parseDouble(input);
            contenervalor<Double> contenedor = new contenervalor<>(valDouble);
            System.out.println("ingresaste un double");
            return;
        } catch (NumberFormatException e) {
        }
        if (input.length() == 1) {
            
            contenervalor<Character> contenedor = new contenervalor<>(input.charAt(0));
            System.out.println("ingresaste un char");
            return;
        }
        contenervalor<String> contenedor = new contenervalor<>(input);
        System.out.println("ingresaste un String");
    }
}