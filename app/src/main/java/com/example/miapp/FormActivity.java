package com.example.miapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.miapp.Retrofit.Api;

import com.example.miapp.Retrofit.NewReg;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormActivity extends AppCompatActivity {

    private String name;
    private String email;
    private String mobile_number;
    private String present_college;
    private String present_city;
    private String zip_code;
    private String google_id;
    private String year_of_study;
    private String gender;
    private String status = "Something";

    private EditText nameEditText;
    private EditText mobileEditText;
    private AutoCompleteTextView collegeEditText;
    private EditText cityEditText;
    private EditText zipEditText;
    private EditText yearEditText;

    private Button submit;

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("colleges.json");
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_activity);

        submit = findViewById(R.id.submit);
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
//            String personName = acct.getDisplayName();
//            String personGivenName = acct.getGivenName();
//            String personFamilyName = acct.getFamilyName();
            email = acct.getEmail();
            google_id = acct.getId();

        }


        ArrayList<String> collegeNames = new ArrayList<String>();


        try {

            JSONArray college_array = new JSONArray(loadJSONFromAsset());
            // implement for loop for getting users list data
            for (int i = 0; i < college_array.length(); i++) {
                // create a JSONObject for fetching single user data
                JSONObject entry = college_array.getJSONObject(i);
                // fetch email and name and store it in arraylist

                collegeNames.add(entry.getString("CollegeName"));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, collegeNames);
        //Getting the instance of AutoCompleteTextView
        AutoCompleteTextView actv = findViewById(R.id.college);
        actv.setThreshold(3);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView







        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                NewReg newUser;
                nameEditText=findViewById(R.id.name);
                name=nameEditText.getText().toString();

                mobileEditText=findViewById(R.id.mobile);
                mobile_number=mobileEditText.getText().toString();

                collegeEditText=findViewById(R.id.college);
                present_college=collegeEditText.getText().toString();

                cityEditText=findViewById(R.id.city);
                present_city=cityEditText.getText().toString();

                zipEditText=findViewById(R.id.fb);
                zip_code=zipEditText.getText().toString();

                yearEditText=findViewById(R.id.year);
                year_of_study=yearEditText.getText().toString();

                newUser= new NewReg(name, email, mobile_number, present_college, present_city, zip_code, gender, google_id, year_of_study, status);

                createPost(newUser);

                Gson gson = new Gson();
                String json = gson.toJson(newUser);


                Log.d("data", json);
            }
        });


}



    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.male:
                if (checked)
                    gender="Male";
                    break;
            case R.id.female:
                if (checked)
                    gender="Female";
                    break;
            case R.id.other:
                if(checked)
                    gender="Other";
                    break;
        }
    }

    private void createPost(NewReg post){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.baseUrl)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<NewReg> call=api.postJson(post);

        call.enqueue(new Callback<NewReg>() {
            @Override
            public void onResponse(Call<NewReg> call, Response<NewReg> response) {
                Log.d("Response", "success");
                startActivity(new Intent(FormActivity.this, MainActivity.class));
            }

            @Override
            public void onFailure(Call<NewReg> call, Throwable t) {
                Toast.makeText(FormActivity.this, "Task Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }



    }


