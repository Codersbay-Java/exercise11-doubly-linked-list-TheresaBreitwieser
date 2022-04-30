package DoublyLinkedList;

public class DoublyLinkedListCustom implements MyListInterface {
    private Node head;
    private Node tail;
    private int size;


    @Override
    public void addFirst(int item) {
        Node newNode = new Node(item);
        if(isEmpty()){
            head= tail=newNode;
        } else {
            newNode.setNext(head);
            head=newNode;
        }
        size++;
    }

    @Override
    public void addLast(int item) {
        Node newNode = new Node(item);
        if(isEmpty()){
            head= tail=newNode;
        } else {
            newNode.setPrevious(tail);
            tail=newNode;
        }
        size++;
    }

    @Override
    public void addAtIndex(int index, int item) {
        if(index<0 || index>size){
            throw new IllegalArgumentException();
        } else if(index ==0) {
            addFirst(item);
        }else if(index==size) {
            addLast(item);
        } else {
            Node newNode = new Node(item);
            Node current = head;
            for(int i=0; i<index; i++) {
                current=current.getNext();
            }
            newNode.setNext(current);
            newNode.setPrevious(current.getPrevious());
            current.getPrevious().setNext(newNode);
            current.setPrevious(newNode);
        }
        size++;
    }

    @Override
    public void addElementAtRandomIndex(int value) {

    }

    @Override
    public Node removeFirst() {
        Node temp=null;
        if (isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        } else if (head.getNext() == null) {
            head = tail = null;
        } else {
            temp = head;
            head = head.getNext();
            size--;
        }
        return temp;
    }

    @Override
    public Node removeLast() {
        Node temp=null;
        if (isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        } else if (head.getNext() == null) {
            head = tail = null;
        } else {
            temp = tail;
            tail = tail.getPrevious();
            size--;
        }
        return temp;
    }

    @Override
    public Node removeAtIndex(int index) {
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head ==null;
    }

    @Override
    public void printList() {

    }

    @Override
    public void printListBackwards() {

    }

    @Override
    public int get(int index) throws IllegalArgumentException {
        return-1;
    }

    //schwierig
    @Override
    public void removeDuplicates() {
//wir gehen von sortierter liste aus [0,1,1,2] - [0,1,2]
    }

    //schwierig
    @Override
    public void reverseList() {

    }

    @Override
    public DoublyLinkedListCustom copyList() {
        return null; //liste 1:1 kopieren und duplikat liste wieder zurück geben
    }

    @Override
    public void clear() {
        //head, tail, size, null
    }

    //schwierig
    @Override
    public boolean insertAfter(int index, int data) {
        return false;
    }

    @Override
    public Node deleteKey(int index) {
        return null; //gelöschte Node zurückgeben
    }
}

