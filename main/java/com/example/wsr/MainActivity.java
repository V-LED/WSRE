package com.example.wsr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataSource dataSource = new DataSource();
        dataSource.execute();
        try {
            dataSource.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        setUsersList(dataSource.resultJson);
    }
    public void setUsersList(String json) {
        String name;
        String date;
        String phone;

        try {
            JSONArray people = new JSONArray(json);

            for (int i = 0; i < people.length(); i++) {
                JSONObject cont = people.getJSONObject(i);

                name = cont.getString("name");
                date = cont.getString("date");
                phone = cont.getString("phone");
                userList.add(new User(name,data,phone));

                Log.e("User", "#" + i + " = name: " + name + ", date: " + date + ", phone: " + phone);

            }

        }catch (Exception e) {
            Log.e("error", "Error");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TextView headerView = (TextView) findViewById(R.id.header);
        switch (id) {
            case R.id.ListNews:
                headerView.setText("Новости");
                return true;
            case R.id.Profile:
                headerView.setText("Профиль");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
