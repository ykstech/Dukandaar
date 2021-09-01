package com.example.simplifiedcoding;


import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.MenuItemCompat;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.whiteelephant.monthpicker.MonthPickerDialog;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import static android.view.View.GONE;
import static android.view.View.TRANSLATION_Y;

public class crud extends AppCompatActivity  {
    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;
    int sc= 1;
int TotalAmount=0;
 int   TotalPayed=0;
 int   TotalRemain=0;
 int start=0;
 int height;

 Menu searchmenu;
 MenuItem itemsearch;


    Boolean system = true;
   // int total=0;
   String pidf;
   String dd="All Bills";
   Boolean back=true;
    private  List<Hero> filteredList2 = new ArrayList<>();


    File filePath3 = new File(Environment.getExternalStorageDirectory(), "Dukandaar/Excel");

    File filePath5 = new File(Environment.getExternalStorageDirectory(), "Dukandaar/Pdf");

    TextView editTextHeroId,payed,remain,updated,noofitem,creation,textView,drawertext,txttotall,txtpaid,txtremain,headername1,headeremail1;
    EditText  editTextName,editTextPhone,editTextAddress,bill,description,reference,amount,paynow,searchedit;
    TextInputLayout layoutname,layoutphone,layoutaddress,layoutbill,layoutdescription,layoutreference,layoutamount,layoutpaynow,layoutspinner;
    ProgressBar progressBar;
   // ListView listView;
    Button buttonAddUpdate,creationb,updatedb;
    Button cancel;
    LinearLayout hidden,noitem;
    List<Hero> heroList;

    SwipeRefreshLayout mSwipeRefreshLayout;

  //  Spinner type;
  // AppCompatImageView noitem;

    AutoCompleteTextView customer ;
     ScrollView linearLayout;
    ProductsAdapter adapter;

    CardView cardView2;
    CardView cardView3;
    CardView cardView4;
    NestedScrollView horizontal;
    BottomAppBar bottomAppBar;
    RecyclerView recyclerView;

   // List<Hero2> heroList2;

  //  LayerDrawable layerDrawable = (LayerDrawable) getResources().getDrawable(R.drawable.rounded);
  //  VectorDrawable vectorDrawable = (VectorDrawable) layerDrawable.findDrawableByLayerId(R.id.person4);


    DrawerLayout drawerLayout;
    NavigationView navigationView,navigationView2;
    View hview;
    Toolbar toolbar;
    Toolbar searchtoolbar;
   Menu Mymenu,menuep;
   MenuItem   iteme,itemp;
  //  TextView textView;



    AppCompatImageButton expand1,renew,left_menu,right_menu,excel;
    FloatingActionButton floatingActionButton;
    boolean isUpdating = false;
     boolean xx = true;

    Calendar calendar = Calendar.getInstance();
     int year = calendar.get(Calendar.YEAR);
     int month = calendar.get(Calendar.MONTH);
     int day = calendar.get(Calendar.DAY_OF_MONTH);
  //  private Handler adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        //dateView = (EditText) findViewById(R.id.creation);

        //hooks//start

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        bottomAppBar = findViewById(R.id.bottomappbar);
      //  bottommenu = bottomAppBar.getMenu();

     //   bottomtext = bottommenu.findItem(R.id.bottomtt);

      //  mSwipeRefreshLayout = findViewById(R.id.swiperefresh_items);

      //  excel = findViewById(R.id.excel);



        noofitem  = findViewById(R.id.noofitem);
        layoutspinner = findViewById(R.id.layoutspinner);
       customer  = findViewById(R.id.type);

        creationb =  findViewById(R.id.creationb);
        updatedb =  findViewById(R.id.updatedb);

        layoutname = findViewById(R.id.layoutname);
        layoutphone = findViewById(R.id.layoutphone);
        layoutaddress = findViewById(R.id.layoutaddress);
        layoutamount = findViewById(R.id.layoutamount);
        layoutdescription = findViewById(R.id.layoutdescription);
        layoutpaynow = findViewById(R.id.layoutpaynow);
        layoutreference = findViewById(R.id.layoutreference);
        layoutbill = findViewById(R.id.layoutbill);

        cardView2 = findViewById(R.id.card2);
        cardView3 = findViewById(R.id.card3);
        cardView4 = findViewById(R.id.card4);
        horizontal = findViewById(R.id.horizontal);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView2 = findViewById(R.id.nav_view2);

        hview = navigationView2.getHeaderView(0);

        headername1 = (TextView)hview.findViewById(R.id.headername);
        headeremail1 = (TextView)hview.findViewById(R.id.headeremail);

        toolbar = findViewById(R.id.toolbar2);

        left_menu = (AppCompatImageButton) findViewById(R.id.right_menu);
        right_menu = (AppCompatImageButton) findViewById(R.id.left_menu);

        drawertext = (TextView) findViewById(R.id.drawertext);

       // searchedit =  findViewById(R.id.searchedit);
        //hooks end

        noitem = (LinearLayout) findViewById(R.id.noitem);



        txttotall = (TextView) findViewById(R.id.txttotal);
        txtpaid = (TextView) findViewById(R.id.txtpaid);
        txtremain = (TextView) findViewById(R.id.txtremain);

        editTextHeroId = (TextView) findViewById(R.id.editTextHeroId);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        bill = (EditText) findViewById(R.id.bill);

        creation = (TextView) findViewById(R.id.creation);
        textView = (TextView) findViewById(R.id.textView);

        description = (EditText) findViewById(R.id.description);
      //  type = (Spinner) findViewById(R.id.type);
        reference = (EditText) findViewById(R.id.reference);
        amount = (EditText) findViewById(R.id.amount);
        payed = (TextView) findViewById(R.id.payed);
        updated = (TextView) findViewById(R.id.updated);

        paynow = (EditText) findViewById(R.id.paynow);
        remain = (TextView) findViewById(R.id.remain);
      //  textViewUpdate = (AppCompatImageButton) findViewById(R.id.textViewUpdate);

         renew = (AppCompatImageButton) findViewById(R.id.renew);
       // textViewDelete = (AppCompatImageButton) findViewById(R.id.textViewDelete);
       //  paynow5 = (TextView) findViewById(R.id.textView16);
        buttonAddUpdate = (Button) findViewById(R.id.buttonAddUpdate);
        cancel = (Button) findViewById(R.id.cancel);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        expand1 = (AppCompatImageButton) findViewById(R.id.expand);
       // listView = (ListView) findViewById(R.id.listViewHeroes);

       // listView2 = (ListView) findViewById(R.id.listViewHeroes2);

        linearLayout = (ScrollView) findViewById(R.id.linearLayout);

        hidden = (LinearLayout) findViewById(R.id.hidden1);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        heroList = new ArrayList<>();

        //getting the recyclerview from xml
        recyclerView = findViewById(R.id.listViewHeroes);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


       // heroList2 = new ArrayList<>();

        //final Calendar myCalendar = Calendar.getInstance();
          setSupportActionBar(toolbar);
          setsearchtoolbar();
        navigationView.bringToFront();
        navigationView2.bringToFront();

        menuep = navigationView2.getMenu();

        itemp = menuep.findItem(R.id.item2);
        iteme = menuep.findItem(R.id.item3);


        //  ActionBarDrawerToggle toggle = new
        //        ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
       // drawerLayout.addDrawerListener(toggle);
       // toggle.syncState();
       getSupportActionBar().setDisplayShowHomeEnabled(true);
        ActionBarDrawerToggle mdrawertoggle = null;
        drawerLayout.addDrawerListener(mdrawertoggle);
        left_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawerLayout.isDrawerOpen(navigationView)){
                    drawerLayout.closeDrawer(navigationView);
                }
              else if(!drawerLayout.isDrawerOpen(navigationView)){
                    drawerLayout.openDrawer(navigationView);
                }
                if(drawerLayout.isDrawerOpen(navigationView2)){
                    drawerLayout.closeDrawer(navigationView2);
                }
            }
        });
        right_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawerLayout.isDrawerOpen(navigationView2)){
                    drawerLayout.closeDrawer(navigationView2);
                }
                else if(!drawerLayout.isDrawerOpen(navigationView2)){
                    drawerLayout.openDrawer(navigationView2);
                }
                if(drawerLayout.isDrawerOpen(navigationView)){
                    drawerLayout.closeDrawer(navigationView);
                }
            }
        });


        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        creationb.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 //creation.setText(getdate());
                 DatePickerDialog datePickerDialog = new DatePickerDialog(crud.this, new DatePickerDialog.OnDateSetListener() {

                     @Override
                     public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                         //bill.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));
                         month = month+1;
                         String month2 = null;
                         String day2 = null;
                         switch (month){
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
                       //  if(month<10){month2 = "0"+month;}else {month2 = String.valueOf(month);}
                         if(dayOfMonth<10){day2 = "0"+dayOfMonth;}else {day2 = String.valueOf(dayOfMonth);}
                        String date = day2+"-"+month2+"-"+year;
                         creation.setText(date);
                     }
                 }, year,month,day);
                 datePickerDialog.show();



             }

        });

        updatedb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //creation.setText(getdate());
                DatePickerDialog datePickerDialog = new DatePickerDialog(crud.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        //bill.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));
                        month = month+1;
                        String month2 = null;
                        String day2 = null;
                        switch (month){
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
                       // if(month<10){month2 = "0"+month;}else {month2 = String.valueOf(month);}
                        if(dayOfMonth<10){day2 = "0"+dayOfMonth;}else {day2 = String.valueOf(dayOfMonth);}
                        String date = day2+"-"+month2+"-"+year;
                        updated.setText(date);
                    }
                }, year,month,day);
                datePickerDialog.show();



            }

        });





        buttonAddUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isUpdating) {
                   // addNumbers();

                   payed.setText(payed2());
                    updateHero();


                } else {
                  //  payed.setText(payed2());
                    createHero(3,"0");
                  //  drawertext.setText("All Bills");

                    navigationView.setCheckedItem(R.id.item2);
                }
            }
        });



        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                system = false;
                horizontal.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.VISIBLE);
                alpha2("gone");
                alpha("visible");


                floatingActionButton.setVisibility(View.VISIBLE);
                bottomAppBar.setVisibility(View.VISIBLE);
                iteme.setVisible(true);
                itemp.setVisible(true);
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                drawertext.setText(dd);
                paynow.setVisibility(View.VISIBLE);

              //  paynow5.setVisibility(View.VISIBLE);

                left_menu.setVisibility(View.VISIBLE);

                Mymenu.findItem(R.id.actionSearch).setVisible(true);
                final Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        system = true;
                    }
                },1000);


            }
        });

        renew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                payed.setText(Integer.toString(0));

            }
        });


//
//        searchedit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                drawertext.setText("");
//                searchedit.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
//
//            }
//        });

//        searchedit.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//            //    drawertext.setText("");
//
//               // searchedit.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
//              //  sc=1;
//              //  adapter.getFilter().filter(s);
//
//            }
//
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });


        amount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                remain.setText(addNumbers());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                remain.setText(addNumbers());

            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        payed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                remain.setText(addNumbers());


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                remain.setText(addNumbers());
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        paynow.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
             // HeroAdapter.filter(s);

               // HeroAdapter todoAdapter = new HeroAdapter();
              //  HeaderViewListAdapter.getFilter().filter(s);
                 // .this.adapter.getFilter().filter(s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                remain.setText(addNumbers2());

            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editTextName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // textView.setText(getl());
                textView.setText(getl());

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textView.setText(getl());

            }


            @Override
            public void afterTextChanged(Editable s) {
                textView.setText(getl());

            }
        });


