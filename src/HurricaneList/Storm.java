//// HurricaneList
// program for instantiating Linked Lists with nodes and traversal/read/write methods for CSCI 211
// last edited Oct. 11, 2022 by S. Gutierrez

package HurricaneList; // includes project package

/**

 * Storm
 * stores data about particular Storm object
 */
public class Storm {

    // declares instance variables
    String name; // name of storm
    String monthFormed; // month storm was formed
    int maxWind; // max wind speed in mph
    int category; // category level, with non-hurricane tropical storms being level 0

    // constructs instance and sets up parameters
    public Storm(String n, String m, int w, int c) {

        name = n;
        monthFormed = m;
        maxWind = w;
        category = c;

    } // ends Storm() constructor method

    // getters //
    public String getName() { return name; }
    public String getMonthFormed() { return monthFormed; }
    public int getMaxWind() { return maxWind; }
    public int getCategory() { return category; }

    // setters //
    public void setName(String name) { this.name = name; }
    public void setMonthFormed(String monthFormed) { this.monthFormed = monthFormed; }
    public void setMaxWind(int maxWind) { this.maxWind = maxWind; }
    public void setCategory(int category) { this.category = category; }

} // ends Storm class
