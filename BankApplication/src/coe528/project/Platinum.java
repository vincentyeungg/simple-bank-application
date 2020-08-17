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
public class Platinum extends Level {

    public void changeLevel(Account acc){
        if(acc.getBalance() < 10000){
            acc.setLevel(new Silver());
        }
        if(acc.getBalance() >= 10000 && acc.getBalance() < 20000){
            acc.setLevel(new Gold());
        }
        if(acc.getBalance() >= 20000){
            //do nothing
        }
    }
    
    @Override
    public String toString(){
        return "Platinum";
    }
}
