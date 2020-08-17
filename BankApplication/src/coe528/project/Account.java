/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Vincent Yeung
 */
public class Account {
    
    private double balance;
    private Level level;
    private Customer p;
    
    public Account(double balance, Customer c) {
        this.balance = balance;
        this.p = c;
        this.level = new Silver();
    }
    
    public Customer getCustomer() {
        return p;
    }

    public void setCustomer(Customer c) {
        p = c;
    }
    
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Level getLevel() {
        
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
    
    public void deposit(double deposit) throws IOException{
        if(deposit > 0){
        balance = balance + deposit;
        changeLevel(this.level);
        editFileInfo(p);
        }
        else{throw new IllegalArgumentException("Amount must be greater than 0");}
    }
    
    public void withdraw(double withdraw) throws IOException{
        //check if there is enough money to withdraw
        //need to throw exception here for if balance < 0
        if((balance > 0 && withdraw > 0) && (balance >= withdraw)){
            balance = balance - withdraw;
            changeLevel(this.level); //need to see the state change or not
            editFileInfo(p);
        }
        else{throw new IllegalArgumentException("Cannot withdraw.");}
    }
    
    public void changeLevel(Level level){
        level.changeLevel(this);
    }
    
    public void onlinePurchase(Account acc, double payment) throws IOException{
        //use states to determine the purchases they can make      
        if(validPurchase(payment) == true){
            if(acc.getBalance() < 10000){
                if(balance >= (20.00 + payment)){
                acc.withdraw(20.00 + payment);
                changeLevel(acc.getLevel());
                editFileInfo(this.p);
                }
            else{
                throw new IllegalArgumentException("Insufficient funds.");
                }
            }
            if((acc.getBalance() >= 10000) && (acc.getBalance() < 20000)){
                if(balance >= (10.00 + payment)){
                acc.withdraw(10.00 + payment);
                changeLevel(acc.getLevel());
                editFileInfo(this.p);
                }
                else{
                throw new IllegalArgumentException("Insufficient funds.");
                }
            }
            if(acc.getBalance() >= 20000){
                if(balance >= (payment)){
                acc.withdraw(payment);
                changeLevel(acc.getLevel());
                editFileInfo(this.p);
                }
                else{
                throw new IllegalArgumentException("Insufficient funds.");
                }
            }
        }
        else{
            throw new IllegalArgumentException("Purchase must be over $50.");
        }
    }
    
    //we must update balance in the file too       
    public void editFileInfo(Customer c) throws IOException{

        try{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c.getUsername())));
        bw.write("Username: " + c.getUsername());
        bw.newLine();
        bw.write("Password: " + c.getPassword());
        bw.newLine();
        bw.write("" + this.balance);
        bw.newLine();
        bw.write("" + this.level);
        bw.newLine();
        bw.write("Role: " + c.getRole());
        System.out.println("Info has been updated.");
        bw.close();
        }
        catch(Exception e){
            System.out.println("error");
        }
    }

    public boolean validPurchase(double payment){
        if(payment >= 50){return true;}
        else{return false;}
    }     
}
