package com.oib.project;

import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

class OnlineTest extends JFrame implements ActionListener
{
    JLabel l;
    JLabel l1;
    JRadioButton jb[]=new JRadioButton[6];
    JButton b1,b2,log;
    ButtonGroup bg;
    int count=0,current=0,x=1,y=1,now=0;
    int m[]=new int[10];
    Timer timer = new Timer();
    OnlineTest(String s)
    {
        super(s);
        l=new JLabel();
        l1 = new JLabel();
        add(l);
        add(l1);
        bg=new ButtonGroup();
        for(int i=0;i<5;i++)
        {
            jb[i]=new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1=new JButton("Save and Next");
        b2=new JButton("Save for later");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);add(b2);
        set();
        l.setBounds(30,40,450,20);
        l1.setBounds(20,20,450,20);
        jb[0].setBounds(50,80,100,20);
        jb[1].setBounds(50,110,100,20);
        jb[2].setBounds(50,140,100,20);
        jb[3].setBounds(50,170,100,20);
        b1.setBounds(95,240,140,30);
        b2.setBounds(270,240,150,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 180;
            public void run() {
                l1.setText("Time Remain: " + i);
                i--;
                if (i < 0) {
                    timer.cancel();
                    l1.setText("Time Out!");
                }
            }
        }, 0, 1000);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            if(check())
                count=count+1;
            current++;
            set();
            if(current==9)
            {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if(e.getActionCommand().equals("Save for later"))
        {
            JButton bk=new JButton("Review"+x);
            bk.setBounds(480,20+30*x,100,30);
            add(bk);
            bk.addActionListener(this);
            m[x]=current;
            x++;
            current++;
            set();
            if(current==9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for(int i=0,y=1;i<x;i++,y++)
        {
            if(e.getActionCommand().equals("Review"+y))
            {
                if(check())
                    count=count+1;
                now=current;
                current=m[y];
                set();
                ((JButton)e.getSource()).setEnabled(false);
                current=now;
            }
        }
        if(e.getActionCommand().equals("Result"))
        {
            if(check())
                count=count+1;
            current++;
            JOptionPane.showMessageDialog(this,"Your Score : "+count+"/10");
            System.exit(0);
        }
    }
    void set()
    {
        jb[4].setSelected(true);
        if(current==0)
        {
            l.setText("1) Which of the following language was developed as the first purely object programming language?");
            jb[0].setText("Small Talk");jb[1].setText("C++");jb[2].setText("Kotlin");jb[3].setText("Java");
        }
        if(current==1)
        {
            l.setText("2) Number of primitive data types in java are?");
            jb[0].setText("6");jb[1].setText("7");jb[2].setText("8");jb[3].setText("9");
        }
        if(current==2)
        {
            l.setText("3) Who developed object-oriented programming?");
            jb[0].setText("James Gosling");jb[1].setText("Dennis Ritche");jb[2].setText("Alan Kay");jb[3].setText("Guido van Rossum");
        }
        if(current==3)
        {
            l.setText("4) Expected created by try block is caught in which block.?");
            jb[0].setText("catch");jb[1].setText("throw");jb[2].setText("final");jb[3].setText("thrown");
        }
        if(current==4)
        {
            l.setText("5) Which of the following is not an OOPS concept in java?");
            jb[0].setText("Polymorphism");jb[1].setText("Inheritance");jb[2].setText("Compilation");jb[3].setText("Encapsulation");
        }
        if(current==5)
        {
            l.setText("6) Which of the following is not an OOPS concept?");
            jb[0].setText("Exception");jb[1].setText("Polymorphism");jb[2].setText("Inheritance");jb[3].setText("Abstraction");
        }
        if(current==6)
        {
            l.setText("7) Under which pillar of OOPS do base class and derived class relationships come?");
            jb[0].setText("Polymorphism");jb[1].setText("Inheritance");jb[2].setText("Encaptulation");
            jb[3].setText("Abstraction");
        }
        if(current==7)
        {
            l.setText("8) Which among the following feature is not in the general definition of OOPS?");
            jb[0].setText("Efficient Code");jb[1].setText("Duplicate & Redundant Data");jb[2].setText("Code Reusability");
            jb[3].setText("Modularity");
        }
        if(current==8)
        {
            l.setText("Q9) The class at the top of exception class is....?");
            jb[0].setText("ArithmeticException");jb[1].setText("Throwable");jb[2].setText("Object");jb[3].setText("Console");
        }
        if(current==9)
        {
            l.setText("Q10) A single program of OOPS contains _______ classes?");
            jb[0].setText("Any Number");jb[1].setText("1");jb[2].setText("10");
            jb[3].setText("None");
        }
        l.setBounds(30,40,450,20);
        for(int i=0,j=0;i<=90;i+=30,j++)
            jb[j].setBounds(50,80+i,200,20);
    }
    boolean check()
    {
        if(current==0)
            return(jb[0].isSelected());
        if(current==1)
            return(jb[2].isSelected());
        if(current==2)
            return(jb[2].isSelected());
        if(current==3)
            return(jb[0].isSelected());
        if(current==4)
            return(jb[2].isSelected());
        if(current==5)
            return(jb[0].isSelected());
        if(current==6)
            return(jb[1].isSelected());
        if(current==7)
            return(jb[1].isSelected());
        if(current==8)
            return(jb[1].isSelected());
        if(current==9)
            return(jb[0].isSelected());
        return false;
    }
}
