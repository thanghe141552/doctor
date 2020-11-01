/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class valid {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public boolean checkName(String text) {
        return !(text.length() <= 0 || text.length() > 50);
    }

    public int getID(ArrayList<Doctor> list) {
        if (list.size() == 0) {
            return 1;
        } else {
            return (list.size() + 1);

        }
    }

    public String getName(String name) {      
        while (true) {
            try {
                System.out.print("Input the name of the doctor : ");
                name = in.readLine();
                if (!checkName(name)) {
                    throw new Exception();
                }
                return name;
            } catch (Exception e) {
                System.out.println("Name is not longer than 50 characters");
            }
        }
    }

    public Date getDateOfBirth() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dob;
        while (true) {
            try {
                System.out.print("Input Date Of Birth: ");
                String date = in.readLine();
                if (!checkDateOfBirthFormat(date)) {
                    throw new Exception();
                }
                sdf.setLenient(false);
                dob = sdf.parse(date);
                return dob;

            } catch (Exception ex) {
                System.out.println("Please reinput the date");
            }
        }
    }

    public String getSpecialization() {
        String spec;
        while (true) {
            try {
                System.out.print("Input the Specialization: ");
                spec = in.readLine();

                if (!checkSpecialization(spec)) {
                    throw new Exception();
                }
                return spec;
            } catch (Exception e) {
                System.out.println("Specialization is a string which is not longer than 255 characters.");
            }
        }
    }
    public boolean checkInt(int min,int max,int input){
        try {
           
            return !(input < min || input > max);
        } catch (Exception ex) {
            Logger.getLogger(valid.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
        
    }
    public int getInt(int min, int max) {
        int number;
        while (true) {
            try {

                number = Integer.parseInt(in.readLine());
                if (number < min || number > max) {
                    throw new NumberFormatException();
                }
                return number;
            } catch (Exception e) {
                System.out.println("Input only from 0-3");
            }
        }
    }

    public int getAvailability() {
        System.out.println("Choose the Availability: ");
        System.out.println("0.In vacation");
        System.out.println("1.Available");
        System.out.println("2.Busy in emergency");
        System.out.println("3.Diagnosing");
        System.out.print("-------Availability------ ");
        return getInt(0, 3);

    }

    public String getEmail() {
        String email;
        while (true) {
            try {
                System.out.print("Input the email: ");
                email = in.readLine();
                if (!checkEmailFormat(email)) {
                    throw new Exception();
                }
                return email;
            } catch (Exception e) {
                System.out.println("Wrong form email");
            }
        }
    }

    public String getPhoneNumber() {
        String phone;
        while (true) {
            try {
                System.out.print("Input the phone number conforming (000)-000-0000 format: ");
                phone = in.readLine();
                if (!checkPhoneNumberFormat(phone)) {
                    throw new Exception();
                }
                return phone;
            } catch (Exception e) {
                System.out.println("Input only 10 character");
            }
        }
    }
   
    public boolean checkDateOfBirthFormat(String text) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            
            sdf.parse(text);           
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkSpecialization(String text) {
        if((text.length() < 0 || text.length() > 255)){
            return false;
        }else if(text.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    public boolean checkEmailFormat(String text) {
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if(!text.matches(EMAIL_PATTERN)|| text.isEmpty()){
            return false;
        }else{
            return true;
        }
        
    }

    public boolean checkPhoneNumberFormat(String text) {
        if( !text.matches("\\d{10}") || text.isEmpty()){
           return false;
        }else{
            return true;
        }
    }
}
