package com.oib.project;

import javax.swing.*;
import java.lang.Exception;

class OnlineExam
{
    public static void main(String args[])
    {
        try
        {
            Login form = new Login();
            form.setSize(400,150);
            form.setVisible(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
} 
