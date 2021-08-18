package org.xxharutoxx.views.mainWindow;
import org.jdesktop.swingx.HorizontalLayout;
import org.jdesktop.swingx.painter.AbstractLayoutPainter;
import org.xxharutoxx.models.Expression;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class CalculatorFrame extends JFrame implements KeyListener, MouseListener {

    /**
     *
     */
    private static final long serialVersionUID = -1549320861627671027L;

//    private JFrame frame;
    private JPanel panelCalculate=new JPanel();
    private final String title="Calculadora";
    public static JTextField textfield;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton equalsButton;
    private JButton ansButton;
    private JButton onButton;
    private JButton clearButton;
    private JButton fourBtn;
    private JButton fiveBtn;
    private JButton sixBtn;
    private JButton oneBtn;
    private JButton twoBtn;
    private JButton threeBtn;
    private JButton zeroBtn;
    private JButton decPointBtn;
    private JButton expBtn;
    private JButton sevenBtn;
    private JButton eightBtn;
    private JButton nineBtn;
    private boolean isOn = false;
    private int onPressed = 0;
    private int modeChosen = 0;
    private double answer = 0;
    private JButton piBtn;
    private JButton eBtn;
    public static boolean onDegrees = true;

    /**
     * Launch the application.
     */
//	public static void main(String[] args) {
//		System.out.println(Math.toDegrees(Math.asin(0.5)));
//		Interpreter parse = new Interpreter();
//		try {
//			System.out.println(parse.eval("Math.sqrt(4)"));
//		} catch (EvalError e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		Expression expression = new Expression("3 + 4");
//		System.out.println(expression.evaluate());
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CalculatorFrame window = new CalculatorFrame();
//					window.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

    /**
     * Create the application.
     */
    public CalculatorFrame() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
//        frame = new JFrame();
        setContentPane(panelCalculate);
//        setSize(600,600);
//        getContentPane().setBackground(new Color(255, 255, 240));
//        setBounds(100, 100, 516, 507);
        setBounds(100, 100, 700, 500);
//        setResizable(false);
        setLocationRelativeTo(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
//        setTitle("Scientific Calculator");
//        setVisible(true);
//        panelCalculate.setLayout(new BoxLayout(panelCalculate,BoxLayout.Y_AXIS));
//        panelCalculate.setAlignmentY(Component.RIGHT_ALIGNMENT);

        UIManager.put("ToolTip.foreground", Color.blue);
        UIManager.put("ToolTip.background", Color.WHITE);

        textfield = new JTextField();
        textfield.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (isOn) {

                        calculateExpression(textfield.getText());

                    }
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub

            }

        });
        textfield.addMouseListener(this);
        textfield.setText("Off");
        textfield.setEditable(false);
        textfield.setFont(new Font("Letter Gothic Std", Font.BOLD, 32));
        textfield.setForeground(new Color(50, 205, 50));
        textfield.setCaretColor(new Color(50, 205, 50));
        textfield.setSelectionColor(new Color(152, 251, 152));
        textfield.setBackground(UIManager.getColor("Button.darkShadow"));
        textfield.setBounds(176, 6, 483, 102);
        panelCalculate.add(textfield);
        textfield.setColumns(10);

        final JButton addButton = new JButton("+");
        addButton.addMouseListener(new MouseListener() {

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
        addButton.setOpaque(true);
        addButton.setBorder(BorderFactory.createLineBorder(new Color(50, 205,
                50)));
        addButton.setForeground(new Color(50, 205, 50));
        addButton.setFont(new Font("Lucida Console", Font.BOLD, 32));
        addButton.setBackground(UIManager.getColor("Button.darkShadow"));
        addButton.setToolTipText("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    textfield.setText(textfield.getText() + " + ");
                }
            }
        });
        addButton.setBounds(576, 326, 75, 38);
        panelCalculate.add(addButton);

        subtractButton = new JButton("-");
        subtractButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

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
        subtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    textfield.setText(textfield.getText() + " - ");
                }
            }
        });
        subtractButton.setToolTipText("Subtract");
        subtractButton.setOpaque(true);
        subtractButton.setFont(new Font("Lucida Console", Font.BOLD, 32));
        subtractButton.setBorder(BorderFactory.createLineBorder(new Color(50,
                205, 50)));
        subtractButton.setBounds(576, 276, 75, 38);
        panelCalculate.add(subtractButton);

        multiplyButton = new JButton("x");
        multiplyButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

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
        multiplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    textfield.setText(textfield.getText() + " * ");
                }
            }
        });
        multiplyButton.setToolTipText("Multiply");
        multiplyButton.setOpaque(true);
        multiplyButton.setFont(new Font("Lucida Console", Font.BOLD, 32));
        multiplyButton.setBorder(BorderFactory.createLineBorder(new Color(50,
                205, 50)));
        multiplyButton.setBounds(576, 226, 75, 38);
        panelCalculate.add(multiplyButton);

        divideButton = new JButton("/");
        divideButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

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
        divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    textfield.setText(textfield.getText() + " / ");
                }

            }
        });
        divideButton.setToolTipText("Divide");
        divideButton.setOpaque(true);
        divideButton.setFont(new Font("Lucida Console", Font.BOLD, 32));
        divideButton.setBorder(BorderFactory.createLineBorder(new Color(50,
                205, 50)));
        divideButton.setBounds(576, 176, 75, 38);
        panelCalculate.add(divideButton);

        equalsButton = new JButton("=");
        equalsButton.addMouseListener(new MouseListener() {

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
        equalsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    calculateExpression(textfield.getText());

                }
                System.out.println(textfield.getText());
            }
        });
        equalsButton.setToolTipText("Equals");
        equalsButton.setOpaque(true);
