package in.app.myandroid.gatepassmngtsystem.entry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import in.app.myandroid.gatepassmngtsystem.R;
import in.app.myandroid.gatepassmngtsystem.adapters.CustomAdapterCompanyDisplay;
import in.app.myandroid.gatepassmngtsystem.dbHelper.DataBaseHelper;
import in.app.myandroid.gatepassmngtsystem.model.Company;

public class New_Company_Add extends AppCompatActivity implements View.OnClickListener {

    private EditText txtCompName, txtCompAdd, txtContactPerson, txtContactNo;
    private Button btnSubmit, btnCancel;
    private ListView listViewCompanyList;


    DataBaseHelper dataBaseHelper;
    CustomAdapterCompanyDisplay customAdapterCompanyDisplay;

    ArrayList<Company> companies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_add_company);

        txtCompName = (EditText) findViewById(R.id.etACCompName);
        txtCompAdd = (EditText) findViewById(R.id.etACCompAdd);
        txtContactPerson = (EditText) findViewById(R.id.etACContactPerson);
        txtContactNo = (EditText) findViewById(R.id.etACConatactNo);
        btnSubmit = (Button) findViewById(R.id.buttonACSubmit);
        btnCancel = (Button) findViewById(R.id.buttonACCancel);
        listViewCompanyList = (ListView) findViewById(R.id.listviewDisplayCompany);

        dataBaseHelper = new DataBaseHelper(this);

        companies = dataBaseHelper.getAllCompanyList();
        customAdapterCompanyDisplay = new CustomAdapterCompanyDisplay(getApplicationContext(), companies);

        listViewCompanyList.setAdapter(customAdapterCompanyDisplay);


        btnSubmit.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonACSubmit) {

            dataBaseHelper.insertCompany(txtCompName.getText().toString().trim(), txtCompAdd.getText().toString().trim()
                    , txtContactPerson.getText().toString().trim(), txtContactNo.getText().toString().trim());

            Toast.makeText(this, "Data Saved Successfully...", Toast.LENGTH_SHORT).show();


            txtCompName.setText("");
            txtCompAdd.setText("");
            txtContactPerson.setText("");
            txtContactNo.setText("");
            txtCompName.requestFocus();

            customAdapterCompanyDisplay.notifyDataSetChanged();

        } else if (v.getId() == R.id.buttonACCancel) {
            Toast.makeText(this, "You Clicked Cancel Button", Toast.LENGTH_SHORT).show();

        }
    }
}
