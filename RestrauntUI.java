package exercise;
import javax.swing.*;
import java.awt.*;
public class RestrauntUI extends JFrame {
    JMenuBar jMenuBar=new JMenuBar();
    JMenu jMode=new JMenu("Режим");
    JMenuItem clientMode=new JMenuItem("Режим клиента");
    JMenuItem waiterMode=new JMenuItem("Режим официанта");
    RestrauntUI() {
        setSize(1280, 720);
        setLocation((1920 - 1280) / 2, (1080 - 720) / 2);
        setLayout(new GridBagLayout());
        jMode.add(clientMode);
        jMode.add(waiterMode);
        jMenuBar.add(jMode);
        GridBagConstraints jMenuBarConstraints= new GridBagConstraints();
        jMenuBarConstraints.fill=GridBagConstraints.HORIZONTAL;
        jMenuBarConstraints.weightx=1.0f;
        jMenuBarConstraints.weighty=0.05;
        jMenuBarConstraints.anchor=GridBagConstraints.NORTHWEST;
        jMenuBarConstraints.gridx=0;
        jMenuBarConstraints.gridy=0;
        add(jMenuBar,jMenuBarConstraints);
        setVisible(true);
        clientMode.addActionListener(e -> {
            setVisible(false);
            new ClientUI(new TableOrdersManager(),new InternetOrderManager());
        });
        waiterMode.addActionListener(e -> {
            setVisible(false);
            new WaterUI(new TableOrdersManager(),new InternetOrderManager());
        });
    }

    public static void main(String[] args){
        new RestrauntUI();
    }
}
