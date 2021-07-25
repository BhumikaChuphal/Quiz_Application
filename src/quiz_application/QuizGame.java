
package quiz_application;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class QuizGame extends JFrame implements ActionListener
{
	ImageIcon img1;
	JLabel jlabel1;
	JLabel jlabel2;
	JLabel jlabel3;
	JTextField jtextfield1;
	JButton btn1;
	JButton btn2;
	
    QuizGame()
    {
    	setBounds(100, 150, 1100, 550);   
    	setLayout(null);
    	getContentPane().setBackground(Color.WHITE);
    	
    	///////////////////////////////////////////////////////////////
    	
    	img1=new ImageIcon(ClassLoader.getSystemResource("Image/start_img.jpeg"));
    	jlabel1=new JLabel(img1);
    	jlabel1.setBounds(0, 0, 730, 520);
    	add(jlabel1);
    	
    	jlabel2=new JLabel("WELCOME");
    	jlabel2.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
    	jlabel2.setForeground(new Color(210,90,100));          
    	jlabel2.setBounds(790, 60, 300, 50);
    	add(jlabel2);
    	
    	//For entering name
    	jlabel3=new JLabel("Enter Your Name ");
    	jlabel3.setFont(new Font("Mangolian Baiti", Font.BOLD, 20));
    	jlabel3.setForeground(new Color(210,90,100));          
    	jlabel3.setBounds(817, 160, 300, 20);
    	add(jlabel3);
    	
    	jtextfield1= new JTextField();
    	jtextfield1.setBounds(800,200,200,30);
    	jtextfield1.setFont(new Font("Mangolian Baiti", Font.BOLD, 15));
    	add(jtextfield1);
    	
    	//Button to start the game
    	btn1= new JButton("START");
    	btn1.setBounds(800,300,80,30);
    	btn1.setBackground(new Color(210,90,100));       
    	btn1.setForeground(Color.WHITE);
    	btn1.addActionListener(this);
    	add(btn1);
    	
    	//Button to exit from the game
    	btn2= new JButton("EXIT");
    	btn2.setBounds(940,300,80,30);
    	btn2.setBackground(new Color(210,90,100));       
    	btn2.setForeground(Color.WHITE);
    	btn2.addActionListener(this);
    	add(btn2);
    	
    	setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
    	if(e.getSource()==btn1)
    	{
    		String str=jtextfield1.getText();
    		new Rules(str);
    		this.setVisible(false);
    	}
    	else if(e.getSource()==btn2)
    	{
    		System.exit(0);
    	}
    }
    
    
    public static void main(String[] args) 
	{
		QuizGame game= new QuizGame();
	}
}
