package DoublyLinkedList;


import java.util.Random;

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
            head.setPrevious(newNode);
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
            tail.setNext(newNode);
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
        Random random = new Random();
        int randomIndex = random.nextInt(size);
        addAtIndex(randomIndex, value);
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
            tail.setNext(null);
            size--;
        }
        return temp;
    }

    @Override
    public Node removeAtIndex(int index) {
        Node current;
        if(isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        } else {
            current=head;
            for(int i=0; i<index; i++) {
                current=current.getNext();
            }
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
            size--;
        }
        return current;
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
        Node current = head;
       while(current !=null) {
           System.out.print(current.getValue() + ",");
           current=current.getNext();
       }if(isEmpty())
       {
            System.out.println("list is empty");
        }
        System.out.println();
    }

    @Override
    public void printListBackwards() {
        Node current = tail;
        while(current !=null){
            System.out.print(current.getValue() + ",");
            current=current.getPrevious();
        }
        System.out.println();
    }

    @Override
    public int get(int index) {
        Node current=head;
        if(isEmpty()){
            throw new IllegalArgumentException("List is empty");
        } else if(index>=size){
            throw new IllegalArgumentException("Index is out of range");
        } else {
            for(int i=0; i<index; i++) {
                current=current.getNext();
            }
        }
        return current.getValue();
    }

    //wir gehen von sortierter liste aus [0,1,1,2] - [0,1,2]
    @Override
    public void removeDuplicates() {
        Node current=head;
        if(isEmpty()) {
            throw new IllegalArgumentException("list is empty");
        } else {
            for(int i=0; i<size-1; i++) {
               while(current.getValue() == current.getNext().getValue()) {
                   removeAtIndex(i+1);
               }
                current=current.getNext();
            }
        }
    }


    @Override
    public void reverseList() {
        Node tempTail = tail;
        tail=head;
        head=tempTail;

        Node current=head;

        while(current !=null) {
            Node temp2=current.getNext();
            current.setNext(current.getPrevious());
            current.setPrevious(temp2);
            current=current.getNext();
        }

    }

    @Override
    public DoublyLinkedListCustom copyList() {
        Node current=head;
        DoublyLinkedListCustom copyListResult = new DoublyLinkedListCustom();
        for(int i=0; i<size; i++) {
            copyListResult.addLast(current.getValue());
            current=current.getNext();
        }
        return copyListResult;
    }

    @Override
    public void clear() {
       head = null;
       tail=null;
       size=0;
    }

    @Override
    public boolean insertAfter(int index, int data) {
        if(index<0 || index>size){
            throw new IllegalArgumentException();
        } else if(index ==0) {
            addFirst(data);
        }else if(index==size) {
            addLast(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            for(int i=0; i<index; i++) {
                current=current.getNext();
            }
            current = current.getNext();
            newNode.setNext(current);
            newNode.setPrevious(current.getPrevious());
            current.getPrevious().setNext(newNode);
            current.setPrevious(newNode);
        }
        size++;
        return true;
    }

    //[0,1,3,1,5,1]
    //[0,3,1,5,1]
    @Override
    public Node deleteKey(int value) {
        Node current=head;
        Node temp=null;
        int count=1;
        for(int i=0; i<size; i++){
            if(current.getValue() == value && count==1) {
                temp = removeAtIndex(i);
                count++;
            }
            current=current.getNext();
        }
        return temp;
    }
}

