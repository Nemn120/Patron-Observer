package observer.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EstacionMeteorologicaGUI extends JFrame {
    private JPanel estacionPanel;
    private JButton notificationBotton;
    private JTextArea infoTemperatura;
    private JTable usersTable;
    private JPanel panelTable;
    private JLabel temperaturaLabel;
    private JLabel listUsersLabel;
    private JButton addUserButton;
    private JFrame frameEstacion;

    public EstacionMeteorologicaGUI() {
        this.setEstacionPanel(estacionPanel);
        this.setNotificationBotton(notificationBotton);
        this.setUsersTable(usersTable);
        this.setPanelTable(panelTable);
        this.setTemperaturaLabel(temperaturaLabel);
        this.setInfoTemperatura(infoTemperatura);
        this.setListUsersLabel(listUsersLabel);
        this.setAddUserButton(addUserButton);

        this.frameEstacion = new JFrame("EstacionMeteorologicaGUI");
        this.getAddUserButton().setText("Subscribir usuario");
        this.getNotificationBotton().setText("Notificar");
        this.getTemperaturaLabel().setText("Temperatura");
        this.getListUsersLabel().setText("Usuarios");
        //this.getInfoTemperatura().setPreferredSize(new Dimension(400, 50));
        this.getInfoTemperatura().setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        this.subscribeUser();
        this.setDataTableUsers();
        this.showMessageForNotification();
        this.sentNotificacion();
    }

    public static void main(String[] args) {
        EstacionMeteorologicaGUI est = new EstacionMeteorologicaGUI();
        est.setFrame();
    }

    public void setFrame() {
        JPanel estacionMeteorologicaGUI = new EstacionMeteorologicaGUI().estacionPanel;
        estacionMeteorologicaGUI.setPreferredSize(new Dimension(430, 400));
        this.getFrameEstacion().setContentPane(estacionMeteorologicaGUI);
        this.getFrameEstacion().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getFrameEstacion().pack();
        this.getFrameEstacion().setLocationRelativeTo(null);
        this.getFrameEstacion().setVisible(true);
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
                    UsersGUI user = new UsersGUI();
                    user.showUserPanel();
                }
            }
        });
    }

    public void showMessageForNotification() {
        this.getInfoTemperatura().setText("18°C - Celsius");
    }

    public void setDataTableUsers() {
        String[] columnNames = {"First Name", "Last Name", "Sport", "Vegetarian"};
        Object[][] data = {
                {"Kathy", "Smith", "Snowboarding", "Ver"},
                {"John", "Doe", "Rowing", "Ver"},
                {"Sue", "Black", "Knitting", "Ver"},
                {"Jane", "White", "Speed reading", "Ver"},
                {"Joe", "Brown", "Pool", "Ver"}
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
        for (int i = 0; i < 4; i++) {
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
}
