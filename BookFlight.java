package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener {
    
    JTextField tfaadhar;
    JLabel tfname, tfnationality, tfaddress, labelgender, labelfname, labelfcode, labelftiming, labelfavailableSeats,labelfare;
    JButton bookflight, fetchButton, flight;
    Choice source, destination;
    JDateChooser dcdate;
    
    public BookFlight() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(420, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        
        
        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(60, 80, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 80, 150, 25);
        add(tfaadhar);
        
        fetchButton = new JButton("Fetch User");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        
        tfaddress = new JLabel();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        labelgender = new JLabel();
        labelgender.setBounds(220, 280, 150, 25);
        add(labelgender);
        
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60, 330, 150, 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsource);
        
        source = new Choice();
        source.setBounds(220, 330, 150, 25);
        add(source);
        
        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(60, 380, 150, 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldest);
        
        destination = new Choice();
        destination.setBounds(220, 380, 150, 25);
        add(destination);
        
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM flight";
            ResultSet rs = c.s.executeQuery(query);
            
            while (rs.next()) {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        flight = new JButton("Fetch Flights");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(380, 380, 120, 25);
        flight.addActionListener(this);
        add(flight);
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 430, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220, 430, 150, 25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60, 480, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(220, 480, 150, 25);
        add(labelfcode);
        
        JLabel lbltiming = new JLabel("Timing");
        lbltiming.setBounds(60, 530, 150, 25);
        lbltiming.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltiming);
        
        labelftiming = new JLabel();
        labelftiming.setBounds(220, 530, 150, 25);
        add(labelftiming);
        
        JLabel lblavailableSeats = new JLabel("Available Seats");
        lblavailableSeats.setBounds(60, 575, 150, 25);
        lblavailableSeats.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblavailableSeats);
        
        labelfavailableSeats = new JLabel();
        labelfavailableSeats.setBounds(220, 575, 150, 25);
        add(labelfavailableSeats);
        
        JLabel lblfare = new JLabel("Fare");
        lblfare.setBounds(60, 608, 150, 25);
        lblfare.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfare);

        labelfare = new JLabel();  // New JLabel to display the fare
        labelfare.setBounds(220, 608, 150, 25);
        add(labelfare);
        
        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60, 650, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(220, 650, 150, 25);
        add(dcdate);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/bookk.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550,100,500,480);
        add(lblimage);
        
        bookflight = new JButton("Book Flight");
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(220, 680, 150, 25);
        bookflight.addActionListener(this);
        add(bookflight);
        
        setSize(1100, 800);
        setLocation(200, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetchButton) {
            String aadhar = tfaadhar.getText();
            try {
                Conn conn = new Conn();
                String query = "SELECT * FROM passenger WHERE aadhar = '" + aadhar + "'";
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    tfaddress.setText(rs.getString("address"));
                    labelgender.setText(rs.getString("gender"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct aadhar");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == flight) {
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            try {
                Conn conn = new Conn();
                String query = "SELECT * FROM flight WHERE source = '" + src + "' AND destination = '" + dest + "'";
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    labelfname.setText(rs.getString("f_name"));
                    labelfcode.setText(rs.getString("f_code"));
                    labelftiming.setText(rs.getString("timing"));
                    labelfavailableSeats.setText(rs.getString("available_seats"));
                    labelfare.setText(rs.getString("fare"));
                } else {
                    JOptionPane.showMessageDialog(null, "No flights Found");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == bookflight) {
            Random random = new Random();
            String aadhar = tfaadhar.getText();
            String name = tfname.getText();
            String nationality = tfnationality.getText();
            String flightname = labelfname.getText();
            String flightcode = labelfcode.getText();
            String timing = labelftiming.getText();
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            int availableSeats = Integer.parseInt(labelfavailableSeats.getText());
            String fare = labelfare.getText();
            
            if (availableSeats > 0) {
                try {
                    Conn conn = new Conn();
                    String updateSeatsQuery = "UPDATE flight SET available_seats = available_seats - 1 WHERE f_code = '" + flightcode + "'";
                    conn.s.executeUpdate(updateSeatsQuery);
                    
                    String reservationQuery = "INSERT INTO reservation VALUES('PNR-" + random.nextInt(1000000) + "', 'TIC-" + random.nextInt(10000) + "', '" + aadhar + "', '" + name + "', '" + nationality + "', '" + flightname + "', '" + flightcode + "', '" + src + "', '" + dest + "', '" + ddate + "', '" + timing + "', '" + fare + "')";
                    conn.s.executeUpdate(reservationQuery);
                    
                    JOptionPane.showMessageDialog(null, "Ticket Booked successfully");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No seats available for this flight.");
            }
        }
    }
    
    public static void main(String[] args) {
        new BookFlight();
    }
}