/*
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                createHero(2,"0");
            }
        });


 */

        floatingActionButton.setOnClickListener(new View.OnClickListener(){

            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {
               if(system) {

                  // bottomAppBar.setCollapsible(true);
                  // bottomAppBar.collapseActionView();

                    // Mymenu.findItem(R.id.actionSearch).setEnabled(false);

                     Mymenu.findItem(R.id.actionSearch).setVisible(false);
                   bottomAppBar.setVisibility(GONE);

                   Mymenu.findItem(R.id.actionSearch).collapseActionView();
                   Mymenu.findItem(R.id.actionSearch).setTitle("");

                   noitem.setVisibility(View.GONE);

                left_menu.setVisibility(View.GONE);
                //  navigationView.setVisibility(view.GONE);
                //recyclerview and horizontal anim


                   renew.setVisibility(View.VISIBLE);


                   layoutname.setEndIconMode(TextInputLayout.END_ICON_CLEAR_TEXT);
                   layoutphone.setEndIconMode(TextInputLayout.END_ICON_CLEAR_TEXT);
                   layoutaddress.setEndIconMode(TextInputLayout.END_ICON_CLEAR_TEXT);
                   layoutbill.setEndIconMode(TextInputLayout.END_ICON_CLEAR_TEXT);
                   layoutdescription.setEndIconMode(TextInputLayout.END_ICON_CLEAR_TEXT);
                   layoutreference.setEndIconMode(TextInputLayout.END_ICON_CLEAR_TEXT);
                   layoutamount.setEndIconMode(TextInputLayout.END_ICON_CLEAR_TEXT);



                //   layoutname.setEndIconActivated(true);
                //   layoutname.setEndIconVisible(true);

                   layoutpaynow.setVisibility(GONE);
                   updatedb.setVisibility(View.VISIBLE);
                   creationb.setVisibility(View.VISIBLE);



                   alpha("gone");

                linearLayout.setVisibility(View.VISIBLE);
                alpha2("visible");


                floatingActionButton.setVisibility(View.GONE);

                   iteme.setVisible(false);
                   itemp.setVisible(false);

                buttonAddUpdate.setText("Add");
                editTextHeroId.setText("Given Automatically");
                editTextName.setText("");
                editTextPhone.setText("");
                editTextAddress.setText("");
                bill.setText("");

                Date c = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyy", Locale.getDefault());
                String formattedDate = df.format(c);
                creation.setText(formattedDate);
                updated.setText(formattedDate);

                description.setText("");
                 customer.setText("");

               // type.setSelection(0);
                reference.setText("");
                amount.setText(Integer.toString(0));

                payed.setText(Integer.toString(0));
/*
                long millis=System.currentTimeMillis();
                java.sql.Date date=new java.sql.Date(millis);
                String updated2 = String.valueOf(date);
                updated2
 */
                // updated.setText(getdate());

                paynow.setText(Integer.toString(0));
                remain.setText(Integer.toString(0));

                //  payed.setVisibility(View.GONE);
                //  remain.setVisibility(View.GONE);
                isUpdating = false;

                paynow.setVisibility(View.GONE);

              //  paynow5.setVisibility(View.GONE);

                //enable

                enable(editTextName);
                enable(editTextPhone);
                enable(editTextAddress);
                enable(bill);
                enable1(creation);
                enable(description);
                enable2(customer);
                enable(reference);
                enable(amount);
                enable1(payed);
                enable(paynow);
                enable1(remain);
                enable1(updated);
                enable3(renew);
                buttonAddUpdate.setVisibility(View.VISIBLE);
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                drawertext.setText("Add Bill");
             //   Mymenu.findItem(R.id.actionSearch).setVisible(false);
                //   linearLayout.setVisibility(View.VISIBLE);



                //  searchItem.setVisible(false);


            }
            }
        });
        createHero(2,"0");

        initNavigationDrawer();

        initNavigationDrawer2();

        navigationView.setCheckedItem(R.id.item2);

        drawertext.setText("All Bills");

        Menu menu1 = navigationView.getMenu();

        MenuItem item2 = menu1.findItem(R.id.item2);
        item2.setTitle("All Bills");




        layoutname.setEndIconMode(TextInputLayout.END_ICON_NONE);
        layoutphone.setEndIconMode(TextInputLayout.END_ICON_NONE);
        layoutaddress.setEndIconMode(TextInputLayout.END_ICON_NONE);
        layoutbill.setEndIconMode(TextInputLayout.END_ICON_NONE);
        layoutdescription.setEndIconMode(TextInputLayout.END_ICON_NONE);
        layoutreference.setEndIconMode(TextInputLayout.END_ICON_NONE);
        layoutamount.setEndIconMode(TextInputLayout.END_ICON_NONE);



       user user = SharedPrefManager.getInstance(this).getUser();

       headeremail1.setText(user.getEmail());

        headername1.setText(user.getUsername());


        ////create directory///
        if (filePath3.exists()) { } else { filePath3.mkdirs(); }
        if (filePath5.exists()) { } else { filePath5.mkdirs(); }

        //initui();


      //  navigationView.setCheckedItem(R.id.item2);

      ///  count(txttotall,2000);



      //  bottomtext.setTitle(Integer.toString(heroList.size()));
     //   SpannableString sd = new SpannableString(bottomtext.getTitle());
     //   sd.setSpan(new ForegroundColorSpan(Color.RED),0, sd.length(),0);
      //  bottomtext.setTitle(sd);

        ArrayList<String>  customlist = getcustomlist();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(crud.this, android.R.layout.simple_spinner_item, customlist);
        customer.setAdapter(adapter);

    }

    private void setsearchtoolbar() {
        //com.google.android.material.appbar.AppBarLayout
        searchtoolbar = findViewById(R.id.searchtoolbar);
        if(searchtoolbar != null){
            searchtoolbar.inflateMenu(R.menu.header_menu);
            searchmenu=searchtoolbar.getMenu();

            searchtoolbar.setNavigationOnClickListener(v -> {
              //  toolbar.setVisibility(View.VISIBLE);
             //  searchtoolbar.setVisibility(View.INVISIBLE);
             circleReveal(R.id.searchtoolbar,1,true,false);
              //  bottomAppBar.setVisibility(View.VISIBLE);
            });

            itemsearch = searchmenu.findItem(R.id.actionSearch);

            MenuItemCompat.setOnActionExpandListener(itemsearch, new MenuItemCompat.OnActionExpandListener() {
                @Override
                public boolean onMenuItemActionExpand(MenuItem item) {


                    return true;
                }

                @Override
                public boolean onMenuItemActionCollapse(MenuItem item) {
                    circleReveal(R.id.searchtoolbar,1,true,false);
                  //  bottomAppBar.setVisibility(View.VISIBLE);
                  //  toolbar.setVisibility(View.VISIBLE);
                   // searchtoolbar.setVisibility(GONE);
                    return true;
                }
            });

           // initSearchview();



        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.actionSearch){

            circleReveal(R.id.searchtoolbar,1,true,true);
            bottomAppBar.setVisibility(GONE);
        }

        return true;
    }


    private void circleReveal(int viewid, int posright, boolean constrain, final boolean isshow) {
        final  View myview = findViewById(viewid);
        int width= myview.getWidth();

        if(posright>0) {
            width -= (posright * 48)-(48 / 2);
        }
            if(constrain){
                width-=36;
            }


            int cx=width;
            int cy=myview.getHeight()/2;

            Animator anim;
            if(isshow){
                anim= ViewAnimationUtils.createCircularReveal(myview,cx,cy,0,(float)width);

            }else {
                anim= ViewAnimationUtils.createCircularReveal(myview,cx,cy,(float)width,0);
            }

            anim.setDuration((long)220);

            anim.addListener(new AnimatorListenerAdapter() {

                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    myview.setVisibility(GONE);
                }
            });

            if(isshow){
                myview.setVisibility(View.VISIBLE);
            }
            anim.start();


    }


    private ArrayList<String> getcustomlist() {

        ArrayList<String> customers = new ArrayList<>();
        customers.add("cash");
        customers.add("cheque");
        customers.add("rtgs");
        return customers;
    }

    ///excel////





    public void count(TextView txtvar,int txtvarval){





    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            //stat
            ValueAnimator valueAnim = ValueAnimator.ofInt(0, txtvarval );
            valueAnim.setDuration(1000);
           // valueAnim.setStartDelay(500);
            valueAnim.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    // int val = (int) animation.getAnimatedValue();
                    txtvar.setText("₹"+valueAnim.getAnimatedValue().toString());

                }
            });

            valueAnim.start();
           //end
        }
    });



}

public  void alpha(String visibility){
    int alphas,alphae,delay,dur;
    if(visibility=="gone"){
        alphas =1;
        alphae = 0;
        delay = 0;
        dur = 200;
    }else{
        alphas =0;
        alphae = 1;
        delay= 0;
        dur = 500;

    }
        ObjectAnimator fadeAltAnim2 = ObjectAnimator.ofFloat(horizontal, View.ALPHA, alphas, alphae);
        fadeAltAnim2.setDuration(dur);
        fadeAltAnim2.setStartDelay(delay);
        fadeAltAnim2.start();

    }

    public  int getheight(){

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        return height;
    }

 public void alpha2(String visiblity){

     int heights,heighte,alphas,alphae,vv,delay,dur;
     View layout,layout2;
        if(visiblity=="gone"){
            vv = View.GONE;
            heights = 0;
            heighte =getheight();
            alphas =1;
            alphae = 0;
            layout = linearLayout;

            layout2 = linearLayout;
            delay = 0;
            dur = 300;
        }else{
            vv = View.GONE;
            heights = getheight();
            heighte =0;
            alphas =0;
            alphae = 1;

            layout = horizontal;layout2=recyclerView;
            delay = 0;
            dur = 600;
        }
        ObjectAnimator fadeAltAnim = ObjectAnimator.ofFloat(linearLayout, TRANSLATION_Y, heights, heighte);

        ObjectAnimator fadeAltAnim3 = ObjectAnimator.ofFloat(linearLayout, View.ALPHA, alphas, alphae);

        fadeAltAnim.setDuration(dur);
        fadeAltAnim.setStartDelay(delay);

        fadeAltAnim3.setStartDelay(delay);
        fadeAltAnim3.setDuration(dur+100);

     AnimatorSet set2 = new AnimatorSet();

            set2.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {

                    layout.setVisibility(vv);
                    layout2.setVisibility(vv);
                    back = true;
                    cancel.setVisibility(View.VISIBLE);

                }
                @Override
                public void onAnimationStart(Animator animation){
                    back = false;
                    cancel.setVisibility(GONE);
                   system=false;

                }
            });


        set2.playTogether(fadeAltAnim,fadeAltAnim3 );
        set2.start();
    }



/*
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.item1: Toast.makeText(this, "item1", Toast.LENGTH_SHORT).show(); break;
        }
        drawerLayout.closeDrawer(GravityCompat.START); return true;
    }

 */


