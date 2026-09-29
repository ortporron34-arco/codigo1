import java.util.ArrayList;
import java.util.List;

public class ejem10dinamico {
    public static void main(String[] args) {
        List<ejem10dato> lista = new ArrayList<>();
        lista.add(new ejem10dato("Juan", 25, "juan@example.com"));  
        lista.add(new ejem10dato("Maria", 30, "maria@example.com"));    
        lista.add(new ejem10dato("Pedro", 28, "pedro@example.com"));    
        lista.add(new ejem10dato("Ana", 22, "ana@example.com"));        

        for (ejem10dato persona : lista) {
            System.out.println("Nombre: " + persona.getNombre());
            System.out.println("Edad: " + persona.getEdad());
            System.out.println("Correo: " + persona.getCorreo());
            System.out.println("------------------------");
        }
    }
}