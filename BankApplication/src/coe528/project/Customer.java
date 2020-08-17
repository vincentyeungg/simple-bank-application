/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;

/**
 *
 * @author Vincent Yeung
 * 
 * A customer is able to withdraw, deposit, purchase online, and get balance
 * Each customer is associated with an account that contains a level that will
 * be implemented in another class
 */
public class Customer extends Person {
    
    public Customer(String username, String password, String role) {
        super(username, password, role);
    }
}
