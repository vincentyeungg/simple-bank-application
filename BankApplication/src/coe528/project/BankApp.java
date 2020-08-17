/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


/**
 *
 * @author Vincent Yeung
 */
public class BankApp extends Application{
    
        private final Manager m = new Manager();
        List<Account> account = new ArrayList<>();
        List<Customer> customer = new ArrayList<>();
    
    Scene loginScene, adminScene, customerScene;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        primaryStage.setTitle("Bank Application"); //title of the first window of app
        
        //set the layout of the login screen with gridpane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10)); //add border layout to scrn
        grid.setVgap(20); // vgap between the different nodes
        grid.setHgap(20); // hgap between the different nodes
        
        //make the labels and fields for user to interact with
        
        //LOGINPAGE
        //add label for the 'tltle'
        Label titlelabel = new Label("Login");
        GridPane.setConstraints(titlelabel, 0, 0); //column, row
        //add lebel for username
        Label namelabel = new Label("Username");
        GridPane.setConstraints(namelabel, 0, 1);
        //add txtfield for input
        TextField userfield = new TextField();
        GridPane.setConstraints(userfield, 1, 1);
        //add label for the password
        Label passlabel = new Label("Password");
        GridPane.setConstraints(passlabel, 0, 2);
        //add txtfield for input
        PasswordField passfield = new PasswordField();
        GridPane.setConstraints(passfield, 1, 2);
        
        //log in button
        Button loginbutton = new Button("Log in");
        
        final Label inform = new Label();
        GridPane.setConstraints(inform, 2, 1);
        
        final Label inform2 = new Label();
        GridPane.setConstraints(inform2, 2, 2);
        
        GridPane.setConstraints(loginbutton, 1, 3);
        grid.getChildren().addAll(namelabel, passlabel, userfield, passfield, loginbutton, titlelabel, inform, inform2); 
        Scene loginScene = new Scene(grid, 800, 500);
        
        //MANAGERSCENE
        // Layout 1 - children are laid out in vertical column
        GridPane adminpage = new GridPane();
        adminpage.setPadding(new Insets(10,10,10,10)); //add border layout to scrn
        adminpage.setVgap(20); // vgap between the different nodes
        adminpage.setHgap(20); // hgap between the different nodes
    
        Label welcome = new Label("Manager Page");
        GridPane.setConstraints(welcome, 2, 0);
    
        //button to add
        Button addcustomer = new Button("Add Customer");
        GridPane.setConstraints(addcustomer, 0, 3);
        
        Label entername = new Label("Enter Username:");
        GridPane.setConstraints(entername, 0, 1);
        
        TextField newUserfield = new TextField();
        GridPane.setConstraints(newUserfield, 1, 1);
    
        //button to delete
        Button deletecustomer = new Button("Delete Customer");
        GridPane.setConstraints(deletecustomer, 1, 3);
        
        Label enterpass = new Label("Enter Password:");
        GridPane.setConstraints(enterpass, 0, 2);
        
        TextField newPassfield = new TextField();
        GridPane.setConstraints(newPassfield, 1, 2);
        
        //log out button
        Button adminlogout = new Button("Log out");
        GridPane.setConstraints(adminlogout, 17, 16);
        
        final Label displaymsge = new Label("");
        GridPane.setConstraints(displaymsge, 0, 5);
        
        final Label displaymsge2 = new Label("");
        GridPane.setConstraints(displaymsge2, 0, 6);
        
        adminpage.getChildren().addAll(adminlogout, deletecustomer, addcustomer, welcome, newUserfield, newPassfield, entername, enterpass, displaymsge, displaymsge2);
        adminScene = new Scene(adminpage,800,500);
        
        //CUSTOMERSCENE
        GridPane customerpage = new GridPane();
        customerpage.setPadding(new Insets(10,10,10,10)); //add border layout to scrn
        customerpage.setVgap(20); // vgap between the different nodes
        customerpage.setHgap(20); // hgap between the different nodes
        
        final Label welcome2 = new Label("");
        GridPane.setConstraints(welcome2, 1, 0); //column, row
        
        Label amount1 = new Label("Enter amount to be withdrawn:");
        GridPane.setConstraints(amount1, 0, 1);
        
        TextField amount1entered = new TextField();
        GridPane.setConstraints(amount1entered, 1, 1);
        
        //button to withdraw
        Button withdraw = new Button("Withdraw");
        GridPane.setConstraints(withdraw, 2, 1); //column, row
        
