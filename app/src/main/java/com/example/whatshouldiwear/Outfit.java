package com.example.whatshouldiwear;
/** class for storing lists of items as part of a weather appropriate outfit
 *
 * @author Peter Saunders
 * @version 1.0
 */
import java.util.ArrayList;


public class Outfit {
    private int id = 0;
    private String name = "";
    private ArrayList<Item> items;

    /**
     * simple constructor for an outfit
     * @param id database specific outfit id
     * @param name name of the outfit
     * @param items list of items that make up an outfit
     */
    public Outfit(int id, String name, ArrayList<Item> items) {
        this.id = id;
        this.name = name;
        this.items = items;
    }

    /**
     * simple outfit id getter
     * @return outfit id as int
     */
    public int getId() {
        return id;
    }

    /**
     * simple outfit name getter
     * @return outfit name as string
     */
    public String getName() {
        return name;
    }

    /**
     * simple outfit items getter
     * @return outfit items as list of items
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * setter for outfit id
     * @param id sets the outfits id, takes int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * sets the outfits name
     * @param name takes string as outfit name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets item list as new outfit list
     * @param items list of items to form new outfit
     */
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
