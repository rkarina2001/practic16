package exercise;
import javax.swing.*;
public class EmptyOrderExxpection extends Throwable {
    EmptyOrderExxpection (){
        JOptionPane.showMessageDialog(null,"Ваш заказ пуст. Добавьте предметы","Your Order is Empty",JOptionPane.ERROR_MESSAGE);
    }
}
