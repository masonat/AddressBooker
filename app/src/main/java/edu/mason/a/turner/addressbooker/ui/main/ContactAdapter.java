package edu.mason.a.turner.addressbooker.ui.main;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.mason.a.turner.addressbooker.R;
import edu.mason.a.turner.addressbooker.data.Contact;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>  {

    private RecyclerView contactRecyclerView;

    private List<Contact> contactList;
    private ContactSelectCallback callback;

    public ContactAdapter(List<Contact> contactList, ContactSelectCallback callback) {
        this.contactList = contactList;
        this.callback = callback;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateContactList(List<Contact> contactList) {
        this.contactList = contactList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_contact, parent, false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.bind(contact, callback);
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public interface ContactSelectCallback {
        void onSelectContact(Contact contact);
    }


    static class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView contactName;
        TextView contactNumber;


        ContactViewHolder(View view) {
            super(view);
            contactName = view.findViewById(R.id.contactName);
            contactNumber = view.findViewById(R.id.contactNumber);
        }

        void bind(final Contact contact, final ContactSelectCallback callback) {
            contactName.setText(contact.getName());
            contactNumber.setText(contact.getNumber());

            itemView.setOnClickListener(v -> callback.onSelectContact(contact));
        }

    }
}
