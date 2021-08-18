package org.xxharutoxx.views.mainWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Welcome extends JFrame{
    private JPanel panelWelcome;
    private JLabel lblClockTime;
    private JLabel lblDate;
    private JPanel panelLeftWelcome;
    private final String title="Bienvenida";
    ImageBackground backgroundImg=new ImageBackground("/com/xxharutoxx/icons/fondo.jpg");

    public Welcome(){
        currentTime();
//        panelLeftWelcome.add(backgroundImg);
    }

    public JPanel getPanelWelcome(){
        return panelWelcome;
    }

    public String getTitle() {
        return title;
    }
    public void currentTime(){
        Calendar calendar=new GregorianCalendar();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        Thread clock=new Thread(){
            public void run(){
                for(;;){
                    Calendar calendar=new GregorianCalendar();
                    int second=calendar.get(Calendar.SECOND);
                    int minute=calendar.get(Calendar.MINUTE);
                    int hour=calendar.get(Calendar.HOUR_OF_DAY);
                    lblClockTime.setText(String.format("%02d",hour)+" : "+String.format("%02d",minute)+" : "+String.format("%02d",second));

                    try {
                        sleep(1000);
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            }
        };
        lblDate.setText(String.format("%02d",day)+" / "+String.format("%02d",(month+1))+" / "+year);
        clock.start();
    }
    class ImageBackground extends JPanel{
        ImageIcon img;
        String name;
        public ImageBackground(String name){
            this.name=name;
        }
        public void paint(Graphics g){
            Dimension size=getSize();
            img=new ImageIcon(getClass().getResource(name));
            g.drawImage(img.getImage(),0,0,size.width,size.height,null);
            setOpaque(false);
            super.paint(g);
        }
    }
}
