package edu.mason.a.turner.addressbooker.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactDAO {
    @Insert
    long insertContact (Contact contact);

    @Delete
    void deleteContact(Contact contact);

    @Update
    void updateContact(Contact contact);

    @Query("SELECT * FROM Contact ORDER BY Name")
    List<Contact> viewAllContacts();

    @Query("DELETE FROM Contact WHERE id = :id")
    void deleteUsingName(String id);
}
