package com.dev.Model;

import com.dev.Helper.DBConnector;
import com.dev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String uname;
    private String pass;
    private String type;

    public User() {

    }

    public User(int id, String name, String uname, String pass, String type) {
        this.id = id;
        this.name = name;
        this.uname = uname;
        this.pass = pass;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ArrayList<User> getList() { // app içinde kullanıcıları listelemek için ArrayList oluşturduk
        ArrayList<User> userList = new ArrayList<>();
        String qeuery = "SELECT * FROM user"; // sql sorgusunu çağırdık
        User obj;
        try {
            Statement st = DBConnector.getInstance().createStatement(); // statemen oluşturup DBconnector'dan çağırdık
            ResultSet rs = st.executeQuery(qeuery);
            while (rs.next()) { // rs yi iterator mantığıyla kullandık
                obj = new User(); // hafızada daha az yer kaplaması için user objsini yukarıda yaptık burada rs içinde bilgileri çağırdık
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
                userList.add(obj); // oluşturduğumuz objeyi user list içerisine ekledik
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    public static boolean add(String name, String uname, String pass, String type) { // veritabanına kullanıcı ekleme işlemi methodu
        String query = "INSERT INTO user(name,uname,pass,type) VALUES (?,?,?,?)";

        User findUser = User.getFetch(uname);// aşağıdaki getFetch burada aynı kullanıcı ismine sahip biri var mı onu sorgulama yaparak bakabiliriz
        if (findUser != null) {
            Helper.showMsg("This User Name already exist"); // verilecek hata mesajını Helper sınıfından değil kendimiz verdik
            return false;
        }

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query); // geriye connection döndürür.
            pr.setString(1, name);
            pr.setString(2, uname);
            pr.setString(3, pass);
            pr.setString(4, type);

            int response = pr.executeUpdate();
            if (response == -1) { // getFetchteki aynı kullanıcı adı işlemini burada da kontrol etmek için sorgu yaptık
                // eğer response = -1 ise hata mesajı gönder.
                Helper.showMsg("Error");
            }
            return response != -1; // response = -1 değilse devam et
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static User getFetch(String uname) { // aynı kullanıcı adından başkası olmaması için oluşturulan method
        User obj = null;
        String query = "SELECT * FROM user WHERE uname = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, uname);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }

    public static User getFetch(String uname, String pass) { // login formunda kullanıcı girişi için oluşturuldu
        User obj = null;
        String query = "SELECT * FROM user WHERE uname = ? AND pass = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, uname);
            pr.setString(2, pass);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                switch (rs.getString("type")) {
                    case "operator":
                        obj = new Operator();
                        break;
                    default:
                        obj = new User();
                }

                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }

    public static User getFetch(int id) { // yukarıdaki getFetchten lesson sınıfında user_id ye göre yeni bir tane daha oluşturuyoruz
        User obj = null;
        String query = "SELECT * FROM user WHERE id = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }

    public static boolean delete(int id) { // users delete işlemi methodu
        String query = "DELETE FROM user WHERE id = ?";
        ArrayList<Lesson> lessonList = Lesson.getListByUser(id);
        for (Lesson l : lessonList) {
            Lesson.delete(l.getId());
        }

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    public static boolean update(int id, String name, String uname, String pass, String type) { // tbl_user_list.getModel().addTableModelListener(e -> { işleminin update methodu
        String query = "UPDATE user SET name=?,uname=?,pass=?,type=? WHERE id = ?";
        // burada yukarıdaki findUser methodunu alıyoruz. Çünkü kullanıcı adı uniq olmalıdır. Kullanıcı ismi değiştirilmek istenirse aynı kullanıcı adı alınamaz
        User findUser = User.getFetch(uname);
        if (findUser != null && findUser.getId() != id) {
            Helper.showMsg("This User Name already exist");
            return false;
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, name);
            pr.setString(2, uname);
            pr.setString(3, pass);
            pr.setString(4, type);
            pr.setInt(5, id);
            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    public static ArrayList<User> searchUserList(String query) { // form sayfasında search işleminini yapmak için method oluşturuyoruz
        // bu işlem için yukarıdaki get list metodunun aynısı yaptık sadece sorgusunu değiştireceğiz onun içinde aşağıya yeni bir sorgu methodu yazıyoruz
        ArrayList<User> userList = new ArrayList<>();
        User obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
                userList.add(obj); //
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    public static String searchQuery(String name, String uname, String type) {
        // search işlemi yaparken sorguya LIKE koyduk burada uname name ve type aratma işlemi yaptığımızda en yakın isimden aramya başlar
        String query = "SELECT * FROM user WHERE uname LIKE '%{{uname}}%' AND name LIKE '%{{name}}%'";
        query = query.replace("{{uname}}", uname);
        query = query.replace("{{name}}", name);
        if (!type.isEmpty()) {
            query += " AND type ='{{type}}'";
            query = query.replace("{{type}}", type);
        }

        return query;
    }

    public static ArrayList<User> getOnlyEducator() { // bu metodu yukarıdaki get listten kopyladık
        // sadece educator kısmı için search ediyor
        ArrayList<User> userList = new ArrayList<>();
        String qeuery = "SELECT * FROM user WHERE type= 'educator'"; //
        User obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(qeuery);
            while (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
                userList.add(obj);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

}