//filteer lliist//
public  void initNavigationDrawer(){
    navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
            int id = menuitem.getItemId();
            switch (id){

                case R.id.item4:
                    filteredList2.removeAll(filteredList2);
                    sc=0;
                    Date c = Calendar.getInstance().getTime();
                    SimpleDateFormat df = new SimpleDateFormat("MMM-yyy", Locale.getDefault());
                    String formattedDate = df.format(c);

                    adapter.getFilter().filter(formattedDate);
                    drawertext.setText(formattedDate+" Bills");
                    dd = formattedDate+" Bills";
                    Toast.makeText(getApplicationContext(), formattedDate, Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawers();
                break;

                case R.id.item2:

                    if(xx) {

                        filteredList2.removeAll(filteredList2);

                        TotalAmount=0;
                        TotalPayed=0;
                        TotalRemain=0;
                        createHero(2, "0");

                        drawertext.setText("All Bills");
                        dd= "All Bills";

                     //   noofitem.setText(Integer.toString(heroList.size())+" Bills");
                        Toast.makeText(getApplicationContext(), "All Bills", Toast.LENGTH_SHORT).show();
                    } else{

                        filteredList2.removeAll(filteredList2);

                        TotalAmount=0;
                        TotalPayed=0;
                        TotalRemain=0;
                        createHero(1, pidf);

                        drawertext.setText("Transactions");

                   //     noofitem.setText(Integer.toString(heroList.size())+" Bills");
                        Toast.makeText(getApplicationContext(), "Transactions", Toast.LENGTH_SHORT).show();

                    }
                    drawerLayout.closeDrawers();
                    break;



                case R.id.item3:

                    filteredList2.removeAll(filteredList2);
                    sc=0;
                    Date cc = Calendar.getInstance().getTime();
                    SimpleDateFormat dfc = new SimpleDateFormat("dd-MMM-yyy", Locale.getDefault());
                    String formattedDatec = dfc.format(cc);

                    adapter.getFilter().filter(formattedDatec);

                    drawertext.setText(formattedDatec);
                    dd = formattedDatec;

                //    noofitem.setText(Integer.toString(heroList.size())+" Bills");
                    Toast.makeText(getApplicationContext(), formattedDatec, Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawers();
                    break;

                case R.id.item5:

                    filteredList2.removeAll(filteredList2);
                    sc=0;
                    Date cy = Calendar.getInstance().getTime();
                    SimpleDateFormat dfy = new SimpleDateFormat("yyy", Locale.getDefault());
                    String formattedDatey = dfy.format(cy);

                    adapter.getFilter().filter(formattedDatey);

                    drawertext.setText(formattedDatey+" Bills");
                    dd = formattedDatey+" Bills";

                //    noofitem.setText(Integer.toString(heroList.size())+" Bills");
                    Toast.makeText(getApplicationContext(), formattedDatey, Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawers();
                    break;
                case R.id.item6:

                    filteredList2.removeAll(filteredList2);
                    sc=0;
                    ///////start//////
                            DatePickerDialog datePickerDialog = new DatePickerDialog(crud.this, new DatePickerDialog.OnDateSetListener() {

                                @Override
                                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                    //bill.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));
                                    month = month+1;
                                    String month2 = null;
                                    String day2 = null;
                                    switch (month){
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
                                    //  if(month<10){month2 = "0"+month;}else {month2 = String.valueOf(month);}
                                    if(dayOfMonth<10){day2 = "0"+dayOfMonth;}else {day2 = String.valueOf(dayOfMonth);}
                                    String date = day2+"-"+month2+"-"+year;

                                    adapter.getFilter().filter(date);

                                    drawertext.setText(date);
                                    dd = date;

                              //      noofitem.setText(Integer.toString(heroList.size())+" Bills");
                                    Toast.makeText(getApplicationContext(), date, Toast.LENGTH_SHORT).show();
                                    drawerLayout.closeDrawers();

                                }
                            }, year,month,day);
                            datePickerDialog.show();




                ///////end////
                    break;
                    case R.id.item7:

                        filteredList2.removeAll(filteredList2);
                        sc=0;

                        //start

                        MonthPickerDialog.Builder builder = new MonthPickerDialog.Builder(crud.this,
                                new MonthPickerDialog.OnDateSetListener() {
                                    @Override
                                    public void onDateSet(int selectedMonth, int selectedYear) {

                                        String month2 = null;

                                        switch (selectedMonth+1){
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
                                          adapter.getFilter().filter(month2);

                                        drawertext.setText(month2+" Bills");
                                        dd = month2+" Bills";

                                      //  noofitem.setText(Integer.toString(heroList.size())+" Bills");
                                        Toast.makeText(getApplicationContext(), month2, Toast.LENGTH_SHORT).show();
                                          drawerLayout.closeDrawers();

                                    }
                                    }, year,month);

                        builder.setActivatedMonth(month)
                                          //  .setMinYear(1990)
                                   // .setActivatedYear(2021)
                               // .setMaxYear(2030)
                               // .setMinMonth(Calendar.JANUARY)
                                  .setTitle("Select  Month")
                                   .setMonthRange(Calendar.JANUARY, Calendar.DECEMBER)
                                     .setMaxMonth(Calendar.DECEMBER)
                                   //  .setYearRange(1990, 2030)
                                   //  .setMonthAndYearRange(Calendar.JANUARY, Calendar.DECEMBER, 1990, 2030)
                                    .showMonthOnly()
                                   //  .showYearOnly()
       .setOnMonthChangedListener(new MonthPickerDialog.OnMonthChangedListener() {
                                        @Override
                                        public void onMonthChanged(int selectedMonth) {

                                        } })
       .setOnYearChangedListener(new MonthPickerDialog.OnYearChangedListener() {
                                                @Override
                                                public void onYearChanged(int selectedYear) {   } })
        .build()
                                                            .show();

                        //end
                break;
                case R.id.item8:

                    filteredList2.removeAll(filteredList2);
                    sc=0;

                    //start

                    MonthPickerDialog.Builder builder2 = new MonthPickerDialog.Builder(crud.this,
                            new MonthPickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(int selectedMonth, int selectedYear) {

                                    adapter.getFilter().filter(Integer.toString(selectedYear));

                                    drawertext.setText(selectedYear+" Bills");
                                    dd = selectedYear+" Bills";

                                 //   noofitem.setText(Integer.toString(heroList.size())+" Bills");
                                    Toast.makeText(getApplicationContext(), Integer.toString(selectedYear), Toast.LENGTH_SHORT).show();
                                    drawerLayout.closeDrawers();

                                }
                            }, year,month);

                    builder2.setActivatedMonth(month)
                              .setMinYear(1990)
                             .setActivatedYear(year)
                             .setMaxYear(year+10)
                            // .setMinMonth(Calendar.JANUARY)
                            .setTitle("Select Year")
                            .setMonthRange(Calendar.JANUARY, Calendar.DECEMBER)
                            .setMaxMonth(Calendar.DECEMBER)
                              .setYearRange(1990, year+10)
                            //  .setMonthAndYearRange(Calendar.JANUARY, Calendar.DECEMBER, 1990, 2030)
                            //.showMonthOnly()
                             .showYearOnly()
                            .setOnMonthChangedListener(new MonthPickerDialog.OnMonthChangedListener() {
                                @Override
                                public void onMonthChanged(int selectedMonth) {

                                } })
                            .setOnYearChangedListener(new MonthPickerDialog.OnYearChangedListener() {
                                @Override
                                public void onYearChanged(int selectedYear) {   } })
                            .build()
                            .show();

                    //end
                    break;

                case R.id.item9:

                    filteredList2.removeAll(filteredList2);
                    sc=0;

                    //start

                    MonthPickerDialog.Builder builder3 = new MonthPickerDialog.Builder(crud.this,
                            new MonthPickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(int selectedMonth, int selectedYear) {
                                    String month2 = null;

                                    switch (selectedMonth+1){
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

                                    adapter.getFilter().filter(month2+"-"+ Integer.toString(selectedYear));

                                    drawertext.setText(month2+" - "+selectedYear);
                                    dd = month2+" - "+selectedYear;

                                 //   noofitem.setText(Integer.toString(heroList.size())+" Bills");
                                    Toast.makeText(getApplicationContext(), month2+"-"+ Integer.toString(selectedYear), Toast.LENGTH_SHORT).show();
                                    drawerLayout.closeDrawers();

                                }
                            }, year,month);

                    builder3.setActivatedMonth(month)
                            .setMinYear(1947)
                            .setActivatedYear(year)
                            .setMaxYear(year+10)
                             .setMinMonth(Calendar.JANUARY)
                            .setTitle("Select Month & Year")
                             .setMonthRange(Calendar.JANUARY, Calendar.DECEMBER)
                              .setMaxMonth(Calendar.DECEMBER)
                            .setYearRange(1947, year+10)
                              .setMonthAndYearRange(Calendar.JANUARY, Calendar.DECEMBER, 1947, year+10)
                            // .showMonthOnly()
                            //.showYearOnly()
                            .setOnMonthChangedListener(new MonthPickerDialog.OnMonthChangedListener() {
                                @Override
                                public void onMonthChanged(int selectedMonth) {

                                } })
                            .setOnYearChangedListener(new MonthPickerDialog.OnYearChangedListener() {
                                @Override
                                public void onYearChanged(int selectedYear) {   } })
                            .build()
                            .show();

                    //end
                    break;

            }
            return true;
        }
    });
}
    public  void initNavigationDrawer2(){
        navigationView2.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                int id = menuitem.getItemId();
                switch (id){

                    case R.id.item1:
                        finish();
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                       // Toast.makeText(getApplicationContext(), formattedDate, Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.item2:
                        //pdf start

                        if(heroList.size()==0){ } else {
                   if(xx==true){
                            /*
                            PdfDocument mypdf = new PdfDocument();
                            Paint mypaint = new Paint();

                            PdfDocument.PageInfo mypageinfo = new PdfDocument.PageInfo.Builder(792, 1120, 1).create();
                            PdfDocument.Page mypage = mypdf.startPage(mypageinfo);
                            Canvas canvas = mypage.getCanvas();


                            ///canvas start////
                            // mypaint.setTextSize(50);
                            // canvas.drawText("Dukandaar Bill Book",30,80,mypaint);


                            mypaint.setFakeBoldText(true);
                            mypaint.setTextAlign(Paint.Align.CENTER);
                            mypaint.setTextSize(30);
                            canvas.drawText(String.valueOf(headername1.getText()), canvas.getWidth() / 2, 80, mypaint);

                            mypaint.setTextSize(25);
                            canvas.drawText(String.valueOf(headeremail1.getText()), canvas.getWidth() / 2, 120, mypaint);

                            mypaint.setColor(Color.rgb(150, 150, 150));
                            canvas.drawRect(30, 150, canvas.getWidth() - 30, 160, mypaint);


                            mypaint.setColor(Color.BLACK);
                            canvas.drawText("Date", 50, 200, mypaint);
                            canvas.drawText(String.valueOf(drawertext.getText()), 250, 200, mypaint);


                            mypaint.setUnderlineText(true);
                            mypaint.setTextSize(40);

                            canvas.drawText("Report", canvas.getWidth() / 2, 250, mypaint);

                            mypaint.setUnderlineText(false);
                            mypaint.setTextSize(25);
                            mypaint.setColor(Color.rgb(211, 211, 211));

                            mypaint.setTextAlign(Paint.Align.LEFT);
                            canvas.drawRect(20, 300, canvas.getWidth() - 20, 350, mypaint);

                            mypaint.setColor(Color.BLACK);

                             */


                            //using add method in document to insert a paragraph


                            final File[] filePathpdf = {new File(Environment.getExternalStorageDirectory() + "/Dukandaar/Pdf/Dukandaar " + drawertext.getText() + ".pdf")};
                            // final int[] pp = {0};
                            //final String[] message = {"file created"};
                            //start//
                            if (filePathpdf[0].exists()) {

                                AlertDialog.Builder builder = new AlertDialog.Builder(crud.this);

                                // Set a title for alert dialog
                                builder.setTitle("File with this Name already Exist");

                                // Ask the final question
                                builder.setMessage("Do you want to overwrite this file or create New ?");

                                // Set the alert dialog yes button click listener
                                builder.setPositiveButton("Overwrite file", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        String message = "file Overwrite";
                                        createpdf(filePathpdf[0], message);

                                    }
                                });

                                // Set the alert dialog no button click listener
                                builder.setNegativeButton("Create New", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // Do something when No button clicked
                                        filePathpdf[0] = new File(Environment.getExternalStorageDirectory() + "/Dukandaar/Pdf/Dukandaar " + drawertext.getText() + " " + System.currentTimeMillis() + ".pdf");

                                        String message = "file writen";
                                        createpdf(filePathpdf[0], message);

                                    }
                                });

                                AlertDialog dialog = builder.create();
                                // Display the alert dialog on interface
                                dialog.show();
                            }


                            ////end dialogue///
                            if (!filePathpdf[0].exists()) {

                                String message = "New file created";
                                createpdf(filePathpdf[0], message);

                            }
                            //end//


                            //pdf end///

                        }
                        }
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.item3:


                        if(heroList.size()==0){ } else {
                            if (xx==true) {
                                File filePath = new File(Environment.getExternalStorageDirectory() + "/Dukandaar/Excel/Dukandaar " + drawertext.getText() + ".xls");


                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {


                                        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
                                        HSSFSheet hssfSheet = hssfWorkbook.createSheet(String.valueOf(drawertext.getText()));

                                        HSSFRow hssfRow;
                                        hssfRow = hssfSheet.createRow(0);


                                        HSSFCell cell1 = hssfRow.createCell(0);
                                        cell1.setCellValue("Date");

                                        hssfRow.createCell(1).setCellValue("Bill No.");
                                        hssfRow.createCell(2).setCellValue("Name");
                                        hssfRow.createCell(3).setCellValue("Phone");
                                        hssfRow.createCell(4).setCellValue("Product");
                                        hssfRow.createCell(5).setCellValue("Payment");
                                        hssfRow.createCell(6).setCellValue("Amount");
                                        hssfRow.createCell(7).setCellValue("Payed");
                                        hssfRow.createCell(8).setCellValue("Remaining");


                                        hssfSheet.setColumnWidth(0, 3000);
                                        hssfSheet.setColumnWidth(1, 3000);
                                        hssfSheet.setColumnWidth(2, 5000);
                                        hssfSheet.setColumnWidth(3, 3000);
                                        hssfSheet.setColumnWidth(4, 5000);
                                        hssfSheet.setColumnWidth(5, 3000);
                                        hssfSheet.setColumnWidth(6, 3000);
                                        hssfSheet.setColumnWidth(7, 3000);
                                        hssfSheet.setColumnWidth(8, 3000);


                                        HSSFRow row;

                                        int tt = 0, tt2 = 0;
                                        for (int rowNum = 1; rowNum < heroList.size() + 1; rowNum++) {

                                            row = hssfSheet.createRow(rowNum);


                                            row.createCell(0).setCellValue(heroList.get(rowNum - 1).getcreation());

                                            row.createCell(1).setCellValue(heroList.get(rowNum - 1).getbill());

                                            row.createCell(2).setCellValue(heroList.get(rowNum - 1).getName());
                                            row.createCell(3).setCellValue(heroList.get(rowNum - 1).getPhone());

                                            row.createCell(4).setCellValue(heroList.get(rowNum - 1).getdescription());
                                            row.createCell(5).setCellValue(heroList.get(rowNum - 1).gettype());
                                            row.createCell(6).setCellValue(heroList.get(rowNum - 1).getamount());
                                            row.createCell(7).setCellValue(heroList.get(rowNum - 1).getpayed());
                                            int am = Integer.parseInt(heroList.get(rowNum - 1).getamount());
                                            int py = Integer.parseInt(heroList.get(rowNum - 1).getpayed());
                                            int re = am - py;
                                            row.createCell(8).setCellValue(Integer.toString(re));

                                            tt = tt + am;
                                            tt2 = tt2 + py;

                                            // String remain = Integer.toString(re);

                                            // hssfSheet.setColumnWidth(0, 1000);


                                        }

                                        // hssfSheet.autoSizeColumn(2);

                                        HSSFRow hssfRowf;
                                        hssfRowf = hssfSheet.createRow(heroList.size() + 1);


                                        hssfRowf.createCell(5).setCellValue("Total");

                                        hssfRowf.createCell(6).setCellValue(Integer.toString(tt));
                                        hssfRowf.createCell(7).setCellValue(Integer.toString(tt2));
                                        hssfRowf.createCell(8).setCellValue(Integer.toString(tt - tt2));


                                        try {
                                            ////start dialogue///

                                            if (filePath.exists()) {

                                                AlertDialog.Builder builder = new AlertDialog.Builder(crud.this);

                                                // Set a title for alert dialog
                                                builder.setTitle("File with this Name already Exist");

                                                // Ask the final question
                                                builder.setMessage("Do you want to overwrite this file or create New ?");

                                                // Set the alert dialog yes button click listener
                                                builder.setPositiveButton("Overwrite file", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        // Do something when user clicked the Yes button

                                                        try {
                                                            filePath.delete();
                                                            filePath.createNewFile();
                                                            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                                                            hssfWorkbook.write(fileOutputStream);

                                                            Toast.makeText(getApplicationContext(), "file Overwrite", Toast.LENGTH_SHORT).show();
                                                            Toast.makeText(getApplicationContext(), Environment.getExternalStorageDirectory() + "/Dukandaar/Excel/", Toast.LENGTH_SHORT).show();


                                                            if (fileOutputStream != null) {
                                                                fileOutputStream.flush();
                                                                fileOutputStream.close();
                                                            }
                                                        } catch (IOException e) {
                                                            e.printStackTrace();
                                                        }
                                                    }
                                                });

                                                // Set the alert dialog no button click listener
                                                builder.setNegativeButton("Create New", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        // Do something when No button clicked
                                                        try {
                                                            File filePath2 = new File(Environment.getExternalStorageDirectory() + "/Dukandaar/Excel/Dukandaar " + drawertext.getText() + " " + System.currentTimeMillis() + ".xls");
                                                            FileOutputStream fileOutputStream = new FileOutputStream(filePath2);
                                                            hssfWorkbook.write(fileOutputStream);

                                                            Toast.makeText(getApplicationContext(), "file wrriten", Toast.LENGTH_SHORT).show();
                                                            Toast.makeText(getApplicationContext(), Environment.getExternalStorageDirectory() + "/Dukandaar/Excel/", Toast.LENGTH_SHORT).show();


                                                            if (fileOutputStream != null) {
                                                                fileOutputStream.flush();
                                                                fileOutputStream.close();
                                                            }

                                                        } catch (IOException e) {
                                                            e.printStackTrace();
                                                        }

                                                    }
                                                });

                                                AlertDialog dialog = builder.create();
                                                // Display the alert dialog on interface
                                                dialog.show();
                                            }


                                            ////end dialogue///
                                            if (!filePath.exists()) {
                                                filePath.createNewFile();

                                                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                                                hssfWorkbook.write(fileOutputStream);

                                                Toast.makeText(getApplicationContext(), "New file Created", Toast.LENGTH_SHORT).show();
                                                Toast.makeText(getApplicationContext(), Environment.getExternalStorageDirectory() + "/Dukandaar/Excel/", Toast.LENGTH_SHORT).show();


                                                if (fileOutputStream != null) {
                                                    fileOutputStream.flush();
                                                    fileOutputStream.close();
                                                }
                                            }


                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                    }
                                });
                            }
                        }
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.item4:

                        Intent shareintent = new Intent(Intent.ACTION_SEND);
                        shareintent.setType("text/plain");
                        String body = "Download app now: https://appsenjoy.com/dCHsm \n" +

                                "Dukandaar billing app..\n" +
                                "It manages bills of dukandaar from holesellers ...\n" +
                                "We have to add bill of holeseller ..\n" +
                                "And update paynow when agent of holeseller come to take payment..\n" +
                                "We can give payment in parts..\n" +
                                "And when and how much amount is given to holeseller is stored in transactions of each bills...\n" +
                                "We can export data in form of excel and pdf files...\n" +
                                "We can filter data by date,month and year etc...and also create pdf or excel of each filtering\n"+
                                "we can see the live status of our bills in profile section ... Total amount ,Total Payed and Total Remaning amount of all Bills\n"
                                +"How to use app: https://drive.google.com/file/d/1thKf0zaFsOjZ8llv6Ibjs_1Ahiu_q0D8/view?usp=sharing";
                        String sub="Dukandaar App";

                        shareintent.putExtra(Intent.EXTRA_SUBJECT,sub);
                        shareintent.putExtra(Intent.EXTRA_TEXT,body);

                        startActivity(Intent.createChooser(shareintent,"Share Using"));


                        drawerLayout.closeDrawers();
                        break;



                    case R.id.item5:
