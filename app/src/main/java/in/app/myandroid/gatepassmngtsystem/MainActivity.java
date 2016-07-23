package in.app.myandroid.gatepassmngtsystem;

import android.app.Dialog;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import in.app.myandroid.gatepassmngtsystem.dbHelper.DataBaseHelper;
import in.app.myandroid.gatepassmngtsystem.entry.UserSignUpActivity;
import in.app.myandroid.gatepassmngtsystem.model.LoginUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    // Drawer Navigation
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;


    private Button btnSignIn, btnSignUp;
    private EditText txtUserName, txtUserPassword;

    DataBaseHelper dataBaseHelper;
    ArrayList<LoginUser> loginUsers;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Drawer Layout
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);


        btnSignIn = (Button) findViewById(R.id.buttonSignIn);
        btnSignUp = (Button) findViewById(R.id.buttonSignUp);
        txtUserName = (EditText) findViewById(R.id.etMasterUserName);
        txtUserPassword = (EditText) findViewById(R.id.etMasterPassword);

        btnSignIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);

        dataBaseHelper = new DataBaseHelper(this);

        loginUsers = dataBaseHelper.getAllUserStaffs();
        if (loginUsers.size() == 0) {
            Toast.makeText(MainActivity.this,
                    "Till your Database has no user registrations, So please first Sign-Up", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonSignIn) {
            String userName = txtUserName.getText().toString();
            String userPassword = txtUserPassword.getText().toString();
            String savedPassword = dataBaseHelper.getUserSearchEntry(userName);

            if (userPassword.equals(savedPassword)) {

                Toast.makeText(MainActivity.this, "Congrats : Login Successfully", Toast.LENGTH_SHORT).show();

                Intent mainIntent = new Intent(MainActivity.this, WelcomeActivity.class);
                startActivity(mainIntent);

            } else {
                Toast.makeText(MainActivity.this, "User Name / Password not matches", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.buttonSignUp) {

            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.fragment_master_login);
            //  dialog.setTitle("Master Login ....");

            final EditText txtMasterName = (EditText) dialog.findViewById(R.id.etMasterUserName);
            final EditText txtMasterPassword = (EditText) dialog.findViewById(R.id.etMasterPassword);
            final Button btnMasterLogin = (Button) dialog.findViewById(R.id.buttonMasterLogin);

            btnMasterLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String userMasterName = txtMasterName.getText().toString();
                    String userMasterPassword = txtMasterPassword.getText().toString();
                    // String savedMasterUserName=dataBaseHelper.getMasterEntry("UserName");
                    String savedMasterUserName = dataBaseHelper.getMasterUserName(userMasterName);
                    //  Toast.makeText(MainActivity.this, ""+ savedMasterUserName, Toast.LENGTH_SHORT).show();
                    String savedMasterPassword = dataBaseHelper.getMasterUserPassword(userMasterPassword);
                    if (userMasterName.equals(savedMasterUserName) && userMasterPassword.equals(savedMasterPassword)) {
                        Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        Intent signUpIntent = new Intent(MainActivity.this, UserSignUpActivity.class);
                        startActivity(signUpIntent);
                        dialog.dismiss();

                    } else {
                        Toast.makeText(MainActivity.this, "User Name / Password not matches", Toast.LENGTH_SHORT).show();
                        txtMasterName.setText("");
                        txtMasterPassword.setText("");
                        txtMasterName.requestFocus();
                    }
                }
            });
            dialog.show();
        }

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.home) {
            Toast.makeText(getApplicationContext(), "Home Menu Clicked", Toast.LENGTH_SHORT).show();
            Log.e("mmp","Home");
            item.setChecked(true);
        }



        return true;
    }
}
