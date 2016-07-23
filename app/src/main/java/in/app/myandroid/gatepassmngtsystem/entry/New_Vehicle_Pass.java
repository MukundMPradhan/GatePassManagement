package in.app.myandroid.gatepassmngtsystem.entry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
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

public class New_Vehicle_Pass extends AppCompatActivity {

    private EditText txtRefNo, txtPreAdd, txtPerAdd, txtCity, txtPinCode, txtLLCode, txtLLNo, txtMobile,
            txtPolicestation, txtFastName, txtLastName, txtFrName, txtIDProofNo, txtLicNo, txtRegNo, txtOwnersName, txtOwnerPhoto,
            txtAuthLetter, txtRCBook, txtInsurance, txtSafety;
    private TextView txtRequestDate, txtIDProofPath, txtPhotoPath;
    private RadioGroup radioGroupPassType, radioGroupGender, radioGroupMStatus;
    private RadioButton radBtnIndividual, radBtnVehicle, radBtnMale, radBtnFemale, radBtnSingle, radBtnMarried, radBtnLight, radBtnHeavy;
    private ImageView imgIDProofCam, imgPhotoCam, imgAddCompany;
    private CheckBox chkBoxSameAdd;
    private Spinner spinnerPassCategory, spinnerPassPeriod, spinnerCompany, spinnerIDProof, spinnerDate,
            spinnerMonth, spinnerYear, spinnerState, spinnerVehicleMake;
    private Button btnSubmit, btnCancel;
    private ImageView btnCompanyAdd;

    // Declaring Adapters
    private ArrayAdapter arrayAdapterPassCategory, arrayAdapterPassPeriod, arrayAdapterIdProofList;
    private ArrayAdapter<String> arrayAdapterDate, arrayAdapterMonth, arrayAdapterYear, arrayAdapterCompanyNames;
    //
    ArrayList<String> dateStr, monthStr, yearStr, companyList;

