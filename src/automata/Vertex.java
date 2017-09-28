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


import java.util.HashMap;
import java.util.ArrayList;
import java.util.*;

public class Vertex {
    private boolean isFinal;
    private HashMap<Character,ArrayList<Vertex> > ways; 
    
    
    public Vertex(){
        isFinal = false;
        ways = new HashMap< > ();
    }
    public void SetFinal(boolean a){
        isFinal = a;
    }
    public ArrayList<Vertex> getWays(Character c){
        return ways.get(c);
    }
    public Set<Character> getKeys(){
        return ways.keySet();
    }
    public boolean IsFinal(){
        return isFinal;
    }
    public void addWay(Vertex to,char c){
        ArrayList<Vertex> q = ways.get(c);
        if(q == null){
            q = new ArrayList<>();
            ways.replace(c, q);
        }
        q.add(to);
        
        System.out.println("Adding way from "+this+ " to "+ to + " by " + c);
        System.out.println(ways.get(c).size() + " " + q.size());
    }
    public void print(){
        if(isFinal)System.out.println("Final");
        Set<Character> keys = ways.keySet();
        keys.stream().forEach((a) -> {
            ArrayList b = ways.get(a);
            System.out.println(a + " "+b+" "+b.size() + "\n");
        });
    }
    
}
