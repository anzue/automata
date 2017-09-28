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

import automata.Automat;

public class Automata {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Automat x = new Automat();
        x.print();
        System.out.println("Dfs");
        x.initDfs();
    }
    
}
