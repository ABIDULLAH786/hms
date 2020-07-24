package hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class RemoveData extends Data_Variable implements ActionListener
{
	String SearchID;
	RemoveData()
	{
		// JFrame
		frame = new JFrame();
		frame.setSize(1200,700);
		frame.setLayout(null);
		frame.setVisible(true);	
		
		
		// Heading and Name_Heading
		Heading = new JPanel();
		Heading.setBackground(new Color(0,0,0,80));
		Heading.setBounds(0,0,1200,100);
       
		fH = new Font("Serif",Font.BOLD,20);
		Name_Head = new JLabel("REMOVE DATA FROM DATA");
		Name_Head.setBounds(200,25,300,50);
		Name_Head.setFont(fH);
		Heading.add(Name_Head);
		
		// Background Image
		background = new ImageIcon("D:/SEMESTERS/4th-Semester/Database System/project/HMS/src/hms/HostelPic.jpg");
		Image temp_Img_Background1 = background.getImage();
		Image temp_Img_Background2 = temp_Img_Background1.getScaledInstance(1200,700,Image.SCALE_SMOOTH);
		background = new ImageIcon(temp_Img_Background2);
		Img_Background = new JLabel("",background,JLabel.CENTER);		
		
		
		
		// Declaring the varibale
		IDForRemove = new JTextField();
		IDForRemove.setBounds(180,250,130,25);
		
		lb_IDRemove= new JLabel("SEARCH ID:");
		lb_IDRemove.setBounds(60,245,130,30);
		lb_IDRemove.setFont(fH);
		
		
		// Removal Button
		fH = new Font("Serif",Font.BOLD,15);
		Remove_std = new JButton("Remove");
		Remove_std.setBounds(100,300,180,50);
		Remove_std.setFont(fH);
		
		Remove_std.addActionListener(this);
		
		
		// Adding Labels and Buttons as well as JTextField
	    Img_Background.add(IDForRemove);
		Img_Background.add(lb_IDRemove);
		Img_Background.add(Heading);
		Img_Background.add(Remove_std);
		
		Img_Background.setBounds(0,0,1200,700);
		frame.add(Img_Background);
			 
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		
		try
		{
		System.out.println("Before Student");	
		//String FileName = "StudentData.accdb";
    	Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/studentdata";
		System.out.println("Before Student_1");
    	con = DriverManager.getConnection(url,"root","12345");
    	System.out.println("Before Student_2");
		stmt = con.createStatement();
		System.out.println("Before Student_3");
			
			if(ae.getSource()==Remove_std)
			{
				try
				{								
				System.out.println("Before Student_4");
					System.out.println("ok5");
					SearchID=IDForRemove.getText().toString();	
					rs =stmt.executeQuery("Select * from StudentEntry where ID_NO="+SearchID);
				  while(rs.next())
					 {
						 Tf_ID = new JTextField(rs.getString(1));
						 Tf_name = new JTextField(rs.getString(2));
						 Tf_Fname = new JTextField(rs.getString(3));
						 Tf_Semest = new JTextField(rs.getString(4));
						 Tf_Depart = new JTextField(rs.getString(5));
						 Tf_DoB = new JTextField(rs.getString(6));
						 Tf_Resident = new JTextField(rs.getString(7));
						 Tf_Gender = new JTextField(rs.getString(8));
						 Tf_Program =  new JTextField(rs.getString(9));	
					
					fH = new Font("Serif",Font.BOLD,30);
						// setting to dispaly it 
						   Tf_ID.setBounds(860,230,300,30);
						 Tf_name.setBounds(860,280,300,30);
						Tf_Fname.setBounds(860,330,300,30);
					   Tf_Semest.setBounds(860,380,300,30);
					   Tf_Depart.setBounds(860,430,300,30);
						  Tf_DoB.setBounds(860,480,300,30);
					 Tf_Resident.setBounds(860,530,300,30);
					   Tf_Gender.setBounds(860,580,300,30);
					  Tf_Program.setBounds(860,630,300,30);
					  
					  // setting Label....
						 lb_Namen.setBounds(500,230,300,30);
						lb_Fnamen.setBounds(500,280,300,30);
					   lb_Semestn.setBounds(500,330,300,30);
					   lb_Departn.setBounds(500,380,300,30);
						   lb_IDn.setBounds(500,430,300,30);
					 lb_Residentn.setBounds(500,480,300,30);
					   lb_Gendern.setBounds(500,530,300,30);
						  lb_DoBn.setBounds(500,580,300,30);
						 lb_Prog.setBounds(500,630,300,30);

						lb_IDn.setFont(fH);
						lb_Namen.setFont(fH);
						lb_Fnamen.setFont(fH);
						lb_Semestn.setFont(fH);
						lb_Departn.setFont(fH);
						lb_Residentn.setFont(fH);
						lb_Gendern.setFont(fH);
						lb_DoBn.setFont(fH);
						lb_Prog.setFont(fH);
						
	
					

						
						
						Img_Background.add(lb_Namen);
						Img_Background.add(lb_Fnamen);
						Img_Background.add(lb_Semestn);
						Img_Background.add(lb_Departn);
						Img_Background.add(lb_IDn);
						Img_Background.add(lb_Residentn);
						Img_Background.add(lb_Gendern);
						Img_Background.add(lb_DoBn);
						Img_Background.add(lb_Prog);
					
						// this TextField..........
						Img_Background.add(Tf_ID);
						Img_Background.add(Tf_name);
						Img_Background.add(Tf_Fname);
						Img_Background.add(Tf_Semest);
						Img_Background.add(Tf_Depart);
						Img_Background.add(Tf_DoB);
						Img_Background.add(Tf_Resident);
						Img_Background.add(Tf_Gender);
						Img_Background.add(Tf_Program);
						
						
						
						System.out.println("Ok");
						String DeleteData="Delete from StudentEntry where ID_NO="+SearchID;
						stmt.executeUpdate(DeleteData);
						JOptionPane.showMessageDialog(null,"Deleted");
						System.out.println("ok_deleted msg");
					
					}		
						
					
				}
				catch(Exception ar)
				{
                                    System.out.println("ok_deleted msg in");
					System.out.println("ERROR : "+ar);
				}
			finally
			{
				try
				{
                                    
                                    System.out.println("ok_deleted msg try");
					stmt.close();
					con.close();
				}
				catch(Exception err)
				{
                                    System.out.println("ok_deleted msg cat");
					System.out.println("ERROR : "+err);
				}

			}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error: "+ex);
		}
	
	}	
	
}


class Data_Variable
{
	// DataBase Connection  
	Connection con;
	Statement  stmt;
	ResultSet  rs;
	
	
	// Varibale for to display which cancelling the specific data 
	
	JTextField Tf_name;
	JTextField Tf_Fname;
	JTextField Tf_ID;
	JTextField Tf_Semest;
	JTextField Tf_Depart;
	JTextField Tf_DoB;
	JTextField Tf_Resident;
	JTextField Tf_Gender;
	JTextField Tf_Program;
	
	
	
	
	      JLabel lb_IDn= new JLabel("ID NO:");
	  JLabel lb_Semestn= new JLabel("SEMESTER:");
	   JLabel lb_Namen = new JLabel("CANDIDATE NAME:");
	  JLabel lb_Fnamen = new JLabel("FATHER NAME:");
      JLabel lb_Departn= new JLabel("DEPARTMENT:");
	     JLabel lb_DoBn= new JLabel("DATE OF BIRTH:");
	JLabel lb_Gendern  = new JLabel("GENDER:") ;
	JLabel lb_Residentn= new JLabel("RESIDENT ADD:");
	JLabel lb_Prog     = new JLabel("Programme:");

	
	
	
	// Decalaring Variable
	JLabel Img_Background;
	JLabel Name_Head;
	Font fH;
	ImageIcon background;
	JButton Remove_std;
	JButton Confirm_yes;
	JButton Confirm_No;
	JTextField Confirm_tf;
		
	JPanel Heading;
	JFrame frame;
	
	JTextField IDForRemove;
	JLabel lb_IDRemove;
	
	
	
	
}