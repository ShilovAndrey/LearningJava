package calculatorSwing.Calculator;

import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorEngine implements ActionListener {

    JTextField field;
    char selectedAction = ' ';
    double currentResult = 0;


    CalculatorEngine(JTextField field) {
        this.field = field;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(e.getSource() instanceof JButton)) {
            return;
        }
        JButton clickedButton = (JButton) e.getSource();
        String dispFieldText = field.getText();
        double displayValue = 0;
        if (!(dispFieldText.equals(""))) {
            displayValue = Double.parseDouble(dispFieldText);
        }
        if (e.getActionCommand().equals("+")) {
            selectedAction='+';
            currentResult = displayValue;
            field.setText("");
        } else if (e.getActionCommand().equals("-")) {
            selectedAction='-';
            currentResult = displayValue;
            field.setText("");
        } else if (e.getActionCommand().equals("*")) {
            selectedAction='*';
            currentResult = displayValue;
            field.setText("");
        } else if (e.getActionCommand().equals("/")) {
            selectedAction='/';
            currentResult = displayValue;
            field.setText("");
        }else if(e.getActionCommand().equals("=")){
            if(selectedAction=='+'){
                currentResult+=displayValue;
                field.setText(""+currentResult);
            }else if(selectedAction=='-'){
                currentResult-=displayValue;
                field.setText(""+currentResult);
            }else if(selectedAction=='*'){
                currentResult*=displayValue;
                field.setText(""+currentResult);
            }else if(selectedAction=='/'){
                currentResult/=displayValue;
                field.setText(""+currentResult);
            }
        } else {
            String clickButtonLabel = clickedButton.getText();
            field.setText(dispFieldText+clickButtonLabel);
        }

    }

}
