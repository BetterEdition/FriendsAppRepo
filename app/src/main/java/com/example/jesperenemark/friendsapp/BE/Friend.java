package com.example.jesperenemark.friendsapp.BE;
/**
 * Created by robiesun on 12/03/2018.
 */

public class Friend {

    public int Id;
    public String FirstName;
    public String LastName;
    public String Address;
    public String Location;
    public String PhoneNumber;
    public String MailAddress;
    public String Website;
    public String Picture;
    public String BirthDate;
    public String Image;

    public Friend(int id,String firstName, String lastName, String address, String phoneNumber, String mailAddress, String img ) {
        this.Id = id;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Address = address;
        this.PhoneNumber = phoneNumber;
        this.MailAddress = mailAddress;
        this.Image = img;

    }


    public int getId() { return Id;}

    public String getfirstName() { return FirstName; }
    public void setfirstName(String firstName) {this.FirstName = firstName;}

    public String getlastName() { return LastName; }
    public void setlasName(String lastName) {this.LastName = lastName;}

    public String getAddress() { return Address; }
    public void setAddress(String address) {this.Address = address;}

    public String getLocation() { return Location; }
    public void setLocation(String location) {this.Location = location;}

    public String getPhoneNumber() { return PhoneNumber; }
    public void setPhoneNumber(String phoneN) {this.PhoneNumber = phoneN;}

    public String getMailAddress() { return MailAddress; }
    public void setMailAddress(String mailAdd) {this.MailAddress = mailAdd;}

    public String getWebsite() { return Website; }
    public void setWebsite(String website) {this.Website = website;}

    public String getPicture() { return Picture; }

    public String getBirthDate() { return BirthDate; }
    public void setBirthDate(String birthD) {this.BirthDate = birthD; }

    public String getName() {
        return FirstName + " "+ LastName;
    }

    public String getImage() { return Image; }
    public void setImage(String image) { this.Image = image; }


    public String toString() {
        return "" + Id + ": " + FirstName + " " + LastName + " " + Address + " " + PhoneNumber + " " + MailAddress + " " + BirthDate;
    }
}