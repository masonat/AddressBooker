package edu.mason.a.turner.addressbooker;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class ContactDatabase extends RoomDatabase {
    public abstract ContactDAO contactDAO();

    private static final String DATABASE_NAME = "contact.db";

    private static ContactDatabase contactDatabase;

    public static ContactDatabase getInstance(Context context){
        if (contactDatabase == null){
            contactDatabase = Room.databaseBuilder(context, ContactDatabase.class, DATABASE_NAME)
                    // allows Room database methods to be run on Main thread
                    .allowMainThreadQueries()
                    .build();
        }
        return contactDatabase;
    }

}
