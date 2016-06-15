package com.example.shanupaayeshmal.book_my_hotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainMenuActivity extends AppCompatActivity {
    private static Button btn1;
    private static Button btn2;
    private static Button btn3;
    private static ImageView btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        openGoooglemap();
        openAbout();
        openFB();
        openWeb();
    }



    // Google Maps
     public void openGoooglemap() {

         btn1 = (Button) findViewById(R.id.google_button);

         btn1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent1 = new Intent(MainMenuActivity.this, MapsActivity.class);
                 startActivity(intent1);
                 finish();
             }
         });
     }

    //Open FB
    public void openFB(){

        btn4=(ImageView)findViewById(R.id.fb_Imgbutton);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainMenuActivity.this, FbActivity.class);
                startActivity(intent2);
                finish();
            }
        });

    }

    //  Web site
    public void openWeb(){

        btn3=(Button)findViewById(R.id.web_button);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainMenuActivity.this, WebActivity.class);
                startActivity(intent3);
                finish();
            }
        });

    }



    public void openAbout(){

        btn2=(Button)findViewById(R.id.about_button);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(MainMenuActivity.this, AboutUsActivity.class);
                startActivity(intent4);
                finish();
            }
        });

    }









    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
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
