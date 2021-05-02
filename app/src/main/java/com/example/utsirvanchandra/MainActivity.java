package com.example.utsirvanchandra;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    public Button btntelp, btnweb, btnmaps, btnemail, btn_inttelp, btn_intweb, btn_intmaps, btn_intmail;

    telepon fragmenttelepon;
    web     fragmentweb;
    maps    fragmentmaps;
    email   fragmentemail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btntelp     = findViewById(R.id.btn_telp);
        btnweb      = findViewById(R.id.btn_web);
        btnmaps     = findViewById(R.id.btn_maps);
        btnemail    = findViewById(R.id.btn_email);
        btn_inttelp = findViewById(R.id.btn_inttelp);
        btn_intweb  = findViewById(R.id.btn_intweb);
        btn_intmaps = findViewById(R.id.btn_intmaps);
        btn_intmail = findViewById(R.id.btn_intmail);

        btntelp.setOnClickListener(this);
        btnweb.setOnClickListener(this);
        btnmaps.setOnClickListener(this);
        btnemail.setOnClickListener(this);
        btn_inttelp.setOnClickListener(this);
        btn_intweb.setOnClickListener(this);
        btn_intmaps.setOnClickListener(this);
        btn_intmail.setOnClickListener(this);
    }

    void menutelepon() {
        fragmenttelepon = new telepon();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragmenttelepon);
        ft.commit();
    }
    void menuweb() {
        fragmentweb = new web();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragmentweb);
        ft.commit();
    }
    void menumaps() {
        fragmentmaps = new maps();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragmentmaps);
        ft.commit();
    }
    void menuemail() {
        fragmentemail = new email();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragmentemail);
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        if (v == btntelp) {
            menutelepon();
        }
        if (v == btnweb) {
            menuweb();
        }
        if (v == btnmaps) {
            menumaps();
        }
        if (v == btnemail) {
            menuemail();
        }
        if (v == btn_inttelp) {
            Intent call = new Intent(Intent.ACTION_DIAL);
            call.setData(Uri.parse("tel:" + "089600009999"));
            startActivity(call);
        }
        if (v == btn_intweb) {
            String url = "http://shopee.co.id/dtautocare.bekasi";
            Intent web = new Intent(Intent.ACTION_VIEW);
            web.setData(Uri.parse(url));
            startActivity(web);
        }
        if (v == btn_intmaps) {
            String maps = "google.navigation:q=-6.283643, 106.991722";
            Intent map = new Intent(Intent.ACTION_VIEW);
            map.setData(Uri.parse(maps));
            startActivity(map);
        }
        if (v == btn_intmail) {
            Intent mail = new Intent(Intent.ACTION_SEND);
            mail.setType("text/plain");
            mail.putExtra(Intent.EXTRA_EMAIL, new String[] {"irvan.chndr.ic@gmail.com"});
            mail.putExtra(Intent.EXTRA_TEXT, "Hai, ini adalah percobaan mengirim email dari aplikasi android");

            try {
                startActivity(Intent.createChooser(mail, "Ingin Mengirim Email ?"));
            } catch (android.content.ActivityNotFoundException ex) {
            }
        }
    }
}