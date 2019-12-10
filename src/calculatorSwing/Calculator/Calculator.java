package calculatorSwing.Calculator;

import javax.swing.*;
import java.awt.*;

public class Calculator {

    private JFrame frame;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JTextField panelField;
    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonPoint;
    private JButton buttonEqual;
    private JButton buttonPlus;
    private JButton buttonMinus;
    private JButton buttonMultiply;
    private JButton buttonDivide;


    public static void main(String[] args) {

        Calculator calc = new Calculator();
        calc.createFrame();  // вызываем метод для создания frame
    }

    public void createFrame() {  // создаем frame
        frame = new JFrame("Калькулятор");
        frame.setLayout(new BorderLayout(2, 2));
        createPanel1();  // вызываем метод для создания panel1
        frame.getContentPane().add(panel1, BorderLayout.NORTH);
        createPanel2();  // вызываем метод для создания panel1
        frame.getContentPane().add(panel2, BorderLayout.CENTER);
        createPanel3();  // вызываем метод для создания panel1
        frame.getContentPane().add(panel3, BorderLayout.EAST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        addButtonListener();

    }

    public void createPanel1() {
        panel1 = new JPanel();
        BorderLayout b1 = new BorderLayout();
        panel1.setLayout(b1);
        panelField = new JTextField(30);
        panelField.setEditable(false);

        panel1.add(BorderLayout.NORTH, panelField);
    }

    public void createPanel2() {

        panel2 = new JPanel();
        GridLayout g1 = new GridLayout(4, 3);
        panel2.setLayout(g1);
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonPoint = new JButton(".");
        buttonEqual = new JButton("=");

        panel2.add(button7);
        panel2.add(button2);
        panel2.add(button3);
        panel2.add(button4);
        panel2.add(button5);
        panel2.add(button6);
        panel2.add(button1);
        panel2.add(button8);
        panel2.add(button9);
        panel2.add(button0);
        panel2.add(buttonPoint);
        panel2.add(buttonEqual);
    }

    public void createPanel3() {
        panel3 = new JPanel();
        GridLayout g2 = new GridLayout(4, 1);
        panel3.setLayout(g2);
        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonMultiply = new JButton("*");
        buttonDivide = new JButton("/");
        panel3.add(buttonPlus);
        panel3.add(buttonMinus);
        panel3.add(buttonMultiply);
        panel3.add(buttonDivide);
    }


    public void addButtonListener() {  // добавляем слушательсобытий к кажждой кнопке
        CalculatorEngine calcEngine = new CalculatorEngine(panelField);
        button0.addActionListener(calcEngine);
        button1.addActionListener(calcEngine);
        button2.addActionListener(calcEngine);
        button3.addActionListener(calcEngine);
        button4.addActionListener(calcEngine);
        button5.addActionListener(calcEngine);
        button6.addActionListener(calcEngine);
        button7.addActionListener(calcEngine);
        button8.addActionListener(calcEngine);
        button9.addActionListener(calcEngine);
        buttonPlus.addActionListener(calcEngine);
        buttonPoint.addActionListener(calcEngine);
        buttonEqual.addActionListener(calcEngine);
        buttonDivide.addActionListener(calcEngine);
        buttonMultiply.addActionListener(calcEngine);
        buttonMinus.addActionListener(calcEngine);
    }

}