    AllFunctions allFunctions;
    DataBaseHelper dataBaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_vehicle_pass);


        txtRefNo = (EditText) findViewById(R.id.etVehPassRefNo);
        radBtnIndividual = (RadioButton) findViewById(R.id.radButtonVehPassIndividual);
        radBtnVehicle = (RadioButton) findViewById(R.id.radButtonVehPassVehicle);
        // spinnerPassCategory=(Spinner) findViewById(R.id.passcate)
        spinnerPassPeriod = (Spinner) findViewById(R.id.spinnerVehPassPassPeriod);
        txtRequestDate = (TextView) findViewById(R.id.tvVehPassRequestDate);
        spinnerCompany = (Spinner) findViewById(R.id.spinnerVehPassCompany);
        btnCompanyAdd = (ImageView) findViewById(R.id.buttonVehPassAddCompany);
        radBtnLight = (RadioButton) findViewById(R.id.radButtonVehPassLight);
        radBtnHeavy = (RadioButton) findViewById(R.id.radioButtonVehPassHeavy);
        spinnerVehicleMake = (Spinner) findViewById(R.id.spinnerVehPassVehicleMake);
        txtLicNo = (EditText) findViewById(R.id.etVehPassLicNo);
        txtRegNo = (EditText) findViewById(R.id.etVehPassRegNo);
        txtOwnersName = (EditText) findViewById(R.id.etVehPassOwnerName);
        txtOwnerPhoto = (EditText) findViewById(R.id.etVehPassOwnerPhoto);
        txtAuthLetter = (EditText) findViewById(R.id.etVehPassCHAAuthLetter);
        txtRCBook = (EditText) findViewById(R.id.etVehPassRCBook);
        txtInsurance = (EditText) findViewById(R.id.etVehPassInsurance);
        txtSafety = (EditText) findViewById(R.id.etVehPassSafetyCert);
        txtFastName = (EditText) findViewById(R.id.etVehPassFastName);
        txtLastName = (EditText) findViewById(R.id.etVehPassLastName);
        txtFrName = (EditText) findViewById(R.id.etVehPassFrName);
        radBtnMale = (RadioButton) findViewById(R.id.radioButtonVehPassMale);
        radBtnFemale = (RadioButton) findViewById(R.id.radioButtonVehPassFemale);
        spinnerDate = (Spinner) findViewById(R.id.spinnerVehPassDate);
        spinnerMonth = (Spinner) findViewById(R.id.spinnerVehPassMonth);
        spinnerYear = (Spinner) findViewById(R.id.spinnerVehPassYear);
        radBtnSingle = (RadioButton) findViewById(R.id.radioButtonVehPassSignle);
        radBtnMarried = (RadioButton) findViewById(R.id.radioButtonVehPassMarried);
        txtPreAdd = (EditText) findViewById(R.id.etVehPassPreAdd);
        txtPerAdd = (EditText) findViewById(R.id.etVehPassPerAdd);
        chkBoxSameAdd = (CheckBox) findViewById(R.id.checkboxVehPassSameAdd);
        txtCity = (EditText) findViewById(R.id.etVehPassCity);
        spinnerState = (Spinner) findViewById(R.id.spinnerVehPassState);
        txtPinCode = (EditText) findViewById(R.id.etVehPassPinCode);
        txtLLCode = (EditText) findViewById(R.id.etVehPassLandLineCode);
        txtLLNo = (EditText) findViewById(R.id.etVehPassLandLineNo);
        txtMobile = (EditText) findViewById(R.id.etVehPassMobile);
        txtPolicestation = (EditText) findViewById(R.id.etVehPassPoliceStation);
        txtPhotoPath = (TextView) findViewById(R.id.tvVehPassPhotoPath);
        btnSubmit = (Button) findViewById(R.id.buttonVehPassSubmit);
        btnCancel = (Button) findViewById(R.id.buttonVehPassCancel);



        radBtnIndividual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentIndividual = new Intent(getApplicationContext(), New_Individual_Pass.class);
                startActivity(intentIndividual);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBaseHelper.insertNewVehicleGatePass("2", "22", txtRefNo.getText().toString(), "Vehicle",
                        spinnerPassPeriod.getSelectedItem().toString(), txtRequestDate.getText().toString(),
                        spinnerCompany.getSelectedItem().toString(), "vhicle_type", "Honda", txtLicNo.getText().toString(),
                        txtRegNo.getText().toString(), txtOwnersName.getText().toString(), txtOwnerPhoto.getText().toString(),
                        txtAuthLetter.getText().toString(), txtRCBook.getText().toString(), txtInsurance.getText().toString(),
                        txtSafety.getText().toString(), txtFastName.getText().toString(), txtLastName.getText().toString(),
                        txtFrName.getText().toString(), spinnerDate.getSelectedItem().toString() +
                                spinnerMonth.getSelectedItem().toString() + spinnerYear.getSelectedItem().toString(),
                        txtPreAdd.getText().toString(), txtPerAdd.getText().toString(), txtCity.getText().toString(),
                        "to be select", txtPinCode.getText().toString(), "std", txtLLCode.getText().toString() +
                                txtLLNo.getText().toString(), txtMobile.getText().toString(), txtPolicestation.getText().toString(),
                        txtPhotoPath.getText().toString());
                Toast.makeText(getApplicationContext(), "Data has been saved sucessfully", Toast.LENGTH_SHORT).show();

                ;
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
        // arrayAdapterPassCategory = ArrayAdapter.createFromResource(getApplicationContext(), R.array.PassCategory, R.layout.layout_text_view);
        arrayAdapterPassPeriod = ArrayAdapter.createFromResource(getApplicationContext(), R.array.PassPeriod, R.layout.layout_text_view);
//        arrayAdapterIdProofList = ArrayAdapter.createFromResource(getApplicationContext(), R.array.IdProofType, R.layout.layout_text_view);

        arrayAdapterDate = new ArrayAdapter<String>(getApplicationContext(), R.layout.layout_text_view, R.id.text1, dateStr);
        arrayAdapterMonth = new ArrayAdapter<String>(getApplicationContext(), R.layout.layout_text_view, R.id.text1, monthStr);
        arrayAdapterYear = new ArrayAdapter<String>(getApplicationContext(), R.layout.layout_text_view, R.id.text1, yearStr);
        arrayAdapterCompanyNames = new ArrayAdapter<String>(getApplicationContext(), R.layout.layout_text_view, R.id.text1, companyList);

        // Set Adapters
        //  spinnerPassCategory.setAdapter(arrayAdapterPassCategory);
        spinnerPassPeriod.setAdapter(arrayAdapterPassPeriod);
//        spinnerIDProof.setAdapter(arrayAdapterIdProofList);

        spinnerDate.setAdapter(arrayAdapterDate);
        spinnerMonth.setAdapter(arrayAdapterMonth);
        spinnerYear.setAdapter(arrayAdapterYear);

        spinnerCompany.setAdapter(arrayAdapterCompanyNames);

    }


}
