package musicpreferencevisualization;

import java.util.Iterator;
import java.util.ListIterator;

public class LList<E> {
    
    private class Node<D> {
        private D data;
        private Node<D> next;
        
        public Node(D d) {
            data = d;
        }
        
        public void setNext(Node<D> n) {
            next = n;
        }
        
        public D data() {
            return data;
        }
        
        public Node<D> next() {
            return next;
        }
    }
    
    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    public LList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public void add(E element) {
        if (head == null) {
            head = new Node<E>(element);
            tail = head;
        }
        else {
            tail.setNext(new Node<E>(element));
            tail = tail.next();
        }
        size++;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        else {
            Node<E> current = head;
            if (index == 0) {
                current = new Node<E>(element);
                current.setNext(head);
                head = current;
            }
            else {
                index--;
                for (int i = 0; i < index; i++) {
                    current = current.next();
                }
                Node<E> temp = current.next();
                current.setNext(new Node<E>(element));
                current.next.setNext(temp);
            }
            size++;
        }
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean contains(Object element) {
        if (head.data() == element || tail.data() == element ) {
            return true;
        }
        else {
            Node<E> current = head.next();
            for (int i = 0; i < size; i ++) {
                if (current.data == element) {
                    return true;
                }
                current = current.next();
            }
            return false;
        }
    }

    public E get(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        for (int i = 0; i < index; i ++) {
            current = current.next();
        }
        return current.data();
    }

    public int indexOf(Object element) {
        Node<E> current = head;
        for (int i = 0; i < size; i ++) {
            if (current.data() == element) {
                return i;
            }
            current = current.next();
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    public int lastIndexOf(Object element) {
        Node<E> current = head;
        int j = -1;
        for (int i = 0; i < size; i ++) {
            if (current.data() == element) {
                j = i;
            }
            current = current.next();
        }
        return j;
    }

    public ListIterator<E> listIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    public ListIterator<E> listIterator(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean remove(Object element) {
        Node<E> current = new Node<E>(null);
        current.setNext(head);
        boolean flag = false;
        int i;
        for (i = 0; i < size; i ++) {
            if (current.next.data() == element) {
                flag = true;
                break;
            }
            current = current.next();
        }
        if (flag) {
            removeCleanUp(i, current);
        }
        return flag;
    }

    public E remove(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = new Node<E>(null);
        current.setNext(head);
        for (int i = 0; i < index; i ++) {
            current = current.next();
        }
        E element = current.next.data();
        size--;
        removeCleanUp(index, current);
        return element;
    }

    private void removeCleanUp(int index, Node<E> current) {
        if (index == size - 1) {
            current.setNext(null);
            tail = current;
        }
        else if (size == 0) {
            head = null;
            tail = null;
        }
        else if (current.next == head) {
            head = head.next();
        }
        else {
            current.setNext(current.next().next());
        }
    }
    
    public int size() {
        return size;
    }
    
    public void sort() {
        head = sort(head, size);
        tail = findtail(head, size);
    }
    
    private Node<E> sort(Node<E> head, int size) {
        Node<E> head1 = null;
        int size1 = 0;
        Node<E> head2 = null;
        int size2 = 0;
        Node<E> head3 = new Node<E>(head.data());
        int size3 = 1;
        Node<E> current = head.next();
        E data = head.data();
        Node<E> temp;
        for (int i = 1; i < size; i ++) {
            int j = ((String) data).compareTo((String) current.data());
            temp = new Node<E>(current.data);
            if (j > 0) {
                temp.setNext(head1);
                head1 = temp;
                size1++;
            }
            else if (j < 0) {
                temp.setNext(head2);
                head2 = temp;
                size2++;
            }
            else {
                temp.setNext(head3);
                head3 = temp;
                size3++;
            }
            current = current.next();
        }
        if (head2 != null && head2.data() != null) {
            head2 = sort(head2, size2);
            findtail(head3, size3).setNext(head2);
        }
        if (head1 != null && head1.data() != null) {
            head1 = sort(head1, size1);
            findtail(head1, size1).setNext(head3);
            return head1;
        }
        else {
            return head3;
        }
    }
    
    private Node<E> findtail(Node<E> head, int size) {
        Node<E> current = head;
        for (int i = 0; i < size - 1; i ++) {
            current = current.next();
        }
        return current;
    }

    public String toString(){
        Node<E> current = head;
        String str = "{";
        for (int i = 0; i < size - 1; i ++) {
            str = str + current.data() + ", ";
            current = current.next();
        }
        str = str + current.data() + "}";
        return str;
    }
}
