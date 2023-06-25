package com.example.EnergizeMe.myfirstapp.ui.main.Tracking;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.EnergizeMe.myfirstapp.Logik.Activity;
import com.example.EnergizeMe.myfirstapp.ui.main.MeinTag;
import com.example.EnergizeMe.myfirstapp.ui.main.Tracked.Activity_Tracked;
import com.example.myfirstapp.R;
import com.example.myfirstapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class Tracking extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private @NonNull ActivityMainBinding binding;

    private SearchView searchView;
    private ListView myListView;

    private ArrayList<String> arrayList;

    private ArrayAdapter<String> adapter;
    private ImageView back;
    private TextView title;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //       setContentView(binding.getRoot());
        context = this;
        setContentView(R.layout.activity_activity_tracking);

        ArrayList<Activity> activities = new ArrayList<>();


        Activity activity1 = new Activity("Laufen", 30, 300, 10);
        activities.add(activity1);

        Activity activity2 = new Activity("Yoga", 60, 200, 8);
        activities.add(activity2);


        back = findViewById(R.id.back);
        myListView = findViewById(R.id.myListView);

        ArrayList<String> activityNames = new ArrayList<>();
        for (Activity activity : activities) {
            activityNames.add(activity.getName());
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, activityNames);

        // Setze den ArrayAdapter auf die ListView
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Activity act = activities.get(position);
                Activity_Tracked.tracked.add(act.getName());
                Toast.makeText(context, "Die ausgewählte Aktivität wurde hinzugefügt!", Toast.LENGTH_SHORT).show();
            }
        });



        // Weitere Anpassungen und Logik können hier durchgeführt werden
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logik für den Klick auf den "Mahlzeiten"-Button (für den oberen Button)
                Intent i = new Intent(Tracking.this, MeinTag.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_tracking);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

        /*back = findViewById(R.id.back);
        title = findViewById(R.id.title);
        searchView = findViewById(R.id.searchView);
        myListView = findViewById(R.id.myListView);
       *//*searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
         @Override
           public boolean onQueryTextSubmit(String query) {
                return false;
            }

           @Override
          public boolean onQueryTextChange(String s) {
              adapter.getFilter().filter(s);
               return false;
            }
        });*//*



        // setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_tracking);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAnchorView(R.id.fab)
//                        .setAction("Action", null).show();
//            }
//        });*/
    }

