/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the vator.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class process {

    valid va = new valid();
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    ArrayList<Doctor> list = new ArrayList<>();

    public int getInt(int min, int max) {
        int number;
        while (true) {
            try {
                number = Integer.parseInt(in.readLine());
                if (number < min || number > max) {
                    throw new NumberFormatException();
                } else {
                    System.out.println("Input success");
                    return number;
                }
            } catch (Exception e) {
                System.out.println("Input again");
            }
        }
    }

    public void add() {
        System.out.println("--Create Doctor");
        int id = va.getID(list);
        String name = va.getName("");
        Date dob = va.getDateOfBirth();
        String spec = va.getSpecialization();
        int avai = va.getAvailability();
        String email = va.getEmail();
        String phone = va.getPhoneNumber();
        Doctor d = new Doctor(id, name, dob, spec, avai, email, phone);
        list.add(d);
    }

    public void Update() {

        if (!list.isEmpty()) {
            System.out.print("Input the ID of the doctor you want to update: ");
            int id = getInt(0, list.size());
            list.remove(getThePosOfTheID(id));
            String name = va.getName("");
            Date dob = va.getDateOfBirth();
            String spec = va.getSpecialization();
            int availability = va.getAvailability();
            String email = va.getEmail();
            String phone = va.getPhoneNumber();
            Doctor d = new Doctor(id, name, dob, spec, availability, email, phone);
            list.add(d);
        } else {
            System.out.println(" List is empty !! Please add Information");
        }

    }

    public int getThePosOfTheID(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (id == list.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    public int getThePosOfTheName(String name) {
        for (int i = 0; i < list.size(); i++) {
            if (name == list.get(i).getName()) {
                return i;
            }
        }
        return -1;
    }

    public boolean checkDelete(int id) throws ParseException {
        Date dob;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        String txt = "01/01/2000";
        dob = sdf.parse(txt);
        list.add(new Doctor(1, "nam", dob, "ava", 0, "nam@gmail.com", "1234567890"));
        if( id == list.size()){
            return true;   
        }else{
            return false;
        }       
    }
  public boolean checkEmptyListDelete(int id) throws ParseException {
       return false;             
    }
    public void delete() {
        if (!list.isEmpty()) {
            System.out.println("Input ID of the doctor  to delete: ");
            int id = getInt(0, list.size());
            list.remove(getThePosOfTheID(id));
        } else {
            System.out.println(" List is empty !! Please add Information");
        }

    }

    public void search() {
        if (!list.isEmpty()) {
            System.out.println("-------Search");
            System.out.println("1.Search by ID");
            System.out.println("2.Search by Name");
            switch (getInt(1, 2)) {
                case 1:
                    SearchByID();
                    break;
                case 2:
                    searchByName();
                    break;
            }
        } else {
            System.out.println(" List is empty !! Please add Information");
        }
    }

    public void SearchByID() {
        System.out.print("Input ID to search: ");
        int id = getInt(1, list.size());
        showTheDoctor(list.get(getThePosOfTheID(id)));
    }

    public void searchByName() {
        System.out.print("Input name  to search: ");
        try {
            String name = in.readLine();
            showTheDoctor(list.get(getThePosOfTheName(name)));
        } catch (IOException ex) {
            Logger.getLogger(process.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void sortDoctor() {
        if (!list.isEmpty()) {
            Collections.sort(list);
            for (Doctor doctor : list) {
                System.out.println(doctor.toString());
            }
        } else {
            System.out.println(" List is empty !! Please add Information");
        }
    }

    public void showTheDoctor(Doctor d) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("-------Information");
        System.out.println("ID: " + d.getId());
        System.out.println("Name: " + d.getName());
        System.out.println("Date of Birth: " + sdf.format(d.getDateOfBirth()));
        System.out.println("Specialization: " + d.getSpecialization());
        System.out.println("Availability: " + d.getAvailability());
        System.out.println("Email: " + d.getEmail());
        System.out.println("Mobile: " + d.getMobile());
    }

    public void run() {

        System.out.println("1. Create a Doctor\n"
                + "2. Editt a Doctor Information\n"
                + "3. Delete a Doctor\n"
                + "4. Search doctor by ID and by Name\n"
                + "5. Sort doctor by DateOfBirth");
        System.out.println("6. Exit");
        System.out.print("Choose 1 to 6: ");
        switch (getInt(1, 6)) {
            case 1:
                add();
                break;
            case 2:
                Update();
                break;
            case 3:
                delete();
                break;
            case 4:
                search();
                break;
            case 5:
                sortDoctor();
                break;
            case 6:
                System.exit(0);
        }
    }
}