//                        Intent shareintent2 = new Intent(Intent.ACTION_SEND);
//                        shareintent2.setType("text/plain");
//                        String body2 = "https://drive.google.com/file/d/1xDq9OeS-R0ZWSQoDLMvkvdwEcL0xMjIC/view?usp=sharing";
//                        String sub2="Dukandaar App";
//
//                        shareintent2.putExtra(Intent.EXTRA_SUBJECT,sub2);
//                        shareintent2.putExtra(Intent.EXTRA_TEXT,body2);
//
//                        startActivity(Intent.createChooser(shareintent2,"Share Using"));
//
                        try {
                            Uri uri = Uri.parse("https://drive.google.com/file/d/1thKf0zaFsOjZ8llv6Ibjs_1Ahiu_q0D8/view?usp=sharing"); // missing 'http://' will cause crashed
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.item6:

                        finish();
                        SharedPrefManager.getInstance(getApplicationContext()).logout();
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        drawerLayout.closeDrawers();
                        break;

                }
                return true;
            }


        });
    }

    private void createpdf(File filePathpdf,String ss) {
        try{


            OutputStream outputStream = new FileOutputStream(filePathpdf);
            PdfWriter writer = new PdfWriter(filePathpdf);

            // Creating a PdfDocument object
            PdfDocument pdfDoc = new PdfDocument(writer);

            // Creating a Document object
            Document doc = new Document(pdfDoc);
            PdfPage pdfPage = pdfDoc.addNewPage();


            Paragraph paragraph1 = new Paragraph(String.valueOf(headername1.getText())).setTextAlignment(TextAlignment.CENTER).setFontSize(30).setBold();
            Paragraph paragraph2 = new Paragraph(String.valueOf(headeremail1.getText())).setTextAlignment(TextAlignment.CENTER).setFontSize(20).setBold();
            Paragraph paragraph3 = new Paragraph("Date :     "+drawertext.getText()+"\n\n").setTextAlignment(TextAlignment.LEFT).setFontSize(18).setBold();
            //Creating a PdfCanvas object
            PdfCanvas canvas = new PdfCanvas(pdfPage);

            // Initial point of the line
            canvas.moveTo(30, 680);

            // Drawing the line
            canvas.lineTo(564, 680);

            // Closing the path stroke
            canvas.closePathStroke();

            Paragraph paragraph4 = new Paragraph("Report \n\n").setTextAlignment(TextAlignment.CENTER).setUnderline().setFontSize(20).setBold();

            // Adding paragraphs to document
            doc.add(paragraph1);
            doc.add(paragraph2);
            doc.add(paragraph3);

            doc.add(paragraph4);


            // Creating a table
            float [] pointColumnWidths = {94,94,94,94,94,94};
            Table table = new Table(pointColumnWidths);

            Border border = new SolidBorder(1);
            border.setColor(new DeviceRgb(211,211,211));

            Border border2 = new SolidBorder(1);
            border2.setColor(new DeviceRgb(255,255,255));


            Border border3 = new SolidBorder(1);
            border3.setColor(new DeviceRgb(128,128,128));

            // Adding row 1 to the table
            table.addCell(new Cell().setBackgroundColor(new DeviceRgb(211,211,211)).setBorder(border).setBorderBottom(border3).add(new Paragraph("Date")).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().setBackgroundColor(new DeviceRgb(211,211,211)).setBorder(border).setBorderBottom(border3).add(new Paragraph("Bill No.")).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().setBackgroundColor(new DeviceRgb(211,211,211)).setBorder(border).setBorderBottom(border3).add(new Paragraph("Name")).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().setBackgroundColor(new DeviceRgb(211,211,211)).setBorder(border).setBorderBottom(border3).add(new Paragraph("Product")).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().setBackgroundColor(new DeviceRgb(211,211,211)).setBorder(border).setBorderBottom(border3).add(new Paragraph("Amount")).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().setBackgroundColor(new DeviceRgb(211,211,211)).setBorder(border).setBorderBottom(border3).add(new Paragraph("Remaining")).setTextAlignment(TextAlignment.CENTER));

            //add row2//
            int tt = 0, tt2 = 0;

            for (int rowNum = 1; rowNum < heroList.size() + 1; rowNum++) {
                table.addCell(new Cell().setBorderLeft(border2).add(new Paragraph(heroList.get(rowNum - 1).getcreation())).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().setBorderLeft(border2).add(new Paragraph(heroList.get(rowNum - 1).getbill())).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().setBorderLeft(border2).add(new Paragraph(heroList.get(rowNum - 1).getName())).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().setBorderLeft(border2).add(new Paragraph(heroList.get(rowNum - 1).getdescription())).setTextAlignment(TextAlignment.CENTER));
                table.addCell(new Cell().setBorderLeft(border2).add(new Paragraph("₹"+heroList.get(rowNum - 1).getamount())).setTextAlignment(TextAlignment.CENTER));

                int am = Integer.parseInt(heroList.get(rowNum - 1).getamount());
                int py = Integer.parseInt(heroList.get(rowNum - 1).getpayed());
                int re = am - py;

                table.addCell(new Cell().setBorderLeft(border2).setBorderRight(border2).add(new Paragraph("₹"+Integer.toString(re))).setTextAlignment(TextAlignment.CENTER));



                tt = tt + am;
                tt2 = tt2 + py;

            }
            table.addCell(new Cell().setBorderLeft(border2).setBorderRight(border2).setBorderBottom(border2).add(new Paragraph("")).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().setBorderLeft(border2).setBorderRight(border2).setBorderBottom(border2).add(new Paragraph("")).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().setBorderLeft(border2).setBorderRight(border2).setBorderBottom(border2).add(new Paragraph("")).setTextAlignment(TextAlignment.CENTER));

            table.addCell(new Cell().setBorderLeft(border2).setBorderBottom(border2).add(new Paragraph("Total")).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().setBorderLeft(border2).setBorderBottom(border2).setBorderRight(border2).add(new Paragraph("₹"+Integer.toString(tt))).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().setBorderLeft(border2).setBorderBottom(border2).setBorderRight(border2).add(new Paragraph("₹"+Integer.toString(tt-tt2))).setTextAlignment(TextAlignment.CENTER));


            // Adding Table to document
            doc.add(table);

            // Closing the document
            doc.close();

            Toast toast = Toast.makeText(getApplicationContext(), ss, Toast.LENGTH_SHORT);
            toast.show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
public void onBackPressed(){
        if(linearLayout.getVisibility()==View.VISIBLE) {
            if(back) {
                system = false;
                horizontal.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.VISIBLE);
                alpha2("gone");
                alpha("visible");


                left_menu.setVisibility(View.VISIBLE);


                drawertext.setText(dd);
                Mymenu.findItem(R.id.actionSearch).setVisible(true);
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);

             //   Mymenu.findItem(R.id.actionSearch).setVisible(true);



                paynow.setVisibility(View.VISIBLE);

              //  paynow5.setVisibility(View.VISIBLE);


                floatingActionButton.setVisibility(View.VISIBLE);
                bottomAppBar.setVisibility(View.VISIBLE);
                iteme.setVisible(true);
                itemp.setVisible(true);

                final Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        system = true;
                    }
                },1000);

            }
        }
        else{
        if(xx == true) {

            noitem.setVisibility(View.GONE);

            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        } else {  xx = true;


            Mymenu.findItem(R.id.actionSearch).setVisible(true);

            filteredList2.removeAll(filteredList2);
           // expand1.setVisibility(View.VISIBLE);
          //  hidden.setVisibility(View.VISIBLE);
            createHero(2,"0");
            Menu menu1 = navigationView.getMenu();

            MenuItem item2 = menu1.findItem(R.id.item2);
            item2.setTitle("All Bills");
            navigationView.setCheckedItem(R.id.item2);


            recyclerView.setVisibility(View.VISIBLE);


            drawertext.setText("All Billls");


            noitem.setVisibility(View.GONE);

            //left_menu.setVisibility(View.VISIBLE);
        }

        }
}

    public void createHero(int pid2,String pid1) {

            String name = editTextName.getText().toString().trim();
            String phone = editTextPhone.getText().toString().trim();
            String address = editTextAddress.getText().toString().trim();

            String bill1 = bill.getText().toString().trim();
            String creation1 = creation.getText().toString().trim();
            String description1 = description.getText().toString().trim();
           // String type1 = type.getText().toString().trim();
        String type1 = customer.getText().toString().trim();

        String reference1 = reference.getText().toString().trim();
            String amount1 = amount.getText().toString().trim();

       // String remain1 = remain.getText().toString().trim();

           String paynow1 = paynow.getText().toString().trim();







            String updated1 = updated.getText().toString().trim();


       /*

            amount.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {



                    }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    remain.setText(addNumbers());

                }


                @Override
                public void afterTextChanged(Editable s) {

                }
            });


        paynow.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {



            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                remain.setText(addNumbers2());

            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });

 */
/*
        remain.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {



            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }


            @Override
            public void afterTextChanged(Editable s) {
                payed.setText(addNumbers3());
            }
        });

 */










            //   if (TextUtils.isEmpty(realname)) {
            //       editTextRealname.setError("Please enter real name");
            //       editTextRealname.requestFocus();
            //        return;
            //    }


            //getting the current user
               String pp2;
               String pp = null;
               String payed1 = null;
        if(linearLayout.getVisibility()==View.GONE) {
            pp2 = Integer.toString(pid2);
            if (pid2 == 1||pid2 == 4) {
                pp = pid1;
                payed1 = paynow1;

            } else if(pid2==2) {
                pp2 = Integer.toString(pid2);
                user user = SharedPrefManager.getInstance(this).getUser();
                int x = user.getId();
                pp = Integer.toString(x);
                payed1 = paynow1;
               // pp = Integer.toString(42);
            }
        } else {
            pp2 = Integer.toString(3);
            user user = SharedPrefManager.getInstance(this).getUser();
            int x = user.getId();
             pp = Integer.toString(x);

             payed1 = String.valueOf(0);



            if (TextUtils.isEmpty(name)) {
               // editTextName.setError();
                layoutname.setError("Please enter name");
                editTextName.requestFocus();

                return;
            }

            if (TextUtils.isEmpty(amount1)) {
               amount1 = Integer.toString(0);
            //    amount.setText(Integer.toString(0));
            }
           dd = "All Bills";
         //  drawertext.setText("All Bills");

            TotalAmount=0;
            TotalPayed=0;
            TotalRemain=0;


        }
            HashMap<String, String> params = new HashMap<>();
            params.put("name", name);
            params.put("phone", phone);
            params.put("address", address);
            params.put("pid", pp);
            params.put("pid2", pp2);
            params.put("bill", bill1);
            params.put("creation", creation1);
            params.put("description", description1);
            params.put("type", type1);
            params.put("reference", reference1);
            params.put("amount", amount1);
            params.put("payed", payed1);
            params.put("updated", updated1);

            PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_CREATE_HERO, params, CODE_POST_REQUEST);
            request.execute();

        editTextName.setText("");
        editTextPhone.setText("");
        editTextAddress.setText("");
        bill.setText("");
       // creation.setText("");
        description.setText("");
        customer.setText("");


        reference.setText("");
      //  amount.setText("");
       // payed.setText("");
     //   updated.setText("");
      //  paynow.setText("");
        //remain.setText("");


        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyy", Locale.getDefault());
        String formattedDate = df.format(c);
        creation.setText(formattedDate);
        updated.setText(formattedDate);

        amount.setText(Integer.toString(0));
        payed.setText(Integer.toString(0));
        paynow.setText(Integer.toString(0));
        remain.setText(Integer.toString(0));


    }

    private String addNumbers() {
        int num1;
        int num2;
        int num5;
        if(!paynow.getText().toString().equals("") && paynow.getText().length()>0){
            num5  = Integer.parseInt(paynow.getText().toString());
        }else{
            num5 = 0;
        }

        if(!amount.getText().toString().equals("") && amount.getText().length()>0){
            num1 = Integer.parseInt(amount.getText().toString());
        }else{
            num1 = 0;
        }
        if(!payed.getText().toString().equals("") && payed.getText().length()>0){
            num2 = Integer.parseInt(payed.getText().toString());
        }else{
            num2 = 0;
        }
        return Integer.toString(num1 - (num2 + num5));
    }



    private String addNumbers2() {
         int num3;
        int num4;
        int num5;


        if(!paynow.getText().toString().equals("") && paynow.getText().length()>0){
          num5  = Integer.parseInt(paynow.getText().toString());
        }else{
            num5 = 0;
        }
        if(!payed.getText().toString().equals("") && payed.getText().length()>0){
            num4 = Integer.parseInt(payed.getText().toString());
        }else{
            num4 = 0;
        }
        if(!amount.getText().toString().equals("") && amount.getText().length()>0){
            num3 = Integer.parseInt(amount.getText().toString());
        }else{
            num3 = 0;
        }

        return Integer.toString(num3-(num4+num5));

    }

    private String getl() {
        String s;
        String y = "";
        String z = "";
        if(!editTextName.getText().toString().equals("") && editTextName.getText().length()>0){
           // vectorDrawable.setVisible(false,false);
           // textView.setVisibility(View.VISIBLE);

            textView.setBackgroundResource(R.drawable.rounded3);
            s = editTextName.getText().toString();
            y = String.valueOf(s.charAt(0));
            z = y.toUpperCase();

            layoutname.setError(null);


        }else{
           // textView.setVisibility(View.GONE);
                textView.setBackgroundResource(R.drawable.rounded);
              ///  vectorDrawable.setVisible(true,false);
           // Drawable img = textView.getContext().getResources().getDrawable(R.drawable.ic_baseline_person_outline_24);
           // textView.setCompoundDrawablesWithIntrinsicBounds(img, null,null,null);
             }
        return z;

           // s = editTextName.getText().toString();

    }




    private String payed2(){
        int num10,num11;
        if(!paynow.getText().toString().equals("") && paynow.getText().length()>0){
            num10  = Integer.parseInt(paynow.getText().toString());
        }else{
            num10 = 0;
        }
        if(!payed.getText().toString().equals("") && payed.getText().length()>0){
            num11  = Integer.parseInt(payed.getText().toString());
        }else{
            num11 = 0;
        }


       // int num10 = Integer.parseInt(payed.getText().toString().trim());
       // int num11 = Integer.parseInt(paynow.getText().toString().trim());
        int num45;
        num45 = num10 + num11;
         return Integer.toString(num45);

    }


