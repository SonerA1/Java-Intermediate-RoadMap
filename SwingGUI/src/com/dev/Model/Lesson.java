package com.dev.Model;

import com.dev.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Lesson {
    private int id;
    private int user_id;
    private int lesson_id;
    private String name;
    private String lang;

    private Course course;
    private User educator;

    public Lesson(int id, int user_id, int lesson_id, String name, String lang) {
        this.id = id;
        this.user_id = user_id;
        this.lesson_id = lesson_id;
        this.name = name;
        this.lang = lang;
        this.course = Course.getFetch(lesson_id);
        this.educator = User.getFetch(user_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getEducator() {
        return educator;
    }

    public void setEducator(User educator) {
        this.educator = educator;
    }

    public static ArrayList<Lesson> getList() {
        ArrayList<Lesson> lessonList = new ArrayList<>();
        Lesson obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM lesson");
            while (rs.next()) {
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                int lesson_id = rs.getInt("lesson_id");
                String name = rs.getString("name");
                String lang = rs.getString("lang");
                obj = new Lesson(id, user_id, lesson_id, name, lang);
                lessonList.add(obj);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lessonList;
    }
    public static boolean add(int user_id, int lesson_id, String name, String lang){
        String query = "INSERT INTO lesson (user_id, lesson_id, name, lang) VALUES (?,?,?,?)";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,user_id);
            pr.setInt(2,lesson_id);
            pr.setString(3,name);
            pr.setString(4,lang);
            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
    public static ArrayList<Lesson> getListByUser(int user_id) {
        ArrayList<Lesson> lessonList = new ArrayList<>();
        Lesson obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM lesson WHERE user_id = " + user_id);
            while (rs.next()) {
                int id = rs.getInt("id");
                int userID = rs.getInt("user_id");
                int lesson_id = rs.getInt("lesson_id");
                String name = rs.getString("name");
                String lang = rs.getString("lang");
                obj = new Lesson(id, user_id, lesson_id, name, lang);
                lessonList.add(obj);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lessonList;
    }
    public static boolean delete(int id) { // lesson delete işlemi methodu
        String query = "DELETE FROM lesson WHERE id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);

            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
}
