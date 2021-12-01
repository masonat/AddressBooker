package edu.mason.a.turner.addressbooker.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = { Contact.class },version = 1, exportSchema = false)
public abstract class ContactDatabase extends RoomDatabase {
    public abstract ContactDAO contactDAO();

    private static final String DATABASE_NAME = "contact.db";

    private static ContactDatabase contactDatabase;

    public static ContactDatabase getInstance(Context context){
        if (contactDatabase == null){
            contactDatabase = Room.databaseBuilder(context, ContactDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries() // allows database methods to be run on Main thread
                    .build();
        }
        return contactDatabase;
    }

}
