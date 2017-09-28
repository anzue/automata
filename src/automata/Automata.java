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
        
        int z = x.bfs(1000);
        if(z == -1 )
            System.out.print("All length to 1000 are reachable\n");
        else 
            System.out.print("Length "+z+" isn`t reachable\n");
                
        x.generateCycles();

        if(x.fullCheck())
            System.out.print("All length over 1000 are reachable");
        else 
            System.out.print("Length over 1000 arent reachable");
        
        
  
    }
    
}
