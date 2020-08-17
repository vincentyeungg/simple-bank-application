/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;


/**
 *
 * @author Vincent Yeung
 * there is only one manager with initials and password: admin
 * manager can add and delete customers from database (file) system
 */
public class Manager extends Person {
    private static final String username = "admin";
    private static final String password = "admin";
    private static final String role = "Manager";
    
    public Manager(){
        super(username, password, role);
    }
    
    public void addCustomerFile(String C_username, String C_password) throws IOException{
    
        if(C_username.equals("admin")){
            throw new IllegalArgumentException("There can only be one admin.");
        }
        else{
            File file = new File(C_username);
            if(file.exists()){
                throw new IllegalArgumentException("The file already exists");
            }
            else{
                PrintWriter pw = new PrintWriter(file);
                pw.println("Username: " + C_username);
                pw.println("Password: " + C_password);
                pw.println("" + 100.00); //this will have to change as balance change
                pw.println("Silver"); //changes as the balance changes 
                pw.println("Role: Customer");
                System.out.println("Customer Added");
                pw.close();
            }
        }    
    }
    
    public void deleteCustomerFile(String username){
    //only takes username bc we assume there can be no customers with the same
    //name
        File file = new File(username);
        if(file.delete()){
            System.out.println("Customer File removed from system.");
        }
        else{System.out.println("Customer File does not exist");
        }
    }
    
    public boolean verifyManager(String username, String password){
        if(username.equals(this.username) && password.equals(this.password)){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean verifyCustomer(String username, String password){
        File f = new File(username);
        try{
            checkUser(f, username);
            checkPass(f, password);
            return true;
        }catch(IOException e){
            System.out.println("Incorrect log in or password.");
        }
        return false;
    }
    
    public void checkUser(File f, String username) throws IOException{
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            //do something
            if(line.equals("Username: " + username)){
                    //System.out.println("true");
                    break;
                }
            else{
                //System.out.println("false");
                break;}
        }
        br.close();
        fr.close();
    }
    
    public void checkPass(File f, String password) throws IOException{
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            line = br.readLine();
            if(line.equals("Password: " + password)){
                    //System.out.println("true");
                    break;
            }
            else{
                //System.out.println("false");
                break;
            }
        }
        br.close();
        fr.close();
    }  
    
    public boolean checkforduplicate(String Username) throws FileNotFoundException, IOException{
        FileReader fr = new FileReader(Username);
        BufferedReader br = new BufferedReader(fr);
        String line;
        line = br.readLine();
        if(line.equals("Username: " + Username)){
            br.close();
            fr.close();
            return true;
        }
        else{
            br.close();
            fr.close();
            return false;}
        }
    }