//        equalsButton.setForeground(new Color(50, 205, 50));
        equalsButton.setFont(new Font("Lucida Console", Font.BOLD, 32));
        equalsButton.setBorder(BorderFactory.createLineBorder(new Color(50,
                205, 50)));
        equalsButton.setBounds(576, 376, 75, 38);
        panelCalculate.add(equalsButton);

        ansButton = new JButton("Ans");
        ansButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                ansButton.setBackground(UIManager.getColor("Button.darkShadow"));

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                ansButton.setOpaque(true);
                ansButton.setBackground(null);
                ansButton.setBounds(ansButton.getX() + 5, ansButton.getY(),
                        ansButton.getWidth() - 10, ansButton.getHeight());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                ansButton.setOpaque(true);
//                ansButton.setBackground(UIManager.getColor("Button.darkShadow"));
                ansButton.setBounds(ansButton.getX() - 5, ansButton.getY(),
                        ansButton.getWidth() + 10, ansButton.getHeight());
            }

        });
        ansButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "Ans");
                }
            }
        });
        ansButton.setToolTipText("Previous Answer");
        ansButton.setOpaque(true);
        ansButton.setFont(new Font("Lucida Console", Font.BOLD, 28));
        ansButton.setBorder(BorderFactory.createLineBorder(new Color(50, 205,
                50)));
        ansButton.setBounds(576, 426, 75, 38);
        panelCalculate.add(ansButton);

        onButton = new JButton("Off");
        onButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                onButton.setForeground(Color.BLACK);
                if (isOn) {
                    onButton.setBackground(Color.GREEN);
                    onButton.setText("Off");
                } else {
                    onButton.setBackground(Color.RED);
                    onButton.setText("On");
                }
                onButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                onButton.setBounds(onButton.getX() + 5, onButton.getY(),
                        onButton.getWidth() - 10, onButton.getHeight());

            }

            @Override
            public void mouseExited(MouseEvent e) {
//                onButton.setForeground(new Color(50, 205, 50));
                onButton.setText("Off");
                if (onPressed > 0) {
                    onButton.setForeground(Color.BLACK);
                    if (isOn) {
                        onButton.setBackground(Color.RED);
                        onButton.setText("On");
                    } else {
                        onButton.setBackground(Color.GREEN);
                        onButton.setText("Off");
                    }
                } else {
                    onButton.setBorder(BorderFactory
                            .createLineBorder(new Color(50, 205, 50)));
                    onButton.setBackground(UIManager
                            .getColor("Button.darkShadow"));
                }
                onButton.setBounds(onButton.getX() - 5, onButton.getY(),
                        onButton.getWidth() + 10, onButton.getHeight());
            }

        });
        onButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onPressed++;
                if (isOn == false) {
                    isOn = true;
                    textfield.setEditable(true);
                    textfield.setText("0");
                    onButton.setToolTipText("Off");
                    onButton.setText("Off");
                    onButton.setBackground(Color.GREEN);
                    onButton.setForeground(Color.BLACK);
                    onButton.setBorder(BorderFactory
                            .createLineBorder(Color.BLACK));
                    textfield.setBackground(Color.BLACK);
                } else {
                    isOn = false;
                    textfield.setEditable(false);
                    textfield.setBackground(Color.BLACK);
                    textfield.setText("Off");
                    onButton.setToolTipText("On");
                    onButton.setForeground(Color.BLACK);
                    onButton.setBackground(Color.RED);
                    onButton.setBorder(BorderFactory
                            .createLineBorder(Color.BLACK));
                    onButton.setText("On");
                }
            }
        });
        onButton.setToolTipText("On");
        onButton.setOpaque(true);
        onButton.setFont(new Font("Lucida Console", Font.BOLD, 22));
        onButton.setBorder(BorderFactory
                .createLineBorder(new Color(50, 205, 50)));
        onButton.setBounds(188, 428, 75, 38);
        panelCalculate.add(onButton);

        clearButton = new JButton("AC");
        clearButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                clearButton.setBackground(UIManager
//                        .getColor("Button.darkShadow"));

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                clearButton.setForeground(Color.BLACK);
                clearButton.setBackground(Color.YELLOW);
                clearButton.setBorder(BorderFactory
                        .createLineBorder(Color.BLACK));
                clearButton.setBounds(clearButton.getX() + 5,
                        clearButton.getY(), clearButton.getWidth() - 10,
                        clearButton.getHeight());

            }

            @Override
            public void mouseExited(MouseEvent e) {
//                clearButton.setForeground(new Color(50, 205, 50));
//                clearButton.setBorder(BorderFactory.createLineBorder(new Color(
//                        50, 205, 50)));
//                clearButton.setBackground(UIManager
//                        .getColor("Button.darkShadow"));
                clearButton.setBounds(clearButton.getX() - 5,
                        clearButton.getY(), clearButton.getWidth() + 10,
                        clearButton.getHeight());
            }

        });
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                clearButton.setForeground(new Color(50, 205, 50));
                if (isOn) {
                    textfield.setText("");
                }
            }
        });
        clearButton.setToolTipText("Clear");
        clearButton.setOpaque(true);
        clearButton.setFont(new Font("Lucida Console", Font.BOLD, 25));
        clearButton.setBorder(BorderFactory.createLineBorder(new Color(50, 205,
                50)));
        clearButton.setBounds(576, 126, 75, 38);
        panelCalculate.add(clearButton);

        fourBtn = new JButton("4");
        fourBtn.addMouseListener(new MouseListener() {

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
                fourBtn.setOpaque(true);
                fourBtn.setBackground(null);
                fourBtn.setBounds(fourBtn.getX() + 5, fourBtn.getY(),
                        fourBtn.getWidth() - 10, fourBtn.getHeight());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                fourBtn.setOpaque(true);
//                fourBtn.setBackground(UIManager.getColor("Button.darkShadow"));
                fourBtn.setBounds(fourBtn.getX() - 5, fourBtn.getY(),
                        fourBtn.getWidth() + 10, fourBtn.getHeight());
            }

        });
        fourBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "4");
                }
            }
        });
        fourBtn.setToolTipText("4");
        fourBtn.setOpaque(true);
