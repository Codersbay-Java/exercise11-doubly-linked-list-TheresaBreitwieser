package DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedListCustom list = new DoublyLinkedListCustom();

        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);
        list.addAtIndex(2,6);
        list.printList();
        list.clear();
        list.printList();
        list.addFirst(0);
        list.addLast(1);
        list.addLast(1);
        list.addLast(2);
        list.addLast(2);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.printList();
        list.printListBackwards();
//        list.removeAtIndex(2);
        list.printList();
        list.removeDuplicates();
        list.printList();
        list.insertAfter(2,6);
        list.printList();
//        DoublyLinkedListCustom resultDuplicate = new DoublyLinkedListCustom();
//        resultDuplicate= list.copyList();
//        resultDuplicate.printList();
        list.reverseList();
        list.printList();
        list.addLast(6);
        list.printList();
        list.deleteKey(6);
        list.printList();
        System.out.println(list.get(0));
//        list.addElementAtRandomIndex(10);
//        list.addElementAtRandomIndex(10);
        list.printList();
        list.removeAtIndex(2);
        list.removeFirst();
        list.printList();
//        list.removeLast();
        list.printList();






    }
}