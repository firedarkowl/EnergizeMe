package com.example.EnergizeMe.myfirstapp.ui.main.Tracking;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myfirstapp.R;
//import com.example.myfirstapp.databinding.ActivityTrackingBinding;

import java.util.ArrayList;

public class Tracking extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    //private ActivityTrackingBinding binding;

    private SearchView searchView;
    private ListView myListView;

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        searchView=findViewById(R.id.searchView);
        myListView=findViewById(R.id.searchView);

        arrayList = new ArrayList<>();
        arrayList.add("Schnitzel mit Pommes");
       arrayList.add("Yoga");
       arrayList.add("Cola Light");

      adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
      myListView.setAdapter(adapter);
       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String query) {
                return false;
            }

           @Override
          public boolean onQueryTextChange(String s) {
              adapter.getFilter().filter(s);
               return false;
            }
        });



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
//        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_tracking);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}