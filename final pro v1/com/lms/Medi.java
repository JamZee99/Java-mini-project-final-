package com.lms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;


public class Medi extends JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    private JPanel tecMainPane;
    private JButton contactButton;
    private JButton courseDetailsButton;
    private JButton gradesAndGPAButton;
    private JPanel jMain;
    private JPanel contactDtl;
    private JPanel medDtls;
    private JPanel profileEdit;
    private JPanel courseDtls;
    private JPanel time;
    private JPanel Notice;
    private JButton logoutButton;
    private JLabel uNametxt;
    private JButton timetablesButton;
    private JButton noticesButton;
    private JButton manageAttBut;
    private JButton profileButton;
    private JButton mediButt;
    private JTextField textFname;
    private JTextField textLname;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JTextField textDOB;
    private JTextField textPno;
    private JTextField textEmail;
    private JLabel txtFname;
    private JLabel txtLname;
    private JPanel mangeAtt;
    private JTextField textstdID;
    private JTextField textDate;
    private JTextField textLevel;
    private JTextField textCode;
    private JTextField textType;
    private JTextField textStdID;
    private JButton searchButton;
    private JTable tableAtt;
    private JComboBox comboBox1;
    private JTextField searchDate;
    private JTextField searchCode;
    private JButton DELETEButton;
    private JButton ADDButton;
    private JButton MODIFYButton;
    private JTextField searchAtt;

    public int countPresent=0;
    public String gender;
    public String StdID;

    public String Status;
    public Medi(String title) {
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(tecMainPane);
        this.pack();
        setVisible(true);
        conn = LMSdb.java_db();
        attTable();


        int countAbsent = 0;
        double attPercentage = 1;
        try {
            pst = conn.prepareStatement("select * from attendance");
            rs = pst.executeQuery();
            int index = 100;
            while (Student.studentCount > 0) {
                pst = conn.prepareStatement("select * from attendance");
                rs = pst.executeQuery();
                countPresent = 0;
                while (rs.next()) {
                    //pst.setString(1,txt_search.getText());
                    String add1 = rs.getString("Status");
                    String add2 = rs.getNString("Std_id");
                    if (Objects.equals(add2, String.valueOf(index))) {
                        if (Objects.equals(add1, "Present")) {
                            countPresent++;


                        }

                    }
                    ;
                    double dPresent = countPresent;
                    countAbsent = 15 - countPresent;
                    attPercentage = (dPresent / 15) * 100;
                }
                manageAttBut.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jMain.removeAll();
                        jMain.repaint();
                        jMain.revalidate();

                        jMain.add(mangeAtt);
                        //j3.removeAll();
                        jMain.repaint();
                        jMain.revalidate();
                        noticesButton.setBackground(new Color(174, 196, 255));
                        timetablesButton.setBackground(new Color(174, 196, 255));
                        profileButton.setBackground(new Color(174, 196, 255));
                        manageAttBut.setBackground(new Color(25, 118, 250));
                        mediButt.setBackground(new Color(174, 196, 255));

                        noticesButton.setForeground(Color.black);
                        timetablesButton.setForeground(Color.black);
                        profileButton.setForeground(Color.black);
                        manageAttBut.setForeground(Color.white);
                        mediButt.setForeground(Color.black);
                    }
                });
                profileButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jMain.removeAll();
                        jMain.repaint();
                        jMain.revalidate();

                        jMain.add(profileEdit);
                        //j3.removeAll();
                        jMain.repaint();
                        jMain.revalidate();
                        noticesButton.setBackground(new Color(174, 196, 255));
                        timetablesButton.setBackground(new Color(174, 196, 255));
                        profileButton.setBackground(new Color(25, 118, 250));
                        manageAttBut.setBackground(new Color(174, 196, 255));
                        mediButt.setBackground(new Color(174, 196, 255));

                        noticesButton.setForeground(Color.black);
                        timetablesButton.setForeground(Color.black);
                        profileButton.setForeground(Color.white);
                        manageAttBut.setForeground(Color.black);
                        mediButt.setForeground(Color.black);
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
                        noticesButton.setBackground(new Color(174, 196, 255));
                        timetablesButton.setBackground(new Color(25, 118, 250));
                        profileButton.setBackground(new Color(174, 196, 255));
                        manageAttBut.setBackground(new Color(174, 196, 255));
                        mediButt.setBackground(new Color(174, 196, 255));

                        noticesButton.setForeground(Color.black);
                        timetablesButton.setForeground(Color.white);
                        profileButton.setForeground(Color.black);
                        manageAttBut.setForeground(Color.black);
                        mediButt.setForeground(Color.black);
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
                        noticesButton.setBackground(new Color(25, 118, 250));
                        timetablesButton.setBackground(new Color(174, 196, 255));
                        profileButton.setBackground(new Color(174, 196, 255));
                        manageAttBut.setBackground(new Color(174, 196, 255));
                        mediButt.setBackground(new Color(174, 196, 255));

                        noticesButton.setForeground(Color.white);
                        timetablesButton.setForeground(Color.black);
                        profileButton.setForeground(Color.black);
                        manageAttBut.setForeground(Color.black);
                        mediButt.setForeground(Color.black);
                    }
                });


                mediButt.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jMain.removeAll();
                        jMain.repaint();
                        jMain.revalidate();

                        jMain.add(courseDtls);
                        //j3.removeAll();
                        jMain.repaint();
                        jMain.revalidate();
                        noticesButton.setBackground(new Color(174, 196, 255));
                        timetablesButton.setBackground(new Color(174, 196, 255));
                        profileButton.setBackground(new Color(174, 196, 255));
                        manageAttBut.setBackground(new Color(174, 196, 255));
                        mediButt.setBackground(new Color(25, 118, 250));

                        noticesButton.setForeground(Color.black);
                        timetablesButton.setForeground(Color.black);
                        profileButton.setForeground(Color.black);
                        manageAttBut.setForeground(Color.black);
                        mediButt.setForeground(Color.white);
                    }
                });
                //rs.beforeFirst();
                try {
                    //pst = conn.prepareStatement("INSERT INTO att_summ(att_summ) VALUES (?) WHERE Std_id=?");
                    pst = conn.prepareStatement("UPDATE att_summ SET Present_days=?, Absent_days=?, Att_percentage=? WHERE Std_id=?");
                    pst.setString(1, String.valueOf(countPresent));
                    pst.setString(3, String.valueOf(attPercentage));
                    pst.setString(2, String.valueOf(countAbsent));
                    pst.setString(4, String.valueOf(index));
                    pst.executeUpdate();
                    //JOptionPane.showMessageDialog(null,index);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                index++;
                Student.studentCount--;
            }
            JOptionPane.showMessageDialog(null, countPresent);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        try {

        } catch (Exception e) {

        } finally {

            try {

                rs.close();
                pst.close();

            } catch (Exception e) {

            }
        }
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
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String sAttID = searchAtt.getText();
                String sID = textstdID.getText();
                String sDate = textDate.getText();
                String sCode = textCode.getText();
                Status = Objects.requireNonNull(comboBox1.getSelectedItem()).toString();
                if (!(sAttID.equals(""))) {
                    try {
                        pst = conn.prepareStatement("SELECT * FROM attendance WHERE Att_id=?");
                        pst.setString(1, searchAtt.getText());
                        rs = pst.executeQuery();

                        while (rs.next()) {
                            String add1 = rs.getString("Std_id");
                            textstdID.setText(add1);
                            String add2 = rs.getString("Dates");
                            textDate.setText(add2);
                            String add3 = rs.getString("Level");
                            textLevel.setText(add3);
                            String add4 = rs.getString("Status");

                            if (Objects.equals(add4, "Present")) {
                                //comboBox1.setEnabled(true);
                                comboBox1.setSelectedIndex(1);
                            } else if (Objects.equals(add4, "Absent")) {
                                //comboBox1.setEnabled(true);
                                comboBox1.setSelectedIndex(2);
                            } else {
                                // comboBox1.setEnabled(true);
                                comboBox1.setSelectedIndex(3);
                            }


                            String add5 = rs.getString("Course_type");
                            textType.setText(add5);
                            String add6 = rs.getString("Course_code");
                            textCode.setText(add6);

                            textStdID.setText(add1);
                            searchDate.setText(add2);
                            searchCode.setText(add6);
                            JOptionPane.showMessageDialog(null, "Founded");
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
                } else if (!(sID.equals("") || sCode.equals("") || sDate.equals(""))) {
                    try {
                        pst = conn.prepareStatement("SELECT * FROM attendance WHERE Std_id=? AND Course_code=? AND dates =?");
                        pst.setString(1, textStdID.getText());
                        pst.setString(2, searchCode.getText());
                        pst.setString(3, searchDate.getText());
                        rs = pst.executeQuery();

                        while (rs.next()) {
                            String add1 = rs.getString("Std_id");
                            textstdID.setText(add1);
                            String add2 = rs.getString("Dates");
                            textDate.setText(add2);
                            String add3 = rs.getString("Level");
                            textLevel.setText(add3);
                            String add4 = rs.getString("Status");

                            if (Objects.equals(add4, "Present")) {
                                //comboBox1.setEnabled(true);
                                comboBox1.setSelectedIndex(1);
                            } else if (Objects.equals(add4, "Absent")) {
                                //comboBox1.setEnabled(true);
                                comboBox1.setSelectedIndex(2);
                            } else {
                                // comboBox1.setEnabled(true);
                                comboBox1.setSelectedIndex(3);
                            }


                            String add5 = rs.getString("Course_type");
                            textType.setText(add5);
                            String add6 = rs.getString("Course_code");
                            textCode.setText(add6);
                            String add7 = rs.getString("Att_id");
                            searchAtt.setText(add7);
                            JOptionPane.showMessageDialog(null, "Founded");
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

                } else {
                    JOptionPane.showMessageDialog(null, "Please fill the Attendance ID or All other fields");
                }
            }
        });

        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String aID = textstdID.getText();
                String aDate = textDate.getText();
                String aCode = textCode.getText();
                String aLevel = textLevel.getText();
                String aType = textType.getText();
                Status = Objects.requireNonNull(comboBox1.getSelectedItem()).toString();
                if (!(aID.equals("") || aCode.equals("") || aDate.equals("") || aLevel.equals("") || aType.equals("") || Status.equals(""))) {
                    try {
                        pst = conn.prepareStatement("INSERT INTO attendance(Std_id,Dates,Level,Course_code,Course_type,Status) VALUES(?,?,?,?,?,?)");
                        pst.setString(1, aID);
                        pst.setString(2, aDate);
                        pst.setString(3, aLevel);
                        pst.setString(4, aCode);
                        pst.setString(5, aType);
                        pst.setString(6, Status);
                        pst.executeUpdate();
                        attTable();
                        JOptionPane.showMessageDialog(null, "Successfully inserted");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                }
            }
        });

        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String aAtt_ID = searchAtt.getText();
                String aID = textstdID.getText();
                String aDate = textDate.getText();
                String aCode = textCode.getText();
                String aLevel = textLevel.getText();
                String aType = textType.getText();
                Status = Objects.requireNonNull(comboBox1.getSelectedItem()).toString();
                if (!(aID.equals("") || aCode.equals("") || aDate.equals("") || aLevel.equals("") || aType.equals("") || Status.equals(""))) {
                    try {
                        pst = conn.prepareStatement("DELETE FROM attendance WHERE Std_id=? AND Dates=? AND Level=? AND Course_code=? AND Course_type=? AND Status=? AND Att_id=?");
                        pst.setString(1, aID);
                        pst.setString(2, aDate);
                        pst.setString(3, aLevel);
                        pst.setString(4, aCode);
                        pst.setString(5, aType);
                        pst.setString(6, Status);
                        pst.setString(7,aAtt_ID);
                        pst.executeUpdate();
                        attTable();
                        textstdID.setText("");
                        textDate.setText("");
                        textCode.setText("");
                        textLevel.setText("");
                        textType.setText("");
                        comboBox1.setSelectedIndex(0);
                        JOptionPane.showMessageDialog(null, "Successfully Deleted ");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                }
            }

        });

        MODIFYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String Att_ID = searchAtt.getText();
                String aID = textstdID.getText();
                String aDate = textDate.getText();
                String aCode = textCode.getText();
                String aLevel = textLevel.getText();
                String aType = textType.getText();
                Status = Objects.requireNonNull(comboBox1.getSelectedItem()).toString();
                if (!(aID.equals("") || aCode.equals("") || aDate.equals("") || aLevel.equals("") || aType.equals("") || Status.equals(""))) {
                    try {
                        pst = conn.prepareStatement("UPDATE attendance SET Std_id=?, Dates=?, Level=?, Course_code=?, Course_type=?, Status=? WHERE Att_id=" + Att_ID);
                        pst.setString(1, aID);
                        pst.setString(2, aDate);
                        pst.setString(3, aLevel);
                        pst.setString(4, aCode);
                        pst.setString(5, aType);
                        pst.setString(6, Status);
                        pst.executeUpdate();
                        attTable();
                        JOptionPane.showMessageDialog(null, "Successfully Modified ");

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                }
            }
        });
    }
    void attTable(){
        try {
            pst = conn.prepareStatement("SELECT * FROM attendance");
            ResultSet rs = pst.executeQuery();
            tableAtt.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Medi tecOff=new Medi("Tec_off");
    }


}
