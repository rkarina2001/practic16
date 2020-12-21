package exercise;
import javax.swing.*;
public class BusyTableException extends Exception{
    public BusyTableException(){
        JOptionPane.showMessageDialog(null,"Все столы заняты. Подождите или закажите доставку, пожалуйста.","All tables are busy",JOptionPane.ERROR_MESSAGE);
    }
}
