package com.example.simplifiedcoding;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener  {

    EditText editTextUsername, editTextEmail, editTextPassword;
  //  RadioGroup radioGroupGender;
    LinearLayout male,female;
    RelativeLayout main;
    String gender2="no";
    ImageView show,splash;
    String str="no";

   // int x=0;

/*
    <RadioGroup
    android:id="@+id/radioGender"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginBottom="8dp"
    android:layout_marginTop="8dp"
    android:orientation="horizontal">

        <RadioButton
    android:id="@+id/radioButtonMale"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:checked="true"
    android:text="Male" />


        <RadioButton
    android:id="@+id/radioButtonFemale"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Female" />

    </RadioGroup>

 */
private static MainActivity mInstance;
   // private MainActivity MyApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInstance = this;
        checkConnection();


        /*
        if (!isConnected(this)) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Internet Connection Alert")
                    .setMessage("Please Check Your Internet Connection;  This app requires internet connection to work")
                    .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    }).show();

        } else  {

         */

            //if the user is already logged in we will directly start the profile activity
            //splash.setVisibility(View.VISIBLE);



            editTextUsername = (EditText) findViewById(R.id.editTextUsername);
            editTextEmail = (EditText) findViewById(R.id.editTextEmail);
            editTextPassword = (EditText) findViewById(R.id.editTextPassword);
           // radioGroupGender = (RadioGroup) findViewById(R.id.radioGender);


            splash = findViewById(R.id.splash);
            main = findViewById(R.id.main);



               show = findViewById(R.id.showpassword);
            male = findViewById(R.id.male);
            female = findViewById(R.id.female);


          //  Intent intent = getIntent();
          //  str = intent.getStringExtra("keyv");

         //   Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();




            male.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    male.setBackgroundResource(R.drawable.gender);

                    female.setBackgroundResource(R.drawable.gender2);


                    if(gender2=="no") {
                        Toast.makeText(getApplicationContext(), "Male", Toast.LENGTH_SHORT).show();
                    }

                    gender2="Male";
                }
            });


            female.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    female.setBackgroundResource(R.drawable.gender);

                    male.setBackgroundResource(R.drawable.gender2);


                    if(gender2=="no") {
                        Toast.makeText(getApplicationContext(), "Female", Toast.LENGTH_SHORT).show();
                    }

                    gender2="Female";
                }
            });


            show.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        editTextPassword.setInputType(InputType.TYPE_CLASS_TEXT);

                }
            });

            findViewById(R.id.buttonRegister).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //if user pressed on button register
                    //here we will register the user to server
                    registerUser();
                }
            });

            findViewById(R.id.textViewLogin).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //if user pressed on login
                    //we will open the login screen
                    finish();
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
            });
            //finish
        }

    public static synchronized MainActivity getInstance() { return mInstance; }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) { ConnectivityReceiver.connectivityReceiverListener = listener; }

    @Override
    protected void onResume() {
        super.onResume();

        // register connection status listener
        MainActivity.getInstance().setConnectivityListener(this);
    }

    /**
     * Callback will be triggered when there is change in
     * network connection
     */
    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
       showSnack(isConnected);

    }
    private void checkConnection() {
     //   Activity activity =   this;
        boolean isConnected = ConnectivityReceiver.isConnected();
        showSnack(isConnected);
    }

    private  void showSnack(boolean isConnected){
if(isConnected){}else {
    AlertDialog.Builder builder = new AlertDialog.Builder(
            MainActivity.this);
    builder.setTitle("N0 Internet Connection");
    builder.setMessage("This app requires internet connection");
    builder.setCancelable(false);
    builder.setPositiveButton("Close",
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog,
                                    int which) {
                    Toast.makeText(getApplicationContext(), "Please connect to Internet", Toast.LENGTH_LONG).show();
                    finish();
                }
            });
    builder.show();
}

    }

    /*
    // Showing the status in Snackbar
    private void showSnack(boolean isConnected) {
        String message;
        int color;
        if (isConnected) {
            message = "Good! Connected to Internet";
            color = Color.WHITE;
        } else {
            message = "Sorry! Not connected to internet";
            color = Color.RED;
        }

        Snackbar snackbar = Snackbar
                .make(findViewById(R.id.fab), message, Snackbar.LENGTH_LONG);

        View sbView = snackbar.getView();
     //   TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
       // textView.setTextColor(color);
        snackbar.show();
    }

     */

    /*
    private boolean isConnected(MainActivity mainActivity) {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if((wifiConn != null && wifiConn.isConnected())||(mobileConn != null && mobileConn.isConnected())){
            return true;
        }
        else {
            return false;
        }

    }

     */



    private void registerUser() {
        final String username = editTextUsername.getText().toString().trim();
        final String email = editTextEmail.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();

     //   final String gender = ((RadioButton) findViewById(radioGroupGender.getCheckedRadioButtonId())).getText().toString();
         final  String gender = gender2;
        //first we will do the validations

        if (TextUtils.isEmpty(username)) {
            editTextUsername.setError("Please enter username");
            editTextUsername.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            editTextEmail.setError("Please enter your email");
            editTextEmail.requestFocus();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Enter a valid email");
            editTextEmail.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError("Enter a password");
            editTextPassword.requestFocus();
            return;
        }

        if(gender.equals("no")){

            Toast.makeText(getApplicationContext(), "Please Select Gender", Toast.LENGTH_SHORT).show();
            return;

        }

        //if it passes all the validations

        class RegisterUser extends AsyncTask<Void, Void, String> {

            private ProgressBar progressBar;

            @Override
            protected String doInBackground(Void... voids) {
                //creating request handler object
                RequestHandler requestHandler = new RequestHandler();

                //creating request parameters
                HashMap<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("email", email);
                params.put("password", password);
                params.put("gender", gender);

                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_REGISTER, params);
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                //displaying the progress bar while user registers on the server
                progressBar = (ProgressBar) findViewById(R.id.progressBar);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                //hiding the progressbar after completion
                progressBar.setVisibility(View.GONE);

                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(s);

                    //if no error in response
                    if (!obj.getBoolean("error")) {
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                        //getting the user from the response
                        JSONObject userJson = obj.getJSONObject("user");

                        //creating a new user object
                        user user = new user(
                                userJson.getInt("id"),
                                userJson.getString("username"),
                                userJson.getString("email"),
                                userJson.getString("gender")
                        );

                        //storing the user in shared preferences
                        SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);

                        //starting the profile activity
                        finish();
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        //executing the async task
        RegisterUser ru = new RegisterUser();
        ru.execute();
    }

   }