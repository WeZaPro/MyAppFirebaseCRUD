package com.example.myappfirebasecrud;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.myappfirebasecrud.MainActivity.PathFolder;


/**
 * A simple {@link Fragment} subclass.
 */
public class HideFilterDataFragment extends Fragment {
    RecyclerView _myRecyclerView;
    MyAdapter myAdapter;
    DatabaseReference databaseReference;
    MyModelData myModelData;
    ArrayList<MyModelData> listData = new ArrayList<>();
    View v;
    public HideFilterDataFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        databaseReference = FirebaseDatabase.getInstance().getReference().child(PathFolder);
        v = inflater.inflate(R.layout.fragment_main, container, false);
        setLayout(v);
        myModelData = new MyModelData();
        loadData();
        return v;
    }

    private void loadData() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                // ใส่เพราะ เมื่อ Insert ข้อมูลแล้ว RecyclerView Dupplicate Data View
                listData.clear();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    myModelData = dataSnapshot1.getValue(MyModelData.class);
                    //test
                    myModelData.setUID(dataSnapshot1.getKey());

                    listData.add(myModelData);
                }
                myAdapter = new MyAdapter(getActivity(), listData);
                _myRecyclerView.setAdapter(myAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "error " + databaseError, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setLayout(View v) {
        _myRecyclerView = v.findViewById(R.id.myRecyclerView);
        _myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

}
