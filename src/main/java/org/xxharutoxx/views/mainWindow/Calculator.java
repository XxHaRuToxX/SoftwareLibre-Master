package org.xxharutoxx.views.mainWindow;

import org.xxharutoxx.models.ExpressionCalculate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements KeyListener,MouseListener{
    private static final long serialVersionUID = -1549320861627671027L;

    private JPanel panelCalculator;
    private JButton btnClear;
    private JButton btnDivide;
    private JButton btnMultiply;
    private JButton btnSubtrac;
    private JButton btnAdd;
    private JButton btnEquals;
    private JButton btnAns;
    private JButton btnTan;
    private JButton btnInvTan;
    private JButton btnRightBrace;
    private JButton btnNine;
    private JButton btnSix;
    private JButton btnThree;
    private JButton btnExp;
    private JButton btnCos;
    private JButton btnInvCos;
    private JButton btnLeftBrace;
    private JButton btnEight;
    private JButton btnFive;
    private JButton btnTwo;
    private JButton btnDescPoint;
    private JButton degreeButton;
    private JButton btnSqrt;
    private JButton btnE;
    private JButton btnPI;
    private JButton btnModeOnOff;
    private JTextField textfield;
    private JButton btnSen;
    private JButton btnInvSen;
    private JButton btnExponent;
    private JButton btnSeven;
    private JButton btnFour;
    private JButton btnOne;
    private JButton btnZero;
    private boolean isOn = false;
    private int onPressed = 0;
    private int modeChosen = 0;
    private double answer = 0;
    public static boolean onDegrees = true;

    public Calculator() {
        initComponents();
        textfield.addMouseListener(this);
        textfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (isOn) {
                        calculateExpression(textfield.getText());
                    }
                }
            }
        });
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    textfield.setText(textfield.getText() + " + ");
                }
            }
        });
        btnAdd.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });
        btnModeOnOff.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (isOn) {
                    btnModeOnOff.setBackground(Color.GREEN);
                    btnModeOnOff.setText("Off");
                } else {
                    btnModeOnOff.setBackground(Color.RED);
                    btnModeOnOff.setText("On");
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnModeOnOff.setText("Off");
                if (onPressed > 0) {
                    btnModeOnOff.setForeground(Color.BLACK);
                    if (isOn) {
                        btnModeOnOff.setBackground(Color.RED);
                        btnModeOnOff.setText("On");
                    } else {
                        btnModeOnOff.setBackground(Color.GREEN);
                        btnModeOnOff.setText("Off");
                    }
                } else {
                    btnModeOnOff.setBorder(BorderFactory
                            .createLineBorder(new Color(50, 205, 50)));
                    btnModeOnOff.setBackground(UIManager
                            .getColor("Button.darkShadow"));
                }
            }
        });
        btnModeOnOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPressed++;
                if (isOn == false) {
                    isOn = true;
                    textfield.setEditable(true);
                    textfield.setText("0");
                    btnModeOnOff.setToolTipText("Off");
                    btnModeOnOff.setText("Off");
                    btnModeOnOff.setBackground(Color.GREEN);
                    btnModeOnOff.setForeground(Color.BLACK);
                    btnModeOnOff.setBorder(BorderFactory
                            .createLineBorder(Color.BLACK));
                    textfield.setBackground(Color.BLACK);
                } else {
                    isOn = false;
                    textfield.setEditable(false);
                    textfield.setBackground(Color.BLACK);
                    textfield.setText("Off");
                    btnModeOnOff.setToolTipText("On");
                    btnModeOnOff.setForeground(Color.BLACK);
                    btnModeOnOff.setBackground(Color.RED);
                    btnModeOnOff.setBorder(BorderFactory
                            .createLineBorder(Color.BLACK));
                    btnModeOnOff.setText("On");
                }
            }
        });
        btnSubtrac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    textfield.setText(textfield.getText() + " - ");
                }
            }
        });
        btnMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    textfield.setText(textfield.getText() + " * ");
                }
            }
        });
        btnDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    textfield.setText(textfield.getText() + " / ");
                }
            }
        });
        btnEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    textfield.setText(textfield.getText());
                }
                System.out.println(textfield.getText());
            }
        });
        btnEquals.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                equalsButton.setBackground(UIManager
//                        .getColor("Button.darkShadow"));

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });
        btnAns.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "Ans");
                }
            }
        });
        btnClear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnClear.setForeground(Color.BLACK);
                btnClear.setBackground(Color.YELLOW);
                btnClear.setBorder(BorderFactory
                        .createLineBorder(Color.BLACK));
                btnClear.setBounds(btnClear.getX() + 5,
                        btnClear.getY(), btnClear.getWidth() - 10,
                        btnClear.getHeight());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnClear.setBounds(btnClear.getX() - 5,
                        btnClear.getY(), btnClear.getWidth() + 10,
                        btnClear.getHeight());
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    textfield.setText("");
                }
            }
        });
        btnFour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "4");
                }
            }
        });
        btnFour.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                fourBtn.setBackground(UIManager.getColor("Button.darkShadow"));

            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                fourBtn.setOpaque(true);
//                fourBtn.setBackground(null);
//                fourBtn.setBounds(fourBtn.getX() + 5, fourBtn.getY(),
//                        fourBtn.getWidth() - 10, fourBtn.getHeight());

            }

            @Override
            public void mouseExited(MouseEvent e) {
//                fourBtn.setOpaque(true);
//                fourBtn.setBackground(UIManager.getColor("Button.darkShadow"));
//                fourBtn.setBounds(fourBtn.getX() - 5, fourBtn.getY(),
//                        fourBtn.getWidth() + 10, fourBtn.getHeight());
            }

        });
        btnFive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "5");
                }
            }
        });
        btnFive.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                fiveBtn.setBackground(UIManager.getColor("Button.darkShadow"));

            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                fiveBtn.setOpaque(true);
