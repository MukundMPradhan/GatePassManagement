package in.app.myandroid.gatepassmngtsystem.model;

/**
 * Created by mukund on 17/7/16.
 */

public class Company {
    private String compName, compAdd, contactPerson, contactNo;

    public Company(String compName, String compAdd, String contactPerson, String contactNo) {
        this.compAdd = compAdd;
        this.compName = compName;
        this.contactNo = contactNo;
        this.contactPerson = contactPerson;
    }

    public String getCompAdd() {
        return compAdd;
    }

    public Company setCompAdd(String compAdd) {
        this.compAdd = compAdd;
        return this;
    }

    public String getCompName() {
        return compName;
    }

    public Company setCompName(String compName) {
        this.compName = compName;
        return this;
    }

    public String getContactNo() {
        return contactNo;
    }

    public Company setContactNo(String contactNo) {
        this.contactNo = contactNo;
        return this;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public Company setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }
}
