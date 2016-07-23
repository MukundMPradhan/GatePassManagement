package in.app.myandroid.gatepassmngtsystem.entry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import in.app.myandroid.gatepassmngtsystem.AllFunctions;
import in.app.myandroid.gatepassmngtsystem.R;
import in.app.myandroid.gatepassmngtsystem.dbHelper.DataBaseHelper;

public class New_Individual_Pass extends Activity implements View.OnClickListener {

    // Declarations
    private EditText txtRefNo, txtPreAdd, txtPerAdd, txtCity, txtPinCode, txtLLCode, txtLLNo, txtMobile, txtPolicestation, txtFastName, txtLastName, txtFrName, txtIDProofNo;
    private TextView txtRequestDate, txtIDProofPath;
    private RadioGroup radioGroupPassType, radioGroupGender, radioGroupMStatus;
    private RadioButton radBtnIndividual, radBtnVehicle, radBtnMale, radBtnFemale, radBtnSingle, radBtnMarried;
    private ImageView imgIDProofCam, imgPhotoCam, imgAddCompany;
    private CheckBox chkBoxSameAdd;
    private Spinner spinnerPassCategory, spinnerPassPeriod, spinnerCompany, spinnerIDProof, spinnerDate,
            spinnerMonth, spinnerYear, spinnerState;
    private Button btnSubmit, btnCancel;

    // Declaring Adapters
    ArrayAdapter arrayAdapterPassCategory, arrayAdapterPassPeriod, arrayAdapterIdProofList;
    ArrayAdapter<String> arrayAdapterDate, arrayAdapterMonth, arrayAdapterYear, arrayAdapterCompanyNames;
    //
    ArrayList<String> dateStr, monthStr, yearStr, companyList;
    //ArrayList<Company> companyList;


