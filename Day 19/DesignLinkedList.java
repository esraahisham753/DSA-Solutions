/*
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
*/

class MyLinkedList {
    class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    Node head;
    int length;


    public MyLinkedList() {
        this.head = null;
        this.length = 0;
    }
    
    public int get(int index) {
        if (index >= this.length) {
            return -1;
        }

        Node current;
        int i;
        for (i = 0, current = head; i < index; i++, current = current.next) {}

        return current.val;
    }
    
    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val, null);
        } else {
            Node newNode = new Node(val, head);
            head = newNode;
        }

        this.length++;
    }
    
    public void addAtTail(int val) {
        if (head == null) {
            head = new Node(val, null);
        } else {
            Node current;

            for (current = head; current.next != null; current = current.next ) {}

            current.next = new Node(val, null);
        }
        
        length++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
        } else if (index == length) {
            addAtTail(val);
        } else if (index > length) {
            return;
        } else {
            Node current;
            int i;
            for (i = 0, current = head; i < index - 1; i++, current = current.next) {}

            Node newNode = new Node(val, current.next);
            current.next = newNode;
            length++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if (index >= length) {
            return;
        } else if (index == 0) {
            head = head.next;
        } else {
            Node current;
            int i;
            for (i = 0, current = head; i < index - 1; i++, current = current.next) {}

            current.next = current.next.next;
        }
       
        length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */