package com.example.gmamdin.contacts;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context context;
    List<Contact> contacts;
    Dialog mydialog;

    public RecyclerViewAdapter(Context context, List<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        view= LayoutInflater.from(context).inflate(R.layout.item_contact,parent,false);
        final MyViewHolder myViewHolder=new MyViewHolder(view);

        mydialog=new Dialog(context);
        mydialog.setContentView(R.layout.dialog_content);
        mydialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        myViewHolder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView name=(TextView)mydialog.findViewById(R.id.dialog_name);
                TextView number=(TextView)mydialog.findViewById(R.id.dialog_phone);
                ImageView img=(ImageView)mydialog.findViewById(R.id.dialog_image);
                name.setText(contacts.get(myViewHolder.getAdapterPosition()).getName());
                number.setText(contacts.get(myViewHolder.getAdapterPosition()).getPhone());
                img.setImageResource(contacts.get(myViewHolder.getAdapterPosition()).getPhoto());
                //Toast.makeText(context,"Test"+String.valueOf(myViewHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
                mydialog.show();
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(contacts.get(position).getName());
        holder.number.setText(contacts.get(position).getPhone());
        holder.image.setImageResource(contacts.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView number;
        private ImageView image;
        private LinearLayout item_contact;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name=(TextView)itemView.findViewById(R.id.name_contact);
            number=(TextView)itemView.findViewById(R.id.phone_contact);
            image=(ImageView)itemView.findViewById(R.id.image_contact);
            item_contact=(LinearLayout)itemView.findViewById(R.id.contact_item);
        }
    }

}
