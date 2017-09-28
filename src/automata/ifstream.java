/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

/**
 *
 * @author anton
 */

import java.util.Scanner;

public class ifstream {
    private Scanner reader;
    public ifstream(){
        reader = new Scanner(System.in);
    }
    public int read(Integer a){
        a = reader.nextInt();
        return 0;
    }
    
    public int read(String a){
        a = reader.nextLine();
        return 0;
    }
    
    public int read(Character a){
        reader.useDelimiter("");
        a = reader.next().charAt(0);
        reader.useDelimiter("\\s");
        return 0;
    }
    
    
    
}
