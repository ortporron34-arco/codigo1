import java.util.Scanner;

public class clase4 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingresa la primera medida: ");
        String dato1 = teclado.nextLine();

        System.out.print("Ingresa la segunda medida: ");
        String dato2 = teclado.nextLine();

        if (dato1.equalsIgnoreCase("true") || dato1.equalsIgnoreCase("false") ||
            dato2.equalsIgnoreCase("true") || dato2.equalsIgnoreCase("false")) {

            System.out.println("No se pueden hacer operaciones con valores booleanos");

        } else {
            try {
                double lado1 = Double.parseDouble(dato1);
                double lado2 = Double.parseDouble(dato2);

                double area = lado1 * lado2;
                double perimetro = 2 * (lado1 + lado2);
                double diferencia = lado1 - lado2;

                System.out.println("Área del rectángulo: " + area);
                System.out.println("Perímetro del rectángulo: " + perimetro);
                System.out.println("Diferencia entre lados: " + diferencia);

            } catch (Exception e) {
                System.out.println("Resultado de concatenar texto: " + dato1 + dato2);
            }
        }

        teclado.close();
    }
}
