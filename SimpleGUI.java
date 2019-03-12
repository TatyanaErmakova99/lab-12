import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGUI extends JFrame {
    private JButton button = new JButton("Enter");
    private JTextField input = new JTextField("", 8);
    private JLabel label = new JLabel("Input:");
    private JRadioButton left = new JRadioButton("\n" + "left");
    private JRadioButton right = new JRadioButton("\n" + "right");
    private JCheckBox check = new JCheckBox("Check", false);

    public SimpleGUI() {
        super("GUI Program");
        this.setBounds(250,250,300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(5,2,2,1));
        container.add(label);
        container.add(input);

        ButtonGroup group = new ButtonGroup();
        group.add(left);
        group.add(right);
        container.add(left);

        left.setSelected(true);
        container.add(right);
        container.add(check);
        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = "";
            message += "Button was entered\n";
            message += "Text is " + input.getText() + "\n";
            message += (left.isSelected()?"left":"right")
                    + " is selected\n";
            message += "CheckBox is " + ((check.isSelected())
                    ?"checked":"unchecked");
            JOptionPane.showMessageDialog(null,
                    message,
                    "Output",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SimpleGUI app = new SimpleGUI();
        app.setVisible(true);
    }
}