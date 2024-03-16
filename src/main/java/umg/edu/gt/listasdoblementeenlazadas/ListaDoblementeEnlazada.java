package umg.edu.gt.listasdoblementeenlazadas;

public class ListaDoblementeEnlazada {
    private NodoDoble primero;
    private NodoDoble ultimo;

    public ListaDoblementeEnlazada() {
        this.primero = null;
        this.ultimo = null;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public void agregarInicio(Object dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (estaVacia()) {
            primero = ultimo = nuevo;
        } else {
            nuevo.setSiguiente(primero);
            primero.setAnterior(nuevo);
            primero = nuevo;
        }
    }

    public void agregarFinal(Object dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (estaVacia()) {
            primero = ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
        }
    }

    public void eliminarInicio() {
        if (!estaVacia()) {
            if (primero == ultimo) {
                primero = ultimo = null;
            } else {
                primero = primero.getSiguiente();
                primero.setAnterior(null);
            }
        }
    }

    public void eliminarFinal() {
        if (!estaVacia()) {
            if (primero == ultimo) {
                primero = ultimo = null;
            } else {
                ultimo = ultimo.getAnterior();
                ultimo.setSiguiente(null);
            }
        }
    }

    public void recorrerLista() {
        NodoDoble actual = primero;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }

    public void buscarNodo(Object dato) {
        NodoDoble actual = primero;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                System.out.println("El dato " + dato + " se encuentra en la lista");
                return;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("El dato " + dato + " no se encuentra en la lista");
    }

    public void insertarMedio(Object dato, Object datoDespues) {
        NodoDoble actual = primero;
        while (actual != null) {
            if (actual.getDato().equals(datoDespues)) {
                NodoDoble nuevo = new NodoDoble(dato);
                nuevo.setSiguiente(actual.getSiguiente());
                if (actual.getSiguiente() != null) {
                    actual.getSiguiente().setAnterior(nuevo);
                }
                actual.setSiguiente(nuevo);
                nuevo.setAnterior(actual);
                if (actual == ultimo) {
                    ultimo = nuevo;
                }
                return;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("El dato " + datoDespues + " no se encuentra en la lista");
    }

    public void eliminarMedio(Object dato) {
        if (estaVacia()) {
            return;
        }
        NodoDoble actual = primero;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                if (actual == primero) {
                    eliminarInicio();
                } else if (actual == ultimo) {
                    eliminarFinal();
                } else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
                return;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("El dato " + dato + " no se encuentra en la lista");
    }

    public void revertirLista() {
        if (estaVacia() || primero == ultimo) {
            return;
        }
        NodoDoble actual = primero;
        NodoDoble temp = null;
        while (actual != null) {
            temp = actual.getAnterior();
            actual.setAnterior(actual.getSiguiente());
            actual.setSiguiente(temp);
            actual = actual.getAnterior();
        }
        if (temp != null) {
            ultimo = primero;
            primero = temp.getAnterior();
        }
    }

    public int tamanoLista() {
        int tamano = 0;
        NodoDoble actual = primero;
        while (actual != null) {
            tamano++;
            actual = actual.getSiguiente();
        }
        return tamano;
    }

    public void eliminarDuplicados() {
        NodoDoble actual = primero;
        while (actual != null) {
            NodoDoble comparar = actual.getSiguiente();
            while (comparar != null) {
                if (actual.getDato().equals(comparar.getDato())) {
                    if (comparar == ultimo) {
                        ultimo = comparar.getAnterior();
                    }
                    comparar.getAnterior().setSiguiente(comparar.getSiguiente());
                    if (comparar.getSiguiente() != null) {
                        comparar.getSiguiente().setAnterior(comparar.getAnterior());
                    }
                    comparar = comparar.getSiguiente();
                } else {
                    comparar = comparar.getSiguiente();
                }
            }
            actual = actual.getSiguiente();
        }
    }
}
