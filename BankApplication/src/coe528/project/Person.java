/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author Vincent Yeung
 */

public abstract class Person {
    
    //OVERVIEW: This class represents a person associated with an account
    //this class is immutable
    //Abstract Function: AF(c) = a person p, such that
    //                          c.username = p.username, 
    //                          c.password = p.password,
    //                          c.role = p.role
    //Rep Invariant: RI(c) = true if c.username != null, 
    //                               c.password != null,
    //                               c.role != null &&
    //                               c.role = "Manager" or 
    //                               "Customer"
    //                               false otherwise   
    
    private String username;
    private String password;
    private String role;

    public Person(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    //Requires: A person has been created and given a username
    //Modifies: n/a
    //Effects: returns username
    public String getUsername() {
        return username;
    }
    
    //Requires: A string that is not empty, and doesn't point to null
    //Modifies: username
    //Effects: Changes username for the Person associated with the account
    public void setUsername(String username) {
        this.username = username;
    }
    
    //Requires: A person has been created and given a password
    //Modifies: n/a
    //Effects: returns password
    public String getPassword() {
        return password;
    }
    
    //Requires: A string that is not empty, and doesn't point to null
    //Modifies: password
    //Effects: Changes password for the Person associated with the account
    public void setPassword(String password) {
        this.password = password;
    }
    
    //Requires: A person has been created and given a role
    //Modifies: n/a
    //Effects: returns role
    public String getRole(){
        return role;
    }
    
    //Requires: A string that is not empty, and is equal to "Manager" or "Customer"
    //          and doesn't point to null
    //Modifies: role 
    //Effects: Sets the new role for the Person associated with the account
    public void setRole(String role){
        if(role.equals("Admin") || (role.equals("Customer")))
        this.role = role;
    }
    
    //Implementation of Abstract Function
    @Override
    public String toString(){
        return "Username: " + this.username + ", " +  "Password: " + this.password + ", " + "Role: " + this.role;
    }
    
    //Implementation of Rep Invariant
    public boolean repOK(){
        if((this.username).equals("") && (this.password).equals("")){
            if((this.role).equals("Manager") || (this.role).equals("Customer")){
                return true;
            }
        }
        return false;
    }
}
