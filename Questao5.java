class Node<E> {
    E data;
    Node<E> next;

    //Construtores
    Node () {
        this.data = null;
        this.next = null;
    }

    Node(E data) {
        this.data = data;
        this.next = null;
    }

    //Getters
    public E getData() { return data;}
    public Node<E> getNext() { return next;}

    //Setters
    public void setNext(Node<E> next) { this.next = next;}
    public void setData(E data) { this.data = data; }
}

class LinkedList<E> {
    private Node<E> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> current = head;
        if (index == 0) {
            head = head.next;
        } else {
            Node<E> previous = null;
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.next;
            }
            previous.next = current.next;
        }
        size--;
        return current.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

public class Questao5 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("Removed element at index 3: " + list.remove(3));
        System.out.println("Size of the list: " + list.size());
        System.out.println("Is list empty? " + list.isEmpty());
    }
}
