package com.lms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;


public class LoginPage extends JFrame{

    Connection conn = null;
    ResultSet rs=null;
    ResultSet rs1=null;
    ResultSet rs2=null;
    ResultSet rs3=null;
    PreparedStatement pst = null;
    private JPanel Form;
    private JTextField txtUserID;
    private JPasswordField txtPwd;
    private JComboBox comboPostion;
    private JButton LOGINButton;
    private JButton CLEARButton;
    private JButton donTHaveAnButton;
    private JLabel txtUsername;
    private JLabel pass;
    private JLabel curDate;

    public String userID;
    public String  pwd;
    public static int winChecked = -1;

    //git testing here

    public LoginPage (String title){
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(Form);
        this.pack();
        setVisible(true);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2,size.height/2-getHeight()/2);
        JFrame frame = new JFrame();
        frame.addWindowStateListener(new WindowStateListener() {
            public void windowStateChanged(WindowEvent arg0) {
                frame__windowStateChanged(arg0);
            }
        });

        //initComponents();
        conn = LMSdb.java_db();
        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                userID = txtUserID.getText();

                pwd = txtPwd.getText();
                String sql = "SELECT * FROM admin WHERE Ad_id="+userID;

                String access = (comboPostion.getSelectedItem().toString());
                if (access == "Admin") {

                    try {
                        int count = 0;
                        pst = conn.prepareStatement(sql);

                        //pst.setString(1,txtUserID.getText());
                        // pst.setString(2,txtPwd.getText());
                        //pst.setString(1,comboPostion.getSelectedItem().toString());

                        rs = pst.executeQuery(sql);
                        while (rs.next()) {
                            String id = rs.getString("Ad_id");
                            String Pass = rs.getString("Password");
                            AdminM.Ad_id = id;
                            AdminM.Password =Pass;
                            count = count + 1;

                        }
                        //String sql = "SELECT Ad_id,Password FROM admin where (Ad_id = ? and Password=?)"
                        if (Objects.equals( userID, AdminM.Ad_id) && Objects.equals(pwd, AdminM.Password)) {
                            JOptionPane.showMessageDialog(null, "Welcome "+access);
                            Admin admin = new Admin("admin form");
                            admin.setVisible(true);
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Dear Admin, UserId and Password you entered wrong");
                        }


                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "fill the fields");
                    } finally {
                        try {
                            rs.close();
                            pst.close();
                        } catch (Exception e) {

                        }
                    }
                }
                if (access == "Student") {
                    userID = txtUserID.getText();
                    //String sqlAdmin = "SELECT Std_id,Password FROM student where Std_id ="+userID;

                    try {

                        pst = conn.prepareStatement("SELECT Std_id,Password FROM student where Std_id ="+userID);
                        rs1 = pst.executeQuery();
                        while (rs1.next()) {
                            String id = rs1.getString("Std_id");
                            String Pass = rs1.getString("Password");
                            Student.Std_id = id;
                            Student.Password = Pass;
                        }
                        if (Objects.equals(userID, Student.Std_id) && Objects.equals(pwd, Student.Password)){
                            JOptionPane.showMessageDialog(null, "Welcome "+access);
                            StudentForm2 studentForm2 = new StudentForm2("Student from");
                            studentForm2.setVisible(true);
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Dear Student, UserId and Password you entered wrong " );
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,e);
                    }
                    finally {
                        try {
                            rs1.close();
                            pst.close();
                        } catch (Exception e) {

                        }
                    }
                }
                if (access == "Technical Officer") {
                    String userIDt = txtUserID.getText();
                    //String sqlTecOfficer = "SELECT Tec_id,Password FROM tecofficer where Tec_id ="+userID;

                    try {

                        pst = conn.prepareStatement("SELECT Tec_id,Password FROM tecofficer where Tec_id =?");
                        pst.setString(1,userIDt);
                        rs2 = pst.executeQuery();
                        while (rs2.next()) {
                            String id = rs2.getString("Tec_id");
                            String Pass = rs2.getString("Password");
                            TechOfficer.TecId = id;
                            TechOfficer.Password = Pass;
                        }
                        if ((Objects.equals(userIDt, TechOfficer.TecId)) && Objects.equals(pwd, TechOfficer.Password)){
                            JOptionPane.showMessageDialog(null, "Welcome "+access);
                            Tec_Offc tec_Offc = new Tec_Offc("Tec log");
                            tec_Offc.setVisible(true);
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Dear Technical Officer, UserId and Password you entered wrong " );
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,e);
                    }
                    finally {
                        try {
                            rs2.close();
                            pst.close();
                        } catch (Exception e) {
                            //JOptionPane.showMessageDialog(null,e);
                        }
                    }
                }
                if (access == "Lecturer") {
                    userID = txtUserID.getText();
                    String sqlLecturer = "SELECT Lec_id,Password FROM lecturer where Lec_id ="+userID;

                    try {

                        pst = conn.prepareStatement(sqlLecturer);
                        rs3 = pst.executeQuery(sqlLecturer);
                        while (rs3.next()) {
                            String id = rs3.getString("Lec_id");
                            String Pass = rs3.getString("Password");
                            LecturerM.LecId = id;
                            LecturerM.Password = Pass;
                        }
                        if (Objects.equals(userID, LecturerM.LecId) && Objects.equals(pwd, LecturerM.Password))
                        {
                            JOptionPane.showMessageDialog(null, "Welcome "+access);
                            Lecturer lecture = new Lecturer("PanelLecturer");
                            lecture.setVisible(true);
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Dear Lecturer, UserId and Password you entered wrong " );
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,"fill the fields");
                    }
                    finally {
                        try {
                            rs3.close();
                            pst.close();
                        } catch (Exception e) {
                            //JOptionPane.showMessageDialog(null,e);
                        }
                    }
                }
            }});

        CLEARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtUserID.setText("");
                txtPwd.setText("");
            }
        });
        donTHaveAnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String access = (comboPostion.getSelectedItem().toString());
                userID = txtUserID.getText();

                pwd = txtPwd.getText();
                String sql = "SELECT * FROM admin WHERE Ad_id="+userID;
                try {
                    if (access == "Admin") {

                        try {
                            int count = 0;
                            pst = conn.prepareStatement(sql);

                            //pst.setString(1,txtUserID.getText());
                            // pst.setString(2,txtPwd.getText());
                            //pst.setString(1,comboPostion.getSelectedItem().toString());

                            rs = pst.executeQuery(sql);
                            while (rs.next()) {
                                String id = rs.getString("Ad_id");
                                String Pass = rs.getString("Password");
                                AdminM.Ad_id = id;
                                AdminM.Password =Pass;
                                count = count + 1;

                            }
                            //String sql = "SELECT Ad_id,Password FROM admin where (Ad_id = ? and Password=?)"
                            if (Objects.equals( userID, AdminM.Ad_id) && Objects.equals(pwd, AdminM.Password)) {
                                JOptionPane.showMessageDialog(null, "Welcome "+access);
                                AdminForm ad = new AdminForm("LoginForm");
                                ad.setVisible(true);
                                dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "Dear Admin, UserId and Password you entered wrong");
                            }


                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "fill the fields");
                        } finally {
                            try {
                                rs.close();
                                pst.close();
                            } catch (Exception e) {

                            }
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Admin can only register users");
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        });
    }
    public void currentDate(){
        Calendar cal=new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        curDate.setText((month+1)+"/"+day+"/"+year);

    }
    public void frame__windowStateChanged(WindowEvent e){
        // minimized
        LoginPage loginPage = new LoginPage("Login page");
        if ((e.getNewState() & loginPage.ICONIFIED) == loginPage.ICONIFIED){
            winChecked=1;
        }
        // maximized
        else if ((e.getNewState() & loginPage.MAXIMIZED_BOTH) == loginPage.MAXIMIZED_BOTH){
            winChecked=0;
        }
    }
    public static void main(String[] args) {
        LoginPage lp= new LoginPage("LoginForm");
        //Admin ad = new Admin("Admin");
    }
}
