import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form1 {
    public Form1()
    {


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Am apasat butonul");
            }
        });
    }
    JFrame f;
    JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton addButton;
    private JButton substractButton;
    private JButton multiplicateButton;
    private JButton divideButton;
    private JButton derivateButton;
    private JButton integrateButton;
    private JButton resultButton;
    private JButton cancelButton;
    private JTextField textField3;



    private void createUIComponents() {


    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculator");
        frame.setIconImage(new ImageIcon("src/calculator.png").getImage());

        frame.setContentPane(new Form1().panel1);
        frame.setBounds(0,0,900,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