//        fourBtn.setForeground(new Color(50, 205, 50));
        fourBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
        fourBtn.setBorder(BorderFactory
                .createLineBorder(new Color(50, 205, 50)));
        fourBtn.setBounds(297, 328, 75, 38);
        panelCalculate.add(fourBtn);

        fiveBtn = new JButton("5");
        fiveBtn.addMouseListener(new MouseListener() {

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
                fiveBtn.setOpaque(true);
                fiveBtn.setBackground(null);
                fiveBtn.setBounds(fiveBtn.getX() + 5, fiveBtn.getY(),
                        fiveBtn.getWidth() - 10, fiveBtn.getHeight());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                fiveBtn.setOpaque(true);
//                fiveBtn.setBackground(UIManager.getColor("Button.darkShadow"));
                fiveBtn.setBounds(fiveBtn.getX() - 5, fiveBtn.getY(),
                        fiveBtn.getWidth() + 10, fiveBtn.getHeight());
            }

        });
        fiveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "5");
                }
            }
        });
        fiveBtn.setToolTipText("5");
        fiveBtn.setOpaque(true);
        fiveBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
        fiveBtn.setBorder(BorderFactory
                .createLineBorder(new Color(50, 205, 50)));
        fiveBtn.setBounds(391, 328, 75, 38);
        panelCalculate.add(fiveBtn);

        sixBtn = new JButton("6");
        sixBtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                sixBtn.setBackground(UIManager.getColor("Button.darkShadow"));

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                sixBtn.setOpaque(true);
                sixBtn.setBackground(null);
                sixBtn.setBounds(sixBtn.getX() + 5, sixBtn.getY(),
                        sixBtn.getWidth() - 10, sixBtn.getHeight());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                sixBtn.setOpaque(true);
