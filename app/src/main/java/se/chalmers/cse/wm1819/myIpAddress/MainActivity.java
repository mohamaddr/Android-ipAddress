package se.chalmers.cse.wm1819.myIpAddress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {



    //Field for parameter name
    public static final String HTTP_PARAM = "httpResponse";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // recovering the instance state
        setContentView(R.layout.activity_main);
    }

    public void onClickBook(View view)
    {
        Intent intent = new Intent(this, MainIpActivity.class);
        startActivity(intent);
    }


}
