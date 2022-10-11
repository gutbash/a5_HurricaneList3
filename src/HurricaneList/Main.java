//// HurricaneList
// program for instantiating Linked Lists with nodes and traversal/read/write methods for CSCI 211
// last edited Sep. 28, 2022 by S. Gutierrez

package HurricaneList; // includes project package

import java.util.Scanner; // imports Scanner class for input

/**

 * Main
 * driver code for HurricaneList operations
 */
public class Main {

    /**

     * MAIN METHOD / DRIVER CODE
     */
    public static void main(String[] args) {

        // initializes Scanner object for input
        Scanner input = new Scanner(System.in);

        // initializes HurricaneList linked list
        HurricaneList HurAtl1986 = new HurricaneList();

        // initializes Storm data objects with info
        Storm andrew = new Storm("Andrew", "June", 50, 0);
        Storm bonnie = new Storm("Bonnie", "June", 85, 1);
        Storm charley = new Storm("Charley", "August", 80, 1);
        Storm danielle = new Storm("Danielle", "September", 60, 0);
        Storm earl = new Storm("Earl", "September", 105, 2);
        Storm frances = new Storm("Frances", "November", 85, 1);

        // pushes Storm object data onto HurricaneList linked list
        HurAtl1986.push_back(andrew);
        HurAtl1986.push_back(bonnie);
        HurAtl1986.push_back(charley);
        HurAtl1986.push_back(danielle);
        HurAtl1986.push_back(earl);

        // inserts Storm object data into HurricaneList linked list
        HurAtl1986.insert(frances, 2);

        // prints formatted every storm in the HurricaneList linked list starting from head
        HurAtl1986.print();
        System.out.println();

        // prints formatted every storm in the HurricaneList linked list starting from tail
        //HurAtl1986.printReverse();

        boolean exit = true; // stops loop if exit command sets to false

        while (exit) {

            // prints a list of commands to operate on HurricaneList
            System.out.println("\nOPERATE ON THE LIST WITH THE FOLLOWING COMMANDS:\n\nsortwind\nsearchname\nsearchcategory\nsearchmonth\nexit\n");
            System.out.print("INPUT COMMAND: "); // prompts input
            String command = input.nextLine(); // reads user input
            System.out.println();

            switch (command) {
                case "sortwind":
                    HurAtl1986.sortWind(); // performs wind sort
                    HurAtl1986.print(); // print the wind sorted list
                    break; // breaks from switch
                case "searchname":
                    System.out.print("NAME TO SEARCH: "); // prompts input
                    String name = input.nextLine(); // reads user input
                    System.out.println();
                    HurAtl1986.searchName(name); // performs name search
                    break; // breaks from switch
                case "searchcategory":
                    System.out.print("CATEGORY TO SEARCH: "); // prompts input
                    int category = input.nextInt(); // reads user input
                    System.out.println();
                    HurAtl1986.searchCategory(category); // performs cat search
                    break; // breaks from switch
                case "searchmonth":
                    System.out.print("MONTH TO SEARCH: "); // prompts input
                    String month = input.nextLine(); // reads user input
                    System.out.println();
                    HurAtl1986.searchMonth(month); // performs month search
                    break; // breaks from switch
                case "exit":
                    exit = false;
                    break; // breaks from switch

            } // ends switch case
        } // ends while loop
    } // ends main method
} // ends Main class
