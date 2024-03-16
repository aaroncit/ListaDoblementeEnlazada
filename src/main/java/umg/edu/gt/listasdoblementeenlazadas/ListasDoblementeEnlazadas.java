package umg.edu.gt.listasdoblementeenlazadas;

public class ListasDoblementeEnlazadas {

    public static void main(String[] args) {
        ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();

        lista.agregarInicio("A");
        lista.agregarInicio("B");
        lista.agregarFinal("C");
        lista.agregarFinal("D");

        System.out.println("Lista original:");
        lista.recorrerLista();

        lista.buscarNodo("B"); // Buscar un nodo que está en la lista
        lista.buscarNodo("E"); // Buscar un nodo que no está en la lista

        lista.insertarMedio("X", "C"); // Insertar un nuevo nodo después de un dato específico

        lista.eliminarMedio("C"); // Eliminar un nodo específico

        lista.revertirLista(); // Revertir la lista doble

        int tamano = lista.tamanoLista(); // Obtener el tamaño de la lista

        lista.eliminarDuplicados(); // Eliminar duplicados de la lista

        // Mostrar la lista después de realizar las operaciones
        System.out.println("\nLista después de operaciones:");
        lista.recorrerLista();

        // Mostrar el tamaño de la lista
        System.out.println("Tamaño de la lista: " + tamano);
    }
}
