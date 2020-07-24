package hms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class Search_Student_Data extends Data_Variable_Search implements ActionListener
{
    String SearchID;
    Search_Student_Data()
    {
        // JFrame
        frame = new JFrame();
	frame.setSize(1200,700);
	frame.setLayout(null);
	frame.setVisible(true);	

        // Heading and Heading_Name
	Heading = new JPanel();
	Heading.setBackground(new Color(0,0,0,80));
	Heading.setBounds(0,0,1200,100);
       
	fH = new Font("Serif",Font.BOLD,20);
	Heading_Name = new JLabel("SEARCH DATA FROM RECORDS");
	Heading_Name.setBounds(200,25,300,50);
	Heading_Name.setFont(fH);
	Heading.add(Heading_Name);
		
	// Background Image
	background = new ImageIcon("D:/SEMESTERS/4th-Semester/Database System/project/HMS/src/hms/HostelPic3.jpg");
	Image temp_Imge_Background1 = background.getImage();
        Image temp_Imge_Background2 = temp_Imge_Background1.getScaledInstance(1200,700,Image.SCALE_SMOOTH);
	background = new ImageIcon(temp_Imge_Background2);
	Imge_Background = new JLabel("",background,JLabel.CENTER);		
		
	// Declaring the varibale
	Tf_SearchID = new JTextField();
	Tf_SearchID.setBounds(180,250,130,25);
		
	lb_SearchID= new JLabel("SEARCH ID:");
	lb_SearchID.setBounds(60,245,130,30);
	lb_SearchID.setFont(fH);
		
        // Search Button
	fH = new Font("Serif",Font.BOLD,15);
	butt_Seacrh = new JButton("Search Data");
	butt_Seacrh.setBounds(100,300,180,50);
	butt_Seacrh.setFont(fH);
		
	butt_Seacrh.addActionListener(this);
		
	// Adding Labels and Buttons as well as JTextField
	Imge_Background.add(Tf_SearchID);
	Imge_Background.add(lb_SearchID);
	Imge_Background.add(Heading);
	Imge_Background.add(butt_Seacrh);
		
	Imge_Background.setBounds(0,0,1200,700);
	frame.add(Imge_Background);
			 
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
    }
    public void actionPerformed(ActionEvent ae)
    {
	boolean chech_FOUND_OR_NOT = true;
	try
	{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/studentdata";
            con = DriverManager.getConnection(url,"root","12345");
            stmt = con.createStatement();
			
            if(ae.getSource()==butt_Seacrh)
            {
                try
                {								
                    System.out.println("ok5");
                    SearchID=Tf_SearchID.getText().toString();
                    rs =stmt.executeQuery("Select * from StudentEntry where ID_NO="+SearchID);
                    
                    while(rs.next())
                    {
                        chech_FOUND_OR_NOT = false;
                        // making variable for denoting the text
                        Lb_Semest= new JLabel("SEMESTER:");
                        Lb_Name = new JLabel("CANDIDATE NAME:");
                        Lb_Fname = new JLabel("FATHER NAME:");
                        Lb_ID= new JLabel("ID NO:");
                        Lb_Depart= new JLabel("DEPARTMENT:");
                        Lb_DoB= new JLabel("DATE OF BIRTH:");
                        Lb_Gender  = new JLabel("GENDER:") ;
                        Lb_Resident= new JLabel("RESIDENT ADD:");
                        Lb_Program = new JLabel("PROGRAME:");
                        System.out.print("Ch_1");
                        
                        //Declaring the varia
                        Tf_ID = new JTextField(rs.getString(1));
                        Tf_name = new JTextField(rs.getString(2));
                        Tf_Fname = new JTextField(rs.getString(3));
                        Tf_Semest = new JTextField(rs.getString(4));
                        Tf_Depart = new JTextField(rs.getString(5));
                        Tf_DoB = new JTextField(rs.getString(6));
                        Tf_Resident = new JTextField(rs.getString(7));
                        Tf_Gender = new JTextField(rs.getString(8));
                        Tf_Program =  new JTextField(rs.getString(9));
                        System.out.print("Ch_2");
                        fH = new Font("Serif",Font.BOLD,30);

                        //Setting labels on frame
                        Lb_ID.setBounds(400,230,200,30);
                        Lb_Name.setBounds(400,280,200,30);
                        Lb_Fname.setBounds(400,330,200,30);
                        Lb_Semest.setBounds(400,380,200,30);
                        Lb_Depart.setBounds(400,430,200,30);
                        Lb_DoB.setBounds(400,480,200,30);
                        Lb_Resident.setBounds(400,530,200,30);
                        Lb_Gender.setBounds(400,580,200,30);
                        Lb_Program.setBounds(400,630,200,30);
                        System.out.print("Ch_3");
        
                        //Setting test field on frame         
                        Tf_ID.setBounds(860,230,300,30);
                        Tf_name.setBounds(860,280,300,30);
                        Tf_Fname.setBounds(860,330,300,30);
                        Tf_Semest.setBounds(860,380,300,30);
                        Tf_Depart.setBounds(860,430,300,30);
                        Tf_DoB.setBounds(860,480,300,30);
                        Tf_Resident.setBounds(860,530,300,30);
                        Tf_Gender.setBounds(860,580,300,30);
                        Tf_Program.setBounds(860,630,300,30);
                        System.out.print("Ch_4");
                        
                        // this TextField..........
                        Imge_Background.add(Tf_ID);
                        Imge_Background.add(Tf_name);
                        Imge_Background.add(Tf_Fname);
                        Imge_Background.add(Tf_Semest);
                        Imge_Background.add(Tf_Depart);
                        Imge_Background.add(Tf_DoB);
                        Imge_Background.add(Tf_Resident);
                        Imge_Background.add(Tf_Gender);
                        Imge_Background.add(Tf_Program);
                        System.out.print("Ch_5");						
                        // this labels for denoting the text field..........
                        Imge_Background.add(Lb_ID);
                        Imge_Background.add(Lb_Name);
                        Imge_Background.add(Lb_Fname);
                        Imge_Background.add(Lb_Semest);
                        Imge_Background.add(Lb_Depart);
                        Imge_Background.add(Lb_DoB);
                        Imge_Background.add(Lb_Resident);
                        Imge_Background.add(Lb_Gender);
                        Imge_Background.add(Lb_Program);
                        System.out.print("Ch_6");
                    }
                    if(chech_FOUND_OR_NOT)//if data is not found
                    {
                        JOptionPane.showMessageDialog(null,"DATA NOT FOUND!");
                        try
                        {
                            stmt.close();
                            con.close();
                        }
                        catch(Exception err)
                        {
                            System.out.println("ERROR : "+err);
                        }
                    }
                }
                catch(Exception ar)
                {
                    System.out.println("ERROR : "+ar.getMessage());
                }
                finally
                {
                    try
                    {
                        stmt.close();
                        con.close();
                    }
                    catch(Exception err)
                    {
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


class Data_Variable_Search
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
	
	// making variable for denoting the text
	JLabel Lb_Semest;
	JLabel Lb_Name ;
	JLabel Lb_Fname;
	JLabel Lb_ID;
        JLabel Lb_Depart;
	JLabel Lb_DoB;
	JLabel Lb_Gender;
	JLabel Lb_Resident;
	JLabel Lb_Program ;
	
       
	
	// making Variable for Frame its button
	JLabel Imge_Background;
	JLabel Heading_Name;
	Font fH;
	ImageIcon background;
	JButton butt_Seacrh;		
	JPanel Heading;
	JFrame frame;
	
	JTextField Tf_SearchID;
	JLabel lb_SearchID;	
	
}