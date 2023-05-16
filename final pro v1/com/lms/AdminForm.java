package com.lms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminForm extends JFrame{
    private JPanel adminPane;
    private JPanel header;
    private JButton editUserProfilesButton;
    private JButton editCoursesButton;
    private JButton editNoticeButton;
    private JButton logoutButton;
    private JPanel dynamicDis;
    private JPanel btnPanel;
    private JPanel edUser;
    private JPanel edCourses;
    private JPanel edNotice;
    private JButton editTimetablesButton;
    private JPanel edTime;
    private JLabel uID;

    public AdminForm(String title) {
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(adminPane);
        this.pack();
        setVisible(true);
        AdminM ad = new AdminM();

        uID.setText(String.valueOf(ad.Ad_id).toString());

    editUserProfilesButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dynamicDis.removeAll();
            dynamicDis.repaint();
            dynamicDis.revalidate();

            dynamicDis.add(edUser);
            //j3.removeAll();
            dynamicDis.repaint();
            dynamicDis.revalidate();
        }
    });
        editCoursesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dynamicDis.removeAll();
                dynamicDis.repaint();
                dynamicDis.revalidate();

                dynamicDis.add(edCourses);
                //j3.removeAll();
                dynamicDis.repaint();
                dynamicDis.revalidate();
            }
        });
        editNoticeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dynamicDis.removeAll();
                dynamicDis.repaint();
                dynamicDis.revalidate();

                dynamicDis.add(edNotice);
                //j3.removeAll();
                dynamicDis.repaint();
                dynamicDis.revalidate();
            }
        });
        editTimetablesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dynamicDis.removeAll();
                dynamicDis.repaint();
                dynamicDis.revalidate();

                dynamicDis.add(edTime);
                //j3.removeAll();
                dynamicDis.repaint();
                dynamicDis.revalidate();
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPage lp= new LoginPage("LoginForm");
                dispose();
            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
