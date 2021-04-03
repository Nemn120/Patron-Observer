package observer.gui;

import observer.business.WeatherCustomer;
import observer.business.WeatherObserver;
import observer.business.WeatherStation;
import observer.business.WeatherSubject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
    private JTextField textField1;
    private JTextField unsuscribe;
    private JButton btnUnsuscribe;
    private JTextArea logInfo;
    private JPanel panelUnsubscriber;
    private JFrame frameEstacion;
    private List<JButton> listButtonUnsubscribe;
    private String[] columnNames;
    private Object[][] data;
    WeatherStation weatherStation;

    public EstacionMeteorologicaGUI() {
        this.weatherStation= new WeatherStation("ESTACION FISI", 0);

        this.setEstacionPanel(estacionPanel);
        this.getEstacionPanel().setPreferredSize(new Dimension(450, 300));
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
        this.setTextField1(textField1);
        this.setListButtonUnsubscribe(new ArrayList<JButton>());
        this.setColumnNames(new String[]{});
        this.setData(new Object[][]{});
        this.setLogInfo(logInfo);

        this.frameEstacion = new JFrame("EstacionMeteorologicaGUI");
        this.getAddUserButton().setText("Subscribir");
        this.getNotificationBotton().setText("Notificar");
        this.getTemperaturaLabel().setText("Temperatura");
        this.getListUsersLabel().setText("Usuarios");
        this.getNameUserLabel().setText("Nombre");
        this.getNameUserInput().setSize(new Dimension(10,10));
        this.getTextField1().setSize(new Dimension(10,10));

    }

    public static void main(String[] args) {
        EstacionMeteorologicaGUI est = new EstacionMeteorologicaGUI();
        est.setFrame();
    }

    public void setFrame() {
        this.subscribeUser();
        this.setColumnsAndRows();
        this.setDataTableUsers();
        this.unsubscribe();
        this.sendTemp();

        this.getFrameEstacion().setContentPane(this.getEstacionPanel());
        this.getFrameEstacion().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getFrameEstacion().pack();
        this.getFrameEstacion().setLocationRelativeTo(null);
        this.getFrameEstacion().setVisible(true);
    }

    public void setColumnsAndRows() {
        String[] columnNames = {"N°", "Nombre", "Temperatura C°"};
        int rows = weatherStation.getSetOfWeatherObservers().size();
         Object[][] table = new Object[rows][3];
            for (int i = 0; i < rows; i++) {
                for(int j = 0; j< 3; j++){
                    if(j == 0){
                        table[i][j] = i+1;
                    }else if(j== 1){
                        table[i][j] = weatherStation.getSetOfWeatherObservers().get(i).getName();
                    }else if(j== 2) {
                        table[i][j] = weatherStation.getSetOfWeatherObservers().get(i).getCurrentTemp();
                    }
                }
            }
        this.setColumnNames(columnNames);
        this.setData(table);
        getUsersTable().setModel(new DefaultTableModel(getData(), getColumnNames()));
    }

    public void subscribeUser() {
        this.getAddUserButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)) {
                    WeatherCustomer wc = new WeatherCustomer(nameUserInput.getText(),weatherStation);
                    weatherStation.addObserver(wc);
                    //Operacion para subscribir
                    JOptionPane.showMessageDialog(null, "Usuario suscrito");
                    System.out.println(nameUserInput.getText());
                    setColumnsAndRows();
                }
            }
        });
    }

    public void sendTemp(){
        this.getNotificationBotton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)) {
                    weatherStation.setTemp(Integer.parseInt(textField1.getText()));
                    JOptionPane.showMessageDialog(null, "Temperatura enviada");
                    setColumnsAndRows();
                    showInfo();
                }
            }
        });

    }


    public void unsubscribe() {
      this.getBtnUnsuscribe().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)) {
                    //Operacion para unsubscribe por indice
                    if(!unsuscribe.getText().isEmpty()){
                        int index=Integer.parseInt(unsuscribe.getText())-1;
                        if(index >=0 && index <= weatherStation.getSetOfWeatherObservers().size());
                        weatherStation.removeObserverByIndex(index);
                        setColumnsAndRows();
                        showInfo();
                    }
                }
            }
       });

    }


    public void setDataTableUsers() {

        DefaultTableModel dm = new DefaultTableModel();
        dm.setDataVector(this.getData(), this.getColumnNames());
        this.getUsersTable().setModel(dm);
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

    public void showInfo() {
        this.logInfo.setText(weatherStation.showInfos());

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

    public String[] getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public Object[][] getData() {
        return data;
    }

    public void setData(Object[][] data) {
        this.data = data;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JButton getBtnUnsuscribe() {
        return btnUnsuscribe;
    }

    public void setBtnUnsuscribe(JButton btnUnsuscribe) {
        this.btnUnsuscribe = btnUnsuscribe;
    }

    public JTextArea getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(JTextArea logInfo) {
        this.logInfo = logInfo;
    }
}
