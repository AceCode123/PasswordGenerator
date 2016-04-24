package me.Anthony;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Generator extends JFrame {

    public static JButton create = new JButton();
    private static JCheckBox haveNumbers = new JCheckBox();
    private static JCheckBox haveStrangeCharacters = new JCheckBox();
    private static JCheckBox inCapitalLetteres = new JCheckBox();
    public static JLabel out = new JLabel();
    public static JTextField lengthField = new JTextField();
    public static JButton update = new JButton();
    public static int LENGTH = 16;
    private static String password;
    private static String[] chars = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static int[] numbers = {0,1,2,3,4,5,6,7,8,9};
    private static char[] characters = {'@', '^', '&', '*', '#'};

    public Generator() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridLayout(2,2));
        out.setFont(new Font("Corrier", Font.PLAIN, 45));
        out.setText("Password Output");
        getContentPane().add(out);
        lengthField.setFont(new Font("Corrier", Font.PLAIN, 45));
        lengthField.setText("Please enter the length of your password");
        getContentPane().add(lengthField);
        update.setFont(new Font("Corrier", Font.PLAIN, 45));
        UpdateAction up = new UpdateAction();
        update.addMouseListener(up);
        update.setText("Update");
        getContentPane().add(update);
        create.setFont(new Font("Corrier", Font.PLAIN, 45));
        create.setText("Create");
        CreateAction cAction = new CreateAction();
        create.addMouseListener(cAction);
        getContentPane().add(create);
        setTitle("Password Generator made by AceCode123");
        pack();
        setVisible(true);
    }

    public static String generate() {
        StringBuilder sb = new StringBuilder();
        String list;
        int characterType = 0;
        for(int i = 0; i < LENGTH;  i++) {
                    if(characterType == 0 ) {
                        int random = (int) (Math.random() * chars.length);
                        sb.append(chars[random]);
                        characterType++;
                        continue;
                    }
                    if(characterType == 1) {
                        int random = (int) (Math.random() * numbers.length);
                        sb.append(numbers[random]);
                        characterType++;
                        continue;
                    }
                    if(characterType == 2) {
                        int random = (int) (Math.random() * characters.length);
                        sb.append(characters[random]);
                        characterType = 0;
                    }
                }
        list = sb.toString();
        System.out.println("Password Generated, " + list);
    return list;
    }
}
class UpdateAction implements MouseListener {


    @Override
    public void mouseClicked(MouseEvent e) {
       if(Generator.lengthField.getText() != null) {
           int length = 16;
           try {
               length = Integer.parseInt(Generator.lengthField.getText());

           } catch(NumberFormatException ex) {
               Generator.lengthField.setText("Please enter a valid number!");
               System.out.println("Could not cast the length field as an integer!");
           }
           Generator.LENGTH = length;
           Generator.lengthField.setText("Length updated!");
           System.out.println("Set password length to " + length + "!");
       }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
class CreateAction implements MouseListener {


    @Override
    public void mouseClicked(MouseEvent e) {
        Generator.out.setText(Generator.generate());
        System.out.println("Generated a new password and it was output!");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
