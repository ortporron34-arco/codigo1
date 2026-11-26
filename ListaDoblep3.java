import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ListaDoblep3<T> implements Iterable<T> {

    private NodoDoble<T> cabeza;
    private NodoDoble<T> cola;
    private int tamano;

    public boolean estaVacia() { return cabeza == null; }
    public int tamano() { return tamano; }

    // ---------- Inserción ----------
    public void insertarInicio(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (estaVacia()) {
            cabeza = cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.previo = nuevo;
            cabeza = nuevo;
        }
        tamano++;
    }

    public void insertarFinal(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (estaVacia()) {
            cabeza = cola = nuevo;
        } else {
            nuevo.previo = cola;
            cola.siguiente = nuevo;
            cola = nuevo;
        }
        tamano++;
    }

    public void insertarEn(int pos, T dato) {
        if (pos < 0 || pos > tamano)
            throw new IndexOutOfBoundsException("Posición inválida: " + pos);
        if (pos == 0) { insertarInicio(dato); return; }
        if (pos == tamano) { insertarFinal(dato); return; }

        NodoDoble<T> siguiente = nodoEn(pos);
        NodoDoble<T> anterior = siguiente.previo;
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        nuevo.previo = anterior;      // 1° enlaces del nuevo nodo
        nuevo.siguiente = siguiente;  // 2°
        anterior.siguiente = nuevo;   // 3° enlaces de los vecinos
        siguiente.previo = nuevo;     // 4°
        tamano++;
    }

    // ---------- Eliminación ----------
    public T eliminarInicio() {
        if (estaVacia()) throw new NoSuchElementException("Lista vacía");
        return eliminarNodo(cabeza);
    }

    public T eliminarFinal() { // O(1): la cola conoce a su penúltimo
        if (estaVacia()) throw new NoSuchElementException("Lista vacía");
        return eliminarNodo(cola);
    }

    public boolean eliminar(T dato) {
        for (NodoDoble<T> n = cabeza; n != null; n = n.siguiente) {
            if (Objects.equals(n.dato, dato)) {
                eliminarNodo(n);
                return true;
            }
        }
        return false;
    }

    /** Desconecta un nodo ya localizado en O(1). */
    private T eliminarNodo(NodoDoble<T> n) {
        if (n.previo == null) cabeza = n.siguiente;
        else n.previo.siguiente = n.siguiente;

        if (n.siguiente == null) cola = n.previo;
        else n.siguiente.previo = n.previo;

        T dato = n.dato;
        n.previo = n.siguiente = null; // evita referencias colgantes
        tamano--;
        return dato;
    }

    // ---------- Consulta ----------
    public T obtener(int pos) {
        if (pos < 0 || pos >= tamano)
            throw new IndexOutOfBoundsException("Posición inválida: " + pos);
        return nodoEn(pos).dato;
    }

    public int indiceDe(T dato) {
        int i = 0;
        for (NodoDoble<T> n = cabeza; n != null; n = n.siguiente, i++) {
            if (Objects.equals(n.dato, dato)) return i;
        }
        return -1;
    }

    public boolean contiene(T dato) { return indiceDe(dato) != -1; }

    // ---------- Inversión ----------
    public void invertir() {
        NodoDoble<T> actual = cabeza;
        while (actual != null) {
            NodoDoble<T> sig = actual.siguiente;
            actual.siguiente = actual.previo; // cada nodo intercambia sus enlaces
            actual.previo = sig;
            actual = sig;
        }
        NodoDoble<T> tmp = cabeza;
        cabeza = cola;
        cola = tmp;
    }

    // ---------- Utilidades ----------
    /** Parte del extremo más cercano: recorre a lo sumo la mitad de la lista. */
    private NodoDoble<T> nodoEn(int pos) {
        NodoDoble<T> n;
        if (pos < tamano / 2) {
            n = cabeza;
            for (int i = 0; i < pos; i++)
                n = n.siguiente;
        } else {
            n = cola;
            for (int i = tamano - 1; i > pos; i--)
                n = n.previo;
        }
        return n;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private NodoDoble<T> actual = cabeza;

            public boolean hasNext() { return actual != null; }

            public T next() {
                if (actual == null) throw new NoSuchElementException();
                T dato = actual.dato;
                actual = actual.siguiente;
                return dato;
            }
        };
    }

    /** Recorrido de cola a cabeza: for (T x : lista.reversa()) { ... } */
    public Iterable<T> reversa() {
        return () -> new Iterator<>() {
            private NodoDoble<T> actual = cola;

            public boolean hasNext() { return actual != null; }

            public T next() {
                if (actual == null) throw new NoSuchElementException();
                T dato = actual.dato;
                actual = actual.previo;
                return dato;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("null");
        for (T dato : this) sb.append(" ↔️ ").append(dato);
        return sb.append(" ↔️ null").toString();
    }

    public String toStringReversa() {
        StringBuilder sb = new StringBuilder("null");
        for (T dato : reversa()) sb.append(" ↔️ ").append(dato);
        return sb.append(" ↔️ null").toString();
    }

    // ---------- Programa de prueba ----------
    public static void main(String[] args) {
        ListaDoblep3<Integer> lista = new ListaDoblep3<>();
        lista.insertarFinal(20);
        lista.insertarFinal(30);
        lista.insertarInicio(10);
        lista.insertarEn(2, 25);
        System.out.println(lista); // null ↔️ 10 ↔️ 20 ↔️ 25 ↔️ 30 ↔️ null
        System.out.println(lista.toStringReversa()); // null ↔️ 30 ↔️ 25 ↔️ 20 ↔️ 10 ↔️ null

        lista.eliminar(20);
        lista.eliminarFinal(); // O(1) en la lista doble
        System.out.println(lista); // null ↔️ 10 ↔️ 25 ↔️ null

        lista.invertir();
        System.out.println(lista); // null ↔️ 25 ↔️ 10 ↔️ null
        System.out.println(lista.indiceDe(10)); // 1
        System.out.println(lista.contiene(99)); // false
        System.out.println(lista.tamano()); // 2

        // Casos borde: vaciar la lista y volver a usarla
        lista.eliminarInicio();
        lista.eliminarFinal();
        System.out.println(lista.estaVacia()); // true
        lista.insertarInicio(7);
        System.out.println(lista); // null ↔️ 7 ↔️ null

        // Recorrido en ambos sentidos
        ListaDoblep3<String> nombres = new ListaDoblep3<>();
        nombres.insertarFinal("Ana");
        nombres.insertarFinal("Luis");
        nombres.insertarFinal("Marta");
        for (String n : nombres) System.out.print(n + " "); // Ana Luis Marta
        System.out.println();
        for (String n : nombres.reversa()) System.out.print(n + " "); // Marta Luis Ana
        System.out.println();

        // Excepción esperada
        try {
            nombres.obtener(5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage()); // Posición inválida: 5
        }
    }
}

/** Nodo de la lista doble: dato y referencias al anterior y al siguiente. */
class NodoDoble<T> {
    T dato;
    NodoDoble<T> previo;
    NodoDoble<T> siguiente;

    NodoDoble(T dato) {
        this.dato = dato;
    }
}