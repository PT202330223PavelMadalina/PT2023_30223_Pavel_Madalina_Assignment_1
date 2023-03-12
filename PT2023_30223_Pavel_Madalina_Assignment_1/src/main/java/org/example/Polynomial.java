package org.example;

import java.util.*;

public class Polynomial {
    private SortedMap <Integer,Integer> ppolinom;
    public Polynomial()
    {
        ppolinom=new TreeMap<Integer,Integer>();
    }
    public void adaugare(Integer p, Integer c)
    {
        ppolinom.put(p,c);
    }
    public void afisare()
    {

        for(Map.Entry<Integer,Integer> entry: ppolinom.entrySet()){
            if(entry.getValue()>0)
            System.out.print("+"+entry.getValue()+"x^"+ entry.getKey());
            else
                System.out.print("-"+entry.getValue()+"x^"+ entry.getKey());
        }

    }

}