//                sixBtn.setBackground(UIManager.getColor("Button.darkShadow"));
                sixBtn.setBounds(sixBtn.getX() - 5, sixBtn.getY(),
                        sixBtn.getWidth() + 10, sixBtn.getHeight());
            }

        });
        sixBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "6");
                }
            }
        });
        sixBtn.setToolTipText("6");
        sixBtn.setOpaque(true);
        sixBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
        sixBtn.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
        sixBtn.setBounds(478, 328, 75, 38);
        panelCalculate.add(sixBtn);

        oneBtn = new JButton("1");
        oneBtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                oneBtn.setBackground(UIManager.getColor("Button.darkShadow"));

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                oneBtn.setOpaque(true);
                oneBtn.setBackground(null);
                oneBtn.setBounds(oneBtn.getX() + 5, oneBtn.getY(),
                        oneBtn.getWidth() - 10, oneBtn.getHeight());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                oneBtn.setOpaque(true);
//                oneBtn.setBackground(UIManager.getColor("Button.darkShadow"));
                oneBtn.setBounds(oneBtn.getX() - 5, oneBtn.getY(),
                        oneBtn.getWidth() + 10, oneBtn.getHeight());
            }

        });
        oneBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "1");
                }
            }
        });
        oneBtn.setToolTipText("1");
        oneBtn.setOpaque(true);
        oneBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
        oneBtn.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
        oneBtn.setBounds(297, 378, 75, 38);
        panelCalculate.add(oneBtn);

        twoBtn = new JButton("2");
        twoBtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                twoBtn.setBackground(UIManager.getColor("Button.darkShadow"));

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                twoBtn.setOpaque(true);
                twoBtn.setBackground(null);
                twoBtn.setBounds(twoBtn.getX() + 5, twoBtn.getY(),
                        twoBtn.getWidth() - 10, twoBtn.getHeight());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                twoBtn.setOpaque(true);
//                twoBtn.setBackground(UIManager.getColor("Button.darkShadow"));
                twoBtn.setBounds(twoBtn.getX() - 5, twoBtn.getY(),
                        twoBtn.getWidth() + 10, twoBtn.getHeight());
            }

        });
        twoBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "2");
                }
            }
        });
        twoBtn.setToolTipText("2");
        twoBtn.setOpaque(true);
        twoBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
        twoBtn.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
        twoBtn.setBounds(390, 378, 75, 38);
        panelCalculate.add(twoBtn);

        threeBtn = new JButton("3");
        threeBtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                threeBtn.setBackground(UIManager.getColor("Button.darkShadow"));

            }

            public void mouseEntered(MouseEvent e) {
                threeBtn.setOpaque(true);
                threeBtn.setBackground(null);
                threeBtn.setBounds(threeBtn.getX() + 5, threeBtn.getY(),
                        threeBtn.getWidth() - 10, threeBtn.getHeight());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                threeBtn.setOpaque(true);
//                threeBtn.setBackground(UIManager.getColor("Button.darkShadow"));
                threeBtn.setBounds(threeBtn.getX() - 5, threeBtn.getY(),
                        threeBtn.getWidth() + 10, threeBtn.getHeight());
            }

        });
        threeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "3");
                }
            }
        });
        threeBtn.setToolTipText("3");
        threeBtn.setOpaque(true);
        threeBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
        threeBtn.setBorder(BorderFactory
                .createLineBorder(new Color(50, 205, 50)));
        threeBtn.setBounds(478, 378, 75, 38);
        panelCalculate.add(threeBtn);

        zeroBtn = new JButton("0");
        zeroBtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                zeroBtn.setBackground(UIManager.getColor("Button.darkShadow"));

            }

            public void mouseEntered(MouseEvent e) {
                zeroBtn.setOpaque(true);
                zeroBtn.setBackground(null);
                zeroBtn.setBounds(zeroBtn.getX() + 5, zeroBtn.getY(),
                        zeroBtn.getWidth() - 10, zeroBtn.getHeight());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                zeroBtn.setOpaque(true);
//                zeroBtn.setBackground(UIManager.getColor("Button.darkShadow"));
                zeroBtn.setBounds(zeroBtn.getX() - 5, zeroBtn.getY(),
                        zeroBtn.getWidth() + 10, zeroBtn.getHeight());
            }

        });
        zeroBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "0");
                }
            }
        });
        zeroBtn.setToolTipText("0");
        zeroBtn.setOpaque(true);
        zeroBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
        zeroBtn.setBorder(BorderFactory
                .createLineBorder(new Color(50, 205, 50)));
        zeroBtn.setBounds(297, 428, 75, 38);
        panelCalculate.add(zeroBtn);

        decPointBtn = new JButton(".");
        decPointBtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                decPointBtn.setBackground(UIManager
//                        .getColor("Button.darkShadow"));

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                decPointBtn.setOpaque(true);
                decPointBtn.setBackground(null);
                decPointBtn.setBounds(decPointBtn.getX() + 5,
                        decPointBtn.getY(), decPointBtn.getWidth() - 10,
                        decPointBtn.getHeight());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                decPointBtn.setOpaque(true);
//                decPointBtn.setBackground(UIManager
//                        .getColor("Button.darkShadow"));
                decPointBtn.setBounds(decPointBtn.getX() - 5,
                        decPointBtn.getY(), decPointBtn.getWidth() + 10,
                        decPointBtn.getHeight());
            }

        });
        decPointBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + ".");
                }
            }
        });
        decPointBtn.setToolTipText(".");
        decPointBtn.setOpaque(true);
        decPointBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
        decPointBtn.setBorder(BorderFactory.createLineBorder(new Color(50, 205,
                50)));
        decPointBtn.setBounds(390, 428, 75, 38);
        panelCalculate.add(decPointBtn);

        expBtn = new JButton("EXP");
        expBtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                expBtn.setBackground(UIManager.getColor("Button.darkShadow"));

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                expBtn.setOpaque(true);
                expBtn.setBackground(null);
                expBtn.setBounds(expBtn.getX() + 5, expBtn.getY(),
                        expBtn.getWidth() - 10, expBtn.getHeight());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                expBtn.setOpaque(true);
