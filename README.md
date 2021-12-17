# Android Address Booker Application

## Installation
Clone this repository and import into **Android Studio**
```bash
git clone git@github.com:masonat/AddressBooker.git
```



## Contributing

1. Fork it
2. Create your feature branch (git checkout -b my-new-feature)
3. Commit your changes (git commit -m 'Add some feature')
4. Run the linter (ruby lint.rb').
5. Push your branch (git push origin my-new-feature)
6. Create a new Pull Request



## Background Information 

**Project Description**

For this project, we will be creating an Address Book App using Android Studio. This app will manage your contacts&#39; information including name, address, phone number, email, and notes. It will be similar to a simple address book in which you can save and retrieve your contacts information. The user will be required to enter a contact&#39;s name and phone number; however, entering an address, email or notes will be optional.

The app will have four screens: Main Menu, Add Contact, Edit Contact, and View Contact.

The Main Menu screen will display the name and phone number of all existing contacts in alphabetical order and an &quot;Add Contact&quot; button to add a new contact.

When the user clicks on a name on this list, the View Contact screen will pop up, displaying detail information about the selected contact. This screen also has two buttons: &quot;Edit&quot; (to modify the contact) and &quot;Delete&quot; (to remove the contact from the list).

The Add Contact screen will have text views for name, address, phone number, email, and notes, as well as text boxes to enter that information in for new contacts. This screen also has three buttons: &quot;Save&quot; (to add new contact to the list), &quot;Cancel&quot; (to return to the Main Menu) and &quot;Clear&quot; (to reset the form).

The Edit Contact screen will have text views and text boxes to displays existing name, address, phone number, email, and notes for a selected contact. This screen also has two buttons: &quot;Save&quot; (to save changes/updates) and &quot;Cancel&quot; (to return to the Main Menu).

**Requirements Specifications**

We are implementing an address book. It will have the following activities and functionalities.

1. Main Menu Activity with the following functionalities:
  a. Activity will have RecyclerView to display a list of all existing contacts in alphabetical order.
  b. It will have a button to add a new contact.
2. Add Contact Activity with the following functionalities:
  a. Activity will have text views for name, address, phone number, email, and notes.
  b. It will have text boxes to enter the information for name, address, phone number, email, and notes of a new contact.
  c. It will have three buttons, one to save new contact, one to reset the form, and one to return to the Main Menu.
  d. It will display an error message if the contact&#39;s name and/or phone number are not entered.
3. View Contact Activity with the following functionalities:
  a. Activity will display detail information about the selected contact (from Main Menu), including name, address, phone number, email, and notes.
  b. It will have three buttons, one to edit/modify the contact, one to delete the contact, and one to return to the Main Menu.
4. Edit Contact Activity with the following functionalities:
  a. Activity will have text views for name, address, phone number, email, and notes.
  b. It will have text boxes to display existing name, address, phone number, email, and notes of the selected contact.
  c. It will have two buttons, one to return to the Main Menu and one to save changes/updates.

**Technical Description**

For the designer, xml files were created for the four activities: Main Menu, Add Contact, Edit Contact, and View Contact. We also created an xml file for List Item Contact. For the Main Menu, we used a constraint layout, which included a text view, recycler view, and button. For the other three activities, a table layout was used for each. TextView, EditText, and/or buttons were placed in the rows of the tables. The different styling we used for the buttons in the layouts was made using various Material Design and setting style equal to whatever we wanted for the layout.

For the List Item Contact, we used a linear layout to display the text views of name and phone number that was used in the recycler view. We also used view binding to replace the findViewById function for ease of use.

For the code/implementation of the UI, we first created five classes: ContactAdapter, MainActivity, AddContactActivity, EditContactActivity, and ViewContactActivity. In all these five classes, the onCreate function was used in order to open their respective activity. In MainActivity, AddContactActivity, EditContactActivity, and ViewContactActivity, we implemented the code for Add, Save, Cancel, Clear, Edit, and Delete Contact functions which were linked to the onClick event of the respective buttons. In AddContactActivity, EditContactActivity, and ViewContactActivity, we used binding to get/set the values of the text boxes (from user input).

We also used the Room persistence library to handle the SQLite database. In order to start working with this library we had to upgrade the Gradle dependencies to include room, we used room version _2.4.0-alpha03_ which is the most update version that provides support when using computers with Apple&#39;s M1 chip. We created two classes ContactDatabase and Contact, and one interface named ContactDAO.

The Contact class contained the data model for the table in our SQLite database. The class is annotated with @Entity which marks the class title making it the name of the class. The other annotations used were @Primary key – marking the field as the primary key – and @ColumnInfo which introduces a new column into the database and its type.

The ContactDatabase class was marked with @Database which signals that it is a RoomDatabase. It defines the database name and uses allowMainThreadQueries() which disables the main thread query check for Room. This is usually used in bigger applications to ensure that the main thread isn&#39;t locked, which would lead to us getting hit with an &quot;Application Not Responding&quot; error. We allowed main thread queries in this case because we are not putting a lot of data in our database for our class project, so we won&#39;t have to worry about the previously mentioned complications that may arise.

The ContactDAO interface was annotated by @Dao. This stands for data access objects which allows us to use a DAO to access our app&#39;s SQLite database instead of just using some sort of query builder direct queries. This is the place where we defined all the interactions we would be having with our database. It contained methods that were annotated to provide general Insert, Delete, and Update methods. We also used a few custom queries to getContactByID or to viewAllContacts.

**Instructions for Using the App**


1. When you open the app, you will see a list of existing contacts (if any) on the Main Menu screen. They will be sorted alphabetically.
2. To add a new contact, click on &quot;Add Contact&quot;.
  a. To save a new contact, fill out at least the name and phone number, and click &quot;Save&quot;.
  b. To exit the form without saving a new contact, click &quot;Cancel&quot;.
  c. To reset the form, click &quot;Clear&quot;.
3. To view detailed information about a contact, click on a specific contact on the Main Menu. This will take you to the View Contact screen.
4. To edit a contact, click &quot;Edit&quot; on the View Contact screen.
  a. To save changes/updates, make necessary changes/updates, then click &quot;Save&quot;.
  b. To cancel the changes you made or exit the Edit screen, click &quot;Cancel&quot;.
5. To delete a contact, click &quot;Delete&quot; on the View Contact screen.
