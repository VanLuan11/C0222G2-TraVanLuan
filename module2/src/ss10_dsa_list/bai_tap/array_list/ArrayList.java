package ss10_dsa_list.bai_tap.array_list;


import java.util.Arrays;

public class ArrayList<E> {
     private int size = 0;
     private static  int DEFAULT_CAPACITY = 10;
     Object elements[];

    public ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public ArrayList(int capacity){
        if(capacity > 0){
            elements = new Object[capacity];
        }else {
            throw new IllegalArgumentException("capacity: " + capacity);
        }

    }

    // thêm phân tử
    public boolean add (E element){
        if(elements.length == size){
            this.ensureCapacity(10);
        }
        elements[size] = element;
        size ++;
        return true;
    }
    public void add(E element, int index ){
        if ( index > elements.length){
            throw new IllegalArgumentException("index: " + index);
        }else if(elements.length == size){
            this.ensureCapacity(10);
        }
        if (elements[index] == null){
            elements[index] = element;
            size ++;
        }else{
            for (int i = size+1; i >= index ; i--) {
                elements[i] = elements[i-1];
            }
            elements[index] = element;
            size++;
        }
    }

    // xóa pt ra khỏi mảng
    public E remove(int index){
        if(index < 0|| index >+elements.length){
            throw new IllegalArgumentException("Error index: " +index);
        }
        E element = (E) elements[index];

        for (int i = index; i < size -1 ; i++) {
            elements[i] = elements[i +1];
        }
        elements[size - 1] =  null;
        size--;
        return element;

    }

    //pt trả về số lượng đủ phần tử
    public int size(){
        return this.size;

    }

    // tạo ra 1 bản sao của Array list
    public E clone(){
        ArrayList<E> v = new ArrayList<>();
        v.elements = Arrays.copyOf(this.elements,this.size);
        v.size  = this.size;
        return (E) v;
    }

    // kiểm tra pt cót tồn lại hay ko
    public boolean contains(E o){
        return this.indexOf(o) >=0;
    }

    // lấy số thứ tự của 1 pt
    public int indexOf(E element){
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(element)){
                return  i;
            }
        }
        return  index;
    }

    //pt tăng kích thước
    public void ensureCapacity(int minCapacity){
        if(minCapacity >=0 ){
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        }else{
            throw new IllegalArgumentException("minCapacity: " + minCapacity);
        }
    }

    // lấy 1 pt ở vị trí i
    public E get (int i){
        return (E) elements[i];
    }

    // xóa tất cả các phần tử
    public void clear(){
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;

        }

    }


}
