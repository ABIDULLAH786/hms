package hms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Upd_Std extends VarUpd_Std  implements ActionListener
{
	public Upd_Std()
	{

		fH = new Font("Serif",Font.BOLD,20);
		JFrame frame = new JFrame("WELCOME TO STUDENT REGISTRATION");
		frame.setSize(1200,700);
		frame.setLayout(null);
  
		Submit = new JButton("Update");
		Submit.setBounds(568,600,90,40 );
		
		/* // Registration Page
                Regis_page = new JPanel(); 
		Regis_page.setBounds(300,170,470,500);
		Regis_page.setBackground(new Color(0,0,0,60)); */
		
		// Heading
		Heading = new JPanel();
		Heading.setBackground(new Color(0,0,0,80));
		Heading.setBounds(0,0,1200,100);
		
		// Name_Heading
		Name_Heading = new JLabel(" UPDATE DATA PAGE ");
		Name_Heading.setBounds(100,500,400,100);
		Name_Heading.setFont(fH);
		
		// Background Img
		background = new ImageIcon("D:/SEMESTERS/4th-Semester/Database System/project/HMS/src/hms/HostelPic1.jpg");
                img = new JLabel("",background,JLabel.CENTER);
		img.setBounds(0,0,1200,700);			
		
		// JComboBox
		Progr = new JComboBox();
		Progr.addItem("Regular Programe");
		Progr.addItem("Summar Programe");
		Progr.addItem("Fall Programe");
		Progr.setBounds(535,550,150,20);		
		img.add(Progr);
		lb_Prog_Name = new JLabel("Programe Name:");
		Progr.addActionListener(this);
		
		// JTextField 
		Tf_name = new JTextField(20);
    	Tf_name.setBounds(470,150,300,30);
		
		Tf_Fname = new JTextField(20);
    	Tf_Fname.setBounds(470,200,300,30);	

		Tf_ID = new JTextField(20);
    	Tf_ID.setBounds(470,250,300,30);	

		Tf_Semest = new JTextField(20);
    	Tf_Semest.setBounds(470,300,300,30);	

		Tf_Depart = new JTextField(20);
    	Tf_Depart.setBounds(470,350,300,30);	

		Tf_DoB = new JTextField(20);
    	Tf_DoB.setBounds(470,400,300,30);	

		Tf_Resident = new JTextField(20);
    	Tf_Resident.setBounds(470,450,300,30);	
		
		// Male or Femal Button
		Male = new JRadioButton("MALE");
        Male.setBounds(535,500,60,25);		
		
		Female = new JRadioButton("FEMALE");
        Female.setBounds(620,500,70,25);		
			
	
		Male.addActionListener(this);
	    Female.addActionListener(this);
		
	
	   // Adding 
    	lb_Name.setBounds(280,145,300,30);
		lb_Name.setFont(fH);
		img.add(lb_Name);
		img.add(Tf_name);
		
		lb_Fname.setBounds(280,200,300,30);
		lb_Fname.setFont(fH);
		img.add(lb_Fname);
		img.add(Tf_Fname);
		
		
		lb_ID.setBounds(280,245,300,30);
		lb_ID.setFont(fH);
		img.add(lb_ID);
		img.add(Tf_ID);
		
		lb_Semest.setBounds(280,300,300,30);
		lb_Semest.setFont(fH);
		img.add(lb_Semest);
		img.add(Tf_Semest);
		
		
		lb_Depart.setBounds(280,345,300,30);
		lb_Depart.setFont(fH);
		img.add(lb_Depart);
		img.add(Tf_Depart);
		
		
		lb_DoB.setBounds(280,400,300,30);
		lb_DoB.setFont(fH);
		img.add(lb_DoB);
		img.add(Tf_DoB);
		
		
		lb_Resident.setBounds(280,445,300,30);
		lb_Resident.setFont(fH);
		
		lb_Gender.setBounds(280,490,300,30);
		lb_Gender.setFont(fH);
		
		lb_Prog_Name.setBounds(280,540,300,30);
		lb_Prog_Name.setFont(fH);
		
		
		img.add(lb_Resident);
		img.add(Tf_Resident);
		img.add(lb_Gender);
		img.add(lb_Prog_Name);
		img.add(Heading);
		//img.add(Regis_page);

		Submit.addActionListener(this);
		img.add(Submit);
		Heading.add(Name_Heading);
		img.add(Male);
		img.add(Female);
		
		frame.add(img);
			
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setResizable(false);	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==Submit)
		{
				String GENDER=null;
		
			try
			{
				if(Male.isSelected())
				{
						GENDER="Male";
				}
				else if(Female.isSelected())
				{
					GENDER="Female";
				}
		/* 
				if(Progr.isSelected())
				{
					String Pro_Selec_Temp=Progr.isSelected();
					if(Pro_Selected.equalsIgnoreCase("Summar"))
					{
						
					}
					
				} */
		
			Connection con;
			Statement stmt;
			ResultSet re;
			
		Class.forName("com.mysql.jdbc.Driver");	
		//String msAccDB = "StudentData.accdb";
		//String dbURL = "jdbc:ucanaccess://" + msAccDB;
		String date = Tf_DoB.getText().toString();
		String url = "jdbc:mysql://localhost:3306/studentdata";
		con = DriverManager.getConnection(url,"root","12345");
		stmt = con.createStatement();
		//short IDNo = Short.parseShort(Tf_ID.getText());
		//String IDNo =Tf_ID.getText();

String query = "Update StudentEntry Set std_Name='"+Tf_name.getText()+"',F_Name='"+Tf_Fname.getText()+"',Semester='"+Tf_Semest.getText()+"',Depart='"+Tf_Depart.getText()+"',DOB='"+date+"',Address='"+Tf_Resident.getText()+"',Gender='"+GENDER+"',Programe='"+Progr.getSelectedItem().toString()+"' where ID_NO="+Tf_ID.getText().toString();
		
		//System.out.println("ok");
		int affected = stmt.executeUpdate(query);
		
			if(affected>0)
			{
			System.out.println("Updated");
			}
			else
			System.out.println("Data didn't Update");
	
			stmt.close();
			con.close();	
	
			}
			catch(Exception err)
			{
				System.out.println("Error:"+err);
			}			
			
			JOptionPane.showMessageDialog(null,"Successfully Updated!");
		}
	}
	
        /*
	public static void main(String args[])
	{
		new Upd_Std();
	}
        */
}

class VarUpd_Std
{	
	String Name;
	String F_name;
	String ID;
	String Semest;
    String Depart;
	String DoB;
	String Resident;

	Font fH;
	JLabel lb_Semest= new JLabel("SEMESTER:");
	JLabel lb_Name = new JLabel("CANDIDATE NAME:");
	JLabel lb_Fname = new JLabel("FATHER NAME:");
	JLabel lb_ID= new JLabel("ID NO:");
    JLabel lb_Depart= new JLabel("DEPARTMENT:");
	JLabel lb_DoB= new JLabel("DATE OF BIRTH:");
	JLabel lb_Gender  = new JLabel("GENDER:") ;
	JLabel lb_Resident= new JLabel("RESIDENT ADD:");
	
		
    JRadioButton Male;
	JRadioButton Female;
	
	JTextField Tf_name;
	JTextField Tf_Fname;
	JTextField Tf_ID;
	JTextField Tf_Semest;
	JTextField Tf_Depart;
	JTextField Tf_DoB;
	JTextField Tf_Resident;
	
	JButton Submit;
	JLabel img;
	ImageIcon background;
	JPanel Heading;
	JLabel Name_Heading;
	JComboBox Progr;
	JLabel lb_Prog_Name;
 
}