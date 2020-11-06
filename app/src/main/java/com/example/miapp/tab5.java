package com.example.miapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;
//import android.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class tab5 extends Fragment{
    View view;
    Uri personPhoto;
    Button signOut;
    private GoogleSignInClient mGoogleSignInClient;
    private EventListener listener;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.tab5, container, false);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getActivity());
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);

        if (acct != null) {
//            String personName = acct.getDisplayName();
//            String personGivenName = acct.getGivenName();
//            String personFamilyName = acct.getFamilyName();
//            String personEmail = acct.getEmail();
              String personId = acct.getId();
              personPhoto = acct.getPhotoUrl();
              Log.d("ID", personId);
        }

//        startActivity(new Intent(getActivity(), SignInActivity.class));

        signOut=(Button) view.findViewById(R.id.sign_out_button);

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("Check2", "Something");
              signOut();


            }
        });




        final FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.profile_pictures, new about_profile());
        transaction.addToBackStack(null);
        transaction.commit();


        return view;
    }

    private void signOut() {

        mGoogleSignInClient.signOut()
                .addOnCompleteListener(getActivity(), new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // [START_EXCLUDE]
                        Log.d("Check", "Signed Out");
                        startActivity(new Intent(getActivity(), SignInActivity.class));
                        // [END_EXCLUDE]
                    }
                });

    }


}