//                expBtn.setBackground(UIManager.getColor("Button.darkShadow"));
                expBtn.setBounds(expBtn.getX() - 5, expBtn.getY(),
                        expBtn.getWidth() + 10, expBtn.getHeight());
            }

        });
        expBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    textfield.setText(textfield.getText() + "E");
                }
            }
        });
        expBtn.setToolTipText("EXP");
        expBtn.setOpaque(true);
        expBtn.setFont(new Font("Lucida Console", Font.BOLD, 25));
        expBtn.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
        expBtn.setBounds(478, 428, 75, 38);
        panelCalculate.add(expBtn);

        sevenBtn = new JButton("7");
        sevenBtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                sevenBtn.setBackground(UIManager.getColor("Button.darkShadow"));

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                sevenBtn.setOpaque(true);
                sevenBtn.setBackground(null);
                sevenBtn.setBounds(sevenBtn.getX() + 5, sevenBtn.getY(),
                        sevenBtn.getWidth() - 10, sevenBtn.getHeight());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                sevenBtn.setOpaque(true);
//                sevenBtn.setBackground(UIManager.getColor("Button.darkShadow"));
                sevenBtn.setBounds(sevenBtn.getX() - 5, sevenBtn.getY(),
                        sevenBtn.getWidth() + 10, sevenBtn.getHeight());
            }

        });
        sevenBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "7");
                }
            }
        });
        sevenBtn.setToolTipText("7");
        sevenBtn.setOpaque(true);
        sevenBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
        sevenBtn.setBorder(BorderFactory
                .createLineBorder(new Color(50, 205, 50)));
        sevenBtn.setBounds(297, 278, 75, 38);
        panelCalculate.add(sevenBtn);

        eightBtn = new JButton("8");
        eightBtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                eightBtn.setBackground(UIManager.getColor("Button.darkShadow"));

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                eightBtn.setOpaque(true);
                eightBtn.setBackground(null);
                eightBtn.setBounds(eightBtn.getX() + 5, eightBtn.getY(),
                        eightBtn.getWidth() - 10, eightBtn.getHeight());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                eightBtn.setOpaque(true);