/*
    private void readHeroes() {

        PerformNetworkRequest request1 = new PerformNetworkRequest(Api.URL_READ_HEROES, null, CODE_GET_REQUEST);
        request1.execute();

    }
    */




    private void updateHero() {

        system = false;
        String id = editTextHeroId.getText().toString();
        String name = editTextName.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();
        String bill1 = bill.getText().toString().trim();
        String creation1 = creation.getText().toString().trim();
        String description1 = description.getText().toString().trim();
        String type1 = customer.getText().toString().trim();
        //String type1 = type.getSelectedItem().toString();

        String reference1 = reference.getText().toString().trim();
        String amount1 = amount.getText().toString().trim();

        String payed1 = payed.getText().toString().trim();

        String paynow1 = paynow.getText().toString().trim();
        String updated1 = updated.getText().toString().trim();
       // long millis=System.currentTimeMillis();
       //   java.sql.Date date=new java.sql.Date(millis);

        //  String updated1 = String.valueOf(date);




        if (TextUtils.isEmpty(name)) {
            layoutname.setError("Please enter name");
            editTextName.requestFocus();
            return;
        }
        if (paynow1.equals("")) {
            paynow1 = Integer.toString(0);

          //  paynow.setText(Integer.toString(0));
        }
        if (TextUtils.isEmpty(amount1)) {
            amount1 = Integer.toString(0);
         //   amount.setText(Integer.toString(0));
        }




     //   if (TextUtils.isEmpty(realname)) {
      //      editTextRealname.setError("Please enter real name");
       //     editTextRealname.requestFocus();
      //      return;
      //  }

        HashMap<String, String> params = new HashMap<>();
        params.put("id", id);
        params.put("name", name);
        params.put("phone", phone);
        params.put("address", address);
        params.put("bill", bill1);
        params.put("creation", creation1);
        params.put("description", description1);
        params.put("type", type1);
        params.put("reference", reference1);
        params.put("amount", amount1);
        params.put("payed", payed1);
        params.put("updated", updated1);






         TotalAmount=0;
         TotalPayed=0;
         TotalRemain=0;
        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_UPDATE_HERO, params, CODE_POST_REQUEST);
        request.execute();

        buttonAddUpdate.setText("Add");

        editTextPhone.setText("");
        editTextAddress.setText("");
        bill.setText("");
        creation.setText("");
        description.setText("");
       customer.setText("");
      //  type.setSelection(0);

        reference.setText("");
        amount.setText("");
        remain.setText("");

        isUpdating = false;
