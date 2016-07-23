package in.app.myandroid.gatepassmngtsystem.model;

/**
 * Created by mukund on 7/7/16.
 */
public class NewPass {
    private String id, app_id, ref_id, fast_name, last_name, fr_name, gender, date_of_birth, mr_status, pre_add, per_add, state, pincode, std_code,
            land_line, mobile, police_station, photo_path, pass_type, pass_category, pass_period, req_date, comp_name, veh_type, veh_name, lic_no,
            reg_no, owner_name, id_proof, id_no, guard_status, mod_status, reject_rejon, accept_date, mod_sign, noc, owner_photo, city, id_proof_no, manager_sign;

    public NewPass(String id, String app_id, String ref_id, String fast_name, String last_name, String fr_name, String gender,
                   String date_of_birth, String mr_status, String pre_add, String per_add, String state, String pincode,
                   String std_code, String reg_no, String owner_name, String id_proof, String id_no, String guard_status,
                   String mod_status, String reject_rejon, String accept_date, String mod_sign, String noc, String owner_photo,
                   String city, String id_proof_no, String manager_sign) {
        this.id = id;
        this.app_id = app_id;
        this.ref_id = ref_id;
        this.fast_name = fast_name;
        this.last_name = last_name;
        this.fr_name = fr_name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.mr_status = mr_status;
        this.pre_add = pre_add;
        this.per_add = per_add;
        this.state = state;
        this.pincode = pincode;
        this.std_code = std_code;
        this.reg_no = reg_no;
        this.owner_name = owner_name;
        this.id_proof = id_proof;
        this.id_no = id_no;
        this.guard_status = guard_status;
        this.mod_status = mod_status;
        this.reject_rejon = reject_rejon;
        this.accept_date = accept_date;
        this.mod_sign = mod_sign;
        this.noc = noc;
        this.owner_photo = owner_photo;
        this.city = city;
        this.id_proof_no = id_proof_no;
        this.manager_sign = manager_sign;
    }

    public String getAccept_date() {
        return accept_date;
    }

    public NewPass setAccept_date(String accept_date) {
        this.accept_date = accept_date;
        return this;
    }

    public String getApp_id() {
        return app_id;
    }

    public NewPass setApp_id(String app_id) {
        this.app_id = app_id;
        return this;
    }

    public String getCity() {
        return city;
    }

    public NewPass setCity(String city) {
        this.city = city;
        return this;
    }

    public String getComp_name() {
        return comp_name;
    }

    public NewPass setComp_name(String comp_name) {
        this.comp_name = comp_name;
        return this;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public NewPass setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
        return this;
    }

    public String getFast_name() {
        return fast_name;
    }

    public NewPass setFast_name(String fast_name) {
        this.fast_name = fast_name;
        return this;
    }

    public String getFr_name() {
        return fr_name;
    }

    public NewPass setFr_name(String fr_name) {
        this.fr_name = fr_name;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public NewPass setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getGuard_status() {
        return guard_status;
    }

    public NewPass setGuard_status(String guard_status) {
        this.guard_status = guard_status;
        return this;
    }

    public String getId() {
        return id;
    }

    public NewPass setId(String id) {
        this.id = id;
        return this;
    }

    public String getId_no() {
        return id_no;
    }

    public NewPass setId_no(String id_no) {
        this.id_no = id_no;
        return this;
    }

    public String getId_proof() {
        return id_proof;
    }

    public NewPass setId_proof(String id_proof) {
        this.id_proof = id_proof;
        return this;
    }

    public String getId_proof_no() {
        return id_proof_no;
    }

    public NewPass setId_proof_no(String id_proof_no) {
        this.id_proof_no = id_proof_no;
        return this;
    }

    public String getLand_line() {
        return land_line;
    }

    public NewPass setLand_line(String land_line) {
        this.land_line = land_line;
        return this;
    }

    public String getLast_name() {
        return last_name;
    }

    public NewPass setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public String getLic_no() {
        return lic_no;
    }

    public NewPass setLic_no(String lic_no) {
        this.lic_no = lic_no;
        return this;
    }

    public String getManager_sign() {
        return manager_sign;
    }

    public NewPass setManager_sign(String manager_sign) {
        this.manager_sign = manager_sign;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public NewPass setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getMod_sign() {
        return mod_sign;
    }

    public NewPass setMod_sign(String mod_sign) {
        this.mod_sign = mod_sign;
        return this;
    }

    public String getMod_status() {
        return mod_status;
    }

    public NewPass setMod_status(String mod_status) {
        this.mod_status = mod_status;
        return this;
    }

    public String getMr_status() {
        return mr_status;
    }

    public NewPass setMr_status(String mr_status) {
        this.mr_status = mr_status;
        return this;
    }

    public String getNoc() {
        return noc;
    }

    public NewPass setNoc(String noc) {
        this.noc = noc;
        return this;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public NewPass setOwner_name(String owner_name) {
        this.owner_name = owner_name;
        return this;
    }

    public String getOwner_photo() {
        return owner_photo;
    }

    public NewPass setOwner_photo(String owner_photo) {
        this.owner_photo = owner_photo;
        return this;
    }

    public String getPass_category() {
        return pass_category;
    }

    public NewPass setPass_category(String pass_category) {
        this.pass_category = pass_category;
        return this;
    }

    public String getPass_period() {
        return pass_period;
    }

    public NewPass setPass_period(String pass_period) {
        this.pass_period = pass_period;
        return this;
    }

    public String getPass_type() {
        return pass_type;
    }

    public NewPass setPass_type(String pass_type) {
        this.pass_type = pass_type;
        return this;
    }

    public String getPer_add() {
        return per_add;
    }

    public NewPass setPer_add(String per_add) {
        this.per_add = per_add;
        return this;
    }

    public String getPhoto_path() {
        return photo_path;
    }

    public NewPass setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
        return this;
    }

    public String getPincode() {
        return pincode;
    }

    public NewPass setPincode(String pincode) {
        this.pincode = pincode;
        return this;
    }

    public String getPolice_station() {
        return police_station;
    }

    public NewPass setPolice_station(String police_station) {
        this.police_station = police_station;
        return this;
    }

    public String getPre_add() {
        return pre_add;
    }

    public NewPass setPre_add(String pre_add) {
        this.pre_add = pre_add;
        return this;
    }

    public String getRef_id() {
        return ref_id;
    }

    public NewPass setRef_id(String ref_id) {
        this.ref_id = ref_id;
        return this;
    }

    public String getReg_no() {
        return reg_no;
    }

    public NewPass setReg_no(String reg_no) {
        this.reg_no = reg_no;
        return this;
    }

    public String getReject_rejon() {
        return reject_rejon;
    }

    public NewPass setReject_rejon(String reject_rejon) {
        this.reject_rejon = reject_rejon;
        return this;
    }

    public String getReq_date() {
        return req_date;
    }

    public NewPass setReq_date(String req_date) {
        this.req_date = req_date;
        return this;
    }

    public String getState() {
        return state;
    }

    public NewPass setState(String state) {
        this.state = state;
        return this;
    }

    public String getStd_code() {
        return std_code;
    }

    public NewPass setStd_code(String std_code) {
        this.std_code = std_code;
        return this;
    }

    public String getVeh_name() {
        return veh_name;
    }

    public NewPass setVeh_name(String veh_name) {
        this.veh_name = veh_name;
        return this;
    }

    public String getVeh_type() {
        return veh_type;
    }

    public NewPass setVeh_type(String veh_type) {
        this.veh_type = veh_type;
        return this;
    }
}
