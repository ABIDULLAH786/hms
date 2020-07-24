package hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Room_Info implements ActionListener
{
    JFrame frame;   
    Font fH;
    JLabel lb_room_id;
    JLabel lb_room_capacity;
    JLabel lb_Hostel_id;
    JLabel lb_students_name ;
    JLabel lb_student_1 ;
    JLabel lb_student_2 ;
    JLabel lb_student_3 ;
    JLabel lb_room_status ;
    
    JRadioButton room_full;
    JRadioButton room_not_full;
	
    JTextField TF_room_id;
    JTextField TF_room_capacity;
    JTextField TF_Hostel_id;
    JTextField TF_students_name_1;
    JTextField TF_students_name_2;
    JTextField TF_students_name_3;
    JButton Submit;
    JButton Back;
    JLabel F_img;
    ImageIcon background_f;
    JPanel Heading;
    JLabel Name_Heading;
	
    
    public Room_Info()
    {


        fH = new Font("Serif",Font.BOLD,20);
        frame = new JFrame("WELCOME TO Hostel Info");
	frame.setSize(1200,700);
	frame.setLayout(null);
        //buttons
	Submit = new JButton("Submit");
	Submit.setBounds(645,600,100,40);
        
	Back = new JButton("Go Back");
	Back.setBounds(500,600,100,40);	
		
	// Heading
	Heading = new JPanel();
	Heading.setBackground(new Color(0,0,0,80));
	Heading.setBounds(0,0,1200,100);
	
	// Name_Heading
	Name_Heading = new JLabel("Room Info");
	Name_Heading.setBounds(120,500,400,100);
	Name_Heading.setFont(fH);
		
        // background_f F_img
	background_f = new ImageIcon(ClassLoader.getSystemResource("hms/HostelPic1.jpg"));
        F_img = new JLabel("",background_f,JLabel.CENTER);
	F_img.setBounds(0,0,1200,700);			
		
        // JLabel
        lb_room_id = new JLabel("Room ID:");
        lb_room_capacity = new JLabel("Rooms Capacity:");
        lb_Hostel_id= new JLabel("Hostel ID:");
        lb_students_name= new JLabel("Students Name:");
        lb_student_1= new JLabel("Student 1:");
        lb_student_2= new JLabel("Student 2:");
        lb_student_3= new JLabel("Student 3:");
        lb_room_status= new JLabel("Room Status:");
        

	// JTextField 
	TF_room_id = new JTextField(20);
    	TF_room_id.setBounds(470,150,300,30);
	TF_room_capacity = new JTextField(20);
    	TF_room_capacity.setBounds(470,200,300,30);	
	TF_Hostel_id = new JTextField(20);
    	TF_Hostel_id.setBounds(470,250,300,30);	
	TF_students_name_1 = new JTextField(20);
    	TF_students_name_1.setBounds(470,350,300,30);	
	TF_students_name_2 = new JTextField(20);
    	TF_students_name_2.setBounds(470,400,300,30);	
	TF_students_name_3 = new JTextField(20);
    	TF_students_name_3.setBounds(470,450,300,30);	
		
	// room_full or Femal Button
	room_full = new JRadioButton("Full");
        room_full.setBounds(470,500,60,25);		
		
	room_not_full = new JRadioButton("Not Full");
        room_not_full.setBounds(555,500,70,25);		
			
        ButtonGroup group = new ButtonGroup();
	group.add(room_full);
	group.add(room_not_full);
        
	room_full.addActionListener(this);
	room_not_full.addActionListener(this);
		
			
	Submit.addActionListener(this);
	Back.addActionListener(this);
	
	
	// Adding 
    	lb_room_id.setBounds(324,145,300,30);
	lb_room_id.setFont(fH);
	F_img.add(lb_room_id);
	F_img.add(TF_room_id);
		
	lb_room_capacity.setBounds(324,200,300,30);
	lb_room_capacity.setFont(fH);
	F_img.add(lb_room_capacity);
	F_img.add(TF_room_capacity);
        
        lb_Hostel_id.setBounds(330,245,300,30);
	lb_Hostel_id.setFont(fH);
	F_img.add(lb_Hostel_id);
	F_img.add(TF_Hostel_id);
		
	lb_students_name.setBounds(330,300,300,30);
	lb_students_name.setFont(fH);
	F_img.add(lb_students_name);
	lb_student_1.setBounds(330,350,300,30);
	lb_student_1.setFont(fH);
	F_img.add(lb_student_1);
	lb_student_2.setBounds(330,400,300,30);
	lb_student_2.setFont(fH);
	F_img.add(lb_student_2);
	lb_student_3.setBounds(330,450,300,30);
	lb_student_3.setFont(fH);
	F_img.add(lb_student_3);
	lb_room_status.setBounds(330,500,300,30);
	lb_room_status.setFont(fH);
	F_img.add(lb_room_status);
	F_img.add(TF_students_name_1);
	F_img.add(TF_students_name_2);
	F_img.add(TF_students_name_3);
		
	F_img.add(Heading);

	F_img.add(room_full);
	F_img.add(room_not_full);
        			                                       

        F_img.add(Submit);
        F_img.add(Back);
	Heading.add(Name_Heading);
	frame.add(F_img);

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
                String query = "Insert into fee(room_id, capacity, hostel_id, name_of_student, room_status) values(?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);;
		
                ps.setInt(1,Integer.parseInt(TF_room_id.getText()));
                ps.setInt(2,Integer.parseInt(TF_room_capacity.getText()));
                ps.setInt(3,Integer.parseInt(TF_Hostel_id.getText()));
                ps.setString(4,TF_students_name_1.getText() + TF_students_name_2.getText() + TF_students_name_3.getText());
              
                if(room_full.isSelected())
                    ps.setString(5,"Full");
                else if(room_not_full.isSelected())
                    ps.setString(5,"Not Full");
                else
                    JOptionPane.showMessageDialog(frame, "Please Select Hostel Status");
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(frame, "The Hostel Information did not Added successfully");
                    TF_room_id.setText("");
                    TF_room_capacity.setText("");
                    TF_Hostel_id.setText("");
                    TF_students_name_1.setText("");
                    TF_students_name_2.setText("");
                    TF_students_name_3.setText("");
                }
                else
                    JOptionPane.showMessageDialog(frame, "The Hostel Information Added successfully");
                
                con.close();
            }
            catch(Exception err)
            {
                System.out.println("\n\nError "+err.getMessage());
            }
        }
        else if(ae.getSource()==Back)
        {
            new AdminFrame();
            frame.dispose(); //this is used to run currently page and dispose opened page
        }
    }
}
