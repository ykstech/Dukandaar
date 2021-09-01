package com.example.simplifiedcoding;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;

public class ProfileActivity extends AppCompatActivity {

    TextView textViewId, textViewUsername, textViewEmail, textViewGender,amount,payed,montha,monthp,yeara,yearp,bill,billp;
    Button buttoncrud;

    int id;
    String jamount;
    ProgressBar progressBar;
    RelativeLayout ssc;

    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    String month2=null;

    private static final  int Timea= 2000;
    private long mback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        buttoncrud = (Button) findViewById(R.id.buttoncrud);

        ssc = findViewById(R.id.ssc);


        //if the user is not logged in
        //starting the login activity
        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }




        //textViewId = (TextView) findViewById(R.id.textViewId);
        textViewUsername = (TextView) findViewById(R.id.textViewUsername);
        textViewEmail = (TextView) findViewById(R.id.textViewEmail);
        textViewGender = (TextView) findViewById(R.id.textViewGender);

        amount = findViewById(R.id.amount);
        payed = findViewById(R.id.payed);
        montha = findViewById(R.id.montha);
        monthp = findViewById(R.id.monthp);
        yeara = findViewById(R.id.yeara);
        yearp = findViewById(R.id.yearp);
        bill = findViewById(R.id.bill);
        billp = findViewById(R.id.billp);

        //getting the current user
        user user = SharedPrefManager.getInstance(this).getUser();

        //setting the values to the textviews
       // textViewId.setText(String.valueOf(user.getId()));
        textViewUsername.setText(user.getUsername());
        id = user.getId();
        textViewEmail.setText(user.getEmail());






      // amount.setText(jamount);


       // textViewGender.setText(user.getGender());

        //when the user presses logout button
        //calling the logout method

        switch (month+1){
            case 1: month2 = "Jan";break;
            case 2: month2 = "Feb";break;
            case 3: month2 = "Mar";break;
            case 4: month2 = "Apr";break;
            case 5: month2 = "May";break;
            case 6: month2 = "Jun";break;
            case 7: month2 = "Jul";break;
            case 8: month2 = "Aug";break;
            case 9: month2 = "Sep";break;
            case 10: month2 = "Oct";break;
            case 11: month2 = "Nov";break;
            case 12: month2 = "Dec";break;
        }



        if(user.getGender().equals("Male")){

            textViewGender.setBackgroundResource(R.drawable.ic_male_svgrepo_com);
        }else{

            textViewGender.setBackgroundResource(R.drawable.ic_female_svgrepo_com);
        }

        findViewById(R.id.buttonLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                SharedPrefManager.getInstance(getApplicationContext()).logout();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });




        findViewById(R.id.buttoncrud).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(getApplicationContext(), crud.class));
            }
        });




       // Toast.makeText(getApplicationContext(), Integer.toString(id), Toast.LENGTH_SHORT).show();

        //createHero(2,"0");


       getdata();


    }

    @Override
    public  void  onBackPressed(){
        if(mback + Timea> System.currentTimeMillis()){
             super.onBackPressed();
             return;
        }else {
            Toast.makeText(getBaseContext(),"Press Back again to Exit",Toast.LENGTH_SHORT).show();

        }
        mback = System.currentTimeMillis();
    }

    private  void getdata(){
        @SuppressLint("StaticFieldLeak")
        class UserLogin2 extends AsyncTask<Void, Void, String> {


            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressBar = (ProgressBar) findViewById(R.id.progressBar);

                //  ssc.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);



            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);


                try {
                    //converting response to json object

                    progressBar.setVisibility(View.GONE);

                    JSONObject obj = new JSONObject(s);

                    //if no error in response
                    if (!obj.getBoolean("error")) {
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();


                        amount.setText("₹"+Integer.toString(obj.getInt("amount")));
                        payed.setText("₹"+Integer.toString(obj.getInt("payed")));
                        montha.setText("₹"+Integer.toString(obj.getInt("montha")));
                        monthp.setText("₹"+Integer.toString(obj.getInt("monthp")));
                        yeara.setText("₹"+Integer.toString(obj.getInt("yeara")));
                        yearp.setText("₹"+Integer.toString(obj.getInt("yearp")));
                        bill.setText(Integer.toString(obj.getInt("bill")));
                        billp.setText(Integer.toString(obj.getInt("billp")));

                        ssc.setVisibility(View.VISIBLE);
                        //getting the user from the response
                        /*
                        JSONObject user2Json = obj.getJSONObject("user");


                        //creating a new user object
                        user2 user2 = new user2(
                                user2Json.getInt("amount"),
                                user2Json.getInt("payed"),
                                user2Json.getInt("montha"),
                                user2Json.getInt("monthp"),
                                user2Json.getInt("yeara"),
                                user2Json.getInt("yearp"),
                                user2Json.getInt("bill"),
                                user2Json.getInt("billp")
                        );


                         */

                     //    jamount = obj.getString("amount");
                        //storing the user in shared preferences
                        //SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);

                        //starting the profile activity
                      //  finish();
                      //  startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Server Problem", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                //creating request handler object
                RequestHandler requestHandler = new RequestHandler();

                //creating request parameters
                HashMap<String, String> params = new HashMap<>();
                params.put("month", month2);
                params.put("year", Integer.toString(year));
                params.put("pid",Integer.toString(id));

                //returing the response
                return requestHandler.sendPostRequest(URLs.url_data, params);
            }
        }

        UserLogin2 ul = new UserLogin2();
        ul.execute();
    }



}