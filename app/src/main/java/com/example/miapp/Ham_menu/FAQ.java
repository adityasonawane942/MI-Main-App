package com.example.miapp.Ham_menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.recyclerview.widget.RecyclerView;

import com.example.miapp.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import com.example.miapp.Ham_menu.FAQs.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FAQ extends androidx.fragment.app.Fragment {


    public String loadJSONFromAsset(){
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open("faq.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_faqs, container, false);


        RecyclerView recyclerView=view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Question> questions=new ArrayList<>();


        try {

            JSONArray faq_array = new JSONArray(loadJSONFromAsset());
            // implement for loop for getting users list data
            for (int i = 0; i < faq_array.length(); i++) {
                // create a JSONObject for fetching single user data
                JSONObject entry = faq_array.getJSONObject(i);
                // fetch email and name and store it in arraylist
                ArrayList<Answer> a=new ArrayList<>();
                a.add(new Answer(entry.getString("Answer")));
                questions.add(new Question(entry.getString("Question"),a));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        AnswerAdapter adapter = new AnswerAdapter(questions);
        recyclerView.setAdapter(adapter);


        return view;

    }
}