        Label amount2 = new Label("Enter amount to be deposited:");
        GridPane.setConstraints(amount2, 0, 2);
        
        TextField amount2entered = new TextField();
        GridPane.setConstraints(amount2entered, 1, 2);
        
        //button to deposit
        Button deposit = new Button("Deposit");
        GridPane.setConstraints(deposit, 2, 2); //column, row
        
        //label for balance
        Label balancelabel = new Label("Balance:");
        GridPane.setConstraints(balancelabel, 0, 3);
        
        TextField balance = new TextField();
        GridPane.setConstraints(balance, 1, 3);
        
        //button to get balance
        Button getBalance = new Button("Balance");
        GridPane.setConstraints(getBalance, 2, 3); //column, row
    
        Label amount3 = new Label("Online Purchase Amount:");
        GridPane.setConstraints(amount3, 0, 4);
        
        TextField amount3entered = new TextField();
        GridPane.setConstraints(amount3entered, 1, 4);
        
        //button to purchase online
        Button onlinePurchase = new Button("Purchase Online");
        GridPane.setConstraints(onlinePurchase, 2, 4);
    
        //log out button
        Button customerlogout = new Button("Log out");
        GridPane.setConstraints(customerlogout, 12, 12);
        
        //inform label
        final Label inform3 = new Label();
        GridPane.setConstraints(inform3, 2, 6);
        
        final Label yourState = new Label("Level:");
        GridPane.setConstraints(yourState, 0, 6);
        
        //to display the level
        final Label level = new Label();
        GridPane.setConstraints(level, 1, 6);
        
        customerpage.getChildren().addAll(customerlogout, deposit, withdraw, getBalance, onlinePurchase, welcome2, amount1, amount2, amount3, amount1entered, amount2entered, amount3entered, balance, balancelabel, level, inform3, yourState);
        customerScene = new Scene(customerpage,800,500);
        
