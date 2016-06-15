package com.example.shanupaayeshmal.book_my_hotel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class FbActivity extends AppCompatActivity {
    private static Button btnFB;
    private static WebView wbFB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb);
        urlOpenFB();
    }

    public void urlOpenFB(){
        btnFB=(Button)findViewById(R.id.button_fb);
        wbFB=(WebView)findViewById(R.id.webView_FB);

        btnFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.youtube.com";
                wbFB.getSettings().setLoadsImagesAutomatically(true);
                wbFB.getSettings().setJavaScriptEnabled(true);
                wbFB.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                wbFB.loadUrl(url);


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fb, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
