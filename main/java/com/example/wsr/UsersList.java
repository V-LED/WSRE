package com.example.wsr;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Администратор on 02.11.2018.
 */

public class UsersList extends ArrayAdapter<User> {
    private Activity context;
    private List<User> userList;

    public  UsersList(Activity context, List<User> userList) {
        super(context,R.layout.users,userList);
        this.context = context;
        this.userList = userList;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listItem = inflater.inflate(R.layout.users,null,true);
        TextView name = listItem.findViewById(R.id.nameId);
        TextView phone = listItem.findViewById(R.id.phoneId);
        TextView date = listItem.findViewById(R.id.dateId);

        User user = userList.get(position);
        name.setText(user.getName());
        phone.setText(user.getPhone());
        date.setText(user.getDate());

        return  listItem;
    }
}
