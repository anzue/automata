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

import automata.ifstream.*;

import java.util.*; 

import java.util.ArrayList;

public class Automat {
    private ArrayList<Vertex> vert;
    private Scanner reader;
    private int start;
    
    
    private void out(String s){
        System.out.print(s);
    }
    
    public  Automat(){
        //x = new ifstream();
        reader = new Scanner(System.in);
        vert = new ArrayList<>();
        int n = 0;
        out("n  = ");
        n = reader.nextInt();
        out("sigma = ");
        int sigma = reader.nextInt();
        out("start = ");
        start = reader.nextInt();
        System.out.print(n);
        for(int i=0;i<n;++i){
            vert.add(new Vertex());
        }
        out("fin count = ");
        int finals = reader.nextInt();
        int pos;
        out("fin = ");
        while(finals-->0){
            pos = reader.nextInt();
            vert.get(pos).SetFinal(true);
        }
        
        out("states = ");
       // reader.useDelimiter(" ");
        for(int i=0;i<n;++i){
            int m = 0;
            //x.read(m);
            m = reader.nextInt();
           // out(m+"\n");
            char c = 0;
            int to = 0;
            while(m-->0){
                c = reader.next().charAt(0);
              //  out(c+" ");
                to = reader.nextInt();
              //  out(c+" "+ to+ " ");
                vert.get(i).addWay(vert.get(to),c);
                //--m;
            }
           
        }
    }
    
    
    public void dfs(Vertex v,String s){
        out("Dfs "  + v + " "+s+"\n");
        if(v.IsFinal())
            out(s);
        ArrayList<Vertex> ways;
        Set<Character> keys = v.getKeys();
        out(keys.size()+"\n");
        for(Character c:keys){
            ways = v.getWays(c);
            //out("")
            for(Vertex vv:ways){
                dfs(vv,s+c);
            }
        }
    }
    public void initDfs(){
        dfs(vert.get(start),"");
    }
    
    public void print(){
        if(vert!=null)
            for(int i=0;i<vert.size();++i){
                System.out.print(i + " ");
                vert.get(i).print();
            }
        else
            System.out.println("null array");
            
    }
}
