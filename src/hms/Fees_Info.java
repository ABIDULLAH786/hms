package hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Fees_Info implements ActionListener
{
    JFrame frame;
    Font fH;
    JLabel lb_Fee_mounth;
    JLabel lb_Fee_status;
    JLabel lb_Std_ID ;

    JRadioButton Fee_Complete_Submited;
    JRadioButton Fee_Not_Complete_Submited;
	
    JTextField TF_Fee_mounth;
    JTextField TF_Std_ID;
	
    JButton Submit;
    JButton Back;
    
    JLabel img;
    ImageIcon background;
    JPanel Heading;
    JLabel Name_Heading;
    public Fees_Info()
    {
        fH = new Font("Serif",Font.BOLD,20);
        frame = new JFrame("UPDATE FACULTY DATA PAGE");
        frame.setSize(1200,700);
	frame.setLayout(null);
  
	Submit = new JButton("Submit");
	Submit.setBounds(645,600,100,40);
        
        Back = new JButton("Go Back");
	Back.setBounds(500,600,100,40);	
		
        // Heading
        Heading = new JPanel();
        Heading.setBackground(new Color(0,0,0,80));
	Heading.setBounds(0,0,1200,100);
		
	// Name_Heading
	Name_Heading = new JLabel(" FEE INFO PAGE ");
	Name_Heading.setBounds(100,500,400,100);
	Name_Heading.setFont(fH);
		
	// Background Img
	background = new ImageIcon(ClassLoader.getSystemResource("hms/HostelPic6.jpg"));
        img = new JLabel("",background,JLabel.CENTER);
	img.setBounds(0,0,1200,700);			
		
        // JLabel
        lb_Fee_mounth= new JLabel("Mounthly Fee:");
        lb_Fee_status = new JLabel("Fee Status:");
        lb_Std_ID = new JLabel("Student ID:");
	// JTextField 
	TF_Fee_mounth = new JTextField(20);
    	TF_Fee_mounth.setBounds(470,150,300,30);
	
        TF_Std_ID = new JTextField(20);
    	TF_Std_ID.setBounds(470,200,300,30);	
       
	// Fee_Complete_Submited or Fee_Not_Complete_Submited
	Fee_Complete_Submited = new JRadioButton("Complete Submited");
        Fee_Complete_Submited.setBounds(470,250,140,30);		
		
	Fee_Not_Complete_Submited = new JRadioButton("Not Complete Submited");
        Fee_Not_Complete_Submited.setBounds(615,250,160,30);
        
        ButtonGroup group = new ButtonGroup();
	group.add(Fee_Complete_Submited);
	group.add(Fee_Not_Complete_Submited);
			
	
	Fee_Complete_Submited.addActionListener(this);
	Fee_Not_Complete_Submited.addActionListener(this);
		
	
	// Adding 
    	lb_Fee_mounth.setBounds(280,145,300,30);
	lb_Fee_mounth.setFont(fH);
	img.add(lb_Fee_mounth);
	img.add(TF_Fee_mounth);
	
        lb_Std_ID.setBounds(280,200,300,30);
	lb_Std_ID.setFont(fH);
	img.add(lb_Std_ID);
        img.add(TF_Std_ID);
        
	lb_Fee_status.setBounds(280,245,300,30);
	lb_Fee_status.setFont(fH);
	img.add(lb_Fee_status);
		
	
		
	img.add(Heading);
	
        //img.add(Regis_page);
	Submit.addActionListener(this);
	Back.addActionListener(this);
        
	img.add(Submit);
	img.add(Back);
	Heading.add(Name_Heading);
	img.add(Fee_Complete_Submited);
	img.add(Fee_Not_Complete_Submited);
		
	frame.add(img);
			
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	frame.setResizable(false);
    }
	
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Submit)
        {
            try
            {
                Connection con;
		Class.forName("com.mysql.jdbc.Driver");	
		String url = "jdbc:mysql://localhost:3306/hms";
		con = DriverManager.getConnection(url,"root","pakistani12");
                String query = "Insert into Fee(fee_mounth, fee_status, std_id) values(?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);
		
                ps.setInt(1,Integer.parseInt(TF_Fee_mounth.getText()));
                ps.setInt(3,Integer.parseInt(TF_Std_ID.getText()));
                
                if(Fee_Complete_Submited.isSelected())
                {
                    ps.setString(2,"Complete Submited");
		}
                else if(Fee_Not_Complete_Submited.isSelected())
		{
                    ps.setString(2,"Not Complete Submited");
		}
		
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(frame, "The Fees Information did not Added successfully");
                    TF_Fee_mounth.setText("");
                    TF_Std_ID.setText("");
                }
                else
                    JOptionPane.showMessageDialog(frame, "The Fees Information Added successfully");

                con.close();	
	
		
            }
            catch(Exception err)
            {
                System.out.println("Error:"+err);
            }			
	
        }
        else if(ae.getSource()==Back)
        {
            new AdminFrame();
            frame.dispose(); //this is used to run currently page and dispose opened page
        }
    }
}
