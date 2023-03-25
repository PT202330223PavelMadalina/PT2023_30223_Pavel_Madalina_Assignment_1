package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form1 {
    public Form1() {

        JFrame frame = new JFrame("Calculator");
        frame.setIconImage(new ImageIcon("src/calculator.png").getImage());



        panel1.setBounds(0,0,500,400);
        panel1.setBackground(new Color(135,206,250));
        panel1.setLayout(null);
        l1.setBounds(100,0,300,30);
        l1.setFont(new Font("serif",Font.BOLD,20));
        l1.setForeground(new Color(70,130,180));
        panel1.add(l1);
        l2.setBounds(50,50,200,30);
        l2.setFont(new Font("serif",Font.ITALIC,20));
        l2.setForeground(new Color(70,130,180));
        panel1.add(l2);
        t1.setBounds(250,50,200,30);
        panel1.add(t1);
        t2.setBounds(250,100,200,30);
        panel1.add(t2);
        l3.setBounds(50,100,200,30);
        l3.setFont(new Font("serif",Font.ITALIC,20));
        l3.setForeground(new Color(70,130,180));
        panel1.add(l3);

        addButton.setBackground(new Color(0,0,128));
        addButton.setForeground(Color.white);
        addButton.setBounds(50,150,150,30);
        panel1.add(addButton);

        substractButton.setBackground(new Color(0,0,128));
        substractButton.setForeground(Color.white);
        substractButton.setBounds(50,200,150,30);
        panel1.add(substractButton);

        multiplicateButton.setBackground(new Color(0,0,128));
        multiplicateButton.setForeground(Color.white);
        multiplicateButton.setBounds(50,250,150,30);
        panel1.add(multiplicateButton);

        divideButton.setBackground(new Color(0,0,128));
        divideButton.setForeground(Color.white);
        divideButton.setBounds(280,150,150,30);
        panel1.add(divideButton);

        integrateButton.setBackground(new Color(0,0,128));
        integrateButton.setForeground(Color.white);
        integrateButton.setBounds(280,200,150,30);
        panel1.add(integrateButton);

        derivateButton.setBackground(new Color(0,0,128));
        derivateButton.setForeground(Color.white);
        derivateButton.setBounds(280,250,150,30);
        panel1.add(derivateButton);

        cancelButton.setBackground(new Color(0,0,128));
        cancelButton.setForeground(Color.white);
        cancelButton.setBounds(280,350,150,30);
        panel1.add(cancelButton);

        result.setBounds(50,300,300,30);
        result.setFont(new Font("serif",Font.BOLD,20));
        result.setForeground(new Color(70,130,180));
        panel1.add(result);

        t3.setBounds(250,300,200,30);
        panel1.add(t3);


        frame.setBounds(0, 0, 500, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         frame.add(panel1);
        frame.setVisible(true);




    }

    JFrame f;
    JPanel panel1=new JPanel();
    private Label l1=new Label("POLYNOMIAL CALCULATOR");
    private Label l2=new Label("First Polynomial=");
    private JTextField t1=new JTextField();
    private JTextField t2=new JTextField();
    private JTextField t3=new JTextField();
    private JButton addButton=new JButton("Add");
    private JButton substractButton=new JButton("Substract");
    private JButton multiplicateButton=new JButton("Multiplicate");
    private JButton divideButton=new JButton("Divide");
    private JButton derivateButton=new JButton("Derivate");
    private JButton integrateButton=new JButton("Integrate");
    private JLabel result=new JLabel("Result");
    private JButton cancelButton=new JButton("Clear");
    private Label l3=new Label("Second Polynomial=");

    public void setL1(Label l1) {
        this.l1 = l1;
    }

    public void setL2(Label l2) {
        this.l2 = l2;
    }

    public void setT1(JTextField t1) {
        this.t1 = t1;
    }

    public void setT2(JTextField t2) {
        this.t2 = t2;
    }

    public void setT3(JTextField t3) {
        this.t3=t3;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public void setSubstractButton(JButton substractButton) {
        this.substractButton = substractButton;
    }

    public void setMultiplicateButton(JButton multiplicateButton) {
        this.multiplicateButton = multiplicateButton;
    }

    public void setDivideButton(JButton divideButton) {
        this.divideButton = divideButton;
    }

    public void setDerivateButton(JButton derivateButton) {
        this.derivateButton = derivateButton;
    }

    public void setIntegrateButton(JButton integrateButton) {
        this.integrateButton = integrateButton;
    }

    public void setResult(JLabel result) {
        this.result = result;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public void setL3(Label l3) {
        this.l3 = l3;
    }

    public Label getL1() {
        return l1;
    }

    public Label getL2() {
        return l2;
    }

    public JTextField getT1() {
        return t1;
    }

    public JTextField getT2() {
        return t2;
    }

    public JTextField getT3() {
        return t3;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSubstractButton() {
        return substractButton;
    }

    public JButton getMultiplicateButton() {
        return multiplicateButton;
    }

    public JButton getDivideButton() {
        return divideButton;
    }

    public JButton getDerivateButton() {
        return derivateButton;
    }

    public JButton getIntegrateButton() {
        return integrateButton;
    }

    public JLabel getResult() {
        return result;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public Label getL3() {
        return l3;
    }
}