//go back
        linearLayout.setVisibility(View.GONE);

        left_menu.setVisibility(View.VISIBLE);

        Mymenu.findItem(R.id.actionSearch).setVisible(true);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
      //  recyclerView.setVisibility(View.VISIBLE);
        floatingActionButton.setVisibility(View.VISIBLE);
        bottomAppBar.setVisibility(View.VISIBLE);
        iteme.setVisible(true);
        itemp.setVisible(true);

        createHero(4, id);
        payed.setText("");
        updated.setText("");
        paynow.setText("");
         drawertext.setText("All Bills");
        editTextName.setText("");
        navigationView.setCheckedItem(R.id.item2);


        horizontal.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
        alpha2("gone");
        alpha("visible");

        createHero(2,"0");

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                system = true;
            }
        },1000);


    }

    private void deleteHero(int id) {
        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_DELETE_HERO + id, null, CODE_GET_REQUEST);
        request.execute();

        TotalAmount=0;
        TotalPayed=0;
        TotalRemain=0;
        createHero(2,"0");
    }
    private void deleteHero2(int id) {
        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_DELETE_HERO2 + id, null, CODE_GET_REQUEST);
        request.execute();
        xx = false;
        //createHero(2,"0");

        TotalAmount=0;
        TotalPayed=0;
        TotalRemain=0;
        createHero(1, pidf);


    }



    //  KeyListener listener;
    private void disable(EditText ppd) {
        ppd.setFocusable(false);
        ppd.setEnabled(false);
        ppd.setCursorVisible(false);
        ppd.setFocusableInTouchMode(false);
      //  listener = ppd.getKeyListener();
      //  ppd.setKeyListener(null);
       // ppd.setBackgroundColor(Color.TRANSPARENT);


    }
    private void disable1(TextView ppd) {
        ppd.setFocusable(false);
        ppd.setEnabled(false);
        ppd.setCursorVisible(false);
        ppd.setFocusableInTouchMode(false);
        //  listener = ppd.getKeyListener();
        //  ppd.setKeyListener(null);
        // ppd.setBackgroundColor(Color.TRANSPARENT);


    }
    private void disable2(AutoCompleteTextView ppd) {
        ppd.setFocusable(false);
        ppd.setEnabled(false);
       // ppd.setCursorVisible(false);
        ppd.setFocusableInTouchMode(false);
        //  listener = ppd.getKeyListener();
        //  ppd.setKeyListener(null);
        // ppd.setBackgroundColor(Color.TRANSPARENT);


    }
    private void disable3(AppCompatImageButton ppd) {
        ppd.setFocusable(false);
        ppd.setEnabled(false);
        // ppd.setCursorVisible(false);
        ppd.setFocusableInTouchMode(false);
        //  listener = ppd.getKeyListener();
        //  ppd.setKeyListener(null);
        // ppd.setBackgroundColor(Color.TRANSPARENT);


    }


    private void enable(EditText ppd1) {
        ppd1.setFocusable(true);
        ppd1.setEnabled(true);
        ppd1.setCursorVisible(true);
        ppd1.setFocusableInTouchMode(true);
       // ppd1.setKeyListener(listener);
     //  ppd1.setHighlightColor(Color.rgb(117,117,117));

    }
    private void enable1(TextView ppd1) {
        ppd1.setFocusable(true);
        ppd1.setEnabled(true);
        ppd1.setCursorVisible(true);
        ppd1.setFocusableInTouchMode(true);
        // ppd1.setKeyListener(listener);
        //  ppd1.setHighlightColor(Color.rgb(117,117,117));

    }
    private void enable2(AutoCompleteTextView ppd1) {
        ppd1.setFocusable(true);
        ppd1.setEnabled(true);
      //  ppd1.setCursorVisible(true);
        ppd1.setFocusableInTouchMode(true);
        // ppd1.setKeyListener(listener);
        //  ppd1.setHighlightColor(Color.rgb(117,117,117));

    }
    private void enable3(AppCompatImageButton ppd1) {
        ppd1.setFocusable(true);
        ppd1.setEnabled(true);
       // ppd1.setCursorVisible(true);
        ppd1.setFocusableInTouchMode(true);
        // ppd1.setKeyListener(listener);
        //  ppd1.setHighlightColor(Color.rgb(117,117,117));

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.header_menu, menu);
        Mymenu = menu;
        MenuItem searchItem = menu.findItem(R.id.actionSearch);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                sc=1;
                adapter.getFilter().filter(newText);
               // bottomAppBar.setVisibility(GONE);
                return true;
            }
        });




        return true;
    }









    private void refreshHeroList(JSONArray heroes) throws JSONException {
        heroList.clear();

        for (int i = 0; i < heroes.length(); i++) {
            JSONObject obj = heroes.getJSONObject(i);

            heroList.add(new Hero(
                    obj.getInt("id"),
                    obj.getString("name"),
                    obj.getString("phone"),
                    obj.getString("address"),
                    obj.getString("bill"),
                    obj.getString("creation"),
                    obj.getString("description"),
                    obj.getString("type"),
                    obj.getString("reference"),
                    obj.getString("amount"),
                    obj.getString("payed"),
                    obj.getString("updated")

            ));
        }

        noofitem.setText(Integer.toString(heroList.size())+" Bills");


        if(heroList.size()==0){
            noitem.setVisibility(View.VISIBLE);

           // horizontal.setVisibility(GONE);
        }else{

            noitem.setVisibility(View.GONE);

           // horizontal.setVisibility(View.VISIBLE);
        }




        //count s.//

        TotalAmount=0;
        TotalPayed=0;
        TotalRemain=0;
        for (int i=0; i<heroList.size(); i++){


            int h = Integer.parseInt(heroList.get(i).getamount());
            int k = Integer.parseInt(heroList.get(i).getpayed());


            TotalAmount = TotalAmount + h;
            TotalPayed = TotalPayed + k;


        }

        if(xx) {

            count(txtpaid,TotalPayed);
            count(txttotall,TotalAmount);
            TotalRemain = TotalAmount - TotalPayed;
            count(txtremain, TotalRemain);
          //  Toast.makeText(getApplicationContext(), Integer.toString(TotalAmount), Toast.LENGTH_SHORT).show();

        }else if(xx==false){

            count(txtpaid,TotalPayed);

        }

        //count end//




        Collections.sort(heroList, new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                return o2.getId()-o1.getId();
            }
        });

        adapter = new ProductsAdapter(crud.this,heroList);

        recyclerView.setAdapter(adapter);


    }








    private class PerformNetworkRequest extends AsyncTask<Void, Void, String> {
        String url;
        HashMap<String, String> params;
        int requestCode;

        PerformNetworkRequest(String url, HashMap<String, String> params, int requestCode) {
            this.url = url;
            this.params = params;
            this.requestCode = requestCode;
            //crud.this.adapter.getFilter().filter;

          //  progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);


            //ss



            //end
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject object = new JSONObject(s);
                if (!object.getBoolean("error")) {

                    progressBar.setVisibility(GONE);
                  //  mSwipeRefreshLayout.setRefreshing(false);
                    Toast.makeText(getApplicationContext(), object.getString("message"), Toast.LENGTH_SHORT).show();
                    refreshHeroList(object.getJSONArray("heroes"));
                 if(xx==false){
                     recyclerView.setVisibility(View.VISIBLE);
                     horizontal.setVisibility(View.VISIBLE);

                 }else if(xx==true && linearLayout.getVisibility()==GONE){

                     cardView2.setVisibility(View.VISIBLE);
                     cardView4.setVisibility(View.VISIBLE);
                     horizontal.setVisibility(View.VISIBLE);
                 }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(Void... voids) {
            RequestHandler requestHandler = new RequestHandler();

            if (requestCode == CODE_POST_REQUEST)
                return requestHandler.sendPostRequest(url, params);


            if (requestCode == CODE_GET_REQUEST)
                return requestHandler.sendGetRequest(url);

            return null;
        }
    }




    public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> implements Filterable {


        private Context mCtx;
        private List<Hero> heroList;
        private  List<Hero> heroListfull;


        public ProductsAdapter(Context mCtx, List<Hero> heroList) {
            this.mCtx = mCtx;
            this.heroList = heroList;
            heroListfull = new ArrayList<>(heroList);
        }

        @Override
        public ProductsAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(mCtx);
            View view = inflater.inflate(R.layout.layout_hero_list,parent, false);
            return new ProductsAdapter.ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ProductsAdapter.ProductViewHolder holder, int position) {
              Hero hero = heroList.get(position);

            //loading the image
            //Glide.with(mCtx)
            //   .load(product.getImage())
            //  .into(holder.imageView);





            holder.textViewName1.setText(hero.getName());

          /*
            Typeface typeface = ResourcesCompat.getFont(
                    crud.this,R.font.robo
            );

            Typeface typeface1 = Typeface.createFromAsset(
                    getAssets(),"roboa.ttf"
            );


            holder.textViewName1.setTypeface(typeface1);
            holder.textViewName1.setTypeface(typeface);


            holder.remain2.setTypeface(typeface1);
            holder.remain2.setTypeface(typeface);


            holder.txtdate.setTypeface(typeface1);
            holder.txtdate.setTypeface(typeface);


            holder.ruppes.setTypeface(typeface1);
            holder.ruppes.setTypeface(typeface);


            holder.payed2.setTypeface(typeface1);
            holder.payed2.setTypeface(typeface);

           */



            noofitem.setText(Integer.toString(heroList.size())+" Bills");


            // satrt
            ViewGroup.MarginLayoutParams layoutParams2 = (ViewGroup.MarginLayoutParams) holder.cardView.getLayoutParams();
            layoutParams2.setMargins(30, 30, 30, 30);
            holder.cardView.requestLayout();

            if(position+1==heroList.size()) {
                //   Toast.makeText(getApplicationContext(), "pos"+(position+1)+"size"+heroList.size(), Toast.LENGTH_SHORT).show();

                //  holder.cardView.setCardBackgroundColor(Color.parseColor("#b70505"));
                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) holder.cardView.getLayoutParams();
                layoutParams.setMargins(30, 30, 30, 250);
                holder.cardView.requestLayout();
                // recyclerView.getScrollX();
            }


/*
           if(holder.getLayoutPosition()+1==heroList.size()){
                //  holder.cardView.setCardBackgroundColor(Color.parseColor("#b70505"));
                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) holder.cardView.getLayoutParams();
                layoutParams.setMargins(30,30,30,210);
                holder.cardView.requestLayout();
               // recyclerView.getScrollX();
            }
*/

            if (xx == true) {

              //  item2.setEnabled(true);
                //   item2.setChecked(true);

               // drawertext.setText("All Bills");

                holder.ruppes.setText("₹" + hero.getamount());

                holder.txtdate.setText(hero.getcreation());
                holder.payed2.setText("- ₹" + hero.getpayed());
                String Amounts = hero.getamount();
                String Payedss = hero.getpayed();

                int a = Integer.parseInt(Amounts);
                int b = Integer.parseInt(Payedss);
                int c = a - b;
                /*
              //total
                TotalAmount = TotalAmount+a;

                 count(txttotall,TotalAmount);
             //payed
                TotalPayed = TotalPayed+b;

                count(txtpaid,TotalPayed);
                //remain
                TotalRemain = TotalRemain+c;

                count(txtremain,TotalRemain);

                 */

             //   Toast.makeText(getApplicationContext(), "pos"+position+"size"+heroList.size(), Toast.LENGTH_SHORT).show();



                 String d = Integer.toString(c);
                holder.remain2.setText("= ₹" + d);


                // hidden1.setVisibility(View.GONE);

                holder.expand.setVisibility(View.VISIBLE);

                holder.hidden2.setVisibility(View.VISIBLE);

                holder.textViewDelete2.setVisibility(View.GONE);


                holder.txtdate.setVisibility(View.VISIBLE);


                floatingActionButton.setVisibility(View.VISIBLE);
                bottomAppBar.setVisibility(View.VISIBLE);
                iteme.setVisible(true);
                itemp.setVisible(true);

             //   recyclerView.setVisibility(View.VISIBLE);


            } else if (xx == false) {

              //  item2.setEnabled(true);

                //item2.setChecked(true);

               // drawertext.setText("Transactions");

              //  recyclerView.setVisibility(View.GONE);

                holder.ruppes.setText(hero.getupdated());

                holder.payed2.setText("₹" + hero.getpayed());

               // holder.txtdate.setText(hero.getcreation());

                holder.txtdate.setVisibility(View.GONE);

                holder.hidden1.setVisibility(View.GONE);

                holder.expand.setVisibility(View.GONE);

                holder.textViewDelete2.setVisibility(View.VISIBLE);

                holder.hidden2.setVisibility(View.GONE);

                floatingActionButton.setVisibility(View.GONE);
                bottomAppBar.setVisibility(GONE);
                iteme.setVisible(false);
                itemp.setVisible(false);


                //  recyclerView.setVisibility(View.VISIBLE);


            }

            ////excel////


            holder.textViewdetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(system) {
                        //   progressBar.setVisibility(View.VISIBLE);
                        Mymenu.findItem(R.id.actionSearch).setVisible(false);
                        Mymenu.findItem(R.id.actionSearch).collapseActionView();
                   //     Mymenu.findItem(R.id.actionSearch).setTitle("");

                        recyclerView.setVisibility(View.GONE);

                        horizontal.setVisibility(View.GONE);
                        cardView2.setVisibility(View.GONE);
                        cardView4.setVisibility(GONE);

                        String pid1 = Integer.toString(hero.getId());
                        pidf = pid1;

                        xx = false;
                        createHero(1, pid1);

                        Menu menu1 = navigationView.getMenu();

                        MenuItem item2 = menu1.findItem(R.id.item2);
                        item2.setTitle("Transactions");

                        navigationView.setCheckedItem(R.id.item2);

                        drawertext.setText("Transactions");

                        holder.ruppes.setText(hero.getupdated());

                        holder.payed2.setText("₹" + hero.getpayed());


                        holder.hidden1.setVisibility(View.GONE);

                        holder.expand.setVisibility(View.GONE);

                        holder.hidden2.setVisibility(View.GONE);
                        holder.textViewDelete2.setVisibility(View.VISIBLE);

                        floatingActionButton.setVisibility(View.GONE);
                        bottomAppBar.setVisibility(GONE);
                        iteme.setVisible(false);
                        itemp.setVisible(false);

                        // recyclerView.setVisibility(View.VISIBLE);

                    }

                }
            });



            holder.expand.setOnClickListener(view -> {

               //153dp if (holder.cardView.getHeight()==holder.cardView.getMinimumHeight()) {
                 int poss = Integer.parseInt(String.valueOf(holder.expand2.getText()));
                 if(poss==0){
                  //   Toast.makeText(getApplicationContext(),"success", Toast.LENGTH_SHORT).show();



//620
                    ValueAnimator valueAnim = ValueAnimator.ofInt(holder.cardView.getMeasuredHeightAndState(),holder.cardView.getMeasuredHeightAndState()+160);
                    valueAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            int val = (int) animation.getAnimatedValue();
                            ViewGroup.LayoutParams layoutParams=holder.cardView.getLayoutParams();
                            layoutParams.height = val;
                            holder.cardView.setLayoutParams(layoutParams);
                            holder.cardView.setCardElevation(100);
                            holder.cardView.setElevation(100);
                            holder.expand.setImageResource(R.drawable.ic_baseline_expand_less_24);
                            holder.hidden1.setVisibility(View.VISIBLE);
                          //  holder.relative.setElevation(50);

                        }



                    });

                    valueAnim.start();

                    holder.expand2.setText("1");



                } else {
               //     Toast.makeText(getApplicationContext(), Integer.toString(holder.cardView.getMinimumHeight()), Toast.LENGTH_SHORT).show();
                    ValueAnimator valueAnim = ValueAnimator.ofInt(holder.cardView.getMeasuredHeightAndState(),holder.cardView.getMeasuredHeightAndState()-160);
                    valueAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            int val = (int) animation.getAnimatedValue();
                            ViewGroup.LayoutParams layoutParams=holder.cardView.getLayoutParams();
                            layoutParams.height = val;
                            holder.cardView.setLayoutParams(layoutParams);
                            holder.cardView.setCardElevation(30);
                            holder.cardView.setElevation(30);
                            holder.expand.setImageResource(R.drawable.ic_baseline_expand_more_24);
                            holder.hidden1.setVisibility(GONE);

                        }



                    });
                    valueAnim.start();

                    holder.expand2.setText("0");

                }

            });




            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (xx == true  ) {

                        if(system) {


                            Mymenu.findItem(R.id.actionSearch).setVisible(false);
                            Mymenu.findItem(R.id.actionSearch).collapseActionView();
                            Mymenu.findItem(R.id.actionSearch).setTitle("");

                       //     Mymenu.findItem(R.id.actionSearch).setVisible(false);

                            layoutname.setEndIconMode(TextInputLayout.END_ICON_NONE);
                            layoutphone.setEndIconMode(TextInputLayout.END_ICON_NONE);
                            layoutaddress.setEndIconMode(TextInputLayout.END_ICON_NONE);
                            layoutbill.setEndIconMode(TextInputLayout.END_ICON_NONE);
                            layoutdescription.setEndIconMode(TextInputLayout.END_ICON_NONE);
                            layoutreference.setEndIconMode(TextInputLayout.END_ICON_NONE);
                            layoutamount.setEndIconMode(TextInputLayout.END_ICON_NONE);


                            renew.setVisibility(GONE);


                            layoutpaynow.setVisibility(GONE);
                            updatedb.setVisibility(GONE);
                            creationb.setVisibility(GONE);
                          //  layoutname.setEndIconActivated(false);
                          //  layoutname.setEndIconVisible(false);

                            left_menu.setVisibility(View.GONE);
                        drawertext.setText("Details");

                            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);


                        //  alpha("gone");
                        alpha("gone");

                        linearLayout.setVisibility(View.VISIBLE);
                        alpha2("visible");


                        floatingActionButton.setVisibility(View.GONE);
                            bottomAppBar.setVisibility(GONE);
                            iteme.setVisible(false);
                            itemp.setVisible(false);

                      //  paynow5.setVisibility(View.GONE);
                        paynow.setVisibility(View.GONE);
                        paynow.setText(Integer.toString(0));

                        disable(editTextName);
                        disable(editTextPhone);
                        disable(editTextAddress);
                        disable(bill);
                        disable1(creation);
                        disable(description);
                        disable2(customer);
                        disable(reference);
                        disable(amount);
                        disable1(payed);
                        disable(paynow);
                        disable1(remain);
                        disable1(updated);

                        disable3(renew);
                        //set values

                        editTextHeroId.setText(String.valueOf(hero.getId()));
                        editTextName.setText(hero.getName());
                        editTextPhone.setText(hero.getPhone());
                        editTextAddress.setText(hero.getAddress());
                        bill.setText(hero.getbill());
                        creation.setText(hero.getcreation());
                        description.setText(hero.getdescription());
                        customer.setText(hero.gettype());
                     //   type.setSelection(((ArrayAdapter<String>) type.getAdapter()).getPosition(hero.gettype()));

                        reference.setText(hero.getreference());
                        amount.setText(hero.getamount());
                        payed.setText(hero.getpayed());
                        updated.setText(hero.getupdated());

                        buttonAddUpdate.setVisibility(View.GONE);

                    }
                    }
                }
            });




            holder.textViewUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (system) {
                        isUpdating = true;


                        Mymenu.findItem(R.id.actionSearch).setVisible(false);
                        Mymenu.findItem(R.id.actionSearch).collapseActionView();
                        Mymenu.findItem(R.id.actionSearch).setTitle("");

                        layoutname.setEndIconMode(TextInputLayout.END_ICON_CLEAR_TEXT);
                        layoutphone.setEndIconMode(TextInputLayout.END_ICON_CLEAR_TEXT);
                        layoutaddress.setEndIconMode(TextInputLayout.END_ICON_CLEAR_TEXT);
                        layoutbill.setEndIconMode(TextInputLayout.END_ICON_CLEAR_TEXT);
                        layoutdescription.setEndIconMode(TextInputLayout.END_ICON_CLEAR_TEXT);
                        layoutreference.setEndIconMode(TextInputLayout.END_ICON_CLEAR_TEXT);
                        layoutamount.setEndIconMode(TextInputLayout.END_ICON_CLEAR_TEXT);



                        renew.setVisibility(View.VISIBLE);



                        layoutpaynow.setVisibility(View.VISIBLE);
                        updatedb.setVisibility(View.VISIBLE);
                        creationb.setVisibility(View.VISIBLE);

                        left_menu.setVisibility(View.GONE);
                        drawertext.setText("Update Bill");
                        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

                        //   alpha("gone");
                        alpha("gone");

                        linearLayout.setVisibility(View.VISIBLE);
                        alpha2("visible");

                        floatingActionButton.setVisibility(View.GONE);
                        bottomAppBar.setVisibility(GONE);
                        iteme.setVisible(false);
                        itemp.setVisible(false);
                        buttonAddUpdate.setVisibility(View.VISIBLE);

                        editTextHeroId.setText(String.valueOf(hero.getId()));
                        editTextName.setText(hero.getName());
                        editTextPhone.setText(hero.getPhone());
                        editTextAddress.setText(hero.getAddress());
                        bill.setText(hero.getbill());

                        Date c = Calendar.getInstance().getTime();
                        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyy", Locale.getDefault());
                        String formattedDate = df.format(c);
                        updated.setText(formattedDate);


                        creation.setText(hero.getcreation());
                        description.setText(hero.getdescription());
                         customer.setText(hero.gettype());
                     //   type.setSelection(((ArrayAdapter<String>) type.getAdapter()).getPosition(hero.gettype()));

                        reference.setText(hero.getreference());
                        amount.setText(hero.getamount());
                        payed.setText(hero.getpayed());
                        //  updated.setText(hero.getupdated());

                        paynow.setText(Integer.toString(0));
                        //enable


                        enable(editTextName);
                        enable(editTextPhone);
                        enable(editTextAddress);
                        enable(bill);
                        enable1(creation);
                        enable(description);
                        enable2(customer);
                        enable(reference);
                        enable(amount);
                        enable1(payed);
                        enable(paynow);
                        enable1(remain);
                        enable1(updated);
                        enable3(renew);

                        int num10 = Integer.parseInt(amount.getText().toString().trim());
                        int num11 = Integer.parseInt(payed.getText().toString().trim());
                        int num45;
                        num45 = num10 - num11;

                        remain.setText(Integer.toString(num45));


                        buttonAddUpdate.setText("Update");
                    }
                }
            });

            holder.textViewDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(crud.this);

                    builder.setTitle("Delete " + hero.getName())
                            .setMessage("Are you sure you want to delete it?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    deleteHero(hero.getId());
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();

                }
            });
            holder. textViewDelete2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(crud.this);

                    builder.setTitle("Delete " + hero.getName())
                            .setMessage("Are you sure you want to delete it?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    deleteHero2(hero.getId());
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();

                }
            });


            //end


        }

        @Override
        public int getItemCount() {
            if(heroList.size()==0){
                noitem.setVisibility(View.VISIBLE);

                horizontal.setVisibility(GONE);
            }else{

                noitem.setVisibility(View.GONE);

                horizontal.setVisibility(View.VISIBLE);
            }

            return heroList.size();
        }

        @Override
        public Filter getFilter() {
            return exampleFilter;
        }
        private Filter exampleFilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
               List<Hero> filteredList = new ArrayList<>();
               // List<Hero> filteredList2 = new ArrayList<>();


               // this.heroList = heroList;

               // filteredList.addAll(heroList);
                if(sc==0){

                    if (constraint == null || constraint.length() == 0) {
                     //   filteredList.addAll(heroList);
                    }
                    else {

                        String filterPattern = constraint.toString().toLowerCase().trim();

                        TotalAmount=0;
                        TotalPayed=0;
                        TotalRemain=0;
                        for (Hero item : heroListfull) {
                            if (item.getcreation().toLowerCase().contains(filterPattern) && xx==true) {
                                // filteredList.removeAll(heroListfull);

                                filteredList.add(item);
                                filteredList2.add(item);

                            }else if (item.getupdated().toLowerCase().contains(filterPattern) && xx==false) {
                                // filteredList.removeAll(heroListfull);

                                filteredList.add(item);
                                filteredList2.add(item);

                            }
                        }

                                //count s.//
                        for (int i=0; i<filteredList.size(); i++){


                            int h = Integer.parseInt(filteredList.get(i).getamount());
                            int k = Integer.parseInt(filteredList.get(i).getpayed());
                           //  int l = h-k;

                            TotalAmount = TotalAmount + h;
                            TotalPayed = TotalPayed + k;
                           // TotalRemain = TotalRemain + l;

                        }

                        count(txtpaid,TotalPayed);
                        if(xx) {
                            count(txttotall,TotalAmount);
                            TotalRemain = TotalAmount - TotalPayed;
                            count(txtremain, TotalRemain);
                        }
                           //count end//


                        //  Log.d(this, Arrays.deepToString(List<Hero>));



                    }

                }else{


                    TotalAmount=0;
                    TotalPayed=0;
                    TotalRemain=0;
                if (constraint == null || constraint.length() == 0) {
                    if(filteredList2.size() == 0 && (drawertext.getText()=="All Bills"||drawertext.getText()=="Transactions")){

                        filteredList.addAll(heroListfull);


                       // Toast.makeText(getApplicationContext(), (CharSequence) heroList, Toast.LENGTH_SHORT).show();
                    }else {

                        filteredList.addAll(filteredList2);

                       // Toast.makeText(getApplicationContext(), (CharSequence) filteredList, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    String filterPattern = constraint.toString().toLowerCase().trim();

                    for (Hero item : heroList) {
                        if (item.getName().toLowerCase().contains(filterPattern)) {
                           // filteredList.removeAll(heroListfull);
                            filteredList.add(item);
                        }
                    }

                }
                    //count s.//
                    for (int i=0; i<filteredList.size(); i++){


                        int h = Integer.parseInt(filteredList.get(i).getamount());
                        int k = Integer.parseInt(filteredList.get(i).getpayed());
                        //int l = h-k;

                        TotalAmount = TotalAmount + h;
                        TotalPayed = TotalPayed + k;
                      //  TotalRemain = TotalRemain + l;

                    }
                    count(txtpaid,TotalPayed);
                    if(xx) {
                        count(txttotall,TotalAmount);
                        TotalRemain = TotalAmount - TotalPayed;
                        count(txtremain, TotalRemain);
                    }
                    //count end//


                }
                FilterResults results = new FilterResults();
                results.values = filteredList;
                return results;
            }
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                heroList.clear();
                heroList.addAll((List) results.values);
                if(heroList.size()==0){
                    noitem.setVisibility(View.VISIBLE);

                    horizontal.setVisibility(GONE);

                    noofitem.setText(Integer.toString(heroList.size())+" Bills");
                }else{

                    noitem.setVisibility(View.GONE);

                    horizontal.setVisibility(View.VISIBLE);
                }

                notifyDataSetChanged();
            }
        };



        class ProductViewHolder extends RecyclerView.ViewHolder {

            TextView remain2, payed2, ruppes, textViewName1,txtdate,expand2;
            AppCompatImageButton expand,textViewUpdate,textViewDelete,textViewdetail,textViewDelete2;
            CardView cardView;
            RelativeLayout relative;
            LinearLayout hidden2,hidden1;
            public ProductViewHolder(View listViewItem) {
                super(listViewItem);

                textViewName1 = listViewItem.findViewById(R.id.textViewName);
                ruppes = listViewItem.findViewById(R.id.ruppes);
                payed2 = listViewItem.findViewById(R.id.payed2);
                remain2 = listViewItem.findViewById(R.id.remain2);
                txtdate = listViewItem.findViewById(R.id.txtdate);

                expand = listViewItem.findViewById(R.id.expand);
               expand2 = listViewItem.findViewById(R.id.expand2);

                textViewUpdate = listViewItem.findViewById(R.id.textViewUpdate);
                textViewDelete = listViewItem.findViewById(R.id.textViewDelete);
                textViewdetail = listViewItem.findViewById(R.id.textViewdetail);
                textViewDelete2 = listViewItem.findViewById(R.id.delete);

                cardView = listViewItem.findViewById(R.id.card);
                hidden1 = listViewItem.findViewById(R.id.hidden1);
                hidden2 = listViewItem.findViewById(R.id.fixed54);


             //   relative = listViewItem.findViewById(R.id.relative);


            }

        }


    }
