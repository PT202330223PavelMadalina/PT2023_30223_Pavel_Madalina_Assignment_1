package Modell;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private SortedMap <Integer,Float> ppolinom;
    public Polynomial()
    {
        ppolinom=new TreeMap<Integer,Float>(Collections.reverseOrder());
    }
    public void adaugare(Integer p, Float c)
    {
        ppolinom.put(p,c);
    }
    public boolean gasire(Integer p)
    {
        for(Map.Entry<Integer,Float> entry: ppolinom.entrySet())
            if(entry.getKey()==p)
                return true;

            return false;

    }
    public void modificare(Integer p,Float nVal)
    {
        for(Map.Entry<Integer,Float> entry: ppolinom.entrySet())
            if(entry.getKey()==p)
            {
                entry.setValue(entry.getValue()+nVal);
            }
    }



    public SortedMap<Integer, Float> getPpolinom() {
        return ppolinom;
    }
}
