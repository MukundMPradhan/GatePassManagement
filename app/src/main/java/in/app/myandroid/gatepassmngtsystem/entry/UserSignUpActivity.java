package in.app.myandroid.gatepassmngtsystem.entry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import in.app.myandroid.gatepassmngtsystem.R;
import in.app.myandroid.gatepassmngtsystem.dbHelper.DataBaseHelper;

public class UserSignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtUsuUserID, txtUsuPassword, txtUsuCnfPassword, txtUsuFastName, txtUsuLastName;
    private TextView txtUsuFrName, txtUsuMobNo, txtUsuPhotoPath, txtUsuEmail, txtUsuDob;
    private Spinner spinnerRole, spinnerGender;
    private Button btnSubmit, btnCancel;

    ArrayAdapter adapterRole;
    ArrayAdapter adapterGender;


    DataBaseHelper dataBaseHelper;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_up);

        txtUsuUserID = (TextView) findViewById(R.id.etUsuUserId);
        txtUsuPassword = (TextView) findViewById(R.id.etUsuPassword);
        txtUsuFastName = (TextView) findViewById(R.id.etUsuFastName);
        txtUsuLastName = (TextView) findViewById(R.id.etUsuLastName);
        txtUsuFrName = (TextView) findViewById(R.id.etUsuFrName);
        txtUsuMobNo = (TextView) findViewById(R.id.etUsuMobile);
        txtUsuCnfPassword = (TextView) findViewById(R.id.etUsuCnfPassword);
        txtUsuPhotoPath = (TextView) findViewById(R.id.etUsuPhotos);
        txtUsuEmail = (TextView) findViewById(R.id.etUsuEmail);
        btnSubmit = (Button) findViewById(R.id.buttonUsuSubmit);
        btnCancel = (Button) findViewById(R.id.buttonUsuCancel);

        spinnerRole = (Spinner) findViewById(R.id.spinner);
        spinnerGender = (Spinner) findViewById(R.id.spinnerGender);
        txtUsuDob = (TextView) findViewById(R.id.etUsuDob);

        adapterRole = ArrayAdapter.createFromResource(getApplicationContext(), R.array.role, R.layout.layout_text_view);
        adapterGender = ArrayAdapter.createFromResource(getApplicationContext(), R.array.gender, R.layout.layout_text_view);

        spinnerRole.setAdapter(adapterRole);
        spinnerGender.setAdapter(adapterGender);

        dataBaseHelper = new DataBaseHelper(this);


        btnSubmit.setOnClickListener(this);


        txtUsuEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (txtUsuEmail.getText().toString().length() < 1)
                        txtUsuEmail.setError("Email field can not be empty");
                }
            }
        });
        txtUsuUserID.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (txtUsuUserID.getText().toString().length() < 1) {
                        txtUsuUserID.setError("User ID may not be blank");
                    }
                }
            }
        });
        txtUsuPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (txtUsuPassword.getText().toString().length() < 1)
                        txtUsuPassword.setError("Password may not be blank");
                }
            }
        });
        txtUsuCnfPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (txtUsuCnfPassword.getText().toString().length() < 1) {
                        txtUsuCnfPassword.setError("Plz re-enter correct password");
                    } else if (!txtUsuPassword.getText().toString().trim().equals(txtUsuCnfPassword.getText().toString().trim())) {
                        txtUsuCnfPassword.setError("Both password not same");

                    }
                }
            }
        });


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonUsuSubmit) {
            String id = txtUsuUserID.getText().toString();
            String pw = txtUsuPassword.getText().toString();
            String role = spinnerRole.getSelectedItem().toString();
            String fastName = txtUsuFastName.getText().toString();
            String lastName = txtUsuLastName.getText().toString();
            String frName = txtUsuFrName.getText().toString();
            String gender = spinnerGender.getSelectedItem().toString();
            String dob = txtUsuDob.getText().toString();
            String mobNo = txtUsuMobNo.getText().toString();
            String photoPath = txtUsuPhotoPath.getText().toString();
            String email = txtUsuEmail.getText().toString();


            dataBaseHelper.insertUser(id, pw, role, fastName, lastName, frName, gender,
                    dob, mobNo, photoPath, email);

            txtUsuUserID.setText("");
            txtUsuPassword.setText("");
            spinnerRole.setSelection(0);
            txtUsuFastName.setText("");
            txtUsuLastName.setText("");
            txtUsuFrName.setText("");
            spinnerGender.setSelection(0);
            txtUsuDob.setText("");
            txtUsuMobNo.setText("");
            txtUsuPhotoPath.setText("");
            txtUsuEmail.setText("");
            Toast.makeText(UserSignUpActivity.this, "Account Creation Done Successfully", Toast.LENGTH_SHORT).show();

        } else if (v.getId() == R.id.buttonUsuCancel) {

            //   newPassDataBaseHelper.getAllPasses();
        }

    }


}

