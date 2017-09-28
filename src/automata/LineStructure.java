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


import java.util.*;

public class LineStructure {
    private ArrayList<Set<Integer> > K;  
    boolean isFull;
    
    
    public LineStructure() {
        K = new ArrayList<>();
        for(int i=0;i<102;++i)
            K.add(new TreeSet<Integer>());
        
        isFull = false;
    }
    public boolean IsFull(){
        return isFull;
    }
    
    public void addLine(Integer k ,Integer b){
        System.out.print("adding "+k+"x+"+b+"\n");
        for(int i=1;i*k<=100;++i){
            for(int j=0;j<i;++j)
                K.get(i*k).add(b+j*k);
            if(K.get(i*k).size() == i*k){
                isFull = true;
               // System.out.print("adding line " + 
               //         k+ "x+" + b+ "completed full level " +i*k+"\n");
            }
        }
    }
}
