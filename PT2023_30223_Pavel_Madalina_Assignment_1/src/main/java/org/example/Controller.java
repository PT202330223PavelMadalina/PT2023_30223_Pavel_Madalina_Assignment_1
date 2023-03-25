package org.example;

import View.Form1;
import Modell.Operatii;
import Modell.Polynomial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    public Controller()
    {
        Form1 ff=new Form1();
        ff.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Am apasat butonul");
                String text1= ff.getT1().getText();
                String text2=ff.getT2().getText();
                //System.out.println(text1);
               Polynomial p1=new Polynomial();
               Polynomial p2=new Polynomial();
               p1= Operatii.stringToPolynomial(text1);
               System.out.println("newpol");
               p2=Operatii.stringToPolynomial(text2);
               Polynomial pRez=Operatii.adunare(p1,p2);
               String sirRez=Operatii.polynomialToString(pRez);
               ff.getT3().setText(sirRez);


            }
        });

        ff.getSubstractButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Am apasat butonul");
                String text1= ff.getT1().getText();
                String text2=ff.getT2().getText();
                //System.out.println(text1);
                Polynomial p1=new Polynomial();
                Polynomial p2=new Polynomial();
                p1=Operatii.stringToPolynomial(text1);
                p2=Operatii.stringToPolynomial(text2);
                Polynomial pRez=Operatii.scadere(p1,p2);
                String sirRez=Operatii.polynomialToString(pRez);
                ff.getT3().setText(sirRez);


            }
        });

        ff.getMultiplicateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Am apasat butonul");
                String text1= ff.getT1().getText();
                String text2=ff.getT2().getText();
                //System.out.println(text1);
                Polynomial p1=new Polynomial();
                Polynomial p2=new Polynomial();
                p1=Operatii.stringToPolynomial(text1);
                p2=Operatii.stringToPolynomial(text2);
                Polynomial pRez=Operatii.inmultire(p1,p2);
                String sirRez=Operatii.polynomialToString(pRez);
                ff.getT3().setText(sirRez);


            }
        });

        ff.getDerivateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Am apasat butonul");
                String text1= ff.getT1().getText();
                Polynomial p1=new Polynomial();
                p1=Operatii.stringToPolynomial(text1);
                Polynomial pRez=Operatii.derivare(p1);
                String sirRez=Operatii.polynomialToString(pRez);
                ff.getT3().setText(sirRez);


            }
        });

        ff.getIntegrateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Am apasat butonul");
                String text1= ff.getT1().getText();
                Polynomial p1=new Polynomial();
                p1=Operatii.stringToPolynomial(text1);
                Polynomial pRez=Operatii.integrare(p1);
                String sirRez=Operatii.polynomialToString(pRez);
                ff.getT3().setText(sirRez);


            }
        });



        ff.getCancelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ff.getT1().setText("");
                ff.getT2().setText("");
                ff.getT3().setText("");
            }
        });
    }
}