        //to return to log in scene
        adminlogout.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                primaryStage.setScene(loginScene);
            }
        });
        
        //this will check if username and password match that of an admin and then proceed to the manager page
        loginbutton.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                if(!(userfield.getText().isEmpty()) && !(passfield.getText().isEmpty())){
                    if(m.verifyManager(userfield.getText(), passfield.getText())){
                    primaryStage.setScene(adminScene);
                    userfield.setText(""); //clear the data in the field
                    passfield.setText(""); //clear the data in the field
                    }
                    else{
                        //this is for customer
                        //must check if the customer exists first
                        if(!(m.verifyCustomer(userfield.getText(), passfield.getText()))){
                            inform.setText("");
                            inform2.setText("");
                            userfield.setText("");
                            passfield.setText("");
                            inform.setText("Incorrect username");
                            inform2.setText("or password.");
                        }
                        if(m.verifyCustomer(userfield.getText(), passfield.getText())){
                            Person c = new Customer(userfield.getText(),passfield.getText(), "Customer");

                            try {
                                BufferedReader reader = new BufferedReader(new FileReader(userfield.getText()));
                                //to go the balance line
                                for(int i = 0; i < 2; ++i){
                                reader.readLine();}
                                //make the line = the balance
                                String line = reader.readLine();
                                for(int i = 0; i < 1; ++i){
                                reader.readLine();}
                                String lvl = reader.readLine(); //shud get the state
                                //convert to a double
                                double b = Double.parseDouble(line);
                                //create new account now
                                Account a = new Account(b, (Customer)c);
                                customer.add((Customer)c);
                                account.add(a);
                                //account.get(0).setLevel(lvl);
                                //to see if it reads the correct file
                                welcome2.setText("Welcome back,  " + userfield.getText());
                                //go to that customer scene
                                primaryStage.setScene(customerScene);
                                userfield.setText("");
                                passfield.setText("");
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(BankApp.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(BankApp.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        else{throw new IllegalArgumentException("user not created yet");
                            //maybe make a new label to tell the user its not created yet
                        }
                    }
                }
                else{
                //that means there has been no username or password entered
                if((userfield.getText().isEmpty()) && !(passfield.getText().isEmpty())){
                    inform.setText("");
                    inform2.setText("");
                    inform.setText("Enter username.");
                }
                if(!(userfield.getText().isEmpty()) && (passfield.getText().isEmpty())){
                    inform.setText("");
                    inform2.setText("");
                    inform2.setText("Enter password.");
                }
                if((userfield.getText().isEmpty()) && (passfield.getText().isEmpty())){
                    inform.setText("");
                    inform2.setText("");
                    inform.setText("Enter username");
                    inform2.setText("and password.");
                }
                }
            }
        });
        
        //this will create a customer from admin scene
        addcustomer.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event){
                if(!(newUserfield.getText().isEmpty()) && !(newPassfield.getText().isEmpty()) && !(newUserfield.getText()).equals("admin")){
                    try {
                        //create a new customer
                        m.addCustomerFile(newUserfield.getText(), newPassfield.getText());
                    } catch (IOException ex) {
                        Logger.getLogger(BankApp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    displaymsge.setText("");
                    displaymsge2.setText("");
                    displaymsge.setText("Customer has been added.");
                    newUserfield.setText(""); //clear the data in the field
                    newPassfield.setText(""); //clear the data in the field
                }
                else if((newUserfield.getText().isEmpty()) && !(newPassfield.getText().isEmpty())){
                    displaymsge.setText("");
                    displaymsge2.setText("");
                    displaymsge.setText("Please enter the username");
                    displaymsge2.setText("you want to add.");
                }
                else if(!(newUserfield.getText().isEmpty()) && (newPassfield.getText().isEmpty())){
                    displaymsge.setText("");
                    displaymsge2.setText("");
                    displaymsge.setText("Please enter the");
                    displaymsge2.setText("password.");
                }
                else if((!(newUserfield.getText().isEmpty()) && (newUserfield.getText()).equals("admin")) && (newPassfield.getText().isEmpty())){
                    displaymsge.setText("");
                    displaymsge2.setText("");
                    displaymsge.setText("Cannot add another");
                    displaymsge2.setText("admin.");
                    newUserfield.setText(""); //clear the data in the field
                    newPassfield.setText(""); //clear the data in the field
                }
                else if((!(newUserfield.getText().isEmpty()) && (newUserfield.getText()).equals("admin")) && !(newPassfield.getText().isEmpty())){
                    displaymsge.setText("");
                    displaymsge2.setText("");
                    displaymsge.setText("Cannot add another");
                    displaymsge2.setText("admin.");
                    newUserfield.setText(""); //clear the data in the field
                    newPassfield.setText(""); //clear the data in the field
                }
                else try {
                    if(m.checkforduplicate(newUserfield.getText())){
                        displaymsge.setText("");
                        displaymsge2.setText("");
                        displaymsge.setText("Customer already exists.");
                        newUserfield.setText(""); //clear the data in the field
                        newPassfield.setText(""); //clear the data in the field
                    }
                } catch (IOException ex) {
                    Logger.getLogger(BankApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        //this will delete a customer from admin scene
        deletecustomer.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if((newUserfield.getText().isEmpty())){
                    displaymsge.setText("Please enter the username");
                    displaymsge2.setText("you want to remove.");
                }
                if(!(newUserfield.getText().isEmpty()) && !(newUserfield.getText()).equals("admin")){
                    m.deleteCustomerFile(newUserfield.getText());
                    displaymsge.setText("Customer has been deleted.");
                    newUserfield.setText("");
                    newPassfield.setText("");
                }
                if((!(newUserfield.getText().isEmpty()) && (newUserfield.getText()).equals("admin"))){
                    displaymsge.setText("Cannot delete another admin.");
                    newUserfield.setText(""); //clear the data in the field
                    newPassfield.setText(""); //clear the data in the field
                }
            }
        });
    
        customerlogout.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                account.remove(0);
                customer.remove(0);
                primaryStage.setScene(loginScene);
            }
        });

        deposit.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event){
                
                //need to see if the string entered is numeric and contains only 1 decimal point
                if((!(amount2entered.getText()).matches("^[0-9]*\\.?[0-9]*$") || amount2entered.getText().isEmpty())){
                    inform3.setText("");
                    inform3.setText("Invalid amount.");
                    amount1entered.setText("");
                    amount2entered.setText("");
                    amount3entered.setText("");
                    throw new IllegalArgumentException("Not a valid deposit");
                }
                else{
                    double d = Double.parseDouble(amount2entered.getText());
                    try {
                        (account.get(0)).deposit(d);
                        amount1entered.setText("");
                        amount2entered.setText("");
                        amount3entered.setText("");
                        double b = (account.get(0)).getBalance();
                        String strbalance = Double.toString(b);
                        balance.setText(strbalance);
                        level.setText("");
                        level.setText(((account.get(0)).getLevel()).toString());
                        //level.setText(((account.get(0)).getLevel()).toString());
                    } catch (IOException ex) {
                        Logger.getLogger(BankApp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                } 
        });
        
        getBalance.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                double b = (account.get(0)).getBalance();
                String strbalance = Double.toString(b);
                balance.setText(strbalance);
                amount1entered.setText("");
                amount2entered.setText("");
                amount3entered.setText("");  
                level.setText("");
                level.setText(((account.get(0)).getLevel()).toString());
            }    
        });
        
        withdraw.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //need to see if the string entered is numeric and contains only 1 decimal point
                if(!(amount1entered.getText()).matches("^[0-9]*\\.?[0-9]*$") || amount1entered.getText().isEmpty()){
                    inform3.setText("");
                    inform3.setText("Invalid amount.");
                    amount1entered.setText("");
                    amount2entered.setText("");
                    amount3entered.setText("");
                    throw new IllegalArgumentException("Not a valid withdraw");
                }
                else{
                    double d = Double.parseDouble(amount1entered.getText());
                    try {
                        if(d <= 0){
                            inform3.setText("");
                            inform3.setText("Invalid amount.");
                            amount1entered.setText("");
                            amount2entered.setText("");
                            amount3entered.setText("");
                        }
                        if((account.get(0).getBalance()) < d){
                            inform3.setText("");
                            inform3.setText("Insufficient funds.");
                            amount1entered.setText("");
                            amount2entered.setText("");
                            amount3entered.setText("");
                        }
                        (account.get(0)).withdraw(d);
                        } catch (IOException ex) {
                            Logger.getLogger(BankApp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                amount1entered.setText("");
                amount2entered.setText("");
                amount3entered.setText("");
                double b = (account.get(0)).getBalance();
                String strbalance = Double.toString(b);
                balance.setText(strbalance);
                level.setText("");
                level.setText(((account.get(0)).getLevel()).toString());
            }
        });
        
        onlinePurchase.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                //need to see if the string entered is numeric and contains only 1 decimal point
                if(!(amount3entered.getText()).matches("^[0-9]*\\.?[0-9]*$") || amount3entered.getText().isEmpty()){
                    inform3.setText("");
                    inform3.setText("Invalid amount.");
                    amount1entered.setText("");
                    amount2entered.setText("");
                    amount3entered.setText("");
                    throw new IllegalArgumentException("Not a valid purchase");
                }
                else{
                    double d = Double.parseDouble(amount3entered.getText());
                    try {
                        if(d <= 0){
                            inform3.setText("");
                            inform3.setText("Invalid amount.");
                            amount1entered.setText("");
                            amount2entered.setText("");
                            amount3entered.setText("");
                        }
                        if(d > 0 && d < 50){
                            inform3.setText("");
                            inform3.setText("Must be over $50.");
                            amount1entered.setText("");
                            amount2entered.setText("");
                            amount3entered.setText("");
                        }
                        if((level.getText().equals("Silver")) && ((account.get(0)).getBalance()) < (d+20.00)){
                            inform3.setText("");
                            inform3.setText("Insufficient funds.");
                            amount1entered.setText("");
                            amount2entered.setText("");
                            amount3entered.setText("");
                        }
                        if((level.getText().equals("Gold")) && ((account.get(0)).getBalance()) < (d+0.00)){
                            inform3.setText("");
                            inform3.setText("Insufficient funds.");
                            amount1entered.setText("");
                            amount2entered.setText("");
                            amount3entered.setText("");
                        }
                        if((level.getText().equals("Platinum")) && ((account.get(0)).getBalance()) < (d)){
                            inform3.setText("");
                            inform3.setText("Insufficient funds.");
                            amount1entered.setText("");
                            amount2entered.setText("");
                            amount3entered.setText("");
                        }
                        (account.get(0)).onlinePurchase(account.get(0), d);
                        } catch (IOException ex) {
                            Logger.getLogger(BankApp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                
                amount1entered.setText("");
                amount2entered.setText("");
                amount3entered.setText("");
                double b = (account.get(0)).getBalance();
                String strbalance = Double.toString(b);
                balance.setText(strbalance);
                level.setText("");
                level.setText(((account.get(0)).getLevel()).toString());
            }
        });
        
        //set a scene 
        primaryStage.setScene(loginScene);
        primaryStage.show();//displays to user    
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
