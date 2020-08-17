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
public class Silver extends Level {
    
    public void changeLevel(Account acc){
        if(acc.getBalance() < 10000){
            //do nothing
        }
        if(acc.getBalance() >= 10000 && acc.getBalance() < 20000){
            acc.setLevel(new Gold());
        }
        if(acc.getBalance() >= 20000){
            acc.setLevel(new Platinum());
        }
    }
    @Override
    public String toString(){
        return "Silver";
    }
    
}
