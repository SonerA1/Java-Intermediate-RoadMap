package com.dev.View;

import com.dev.Helper.Config;
import com.dev.Helper.Helper;
import com.dev.Model.Course;

import javax.swing.*;


public class UpdateCourseGUI extends JFrame { // Course classı için Gui oluşturduk
    private JPanel wrapper;
    private JTextField fld_course_name;
    private JButton btn_update;
    private Course course;

    UpdateCourseGUI(Course course){ // bu form sayfası Course classın Mause listenerın update kısmı için oluşturuldu
        this.course = course;
        add(wrapper);
        setSize(300,150);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        fld_course_name.setText(course.getName());

        btn_update.addActionListener(e -> { // UpdateCourseGuı formu içindeki update butonu için createlistener
            if (Helper.isFieldEmpty(fld_course_name)){
                Helper.showMsg("fill");
            }else{
                if (Course.update(course.getId(), fld_course_name.getText())){
                    Helper.showMsg("done");
                }
                dispose();
            }
        });
    }
}
