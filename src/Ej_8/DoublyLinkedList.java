package Ej_8;

import javax.print.attribute.standard.NumberOfDocuments;
import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T>{

    //Atributos
    private Node<T> first;
    private Node<T> last;
    private int size;

    //Constructores
    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public DoublyLinkedList(Node<T> first, Node<T> last, int size) { //Preguntar si esta bien dejarlo
        this.first = first;
        this.last = last;
        this.size = size;
    }

    //!!!! No devolver informacion, no debo devolver nodos con informacion
    // Por eso elimine los set y get de setLast

    //Metodos desde el inicio:
    //Insertar un elemento al frente de la lista
    public void insertFront(T info) {
        Node<T> newNodo = new Node<T>(info, null, null); //Creo un nodo
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

    //Empty
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

    //Metodos desde el fin
    public void insertBack(T dato) {
        Node<T> nuevoNodo = new Node<>(dato, null,null);

        // Encontrar el último nodo
        Node<T> actual = first;
        while (actual.getNext() != null) {
            actual = actual.getNext();
        }

        // Enlazar el nuevo nodo
        actual.setNext(nuevoNodo);
        nuevoNodo.setPrevious(actual);

        // Actualizar el puntero head si la lista está vacía
        if (first == null) {
            first = nuevoNodo;
        }
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

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(this.first); //Creo un iterador y le paso el primer elemento
    }
}
