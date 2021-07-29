/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author alfinadewi
 */
public class loading extends JWindow {
    
    private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    private JLabel labelLogo = new JLabel(new ImageIcon("bunda.jpg"));
    private JProgressBar barisProgress = new JProgressBar();
    private int time = 0;
    private Timer timer;
    
    public loading() {
        Color warna = Color.blue;
        barisProgress.setValue(0);
        barisProgress.setPreferredSize(new Dimension(100, 15));
        barisProgress.setBackground(Color.white);
        barisProgress.setForeground(Color.blue);
        barisProgress.setStringPainted(true);
        barisProgress.setBorder(new LineBorder(warna, 2));
        labelLogo.setBorder(new LineBorder(Color.blue, 2));
        
        //letakkan objek ke container
        getContentPane().add(labelLogo, BorderLayout.NORTH);
        getContentPane().add(barisProgress, BorderLayout.CENTER);
        
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time++;
                barisProgress.setValue(time);
                if (barisProgress.getPercentComplete() == 1.0) {
                    timer.stop();
                    new formLogin().setVisible(true);
                    dispose();
                }
            }
        });
        
        timer.start();
        //menempatkan objek ke memori sebelum ditampilkan
        pack();
        //atur window di tengah layar
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new loading();
    }
}
