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
import automata.LineStructure;

public class Automat {
    private ArrayList<Vertex> vert;
    private Scanner reader;
    private int start;
    private LineStructure u;
    private void out(String s){
        System.out.print(s);
    }

    public Automat(){
        u = new LineStructure();
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
    public int bfs(int maxLen){
        TreeSet<Vertex> cur = new TreeSet<>(new VertexCompare());
        TreeSet<Vertex> next = new TreeSet<>(new VertexCompare());
        System.out.print(cur);
        cur.add(vert.get(start));
        ArrayList<Vertex> ways;
        Set<Character> keys;
        int CLen = 0;
        boolean ok = true;
        while(CLen<maxLen){
            ++CLen;
            ok = false;
            for(Vertex v:cur){
                if(v.IsFinal())
                    ok = true;
                keys = v.getKeys();
                for(Character c:keys){
                    ways = v.getWays(c);
                    for(Vertex to:ways){
                        next.add(to);
                    }
                }
            }
            if(ok == false)
                return CLen;
            cur = next;
            next = new TreeSet<>(new VertexCompare()); 
        }
        
        return -1;
    }
    public void initDfs(){
        dfs(vert.get(start),"");
    }
    
    public void generateCycles(){
        for(Vertex v:vert){
            qdfs(v,v,0);
           // System.out.println("Clen = "+v.cycleLen);
        }
    }
    private int gcd(int a,int b){
        while(a>0 && b>0){
            a%=b;
            if(a>0)b%=a;
        }
        return a+b;
    }
    
    public void qdfs(Vertex v,Vertex end,int h){
        if(h>30)
            return;
        if(h>0 && v == end)
            v.cycleLen = gcd(v.cycleLen,h);
        
        ArrayList<Vertex> ways;
        Set<Character> keys = v.getKeys();
        //out(keys.size()+"\n");
        for(Character c:keys){
            ways = v.getWays(c);
            //out("")
            for(Vertex vv:ways){
                qdfs(vv,end,h+1);
            }
        }
    }
    
    public void findfs(Vertex v,int k,int b){
     //   out("findfs "+v+ " " + k+ " "+ b+  "\n");
        if(v.IsVisited())
            return;
        
        v.SetVisited(true);
        if(v.cycleLen !=0){
            k = gcd(k,v.cycleLen);
            
        }
        if(k!=0)
            b%=k;
       // out("findfs "+v+ " " + k+ " "+ b+" "+ v.cycleLen+  "\n");
        if(v.IsFinal() && k!=0){
              u.addLine(k, b);
        }
        
        ArrayList<Vertex> ways;
        Set<Character> keys = v.getKeys();
        //out(keys.size()+"\n");
        for(Character c:keys){
            ways = v.getWays(c);
            //out("")
            for(Vertex vv:ways){
                findfs(vv,k,b+1);
            }
        }
    }
    
    public boolean fullCheck(){
        findfs(vert.get(start),0,0);
        return u.IsFull();
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

class VertexCompare implements Comparator<Vertex>{
   @Override
   public int compare(Vertex a,Vertex b){
       return System.identityHashCode(a) - System.identityHashCode(b); 
   } 
}


