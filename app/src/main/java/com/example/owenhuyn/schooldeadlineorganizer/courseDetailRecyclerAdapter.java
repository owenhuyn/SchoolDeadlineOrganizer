package com.example.owenhuyn.schooldeadlineorganizer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by owenhuyn on 15-07-01.
 */

public class courseDetailRecyclerAdapter extends RecyclerView.Adapter<courseDetailRecyclerAdapter.ContactViewHolder> {

    private List<Assignment> contactList;

    public courseDetailRecyclerAdapter(ArrayList<Assignment> contactList) {
        this.contactList = contactList;
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        Assignment ci = contactList.get(i);
        contactViewHolder.vName.setText(ci.name);
        contactViewHolder.vTitle.setText(ci.name);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.customcirclecell, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        protected TextView vName;
        protected TextView vTitle;

        public ContactViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.subtitle_textview);
            vTitle = (TextView) v.findViewById(R.id.title_textview);
        }
    }
}