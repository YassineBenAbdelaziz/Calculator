import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.NoSuchElementException;

public class InterfaceGraphique implements ActionListener{

    private JFrame frame ;
    private JLabel l;
    private JPanel panel;
    private JButton[] buttons ;
    private String[] labels = {"7","8","9","+","4","5","6","-","1","2","3","*","0","B","C","/","(",")",".","="};


    public InterfaceGraphique() {
        // Initialize objects
        frame = new JFrame();
        panel = new JPanel();
        l = new JLabel("", SwingConstants.CENTER);
        buttons = new JButton[20];
        
        }

    public void CreerInterface() {
        
        // Label Creation
        l.setBounds(25, 25, 335, 50);
        l.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        l.setFont(new Font("Serif", Font.BOLD, 16));
        l.setBackground(Color.white);
        l.setOpaque(true);

        
        

        // Adding Buttons
        int i;
        int x = 40, y = 100;
        for (i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(labels[i]);
            buttons[i].setFont(new Font("Helvetica", Font.BOLD, 16));
            buttons[i].setBounds(x, y, 60, 60);
            

            if (x + 80 < 300) {
                x = x + 80;
            }
            else {
                x = 40;
                y = y + 80;
            }
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
            
        }

        // Panel management

        panel.add(l);
        panel.setBounds(0, 0, 400, 600);
        panel.setLayout(null);
        panel.setBackground(Color.gray);
        
        // Frame
        
        frame.add(panel);       
        frame.setSize(400, 600);       
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Calculette V0.99");
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    // On Button pressed Call back

        if (e.getSource() == buttons[0]) {
            l.setText(l.getText() + "7");
        } else if (e.getSource() == buttons[1]) {
            l.setText(l.getText() + "8");
        } else if (e.getSource() == buttons[2]) {
            l.setText(l.getText() + "9");
        } else if (e.getSource() == buttons[3]) {
            l.setText(l.getText() + "+");
        } else if (e.getSource() == buttons[4]) {
            l.setText(l.getText() + "4");
        } else if (e.getSource() == buttons[5]) {
            l.setText(l.getText() + "5");
        } else if (e.getSource() == buttons[6]) {
            l.setText(l.getText() + "6");
        } else if (e.getSource() == buttons[7]) {
            l.setText(l.getText() + "-");
        } else if (e.getSource() == buttons[8]) {
            l.setText(l.getText() + "1");
        } else if (e.getSource() == buttons[9]) {
            l.setText(l.getText() + "2");
        } else if (e.getSource() == buttons[10]) {
            l.setText(l.getText() + "3");
        } else if (e.getSource() == buttons[11]) {
            l.setText(l.getText() + "*");
        } else if (e.getSource() == buttons[12]) {
            l.setText(l.getText() + "0");
        } else if (e.getSource() == buttons[13]) {                      // Backspace
            if (l.getText().length() > 0) {
                l.setText(l.getText().substring(0, l.getText().length() - 1));
            }
        } else if (e.getSource() == buttons[14]) {                       // Clear
            l.setText("");
        } else if (e.getSource() == buttons[15]) {
            l.setText(l.getText() + "/");
        } else if (e.getSource() == buttons[16]) {
            l.setText(l.getText() + "(");
        } else if (e.getSource() == buttons[17]) {
            l.setText(l.getText() + ")");
        } else if (e.getSource() == buttons[18]) {
            l.setText(l.getText() + ".");
        } else if (e.getSource() == buttons[19]) {
            // Evaluate expressions 
            Expression express = new Expression(l.getText());
            try {
                l.setText(express.Resoudre());

            } catch (IndexOutOfBoundsException | NumberFormatException | NoSuchElementException c) {
                l.setText("Syntax Error");
            }


        }

    }
}
