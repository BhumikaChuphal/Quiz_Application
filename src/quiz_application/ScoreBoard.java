package quiz_application;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ScoreBoard extends JFrame implements ActionListener
{
	ImageIcon img;
	JLabel jlabel1;
	JLabel jlabel2;
	JLabel jlabel3;
	JButton play_again;
	JButton exit;
	
	ScoreBoard(int score)
	{
		setBounds(100, 150, 1100, 550);   
    	setLayout(null);
    	getContentPane().setBackground(Color.WHITE);
    	
    	///////////////////////////////////////////////////////////////
    	
    	img=new ImageIcon(ClassLoader.getSystemResource("Image/score.png"));
    	jlabel1=new JLabel(img);
    	jlabel1.setBounds(0, -20, 730, 520);
    	add(jlabel1);
    	
    	jlabel2=new JLabel("Thank you for playing !!");
    	jlabel2.setFont(new Font("Jokerman", Font.BOLD | Font.ITALIC, 35));
    	jlabel2.setForeground(new Color(210,90,100));          
    	jlabel2.setBounds(270, 50, 500, 50);
    	add(jlabel2);
    	
    	//Displaying Score
    	jlabel3=new JLabel();
    	jlabel3.setFont(new Font("Jokerman", Font.BOLD, 40));
    	jlabel3.setForeground(new Color(210,90,100));          
    	jlabel3.setBounds(650, 200, 400, 60);
    	jlabel3.setText("Your Score is "+ score);
    	add(jlabel3);
    	
    	//Button for playing again
    	play_again=new JButton("PLAY AGAIN");
    	play_again.setForeground(Color.WHITE);
    	play_again.setFont(new Font("Symbol BOLDITALIC",Font.BOLD,17));
    	play_again.setBackground(new Color(210,90,100));
    	play_again.setBounds(560,400,150,30);
    	play_again.addActionListener(this);
		add(play_again);
    	
		//Button to exit from the screen
		exit= new JButton("Exit");
		exit.setBounds(910,400,100,30);
		exit.setBackground(new Color(210,90,100)); 
		exit.setFont(new Font("Symbol BOLDITALIC",Font.BOLD,17));
		exit.setForeground(Color.WHITE);
		exit.addActionListener(this);
    	add(exit);
    	
    	setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==play_again)
		{
			new QuizGame();
			this.setVisible(false);
		}
		else if(e.getSource()==exit)
		{
			System.exit(0);
		}
	}
}
