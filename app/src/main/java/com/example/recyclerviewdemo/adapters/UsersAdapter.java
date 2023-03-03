package com.example.recyclerviewdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.models.User;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

    private ArrayList<User> mUserList;
    private Context mcontext;

    public UsersAdapter(Context context, ArrayList<User> userList) {
        mcontext = context;
        mUserList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mcontext).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        holder.nameTv.setText(mUserList.get(position).name);
        holder.ageTv.setText(mUserList.get(position).age);
        holder.passTv.setText(mUserList.get(position).password);

    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTv, ageTv,passTv;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.name);
            ageTv = itemView.findViewById(R.id.age);
            passTv = itemView.findViewById(R.id.password);
        }
    }
}
