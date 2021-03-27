package observer.gui;

import javax.swing.*;

public class EstacionMeteorologicaGUI {
    private JPanel panel1;
    private JTextArea textArea1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("EstacionMeteorologicaGUI");
        frame.setContentPane(new EstacionMeteorologicaGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
