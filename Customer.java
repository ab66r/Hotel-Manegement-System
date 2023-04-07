package hotelmanegementsystem;

import java.util.Date;
import java.util.Objects;

public class Customer {

    private String firstName;
    private String lastName;
    private String phone;
    private long nationalNumber;
    private String nationality;
    private Date DOB;// date of birth

    //Constructors
    public Customer(String firstName, String lastName, String phone, long nationalNumber, String nationality, Date DOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.nationalNumber = nationalNumber;
        this.nationality = nationality;
        this.DOB = DOB;
    }

    public Customer() {
        this.firstName = "";
        this.lastName = "";
        this.phone = "";
        this.nationalNumber = 0;
        this.nationality = "";
        this.DOB = new Date("1-1-1960"); //  make a virtual date
    }

    //Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setNationalNumber(long nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public long getNationalNumber() {
        return nationalNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public Date getDOB() {
        return DOB;
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (this.nationalNumber != other.nationalNumber) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.nationality, other.nationality)) {
            return false;
        }
        if (!Objects.equals(this.DOB, other.DOB)) {
            return false;
        }
        return true;
    }

    // tostring method
    @Override
    public String toString() {
        return "Customer{" + "firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", nationalNumber=" + nationalNumber + ", nationality=" + nationality + ", DOB=" + DOB + '}';
    }

}
