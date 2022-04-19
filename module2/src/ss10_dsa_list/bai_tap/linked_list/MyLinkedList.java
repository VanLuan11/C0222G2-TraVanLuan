package ss10_dsa_list.bai_tap.linked_list;

public class MyLinkedList<E>{
    private Node head;
    private Node tail;
    private int numNodes = 0;

    public MyLinkedList(){

    }

    public MyLinkedList(Object data){
        head = new Node(data);
    }

    // thêm vào pt đầu
    public void addFirst(E e){
        Node newNode = new Node(e);
        newNode.next = head;
        head = newNode;
        numNodes++;

        if(tail == null){
            tail = head;
        }
    }

    // thêm vào pt cuối
    public void addLast(E e) {
        Node newNode = new Node(e);

        if (tail == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = tail.next;
        }

        numNodes++;
    }

    //thêm pt
    public void add(int index, Object data){
        Node temp = head;
        Node holder;

        for(int i=0; i < index-1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    // hiển thị tổng số pt
    public int size(){
        return numNodes;
    }

    // lấy pt ở vịt rí index
    public E get(int index){
        Node x = head;
        for(int i=0; i < index; i++){
            x = x.next;
        }
        return (E) x.data;
    }
    
    public boolean remove(Object o){
        if(o == null){
            for(Node i= head; i != null; i=i.next){
                if(i.data == null){
                    return true;
                }
            }
        }
        else{
            for(Node i= head; i!=null; i=i.next){
                if(o.equals(i.data)){
                    return true;
                }
            }
        }
        return false;
    }

    // lấy ra pt ở vị trí đầu
    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

// kiểm tra pt có tồn tại hay ko
    public boolean contains(E o){
        return indexOf(o) >=0;
    }

    public int indexOf(E o){
        int index = 0;
        if (o == null) {
            for (Node x = head; x != null; x = x.next) {
                if (x.data == null)
                    return index;
                index++;
            }
        } else {
            for (Node x = head; x != null; x = x.next) {
                if (o.equals(x.data))
                    return index;
                index++;
            }
        }
        return -1;
    }

    private class Node{
        private Node next;
        private Object data;

        public Node(Object data){
            this.data = data;
        }

        public Object getData(){
            return this.data;
        }
    }
}