/*
    class HeroAdapter extends ArrayAdapter<Hero> {
        //private final Object adapter;
        //  public static Locale getFilter;
        List<Hero> heroList;

        public HeroAdapter(List<Hero> heroList) {
            super(crud.this, R.layout.layout_hero_list, heroList);
            this.heroList = heroList;
          //  listView.setAdapter(adapter);



        }



        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View listViewItem = inflater.inflate(R.layout.layout_hero_list, null, true);


            CardView cardView = listViewItem.findViewById(R.id.card);
            LinearLayout hidden1 = listViewItem.findViewById(R.id.hidden1);
            LinearLayout hidden2 = listViewItem.findViewById(R.id.fixed54);
            TextView textViewName1 = listViewItem.findViewById(R.id.textViewName);
            TextView ruppes = listViewItem.findViewById(R.id.ruppes);
            TextView payed2 = listViewItem.findViewById(R.id.payed2);

           // TextView id2 = listViewItem.findViewById(R.id.textViewid);
            TextView remain2 = listViewItem.findViewById(R.id.remain2);
            AppCompatImageButton expand = listViewItem.findViewById(R.id.expand);
            AppCompatImageButton textViewUpdate = listViewItem.findViewById(R.id.textViewUpdate);
            AppCompatImageButton textViewDelete = listViewItem.findViewById(R.id.textViewDelete);
            AppCompatImageButton textViewdetail = listViewItem.findViewById(R.id.textViewdetail);

            AppCompatImageButton textViewDelete2 = listViewItem.findViewById(R.id.delete);

            final Hero hero = heroList.get(position);

            textViewName1.setText(hero.getName());



            return listViewItem;
        }
    }

    */
}
