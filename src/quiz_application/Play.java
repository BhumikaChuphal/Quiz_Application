package quiz_application;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.applet.*;

public class Play extends JFrame implements ActionListener 
{
	ImageIcon img;
	JLabel jlabel1;
	JLabel qno;
	JLabel question;
	JRadioButton option1;
	JRadioButton option2;
	JRadioButton option3;
	JRadioButton option4;
	ButtonGroup options;
	JButton submit;
	JButton next;
	JButton lifeline;
	
	String [][]q = new String[10][5];
	String [][]answer = new String[10][1];
	String [][]correct_ans=new String[10][1];
	static int count=0;
	static int score=0;
	public static int timer=10;
	public static int answer_given=0;
	
	
	Play()
	{
		setBounds(300,100,1000,700);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		//Adding image at the top
		img=new ImageIcon(ClassLoader.getSystemResource("Image/brain.jpg"));
		jlabel1=new JLabel(img);
		jlabel1.setBounds(0,0,1000,300);
		add(jlabel1);
		
		//Add question number
		qno=new JLabel();
		qno.setBounds(80,325,100,30);
		qno.setFont(new Font("Mangolian Baiti",Font.BOLD,20));
		add(qno);
		
		//Frame for question 
		question=new JLabel();
		question.setBounds(120,210,900,260);
		question.setFont(new Font("Mangolian Baiti",Font.BOLD,20));
		add(question);
		
		
		//Options for the given question
		option1=new JRadioButton();
		option1.setBounds(120,380,500,25);
		option1.setBackground(Color.WHITE);
		option1.setFont(new Font("Dialog",Font.BOLD,15));
		add(option1);
		
		option2=new JRadioButton();
		option2.setBounds(120,418,500,25);
		option2.setBackground(Color.WHITE);
		option2.setFont(new Font("Dialog",Font.BOLD,15));
		add(option2);
		
		option3=new JRadioButton();
		option3.setBounds(120,456,500,25);
		option3.setBackground(Color.WHITE);
		option3.setFont(new Font("Dialog",Font.BOLD,15));
		add(option3);
		
		option4=new JRadioButton();
		option4.setBounds(120,495,500,25);
		option4.setBackground(Color.WHITE);
		option4.setFont(new Font("Dialog",Font.BOLD,15));
		add(option4);
		
		options= new ButtonGroup();
		options.add(option1);
		options.add(option2);
		options.add(option3);
		options.add(option4);
		
		
		// Questions and its options
		q[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        q[0][1] = "JVM";
        q[0][2] = "JDB";
        q[0][3] = "JDK";
        q[0][4] = "JRE";

        q[1][0] = "What is the return type of the hashCode() method in the Object class?";
        q[1][1] = "int";
        q[1][2] = "Object";
        q[1][3] = "long";
        q[1][4] = "void";

        q[2][0] = "Which package contains the Random class?";
        q[2][1] = "java.util package";
        q[2][2] = "java.lang package";
        q[2][3] = "java.awt package";
        q[2][4] = "java.io package";

        q[3][0] = "An interface with no fields or methods is known as?";
        q[3][1] = "Runnable Interface";
        q[3][2] = "Abstract Interface";
        q[3][3] = "Marker Interface";
        q[3][4] = "CharSequence Interface";

        q[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        q[4][1] = "Stack";
        q[4][2] = "String memory";
        q[4][3] = "Random storage space";
        q[4][4] = "Heap memory";

        q[5][0] = "Which of the following is a marker interface?";
        q[5][1] = "Runnable interface";
        q[5][2] = "Remote interface";
        q[5][3] = "Readable interface";
        q[5][4] = "Result interface";

        q[6][0] = "Which keyword is used for accessing the features of a package?";
        q[6][1] = "import";
        q[6][2] = "package";
        q[6][3] = "extends";
        q[6][4] = "export";

        q[7][0] = "In java, jar stands for?";
        q[7][1] = "Java Archive Runner";
        q[7][2] = "Java Archive";
        q[7][3] = "Java Application Resource";
        q[7][4] = "Java Application Runner";

        q[8][0] = "Which of the following is a mutable class in java?";
        q[8][1] = "java.lang.StringBuilder";
        q[8][2] = "java.lang.Short";
        q[8][3] = "java.lang.Byte";
        q[8][4] = "java.lang.String";

        q[9][0] = "Which of the following option leads to the portability and security of Java?";
        q[9][1] = "Bytecode is executed by JVM";
        q[9][2] = "The applet makes the Java code secure and portable";
        q[9][3] = "Use of exception handling";
        q[9][4] = "Dynamic binding between objects";
        
        
        // Correct Answers 
        correct_ans[0][0] = "JDB";
        correct_ans[1][0] = "int";
        correct_ans[2][0] = "java.util package";
        correct_ans[3][0] = "Marker Interface";
        correct_ans[4][0] = "Heap memory";
        correct_ans[5][0] = "Remote interface";
        correct_ans[6][0] = "import";
        correct_ans[7][0] = "Java Archive";
        correct_ans[8][0] = "java.lang.StringBuilder";
        correct_ans[9][0] = "Bytecode is executed by JVM";
		
        
		// Button for Life-line 
		lifeline=new JButton("LIFELINE");
		lifeline.setForeground(Color.WHITE);
		lifeline.setFont(new Font("Symbol BOLDITALIC",Font.BOLD,16));
		lifeline.setBackground(new Color(210,90,100));
		lifeline.setBounds(750,420,120,25);
		lifeline.addActionListener(this);
		add(lifeline);
		
		// Button for next question
		next=new JButton("NEXT");
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Symbol BOLDITALIC",Font.BOLD,17));
		next.setBackground(new Color(210,90,100));
		next.setBounds(750,465,120,25);
		next.addActionListener(this);
		add(next);
		
		// Button for submission
		submit=new JButton("SUBMIT");
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Symbol BOLDITALIC",Font.BOLD,17));
		submit.setBackground(new Color(210,90,100));
		submit.setBounds(750,510,120,25);
		submit.addActionListener(this);
		submit.setEnabled(false);
		add(submit);
		
		start_playing(count);
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==next)
		{
			enable_all();
			repaint();
			answer_given=1;
			submit_ans();	
			
			start_playing(++count);
			if(count==9)
			{
				next.setEnabled(false);
				submit.setEnabled(true);
			}
		}
		else if(e.getSource()==lifeline)
		{
			//options are set according to a fixed pattern
			if(count%2==0)
			{
				option2.setEnabled(false);
				option3.setEnabled(false);
			}
			else
			{
				option3.setEnabled(false);
				option4.setEnabled(false);
			}
			lifeline.setEnabled(false);
		}
		else if(e.getSource()==submit)
		{
			submit_ans();
			Cal_score();
			this.setVisible(false);
			new ScoreBoard(score).setVisible(true);
		}
	}
	
	
	//for enabling all the options
	public void enable_all()
	{
		option1.setEnabled(true);
		option2.setEnabled(true);
		option3.setEnabled(true);
		option4.setEnabled(true);
	}
	
	
	//update the screen every second (for timer)
	public void paint(Graphics g)
	{
		super.paint(g);
		String time= "Time Left : "+timer;
		g.setColor(Color.RED);
		g.setFont(new Font("Taboca", Font.BOLD,20));
		
		if(timer>0)
			g.drawString(time, 750, 420 );
		else
			g.drawString("Times Up!!", 750, 420 );
		
		timer--;
		try
		{
			Thread.sleep(1000);
			repaint();
		}
		catch(Exception e)  {}
		
		if(answer_given==1)
		{
			timer=10;
			answer_given=0;
		}
		
		//if 10 seconds up for the particular question
		if(timer<0)
		{
			timer=10;
			enable_all();
			
			//if reaches in the last question, then set submit button enable and next disable
			if(count==8)
			{
				next.setEnabled(false);
				submit.setEnabled(true);
			}
			
			//if all 10 questions get completed, calculate score
			if(count==9)
			{
				submit_ans();
				Cal_score();
				this.setVisible(false);
				new ScoreBoard(score).setVisible(true);
			}
			
			//carry on for other cases
			else
			{
				submit_ans();
				start_playing(++count);
			}
		}
	}
	
	//Calculating the score 
	private void Cal_score()
	{
		for(int i=0; i<answer.length; i++)
		{
			if(answer[i][0].equals(correct_ans[i][0]))
				score+=10;
		}
	}
	
	
	//storing the submitted answer
	private void submit_ans()
	{
		if(options.getSelection()==null)
			answer[count][0]="";
		else
			answer[count][0] = options.getSelection().getActionCommand();
	}
	
	
	//Changing the question after every 10 seconds or on clicking the next button
	private void start_playing(int count)
	{
		qno.setText(""+(count+1)+". ");
		question.setText(q[count][0]);
		
		option1.setText((q)[count][1]);
		option1.setActionCommand(q[count][1]);
		
		option2.setText((q)[count][2]);
		option2.setActionCommand(q[count][2]);
		
		option3.setText((q)[count][3]);
		option3.setActionCommand(q[count][3]);
		
		option4.setText((q)[count][4]);
		option4.setActionCommand(q[count][4]);
		
		options.clearSelection();
	}
}
