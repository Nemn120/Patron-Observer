package observer.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UsersGUI {
    private JPanel userPanel;
    private JTextArea textArea1;
    private JButton updateButton;
    private JButton unsubscribeButton;

    public UsersGUI() {
        this.setUserPanel(userPanel);
        this.setUpdateButton(updateButton);
        this.setUnsubscribeButton(unsubscribeButton);
        this.updateButton.setText("Actualizar");
        this.unsubscribeButton.setText("Unsubscribe");
        this.unsubscribeUser();
    }

    public void showUserPanel() {
        JFrame frame = new JFrame();
        this.getUserPanel().setPreferredSize(new Dimension(240, 200));
        frame.setContentPane(this.getUserPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    public void unsubscribeUser() {
        this.unsubscribeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)) {
                    //Operacion de unsubscribe
                }
            }
        });
    }

    public JPanel getUserPanel() {
        return userPanel;
    }

    public void setUserPanel(JPanel userPanel) {
        this.userPanel = userPanel;
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public void setTextArea1(JTextArea textArea1) {
        this.textArea1 = textArea1;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(JButton updateButton) {
        this.updateButton = updateButton;
    }

    public JButton getUnsubscribeButton() {
        return unsubscribeButton;
    }

    public void setUnsubscribeButton(JButton unsubscribeButton) {
        this.unsubscribeButton = unsubscribeButton;
    }

}
