package ss10_dsa_list.bai_tap.LinkedList;


public class LinkedList<E> {

    private class Node {
        private Node next;
        private Object data;


        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    // phần từ đầu tiên của danh sách liên kết
    private Node head;

    //Số lượng phần tử trong danh sách
    private int numNode = 0;

    public LinkedList() {
    }

    // thêm 1 pt vào đầu danh sách
    public void addFirst(E element) {
        //khai báo 1 biến là temp trỏ dến giá trị của head
        Node temp = head;
        //biến head sẽ nhận giá trị là 1 node mới
        head = new Node(element);
        //head.next trỏ đến temp
        head.next = temp;
        numNode++;
    }

    // thêm pt  vào cuối danh sách
    public void addLast(E element) {
        //khai báo biến temp trỏ đến head
        Node temp = head;
        //sẽ cho con trỏ chạy đến phẩn từ cuối cùng của danh sách
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(element);
        numNode++;
    }

    public void add(int index, E element) {
        // khai báo biến temp trỏ đến head
        Node temp = head;

        // khai báo 1 node là holder
        Node holber;

        // cho con trỏ chạy đến vị tró index -1
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        // cho holder tham chiếu đến vị trí index
        holber = temp.next;
        //Node tại vị trí index-1 sẽ trỏ tới node mới
        temp.next = new Node((element));
        //node mới sẽ trỏ đến holder
        temp.next.next = holber;
        // tăng số lượng pt trong danh sách lên 1
        numNode++;
    }

    public Object get(int index) {
        // khai báo biến temp trỏ tới head
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public int size() {
        return numNode;
    }

    // xóa pt ở vị trí cần xóa
    public E remove(int index) {
        if (index < 0 || index > numNode) {
            throw new IllegalArgumentException("Error: " + index);
        }
        // khai báo biến temp trỏ đến head
        Node temp = head;
        Object data;

        // nếu index = 0 thì sẽ trả về data hiện tại
        if (index == 0) {
            data = temp.data;
            head = head.next;
            numNode--;
        } else {
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            data = temp.next.data;
            temp.next = temp.next.next;
            numNode--;
        }
        return (E) data;
    }

    public boolean remove(E element) {
        // Remove đối tượng nếu element head
        if (head.data.equals(element)) {
            remove(0);
        } else {
            // Khai báo 1 node temp trỏ đến head
            Node temp = head;
            while (temp.next != null) {
                // Nếu như tồn tại pt có data bằng data truyền vào thì node đó sẽ bị remove
                if (temp.next.data.equals(element)) {
                    temp.next = temp.next.next;
                    numNode--;
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    // sao chép
    public LinkedList<E> clone() {
        // kiểm tra xem LinkedList có pt không
        if (numNode == 0) {
            throw new IllegalArgumentException("LinkedList này null");
        }
        // khai báo linkedList trả về
        LinkedList<E> returnLinkedList = new LinkedList<>();
        // khai báo 1 temp trỏ đến head
        Node temp = head;
        //add temp vào danh sách trả về nó làm head
        returnLinkedList.addFirst((E) temp.data);
        temp = temp.next;
        while (temp != null) {
            returnLinkedList.addLast((E) temp.data);
            temp = temp.next;
        }
        return returnLinkedList;
    }

    // kiểm tra 1 pt có tồn tại hay ko
    public boolean constranins(E element) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.data.equals(element)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // tìm 1 pt nào đó
    public int indexOf(E element) {
        Node temp = head;
        for (int i = 0; i < numNode; i++) {
            if (temp.getData().equals(element)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public E getFist(int index) {
        Node temp = head;
        return (E) temp.data;
    }

    public E getLast() {
        Node temp = head;
        while (temp.next !=null) {
            if (temp.next != null) {
                temp = temp.next;
            }

        }
        return (E) temp.data;
    }

    public void clear (){
        Node temp = head;
        while (temp.next != null) {
            temp.data = null;
            temp = temp.next;
        }
        numNode =0;
    }
}