//                fiveBtn.setBackground(null);
//                fiveBtn.setBounds(fiveBtn.getX() + 5, fiveBtn.getY(),
//                        fiveBtn.getWidth() - 10, fiveBtn.getHeight());

            }

            @Override
            public void mouseExited(MouseEvent e) {
//                fiveBtn.setOpaque(true);
//                fiveBtn.setBackground(UIManager.getColor("Button.darkShadow"));
//                fiveBtn.setBounds(fiveBtn.getX() - 5, fiveBtn.getY(),
//                        fiveBtn.getWidth() + 10, fiveBtn.getHeight());
            }

        });
        btnSix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "6");
                }
            }
        });
        btnOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "1");
                }
            }
        });
        btnTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "2");
                }
            }
        });
        btnThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "3");
                }
            }
        });
        btnZero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "0");
                }
            }
        });
        btnDescPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + ".");
                }
            }
        });

        btnExp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    textfield.setText(textfield.getText() + "E");
                }
            }
        });
        btnSeven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "7");
                }
            }
        });
        btnEight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "8");
                }
            }
        });
        btnNine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "9");
                }
            }
        });
        btnExponent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "^");
                }
            }
        });
        btnLeftBrace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "(");
                }
            }
        });
        btnRightBrace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + ")");
                }
            }
        });
        btnSen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "sen");
                }
            }
        });
        btnCos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "cos");
                }
            }
        });
        btnTan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "tan");
                }
            }
        });
        btnPI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "π");
                }
            }
        });
        btnE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "e");
                }
            }
        });
        btnSqrt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(String.valueOf(Math.sqrt(Double.parseDouble(textfield.getText()))));
                }
            }
        });
        degreeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (onDegrees) {
                    degreeButton.setForeground(Color.WHITE);
                    degreeButton.setBackground(Color.BLUE);
                    degreeButton.setText("Radians");
                } else {
                    degreeButton.setForeground(Color.BLACK);
                    degreeButton.setBackground(Color.MAGENTA);
                    degreeButton.setText("Degrees");

                }
                degreeButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                degreeButton.setBounds(degreeButton.getX() + 5, degreeButton.getY(),
                        degreeButton.getWidth() - 10, degreeButton.getHeight());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                degreeButton.setForeground(new Color(50, 205, 50));
                degreeButton.setText("Degrees");
                if (modeChosen > 0) {
                    if (onDegrees) {
                        degreeButton.setBackground(Color.MAGENTA);
                        degreeButton.setText("Degrees");
                        degreeButton.setForeground(Color.BLACK);
                    } else {
                        degreeButton.setForeground(Color.WHITE);
                        degreeButton.setBackground(Color.BLUE);
                        degreeButton.setText("Radians");
                    }
                } else {
                    degreeButton.setBorder(BorderFactory.createLineBorder(new Color(
                            50, 205, 50)));
                    degreeButton.setBackground(UIManager
                            .getColor("Button.darkShadow"));
                }
                degreeButton.setBounds(degreeButton.getX() - 5, degreeButton.getY(),
                        degreeButton.getWidth() + 10, degreeButton.getHeight());
            }
        });
        degreeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeChosen++;
                if (onDegrees == false) {
                    onDegrees = true;
                    degreeButton.setToolTipText("Degrees");
                    degreeButton.setText("Degrees");
                    degreeButton.setBackground(Color.MAGENTA);
                    degreeButton.setForeground(Color.BLACK);
                    degreeButton.setBorder(BorderFactory
                            .createLineBorder(Color.BLACK));
                } else {
                    onDegrees = false;
                    degreeButton.setToolTipText("Radians");
                    degreeButton.setText("Radians");
                    degreeButton.setBackground(Color.BLUE);
                    degreeButton.setForeground(Color.WHITE);
                    degreeButton.setBorder(BorderFactory
                            .createLineBorder(Color.BLACK));
                }
            }
        });
        btnInvSen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "arcsen(");
                }
            }
        });
        btnInvCos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "arccos(");
                }
            }
        });
        btnInvTan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "arctan(");
                }
            }
        });
    }
    public void initComponents(){
        setContentPane(panelCalculator);
        setSize(600,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void calculateExpression(String expression) {
        String newExpression1 = "";
        String[] values = textfield.getText().split("\\s");
        for (int i = 0; i < values.length; i++) {
            if (values[i].trim().equals("Ans")) {
                newExpression1 += answer;
            } else {
                newExpression1 += values[i];
            }
        }

        String newExpression2 = "";
        for (int j = 0; j < newExpression1.length(); j++) {
            if (newExpression1.charAt(j) == 'π') {
                newExpression2 += Math.PI;
            } else if (newExpression1.charAt(j) == 'e') {
                newExpression2 += Math.E;
            } else {
                newExpression2 += newExpression1.charAt(j);
            }
        }

        try {
            ExpressionCalculate e = new ExpressionCalculate(newExpression2);
            double ans = e.evaluate();
            answer = ans;
            textfield.setText(Double.toString(ans));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Por favor ingrese un número válido! Ingresaste: " + "\""
                            + textfield.getText() + "\"");
            textfield.setText("");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (textfield.getText().equals("0")) {
            textfield.setText("");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    boolean isDouble(Object str) {
        try {
            Double.toString((Double) str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    boolean isInteger(Object str) {
        try {
            Integer.toString((Integer) str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
