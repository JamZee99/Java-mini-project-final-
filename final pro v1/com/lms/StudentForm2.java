package com.lms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class StudentForm2 extends JFrame {
    private JPanel MainPane;
    private JButton contactButton;
    private JButton courseDetailsButton;
    private JButton gradesAndGPAButton;
    private JButton timetablesButton;
    private JButton noticesButton;
    private JButton mediButton;
    private JButton profileButton;
    private JPanel jMain;
    private JPanel contactDtl;
    private JPanel profilePic;
    private JButton chooseButton;
    private JButton saveButton;
    private JPanel j3;
    ResultSet rs1 = null;
    private JPanel courseDtls;
    private JPanel grades;
    private JPanel time;
    private JPanel Notice;
    private JButton logoutButton;
    private JTextField txtFname;
    private JTextField txtLname;
    private JTextField txtDOB;
    private JTextField txtEmail;
    private JTextField txtGender;
    private JTextField txtAddress;
    private JTextField txtPno;
    private JButton CLEARButton;
    private JButton CHANGEButton;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JLabel imgIco;
    private JLabel uNametxt;
    private JLabel img;
    private JLabel preFname;
    private JLabel preLname;
    private JLabel preDOB;
    private JLabel prePno;
    private JLabel preEmail;
    private JLabel preGender;
    private JLabel preAddress;
    private JTable medTable;
    private JPanel medDtls;
    private JScrollPane table1;
    private JTable tableCourse;
    private JTable tableGrades;
    private JTable tableTime;
    private JTable tableNotice;
    private JPanel image;
    private JButton clearButton;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    private ImageIcon format = null;
    String filename = null;
    byte[] person_image = null;
    private String gender;
    public String Department;




    int imgT = 0;

    public StudentForm2(String title) {
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(MainPane);
        this.pack();
        setVisible(true);
        conn = LMSdb.java_db();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        
        table_loadMEd();
        table_loadCourse();
        table_loadGrades();
        table_loadNotice();
        //LoginPage loginPage = new LoginPage("Login page");


        contactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jMain.removeAll();
                jMain.repaint();
                jMain.revalidate();

                jMain.add(contactDtl);
                //j3.removeAll();
                jMain.repaint();
                jMain.revalidate();
                courseDetailsButton.setBackground(Color.white);
                gradesAndGPAButton.setBackground(Color.white);
                noticesButton.setBackground(Color.white);
                timetablesButton.setBackground(Color.white);
                profileButton.setBackground(Color.white);
                mediButton.setBackground(Color.white);
                contactButton.setBackground(new Color(250, 247, 147));
            }
        });
        mediButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jMain.removeAll();
                jMain.repaint();
                jMain.revalidate();

                jMain.add(medDtls);
                //j3.removeAll();
                jMain.repaint();
                jMain.revalidate();
                courseDetailsButton.setBackground(Color.white);
                gradesAndGPAButton.setBackground(Color.white);
                noticesButton.setBackground(Color.white);
                timetablesButton.setBackground(Color.white);
                profileButton.setBackground(Color.white);
                mediButton.setBackground(new Color(250, 247, 147));
                contactButton.setBackground(Color.white);
            }
        });
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jMain.removeAll();
                jMain.repaint();
                jMain.revalidate();

                jMain.add(profilePic);
                //j3.removeAll();
                jMain.repaint();
                jMain.revalidate();
                courseDetailsButton.setBackground(Color.white);
                gradesAndGPAButton.setBackground(Color.white);
                noticesButton.setBackground(Color.white);
                timetablesButton.setBackground(Color.white);
                profileButton.setBackground(new Color(250, 247, 147));
                mediButton.setBackground(Color.white);
                contactButton.setBackground(Color.white);
            }
        });
        timetablesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jMain.removeAll();
                jMain.repaint();
                jMain.revalidate();

                jMain.add(time);
                //j3.removeAll();
                jMain.repaint();
                jMain.revalidate();
                courseDetailsButton.setBackground(Color.white);
                gradesAndGPAButton.setBackground(Color.white);
                noticesButton.setBackground(Color.white);
                timetablesButton.setBackground(new Color(250, 247, 147));
                profileButton.setBackground(Color.white);
                mediButton.setBackground(Color.white);
                contactButton.setBackground(Color.white);
            }
        });
        noticesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jMain.removeAll();
                jMain.repaint();
                jMain.revalidate();

                jMain.add(Notice);
                //j3.removeAll();
                jMain.repaint();
                jMain.revalidate();
                courseDetailsButton.setBackground(Color.white);
                gradesAndGPAButton.setBackground(Color.white);
                noticesButton.setBackground(new Color(250, 247, 147));
                timetablesButton.setBackground(Color.white);
                profileButton.setBackground(Color.white);
                mediButton.setBackground(Color.white);
                contactButton.setBackground(Color.white);
            }
        });


        gradesAndGPAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jMain.removeAll();
                jMain.repaint();
                jMain.revalidate();

                jMain.add(grades);
                //j3.removeAll();
                jMain.repaint();
                jMain.revalidate();
                courseDetailsButton.setBackground(Color.white);
                gradesAndGPAButton.setBackground(new Color(250, 247, 147));
                noticesButton.setBackground(Color.white);
                timetablesButton.setBackground(Color.white);
                profileButton.setBackground(Color.white);
                mediButton.setBackground(Color.white);
                contactButton.setBackground(Color.white);
            }
        });
        courseDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jMain.removeAll();
                jMain.repaint();
                jMain.revalidate();

                jMain.add(courseDtls);
                //j3.removeAll();
                jMain.repaint();
                jMain.revalidate();
                //courseDetailsButton.setSelected(true);
                courseDetailsButton.setBackground(new Color(250, 247, 147));
                gradesAndGPAButton.setBackground(Color.white);
                noticesButton.setBackground(Color.white);
                timetablesButton.setBackground(Color.white);
                profileButton.setBackground(Color.white);
                mediButton.setBackground(Color.white);
                contactButton.setBackground(Color.white);
            }
        });
        try {
            //String sql = "select * from student where Std_id= " + Student.Std_id;
            pst = conn.prepareStatement("select * from student where Std_id= " + Student.Std_id);
            rs = pst.executeQuery();
            while (rs.next()) {
                //pst.setString(1,txt_search.getText());
                String add1 = rs.getString("Fname");
                txtFname.setText(add1);
                Student.Fname = add1;

                Department = rs.getString("Department");

                String add2 = rs.getString("Lname");
                txtLname.setText(add2);
                uNametxt.setText(Student.Fname + " " + add2);

                String add3 = rs.getString("DOB");
                txtDOB.setText(add3);

                String add4 = rs.getString("Email");
                txtEmail.setText(add4);

                String add5 = rs.getString("Pno");
                txtPno.setText(add5);

                String add6 = rs.getString("Address");
                txtAddress.setText(add6);

                String add7 = rs.getString("Sex");
                if (!Objects.equals(add7, "F")) {
                    gender = "M";
                    maleRadioButton.setSelected(true);
                    femaleRadioButton.setSelected(false);


                } else {
                    gender = "F";
                    femaleRadioButton.setSelected(true);
                    maleRadioButton.setSelected(false);

                }
                //preGender.setText(gender);

                byte[] image = rs.getBytes("Image");
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(imgIco.getWidth(), imgIco.getHeight(), Image.SCALE_SMOOTH));
                imgIco.setIcon(imageIcon);
                person_image = image;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {

            try {

                rs.close();
                pst.close();

            } catch (Exception e) {

            }
        }

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPage loginPage = new LoginPage("Login page");
                dispose();
            }
        });

        CHANGEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                   /* conn = LMSdb.java_db();
                    Statement stmt = conn.createStatement();
                    String sqlGet = "SELECT Std_id,Fname,Lname,Sex,Pno,Email,DOB,Address FROM student WHERE Std_id ="+Admin.Ad_id;
                    pst = conn.prepareStatement(sqlGet);
                    rs = pst.executeQuery(sqlGet);
                    while (rs.next()) {
                        Student.Std_id=rs.getString("Std_id");
                        Student.Fname=rs.getString("Fname");
                        Student.Lname=rs.getString("Lname");
                        Student.Sex=rs.getString("Sex");
                        Student.Pno=rs.getString("Pno");
                        Student.DOB=rs.getString("DOB");
                        Student.Email=rs.getString("Email");
                        Student.Address=rs.getString("Address");
                    }
                    txtFname.setText(Student.Fname);
                    txtLname.setText(Student.Lname);
                    //txtDOB.setText();
                    txtPno.setText(Student.Pno);
                    txtEmail.setText(Student.Email);
                    //pst.setString(3,txtGender.getText());
                    txtAddress.setText(Student.Address);
                    //pst.setString(4,gender);*/
                    /*String FName = txtFname.getText();
                    String LName = txtLname.getText();
                    String EMail = txtEmail.getText();
                    String PNum = txtPno.getText();
                    String Dates = txtDOB.getText();
                    String Address = txtAddress.getText();
                    maleRadioButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            gender = "Male";
                            maleRadioButton.setSelected(true);
                            femaleRadioButton.setSelected(false);
                        }
                    });
                    femaleRadioButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            gender = "Female";
                            femaleRadioButton.setSelected(true);
                            maleRadioButton.setSelected(false);
                        }
                    });*/
                    String FName = txtFname.getText();
                    String LName = txtLname.getText();
                    String EMail = txtEmail.getText();
                    String PNum = txtPno.getText();
                    String Dates = txtDOB.getText();
                    String Address = txtAddress.getText();
                    // String sql1 = "UPDATE student SET Fname = ?, Lname=?, Sex= ?, Pno= ?, Email= ?, Address= ? WHERE Std_id= '740'";
                    pst = conn.prepareStatement("UPDATE student SET Fname = ?, Lname=?, Sex= ?, Pno= ?, Email= ?, Address= ?,DOB = ? WHERE Std_id=" + Student.Std_id);
                    pst.setString(1, FName);
                    pst.setString(2, LName);
                    pst.setString(3, gender);
                    pst.setString(4, PNum);
                    pst.setString(5, EMail);
                    pst.setDate(7, Date.valueOf(Dates));
                    pst.setString(6, Address);
                    //pst.setBytes(8,person_image);
                    //pst.setBytes(9,person_image);


                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data is saved successfully");

                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, e);
                } finally {
                    try {
                        rs.close();
                        pst.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }

                }
            }
        });


        CLEARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtFname.setText("");
                txtLname.setText("");
                txtDOB.setText("");
                txtPno.setText("");
                txtEmail.setText("");
                txtGender.setText("");
                txtAddress.setText("");
            }
        });
        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);
                File f = chooser.getSelectedFile();
                filename = f.getAbsolutePath();
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(imgIco.getWidth(), imgIco.getHeight(), Image.SCALE_DEFAULT));
                imgIco.setIcon(imageIcon);

                /*try{
                    imgT = 1;
                    File file = new File(filename);
                    FileInputStream fis = new FileInputStream(file);
                    byte[] imageData = new byte[(int) file.length()];
                    fis.read(imageData);
                    person_image = imageData;

                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }*/

                try {
                    imgT = 1;
                    File image = new File(filename);
                    FileInputStream fix = new FileInputStream(image);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    byte[] buf = new byte[1024];

                    for (int number; (number = fix.read(buf)) != -1; ) {
                        bos.write(buf, 0, number);
                    }
                    person_image = bos.toByteArray();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (imgT == 1) {
                    try {
                        //String sqlInsertProfile = "UPDATE student SET image= ? WHERE Std_id="+Student.Std_id;
                        PreparedStatement pst = conn.prepareStatement("UPDATE student SET image= ? WHERE Std_id=" + Student.Std_id);
                        pst.setBytes(1, person_image);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Successfully Inserted");

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please insert image first");
                }
            }
        });
        maleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gender = "M";
                maleRadioButton.setSelected(true);
                femaleRadioButton.setSelected(false);
            }
        });
        femaleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gender = "F";
                femaleRadioButton.setSelected(true);
                maleRadioButton.setSelected(false);
            }
        });
        table_loadTime();


    }

    void table_loadMEd() {
        try {
            pst = conn.prepareStatement("SELECT * FROM medical");
            ResultSet rs = pst.executeQuery();
            medTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void table_loadCourse() {
        try {
            pst = conn.prepareStatement("SELECT * FROM course");
            ResultSet rs = pst.executeQuery();
            tableCourse.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void table_loadGrades() {
        try {
            pst = conn.prepareStatement("SELECT * FROM marks");
            ResultSet rs = pst.executeQuery();
            tableGrades.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void table_loadTime() {

        try {
            pst = conn.prepareStatement("SELECT * FROM " + Department);
            ResultSet rs = pst.executeQuery();
            tableTime.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Department);
            e.printStackTrace();
        }
    }

    void table_loadNotice() {
        try {
            pst = conn.prepareStatement("SELECT * FROM notice");
            ResultSet rs = pst.executeQuery();
            tableNotice.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    //public static void main(String[] args) {
        //JFrame jFrame = new JFrame();

    //}

}