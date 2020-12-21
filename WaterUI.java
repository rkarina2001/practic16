package exercise;
import javax.swing.*;
import java.awt.*;
public class WaterUI extends JFrame {
    InternetOrderManager internetOrdersManager;
    TableOrdersManager tableOrdersManager;
    JMenuBar jMenuBar=new JMenuBar();
    JMenu jMode=new JMenu("Режим");
    JMenuItem waiterMode=new JMenuItem("Режим клиента");
    JPanel menuItemsPanel=new JPanel();
    JPanel buttonsPanel=new JPanel();
    JLabel costs=new JLabel("");
    JLabel countLabel=new JLabel("");
    WaterUI(){
        super("Waiter");
        setSize(1280, 720);
        setLocation((1920 - 1280) / 2, (1080 - 720) / 2);
    }

    WaterUI(TableOrdersManager tableOrdersManager,InternetOrderManager internetOrdersManager){
        this();
        this.tableOrdersManager=tableOrdersManager;
        this.internetOrdersManager=internetOrdersManager;
        allOrders();
    }

    private void allOrders(){
        menuItemsPanel=new JPanel();
        menuItemsPanel.setLayout(new GridBagLayout());
        buttonsPanel=new JPanel();
        this.getContentPane().removeAll();
        setLayout(new GridBagLayout());
        jMode.add(waiterMode);
        jMenuBar.add(jMode);

        GridBagConstraints jMenuBarConstraints= new GridBagConstraints();
        jMenuBarConstraints.gridwidth=2;
        jMenuBarConstraints.fill=GridBagConstraints.HORIZONTAL;
        jMenuBarConstraints.weightx=1.0f;
        jMenuBarConstraints.weighty=0.05;
        jMenuBarConstraints.anchor=GridBagConstraints.NORTHWEST;
        jMenuBarConstraints.gridx=0;
        jMenuBarConstraints.gridy=0;

        add(jMenuBar,jMenuBarConstraints);

        buttonsPanel.setLayout(new GridLayout(2,1));
        buttonsPanel.add(costs);
        buttonsPanel.add(countLabel);
        costs.setText("Стоимость заказов, ожидающих выдачи: "+String.valueOf(this.tableOrdersManager.ordersCostSummary()+this.internetOrdersManager.ordersCostSummary()));
        countLabel.setText("Количество заказов, ожидаюших выдачи: "+String.valueOf(this.tableOrdersManager.getOrders().length+this.internetOrdersManager.getOrders().length));
        waiterMode.addActionListener(e -> {
            setVisible(false);
            new ClientUI(this.tableOrdersManager,this.internetOrdersManager);
        });

        GridBagConstraints textFieldsConstraint= new GridBagConstraints();
        textFieldsConstraint.fill=GridBagConstraints.BOTH;
        textFieldsConstraint.weightx=0.5f;
        textFieldsConstraint.weighty=1f;
        textFieldsConstraint.anchor=GridBagConstraints.SOUTHWEST;
        textFieldsConstraint.gridx=0;
        textFieldsConstraint.gridy=1;
        JScrollPane menuPane=new JScrollPane(menuItemsPanel);
        add(menuPane,textFieldsConstraint);
        textFieldsConstraint.gridx=1;
        add(buttonsPanel,textFieldsConstraint);

        int i=0;
        for(Order order: this.internetOrdersManager.getOrders()){
            setVisible(false);
            new OrderUI(order,menuItemsPanel,i,internetOrdersManager,this);
            i++;
        }
        for(Order order: this.tableOrdersManager.getOrders()){
            setVisible(false);
            new OrderUI(order,menuItemsPanel,i,tableOrdersManager,this);
            i++;
        }

        this.setVisible(true);
    }
}
