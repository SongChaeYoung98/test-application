package com.example.testapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class nestedscrollview_adapter extends RecyclerView.Adapter<nestedscrollview_adapter.ViewHolder> {

    private ArrayList<String> userNames;
    private ArrayList<String> userNumbers;

    public nestedscrollview_adapter(ArrayList<String> userNames, ArrayList<String> userNumbers) {
        this.userNames = userNames;
        this.userNumbers = userNumbers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nestedscrollview_adapter, parent, false);


        Log.d("test", "userNames : " + userNames);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Bind data to the views inside the ViewHolder
        String currentUserName = userNames.get(position);
        String currentUserNumber = userNumbers.get(position);

        String formattedUserNumber = String.format("010-%s-%s",
                currentUserNumber.substring(3, 7), currentUserNumber.substring(7));

        holder.userNameTextView.setText(currentUserName);
        holder.userNumberTextView.setText(formattedUserNumber);
    }

    @Override
    public int getItemCount() {
        return userNames.size(); // Return the size of your data
    }

    // Define ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView userNameTextView;
        private TextView userNumberTextView;

        public ViewHolder(View view) {
            super(view);
            userNameTextView = view.findViewById(R.id.listView_user_name);
            userNumberTextView = view.findViewById(R.id.listView_user_phone);
        }
    }
}