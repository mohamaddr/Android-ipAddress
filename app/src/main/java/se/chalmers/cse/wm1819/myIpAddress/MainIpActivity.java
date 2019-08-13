package se.chalmers.cse.wm1819.myIpAddress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;


public class MainIpActivity extends AppCompatActivity {
    TextView ipView ;

    public final String STATE_LEVEL="IK";


    //Field for parameter name
    public static final String HTTP_PARAM = "httpResponse";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // recovering the instance state


        setContentView(R.layout.activity_main_ip);
        ipView = findViewById(R.id.ipTextView);
        Intent intent = getIntent();

    }






    public void onClickGetBooks (View view) {
        //Get the text view in which we will show the result.
        final TextView ipView = findViewById(R.id.ipTextView);

        String url = getString(R.string.server_url_Myip);

        //This uses Volley (Threading and a request queue is automatically handled in the background)
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        Gson gson = new Gson();

                        String dataArray = null;

                        try {
                            dataArray = response.getString("ip");
                        } catch (JSONException e) {
                            Log.e(this.getClass().toString(), e.getMessage());
                        }




                        ipView.setText(dataArray);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ipView.setText("Error! " + error.toString());
                    }
                });

        //The request queue makes sure that HTTP requests are processed in the right order.
        queue.add(jsonObjectRequest);
    }





    @Override
    public void onSaveInstanceState(Bundle outState) {


        outState.putString(STATE_LEVEL,ipView.getText().toString());

        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        ipView.setText(savedInstanceState.getString(STATE_LEVEL));
    }








}