//                eightBtn.setBackground(UIManager.getColor("Button.darkShadow"));
                eightBtn.setBounds(eightBtn.getX() - 5, eightBtn.getY(),
                        eightBtn.getWidth() + 10, eightBtn.getHeight());
            }

        });
        eightBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "8");
                }
            }
        });
        eightBtn.setToolTipText("8");
        eightBtn.setOpaque(true);
        eightBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
        eightBtn.setBorder(BorderFactory
                .createLineBorder(new Color(50, 205, 50)));
        eightBtn.setBounds(391, 278, 75, 38);
        panelCalculate.add(eightBtn);

        nineBtn = new JButton("9");
        nineBtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                nineBtn.setBackground(UIManager.getColor("Button.darkShadow"));

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                nineBtn.setOpaque(true);
                nineBtn.setBackground(null);
                nineBtn.setBounds(nineBtn.getX() + 5, nineBtn.getY(),
                        nineBtn.getWidth() - 10, nineBtn.getHeight());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                nineBtn.setOpaque(true);
                nineBtn.setBackground(UIManager.getColor("Button.darkShadow"));
                nineBtn.setBounds(nineBtn.getX() - 5, nineBtn.getY(),
                        nineBtn.getWidth() + 10, nineBtn.getHeight());
            }

        });
        nineBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "9");
                }
            }
        });
        nineBtn.setToolTipText("9");
        nineBtn.setOpaque(true);
        nineBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
        nineBtn.setBorder(BorderFactory
                .createLineBorder(new Color(50, 205, 50)));
        nineBtn.setBounds(478, 278, 75, 38);
        panelCalculate.add(nineBtn);

        JButton exponentBtn = new JButton("^");
        exponentBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "^");
                }
            }
        });
        exponentBtn.setToolTipText("^");
        exponentBtn.setOpaque(true);
        exponentBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
        exponentBtn.setBorder(BorderFactory.createLineBorder(new Color(50, 205,
                50)));
        exponentBtn.setBounds(297, 226, 75, 38);
        panelCalculate.add(exponentBtn);

        JButton leftBraceBtn = new JButton("(");
        leftBraceBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "(");
                }
            }
        });
        leftBraceBtn.setToolTipText("(");
        leftBraceBtn.setOpaque(true);
        leftBraceBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
        leftBraceBtn.setBorder(BorderFactory.createLineBorder(new Color(50,
                205, 50)));
        leftBraceBtn.setBounds(391, 226, 75, 38);
        panelCalculate.add(leftBraceBtn);

        JButton rightBraceBtn = new JButton(")");
        rightBraceBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + ")");
                }
            }
        });
        rightBraceBtn.setToolTipText(")");
        rightBraceBtn.setOpaque(true);
        rightBraceBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
        rightBraceBtn.setBorder(BorderFactory.createLineBorder(new Color(50,
                205, 50)));
        rightBraceBtn.setBounds(478, 226, 75, 38);
        panelCalculate.add(rightBraceBtn);

        JButton sinBtn = new JButton("sin");
        sinBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "sin(");
                }
            }
        });
        sinBtn.setToolTipText("sin");
        sinBtn.setOpaque(true);
        sinBtn.setFont(new Font("Lucida Console", Font.BOLD, 25));
        sinBtn.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
        sinBtn.setBounds(297, 126, 75, 38);
        panelCalculate.add(sinBtn);

        JButton cosBtn = new JButton("cos");
        cosBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "cos(");
                }
            }
        });
        cosBtn.setToolTipText("cos");
        cosBtn.setOpaque(true);
        cosBtn.setFont(new Font("Lucida Console", Font.BOLD, 25));
        cosBtn.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
        cosBtn.setBounds(391, 126, 75, 38);
        panelCalculate.add(cosBtn);

        JButton tanBtn = new JButton("tan");
        tanBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "tan(");
                }
            }
        });
        tanBtn.setToolTipText("tan");
        tanBtn.setOpaque(true);
        tanBtn.setFont(new Font("Lucida Console", Font.BOLD, 25));
        tanBtn.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
        tanBtn.setBounds(478, 126, 75, 38);
        panelCalculate.add(tanBtn);

        piBtn = new JButton("\u03C0");
        piBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "π");
                }
            }
        });
        piBtn.setToolTipText("pi");
        piBtn.setOpaque(true);
        piBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
        piBtn.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
        piBtn.setBounds(188, 378, 75, 38);
        panelCalculate.add(piBtn);

        eBtn = new JButton("e");
        eBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "e");
                }
            }
        });
        eBtn.setToolTipText("e");
        eBtn.setOpaque(true);
        eBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
        eBtn.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
        eBtn.setBounds(188, 328, 75, 38);
        panelCalculate.add(eBtn);

        JButton sqrtBtn = new JButton("√");
        sqrtBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(String.valueOf(Math.sqrt(Double.parseDouble(textfield.getText()))));
                }
            }
        });
        sqrtBtn.setToolTipText("√");
        sqrtBtn.setOpaque(true);
        sqrtBtn.setFont(new Font("Lucida Console", Font.BOLD, 32));
        sqrtBtn.setBorder(BorderFactory
                .createLineBorder(new Color(50, 205, 50)));
        sqrtBtn.setBounds(188, 278, 75, 38);
        panelCalculate.add(sqrtBtn);

        final JButton modeBtn = new JButton("Degrees");
        modeBtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (onDegrees) {
                    modeBtn.setForeground(Color.WHITE);
                    modeBtn.setBackground(Color.BLUE);
                    modeBtn.setText("Radians");
                } else {
                    modeBtn.setForeground(Color.BLACK);
                    modeBtn.setBackground(Color.MAGENTA);
                    modeBtn.setText("Degrees");

                }
                modeBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                modeBtn.setBounds(modeBtn.getX() + 5, modeBtn.getY(),
                        modeBtn.getWidth() - 10, modeBtn.getHeight());

            }

            @Override
            public void mouseExited(MouseEvent e) {
                modeBtn.setForeground(new Color(50, 205, 50));
                modeBtn.setText("Degrees");
                if (modeChosen > 0) {
                    if (onDegrees) {
                        modeBtn.setBackground(Color.MAGENTA);
                        modeBtn.setText("Degrees");
                        modeBtn.setForeground(Color.BLACK);
                    } else {
                        modeBtn.setForeground(Color.WHITE);
                        modeBtn.setBackground(Color.BLUE);
                        modeBtn.setText("Radians");
                    }
                } else {
                    modeBtn.setBorder(BorderFactory.createLineBorder(new Color(
                            50, 205, 50)));
                    modeBtn.setBackground(UIManager
                            .getColor("Button.darkShadow"));
                }
                modeBtn.setBounds(modeBtn.getX() - 5, modeBtn.getY(),
                        modeBtn.getWidth() + 10, modeBtn.getHeight());
            }

        });
        modeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modeChosen++;
                if (onDegrees == false) {
                    onDegrees = true;
                    modeBtn.setToolTipText("Degrees");
                    modeBtn.setText("Degrees");
                    modeBtn.setBackground(Color.MAGENTA);
                    modeBtn.setForeground(Color.BLACK);
                    modeBtn.setBorder(BorderFactory
                            .createLineBorder(Color.BLACK));
                } else {
                    onDegrees = false;
                    modeBtn.setToolTipText("Radians");
                    modeBtn.setText("Radians");
                    modeBtn.setBackground(Color.BLUE);
                    modeBtn.setForeground(Color.WHITE);
                    modeBtn.setBorder(BorderFactory
                            .createLineBorder(Color.BLACK));
                }
            }
        });
        modeBtn.setToolTipText("On");
        modeBtn.setOpaque(true);
        modeBtn.setFont(new Font("Lucida Console", Font.BOLD, 15));
        modeBtn.setBorder(BorderFactory
                .createLineBorder(new Color(50, 205, 50)));
        modeBtn.setBounds(188, 226, 75, 38);
        panelCalculate.add(modeBtn);

        JButton invSin = new JButton("sin^-1");
        invSin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "arcsin(");
                }
            }
        });
        invSin.setToolTipText("arcsin");
        invSin.setOpaque(true);
        invSin.setFont(new Font("Lucida Console", Font.BOLD, 18));
        invSin.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
        invSin.setBounds(297, 176, 75, 38);
        panelCalculate.add(invSin);

        JButton invTan = new JButton("tan^-1");
        invTan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "arctan(");
                }
            }
        });
        invTan.setToolTipText("arctan");
        invTan.setOpaque(true);
        invTan.setFont(new Font("Lucida Console", Font.BOLD, 18));
        invTan.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
        invTan.setBounds(478, 176, 75, 38);
        panelCalculate.add(invTan);

        JButton invCos = new JButton("cos^-1");
        invCos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn) {
                    if (textfield.getText().equals("0")) {
                        textfield.setText("");
                    }
                    textfield.setText(textfield.getText() + "arccos(");
                }
            }
        });
        invCos.setToolTipText("arccos");
        invCos.setOpaque(true);
        invCos.setFont(new Font("Lucida Console", Font.BOLD, 18));
        invCos.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
        invCos.setBounds(391, 176, 75, 38);
        panelCalculate.add(invCos);
    }
    public JPanel getPanelCalculate() {return panelCalculate;}
    public String getTitleCalculator(){return title;}

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
            } else{
                newExpression2 += newExpression1.charAt(j);
            }
        }

        try {
            Expression e = new Expression(newExpression2);
            double ans = e.evaluate();
            answer = ans;
            textfield.setText(Double.toString(ans));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Por favor ingrese un número válido! Ingresaste: " + "\""
                            + textfield.getText() + "\"");
            textfield.setText("");
        }

        /*
         * boolean powPressed = false; Interpreter parse = new Interpreter();
         *
         * char[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
         * boolean timeToBreak = false; String firstexp = expression; String
         * firstpart = ""; String secondpart = ""; StringBuffer buf = new
         * StringBuffer(expression); for (int j = 0; j < expression.length();
         * j++) { for (int k = 0; k < nums.length; k++) { if
         * (expression.charAt(j) == nums[k]) { secondpart =
         * expression.substring(j); timeToBreak = true; break; } } if
         * (timeToBreak) { break; } else { firstpart += expression.charAt(j); }
         * } expression = firstpart + ".0" + secondpart;
         */

        /*
         * parse.eval("result = " + expression + " + 0.0"); parse.set("result",
         * Double.class); System.out.println(parse.get("result")); if
         * (isDouble(parse.get("result"))) { System.out.println("I got here!");
         * double ans = (double) parse.get("result"); answer = ans;
         * textfield.setText(Double.toString(ans)); } else if
         * (isInteger(parse.get("result"))) { int ans = (int)
         * parse.get("result"); answer = ans;
         * textfield.setText(Integer.toString(ans)); } } catch (EvalError e1) {
         * String[] values = textfield.getText().trim().split(" "); String
         * newExpression = ""; for (int i = 0; i < values.length - 1; i++) { if
         * (values[i].trim().equals("Ans")) { newExpression += answer; } else if
         * (values[i].trim().equals("sin")) { newExpression += "Math.sin"; }
         * else if (values[i].trim().equals("cos")) { newExpression +=
         * "Math.cos"; } else if (values[i].trim().equals("tan")) {
         * newExpression += "Math.tan"; } else if (values[i].trim().equals("^"))
         * { int numParentheses = 0; String firstVal = values[i - 1];
         * StringBuffer value1Buf = new StringBuffer(firstVal); for (int j = 0;
         * j < values[i - 1].length(); j++) { if (values[i - 1].charAt(j) ==
         * '(') { numParentheses++; value1Buf.deleteCharAt(0); } } values[i - 1]
         * = value1Buf.toString();
         *
         * String secondVal = values[i + 1]; StringBuffer value2Buf = new
         * StringBuffer(secondVal); for (int k = 0; k < values[i + 1].length();
         * k++) { if (values[i + 1].charAt(k) == ')') {
         * value2Buf.deleteCharAt(value2Buf.length() - 1); } } values[i + 1] =
         * value2Buf.toString();
         *
         * newExpression += "Math.pow(" + values[i - 1] + ", " + values[i + 1] +
         * ")"; for (int b = 0; b < numParentheses; b++) { newExpression += ")";
         * }
         *
         * StringBuffer buf = new StringBuffer(newExpression);
         * buf.deleteCharAt(newExpression.indexOf("Math.pow(") - 1);
         * newExpression = buf.toString(); powPressed = true; } else { if
         * (powPressed) { if (!values[i + 1].trim().equals("")) { newExpression
         * += values[i + 1]; } } else { newExpression += values[i]; } } }
         *
         * try { parse.eval("result = " + newExpression); if
         * (isDouble(parse.get("result"))) { Double ans = (Double)
         * parse.get("result"); answer = ans;
         * textfield.setText(Double.toString(ans)); } else { Integer ans =
         * (Integer) parse.get("result"); answer = ans;
         * textfield.setText(Integer.toString(ans)); } } catch (EvalError e2) {
         * JOptionPane.showMessageDialog(null,
         * "Please enter a valid number! You have entered: " + "\"" +
         * textfield.getText() + "\""); textfield.setText("");
         *
         * } } decimalPressed = false;
         */

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (textfield.getText().equals("0")) {
            textfield.setText("");
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

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
