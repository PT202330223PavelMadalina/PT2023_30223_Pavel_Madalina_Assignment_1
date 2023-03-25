package Modell;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map;

public class Operatii {

    public static Polynomial adunare(Polynomial polinom1, Polynomial polinom2)
    {
        Polynomial polinom = new Polynomial();
        int ok=0,ok2=0;
        for(Map.Entry<Integer,Float> entry1: polinom1.getPpolinom().entrySet())
        {
            ok=0;
            for(Map.Entry<Integer,Float> entry2: polinom2.getPpolinom().entrySet())
                if(entry1.getKey()== entry2.getKey())
                {
                    polinom.adaugare(entry1.getKey(),(entry1.getValue()+ entry2.getValue()));
                    ok=1;
                    break;
                }
            if(ok==0)
                polinom.adaugare(entry1.getKey(), entry1.getValue());
        }
        for(Map.Entry<Integer,Float> entry2: polinom2.getPpolinom().entrySet())
        { ok2=0;
            for(Map.Entry<Integer,Float> entry3:polinom.getPpolinom().entrySet())
            {
                if(entry2.getKey()== entry3.getKey())
                {
                    ok2=1;
                    break;
                }
            }
            if(ok2==0)
                polinom.adaugare(entry2.getKey(), entry2.getValue());
        }
        return polinom;
    }

    public static Polynomial scadere(Polynomial polinom1, Polynomial polinom2)
    {
        Polynomial polinom = new Polynomial();
        int ok=0,ok2=0;

        for(Map.Entry<Integer,Float> entry1: polinom1.getPpolinom().entrySet())
        {
            ok=0;
            for(Map.Entry<Integer,Float> entry2: polinom2.getPpolinom().entrySet())
                if(entry1.getKey()== entry2.getKey())
                {
                    polinom.adaugare(entry1.getKey(),(entry1.getValue()- entry2.getValue()));
                    ok=1;
                    break;
                }
            if(ok==0)
                polinom.adaugare(entry1.getKey(), entry1.getValue());
        }

        for(Map.Entry<Integer,Float> entry2: polinom2.getPpolinom().entrySet())
        { ok2=0;
            for(Map.Entry<Integer,Float> entry3:polinom.getPpolinom().entrySet())
            {
                if(entry2.getKey()== entry3.getKey())
                {
                    ok2=1;
                    break;
                }
            }
            if(ok2==0)
                polinom.adaugare(entry2.getKey(), -(entry2.getValue()));
        }
        return polinom;
    }

    public static Polynomial derivare(Polynomial polinom1)
    {
        Polynomial polinom = new Polynomial();

        for(Map.Entry<Integer,Float> entry1: polinom1.getPpolinom().entrySet())
        {
            polinom.adaugare(entry1.getKey()-1, entry1.getValue()* entry1.getKey());
        }

        return polinom;
    }

    public static Polynomial integrare(Polynomial polinom1)
    {
        Polynomial polinom = new Polynomial();

        for(Map.Entry<Integer,Float> entry1: polinom1.getPpolinom().entrySet())
        {
            polinom.adaugare(entry1.getKey()+1,  entry1.getValue()/ (entry1.getKey()+1));
        }

        return polinom;
    }

    public static Polynomial inmultire(Polynomial polinom1,Polynomial polinom2)
    {
        Polynomial polinom = new Polynomial();
        for(Map.Entry<Integer,Float> entry1: polinom1.getPpolinom().entrySet())
        {
            for(Map.Entry<Integer,Float> entry2: polinom2.getPpolinom().entrySet())
            {
                if(polinom.gasire(entry1.getKey()+ entry2.getKey())==true)
                polinom.modificare(entry1.getKey()+entry2.getKey(),(entry1.getValue()*entry2.getValue()));
                else
                    polinom.adaugare(entry1.getKey()+ entry2.getKey(),(entry1.getValue()*entry2.getValue()));
            }

        }
        return polinom;
    }

    public static String polynomialToString(Polynomial p)
    {
        String s=new String();
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
        return s;

    }

    public static Polynomial stringToPolynomial(String s) {
        Polynomial poli = new Polynomial();
            int cont=0;
            String sWrong=s;
            Pattern wrongPattern=Pattern.compile("[!@#$%&*()_=]");
            Matcher wrongMatcher=wrongPattern.matcher(sWrong);
            while(wrongMatcher.find())
                cont++;

            Pattern pattern = Pattern.compile("([+-]?)(\\d*)[xX]?\\^?(\\d*)");
            //Pattern pattern = Pattern.compile(" ^([-+]?([0-9]*\\.?[0-9]+)?(x(\\^[+-]?[0-9]+)?)?)+");
            Matcher matcher = pattern.matcher(s);
            Integer unu = 1;
            Integer zero = 0;

        if(cont!=0)
            JOptionPane.showMessageDialog(null, "Introduceti un polinom valid!", null, JOptionPane.WARNING_MESSAGE);
        else
        {
            while (matcher.find()) {

                String semn = matcher.group(1);
                String coef = matcher.group(2);
                String exp = matcher.group(3);
                //if (coef.equals("1") || exp.equals("1") || coef.equals("0") || exp.equals("0") && (matcher.group().contains("x")|| matcher.group().contains("X")))
                //  JOptionPane.showMessageDialog(null, "Introduceti un polinom valid!", null, JOptionPane.WARNING_MESSAGE);
                if (matcher.group(0).equals("") && matcher.group(1).equals("") && matcher.group(2).equals(""))
                    break;
                if (exp.equals("")) {
                    if (matcher.group().contains("x") || matcher.group().contains("X"))
                        exp = "1";
                    else
                        exp = "0";
                }
                if (coef.equals("")) {
                    if (semn.equals("+")) coef = "1";
                    else if (semn.equals("")) {
                        coef = "1";
                    } else
                        coef = "-1";
                } else {
                    if (semn.equals("-")) {
                        coef = "-" + coef;
                    }

                }

                System.out.println("semn:" + semn);
                System.out.println("coef:" + coef);
                System.out.println("exp:" + exp);
                poli.getPpolinom().put(Integer.parseInt(exp), Float.parseFloat(coef));

            }

        }


        return poli;
    }

}
