//// HurricaneList
// program for instantiating Linked Lists with nodes and traversal/read/write methods for CSCI 211
// last edited Sep. 28, 2022 by S. Gutierrez

package HurricaneList; // includes project package

/**

 * HurricaneList
 * linked list for hurricane data
 * contains head and tail tracker fields,
 * push and insert methods,
 * to string print method
 */
public class HurricaneList {

    // declares instance variables
    Node head; // starts Node in list
    Node tail; // ends Node in list
    int length; // keeps track of length of list

    // constructs instances
    public HurricaneList() {

        // sets to null to be replaced with Node
        head = null;
        tail = null;

        // sets initial size/length to empty, 0
        length = 0;

    } // ends HurricaneList() constructor

    /**

     * sortWind()
     * sorts HurricanList by maxWind speed in ascending order according to bubble sort
     */
    void sortWind() {

        // initializes a temporary holder for operating on Node data freely
        Node temp;

        // loops outer according to length of HurricaneList - 1
        for (int i = 0; i < length - 1; i++) {

            // sets temp to the head of the HurricaneList
            temp = head;

            // loops inner according to length of HurricaneList - outer loop idx - 1
            for (int j = 0; j < length - i - 1; j++) {

                // tracks current iterated Node, starts at temp = head
                Node current = temp;
                // tracks next Node according to current Node
                Node next = temp.getNext();

                // compares first position int wind speed to second position int wind speed
                if (current.getStorm().getMaxWind() > next.getStorm().getMaxWind()) {

                    // initializes temporary holder of next Storm to swap Storm data
                    Storm swap = next.getStorm();
                    // sets second position Storm as first position Storm
                    next.setStorm(current.getStorm());
                    // sets first position Storm as second position Storm taken from temp swap holder of Storm
                    current.setStorm(swap);

                } // ends if statement

                temp = temp.getNext(); // traverses to the next Node

            } // ends inner for loop
        } // ends outer for loop
    } // ends sortWind() method

    void searchName(String name) {

        // sets head as current Node at traversal start
        Node current = head;

        // checks for an empty list if there is a head start
        if (head == null) {

            System.out.println("ERROR: empty list"); // prints error message if empty

        } // ends if statement error checker

        // traverses list while haven't reached end, still current Node
        while (current != null) {

            // gets and stores Storm object data from current Node
            Storm storm = current.getStorm();
            if (storm.getName().equals(name)) {

                // prints formatted Storm object data from current Node
                System.out.printf("Hurricane %s - Wind Speed: %d MPH; Month Formed: %s; Category %d%n", storm.getName(), storm.getMaxWind(), storm.getMonthFormed(), storm.getCategory());
                return; // returns once name is found

            } // ends if statement

            // moves current Node to current Node's next Node
            current = current.getNext();

        } // ends while loop

        System.out.println("ERROR: name not found"); // prints error message if name not found

    } // ends searchName() method

    void searchCategory(int category) {

        // sets head as current Node at traversal start
        Node current = head;

        // checks for an empty list if there is a head start
        if (head == null) {

            System.out.println("ERROR: empty list"); // prints error message if empty

        } // ends if statement error checker

        boolean found = false; // checks if cat is found for error checking

        // traverses list while haven't reached end, still current Node
        while (current != null) {

            // gets and stores Storm object data from current Node
            Storm storm = current.getStorm();
            if (storm.getCategory() == category) {

                // prints formatted Storm object data from current Node
                System.out.printf("Hurricane %s - Wind Speed: %d MPH; Month Formed: %s; Category %d%n", storm.getName(), storm.getMaxWind(), storm.getMonthFormed(), storm.getCategory());
                found = true;

            } // ends if statement

            // moves current Node to current Node's next Node
            current = current.getNext();

        } // ends while loop

        if (!found) { // if category hasn't been found

            System.out.println("ERROR: category not found"); // prints error message if name not found

        } // if statement

    } // ends searchCategory() method

    void searchMonth(String month) {

        // sets head as current Node at traversal start
        Node current = head;

        // checks for an empty list if there is a head start
        if (head == null) {

            System.out.println("ERROR: empty list"); // prints error message if empty

        } // ends if statement error checker

        boolean found = false; // checks if cat is found for error checking

        // traverses list while haven't reached end, still current Node
        while (current != null) {

            // gets and stores Storm object data from current Node
            Storm storm = current.getStorm();
            if (storm.getMonthFormed().equals(month)) {

                // prints formatted Storm object data from current Node
                System.out.printf("Hurricane %s - Wind Speed: %d MPH; Month Formed: %s; Category %d%n", storm.getName(), storm.getMaxWind(), storm.getMonthFormed(), storm.getCategory());
                found = true; // marks as found

            } // ends if statement

            // moves current Node to current Node's next Node
            current = current.getNext();

        } // ends while loop

        if (!found) { // if category hasn't been found

            System.out.println("ERROR: month not found"); // prints error message if name not found

        } // if statement
    } // ends searchMonth() method

