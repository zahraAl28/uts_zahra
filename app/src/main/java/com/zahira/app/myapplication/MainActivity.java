package com.zahira.app.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    Button btnHome, btnAbout, btnHelp, btnExit;

    first fragmentHome;
    second fragmentAbout;
    third fragmentHelp;
    forth fragmentExit;


    @SuppressLint("QueryPermissionsNeeded")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHome = findViewById(R.id.btn_home);
        btnAbout = findViewById(R.id.btn_about);
        btnHelp = findViewById(R.id.btn_help);
        btnExit = findViewById(R.id.btn_exit);

        btnHome.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
        btnHelp.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }

    void menuHome() {
        fragmentHome = new first();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragmentHome);
        ft.commit();
    }

    void menuAbout() {
        fragmentAbout = new second();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragmentAbout);
        ft.commit();
    }

    void menuHelp() {
        fragmentHelp = new third();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragmentHelp);
        ft.commit();
    }

    void menuExit() {
        fragmentExit = new forth();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragmentExit);
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        if (v == btnHome) {
            menuHome();
        }
        if (v == btnAbout) {
            menuAbout();
        }
        if (v == btnHelp) {
            menuHelp();
        }
        if (v == btnExit) {
            menuExit();
        }
    }

    public void panggil(View view) {
        String nomor = "021291871";
        Intent panggil = new Intent(Intent.ACTION_DIAL);
        panggil.setData(Uri.fromParts("tel", nomor, null));
        startActivity(panggil);
    }

    public void buka(View view) {
        String url = "https://facebook.com";
        Intent bukabrowser = new Intent(Intent.ACTION_VIEW);
        bukabrowser.setData(Uri.parse(url));
        startActivity(bukabrowser);
    }

    public void btnKirim(View v) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"zahiramazhar30@gmail.com"});
        intent.putExtra(Intent.EXTRA_CC, new String[]{"zahiramazhar30@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Email dari Aplikasi Android");
        intent.putExtra(Intent.EXTRA_TEXT, "Hai, ini adalah percobaan mengirim email dari aplikasi android");

        try {
            startActivity(Intent.createChooser(intent, "Ingin Mengirim Email ?"));
        } catch (android.content.ActivityNotFoundException ex) {
            //do something else
        }
    }

}