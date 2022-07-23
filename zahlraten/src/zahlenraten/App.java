package zahlenraten;// Package name
import java.util.Scanner;//import information in terminal
import java.util.concurrent.ThreadLocalRandom;// random number pickup
import javax.swing.*;//GUI

import java.awt.Color;
import java.awt.event.ActionEvent;//ActionListenner
import java.awt.event.ActionListener;
import java.net.URL;
//new import
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.applet.Applet;
import java.awt.Image;
import java.awt.Toolkit;  

// class name App
public class App  extends Applet {
// global variable need to set with Static
    static int number=ThreadLocalRandom.current().nextInt(0,10+1);
    static int numberGUI=ThreadLocalRandom.current().nextInt(0,10+1);
    static JLabel text=new JLabel("Give in a number between 0-10");
    static JTextField textField= new JTextField();
    static int numberOfTryingGUI=0;  

    // function name "main"
    public static void main(String[] args) throws Exception {

        boolean playerNumber; 
        int numberOfTrying=0;
        boolean whilestatus;
        openGUI();

        do {
            playerNumber= guessTheNumber();
            numberOfTrying++;
            whilestatus=!playerNumber;

        } while (!playerNumber);
        System.out.println("You have been tried already "+numberOfTrying+" Times.");
    }

    public static void openGUI(){
        //Frame setting
        JFrame frame=new JFrame( "Guess the Number");
        frame.setSize(400,330);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//code to closed the show window
        frame.setLocation(500,300);
        frame.setDefaultLookAndFeelDecorated(true);// set layout form

        //text setting
        text.setBounds(70,30,200,50);
        frame.add(text);// add text in frame

        //set box for input
        textField.setBounds(70,80,200,30);
        frame.add(textField);

        //set Button
        JButton button=new JButton("guess");
        button.setBounds(70, 130, 200, 30);
        frame.add(button);
        button.setBackground(Color.orange);
        button.setOpaque(true);


        JLabel triedText=new JLabel("you have been tried already "+ numberOfTryingGUI+" times");
        triedText.setBounds(70,180,200,50);
        frame.add(triedText);// add text in frame

        //ImageIcon imageSpiral = new ImageIcon("background.png");
        ImageIcon imageSpiral = new ImageIcon("JavaProject.jpg");

        JLabel labelPic=new JLabel("you have been tried already "+ numberOfTryingGUI+" times");
        labelPic.setBounds(0,0,400,300);
        labelPic.setIcon(imageSpiral);
        frame.add(labelPic);// add text in frame
        
        

        //make the button work
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String textFromTextfield=textField.getText();//eventListener get the text from input box and save in variable name TextFromTextfield
                int numberFromGui=Integer.parseInt(textFromTextfield);
                guessTheNumberGUI(numberFromGui);
                numberOfTryingGUI++;
                triedText.setText("you have been tried already "+ numberOfTryingGUI+" times");
            }
        
        });

        Color myColor=new Color(215, 244, 186);
        frame.getContentPane().setBackground(myColor);

        ImageIcon image = new ImageIcon("JavaProject.jpg");
        JLabel backgroundImage=new JLabel(image);
        frame.add(backgroundImage);

        
        
        frame.setLayout(null);//absolute positioning
        frame.setVisible(true);//code to set the show result window visible
    }

    public static boolean guessTheNumber(){
        boolean result=false;
        System.out.println("please put your number here");
        Scanner scanner= new Scanner(System.in);
        int guessNumber=scanner.nextInt();
        if (guessNumber==number){
            System.out.println("you are right!!!");
            result=true;
          }
          else if (guessNumber>number){
              System.out.println("the number is to big.Try again!");
          }
          else{System.out.println("the number is to small.Try again!");}
       return result;    
    }
    public static boolean guessTheNumberGUI(int inputNumber){
        boolean result=false;
        
        if (inputNumber==numberGUI){
            text.setText("you are right!!!");
            result=true;
          }
          else if (inputNumber>numberGUI){
              text.setText("the number is to big.Try again!");
              textField.setText("");
          }
          else{
            text.setText("the number is to small.Try again!");
            textField.setText("");
        }
       return result;  
    }
}
