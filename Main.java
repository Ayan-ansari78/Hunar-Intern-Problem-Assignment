// Node class represents each element in the linked list
class Node {
    int data;
    Node next;

    // Constructor to initialize a node with given data
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class represents the linked list data structure
class LinkedList {
    private Node head;

    // Constructor to initialize an empty linked list
    LinkedList() {
        this.head = null;
    }

    // Method to add a new node with given data to the end of the list
    void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to display the elements of the linked list
    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to delete the last occurrence of a specified item
    void deleteLastOccurrence(int item) {
        Node prevToDelete = null;
        Node toDelete = null;
        Node prev = null;
        Node current = head;

        // Traverse the list to find the last occurrence of the item
        while (current != null) {
            if (current.data == item) {
                prevToDelete = prev;
                toDelete = current;
            }
            prev = current;
            current = current.next;
        }

        // If the item was found, delete the node
        if (toDelete != null) {
            if (prevToDelete == null) {
                // If the node to delete is the head
                head = head.next;
            } else {
                // Otherwise, update the references to skip the node to delete
                prevToDelete.next = toDelete.next;
            }
        }
    }
}

// Main class to test the LinkedList class
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Adding elements to the list
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);

        // Display the original list
        System.out.println("Original list:");
        list.display();

        // Delete the last occurrence of 2
        int itemToDelete = 2;
        list.deleteLastOccurrence(itemToDelete);

        // Display the modified list
        System.out.println("List after deleting last occurrence of " + itemToDelete + ":");
        list.display();
        
        // Test deleting the last occurrence of an item that appears multiple times
        itemToDelete = 5;
        list.deleteLastOccurrence(itemToDelete);
        System.out.println("List after deleting last occurrence of " + itemToDelete + ":");
        list.display();
        
        // Test deleting the last occurrence of the only occurrence
        itemToDelete = 1;
        list.deleteLastOccurrence(itemToDelete);
        System.out.println("List after deleting last occurrence of " + itemToDelete + ":");
        list.display();
        
        // Test deleting the last occurrence of an item that does not exist
        itemToDelete = 10;
        list.deleteLastOccurrence(itemToDelete);
        System.out.println("List after deleting last occurrence of " + itemToDelete + ":");
        list.display();
    }
}
