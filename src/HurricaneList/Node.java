//// HurricaneList
// program for instantiating Linked Lists with nodes and traversal/read/write methods for CSCI 211
// last edited Sep. 28, 2022 by S. Gutierrez

package HurricaneList; // includes project package

/**

 * Node
 * contains Storm object data
 * part of HurricaneList linked list
 */
public class Node {

    // declares instance variables
    Storm s; // stores Storm object
    Node next; // keeps track of place in list in forward direction
    Node previous; // keeps track of place in list in previous direction

    // constructs instance variables
    public Node() {

        s = null;
        next = null;
        previous = null;

    } // ends Node() constructor method

    // getters //
    public Node getNext() { return next; }
    public Node getPrevious() { return previous; }
    public Storm getStorm() { return s; }

    // setters //
    public void setNext(Node next) { this.next = next; }
    public void setPrevious(Node previous) { this.previous = previous; }
    public void setStorm(Storm s) { this.s = s; }

} // ends Node class
