package ss10_dsa_list.thuc_hanh;

import java.util.Arrays;
import java.util.Scanner;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }
    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(5);
        listInteger.add(6);
        listInteger.add(7);
        listInteger.add(8);



        System.out.println("element 1: "+listInteger.get(1));
        System.out.println("element 2: "+listInteger.get(2));
        System.out.println("element 3: "+listInteger.get(3));
        System.out.println("element 4: "+listInteger.get(4));
        System.out.println("element 5: "+listInteger.get(5));
        System.out.println("element 6: "+listInteger.get(6));

        System.out.print("Nhap phan tu muon tim: ");
        int index = Integer.parseInt((new Scanner(System.in)).nextLine());

        System.out.println("Phan tu muon tim: " + listInteger.get(index) + " o vi tri: " + index);
    }
}
