import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Calculator extends JFrame implements ActionListener
{
	JButton [][] jb;
	JTextField jtf;	
	JPanel jp;
	String s;
	short sh;
	boolean dc=false;
	boolean oc=false;
	Double d1=0.0;
	Double d2=0.0;
	Calculator()
	{
		jb = new JButton [5][4];
		jtf = new JTextField(10);
		jp = new JPanel();
		add(jtf);
		jb[0][0] = new JButton("1");
		jb[0][1] = new JButton("2");
		jb[0][2] = new JButton("3");
		jb[0][3] = new JButton("4");
		jb[1][0] = new JButton("5");
		jb[1][1] = new JButton("6");
		jb[1][2] = new JButton("7");
		jb[1][3] = new JButton("8");
		jb[2][0] = new JButton("9");
		jb[2][1] = new JButton("0");
		jb[2][2] = new JButton("Back");
		jb[2][3] = new JButton("Clear");
		jb[3][0] = new JButton("*");
		jb[3][1] = new JButton("/");
		jb[3][2] = new JButton("+");
		jb[3][3] = new JButton("-");
		jb[4][0] = new JButton(".");
		jb[4][1] = new JButton("%");
		jb[4][2] = new JButton("Sqrt");
		jb[4][3] = new JButton("=");
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<4;j++)
			{
				jb[i][j].addActionListener(this);
				jp.add(jb[i][j]);
			}
		}
		jp.setLayout(new GridLayout(5, 4));
		setLayout(new BorderLayout());
		add(jtf,BorderLayout.NORTH);
		add(jp,BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent ae)
	{
	 s = ae.getActionCommand();
	//JButton b = (JButton)ae.getSource();
	if (validNumber(s)) append(s);
	if(s.equals("Clear")) 
	{
		jtf.setText("");
		dc=false;
		oc=false;
	}
	if (s.equals(".")&&(dc==false))
	{
		dc=true;
		jtf.setText(jtf.getText()+s);
	}
	if ((s.equals("*"))||(s.equals("/"))||(s.equals("+"))||(s.equals("-"))||(s.equals("=")))
	{
		dc=false;
		calculate();
	}
	}
	public boolean validNumber(String s)
	{
		int isThisANumber = 0;
		boolean flag = true;
		try
		{
		isThisANumber = Integer.parseInt(s); 
		}
		catch (NumberFormatException nfe)
		{
			flag = false;
		}
		return flag;
	}
	public void append(String s)
	{
	jtf.setText(jtf.getText()+s);
	}
	public void calculate()
	{
	String scopy=s;
	if (oc==false)
	{
		oc=true;
		d1=Double.parseDouble(jtf.getText());
		d2=d1;
			if (s=="+") { sh=1; jtf.setText("");}
			if (s=="-") { sh=2; jtf.setText("");}
			if (s=="*") { sh=3; jtf.setText("");}
			if (s=="/") { sh=4; jtf.setText("");}
			if (s=="=") { jtf.setText(""+d1);}
	}
	else
	{
		//oc=false;
		if (!(jtf.getText().equals(""))) 
		d2=Double.parseDouble(jtf.getText());
		if (scopy==("+"))
		{
			d1=d1+d2;
			sh=1;
			//System.out.println(""+d1);
			jtf.setText("");
		}
		if (scopy==("-"))
		{
			sh=2;
			d1=d1-d2;
			jtf.setText("");
		}
		if (scopy==("*"))
		{
			sh=3;
			d1=d1*d2;
			jtf.setText("");
		}
		if (scopy==("/"))
		{
			sh=4;
			d1=d1/d2;
			jtf.setText("");
		}
		if (scopy==("="))
		{
			switch (sh)
			{
			case 1: { d1=d1+d2; break; }
			case 2: { d1=d1-d2; break; }
			case 3: { d1=d1*d2; break; }
			case 4: { d1=d1/d2; break; }
			default : break;
			}
			jtf.setText(""+d1);
		}
		
	}
	}
	public static void main(String[] args) 
	{
		Calculator cal = new Calculator();
		cal.setTitle("Simple Calculator");
		cal.setSize(275,175);
		cal.setVisible(true);
		cal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
