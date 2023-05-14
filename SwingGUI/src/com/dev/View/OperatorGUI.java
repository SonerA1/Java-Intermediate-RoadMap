package com.dev.View;

import com.dev.Helper.Config;
import com.dev.Helper.Helper;
import com.dev.Helper.Item;
import com.dev.Model.Course;
import com.dev.Model.Lesson;
import com.dev.Model.Operator;
import com.dev.Model.User;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class OperatorGUI extends JFrame {

    private JPanel wrapper;
    private JTabbedPane tab_operator;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JPanel pnl_user_list;
    private JScrollPane scrl_user_list;
    private JTable tbl_user_list; // Arayüzdeki User içerisindeki tablo görüntüsü. Bu görüntüyü alabilmek için DefaultTableModel mdl_user_list row_user_list privatelarını oluşturdk.
    private JPanel pnl_user_form;
    private JTextField fld_user_name;
    private JTextField fld_user_uname;
    private JTextField fld_user_pass;
    private JComboBox cmb_user_type;
    private JButton btn_user_add;
    private JTextField fld_user_id;
    private JButton btn_user_delete;
    private JTextField fld_sh_user_name;
    private JTextField fld_sh_user_uname;
    private JComboBox cmb_sh_user_type;
    private JButton btn_user_sh;
    private JPanel pnl_course_list;
    private JScrollPane scrl_course_list;
    private JTable tbl_course_list;
    private JPanel pnl_course_add;
    private JTextField fld_course_name;
    private JButton btn_course_add;
    private JPanel pnl_user_top;
    private JPanel pnl_lesson_list;
    private JScrollPane scrl_lesson_list;
    private JTable tbl_lesson_list;
    private JPanel pnl_lesson_add;
    private JTextField fld_lesson_name;
    private JTextField fld_lesson_lang;
    private JComboBox cmb_lesson_course;
    private JComboBox cmb_lesson_user;
    private JButton btn_lesson_add;
    private DefaultTableModel mdl_user_list; // tbl user list için
    private Object[] row_user_list; // tbl user list için
    private final Operator operator; // constractorını aşağıya çağırdık
    private DefaultTableModel mdl_course_list; // course classı için
    private Object[] row_course_list; // course sınıfı için
    private JPopupMenu courseMenu;// course formunda maus ile sağ tıklama işleme yapılması için oluştururlan PopUp menü
    private DefaultTableModel mdl_lesson_list; // lesson clası için
    private Object[] row_lesson_list; // lesson classı için


    public OperatorGUI(Operator operator) {
        this.operator = operator;
        add(wrapper); // ana wrappermızı çağırdık
        setSize(1000, 500); // app'ın boyutunu ayarladık
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));// method olarak ekranda geleceği yeri seçtik
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE); // proje başlığı
        setVisible(true);


        lbl_welcome.setText("Welcome : " + operator.getName()); // giriş yapan kullanıcının adını yazdırmak

        // ****************ModelUserList*********************
        mdl_user_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) { // iscelleditable methodu form dosyasında id kısmı çift tıkladığımızda değiştirilebiliyor
                // değiştirilebilir özelliğini bu method sayesinde kaldırıyoruz
                if (column == 0) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_user_list = {"ID", "Name Surname", "User Name", "Password", "Type"}; // kolon isimlerini atamak için obje türünde array ürettik
        mdl_user_list.setColumnIdentifiers(col_user_list); // bu şekilde yazılınca modelin tablo başlıklarını yukarıdakiler oluyor
        row_user_list = new Object[col_user_list.length];// loadUSerModel içinde kullanabilmek için burada tekrar ürettik
        loadUserModel(); // aşağıda oluşturduğumuz methodu artık burada kullanabiliriz.
        tbl_user_list.setModel(mdl_user_list);
        tbl_user_list.getTableHeader().setReorderingAllowed(false); // tabloların başlıklarını tutup kaydırmayı engeller

        // burada users tablosu üzerinde mause ile tıkladığımız seçtiğimiz yerin Kullanıcı id alanında gözükmesini sağlıyoruz
        tbl_user_list.getSelectionModel().addListSelectionListener(e -> {
            try { // try cat içine aldık çünkü almayınca seçili satırı silince işlem güncellenmiyor
                String selec_user_id = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 0).toString();
                fld_user_id.setText(selec_user_id);
            } catch (Exception exception) {
            }
        });
        // Tablo içindeki verileri çift tıklayarak değiştirebiliyoruz.Ancak veri tabanında güncelleyemiyoruz.Veri tabanında güncellemek için:
        tbl_user_list.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int user_id = Integer.parseInt(tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 0).toString());
                String user_name = (tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 1).toString());
                String user_uname = (tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 2).toString());
                String user_pass = (tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 3).toString());
                String user_type = (tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 4).toString());

                if (User.update(user_id, user_name, user_uname, user_pass, user_type)) {
                    Helper.showMsg("done");
                }

                loadUserModel(); // burada çağırmamızın sebebi işlem gerçekletikten sonra kendini güncellesin
                loadEducatorCombo(); // formda usersa tablolara eklenen öğretmenleri lesson kısmında eklemek için
                loadLessonModel();// users form içinde bir şeyi güncelleyince lesson bölümünde de güncellenmesi için ekledik
            }
        });
        // *************************ModelUserListEnd******************************

        // *****************CourseList***************************
        courseMenu = new JPopupMenu(); // course formunda satır ve kolanlarda sağ tıklayarak güncelleme ve silme işlemlerini ekledik
        JMenuItem updateMenu = new JMenuItem("Update");
        JMenuItem deleteMenu = new JMenuItem("Delete");
        courseMenu.add(updateMenu);
        courseMenu.add(deleteMenu);

        // updatemunü için addActionlisterner dedik // course kısmında sağ tık update dediğimizde updateGUI form açılır ve güncelleme işlemi yapar
        updateMenu.addActionListener(e -> {
            int select_id = Integer.parseInt(tbl_course_list.getValueAt(tbl_course_list.getSelectedRow(), 0).toString());
            // seçilen row'un id'si gerekiyor selectedrow dediğimizde seçili satır ve 0.row veriyor
            UpdateCourseGUI updateGUI = new UpdateCourseGUI(Course.getFetch(select_id));
            updateGUI.addWindowListener(new WindowAdapter() { // burada yeni bir addWindowslistener yarattık windowsclosed seçtik
                // burada update işlemi yapınca sayfa otomatik refresh atıyor
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCourseModel();
                    loadCourseCombo(); // aynı şekilde courses için eklenenleri güncellemesi içi buraya ekledik
                    loadLessonModel(); // aynı şekilde courses ve lessons için eklenenleri güncellemesi içi buraya ekledik

                }
            });
        });

        // aynı işlemi delete menu olarak yapıyoruz
        deleteMenu.addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int select_id = Integer.parseInt(tbl_course_list.getValueAt(tbl_course_list.getSelectedRow(), 0).toString());
                if (Course.delete(select_id)) {
                    Helper.showMsg("done");
                    loadCourseModel();
                    loadCourseCombo();// aynı şekilde courses için eklenenleri güncellemesi içi buraya ekledik
                    loadLessonModel();
                } else {
                    Helper.showMsg("Error");
                }
            }
        });


        mdl_course_list = new DefaultTableModel(); // burada mdl kısmını defaulttable yaptık
        //yeni obje olarak col_course_list ti yarattık. row course da yeni obje olarak col_course eşitledik.
        // app kısmında ıd ve course name kısmını eklkemiş olduk.
        Object[] col_course_list = {"ID", "Course Name"};
        mdl_course_list.setColumnIdentifiers(col_course_list);
        row_course_list = new Object[col_course_list.length];
        loadCourseModel();


        tbl_course_list.setModel(mdl_course_list);// Tabloyu uygulamada tablolar kısmına atamak içi;
        tbl_course_list.setComponentPopupMenu(courseMenu); // yukarıdaki sağ tıklama menüsünü tabloya ekleme işlemi
        tbl_course_list.getTableHeader().setReorderingAllowed(false); // tablonun kaymaması için.
        tbl_course_list.getColumnModel().getColumn(0).setMaxWidth(75); // sıfırıncı kolunun max genişliğini 75 yaptık ( id kolonu);


        tbl_course_list.addMouseListener(new MouseAdapter() { //popUpmenu de sağ tıkladığımızda hangi kolunu seçtiğimizi gösteren method
            // tbl_course_list.addMouseListener(new MouseAdapter() yazdıktan sonra otomatik olarak bize seçenek sunar oradan maousePressed seçiyoruz
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint(); // bölge belirleme
                int selected_row = tbl_course_list.rowAtPoint(point); // belirlediğimiz bölgeyi seçme
                tbl_course_list.setRowSelectionInterval(selected_row, selected_row); // seçtiğimiz bölge şeceneklerin çıkması
            }
        });

        //**************CourseListEnd**************

        //***************LessonList**********************
        mdl_lesson_list = new DefaultTableModel();
        Object[] col_lessonList = {"ID", "Lesson Name", "Program Language", "Lesson", "Instractor"}; // kolonumuzu oluşturduk
        mdl_lesson_list.setColumnIdentifiers(col_lessonList); //colonları attık
        row_lesson_list = new Object[col_lessonList.length]; // genişliği

        loadLessonModel();

        tbl_lesson_list.setModel(mdl_lesson_list); // tabelları oluşturrduk
        tbl_lesson_list.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_lesson_list.getTableHeader().setReorderingAllowed(false);
        loadCourseCombo();
        loadEducatorCombo(); // eklenen eğitmenleri görebilmek için

        //**************LessonEnd*************************


        btn_user_add.addActionListener(e -> { // formnda users kısmında add butonuna create listener dedik.
            // burada ekleme işlemlerini yapıyoruz.
            if (Helper.isFieldEmpty(fld_user_name) || Helper.isFieldEmpty(fld_user_uname) || Helper.isFieldEmpty(fld_user_pass)) {
                // eğer kullanıcı adı kullanıcı ismi ve şifresi boş ise hata mesajı alır ekleme yapmaz
                Helper.showMsg("fill");
            } else { // veri ekleme işlemi
                String name = fld_user_name.getText();
                String uname = fld_user_uname.getText();
                String pass = fld_user_pass.getText();
                String type = cmb_user_type.getSelectedItem().toString();
                if (User.add(name, uname, pass, type)) {
                    Helper.showMsg("done");
                    loadUserModel();
                    loadEducatorCombo(); // formda users kısmında eğitmen eklemek için
                    fld_user_name.setText(null); // işlemler başarılı yani done ise setTextleri null a çekeriz.
                    fld_user_uname.setText(null);
                    fld_user_pass.setText(null);
                }
            }
        });
        btn_user_delete.addActionListener(e -> { // formda users kısmındaki delete butonu actionlistener
            // silme işlemi yapmak için kullanıcı id kısmının dolu olması gerekiyor
            if (Helper.isFieldEmpty(fld_user_id)) {
                Helper.showMsg("fill");
            } else {
                if (Helper.confirm("sure")) {
                    int user_id = Integer.parseInt(fld_user_id.getText());// id yi çevirmek zorundayız
                    if (User.delete(user_id)) {
                        Helper.showMsg("done");
                        // delete işleminden sonra sayfayı refreshlemek için loadUsermodeli burada da çağırıyoruz
                        loadUserModel();
                        loadEducatorCombo();// formda users kısmında eğitmen silmek için
                        loadLessonModel();
                        fld_user_id.setText(null);
                    } else {
                        Helper.showMsg("Error");
                    }
                }
            }
        });

        btn_user_sh.addActionListener(e -> { // form sayfasında search butonu için arama yapma
            String name = fld_sh_user_name.getText();
            String uname = fld_sh_user_uname.getText();
            String type = cmb_sh_user_type.getSelectedItem().toString();
            String query = User.searchQuery(name, uname, type);
            loadUserModel(User.searchUserList(query)); // arraylist olan
        });

        // formdaki quit tuşu için çıkış yap methodu
        btn_logout.addActionListener(e -> {
            dispose();
            LoginGUI login = new LoginGUI(); // dispose dan sonra tekrar giriş yaptığımızda login ekranına atsın diye
        });
        btn_course_add.addActionListener(e -> { // course formu içindeki add butonu actionlistener ve ekleme işlemleri
            if (Helper.isFieldEmpty(fld_course_name)) {
                Helper.showMsg("fill");
            } else {
                if (Course.add(fld_course_name.getText())) {
                    Helper.showMsg("done");
                    loadCourseModel();
                    loadCourseCombo(); // buraya ekledik çünkü form dosyasında courses kısmında ekleme yaptığımızda lesson bölümünde lesson kısmında eklenenler orada da güncellensin
                    fld_course_name.setText(null);
                } else {
                    Helper.showMsg("Error");
                }
            }

        });
        btn_lesson_add.addActionListener(e -> { // form dosyasında lesson kısmındaki add butonunun actionListenerı
            //ilk önce comboxı seçilen değeri nasıl alır.
            Item courseItem = (Item) cmb_lesson_course.getSelectedItem();
            Item userItem = (Item) cmb_lesson_user.getSelectedItem();
            if(Helper.isFieldEmpty(fld_lesson_name) || Helper.isFieldEmpty(fld_lesson_lang)){
                Helper.showMsg("fill");
            }else{
                if (Lesson.add(userItem.getKey(), courseItem.getKey(), fld_lesson_name.getText(), fld_lesson_lang.getText())){
                    Helper.showMsg("done");
                    loadLessonModel();
                    fld_lesson_lang.setText(null);
                    fld_lesson_name.setText(null);
                }else {
                    Helper.showMsg("Error");
                }
            }

        });
    }

    private void loadLessonModel() {// lesson clası için Lessonmodel methodu oluşturuyoruz
        DefaultTableModel clearModel = (DefaultTableModel) tbl_lesson_list.getModel();
        clearModel.setRowCount(0);
        int i = 0;
        for (Lesson obj : Lesson.getList()) {
            i = 0;
            row_lesson_list[i++] = obj.getId();
            row_lesson_list[i++] = obj.getName();
            row_lesson_list[i++] = obj.getLang();
            row_lesson_list[i++] = obj.getCourse().getName();
            row_lesson_list[i++] = obj.getEducator().getName();
            mdl_lesson_list.addRow(row_lesson_list);

        }

    }

    private void loadCourseModel() {
        // course sınıfı için oluşturulan metod. // yukarıdaki course clası için yazdığımız methodların sisteme düşmesi için kullanıyoruz
        DefaultTableModel clearModel = (DefaultTableModel) tbl_course_list.getModel();
        clearModel.setRowCount(0);
        int i = 0;
        for (Course obj : Course.getList()) {
            i = 0;
            row_course_list[i++] = obj.getId();
            row_course_list[i++] = obj.getName();
            mdl_course_list.addRow(row_course_list);
        }
    }

    public void loadUserModel() {
        // users kısmı için ekleme işlemini yaptıktan sonra menüde gözükmüyor. Eklendikten sonra hemen sisteme düşmesi için kullanılan kod
        DefaultTableModel clearModel = (DefaultTableModel) tbl_user_list.getModel(); //model içindeki verileri dinamik olarak veritabanından alma
        clearModel.setRowCount(0);
        int i = 0;
        for (User obj : User.getList()) {
            i = 0;
            row_user_list[i++] = obj.getId();
            row_user_list[i++] = obj.getName();
            row_user_list[i++] = obj.getUname();
            row_user_list[i++] = obj.getPass();
            row_user_list[i++] = obj.getType();
            mdl_user_list.addRow(row_user_list);
        }

    }

    public void loadUserModel(ArrayList<User> list) { // yukarıdaki searching için loadUserModel metodunun aynısı kullandık
        // parametre olarak <User> list parametresini verdik.
        DefaultTableModel clearModel = (DefaultTableModel) tbl_user_list.getModel();
        clearModel.setRowCount(0);
        int i = 0;
        for (User obj : list) {
            i = 0;
            row_user_list[i++] = obj.getId();
            row_user_list[i++] = obj.getName();
            row_user_list[i++] = obj.getUname();
            row_user_list[i++] = obj.getPass();
            row_user_list[i++] = obj.getType();
            mdl_user_list.addRow(row_user_list);
        }

    }

    public void loadCourseCombo() { // lesson form dosyasında lesson ve eğitmen kısmı için oluşturuldu
        cmb_lesson_course.removeAllItems(); // bütün bilgileri sildik
        for (Course obj : Course.getList()) {
            cmb_lesson_course.addItem(new Item(obj.getId(), obj.getName())); // bunlar sayesinde lesson bölümüne dersler eklendi
        }

    }
    public void loadEducatorCombo(){ // lesson form dosyasında lesson ve eğitmen kısmı için oluşturuldu
        cmb_lesson_user.removeAllItems();
        for (User obj : User.getOnlyEducator()){ // user kısmında açtığımız method için ayrıca kullanılabilir. sadece educator sorgusu için
                cmb_lesson_user.addItem(new Item(obj.getId(), obj.getName())); // bunlar sayesinde educator bölümüne eğitmenler eklendi
        }
        /*cmb_lesson_user.removeAllItems();
        * for(User obj : User.getList()){
        * if(obj.getType().equals("educator")){
        * cmb_lesson_user.addItem(new Item(obj.getID(),obj.getName()))
        *  olarak da kullanılabilir di yukarıdakini tercih ettik*/
    }

    public static void main(String[] args) {
        Helper.setLayout(); // font methodunu çağırdık.
        Operator op = new Operator(); // operator nesnesini veri tabanından çekmedik burada kendimiz oluşturduk
        op.setId(1);
        op.setName("Soner ALCI");
        op.setPass("1234");
        op.setType("operator");
        op.setUname("soner");

        OperatorGUI opGUI = new OperatorGUI(op);
    }
}
