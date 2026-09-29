public class LlamaPractica1 {
    public static void main(String[] args) {
        Practica1<String, String> ejemplo1 = new Practica1<>("Hola", "Mundo");
        ejemplo1.verificatipo();

        Practica1<Integer, Integer> ejemplo2 = new Practica1<>(5, 10);
        ejemplo2.verificatipo();

        Practica1<Double, Double> ejemplo3 = new Practica1<>(5.5, 10.5);
        ejemplo3.verificatipo();

        Practica1<Boolean, Boolean> ejemplo4 = new Practica1<>(true, false);
        ejemplo4.verificatipo();

        Practica1<Character, Character> ejemplo5 = new Practica1<>('A', 'B');
        ejemplo5.verificatipo();

        Practica1<Float, Float> ejemplo6 = new Practica1<>(5.5f, 10.5f);
        ejemplo6.verificatipo();

        Practica1<String, Integer> ejemplo7 = new Practica1<>("Hola", 10);
        ejemplo7.verificatipo();
    }
}
