package edu.mason.a.turner.addressbooker;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contact {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")

    private int id;

    @ColumnInfo (name = "name")
    private String name;

    @ColumnInfo (name = "address")
    private String address;

    @ColumnInfo (name = "number")
    private String number;

    @ColumnInfo (name = "email")
    private String email;

    @ColumnInfo (name = "notes")
    private String notes;

    // constructor
    public Contact(String name, String address, String number, String email, String notes) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.email = email;
        this.notes = notes;
    }
    // GETTERS
    public int getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getNumber() { return number; }
    public String getEmail() { return email; }
    public String getNotes() { return notes; }

    // SETTERS
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setNumber(String number) {
        this.number = number;
    }

}