    AllFunctions allFunctions;
    DataBaseHelper dataBaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_individual_pass);

        //Initialisation of views
        txtRefNo = (EditText) findViewById(R.id.etVehPassRefNo);
        txtIDProofPath = (TextView) findViewById(R.id.etIndPassIDProofPath);
        txtPreAdd = (EditText) findViewById(R.id.etIndPassPreAdd);
        txtPerAdd = (EditText) findViewById(R.id.etIndPassPerAdd);
        txtCity = (EditText) findViewById(R.id.etIndPassCity);
        txtPinCode = (EditText) findViewById(R.id.etIndPassPinCode);
        txtLLCode = (EditText) findViewById(R.id.etIndPassLandLineCode);
        txtLLNo = (EditText) findViewById(R.id.etIndPassLandLineNo);
        txtMobile = (EditText) findViewById(R.id.etIndPassMobile);
        txtPolicestation = (EditText) findViewById(R.id.etIndPassPoliceStation);
        txtFastName = (EditText) findViewById(R.id.etIndPassFastName);
        txtLastName = (EditText) findViewById(R.id.etIndPassLastName);
        txtFrName = (EditText) findViewById(R.id.etIndPassFrName);
        txtIDProofNo = (EditText) findViewById(R.id.etIndPassIDProofNo);
        txtRequestDate = (TextView) findViewById(R.id.tvIndPassRequestDate);
        radBtnFemale = (RadioButton) findViewById(R.id.radioButtonIndPassFemale);
        radBtnIndividual = (RadioButton) findViewById(R.id.radButtonIndPassIndividual);
        radBtnMale = (RadioButton) findViewById(R.id.radioButtonIndPassMale);
        radBtnMarried = (RadioButton) findViewById(R.id.radioButtonIndPassMarried);
        radBtnSingle = (RadioButton) findViewById(R.id.radioButtonIndPassSignle);
        radBtnVehicle = (RadioButton) findViewById(R.id.radButtonIndPassVehicle);
        chkBoxSameAdd = (CheckBox) findViewById(R.id.checkboxIndPassSameAdd);
        spinnerCompany = (Spinner) findViewById(R.id.spinnerIndPassCompany);
        spinnerDate = (Spinner) findViewById(R.id.spinnerIndPassDate);
        spinnerIDProof = (Spinner) findViewById(R.id.spinnerIndPassIDProof);
        spinnerMonth = (Spinner) findViewById(R.id.spinnerIndPassMonth);
        spinnerPassCategory = (Spinner) findViewById(R.id.spinnerIndPassPassCategory);
        spinnerState = (Spinner) findViewById(R.id.spinnerIndPassState);
        spinnerPassPeriod = (Spinner) findViewById(R.id.spinnerVehPassPassPeriod);
        spinnerYear = (Spinner) findViewById(R.id.spinnerIndPassYear);
        //txtIdProofPath = (TextView) findViewById(R.id.tvNPPhotoPath)
        btnSubmit = (Button) findViewById(R.id.buttonIndPassSubmit);
        btnCancel = (Button) findViewById(R.id.buttonIndPassCancel);
        imgAddCompany = (ImageView) findViewById(R.id.imgbuttonIndPassAddComp);

        // Clickable Codes

        btnSubmit.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        radBtnIndividual.setOnClickListener(this);
        radBtnVehicle.setOnClickListener(this);
        imgAddCompany.setOnClickListener(this);

        txtPreAdd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (chkBoxSameAdd.isChecked()) {
                    txtPerAdd.setText(txtPreAdd.getText());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        chkBoxSameAdd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    txtPerAdd.setText("");
                    //txtPerAdd.requestFocus();
                } else if (isChecked) {
                    txtPerAdd.setText(txtPreAdd.getText());
                }
            }
        });


        // On lost Focus changed
        txtRefNo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });


        //Class Initialisations
        allFunctions = new AllFunctions(this);
        dataBaseHelper = new DataBaseHelper(this);

        //Initilisation
        dateStr = new ArrayList<>();
        monthStr = new ArrayList<>();
        yearStr = new ArrayList<>();
        companyList = new ArrayList<>();

        txtRequestDate.setText(allFunctions.getCurrentDate());

        // Loading array datas to values
        dateStr = allFunctions.LoadingDates();
        monthStr = allFunctions.LoadingMonths();
        yearStr = allFunctions.LoadingYears();
        companyList = dataBaseHelper.getCompanyList();


        // Adapters
        arrayAdapterPassCategory = ArrayAdapter.createFromResource(getApplicationContext(), R.array.PassCategory, R.layout.layout_text_view);
        arrayAdapterPassPeriod = ArrayAdapter.createFromResource(getApplicationContext(), R.array.PassPeriod, R.layout.layout_text_view);
        arrayAdapterIdProofList = ArrayAdapter.createFromResource(getApplicationContext(), R.array.IdProofType, R.layout.layout_text_view);

        arrayAdapterDate = new ArrayAdapter<String>(getApplicationContext(), R.layout.layout_text_view, R.id.text1, dateStr);
        arrayAdapterMonth = new ArrayAdapter<String>(getApplicationContext(), R.layout.layout_text_view, R.id.text1, monthStr);
        arrayAdapterYear = new ArrayAdapter<String>(getApplicationContext(), R.layout.layout_text_view, R.id.text1, yearStr);
        arrayAdapterCompanyNames = new ArrayAdapter<String>(getApplicationContext(), R.layout.layout_text_view, R.id.text1, companyList);

        // Set Adapters
        spinnerPassCategory.setAdapter(arrayAdapterPassCategory);
        spinnerPassPeriod.setAdapter(arrayAdapterPassPeriod);
        spinnerIDProof.setAdapter(arrayAdapterIdProofList);

        spinnerDate.setAdapter(arrayAdapterDate);
        spinnerMonth.setAdapter(arrayAdapterMonth);
        spinnerYear.setAdapter(arrayAdapterYear);

        spinnerCompany.setAdapter(arrayAdapterCompanyNames);

        // txtRefNo.setText(String.valueOf(dataBaseHelper.LastGPNo()));

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonIndPassSubmit:
                String selectedPass_Type = null, selectedGender = null, selectedMaritalStatus = null;

                if (radBtnIndividual.isChecked()) {
                    selectedPass_Type = "Individual";
                } else if (radBtnVehicle.isChecked()) {
                    selectedPass_Type = "Vehicle";
                }

                if (radBtnSingle.isChecked()) {
                    selectedMaritalStatus = "Single";
                } else if (radBtnMarried.isChecked()) {
                    selectedMaritalStatus = "Married";
                }

                if (radBtnMale.isChecked()) {
                    selectedGender = "Male";
                } else if (radBtnFemale.isChecked()) {
                    selectedGender = "Female";
                }


                dataBaseHelper.insertNewIndividualGatePass("1", "1", txtRefNo.getText().toString().trim(), selectedPass_Type, spinnerPassCategory.getSelectedItem().toString(),
                        spinnerPassPeriod.getSelectedItem().toString(), txtRequestDate.getText().toString(), "Testing", spinnerIDProof.getSelectedItem().toString()
                        , txtIDProofPath.getText().toString().trim(), txtIDProofNo.getText().toString(), txtFastName.getText().toString().trim(), txtLastName.getText().toString().trim()
                        , txtFrName.getText().toString().trim(), selectedGender, selectedMaritalStatus, txtPreAdd.getText().toString().trim(), txtPerAdd.getText().toString().trim()
                        , txtCity.getText().toString().trim(), "Not listed", txtPinCode.getText().toString(), txtLLCode.getText().toString(), txtLLNo.getText().toString()
                        , txtMobile.getText().toString(), txtPolicestation.getText().toString(), txtIDProofPath.getText().toString());
                Toast.makeText(getApplicationContext(), "DataBase Saved Successfully", Toast.LENGTH_SHORT).show();

                // Clear Form


                break;
            case R.id.buttonIndPassCancel:
                ClearForm();
                Toast.makeText(getApplicationContext(), "Cleared", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radButtonIndPassIndividual:

                break;
            case R.id.radButtonIndPassVehicle:
                Intent intentVehicle = new Intent(getApplicationContext(), New_Vehicle_Pass.class);
                startActivity(intentVehicle);
                break;
            case R.id.imgbuttonIndPassAddComp:
                Intent intentAddCompany = new Intent(getApplicationContext(), New_Company_Add.class);
                startActivity(intentAddCompany);
                break;


        }
    }

    private void ClearForm() {
        txtRefNo.setText("");
        spinnerPassCategory.setSelection(0);
        spinnerPassPeriod.setSelection(0);
        spinnerCompany.setSelection(0);
        spinnerIDProof.setSelection(0);
        txtIDProofNo.setText("");
        txtFastName.setText("");
        txtLastName.setText("");
        txtFrName.setText("");
        spinnerDate.setSelection(0);
        spinnerMonth.setSelection(0);
        spinnerYear.setSelection(0);
        txtPerAdd.setText("");
        txtPreAdd.setText("");
        txtCity.setText("");
        txtPinCode.setText("");
        txtLLCode.setText("");
        txtLLNo.setText("");
        txtMobile.setText("");
        txtPolicestation.setText("");
        txtIDProofPath.setText("");

    }

    public void ValidatingControls() {

    }
}

