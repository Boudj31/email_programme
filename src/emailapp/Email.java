package emailapp;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Email {
    public Scanner s = new Scanner(System.in);// Scanner class
    // Setting private variables
    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alter_email;

    // Constuctor
    public Email(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        System.out.println("NEW EMPLOYEE:" + this.fname + " " + this.lname);
        // calling method
        this.dept = this.setDept();
        this.password = this.generate_password(8);
        this.email = this.generate_email();

    }

    // Generate mail method
    private String generate_email() {
        return this.fname.toLowerCase() + "." + this.lname.toLowerCase() + "@" + this.dept.toLowerCase() + ".company";
    }

    private String setDept() {
        System.out.println("Departement codes \n1 for Sales \n2 for Developement \n3 for Accounting\n0 None");
        boolean flag = false;
        do {
            System.out.println("Enter departement Code");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    return "Sales";
                case 2:
                    return "Developement";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalide choice, please retry again");
            }
        } while (!flag);
        return null;
    }

    // random password

    private String generate_password(int lenght) {
        Random r = new Random();
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%&?";
        String values = Capital_chars+Small_chars+numbers+symbols;
        String password = "";
        for(int i=0;i<lenght;i++){
            password = password+values.charAt(r.nextInt(values.length()));
        }
        return password;
    }

    // change password method
    public void set_password() {
        boolean flag = false;
        do {
            System.out.println("Do you want to change your password ?(Y/N)");
            char choice = s.next().charAt(0);
            if(choice=='Y' || choice=='y'){
                flag = true;
                System.out.println("Enter current password:");
                String temp = s.next();
                if (temp.equals(this.password)){
                    System.out.println("Enter new password");
                    this.password = s.next();
                    System.out.println("Password has changed succesfully !");
                }
                else {
                    System.out.println("Incorrect password");
                }
            } else if(choice=='N' || choice=='n') {
                flag = true;
                System.out.println("Password changes option cancelled");

            }
            else {
                System.out.println("Enter valid choice");
            }
        } while (!flag);

        }
//set mailbox capacity method
    public void set_mailCap() {
        System.out.println("Current capacity =" + this.mailCapacity+"mb");
        System.out.println("Enter new capacity");
        this.mailCapacity = s.nextInt();
        System.out.println("Mail capacity is succesfully changed");
    }

    public void alternate_email() {
        System.out.println("Enter new alternate email: ");
        this.alter_email = s.next();
        System.out.println("Alternate email is set");
    }

    //Display user infos
    public void getInfo(){
        System.out.println("New:"+this.fname+" "+this.lname);
        System.out.println("Departement: "+this.dept);
        System.out.println("Email: "+ this.email);
        System.out.println("Password: "+this.password);
        System.out.println("Mailbox Capacity"+this.mailCapacity+"mb");
        System.out.println("Alternate email " + this.alter_email);

    }

    public void storeFile(){
        try {
            FileWriter in = new FileWriter("C:\\Users\\Admin stagiaire.DESKTOP-8967908\\Desktop\\infos.txt");
            in.write("Firtname: "+this.fname);
            in.append("\nLastname: "+this.lname);
            in.append("\nEmail: "+this.email);
            in.append("\nPassword: "+this.password);
            in.append("\nCapacity: "+this.mailCapacity);
            in.append("\nAlternate mail: "+this.alter_email);
            in.close();
            System.out.println("Data stored...");

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void readFile(){
        try {
            FileReader f1 = new FileReader("C:\\Users\\Admin stagiaire.DESKTOP-8967908\\Desktop\\infos.txt");
            int i;
            while ((i=f1.read())!=-1){
                System.out.println((char) i);

            }
            System.out.println("");
            f1.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

