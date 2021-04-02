package observer.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class EstacionMeteorologicaGUI extends JFrame {
    private JPanel estacionPanel;
    private JButton notificationBotton;
    private JTextArea infoTemperatura;
    private JTable usersTable;
    private JPanel panelTable;
    private JLabel temperaturaLabel;
    private JLabel listUsersLabel;
    private JButton addUserButton;
    private JTextField nameUserInput;
    private JTextArea showMessageButton;
    private JLabel nameUserLabel;
    private JPanel panelUnsubscriber;
    private JFrame frameEstacion;
    private List<JButton> listButtonUnsubscribe;

    public EstacionMeteorologicaGUI() {
        this.setEstacionPanel(estacionPanel);
        this.getEstacionPanel().setPreferredSize(new Dimension(580, 400));
        this.setNotificationBotton(notificationBotton);
        this.setUsersTable(usersTable);
        this.setPanelTable(panelTable);
        this.setTemperaturaLabel(temperaturaLabel);
        this.setInfoTemperatura(infoTemperatura);
        this.setListUsersLabel(listUsersLabel);
        this.setAddUserButton(addUserButton);
        this.setNameUserInput(nameUserInput);
        this.setShowMessageButton(showMessageButton);
        this.setNameUserLabel(nameUserLabel);
        this.setPanelUnsubscriber(panelUnsubscriber);
        this.setListButtonUnsubscribe(new ArrayList<JButton>());

        this.frameEstacion = new JFrame("EstacionMeteorologicaGUI");
        this.getAddUserButton().setText("Subscribir usuario");
        this.getNotificationBotton().setText("Notificar");
        this.getTemperaturaLabel().setText("Temperatura");
        this.getListUsersLabel().setText("Usuarios");
        this.getNameUserLabel().setText("Nombre de nuevo Usuario");
        //this.getInfoTemperatura().setPreferredSize(new Dimension(400, 50));
        this.getInfoTemperatura().setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        this.getShowMessageButton().setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
    }

    public static void main(String[] args) {
        EstacionMeteorologicaGUI est = new EstacionMeteorologicaGUI();
        est.setFrame();
    }

    public void setFrame() {
        this.subscribeUser();
        this.setDataTableUsers();
        this.setMessageForNotification();
        this.sentNotificacion();
        this.showMessageNotification();
        this.setButtonsUnsbuscribe();
        this.selectUnsubscribe();

        this.getFrameEstacion().setContentPane(this.getEstacionPanel());
        this.getFrameEstacion().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getFrameEstacion().pack();
        this.getFrameEstacion().setLocationRelativeTo(null);
        this.getFrameEstacion().setVisible(true);
    }

    public void setListUsers() {

    }

    public void showMessageNotification() {
        this.getShowMessageButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)) {
                    //Operacion para mostrar el mensaje de notifcacion de los usuarios

                }
            }
        });
    }

    public void sentNotificacion() {
        this.getNotificationBotton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)) {
                    //Operacion de enviar notificacion

                    JOptionPane.showMessageDialog(null, "Se ha enviado la notificación a los usuarios");
                }
            }
        });
    }

    public void subscribeUser() {
        this.getAddUserButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)) {
                    //Operacion para subscribir
                }
            }
        });
    }

    public void setButtonsUnsbuscribe() {
        int cantUsers = 5;
        for(int i=0; i<cantUsers; i++) {
            JButton unsubscribeButton = new JButton("Usuario Nª " + String.valueOf(i+1).concat(" Unsubscribe"));
            unsubscribeButton.setPreferredSize(new Dimension(200, 20));
            this.getListButtonUnsubscribe().add(unsubscribeButton);
        }
        Box box = Box.createVerticalBox();
        for(int i=0; i<this.getListButtonUnsubscribe().size(); i++) {
            box.add(this.getListButtonUnsubscribe().get(i));
        }
        this.getPanelUnsubscriber().add(box);
    }

    public void unsubscribe(int pos) {
        this.getListButtonUnsubscribe().get(pos).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)) {
                    //Operacion para unsubscribe por indice
                    System.out.println(pos);
                }
            }
        });
    }

    public void selectUnsubscribe() {
        int cantUsers = 5;
        for(int i=0; i<cantUsers; i++) {
            this.unsubscribe(i);
        }
    }

    public void setMessageForNotification() {
        //Operacion para setear los mensajes de temepratura
        this.getInfoTemperatura().setText("18°C - Celsius");
    }

    public void setDataTableUsers() {
        String[] columnNames = {"N°", "Nombre", "Temperatura"};
        Object[][] data = {
                {"1", "Smith", "18°C"},
                {"2", "Doe", "23°C"},
                {"3", "Black", "24°C"},
                {"4", "White", "27°C"},
                {"5", "Brown", "19°C"}
        };
        DefaultTableModel dm = new DefaultTableModel();
        dm.setDataVector(data, columnNames);
        this.getUsersTable().setModel(dm);
        //JScrollPane scrollPane = new JScrollPane(this.getUsersTable());
        //this.getUsersTable().setBounds(30, 40, 200, 300);
        //this.getFrameEstacion().add(scrollPane);
        //TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        //this.getUsersTable().getColumn("Vegetarian").setCellRenderer(buttonRenderer);
        this.getUsersTable().setFillsViewportHeight(true);
        this.getPanelTable().setLayout(new BorderLayout());
        this.getPanelTable().add(this.getUsersTable().getTableHeader(), BorderLayout.PAGE_START);
        this.getPanelTable().add(this.getUsersTable(), BorderLayout.CENTER);

        TableColumn column = null;
        for (int i = 0; i < 3; i++) {
            column = this.getUsersTable().getColumnModel().getColumn(i);
            if (i == 2) {
                column.setPreferredWidth(100); //third column is bigger
            } else {
                column.setPreferredWidth(50);
            }
        }
    }

    public JLabel getListUsersLabel() {
        return listUsersLabel;
    }

    public void setListUsersLabel(JLabel listUsersLabel) {
        this.listUsersLabel = listUsersLabel;
    }

    public JPanel getPanelTable() {
        return panelTable;
    }

    public void setPanelTable(JPanel panelTable) {
        this.panelTable = panelTable;
    }

    public JPanel getEstacionPanel() {
        return estacionPanel;
    }

    public JFrame getFrameEstacion() {
        return frameEstacion;
    }

    public void setFrameEstacion(JFrame frameEstacion) {
        this.frameEstacion = frameEstacion;
    }

    public void setEstacionPanel(JPanel estacionPanel) {
        this.estacionPanel = estacionPanel;
    }

    public JButton getNotificationBotton() {
        return notificationBotton;
    }

    public void setNotificationBotton(JButton userBotton) {
        this.notificationBotton = userBotton;
    }

    public JTable getUsersTable() {
        return usersTable;
    }

    public void setUsersTable(JTable usersTable) {
        this.usersTable = usersTable;
    }

    public JLabel getTemperaturaLabel() {
        return temperaturaLabel;
    }

    public void setTemperaturaLabel(JLabel temperaturaLabel) {
        this.temperaturaLabel = temperaturaLabel;
    }

    public JTextArea getInfoTemperatura() {
        return infoTemperatura;
    }

    public void setInfoTemperatura(JTextArea infoTemperatura) {
        this.infoTemperatura = infoTemperatura;
    }

    public JButton getAddUserButton() {
        return addUserButton;
    }

    public void setAddUserButton(JButton addUserButton) {
        this.addUserButton = addUserButton;
    }

    public JTextField getNameUserInput() {
        return nameUserInput;
    }

    public void setNameUserInput(JTextField nameUserInput) {
        this.nameUserInput = nameUserInput;
    }

    public JTextArea getShowMessageButton() {
        return showMessageButton;
    }

    public void setShowMessageButton(JTextArea showMessageButton) {
        this.showMessageButton = showMessageButton;
    }

    public JLabel getNameUserLabel() {
        return nameUserLabel;
    }

    public void setNameUserLabel(JLabel nameUserLabel) {
        this.nameUserLabel = nameUserLabel;
    }

    public JPanel getPanelUnsubscriber() {
        return panelUnsubscriber;
    }

    public void setPanelUnsubscriber(JPanel panelUnsubscriber) {
        this.panelUnsubscriber = panelUnsubscriber;
    }

    public List<JButton> getListButtonUnsubscribe() {
        return listButtonUnsubscribe;
    }

    public void setListButtonUnsubscribe(List<JButton> listButtonUnsubscribe) {
        this.listButtonUnsubscribe = listButtonUnsubscribe;
    }
}
