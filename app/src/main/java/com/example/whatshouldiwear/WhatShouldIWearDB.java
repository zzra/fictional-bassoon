/** class for storing database configuration information
 * hellishly long and should be split in some way
 *
 * @author Peter Saunders
 * @version 1.0
 */
package com.example.whatshouldiwear;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class WhatShouldIWearDB {

    // db constants
    public static final String  DB_NAME             = "WhatShouldIWear.db";
    public static final int     DB_VERSION          = 1;

    // outfit table constants
    public static final String  OUTFIT_TABLE        = "outfit";

    public static final String  OUTFIT_ID           = "_id";
    public static final int     OUTFIT_ID_COL       = 0;

    public static final String  OUTFIT_NAME         = "outfit_name";
    public static final int     OUTFIT_NAME_COL     = 1;

    public static final String  OUTFIT_DATE         = "outfit_date";
    public static final int     OUTFIT_DATE_COL     = 2;

    // outfit items table
    public static final String  OUTFIT_ITEM_TABLE   = "outfit_item";

    public static final String  OUTFIT_ITEM_ID      = "_id";
    public static final int     OUTFIT_ITEM_ID_COLD = 0;

    public static final String  OUTFIT_ID_FK        = "outfit_id";
    public static final int     OUTFIT_ID_FK_COL    = 1;

    public static final String  OUTFIT_ITEM_FK      = "item_id";
    public static final int     OUTFIT_ITEM_FK_COL  = 2;

    // items table
    public static final String  ITEM_TABLE          = "item";

    public static final String  ITEM_ID             = "_id";
    public static final int     ITEM_ID_COL         = 0;

    public static final String  ITEM_NAME           = "name";
    public static final int     ITEM_NAME_COL       = 1;

    public static final String  ITEM_DESCRIPTION    = "description";
    public static final int     ITEM_DESCRIPTION_COL= 2;

    public static final String  ITEM_POSITION       = "position";
    public static final int     ITEM_POSITION_COL   = 3;

    public static final String  ITEM_IMAGE          = "image";
    public static final int     ITEM_IMAGE_COL      = 4;

    public static final String  ITEM_PROTECTION     = "protection";
    public static final int     ITEM_PROTECTION_COL = 5;

    // item position enum
    public static final String  POSITION_TABLE      = "item_position";

    public static final String  POSITION_ID         = "_id";
    public static final int     POSITION_ID_COL     = 0;

    public static final String  POSITION_NAME       = "position";
    public static final int     POSITION_NAME_COL   = 1;

    // item protection enum
    public static final String  PROTECTION_TABLE    = "item_protection";

    public static final String  PROTECTION_ID       = "_id";
    public static final int     PROTECTION_ID_COL   = 0;

    public static final String  PROTECTION_NAME     = "protection";
    public static final int     PROTECTION_NAME_COL = 1;

    /**
     * due to items needing a specific image, for the moment created new items
     * is left to initial create of db
     */
    // item options
    public static final String  INSERT_ITEM_TOQUE =
        "INSERT INTO item VALUES (0, 'Toque', 'Winter Hat', 0, " + R.mipmap.ic_toque_01 + " , 0);";

    public static final String  INSERT_ITEM_BALLCAP =
        "INSERT INTO item VALUES (1, 'Ball Cap', 'Sun Hat', 0, " + R.mipmap.ic_ballcap_01 + " , 2);";

    public static final String  INSERT_ITEM_LONGPANTS =
        "INSERT INTO item VALUES (2, 'Long Pants', 'Long Sweat Pants', 2, " +
                R.mipmap.ic_longpants_01 + ", 3);";

    public static final String  INSERT_ITEM_TSHIRT =
        "INSERT INTO item VALUES (3, 'T-Shirt', 'Short Sleeve Shirt', 1, " + R.mipmap.ic_tshirt +" , 2);";

    /**
     * similar to items, position is a static value
     */
    // position options
    public static final String  INSERT_POSITION_HEAD =
        "INSERT INTO " + POSITION_TABLE + " VALUES (0, 'Head');";

    public static final String  INSERT_POSITION_TOP =
        "INSERT INTO " + POSITION_TABLE + " VALUES (1, 'Top');";

    public static final String  INSERT_POSITION_BOTTOM =
        "INSERT INTO " + POSITION_TABLE + " VALUES (2, 'Bottom');";

    /**
     * similiar to items protection is a static value on db creation,
     * however this could easily but done dynamically
     */
    // protection options
    public static final String INSERT_PROTECTION_COLD =
        "INSERT INTO " + PROTECTION_TABLE + " VALUES (0, 'Cold');";

    public static final String INSERT_PROTECTION_RAIN =
        "INSERT INTO " + PROTECTION_TABLE + " VALUES (1, 'Rain');";

    public static final String INSERT_PROTECTION_SUN =
        "INSERT INTO " + PROTECTION_TABLE + " VALUES (2, 'Sun');";

    public static final String INSERT_PROTECTION_MILD =
        "INSERT INTO " + PROTECTION_TABLE + " VALUES (3, 'Mild');";

    public static final String INSERT_PROTECTION_SNOW =
        "INSERT INTO " + PROTECTION_TABLE + " VALUES (4, 'Snow');";

    // create table statements
    public static final String  CREATE_TABLE_OUTFIT =
            "CREATE TABLE " + OUTFIT_TABLE + " (" +
            OUTFIT_ID       + " INTEGER     PRIMARY KEY AUTOINCREMENT, " +
            OUTFIT_NAME     + " TEXT        NOT NULL UNIQUE, " +
            OUTFIT_DATE     + " TEXT        NOT NULL);";
    public static final String CREATE_TABLE_OUTFIT_ITEM =
            "CREATE TABLE " + OUTFIT_ITEM_TABLE + " (" +
            OUTFIT_ITEM_ID  + " INTEGER     PRIMARY KEY, " +
            OUTFIT_ID_FK    + " INTEGER     NOT NULL UNIQUE, " +
            OUTFIT_ITEM_FK  + " INTEGER     NOT NULL UNIQUE);";
    public static final String CREATE_TABLE_ITEM =
            "CREATE TABLE " + ITEM_TABLE + " (" +
            ITEM_ID         + " INTEGER     PRIMARY KEY AUTOINCREMENT, " +
            ITEM_NAME       + " TEXT        NOT NULL UNIQUE, " +
            ITEM_DESCRIPTION+ " TEXT        NOT NULL, " +
            ITEM_POSITION   + " INTEGER     NOT NULL, " +
            ITEM_PROTECTION + " INTEGER     NOT NULL, " +
            ITEM_IMAGE      + " INTEGER     NOT NULL);";
    public static final String CREATE_TABLE_POSITION =
            "CREATE TABLE " + POSITION_TABLE + " (" +
            POSITION_ID     + " INTEGER     PRIMARY KEY AUTOINCREMENT, " +
            POSITION_NAME   + " TEXT        NOT NULL);";
    public static final String CREATE_TABLE_PROTECTION =
            "CREATE TABLE " + PROTECTION_TABLE + " (" +
            PROTECTION_ID   + " INTEGER     PRIMARY KEY AUTOINCREMENT, " +
            PROTECTION_NAME + " TEXT        NOT NULL);";

    // drop table statements
    public static final String DROP_TABLE_OUTFIT        = "DROP TABLE IF EXISTS " + OUTFIT_TABLE;
    public static final String DROP_TABLE_OUTFIT_ITEM   = "DROP TABLE IF EXISTS " + OUTFIT_ITEM_TABLE;
    public static final String DROP_TABLE_ITEM          = "DROP TABLE IF EXISTS " + ITEM_TABLE;
    public static final String DROP_TABLE_POSITION      = "DROP TABLE IF EXISTS " + POSITION_TABLE;
    public static final String DROP_TABLE_PROTECTION    = "DROP TABLE IF EXISTS " + PROTECTION_TABLE;

    // database object and helper object
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    /**
     * public database constructor
     * @param context local application context
     */
    public WhatShouldIWearDB(Context context) {
        dbHelper = new DBHelper(context, DB_NAME, null, DB_VERSION);
    }

    // private db access methods
    private void openReadableDB() {
        db = dbHelper.getReadableDatabase();
    }
    private void openWritableDB() {
        db = dbHelper.getWritableDatabase();
    }
    private void closeDB() {
        if (db != null)
            db.close();
    }

    /**
     * allows you getting of specific outfit items
     * @param outfitId outfit to look for
     * @return list of outfits items
     */
    public ArrayList<Item> getOutfitItems(int outfitId) {
        String where = OUTFIT_ID + "= ?";
        String[] whereArgs = { Integer.toString(outfitId) };
        ArrayList<Item> outfit = new ArrayList<Item>();
        int itemId = -1;

        // first get list of item ids for the outfit
        this.openReadableDB();
        Cursor cursor = db.query(
                OUTFIT_ITEM_TABLE, null, where, whereArgs, null,
                null, null);
        ArrayList<Integer> items = new ArrayList();
        while (cursor.moveToNext()) {
            itemId = getItemIdFromCursor(cursor);
            // -1 is sudo null, do not add
            if (itemId != -1)
                items.add(itemId);
        }
        if (cursor != null)
            cursor.close();
        this.closeDB();

        // next get list of items from the ids
        // since we are working from a list of ids, loop over it to get items
        for (Integer var : items) {
            where = ITEM_ID + "=?";
            whereArgs = new String[]{Integer.toString(var)};
            this.openReadableDB();
            cursor = db.query(
                    ITEM_TABLE, null, where, whereArgs, null,
                    null, null);
            while (cursor.moveToNext()) {
                outfit.add(getItemFromCursor(cursor));
            }
            if (cursor != null)
                cursor.close();
            this.closeDB();
        }
        return outfit;
    }

    // get item ids for outfit
    private static int getItemIdFromCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            return -1;
        } else {
            try {
                int itemId = cursor.getInt(ITEM_ID_COL);
                return itemId;
            } catch (Exception e) {
                return -1;
            }
        }
    }

    // get item values for outfit
    private static Item getItemFromCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            return null;
        } else {
            try {
                Item item = new Item(
                        cursor.getInt(ITEM_ID_COL),
                        cursor.getString(ITEM_NAME_COL),
                        cursor.getString(ITEM_DESCRIPTION_COL),
                        true,
                        cursor.getInt(ITEM_IMAGE_COL));
                return  item;
            } catch (Exception e) {
                return null;
            }
        }
    }

    /**
     * allows for the creation of new outfits
     * @param outfit to create
     */
    public void insertOutfit(Outfit outfit) {
        ContentValues cv = new ContentValues();

        // first insert outfit into its table
        cv.put(OUTFIT_ID, outfit.getId());
        cv.put(OUTFIT_NAME, outfit.getName());
        cv.put(OUTFIT_DATE, String.valueOf(LocalDateTime.now()));

        this.openWritableDB();
        db.insert(OUTFIT_TABLE, null, cv);
        this.closeDB();

        // next insert outfit items into outfit_item table
        for (Item item : outfit.getItems()) {
            cv = new ContentValues();
            cv.put(OUTFIT_ID_FK, outfit.getId());
            cv.put(OUTFIT_ITEM_FK, item.getId());

            this.openWritableDB();
            db.insert(OUTFIT_ITEM_TABLE, null, cv);
            this.closeDB();
        }
    }

    /**
     * allows for updating an outfit with custom items
     * @param outfit to update
     */
    public void updateOutfit(Outfit outfit) {
        ContentValues cv = new ContentValues();

        // first update outfit into its table
        cv.put(OUTFIT_ID, outfit.getId());
        cv.put(OUTFIT_NAME, outfit.getName());
        cv.put(OUTFIT_DATE, String.valueOf(LocalDateTime.now()));

        String where = OUTFIT_ID + "=?";
        String[] whereArgs = {String.valueOf(outfit.getId())};

        this.openWritableDB();
        db.update(OUTFIT_TABLE, cv, where, whereArgs);
        this.closeDB();

        // drop the old list, we could diff, but no
        deleteOutfitItems(outfit);

        // next insert outfit items into outfit_item table
        for (Item item : outfit.getItems()) {
            cv = new ContentValues();
            cv.put(OUTFIT_ID_FK, outfit.getId());
            cv.put(OUTFIT_ITEM_FK, item.getId());

            this.openWritableDB();
            db.insert(OUTFIT_ITEM_TABLE, null, cv);
            this.closeDB();
        }
    }

    /**
     * allows for removal of specific outfits
     * @param outfit to delete
     */
    public void deleteOutfitItems(Outfit outfit) {
        String where = OUTFIT_ITEM_FK + "= ?";
        String[] whereArgs = { String.valueOf(outfit.getId()) };

        this.openWritableDB();
        db.delete(OUTFIT_ITEM_TABLE, where, whereArgs);
        this.closeDB();
    }

    /**
     * gets the items for a position
     * @param position int value of 0, 1, 2
     * @return returns a list of items
     */
    public ArrayList<Item> getItemsForPosition(int position) {
        String where = ITEM_POSITION + "= ?";
        String[] whereArgs = { Integer.toString(position) };
        ArrayList<Item> positionItems = new ArrayList<Item>();

        // first get list of item ids for the outfit
        this.openReadableDB();
        Cursor cursor = db.query(
                ITEM_TABLE, null, where, whereArgs, null,
                null, null);
        ArrayList<Integer> items = new ArrayList();
        while (cursor.moveToNext()) {
            int itemId = getItemIdFromCursor(cursor);
            // -1 is sudo null, do not add
            if (itemId != -1)
                items.add(itemId);
        }
        if (cursor != null)
            cursor.close();
        this.closeDB();

        // next get list of items from the ids
        // since we are working from a list of ids, loop over it to get items
        for (int i = 0; i < items.size(); i++) {
            where = ITEM_ID + "=?";
            String[] whereItem = {String.valueOf(items.get(i))};
            this.openReadableDB();
            cursor = db.query(
                    ITEM_TABLE, null, where, whereItem, null,
                    null, null);
            while (cursor.moveToNext()) {
                positionItems.add(getItemFromCursor(cursor));
            }
            if (cursor != null)
                cursor.close();
            this.closeDB();
        }
        return positionItems;
    }

    // create helper
    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // drop tables
            db.execSQL(DROP_TABLE_ITEM);
            db.execSQL(DROP_TABLE_OUTFIT);
            db.execSQL(DROP_TABLE_OUTFIT_ITEM);
            db.execSQL(DROP_TABLE_POSITION);
            db.execSQL(DROP_TABLE_PROTECTION);

            db.execSQL(CREATE_TABLE_OUTFIT);
            db.execSQL(CREATE_TABLE_OUTFIT_ITEM);
            db.execSQL(CREATE_TABLE_ITEM);
            db.execSQL(CREATE_TABLE_POSITION);
            db.execSQL(CREATE_TABLE_PROTECTION);

            // insert values for position enum
            db.execSQL(INSERT_PROTECTION_COLD);
            db.execSQL(INSERT_PROTECTION_MILD);
            db.execSQL(INSERT_PROTECTION_SNOW);
            db.execSQL(INSERT_PROTECTION_SUN);
            db.execSQL(INSERT_PROTECTION_RAIN);

            // insert values for protection enum
            db.execSQL(INSERT_POSITION_TOP);
            db.execSQL(INSERT_POSITION_HEAD);
            db.execSQL(INSERT_POSITION_BOTTOM);

            // insert values for items
            db.execSQL(INSERT_ITEM_BALLCAP);
            db.execSQL(INSERT_ITEM_LONGPANTS);
            db.execSQL(INSERT_ITEM_TOQUE);
            db.execSQL(INSERT_ITEM_TSHIRT);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(WhatShouldIWearDB.DROP_TABLE_OUTFIT);
            db.execSQL(WhatShouldIWearDB.DROP_TABLE_OUTFIT_ITEM);
            db.execSQL(WhatShouldIWearDB.DROP_TABLE_ITEM);
            db.execSQL(WhatShouldIWearDB.DROP_TABLE_POSITION);
            db.execSQL(WhatShouldIWearDB.DROP_TABLE_PROTECTION);

            onCreate(db);
        }
    }
}
