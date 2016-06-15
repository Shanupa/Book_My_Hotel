package com.example.shanupaayeshmal.book_my_hotel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.amigold.fundapter.interfaces.DynamicImageLoader;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements AsyncResponse {
    private ArrayList<Product> productList;
    private ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        PostResponseAsyncTask taskread = new PostResponseAsyncTask(ListActivity.this, this);
        taskread.execute("http://www.slcabs.com/myhotel/product.php");


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
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

    @Override
    public void processFinish(String s) {
        productList = new JsonConverter<Product>().toArrayList(s, Product.class);
        BindDictionary<Product> dict = new BindDictionary<Product>();
        dict.addStringField(R.id.ho_name, new StringExtractor<Product>() {
            @Override
            public String getStringValue(Product product, int i) {
                return product.hotel_name;
            }
        });
        dict.addStringField(R.id.tp, new StringExtractor<Product>() {
            @Override
            public String getStringValue(Product product, int i) {
                return ""+product.tp_no;
            }
        });
        dict.addStringField(R.id.ho_address, new StringExtractor<Product>() {
            @Override
            public String getStringValue(Product product, int i) {
                return product.address;
            }
        });
        dict.addDynamicImageField(R.id.ho_img, new StringExtractor<Product>() {
            @Override
            public String getStringValue(Product product, int i) {
                return product.img;
            }
        }, new DynamicImageLoader() {
            @Override
            public void loadImage(String s, ImageView imageView) {
                Picasso.with(ListActivity.this).load(s).into(imageView);

            }
        });
        FunDapter<Product> adapter=new FunDapter<Product>(ListActivity.this,productList,R.layout.layout_list,dict);

        lst=(ListView)findViewById(R.id.listHotel);
        lst.setAdapter(adapter);




    }
}
