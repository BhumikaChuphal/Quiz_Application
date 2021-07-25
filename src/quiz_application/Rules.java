package quiz_application;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;


public class Rules extends JFrame implements ActionListener
{
	JLabel jlabel1;
	JLabel jlabel2;
	JButton back;
	JButton start;
	
	
	Rules(String username)
	{
		setBounds(300,100,800,600);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		//Welcome Message
		jlabel1=new JLabel("Welcome "+username+" to Quiz Competition");
		jlabel1.setFont(new Font("Mangolian Baiti",Font.BOLD,30));
		jlabel1.setForeground(new Color(210,90,100));
		jlabel1.setBounds(110,20,800,50);
		add(jlabel1);
		
		//Rules of the game
		jlabel2=new JLabel();
		jlabel2.setFont(new Font("Mangolian Baiti",Font.PLAIN,18));
		jlabel2.setForeground(Color.BLACK);
		jlabel2.setBounds(80,25,800,500);
		jlabel2.setText("<html>"+
							"1. There are overall 10 questions and you will get 4 options for each. "+"<br><br>"+
							"2. You will get 10 seconds to answer each question. "+"<br><br>"+
							"3. You will be given a lifeline to get hint for a question. "+"<br><br>"+
							"4. LifeLine can be used just once. "+"<br><br>"+
							"5. Only individual entry is allowed. "+"<br><br>"+
							"6. Only BTech Students above 7 CGPA with no backlogs are eligible. "+"<br><br>"+
							"7. Your final score will be based on your whole performance. "+"<br><br>"+
				      "</html>");
		add(jlabel2);
		
		//Exit to the start page
		back=new JButton("BACK");
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Symbol BOLDITALIC",Font.BOLD,20));
		back.setBackground(new Color(210,90,100));
		back.setBounds(130,480,100,32);
		back.addActionListener(this);
		add(back);
		
		//Start the game
		start=new JButton("START");
		start.setForeground(Color.WHITE);
		start.setFont(new Font("Symbol BOLDITALIC",Font.BOLD,20));
		start.setBackground(new Color(210,90,100));
		start.setBounds(500,480,100,32);
		start.addActionListener(this);
		add(start);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==back)
		{
			new QuizGame().setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource()==start)
		{
			new Play();
			this.setVisible(false);
		}
	}
}
