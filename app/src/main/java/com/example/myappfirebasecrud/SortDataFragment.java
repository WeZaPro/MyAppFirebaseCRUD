package com.example.myappfirebasecrud;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.myappfirebasecrud.MainActivity.PathFolder;

public class SortDataFragment extends Fragment {

    RecyclerView _myRecyclerView;
    MyAdapter myAdapter;
    DatabaseReference databaseReference;
    MyModelData myModelData;
    ArrayList<MyModelData> listData = new ArrayList<>();
    View v;


    public SortDataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        databaseReference = FirebaseDatabase.getInstance().getReference().child(PathFolder);
        v = inflater.inflate(R.layout.fragment_sort_data, container, false);
        setLayout(v);
        myModelData = new MyModelData();
        sortData();
        return v;
    }

    private void sortData() {

        databaseReference.orderByChild("number").addChildEventListener(new ChildEventListener() {
        //databaseReference.orderByValue().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                MyModelData myModelData = dataSnapshot.getValue(MyModelData.class);
                listData.add(myModelData);

                myAdapter = new MyAdapter(getActivity(), listData);
                _myRecyclerView.setAdapter(myAdapter);
            }


            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void setLayout(View v) {
        _myRecyclerView = v.findViewById(R.id.myRecyclerView);
        _myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

}
