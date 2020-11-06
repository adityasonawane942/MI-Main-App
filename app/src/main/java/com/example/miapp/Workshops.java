package com.example.miapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miapp.Retrofit.AllEvents;
import com.example.miapp.Retrofit.Api;
import com.example.miapp.Retrofit.Event;
import com.example.miapp.adapters.EventAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Workshops extends Fragment {
    View view;
    private static ListView simpleList;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.tab4,container,false);
        //RecyclerView recyclerView=(RecyclerView) inflater.inflate(R.layout.about,container,false);
        getAllEvents();
        simpleList=(ListView) view.findViewById(R.id.simpleListView);
        return  view;
    }

    private static EventAdapter adapter;
    ArrayList<com.example.miapp.Retrofit.Event> Event=new ArrayList<Event>();
    List<Event> eventList= new List<com.example.miapp.Retrofit.Event>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(@Nullable Object o) {
            return false;
        }

        @NonNull
        @Override
        public Iterator<com.example.miapp.Retrofit.Event> iterator() {
            return null;
        }

        @Nullable
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(@Nullable T[] a) {
            return null;
        }

        @Override
        public boolean add(com.example.miapp.Retrofit.Event event) {
            return false;
        }

        @Override
        public boolean remove(@Nullable Object o) {
            return false;
        }

        @Override
        public boolean containsAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(@NonNull Collection<? extends com.example.miapp.Retrofit.Event> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, @NonNull Collection<? extends com.example.miapp.Retrofit.Event> c) {
            return false;
        }

        @Override
        public boolean removeAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public com.example.miapp.Retrofit.Event get(int index) {
            return null;
        }

        @Override
        public com.example.miapp.Retrofit.Event set(int index, com.example.miapp.Retrofit.Event element) {
            return null;
        }

        @Override
        public void add(int index, com.example.miapp.Retrofit.Event element) {

        }

        @Override
        public com.example.miapp.Retrofit.Event remove(int index) {
            return null;
        }

        @Override
        public int indexOf(@Nullable Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(@Nullable Object o) {
            return 0;
        }

        @NonNull
        @Override
        public ListIterator<com.example.miapp.Retrofit.Event> listIterator() {
            return null;
        }

        @NonNull
        @Override
        public ListIterator<com.example.miapp.Retrofit.Event> listIterator(int index) {
            return null;
        }

        @NonNull
        @Override
        public List<com.example.miapp.Retrofit.Event> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

    private void setUpRecyclerView(RecyclerView rv) {
        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
        rv.setAdapter(new about.AboutUsAdapter(rv.getContext(), getListForItems()));
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

    public void getAllEvents(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.baseUrl)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<AllEvents>> call =api.getAllEvent();

        call.enqueue(new Callback<List<AllEvents>>() {
            @Override
            public void onResponse(Call<List<AllEvents>> call, Response<List<AllEvents>> response) {
                List<AllEvents> allEvents = response.body();

                eventList=allEvents.get(4).getEvent();

                if (eventList != null) {
                    if (getActivity() != null) {
                        Event.addAll(eventList);
                    }
                    String[] events = new String[eventList.size()];
                    for (int i = 0; i < eventList.size(); i++) {
                        events[i] = eventList.get(i).getEvent_name();
                    }


                    adapter = new EventAdapter(Event, getActivity());
                    simpleList.setAdapter(adapter);
                }
                else{

                }
            }

            @Override
            public void onFailure(Call<List<AllEvents>> call, Throwable t) {

            }
        });
    }
    public  static class AboutUsAdapter extends RecyclerView.Adapter<about.AboutUsAdapter.ViewHolder>
    {
        ArrayList<String> aboutlist=new ArrayList<>();
        Context aboutuscontext;
        public static class ViewHolder extends RecyclerView.ViewHolder
        {
            public final TextView items;
            public ViewHolder(View view)
            {
                super(view);
                items=(TextView)view.findViewById(R.id.event_name);
            }
        }
        public AboutUsAdapter(Context context, ArrayList<String> list)
        {
            aboutuscontext=context;
            aboutlist=list;
        }
        @Override
        public about.AboutUsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.listitems, parent, false);
            return  new about.AboutUsAdapter.ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(about.AboutUsAdapter.ViewHolder holder, int position) {
            holder.items.setText(aboutlist.get(position));
        }
        @Override
        public int getItemCount() {
            return aboutlist.size();
        }
    }
}
