package main;

import survey.*;

import java.util.Scanner;

public class Main {
    // TODO: Write a generic function for grabbing tokens from a Scanner object

    public static void main(String[] args) {
        // Scan for name, age, and email
        // Put results in IUserProfile object via UserInfo implementation
        // Print out resulting string

        String name;
        double age;
        String email;

        Scanner stdScanner = new Scanner(System.in);
        System.out.println("Please enter your Name, Age, and Email: (ex: john 30 john@email.com)");

        if(!stdScanner.hasNext()) {throw new MatchException("Input type did not match expected type", null);}
        name = stdScanner.next();

        if(!stdScanner.hasNextDouble()) {throw new MatchException("Input type did not match expected type", null);}
        age = stdScanner.nextDouble();

        if(!stdScanner.hasNext()) {throw new MatchException("Input type did not match expected type", null);}
        email = stdScanner.next();

        IUserProfile user = new UserInfo(name, age, email);
        System.out.println(user);
    }
}
