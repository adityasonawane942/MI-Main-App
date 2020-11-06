package com.example.miapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.miapp.Retrofit.Api;
import com.example.miapp.Retrofit.Event;
import com.example.miapp.adapters.EventAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class tab4 extends Fragment{
    View view;
    private static ListView simpleList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.tab4, container, false);
        Event = new ArrayList<>();
       // getEvents("123456");
        return view;
    }
    private static EventAdapter adapter;
    ArrayList<Event> Event;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        simpleList = (ListView) getView().findViewById(R.id.simpleListView);
    }
    private void getEvents(String gID) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.baseUrl)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Event>> call = api.getEvents(gID);

        call.enqueue(new Callback<List<com.example.miapp.Retrofit.Event>>() {
            @Override
            public void onResponse(Call<List<com.example.miapp.Retrofit.Event>> call, Response<List<com.example.miapp.Retrofit.Event>> response) {
                List<Event> eventList=response.body();
                if (getActivity()!=null) {
                    Event.addAll(eventList);
                    adapter= new EventAdapter(Event, getActivity());
                }
                simpleList.setAdapter(adapter);
                String[] events = new String[eventList.size()];
                for (int i = 0; i < eventList.size(); i++) {
                    events[i] = eventList.get(i).getEvent_name();
                }

            }

            @Override
            public void onFailure(Call<List<com.example.miapp.Retrofit.Event>> call, Throwable t) {

            }
        });

    }
}
