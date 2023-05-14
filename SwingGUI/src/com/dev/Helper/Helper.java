package com.dev.Helper;

import javax.swing.*;
import java.awt.*;

public class Helper {
    public static void setLayout(){ // yazı fonto için pc de yüklü olan fontları nimbus olarak ayarladık
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            if("Nimbus".equals((info.getName()))){
                try {
                    UIManager.setLookAndFeel((info.getClassName()));
                } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException |
                         InstantiationException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }
    public static int screenCenterPoint(String axis, Dimension size){ // ugyulamanın çalışmasıyla ekranda çıkacak olan yeri method haline getirdik
        int point = 0;
        switch (axis){
            case "x":
                point = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
                break;
            case "y":
                point = (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
                break;
            default:
                point = 0;
        }
        return point;
    }
    public static boolean isFieldEmpty(JTextField field){ // kullanıcı ekleme işleminde fld_name-username-pass gibi bölümler boş ise hata vermesi için yapılan method
        return field.getText().trim().isEmpty();
    }
    public static void showMsg(String str){ // eğer işlem yapılırken boş alanlar varsa hata mesajını method haline getirdik
        //optionPageTR(); ingilizce butonları TR olarak düzeltmek için
        String msg;
        String title;
        switch (str){
            case "fill":
                msg = ("Please fill in all fields");
                title = "Error";
                break;
            case "done":
                msg = "Succesful";
                title = "Result";
                break;
            case"Error":
                msg = "Error";
                title = "Error";
                break;
            default:
                msg = str;
                title = "Error";
        }
        JOptionPane.showMessageDialog(null,msg,title,JOptionPane.INFORMATION_MESSAGE);
    }
    public static boolean confirm(String str){
        String msg;

        switch (str){
            case "sure":
                msg = "Are you sure you want delete?";
                break;
            default:
                msg = str;
        }
        return JOptionPane.showConfirmDialog(null,msg,"You want ?", JOptionPane.YES_NO_OPTION) == 0;
    }

    /*public static void optionPageTR(){ //optionPageTR(); ingilizce butonları TR olarak düzeltmek için
        UIManager.put("OptionPane.okButtonText", "Tamam");
    }*/
}
