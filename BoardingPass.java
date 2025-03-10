package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class BoardingPass extends JFrame implements ActionListener{
    
    JTextField  tfpnr;
    JLabel tfname, tfnationality, lblsrc, lbldest, labelfname, labelfcode,lbldate,lbltiming,labelfare;
    JButton fetchButton;
    
    
    
    public BoardingPass(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(380,10,450,35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);
        
        JLabel subheading = new JLabel("Boarding Pass");
        subheading.setBounds(360,50,300,30);
        subheading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        subheading.setForeground(Color.BLUE);
        add(subheading);
        
        JLabel lblaadhar = new JLabel("PNR DETAILS");
        lblaadhar .setBounds(60,100,150,25);
        lblaadhar .setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar );
                
        tfpnr = new JTextField();
        tfpnr.setBounds(220,100,150,25);
        add(tfpnr);
        
        fetchButton = new JButton("Enter");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380,100,120,25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        
                
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60,140,150,25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
                
        tfname = new JLabel();
        tfname.setBounds(220,140,150,25);
        add(tfname);
        
        
        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60,180,150,25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
                
        tfnationality = new JLabel();
        tfnationality.setBounds(220,180,150,25);
        add(tfnationality);
        
        
        
        JLabel lbladdress = new JLabel("SRC");
        lbladdress.setBounds(60,220,150,25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
                
        lblsrc = new JLabel();
        lblsrc.setBounds(140,220,150,25);
        add(lblsrc);
        
        JLabel lblgender = new JLabel("DEST");
        lblgender.setBounds(250,220,150,25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        lbldest = new JLabel();
        lbldest.setBounds(330,220,150,25);
        add(lbldest);
        
       
        
       
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60,260,150,25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
                
        labelfname = new JLabel();
        labelfname.setBounds(220,260,150,25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(380,260,150,25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
                
        labelfcode = new JLabel();
        labelfcode.setBounds(540,260,150,25);
        add(labelfcode);
        
        JLabel labeldate = new JLabel("Date");
        labeldate.setBounds(60,300,150,25);
        labeldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labeldate);
                
        lbldate = new JLabel();
        lbldate.setBounds(220,300,150,25);
        add(lbldate);
        
        JLabel lbltime = new JLabel("Time");
        lbltime.setBounds(60, 340, 150, 25);
        lbltime.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltime);

        lbltiming = new JLabel();
        lbltiming.setBounds(220, 340, 150, 25);
        add(lbltiming);
        
        JLabel lblfare = new JLabel("Fare");
        lblfare.setBounds(60, 380, 150, 25);
        lblfare.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfare);

        labelfare = new JLabel();
        labelfare.setBounds(220, 380, 150, 25);
        add(labelfare);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600,0,300,300);
        add(lblimage);
        
       
        
        setSize(1000,450);
        setLocation(300,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
      
        String pnr = tfpnr.getText();
        
        
        
        try{
            Conn conn = new Conn();
            String query = "select * from reservation where  PNR = '"+pnr+"'";
            
            ResultSet  rs = conn.s.executeQuery(query);
            
            if(rs.next()){
                tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality"));
                lblsrc.setText(rs.getString("src"));
                lbldest.setText(rs.getString("des"));
                labelfname.setText(rs.getString("flightname"));
                labelfcode.setText(rs.getString("flightcode"));
                lbldate.setText(rs.getString("ddate"));
                lbltiming.setText(rs.getString("timing"));
                labelfare.setText(rs.getString("fare"));
                
            
            }else{
                JOptionPane.showMessageDialog(null, "Please enter correct PRN");
            }
            
        } catch(Exception e){
            e.printStackTrace();
        
        }
        
      
    }
    
    public static void main(String[] args){
        new BoardingPass();
    }
    
}