    /**

     * push_back()
     * appends this Storm object h to a new node at the tail of the list
     */
    void push_back(Storm h) {

        Node new_node = new Node(); // inits new Node
        new_node.setStorm(h); // sets data in new Node

        // pushes Node at the end of the list
        if (head == null && tail == null) { // checks if list is empty

            head = new_node; // sets head to new Node

        } else {

            // sets start Node as head
            // aims to traverse for last Node
            Node last = head;

            // traverses list while there is a next Node
            while (last.getNext() != null) {

                // sets current last Node to next Node
                last = last.getNext();

            } // ends while loop list traversal

            // sets the current last Node's next Node to the new Node
            last.setNext(new_node);

            // sets the new_node's previous
            new_node.setPrevious(last);

        } // ends if/else logic

        // sets the tail to be the new Node
        tail = new_node;

        // increases length of list
        length++;

    } // ends push_back() method

    /**

     * insert()
     * inserts this Storm object h to a new node and places it at position i
     * position index starts at 0
     */
    void insert(Storm h, int i) {

        Node new_node = new Node(); // inits new Node
        new_node.setStorm(h); // sets data in new Node

        // checks if position is at the start
        if (i == 0) {

            // sets current head of list as next Node
            new_node.setNext(head);

            // sets new_node as old head's previous Node
            head.setPrevious(new_node);

            // replaces current head with new Node as head
            head = new_node;

            // increases length of list
            length++;

        // traverses list if position is not at the start
        } else {

            // inits current position at start, 0
            int position = 0;
            // inits previous Node tracker
            Node previous = null;
            // inits current Node tracker
            Node current = head; // sets current Node tracker to the head start

            // traverses list while the current position is not the target position, i
            while (position != i) {

                // checks if next Node is empty
                if (current.getNext() == null) {
                    // prints error for reaching end of list without finding position
                    System.out.println("ERROR: Out of Range");
                    return;
                } // ends if statement error checker

                // sets previous Node tracker to current Node
                previous = current;
                // sets current Node to its next Node
                current = current.getNext();
                // increases position counter
                position++;

            } // ends while loop traversal

            // finds position equal to target, i
            // sets current Node at target position as new Node's next Node
            new_node.setNext(current);
            // sets current as new_node's previous
            current.setPrevious(new_node);
            // sets new Node as previous Node's next Node
            previous.setNext(new_node);
            // sets previous as new_node's previous
            new_node.setPrevious(previous);

            // increases length of list
            length++;

        } // ends if/else traversal logic

    } // ends insert() method

    /**

     * print()
     * Prints information about each storm from head to tail
     */
    void print() {

        // sets head as current Node at traversal start
        Node current = head;

        // checks for an empty list if there is a head start
        if (head == null) {

            System.out.println("ERROR: Empty List"); // prints error message

        } // ends if statement error checker

        // traverses list while haven't reached end, still current Node
        while (current != null) {

            // gets and stores Storm object data from current Node
            Storm storm = current.getStorm();
            // prints formatted Storm object data from current Node
            System.out.printf("Hurricane %s - Wind Speed: %d MPH; Month Formed: %s; Category %d%n", storm.getName(), storm.getMaxWind(), storm.getMonthFormed(), storm.getCategory());
            // moves current Node to current Node's next Node
            current = current.getNext();

        } // ends while loop traversal
    } // ends print() method

    /**

     * printReverse()
     * Prints information about each storm from tail to head
     */
    void printReverse() {

        // sets head as current Node at traversal start
        Node current = tail;

        // checks for an empty list if there is a head start
        if (tail == null) {

            System.out.println("ERROR: Empty List"); // prints error message

        } // ends if statement error checker

        // traverses list while haven't reached end, still current Node
        while (current != null) {

            // gets and stores Storm object data from current Node
            Storm storm = current.getStorm();
            // prints formatted Storm object data from current Node
            System.out.printf("Hurricane %s - Wind Speed: %d MPH; Month Formed: %s; Category %d%n", storm.getName(), storm.getMaxWind(), storm.getMonthFormed(), storm.getCategory());
            // moves current Node to current Node's previous Node
            current = current.getPrevious();

        } // ends while loop traversal
    } // ends printReverse() method

} // ends HurricaneList class
