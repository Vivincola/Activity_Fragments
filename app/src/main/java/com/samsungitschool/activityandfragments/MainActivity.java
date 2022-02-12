package com.samsungitschool.activityandfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //activitu - екран програми
    //intent - намериние


    private Button btnOpen, btnReplace, btnDelete;

    private FragmentTransaction fragmentTransaction;

// 17:30 gg
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycle","onCreate");

        btnReplace = findViewById(R.id.btnReplace);
        btnDelete = findViewById(R.id.btnDelete);

        Fragment fragment1 = new BlankFragment();
        Fragment fragment2 = new BlankFragment2();

        btnOpen.setOnClickListener(v -> changeFragment(fragment1, TypeTransaction.ADD));
        btnReplace.setOnClickListener(v -> changeFragment(fragment2, TypeTransaction.REPLACE));
        btnDelete.setOnClickListener(v -> changeFragment(fragment1, TypeTransaction.REMOVE));
//        Intent intent =new Intent(this,MainActivity2.class);
//        intent.putExtra("KEY", "Value");
//        startActivity(intent);
//        finish();
    }

    private void changeFragment(Fragment fragment, TypeTransaction typeTransaction){
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (typeTransaction==TypeTransaction.ADD){
            fragmentTransaction.add(R.id.container, fragment);
        }else if (typeTransaction==TypeTransaction.REPLACE){
            fragmentTransaction.replace(R.id.container, fragment);
        }else if(typeTransaction == TypeTransaction.REMOVE){
            fragmentTransaction.remove(fragment);
        }
        fragmentTransaction.commit();
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("Lifecycle", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("Lifecycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle", "onDestroy");
    }

    private void openBrowser(){
        String url = "google.com";
        Uri uri = Uri.parse(url);

        try{
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }catch (ActivityNotFoundException e){
            Toast.makeText(this, "Cant start browser", Toast.LENGTH_SHORT).show();
        }


        startActivity(new Intent(Intent.ACTION_VIEW, uri));

    }
}