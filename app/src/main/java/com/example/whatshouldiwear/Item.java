package com.example.whatshouldiwear;
/** Code to create individual items, contains state for showing if checked
 *
 * @author Peter Saunders
 * @version 1.0
 */

public class Item {
    private int id;
    private String title;
    private String detail;
    private Boolean check;
    private int icon;

    /** constructor for the item, all fields are held in the db
     *
     * @param id unique identifier of item in db
     * @param title items name
     * @param detail additional item information
     * @param check state information for if selected
     * @param icon items icon id
     */
    public Item(int id, String title, String detail, Boolean check, int icon) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.check = check;
        this.icon = icon;
    }

    /**
     * simple setter for id
     * @param id
     */
    public void setId(int id) { this.id = id; }

    /**
     * simple setter for title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * simple setter for detail
     * @param detail
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * simple setter for if selected
     * @param check
     */
    public void setCheck(Boolean check) {
        this.check = check;
    }

    /**
     * simple setter for icon id
     * @param icon
     */
    public void setIcon(int icon) {
        this.icon = icon;
    }

    /**
     * item id getter
     * @return items id as int
     */
    public int getId() { return id; }

    /**
     * item title getter
     * @return item title as string
     */
    public String getTitle() {
        return title;
    }

    /**
     * item detail getter
     * @return item detail as string
     */
    public String getDetail() {
        return detail;
    }

    /**
     * item selected getter
     * @return item check as bool
     */
    public Boolean getCheck() {
        return check;
    }

    /**
     * item icon id getter
     * @return item icon as resource id
     */
    public int getIcon() {
        return icon;
    }
}
