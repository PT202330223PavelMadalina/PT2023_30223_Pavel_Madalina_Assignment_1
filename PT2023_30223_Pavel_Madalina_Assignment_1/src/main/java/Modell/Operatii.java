package Modell;

import javax.swing.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operatii {


    public static Polynomial adunare(Polynomial polinom1, Polynomial polinom2)
    {
        Polynomial polinom = new Polynomial();
        if(polinom1==null || polinom2==null)
            polinom=null;
        else {

            int ok = 0, ok2 = 0;
            for (Map.Entry<Integer, Float> entry1 : polinom1.getPpolinom().entrySet()) {
                ok = 0;
                for (Map.Entry<Integer, Float> entry2 : polinom2.getPpolinom().entrySet())
                    if (entry1.getKey() == entry2.getKey()) {
                        polinom.adaugare(entry1.getKey(), (entry1.getValue() + entry2.getValue()));
                        ok = 1;
                        break;
                    }
                if (ok == 0)
                    polinom.adaugare(entry1.getKey(), entry1.getValue());
            }
            for (Map.Entry<Integer, Float> entry2 : polinom2.getPpolinom().entrySet()) {
                ok2 = 0;
                for (Map.Entry<Integer, Float> entry3 : polinom.getPpolinom().entrySet()) {
                    if (entry2.getKey() == entry3.getKey()) {
                        ok2 = 1;
                        break;
                    }
                }
                if (ok2 == 0)
                    polinom.adaugare(entry2.getKey(), entry2.getValue());
            }
        }
        return polinom;
    }

    public static Polynomial scadere(Polynomial polinom1, Polynomial polinom2) {
        Polynomial polinom = new Polynomial();
        int ok = 0, ok2 = 0;
        if (polinom1 == null || polinom2 == null)
            polinom = null;
        else{
            for (Map.Entry<Integer, Float> entry1 : polinom1.getPpolinom().entrySet()) {
                ok = 0;
                for (Map.Entry<Integer, Float> entry2 : polinom2.getPpolinom().entrySet())
                    if (entry1.getKey() == entry2.getKey()) {
                        polinom.adaugare(entry1.getKey(), (entry1.getValue() - entry2.getValue()));
                        ok = 1;
                        break;
                    }
                if (ok == 0)
                    polinom.adaugare(entry1.getKey(), entry1.getValue());
            }

        for (Map.Entry<Integer, Float> entry2 : polinom2.getPpolinom().entrySet()) {
            ok2 = 0;
            for (Map.Entry<Integer, Float> entry3 : polinom.getPpolinom().entrySet()) {
                if (entry2.getKey() == entry3.getKey()) {
                    ok2 = 1;
                    break;
                }
            }
            if (ok2 == 0)
                polinom.adaugare(entry2.getKey(), -(entry2.getValue()));
        }
    }

        return polinom;
    }

    public static Polynomial derivare(Polynomial polinom1)
    {
        Polynomial polinom = new Polynomial();
        if(polinom1==null)
            polinom=null;
        else {
            for (Map.Entry<Integer, Float> entry1 : polinom1.getPpolinom().entrySet()) {
                polinom.adaugare(entry1.getKey() - 1, entry1.getValue() * entry1.getKey());
            }
        }
        return polinom;
    }

    public static Polynomial integrare(Polynomial polinom1)
    {
        Polynomial polinom = new Polynomial();
        if(polinom1==null)
            polinom=null;
        else {
            for (Map.Entry<Integer, Float> entry1 : polinom1.getPpolinom().entrySet()) {
                polinom.adaugare(entry1.getKey() + 1, entry1.getValue() / (entry1.getKey() + 1));
            }
        }

        return polinom;
    }

    public static Polynomial inmultire(Polynomial polinom1,Polynomial polinom2)
    {
        Polynomial polinom = new Polynomial();
        if(polinom1==null || polinom2==null)
            polinom=null;
        else {
            for (Map.Entry<Integer, Float> entry1 : polinom1.getPpolinom().entrySet()) {
                for (Map.Entry<Integer, Float> entry2 : polinom2.getPpolinom().entrySet()) {
                    if (polinom.gasire(entry1.getKey() + entry2.getKey()) == true)
                        polinom.modificare(entry1.getKey() + entry2.getKey(), (entry1.getValue() * entry2.getValue()));
                    else
                        polinom.adaugare(entry1.getKey() + entry2.getKey(), (entry1.getValue() * entry2.getValue()));
                }

            }
        }
        return polinom;
    }

    public static void impartire(Polynomial p1, Polynomial p2)
    {
        String rez=new String();
        String rez5=new String();
        String rez6=new String();
       SortedMap<Integer,Float> mapRez=new TreeMap<Integer,Float>(Collections.reverseOrder());
        if(p1.getPpolinom().firstKey()<p2.getPpolinom().firstKey())
        {
            rez="0";
            System.out.println("nu putem");
            //JOptionPane.showMessageDialog(null, "Nu se poate imparti astfel!", null, JOptionPane.WARNING_MESSAGE);
        }
        else
        {
              int cont=0;
            Polynomial pNou=new Polynomial();
            //pNou=p1;
            SortedMap.Entry<Integer, Float> firstEntryP2 = p2.getPpolinom().entrySet().iterator().next();

            while(p1.getPpolinom().firstKey()>=p2.getPpolinom().firstKey())
            {
                Polynomial p3=new Polynomial();
                Polynomial p4=new Polynomial();
                Polynomial p5=new Polynomial();
                Polynomial p6=new Polynomial();
                cont++;


                mapRez.clear();
                System.out.println();
                //Operatii.polynomialToString(pNou);
                SortedMap.Entry<Integer, Float> firstEntryP1= p1.getPpolinom().entrySet().iterator().next();

                System.out.println(firstEntryP1.getKey());
                System.out.println(firstEntryP1.getValue());
                mapRez.put((firstEntryP1.getKey()-firstEntryP2.getKey()),firstEntryP1.getValue()/firstEntryP2.getValue());
                SortedMap.Entry<Integer, Float> firstEntryRez = mapRez.entrySet().iterator().next();


                if(firstEntryRez.getValue()==1)
                    if(firstEntryRez.getKey()==1)
                        rez+="+x";
                    else
                        if(firstEntryRez.getKey()!=0)
                      rez+="+"+"x^"+firstEntryRez.getKey();
                else
                    rez+="+"+firstEntryRez.getValue()+"x^"+firstEntryRez.getKey();

                p4=Operatii.stringToPolynomial(rez);
                //Operatii.polynomialToString(p4);
                p3.setPpolinom(p4.getPpolinom());
                //Operatii.polynomialToString(p3);
                SortedMap<Integer, Float> mapRezFinal2 = new TreeMap<>(Collections.reverseOrder());
                mapRezFinal2.clear();
                for (Map.Entry<Integer, Float> termen : p3.getPpolinom().entrySet()) {
                    if (termen.getValue() != 0) {
                        mapRezFinal2.put(termen.getKey(), termen.getValue());
                    }
                }
                if (mapRezFinal2.isEmpty()) {
                    break;
                } else {
                    p3.setPpolinom(mapRezFinal2);
                }


                p5=Operatii.inmultire(p3,p2);

                SortedMap<Integer, Float> mapRezFinal3 = new TreeMap<>(Collections.reverseOrder());
                mapRezFinal3.clear();
                for (Map.Entry<Integer, Float> termen : p5.getPpolinom().entrySet()) {
                    if (termen.getValue() != 0) {
                        mapRezFinal3.put(termen.getKey(), termen.getValue());
                    }
                }
                if (mapRezFinal3.isEmpty()) {
                    break;
                } else {
                    p5.setPpolinom(mapRezFinal3);
                }
                //Operatii.polynomialToString(p1);
                System.out.println("offfffffffffffffffff");
                //Operatii.polynomialToString(p5);
                ///System.out.println(rez5);
                p6=Operatii.scadere(p1,p5);
                //Operatii.polynomialToString(p6);
                //System.out.println(rez6);
                pNou.setPpolinom(p6.getPpolinom());
                SortedMap<Integer, Float> mapRezFinal = new TreeMap<>(Collections.reverseOrder());
                mapRezFinal.clear();
                for (Map.Entry<Integer, Float> termen : p6.getPpolinom().entrySet()) {
                    if (termen.getValue() != 0) {
                        mapRezFinal.put(termen.getKey(), termen.getValue());
                    }
                }
                if (mapRezFinal.isEmpty()) {
                    break;
                } else {
                    pNou.setPpolinom(mapRezFinal);
                }


                p1=pNou;


            }

            //SortedMap.Entry<Integer, Float> firstEntryP1 = p1.getPpolinom().entrySet().iterator().next();
            //rez+="+"+firstEntryP1.getValue();


        }
        //return rez;
    }

    public static String polynomialToString(Polynomial p)
    {
        String s=new String();
        if(p==null)
            s="0";
        else
        {
            for(Map.Entry<Integer,Float> entry: p.getPpolinom().entrySet()){

                if(entry.getKey()>1 && entry.getValue()>1)
                {
                    s+="+"+String.format("%.2f",entry.getValue())+"x^"+ entry.getKey();
                    System.out.print("+"+String.format("%.2f",entry.getValue())+"x^"+ entry.getKey());
                }
                if(entry.getKey()==0)
                {
                    if(entry.getValue()>=1)
                    {
                        s+="+"+String.format("%.2f",entry.getValue());
                        System.out.print("+"+String.format("%.2f",entry.getValue()));
                    }
                    else
                    if(entry.getValue()>0 && entry.getValue()<1)
                    {
                        s+="+"+String.format("%.2f",entry.getValue());
                        System.out.print("+"+String.format("%.2f",entry.getValue()));
                    }
                    else
                    if(entry.getValue()<0)
                    {
                        s+=String.format("%.2f",entry.getValue());
                        System.out.print(String.format("%.2f",entry.getValue()));
                    }
                }
                if(entry.getKey()==1)
                {
                    if(entry.getValue()==1)
                    {
                        s+="+x";
                        System.out.println("+x");
                    }
                    else
                    if(entry.getValue()==-1)
                    {
                        s+="-x";
                        System.out.println("-x");
                    }
                    else
                    if(entry.getValue()>1)
                    {
                        s+="+"+String.format("%.2f",entry.getValue())+"x";
                        System.out.print("+"+String.format("%.2f",entry.getValue())+"x");
                    }
                    else
                    if(entry.getValue()>0 && entry.getValue()<1)
                    {
                        s+="+"+String.format("%.2f",entry.getValue());
                        System.out.print("+"+String.format("%.2f",entry.getValue()));
                    }
                    else
                    if(entry.getValue()<0)
                    {
                        s+=String.format("%.2f",entry.getValue())+"x";
                        System.out.print(String.format("%.2f",entry.getValue())+"x");
                    }
                }
                if(entry.getKey()>1)
                {
                    if(entry.getValue()==1)
                    {
                        s+="+"+"x^"+ entry.getKey();
                        System.out.print("+"+"x^"+ entry.getKey());
                    }
                    else
                    if(entry.getValue()==-1)
                    {
                        s+="-"+"x^"+ entry.getKey();
                        System.out.println("-"+"x^"+ entry.getKey());
                    }
                    else
                    if(entry.getValue()<1)
                    {
                        if(entry.getValue()>0)
                        {
                            s+="+"+String.format("%.2f",entry.getValue())+"x^"+ entry.getKey();
                            System.out.print("+"+String.format("%.2f",entry.getValue())+"x^"+ entry.getKey());
                        }
                        else
                        if(entry.getValue()!=0)
                        {

                            s+=String.format("%.2f",entry.getValue())+"x^"+ entry.getKey();
                            System.out.print(String.format("%.2f",entry.getValue())+"x^"+ entry.getKey());
                        }

                    }
                    else
                    if(entry.getValue()<0)
                    {
                        s+="-"+String.format("%.2f",entry.getValue())+"x";
                        System.out.print(String.format("%.2f",entry.getValue())+"x");
                    }
                }
            }
            if(s.isEmpty())
                s="0";

        }
        return s;

    }

    public static Polynomial stringToPolynomial(String s) {
        Polynomial poli = new Polynomial();
        try {
            int cont = 0,contf=0;
            String sWrong = s;
            Pattern wrongPattern = Pattern.compile("[!@#$%&*():;_=[a-wA-WyYzZ]]");
            Matcher wrongMatcher = wrongPattern.matcher(sWrong);
            while (wrongMatcher.find())
                cont++;

            Pattern pattern = Pattern.compile("([+-]?)(\\d*)([xX]\\^?)?(\\d*)");
            //Pattern pattern = Pattern.compile(" ^([-+]?([0-9]*\\.?[0-9]+)?(x(\\^[+-]?[0-9]+)?)?)+");
            Matcher matcher = pattern.matcher(s);
            Integer unu = 1;
            Integer zero = 0;

            if (cont != 0)
            {
                poli=null;
                contf++;
                //JOptionPane.showMessageDialog(null, "Introduceti un polinom valid!", null, JOptionPane.WARNING_MESSAGE);
            }
            else {
                while (matcher.find()) {

                    String semn = matcher.group(1);
                    String coef = matcher.group(2);
                    String exp = matcher.group(4);
                    System.out.println("semn:" + semn);
                    System.out.println("coef:" + coef);
                    System.out.println("exp:" + exp);
                    if(matcher.group().contains("^") &&(matcher.group().contains("x")==false && matcher.group().contains("X")==false))
                        contf++;
                    //if (coef.equals("1") || exp.equals("1") || coef.equals("0") || exp.equals("0") && (matcher.group().contains("x")|| matcher.group().contains("X")))
                    //  JOptionPane.showMessageDialog(null, "Introduceti un polinom valid!", null, JOptionPane.WARNING_MESSAGE);
                    if (matcher.group(1).equals("") && matcher.group(2).equals("") && matcher.group(4).equals(""))
                        break;
                    if (exp.equals("")) {
                        if (matcher.group().contains("x") || matcher.group().contains("X"))
                            exp = "1";
                        else
                            exp = "0";
                    }
                    if (coef.equals("")) {
                        if ((semn.equals("+")|| semn.equals("")) && (matcher.group().contains("x")|| matcher.group().contains("X"))) {coef = "1";
                        } else
                            if(matcher.group().contains("x")|| matcher.group().contains("X"))
                            coef = "-1";
                    } else {
                        if (semn.equals("-")) {
                            coef = "-" + coef;
                        }

                    }
                    if(exp.compareTo("1")>0 && matcher.group().contains("^")==false)
                        contf++;


                    poli.getPpolinom().put(Integer.parseInt(exp), Float.parseFloat(coef));

                }

            }
            if (contf != 0)
            {
                poli=null;
                JOptionPane.showMessageDialog(null, "Introduceti un polinom valid!", null, JOptionPane.WARNING_MESSAGE);
            }

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Introduceti un polinom valid!", null, JOptionPane.WARNING_MESSAGE);
            poli=null;
        }
        return poli;
    }

}
