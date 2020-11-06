package com.example.miapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class about_profile extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        RecyclerView recyclerView=(RecyclerView) inflater.inflate(R.layout.about2,container,false);
        //RecyclerView recyclerView=(RecyclerView) inflater.inflate(R.layout.about,container,false);

        setUpRecyclerView(recyclerView);


        return  recyclerView;
    }

    private void setUpRecyclerView(RecyclerView rv) {

        //rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
        RecyclerView.LayoutManager manager = new GridLayoutManager(rv.getContext(), 3);

        rv.setLayoutManager(manager);

        rv.setAdapter(new AboutUsAdapter(rv.getContext(), getListForItems()));
    }
    public ArrayList<String> getListForItems()
    {
        ArrayList<String> list =new ArrayList<>();
        list.add("First Item");
        list.add("Second Item");
        list.add("Third Item");
        list.add("Fourth Item");
        list.add("Fifth Item");
        list.add("Six Item");
        list.add("Seven Item");
        list.add("8 Item");
        list.add("9 Item");
        list.add("10 Item");
        list.add("11 Item");
        list.add("12 Item");
        list.add("13 Item");
        list.add("14 Item");
        list.add("15 Item");
        list.add("16 Item");
        list.add("17 Item");
        list.add("18 Item");
        list.add("19 Item");
        list.add("20 Item");
        list.add("21 Item");

        return list;
    }

//    private class AboutUsAdapter extends RecyclerView.Adapter {
//        public AboutUsAdapter(Object context, ArrayList<String> listForItems) {
//        }
//
//        @NonNull
//        @Override
//        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            return null;
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//
//        }
//
//        @Override
//        public int getItemCount() {
//            return 0;
//        }
//    }

    public  static class AboutUsAdapter extends RecyclerView.Adapter<AboutUsAdapter.ViewHolder>
    {
        ArrayList<String> aboutlist=new ArrayList<>();
        Context aboutuscontext;
        public static class ViewHolder extends RecyclerView.ViewHolder
        {
            public final TextView items;
            public ViewHolder(View view)
            {
                super(view);
                items=(TextView)view.findViewById(R.id.itemname);
                items.setText("This");

            }
        }
        public AboutUsAdapter(Context context, ArrayList<String> list)
        {
            aboutuscontext=context;
            aboutlist=list;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_listitems, parent, false);
            return  new ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.items.setText(aboutlist.get(position));
        }
        @Override
        public int getItemCount() {
            return aboutlist.size();
        }
    }
}
    
