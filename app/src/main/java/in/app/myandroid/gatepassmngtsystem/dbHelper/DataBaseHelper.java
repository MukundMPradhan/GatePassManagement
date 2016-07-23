package in.app.myandroid.gatepassmngtsystem.dbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.security.PublicKey;
import java.util.ArrayList;

import in.app.myandroid.gatepassmngtsystem.model.Company;
import in.app.myandroid.gatepassmngtsystem.model.LoginUser;
import in.app.myandroid.gatepassmngtsystem.model.NewPass;

/**
 * Created by mukund on 27/6/16.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    // user data base

    private static final String DB_NAME = "GpMngtDb";
    private static final int DB_VERSION = 1;
    //TABLES
    private static final String TABLE_USERDETAILS = "user_details";
    private static final String TABLE_GATEPASS = "gatepass";
    private static final String TABLE_COMPANY_DETAILS = "company_details";
    //private static final String TABLE_PASSTYPE = "passtype";

    //Table Columns
    private static final String COL_ID = "id";
    private static final String COL_USERID = "user_id";
    private static final String COL_USERNAME = "user_name";
    private static final String COL_PASSWORD = "password";
    private static final String COL_ROLE = "role";
    private static final String COL_FASTNAME = "f_name";
    private static final String COL_LASTNAME = "l_name";
    private static final String COL_FRNAME = "fr_name";
    private static final String COL_GENDER = "gender";
    private static final String COL_DOB = "date_of_birth";
    private static final String COL_MOB_NO = "mob_no";
    private static final String COL_MRSTATUS = "mr_status";
    private static final String COL_PRESENT_ADD = "present_add";
    private static final String COL_PERMANENT_ADD = "permanent_add";
    private static final String COL_STATE = "state";
    private static final String COL_PINCODE = "pincode";
    private static final String COL_STD = "std_isd";
    private static final String COL_LAND_LINE = "land_line";
    private static final String COL_MOB = "mobile";
    private static final String COL_POLICE_STATION = "police";
    private static final String COL_PHOTO_PATH = "photo_path";
    private static final String COL_EMAIL = "email";
    private static final String COL_LOGIN_STATUS = "login_status";
    private static final String COL_USER_SIGN = "user_sign";
    private static final String COL_APP_ID = "applicant_id";
    private static final String COL_REF_ID = "ref_id";
    private static final String COL_PASS_TYPE = "pass_type";
    private static final String COL_PASS_CATEGORY = "pass_category";
    private static final String COL_PASS_PERIOD = "pass_period";
    private static final String COL_REQ_DATE = "requestdate";
    private static final String COL_COMP_NAME = "company_name";
    private static final String COL_VEHICLE_TYPE = "vehicle_type";
    private static final String COL_VEHICLE_NAME = "vehicle_name";
    private static final String COL_LIC_NO = "lc_no";
    private static final String COL_REG_NO = "reg_no";
    private static final String COL_OWNER_NAME = "owner_name";
    private static final String COL_ID_PROOF_TYPE = "id_proof_type";
    private static final String COL_ID_NO = "id_no";
    private static final String COL_GUARD_STATUS = "guard_status";
    private static final String COL_MASTER_STATUS = "admin_status";
    private static final String COL_MOD_STATUS = "moderator_status";
    private static final String COL_REJECT_REASON = "reject_reason";
    private static final String COL_ACCEPT_DATE = "accept_date";
    private static final String COL_MOD_SIGN = "mod_sign";
    private static final String COL_NOC = "noc";
    private static final String COL_OWNER_PHOTO = "owner_photo";
    private static final String COL_CITY = "city";
    private static final String COL_ID_PROOF_PATH = "id_proof_path";
    private static final String COL_MANAGER_SIGN = "manager_sig";

    private static final String COL_ADDRESS = "address";
    private static final String COL_CONTACT_PERSON = "contact_person";
    private static final String COL_CONTACT_NO = "contact_person_no";

    //

    private static final String create_UserDetails_Table = "CREATE TABLE " + TABLE_USERDETAILS +
            " (" + COL_ID + " INTEGER PRIMARY KEY," + " "
            + COL_USERID + " TEXT," + " "
            + COL_FASTNAME + " TEXT," + " "
            + COL_LASTNAME + " TEXT," + " "
            + COL_FRNAME + " TEXT," + " "
            + COL_GENDER + " TEXT," + " "
            + COL_DOB + " TEXT," + " "
            + COL_MOB_NO + " TEXT," + " "
            + COL_PHOTO_PATH + " TEXT," + " "
            + COL_EMAIL + " TEXT," + " "
            + COL_ROLE + " TEXT," + " "
            + COL_LOGIN_STATUS + " TEXT," + " "
            + COL_PASSWORD + " TEXT);";

    private static final String insertMaster = "INSERT INTO " + TABLE_USERDETAILS +
            "(" + COL_ID + ", " +
            COL_USERID + ", " +
            COL_FASTNAME + ", " +
            COL_LASTNAME + ", " +
            COL_FRNAME + ", " +
            COL_GENDER + ", " +
            COL_DOB + ", " +
            COL_MOB_NO + ", " +
            COL_PHOTO_PATH + ", " +
            COL_EMAIL + ", " +
            COL_ROLE + ", " +
            COL_LOGIN_STATUS + ", " +
            COL_PASSWORD + ") " +
            "VALUES(" + 1 + ", 'Master', NULL, NULL, NULL,'Male',NULL,'9099975177',NULL,'replyme.mmp@gmail.com', 'Master', NULL, 'master');";


    private static final String create_GatePassTable = "CREATE TABLE " + TABLE_GATEPASS +
            " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + " "
            + COL_APP_ID + " TEXT," + " "
            + COL_REF_ID + " TEXT," + " "
            + COL_FASTNAME + " TEXT," + " "
            + COL_LASTNAME + " TEXT," + " "
            + COL_FRNAME + " TEXT," + " "
            + COL_GENDER + " TEXT," + " "
            + COL_DOB + " TEXT," + " "
            + COL_MRSTATUS + " TEXT," + " "
            + COL_PRESENT_ADD + " TEXT," + " "
            + COL_PERMANENT_ADD + " TEXT," + " "
            + COL_STATE + " TEXT," + " "
            + COL_PINCODE + " TEXT," + " "
            + COL_STD + " TEXT," + " "
            + COL_LAND_LINE + " TEXT," + " "
            + COL_MOB_NO + " TEXT," + " "
            + COL_POLICE_STATION + " TEXT," + " "
            + COL_PHOTO_PATH + " TEXT," + " "
            + COL_PASS_TYPE + " TEXT," + " "
            + COL_PASS_CATEGORY + " TEXT," + " "
            + COL_PASS_PERIOD + " TEXT," + " "
            + COL_REQ_DATE + " TEXT," + " "
            + COL_COMP_NAME + " TEXT," + " "
            + COL_VEHICLE_TYPE + " TEXT," + " "
            + COL_VEHICLE_NAME + " TEXT," + " "
            + COL_LIC_NO + " TEXT," + " "
            + COL_REG_NO + " TEXT," + " "
            + COL_OWNER_NAME + " TEXT," + " "
            + COL_ID_PROOF_TYPE + " TEXT," + " "
            + COL_ID_NO + " TEXT," + " "
            + COL_GUARD_STATUS + " TEXT," + " "
            + COL_MASTER_STATUS + " TEXT," + " "
            + COL_MOD_STATUS + " TEXT," + " "
            + COL_REJECT_REASON + " TEXT," + " "
            + COL_ACCEPT_DATE + " TEXT," + " "
            + COL_MOD_SIGN + " TEXT," + " "
            + COL_NOC + " TEXT," + " "
            + COL_OWNER_PHOTO + " TEXT," + " "
            + COL_CITY + " TEXT," + " "
            + COL_ID_PROOF_PATH + " TEXT," + " "
            + COL_MANAGER_SIGN + " TEXT);";


    private static final String create_Company_Details_Table = "CREATE TABLE " + TABLE_COMPANY_DETAILS +
            " (" + COL_ID + " INTEGER PRIMARY KEY," + " "
            + COL_COMP_NAME + " TEXT ," + " "
            + COL_ADDRESS + " TEXT," + " "
            //     + COL_USERNAME + " TEXT," + " "
            + COL_CONTACT_PERSON + " TEXT," + " "
            + COL_CONTACT_NO + " TEXT );";


    SQLiteDatabase database;

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(create_UserDetails_Table);
        db.execSQL(create_GatePassTable);
        db.execSQL(create_Company_Details_Table);


        // Insert data

        db.execSQL(insertMaster);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS" + TABLE_USERDETAILS);
        database.execSQL("DROP TABLE IF EXISTS" + TABLE_GATEPASS);

    }

    public void insertUser(String id, String password, String role, String fastName, String lastName, String frName, String gender,
                           String dob, String mobNo, String photoPath, String email) {

        database = getWritableDatabase();


        ContentValues values = new ContentValues();

        values.put(COL_USERID, id);
        values.put(COL_PASSWORD, password);
        values.put(COL_ROLE, role);
        values.put(COL_FASTNAME, fastName);
        values.put(COL_LASTNAME, lastName);
        values.put(COL_FRNAME, frName);
        values.put(COL_GENDER, gender);
        values.put(COL_DOB, dob);
        values.put(COL_MOB_NO, mobNo);
        values.put(COL_PHOTO_PATH, photoPath);
        values.put(COL_EMAIL, email);


        try {
            database.insert(TABLE_USERDETAILS, null, values);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            database.close();
        }


    }


    public ArrayList<LoginUser> getAllUserStaffs() {
        database = getReadableDatabase();

        ArrayList<LoginUser> loginUsers = new ArrayList<>();

        String select_all = "Select * from " + TABLE_USERDETAILS;

        Cursor cursor = database.rawQuery(select_all, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String uName = cursor.getString(1);
                String uPassword = cursor.getString(9);

                LoginUser loginUser = new LoginUser(uName, uPassword);

                loginUsers.add(loginUser);

            } while (cursor.moveToNext());
        }
        database.close();

        return loginUsers;


    }

    public ArrayList<Company> getAllCompanyList() {

        ArrayList<Company> companyList = new ArrayList<>();

        database = getReadableDatabase();

        String sql = "SELECT * FROM " + TABLE_COMPANY_DETAILS + ";";

        Cursor cursor = database.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                String comp_name = cursor.getString(1);
                String comp_add = cursor.getString(2);
                String comp_cont_person = cursor.getString(3);
                String cont_mob = cursor.getString(4);

                Company company = new Company(comp_name, comp_add, comp_cont_person, cont_mob);

                companyList.add(company);

            } while (cursor.moveToNext());
        }

        database.close();
        return companyList;
    }

    public ArrayList<String> getCompanyList() {

        database = getReadableDatabase();

        ArrayList<String> arrayList = new ArrayList<>();


        String sql = "select " + COL_COMP_NAME + " from " + TABLE_COMPANY_DETAILS + ";";

        Cursor cursor = database.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                String compName = cursor.getString(0);
                arrayList.add(compName);
            } while (cursor.moveToNext());

        }

        return arrayList;
    }


    public String getUserSearchEntry(String userName) {

        database = getReadableDatabase();

        Cursor cursor = database.query(TABLE_USERDETAILS, null, COL_USERID + "=?",
                new String[]{userName}, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex(COL_PASSWORD));
        cursor.close();
        return password;
    }

    public String getMasterUserName(String userID) {
        database = getReadableDatabase();

        Cursor cursor = database.query(TABLE_USERDETAILS, null, COL_USERID + "=? AND " + COL_ROLE + "='Master'",
                new String[]{userID}, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String un = cursor.getString(cursor.getColumnIndex(COL_USERID));
        cursor.close();
        return un;
    }

    public String getMasterUserPassword(String userName) {
        database = getReadableDatabase();

        Cursor cursor = database.query(TABLE_USERDETAILS, null, COL_PASSWORD + "=? AND " + COL_ROLE + "='Master'",
                new String[]{userName}, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String pw = cursor.getString(cursor.getColumnIndex(COL_PASSWORD));
        cursor.close();
        return pw;
    }

    public ArrayList<NewPass> getAllGatePasses() {
        database = getReadableDatabase();

        ArrayList<NewPass> allPasses = new ArrayList<>();

        String select_all = "Select * from " + TABLE_GATEPASS;

        Cursor cursor = database.rawQuery(select_all, null);

        if (cursor.moveToFirst()) {
            do {
                String ref_id = cursor.getString(2);
                String userName = cursor.getString(3);
                String dob = cursor.getString(8);
                String email = cursor.getString(19);
                String fastName = cursor.getString(4);
                String frName = cursor.getString(5);
                String gender = cursor.getString(7);
                String landLine = cursor.getString(15);
                String lastName = cursor.getString(6);
                String loginStatus = cursor.getString(21);
                String mobNo = cursor.getString(16);
                String mrStatus = cursor.getString(9);
                String perAdd = cursor.getString(11);
                String photoPath = cursor.getString(18);
                String pin = cursor.getString(13);
                String policeStation = cursor.getString(17);
                String preAdd = cursor.getString(10);
                String role = cursor.getString(20);
                String state = cursor.getString(12);
                String std = cursor.getString(14);
                String userSign = cursor.getString(22);


                // NewPass newPass = new NewPass(dob, email, fastName, frName, gender, ref_id, landLine, lastName, loginStatus, mobNo,
                //  mrStatus, perAdd, photoPath, pin, policeStation, preAdd, role, state, std, userName, userSign);
                ;

                // allPasses.add(newPass);

            } while (cursor.moveToNext());
        }

        cursor.close();
        return allPasses;
    }


    public void insertNewIndividualGatePass
            (String id, String app_id, String ref_id, String pass_type, String pass_category,
             String pass_period, String req_date, String comp_name, String id_ProofType, String idProof_Path, String id_no,
             String fast_name, String last_name, String fr_name, String gender, String mr_status, String pre_add, String per_add, String city,
             String state, String pincode, String std_code, String land_line, String mob, String police, String photo_path) {

        //String date_of_birth, String vehicle_name, String vehicle_type, String lic_no, String reg_no, String owner_name, String guard_status, String mod_status, String reject_rejon,
        //String accept_date, String mod_sign, String noc, String owner_photo,String id_proof_no, String manager_sign) {
        database = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_ID, id);
        contentValues.put(COL_APP_ID, app_id);
        contentValues.put(COL_REF_ID, ref_id);
        contentValues.put(COL_FASTNAME, fast_name);
        contentValues.put(COL_LASTNAME, last_name);
        contentValues.put(COL_FRNAME, fr_name);
        contentValues.put(COL_GENDER, gender);
        // contentValues.put(COL_DOB, date_of_birth);
        contentValues.put(COL_MRSTATUS, mr_status);
        contentValues.put(COL_PRESENT_ADD, pre_add);
        contentValues.put(COL_PERMANENT_ADD, per_add);
        contentValues.put(COL_STATE, state);
        contentValues.put(COL_PINCODE, pincode);
        contentValues.put(COL_STD, std_code);
        contentValues.put(COL_LAND_LINE, land_line);
        contentValues.put(COL_MOB_NO, mob);
        contentValues.put(COL_POLICE_STATION, police);
        contentValues.put(COL_PHOTO_PATH, photo_path);
        contentValues.put(COL_PASS_TYPE, pass_type);
        contentValues.put(COL_PASS_CATEGORY, pass_category);
        contentValues.put(COL_PASS_PERIOD, pass_period);
        contentValues.put(COL_REQ_DATE, req_date);
        contentValues.put(COL_COMP_NAME, comp_name);
        //  contentValues.put(COL_VEHICLE_NAME, vehicle_name);
        // contentValues.put(COL_VEHICLE_TYPE, vehicle_type);
        // contentValues.put(COL_LIC_NO, lic_no);
        // contentValues.put(COL_REG_NO, reg_no);
        //  contentValues.put(COL_OWNER_NAME, owner_name);
        contentValues.put(COL_ID_PROOF_TYPE, id_ProofType);
        contentValues.put(COL_ID_NO, id_no);
        //  contentValues.put(COL_GUARD_STATUS, guard_status);
        //  contentValues.put(COL_MOD_STATUS, mod_status);
        //  contentValues.put(COL_REJECT_REASON, reject_rejon);
        //  contentValues.put(COL_ACCEPT_DATE, accept_date);
        // contentValues.put(COL_MOD_SIGN, mod_sign);
        // contentValues.put(COL_NOC, noc);
        // contentValues.put(COL_OWNER_PHOTO, owner_photo);
        //  contentValues.put(COL_CITY, city);
        //  contentValues.put(COL_ID_PROOF_NO, id_proof_no);
        // contentValues.put(COL_MANAGER_SIGN, manager_sign);

        try {
            database.insert(TABLE_GATEPASS, null, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            database.close();
        }

    }

    public void insertNewVehicleGatePass
            (String id, String app_id, String ref_id, String pass_type,
             String pass_period, String req_date, String comp_name, String vehicle_type, String vehicle_make, String lic_no, String reg_no,
             String owner_name, String owner_photo, String auth_letter_path, String rc_book, String insurance,
             String safety_cert, String fast_name, String last_name, String fr_name, String date_of_birth, String pre_add,
             String per_add, String city, String state, String pincode, String std_code, String land_line, String mob,
             String police, String photo_path) {

        //String date_of_birth, String vehicle_name, String vehicle_type, String lic_no, String reg_no, String owner_name, String guard_status, String mod_status, String reject_rejon,
        //String accept_date, String mod_sign, String noc, String owner_photo,String id_proof_no, String manager_sign) {
        database = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_ID, id);
        contentValues.put(COL_APP_ID, app_id);
        contentValues.put(COL_REF_ID, ref_id);
        contentValues.put(COL_PASS_TYPE, pass_type);
        contentValues.put(COL_VEHICLE_TYPE, vehicle_type);
        contentValues.put(COL_VEHICLE_NAME, vehicle_make);
        contentValues.put(COL_LIC_NO, lic_no);
        contentValues.put(COL_REG_NO, reg_no);
        contentValues.put(COL_OWNER_NAME, owner_name);
        contentValues.put(COL_OWNER_PHOTO, owner_photo);
        //contentValues.put(Col_A);
        contentValues.put(COL_FASTNAME, fast_name);
        contentValues.put(COL_LASTNAME, last_name);
        contentValues.put(COL_FRNAME,fr_name);
        contentValues.put(COL_PRESENT_ADD, pre_add);
        contentValues.put(COL_PERMANENT_ADD, per_add);
        contentValues.put(COL_STATE, state);
        contentValues.put(COL_PINCODE, pincode);
        contentValues.put(COL_STD, std_code);
        contentValues.put(COL_LAND_LINE, land_line);
        contentValues.put(COL_MOB_NO, mob);
        contentValues.put(COL_POLICE_STATION, police);
        contentValues.put(COL_PHOTO_PATH, photo_path);
        contentValues.put(COL_PASS_TYPE, pass_type);
        contentValues.put(COL_PASS_PERIOD, pass_period);
        contentValues.put(COL_REQ_DATE, req_date);
        contentValues.put(COL_COMP_NAME, comp_name);


        try {
            database.insert(TABLE_GATEPASS, null, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            database.close();
        }

    }

    public Integer LastGPNo() {
        Cursor cursor = database.query("Select Max(ref_id) from " + TABLE_GATEPASS + " where " + COL_PASS_TYPE + "= Individual", null, null, null, null, null, null);
        int maxid;

        if (cursor.getCount() < 1) {
            cursor.close();

        }
        cursor.moveToFirst();
        String ref_id = cursor.getString(cursor.getColumnIndex(COL_REF_ID));
        maxid = Integer.parseInt(ref_id) + 1;
        cursor.close();
        return maxid;

    }

    public void insertCompany(String compName, String compAdd, String contactPerson, String contactNo) {

        database = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_COMP_NAME, compName);
        values.put(COL_ADDRESS, compAdd);
        values.put(COL_CONTACT_PERSON, contactPerson);
        values.put(COL_CONTACT_NO, contactNo);

        try {
            database.insert(TABLE_COMPANY_DETAILS, null, values);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            database.close();
        }


    }


}



