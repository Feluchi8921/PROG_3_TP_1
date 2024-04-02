package Ej_7;

import Ej_1.Node;

public class List<T> {
    //Atributos
    private Node<T> first;
    private int size;

    //Constructor
    public List() {
        this.first = null;
        this.size = 0;
    }

    //Metodos
    //Insertar un elemento al frente de la lista
    public void insertFront(T info) {
        Node<T> newNodo = new Node<T>(info, null); //Creo un nodo
        newNodo.setNext(this.first); //Busco el siguiente del primer nodo
        this.first = newNodo; //el primero se vuelve el nuevo nodo
        size++;
    }

    //Extraer un elemento del frente de la lista
    public T extractFront() {
        if (isEmpty()) {
            return null;
        }
        T dato = first.getInfo();
        first = first.getNext();
        size--;
        return dato;
    }


    //Get size
    public int getSize() {
        return size;
    }

    //Size
    public boolean isEmpty() {
        return size == 0;
    }

    //Obtiene el elemento en la posición indicada
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getInfo();
    }

    //Retornar la posicion del elemento pasado por parámetro
    public int indexOf(T info) {
        Node<T> current = first;
        for (int i = 0; i < this.size; i++) {
            if (current.getInfo().equals(info)) {
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }

    //Metodo diferencia
    public List<T> subtraction(List<T> l1, List<T> l2) {
        // Creamos una nueva lista para la diferencia
        List<T> subtractionList = new List<>();

        // Iteramos a través de l1
        for (int i = 0; i < l1.getSize(); i++) {
            boolean found = false;

            // Iteramos a través de l2
            for (int j = 0; j < l2.getSize(); j++) {
                if (l1.get(i).equals(l2.get(j))) { // Comparamos elementos de l1 y l2
                    found = true;
                    break; // Elemento encontrado en l2, salimos del bucle interno
                }
            }

            // Si el elemento no se encontró en l2, lo agregamos
            if (!found) {
                subtractionList.insertFront(l1.get(i)); // Añadimos
            }
        }

        return subtractionList;
    }
    //String
    // Devuelve una representación String de la lista
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = first;
        while (current != null) {
            sb.append(current.getInfo()).append(", ");
            current = current.getNext();
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }
}