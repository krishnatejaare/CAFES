package com.example.arekr.lab3;


        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.DefaultItemAnimator;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.support.v7.widget.Toolbar;
        import android.view.GestureDetector;
        import android.view.MotionEvent;
        import android.view.View;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Record> cafesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CafesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        System.out.println("IN THE RECYCLER VIEW");

        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("bundle");
        ArrayList<Record> records = (ArrayList<Record>) args.getSerializable("myList");
        System.out.println("size is"+records.size());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        //PlacesDisplayTask placesDisplayTask=new PlacesDisplayTask();
        //cafesList=PlacesDisplayTask.shashank;

        mAdapter = new CafesAdapter(records);
       System.out.println(mAdapter.getItemCount());

        System.out.println("MIDDLE OF THE RECYCLER VIEW");


        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        System.out.println("END OF THE RECYCLER VIEW");


    }

//    public List<Record> prepareCafeData(List<Record> list) {
//List<Record>cafeslist=list;
//        /*for (Record r : list) {
//            cafesList.add(r);
//
//            System.out.println("AT END");
//
//            System.out.println(r.getRating());
//        }*/
//return cafeslist;
//
//    }
}

