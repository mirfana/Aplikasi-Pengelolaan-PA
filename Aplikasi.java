/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplikasiPA;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Aplikasi extends javax.swing.JFrame {
    
    private Statement stmt;
    private Connection con;
    private ResultSet rs;
    Database db=new Database();
    public String user,password,tipe,akun;
    int jenis,jenisA;
    
    public void viewS(){
        for(int i=0;i<9;i++){
            tTampil.setValueAt("", i, 0);
            tTampil.setValueAt("", i, 1);
            tTampil.setValueAt("", i, 2);
            tTampil.setValueAt("", i, 3);
            tTampil.setValueAt("", i, 4);
            tTampil.setValueAt("", i, 5);
        }
        String s1 = "SELECT judul_pa,hari,tgl,jam,kode_ruang,id_dosen FROM jadwal j,mahasiswa m WHERE j.nim=m.nim AND j.jenis=1";
        ResultSet resultset = db.getData(s1);
        int j=0;
        try {
            while (resultset.next()) {
                tTampil.setValueAt(resultset.getString("judul_pa"), j, 0);
                tTampil.setValueAt(resultset.getString("hari"), j, 1);
                tTampil.setValueAt(resultset.getString("tgl"), j, 2);
                tTampil.setValueAt(resultset.getString("jam")+".00", j, 3);
                tTampil.setValueAt(resultset.getString("kode_ruang"), j, 4);
                tTampil.setValueAt(resultset.getString("id_dosen"), j, 5);
                j++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public void tampil(String s) throws SQLException{
        for(int i=0;i<9;i++){
            tTampil.setValueAt("", i, 0);
            tTampil.setValueAt("", i, 1);
            tTampil.setValueAt("", i, 2);
            tTampil.setValueAt("", i, 3);
            tTampil.setValueAt("", i, 4);
            tTampil.setValueAt("", i, 5);
        }
        int j=0;
        ResultSet resultset = db.getData(s);
        while (resultset.next()) {
            tTampil.setValueAt(resultset.getString("judul_pa"), j, 0);
            tTampil.setValueAt(resultset.getString("hari"), j, 1);
            tTampil.setValueAt(resultset.getString("tgl"), j, 2);
            tTampil.setValueAt(resultset.getString("jam")+".00", j, 3);
            tTampil.setValueAt(resultset.getString("kode_ruang"), j, 4);
            tTampil.setValueAt(resultset.getString("id_dosen"), j, 5);
            j++;
        }
    }
    
   public void tampilD(){
       String st;
         try {
             for(int k=0;k<10;k++){
                 Tampil.setValueAt("", k, 0);
                 Tampil.setValueAt("", k, 1);
                 Tampil.setValueAt("", k, 2);
             }
             String s="SELECT * FROM Dosen";
             ResultSet resultset = db.getData(s);
             int l=0;
             while (resultset.next()) {

                 Tampil.setValueAt(resultset.getString("id_dosen"), l, 0);
                 Tampil.setValueAt(resultset.getString("nama_dosen"), l, 1);
                 if (resultset.getString("status").equalsIgnoreCase("0")){
                     st="Dosen Pembimbing";
                 }else{
                     st="Dosen Penguji";
                 }
                 Tampil.setValueAt(st, l, 2);


                 l++;

             }    } catch (SQLException ex) {
             Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public void tampil(){
             try {
                 for(int o=0;o<10;o++){
                     Tampil1.setValueAt("", o, 0);
                     Tampil1.setValueAt("", o, 1);
                     Tampil1.setValueAt("", o, 2);
                 }
                 String s="SELECT * FROM Mahasiswa";
                 ResultSet resultset = db.getData(s);
                 int p=0;
                 while (resultset.next()) {
                     Tampil1.setValueAt(resultset.getString("nim"), p, 0);
                     Tampil1.setValueAt(resultset.getString("nama_mhs"), p, 1);
                     Tampil1.setValueAt(resultset.getString("judul_PA"), p, 2);
                     
                     p++;
                     
                 }    } catch (SQLException ex) {
                 Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
   
    public void viewB(String ID){
        int j=0;
        String s = "SELECT hari,tgl,jam,kode_ruang,nim FROM Jadwal WHERE id_dosen='"+ID+"' AND jenis=0";
        ResultSet rs = db.getData(s);
        try {
            while (rs.next()) {
                tblB.setValueAt(rs.getString("hari"), j, 0);
                tblB.setValueAt(rs.getString("tgl"), j, 1);
                tblB.setValueAt(rs.getString("jam")+".00", j, 2);
                tblB.setValueAt(rs.getString("kode_ruang"), j, 3);
                tblB.setValueAt(rs.getString("nim"), j, 4);
                j++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void viewS(String ID){
        int j=0;
        String s = "SELECT hari,tgl,jam,kode_ruang,nim FROM Jadwal WHERE id_dosen='"+ID+"' AND jenis=1";
        ResultSet rs = db.getData(s);
        try {
            while (rs.next()) {
                tblS.setValueAt(rs.getString("hari"), j, 0);
                tblS.setValueAt(rs.getString("tgl"), j, 1);
                tblS.setValueAt(rs.getString("jam")+".00", j, 2);
                tblS.setValueAt(rs.getString("kode_ruang"), j, 3);
                tblS.setValueAt(rs.getString("nim"), j, 4);
                j++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void viewMB(String nim){
        int j=0;
        String s1 = "SELECT hari,tgl,jam,kode_ruang,id_dosen FROM Jadwal WHERE nim='"+nim+"' AND jenis=0";
        ResultSet resultset = db.getData(s1);
        try {
            while (resultset.next()) {
                tblB1.setValueAt(resultset.getString("hari"), j, 0);
                tblB1.setValueAt(resultset.getString("tgl"), j, 1);
                tblB1.setValueAt(resultset.getString("jam")+".00", j, 2);
                tblB1.setValueAt(resultset.getString("kode_ruang"), j, 3);
                tblB1.setValueAt(resultset.getString("id_dosen"), j, 4);
                j++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void viewMS(String nim){
        int j=0;
        String s2 = "SELECT hari,tgl,jam,kode_ruang,id_dosen FROM Jadwal WHERE nim='"+nim+"' AND jenis=1";
        ResultSet resultset = db.getData(s2);
        try {
            if (resultset.next()) {
                tblS1.setValueAt(resultset.getString("hari"), j, 0);
                tblS1.setValueAt(resultset.getString("tgl"), j, 1);
                tblS1.setValueAt(resultset.getString("jam")+".00", j, 2);
                tblS1.setValueAt(resultset.getString("kode_ruang"), j, 3);
                tblS1.setValueAt(resultset.getString("id_dosen"), j, 4);
                j++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void judul(String nim){
        String s="SELECT judul_pa FROM mahasiswa WHERE nim='"+nim+"'";
        rs=db.getData(s);
        try {
            if(rs.next()){
                labelJudul.setText(rs.getString("judul_pa"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Aplikasi() {
        initComponents();
    }

    Aplikasi(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LOGIN = new javax.swing.JPanel();
        txtusername = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        tblmasuk = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        MENU_Admin = new javax.swing.JPanel();
        utama = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jadwal = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jButton28 = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        inputDsn = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jText1 = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        inputMhs = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        txtNIM = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jText2 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        viewData = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButton25 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton26 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tampil = new javax.swing.JTable();
        btnView = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        Tampil1 = new javax.swing.JTable();
        jButton27 = new javax.swing.JButton();
        btnView2 = new javax.swing.JButton();
        inputJadwalS = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        boxThn = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        txtRuang = new javax.swing.JTextField();
        txtNIM1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtHari = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        boxBln = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        boxJam = new javax.swing.JComboBox();
        boxTgl = new javax.swing.JComboBox();
        txtPguji = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        editJadwalS = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        boxTgl2 = new javax.swing.JComboBox();
        boxBln2 = new javax.swing.JComboBox();
        boxThn2 = new javax.swing.JComboBox();
        txtID2 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        boxJam2 = new javax.swing.JComboBox();
        txtRuang2 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        btnSubmit2 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        txtHari2 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        viewJadwalAdm = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tTampil = new javax.swing.JTable();
        jButton20 = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnViewAll = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        MENU_DsnB = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        labelDsnB = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        inputJadwalB = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        boxThn1 = new javax.swing.JComboBox();
        txtRuang1 = new javax.swing.JTextField();
        btnSubmit1 = new javax.swing.JButton();
        txtNIM2 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtID1 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        boxJam1 = new javax.swing.JComboBox();
        boxBln1 = new javax.swing.JComboBox();
        txtHari1 = new javax.swing.JTextField();
        boxTgl1 = new javax.swing.JComboBox();
        jLabel33 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        viewJadwalB = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblB = new javax.swing.JTable();
        jButton21 = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        labelDsnB1 = new javax.swing.JLabel();
        MENU_DsnS = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        labelDsnS = new javax.swing.JLabel();
        viewJadwalS = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblS = new javax.swing.JTable();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        labelDsnS1 = new javax.swing.JLabel();
        MENU_Mhs = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        labelNIM = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        inputJudul = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtJudul = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txtNIM3 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        viewJadwalMhs = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblS1 = new javax.swing.JTable();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jButton22 = new javax.swing.JButton();
        labelJudul = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblB1 = new javax.swing.JTable();
        labelNIM1 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        LOGIN.setBackground(new java.awt.Color(0, 255, 153));
        LOGIN.setPreferredSize(new java.awt.Dimension(450, 560));

        tblmasuk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblmasuk.setText("Masuk");
        tblmasuk.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tblmasukMouseMoved(evt);
            }
        });
        tblmasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblmasukActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userpng.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/passpng.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("LOGIN");

        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo1.png"))); // NOI18N

        jLabel44.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel44.setText("Aplikasi Pengelolaan PA");

        javax.swing.GroupLayout LOGINLayout = new javax.swing.GroupLayout(LOGIN);
        LOGIN.setLayout(LOGINLayout);
        LOGINLayout.setHorizontalGroup(
            LOGINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LOGINLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel65)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LOGINLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(LOGINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LOGINLayout.createSequentialGroup()
                        .addGroup(LOGINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(LOGINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtusername)
                            .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(127, 127, 127))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LOGINLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LOGINLayout.createSequentialGroup()
                        .addComponent(tblmasuk)
                        .addGap(180, 180, 180))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LOGINLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel44)
                .addGap(103, 103, 103))
        );
        LOGINLayout.setVerticalGroup(
            LOGINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LOGINLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(LOGINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(LOGINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(tblmasuk)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(LOGIN, "card6");

        MENU_Admin.setPreferredSize(new java.awt.Dimension(450, 560));
        MENU_Admin.setLayout(new java.awt.CardLayout());

        utama.setPreferredSize(new java.awt.Dimension(450, 560));

        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo1.png"))); // NOI18N

        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/319.JPG"))); // NOI18N

        jButton29.setText("Log Out");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton30.setText("Jadwal Sidang");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton31.setText("Mahasiswa");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton32.setText("Dosen");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton33.setText("Lihat Data");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout utamaLayout = new javax.swing.GroupLayout(utama);
        utama.setLayout(utamaLayout);
        utamaLayout.setHorizontalGroup(
            utamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(utamaLayout.createSequentialGroup()
                .addGroup(utamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(utamaLayout.createSequentialGroup()
                        .addGap(349, 349, 349)
                        .addComponent(jButton29))
                    .addGroup(utamaLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel63))
                    .addGroup(utamaLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(utamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(utamaLayout.createSequentialGroup()
                                .addComponent(jButton30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton33))
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        utamaLayout.setVerticalGroup(
            utamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(utamaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(utamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton30)
                    .addComponent(jButton32)
                    .addComponent(jButton31)
                    .addComponent(jButton33))
                .addGap(37, 37, 37)
                .addComponent(jLabel64)
                .addGap(40, 40, 40)
                .addComponent(jButton29)
                .addContainerGap())
        );

        MENU_Admin.add(utama, "card2");

        jadwal.setPreferredSize(new java.awt.Dimension(450, 560));

        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo1.png"))); // NOI18N

        jButton28.setText("Back");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/319.JPG"))); // NOI18N

        jButton1.setText("Input Jadwal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit Jadwal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Lihat Jadwal");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jadwalLayout = new javax.swing.GroupLayout(jadwal);
        jadwal.setLayout(jadwalLayout);
        jadwalLayout.setHorizontalGroup(
            jadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jadwalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton28)
                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jadwalLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addGap(29, 29, 29))
            .addGroup(jadwalLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel61)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jadwalLayout.setVerticalGroup(
            jadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jadwalLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton28)
                .addContainerGap())
        );

        MENU_Admin.add(jadwal, "card2");

        getContentPane().add(MENU_Admin, "card2");

        inputDsn.setPreferredSize(new java.awt.Dimension(450, 560));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo1.png"))); // NOI18N

        jButton8.setText("Back");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Status              :");

        jButton9.setText("Submit");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Nama               :");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Input Dosen");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("ID                    :");

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton1.setText("Dosen Pembimbing");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton2.setText("Dosen Penguji");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inputDsnLayout = new javax.swing.GroupLayout(inputDsn);
        inputDsn.setLayout(inputDsnLayout);
        inputDsnLayout.setHorizontalGroup(
            inputDsnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputDsnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(inputDsnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputDsnLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(167, 167, 167))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputDsnLayout.createSequentialGroup()
                        .addGroup(inputDsnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(inputDsnLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addGroup(inputDsnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jText1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton9)))
                            .addGroup(inputDsnLayout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(inputDsnLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addGroup(inputDsnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jRadioButton1))))
                        .addGap(37, 37, 37))))
            .addGroup(inputDsnLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(inputDsnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton8)
                    .addComponent(jLabel15))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        inputDsnLayout.setVerticalGroup(
            inputDsnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputDsnLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel18)
                .addGap(50, 50, 50)
                .addGroup(inputDsnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(inputDsnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(inputDsnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addGap(21, 21, 21)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(11, 11, 11))
        );

        getContentPane().add(inputDsn, "card5");

        inputMhs.setPreferredSize(new java.awt.Dimension(450, 560));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo1.png"))); // NOI18N

        jButton13.setText("Back");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Submit");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("NIM                  :");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Nama               :");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("Input Mahasiswa");

        javax.swing.GroupLayout inputMhsLayout = new javax.swing.GroupLayout(inputMhs);
        inputMhs.setLayout(inputMhsLayout);
        inputMhsLayout.setHorizontalGroup(
            inputMhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputMhsLayout.createSequentialGroup()
                .addGroup(inputMhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputMhsLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(inputMhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(inputMhsLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(jText2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(inputMhsLayout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(inputMhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton14)
                                    .addComponent(txtNIM, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(inputMhsLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(inputMhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton13)
                            .addGroup(inputMhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16)
                                .addGroup(inputMhsLayout.createSequentialGroup()
                                    .addGap(118, 118, 118)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        inputMhsLayout.setVerticalGroup(
            inputMhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputMhsLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addGap(50, 50, 50)
                .addGroup(inputMhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtNIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(inputMhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jButton14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                .addComponent(jButton13)
                .addContainerGap())
        );

        getContentPane().add(inputMhs, "card5");

        viewData.setPreferredSize(new java.awt.Dimension(450, 560));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo1.png"))); // NOI18N

        jButton25.setText("Back");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton26.setText("Search by ID");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        Tampil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Dosen", "Nama Dosen", "Status"
            }
        ));
        jScrollPane1.setViewportView(Tampil);

        btnView.setText("View All");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnView)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton26)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnView)
                .addGap(52, 52, 52))
        );

        jTabbedPane1.addTab("Lihat Daftar Dosen", jPanel2);

        Tampil1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NIM", "Nama", "Judul  PA"
            }
        ));
        jScrollPane7.setViewportView(Tampil1);

        jButton27.setText("Search by NIM");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        btnView2.setText("View All");
        btnView2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnView2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton27))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnView2)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton27))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnView2)
                .addGap(53, 53, 53))
        );

        jTabbedPane1.addTab("Lihat Daftar Mahasiswa", jPanel3);

        javax.swing.GroupLayout viewDataLayout = new javax.swing.GroupLayout(viewData);
        viewData.setLayout(viewDataLayout);
        viewDataLayout.setHorizontalGroup(
            viewDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(viewDataLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewDataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton25)
                .addGap(32, 32, 32))
        );
        viewDataLayout.setVerticalGroup(
            viewDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewDataLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jTabbedPane1)
                .addGap(18, 18, 18)
                .addComponent(jButton25)
                .addContainerGap())
        );

        getContentPane().add(viewData, "card5");

        inputJadwalS.setPreferredSize(new java.awt.Dimension(450, 560));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo1.png"))); // NOI18N

        boxThn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boxThn.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Tanggal               :");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("NIM                     :");

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Hari                     :");

        jButton15.setText("Back");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Kode Ruangan     :");

        boxBln.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boxBln.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Jam                     :");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("ID Dosen Penguji :");

        boxJam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boxJam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "08", "09", "10", "11", "12", "13", "14", "15", "16" }));
        boxJam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxJamActionPerformed(evt);
            }
        });

        boxTgl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boxTgl.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        txtPguji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPgujiActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel55.setText("Input Jadwal Sidang");

        javax.swing.GroupLayout inputJadwalSLayout = new javax.swing.GroupLayout(inputJadwalS);
        inputJadwalS.setLayout(inputJadwalSLayout);
        inputJadwalSLayout.setHorizontalGroup(
            inputJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputJadwalSLayout.createSequentialGroup()
                .addGroup(inputJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton15)
                    .addGroup(inputJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(inputJadwalSLayout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(jLabel23))
                        .addGroup(inputJadwalSLayout.createSequentialGroup()
                            .addGap(63, 63, 63)
                            .addGroup(inputJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(inputJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(inputJadwalSLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(boxJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(inputJadwalSLayout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addComponent(btnSubmit))
                                .addGroup(inputJadwalSLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(inputJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNIM1)
                                        .addComponent(txtHari, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPguji)
                                        .addComponent(txtRuang, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(inputJadwalSLayout.createSequentialGroup()
                                            .addComponent(boxTgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(boxBln, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(boxThn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(inputJadwalSLayout.createSequentialGroup()
                            .addGap(143, 143, 143)
                            .addComponent(jLabel55))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        inputJadwalSLayout.setVerticalGroup(
            inputJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputJadwalSLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(inputJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtNIM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtHari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(boxTgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boxBln, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boxThn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel25))
                .addGap(11, 11, 11)
                .addGroup(inputJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(boxJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(inputJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtRuang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtPguji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSubmit)
                .addGap(65, 65, 65)
                .addComponent(jButton15)
                .addGap(11, 11, 11))
        );

        getContentPane().add(inputJadwalS, "card5");

        editJadwalS.setPreferredSize(new java.awt.Dimension(450, 560));

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo1.png"))); // NOI18N

        boxTgl2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boxTgl2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        boxBln2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boxBln2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));

        boxThn2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boxThn2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));

        txtID2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtID2ActionPerformed(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel56.setText("ID Dosen     :");

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel57.setText("Tanggal        :");

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel58.setText("Hari              :");

        boxJam2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boxJam2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "08", "09", "10", "11", "12", "13", "14", "15", "16" }));
        boxJam2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxJam2ActionPerformed(evt);
            }
        });

        txtRuang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRuang2ActionPerformed(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel59.setText("Kode Ruang :");

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel60.setText("Jam              :");

        btnSubmit2.setText("Submit");
        btnSubmit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmit2ActionPerformed(evt);
            }
        });

        jButton24.setText("Back");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        txtHari2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHari2ActionPerformed(evt);
            }
        });

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel66.setText("Ubah Jadwal Sidang");

        javax.swing.GroupLayout editJadwalSLayout = new javax.swing.GroupLayout(editJadwalS);
        editJadwalS.setLayout(editJadwalSLayout);
        editJadwalSLayout.setHorizontalGroup(
            editJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editJadwalSLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(editJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSubmit2)
                    .addComponent(txtHari2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxJam2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRuang2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(editJadwalSLayout.createSequentialGroup()
                        .addComponent(boxTgl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxBln2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxThn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtID2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
            .addGroup(editJadwalSLayout.createSequentialGroup()
                .addGroup(editJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton24)
                    .addGroup(editJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(editJadwalSLayout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(jLabel54))
                        .addGroup(editJadwalSLayout.createSequentialGroup()
                            .addGap(141, 141, 141)
                            .addComponent(jLabel66))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        editJadwalSLayout.setVerticalGroup(
            editJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editJadwalSLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(editJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRuang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addGap(12, 12, 12)
                .addGroup(editJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHari2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(boxTgl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boxBln2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boxThn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(boxJam2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(btnSubmit2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(jButton24)
                .addGap(11, 11, 11))
        );

        getContentPane().add(editJadwalS, "card5");

        viewJadwalAdm.setPreferredSize(new java.awt.Dimension(450, 560));

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo1.png"))); // NOI18N

        btnSearch.setText("Search by NIM");
        btnSearch.setToolTipText("");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tTampil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Judul", "Hari", "Tanggal", "Jam", "Ruangan", "Penguji"
            }
        ));
        jScrollPane3.setViewportView(tTampil);

        jButton20.setText("Back");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnViewAll.setText("View All");
        btnViewAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllActionPerformed(evt);
            }
        });

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel67.setText("Jadwal Sidang");

        javax.swing.GroupLayout viewJadwalAdmLayout = new javax.swing.GroupLayout(viewJadwalAdm);
        viewJadwalAdm.setLayout(viewJadwalAdmLayout);
        viewJadwalAdmLayout.setHorizontalGroup(
            viewJadwalAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewJadwalAdmLayout.createSequentialGroup()
                .addGroup(viewJadwalAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewJadwalAdmLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(viewJadwalAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(viewJadwalAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnViewAll)
                                .addGroup(viewJadwalAdmLayout.createSequentialGroup()
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnSearch)))
                            .addComponent(jLabel43)
                            .addComponent(jButton20)))
                    .addGroup(viewJadwalAdmLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel67)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        viewJadwalAdmLayout.setVerticalGroup(
            viewJadwalAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewJadwalAdmLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(viewJadwalAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnViewAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(jButton20)
                .addContainerGap())
        );

        getContentPane().add(viewJadwalAdm, "card5");

        MENU_DsnB.setPreferredSize(new java.awt.Dimension(450, 560));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/319.JPG"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo1.png"))); // NOI18N

        jButton10.setText("Log Out");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel8.setText("ID Dosen :");

        labelDsnB.setText("-");

        jButton6.setText("Input Jadwal Bimbingan");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Lihat Jadwal Bimbingan");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MENU_DsnBLayout = new javax.swing.GroupLayout(MENU_DsnB);
        MENU_DsnB.setLayout(MENU_DsnBLayout);
        MENU_DsnBLayout.setHorizontalGroup(
            MENU_DsnBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MENU_DsnBLayout.createSequentialGroup()
                .addGroup(MENU_DsnBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MENU_DsnBLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel5))
                    .addGroup(MENU_DsnBLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(MENU_DsnBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton10)
                            .addGroup(MENU_DsnBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(MENU_DsnBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(MENU_DsnBLayout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(labelDsnB, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        MENU_DsnBLayout.setVerticalGroup(
            MENU_DsnBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MENU_DsnBLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MENU_DsnBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDsnB)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addGap(25, 25, 25)
                .addComponent(jButton10)
                .addGap(11, 11, 11))
        );

        getContentPane().add(MENU_DsnB, "card3");

        inputJadwalB.setPreferredSize(new java.awt.Dimension(450, 560));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo1.png"))); // NOI18N

        boxThn1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boxThn1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));

        btnSubmit1.setText("Submit");
        btnSubmit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmit1ActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Tanggal               :");

        txtID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtID1ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("ID Dosen             :");

        boxJam1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boxJam1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "08", "09", "10", "11", "12", "13", "14", "15", "16" }));
        boxJam1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxJam1ActionPerformed(evt);
            }
        });

        boxBln1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boxBln1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));

        boxTgl1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        boxTgl1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Hari                     :");

        jButton16.setText("Back");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Kode Ruangan     :");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("NIM                     :");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("Jam                     :");

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel68.setText("Input Jadwal Bimbingan");

        javax.swing.GroupLayout inputJadwalBLayout = new javax.swing.GroupLayout(inputJadwalB);
        inputJadwalB.setLayout(inputJadwalBLayout);
        inputJadwalBLayout.setHorizontalGroup(
            inputJadwalBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputJadwalBLayout.createSequentialGroup()
                .addGroup(inputJadwalBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton16)
                    .addGroup(inputJadwalBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(inputJadwalBLayout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(jLabel24))
                        .addGroup(inputJadwalBLayout.createSequentialGroup()
                            .addGap(128, 128, 128)
                            .addComponent(jLabel68))
                        .addGroup(inputJadwalBLayout.createSequentialGroup()
                            .addGap(61, 61, 61)
                            .addGroup(inputJadwalBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(inputJadwalBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(inputJadwalBLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(boxJam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(inputJadwalBLayout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addComponent(btnSubmit1))
                                .addGroup(inputJadwalBLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(inputJadwalBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNIM2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(inputJadwalBLayout.createSequentialGroup()
                                            .addGroup(inputJadwalBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtHari1, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtID1, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtRuang1, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, inputJadwalBLayout.createSequentialGroup()
                                                    .addComponent(boxTgl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(boxBln1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(boxThn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        inputJadwalBLayout.setVerticalGroup(
            inputJadwalBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputJadwalBLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel68)
                .addGap(27, 27, 27)
                .addGroup(inputJadwalBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtNIM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputJadwalBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtHari1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputJadwalBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(boxTgl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxBln1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxThn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(inputJadwalBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(boxJam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(inputJadwalBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtRuang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputJadwalBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSubmit1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jButton16)
                .addGap(44, 44, 44))
        );

        getContentPane().add(inputJadwalB, "card5");

        viewJadwalB.setPreferredSize(new java.awt.Dimension(450, 560));

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo1.png"))); // NOI18N

        tblB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Hari", "Tanggal", "Jam", "Ruangan", "Mahasiswa"
            }
        ));
        jScrollPane4.setViewportView(tblB);

        jButton21.setText("Back");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel69.setText("Jadwal Bimbingan");

        jLabel70.setText("ID Dosen :");

        labelDsnB1.setText("-");

        javax.swing.GroupLayout viewJadwalBLayout = new javax.swing.GroupLayout(viewJadwalB);
        viewJadwalB.setLayout(viewJadwalBLayout);
        viewJadwalBLayout.setHorizontalGroup(
            viewJadwalBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewJadwalBLayout.createSequentialGroup()
                .addGroup(viewJadwalBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewJadwalBLayout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel69))
                    .addGroup(viewJadwalBLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(viewJadwalBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(viewJadwalBLayout.createSequentialGroup()
                                .addGroup(viewJadwalBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(viewJadwalBLayout.createSequentialGroup()
                                        .addComponent(jLabel70)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelDsnB1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel46))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewJadwalBLayout.createSequentialGroup()
                        .addContainerGap(374, Short.MAX_VALUE)
                        .addComponent(jButton21)))
                .addGap(21, 21, 21))
        );
        viewJadwalBLayout.setVerticalGroup(
            viewJadwalBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewJadwalBLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel69)
                .addGap(26, 26, 26)
                .addGroup(viewJadwalBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(labelDsnB1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jButton21)
                .addGap(11, 11, 11))
        );

        getContentPane().add(viewJadwalB, "card5");

        MENU_DsnS.setPreferredSize(new java.awt.Dimension(450, 560));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/319.JPG"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo1.png"))); // NOI18N

        jButton12.setText("Log Out");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton4.setText("Lihat Jadwal Sidang");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel48.setText("ID Dosen :");

        labelDsnS.setText("-");

        javax.swing.GroupLayout MENU_DsnSLayout = new javax.swing.GroupLayout(MENU_DsnS);
        MENU_DsnS.setLayout(MENU_DsnSLayout);
        MENU_DsnSLayout.setHorizontalGroup(
            MENU_DsnSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MENU_DsnSLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(MENU_DsnSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(MENU_DsnSLayout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelDsnS, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4)
                    .addGroup(MENU_DsnSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton12)
                        .addComponent(jLabel9)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        MENU_DsnSLayout.setVerticalGroup(
            MENU_DsnSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MENU_DsnSLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MENU_DsnSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDsnS)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton12)
                .addGap(11, 11, 11))
        );

        getContentPane().add(MENU_DsnS, "card4");

        viewJadwalS.setPreferredSize(new java.awt.Dimension(450, 560));

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo1.png"))); // NOI18N

        jButton19.setText("Back");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        tblS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Hari", "Tanggal", "Jam", "Ruangan", "Mahasiswa"
            }
        ));
        jScrollPane2.setViewportView(tblS);

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel71.setText("Jadwal Sidang");

        jLabel72.setText("ID Dosen :");

        labelDsnS1.setText("-");

        javax.swing.GroupLayout viewJadwalSLayout = new javax.swing.GroupLayout(viewJadwalS);
        viewJadwalS.setLayout(viewJadwalSLayout);
        viewJadwalSLayout.setHorizontalGroup(
            viewJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewJadwalSLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(viewJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(viewJadwalSLayout.createSequentialGroup()
                        .addComponent(jLabel72)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelDsnS1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(viewJadwalSLayout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addComponent(jButton19))
                    .addComponent(jLabel42))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewJadwalSLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel71)
                .addGap(160, 160, 160))
        );
        viewJadwalSLayout.setVerticalGroup(
            viewJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewJadwalSLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel71)
                .addGap(26, 26, 26)
                .addGroup(viewJadwalSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(labelDsnS1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jButton19)
                .addGap(11, 11, 11))
        );

        getContentPane().add(viewJadwalS, "card5");

        MENU_Mhs.setPreferredSize(new java.awt.Dimension(450, 560));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/319.JPG"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo1.png"))); // NOI18N

        jButton11.setText("Log Out");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        labelNIM.setText("-");

        jButton5.setText("Input Judul PA");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton23.setText("Lihat Jadwal Mahasiswa");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jLabel2.setText("NIM : ");

        javax.swing.GroupLayout MENU_MhsLayout = new javax.swing.GroupLayout(MENU_Mhs);
        MENU_Mhs.setLayout(MENU_MhsLayout);
        MENU_MhsLayout.setHorizontalGroup(
            MENU_MhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MENU_MhsLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(MENU_MhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(MENU_MhsLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNIM))
                    .addComponent(jButton5)
                    .addComponent(jButton23)
                    .addGroup(MENU_MhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton11)
                        .addComponent(jLabel6)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        MENU_MhsLayout.setVerticalGroup(
            MENU_MhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MENU_MhsLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MENU_MhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNIM)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addComponent(jButton11)
                .addGap(11, 11, 11))
        );

        getContentPane().add(MENU_Mhs, "card5");

        inputJudul.setPreferredSize(new java.awt.Dimension(450, 560));

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo1.png"))); // NOI18N

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setText("Judul PA           :");

        jButton17.setText("Submit");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("Back");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel39.setText("Input Judul PA");

        txtNama.setEditable(false);

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("Nama               :");

        txtNIM3.setEditable(false);

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel41.setText("NIM                  :");

        javax.swing.GroupLayout inputJudulLayout = new javax.swing.GroupLayout(inputJudul);
        inputJudul.setLayout(inputJudulLayout);
        inputJudulLayout.setHorizontalGroup(
            inputJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputJudulLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(inputJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputJudulLayout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(jButton18))
                    .addGroup(inputJudulLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inputJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(inputJudulLayout.createSequentialGroup()
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtNIM3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputJudulLayout.createSequentialGroup()
                            .addComponent(jLabel40)
                            .addGap(18, 18, 18)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(inputJudulLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(inputJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton17)
                            .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28))
            .addGroup(inputJudulLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel37)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        inputJudulLayout.setVerticalGroup(
            inputJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputJudulLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel39)
                .addGap(43, 43, 43)
                .addGroup(inputJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtNIM3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(inputJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(inputJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(inputJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputJudulLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton17)
                        .addGap(136, 136, 136))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputJudulLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton18)))
                .addGap(11, 11, 11))
        );

        getContentPane().add(inputJudul, "card5");

        viewJadwalMhs.setPreferredSize(new java.awt.Dimension(450, 560));

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo1.png"))); // NOI18N

        tblS1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Hari", "Tanggal", "Jam", "Ruangan", "Penguji"
            }
        ));
        jScrollPane5.setViewportView(tblS1);

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel50.setText("Jadwal Sidang");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel51.setText("Jadwal Bimbingan");

        jButton22.setText("Back");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        labelJudul.setText("-");

        jLabel52.setText("NIM         :");

        tblB1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Hari", "Tanggal", "Jam", "Ruangan", "Pembimbing"
            }
        ));
        jScrollPane6.setViewportView(tblB1);

        labelNIM1.setText("-");

        jLabel53.setText("Judul PA  :");

        javax.swing.GroupLayout viewJadwalMhsLayout = new javax.swing.GroupLayout(viewJadwalMhs);
        viewJadwalMhs.setLayout(viewJadwalMhsLayout);
        viewJadwalMhsLayout.setHorizontalGroup(
            viewJadwalMhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewJadwalMhsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton22)
                .addGap(28, 28, 28))
            .addGroup(viewJadwalMhsLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(viewJadwalMhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, viewJadwalMhsLayout.createSequentialGroup()
                        .addGroup(viewJadwalMhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(viewJadwalMhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNIM1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        viewJadwalMhsLayout.setVerticalGroup(
            viewJadwalMhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewJadwalMhsLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(viewJadwalMhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(labelNIM1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(viewJadwalMhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(labelJudul))
                .addGap(9, 9, 9)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(jButton22)
                .addGap(11, 11, 11))
        );

        getContentPane().add(viewJadwalMhs, "card5");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        MENU_Mhs.setVisible(false);
        LOGIN.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        MENU_DsnS.setVisible(false);
        LOGIN.setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void tblmasukMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmasukMouseMoved

    }//GEN-LAST:event_tblmasukMouseMoved

    private void tblmasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblmasukActionPerformed
        try{
            String sql = "SELECT * FROM akun WHERE username = '"+txtusername.getText()+"' and password = '"+String.valueOf(txtpassword.getPassword())+"'";
            ResultSet rs= db.getData(sql);
            if(rs.next()){
                akun=txtusername.getText();
                user = rs.getString("username");
                password = rs.getString("password");
                tipe=rs.getString("tipe");
                JOptionPane.showMessageDialog(null, "Login Berhasil");
                if(tipe.equals("1")){
                    LOGIN.setVisible(false);
                    MENU_Admin.setVisible(true);
                }
                else if(tipe.equals("21")){
                    LOGIN.setVisible(false);
                    MENU_DsnB.setVisible(true);
                    labelDsnB.setText(akun);
                }
                else if(tipe.equals("22")){
                    LOGIN.setVisible(false);
                    MENU_DsnS.setVisible(true);
                    labelDsnS.setText(akun);
                }
                else{
                    LOGIN.setVisible(false);
                    MENU_Mhs.setVisible(true);
                    labelNIM.setText(akun);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Gagal Login","Pesan",JOptionPane.ERROR_MESSAGE);
            }
            txtusername.setText("");
            txtpassword.setText("");
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblmasukActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        inputDsn.setVisible(false);
        MENU_Admin.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String s1 = "INSERT INTO akun VALUES('"+txtID.getText()+"','"+txtID.getText()+"',"+jenisA+")";
        String s2 = "insert into Dosen values('"+txtID.getText()+"','"+jText1.getText()+"',"+jenis+")";
        int dialog = JOptionPane.showConfirmDialog(null, "Anda Yakin?", "",JOptionPane.YES_NO_OPTION);
        if (dialog == JOptionPane.YES_OPTION){
            db.query(s1);
            db.query(s2);
            txtID.setText("");
            jText1.setText("");
            javax.swing.JOptionPane.showMessageDialog(null, "Data Berhasil Dismpan");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        jenis=0;
        jenisA=21;
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jenis=1;
        jenisA=22;
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        String tgl=boxTgl.getSelectedItem().toString()+" "+boxBln.getSelectedItem().toString()+" "+boxThn.getSelectedItem().toString();
        String s = "INSERT INTO Jadwal VALUES('"+txtHari.getText()+"','"+tgl+"','"+boxJam.getSelectedItem().toString()+"','"+txtRuang.getText()+"','"+txtPguji.getText()+"','"+txtNIM1.getText()+"',1)";
        int dialog = JOptionPane.showConfirmDialog(null, "Anda Yakin?", "",JOptionPane.YES_NO_OPTION);
        if (dialog == JOptionPane.YES_OPTION){
            db.query(s);
            txtNIM1.setText("");
            txtHari.setText("");
            txtRuang.setText("");
            txtPguji.setText("");
            javax.swing.JOptionPane.showMessageDialog(null, "Data Berhasil Dismpan");
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        inputJadwalS.setVisible(false);
        MENU_Admin.setVisible(true);
        jadwal.setVisible(true);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void boxJamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxJamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxJamActionPerformed

    private void txtPgujiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPgujiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPgujiActionPerformed

    private void btnSubmit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmit1ActionPerformed
        String tgl=boxTgl1.getSelectedItem().toString()+" "+boxBln1.getSelectedItem().toString()+" "+boxThn1.getSelectedItem().toString();
        String s = "INSERT INTO Jadwal VALUES('"+txtHari1.getText()+"','"+tgl+"','"+boxJam1.getSelectedItem().toString()+"','"+txtRuang1.getText()+"','"+txtID1.getText()+"','"+txtNIM2.getText()+"',0)";
        int dialog = JOptionPane.showConfirmDialog(null, "Anda Yakin?", "",JOptionPane.YES_NO_OPTION);
        if (dialog == JOptionPane.YES_OPTION){
            db.query(s);
            txtNIM2.setText("");
            txtHari1.setText("");
            txtRuang1.setText("");
            javax.swing.JOptionPane.showMessageDialog(null, "Data Berhasil Dismpan");
        }
    }//GEN-LAST:event_btnSubmit1ActionPerformed

    private void txtID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtID1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtID1ActionPerformed

    private void boxJam1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxJam1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxJam1ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        inputJadwalB.setVisible(false);
        MENU_DsnB.setVisible(true);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        String s = "UPDATE mahasiswa SET judul_pa='"+txtJudul.getText()+"' WHERE nim='"+txtNIM3.getText()+"'";
        int dialog = JOptionPane.showConfirmDialog(null, "Anda Yakin?", "",JOptionPane.YES_NO_OPTION);
        if (dialog == JOptionPane.YES_OPTION){
            db.query(s);
            javax.swing.JOptionPane.showMessageDialog(null, "Data Berhasil Dismpan");
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        inputJudul.setVisible(false);
        MENU_Mhs.setVisible(true);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        viewJadwalS.setVisible(false);
        MENU_DsnS.setVisible(true);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        for(int i=0;i<9;i++){
            tTampil.setValueAt("", i, 0);
            tTampil.setValueAt("", i, 1);
            tTampil.setValueAt("", i, 2);
            tTampil.setValueAt("", i, 3);
            tTampil.setValueAt("", i, 4);
            tTampil.setValueAt("", i, 5);
        }
        String s = "SELECT judul_pa,hari,tgl,jam,kode_ruang,id_dosen FROM jadwal j,mahasiswa m WHERE j.nim='"+txtSearch.getText()+"' AND j.nim=m.nim AND j.jenis=1";
        try {
            tampil(s);
        } catch (SQLException ex) {}
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        viewJadwalAdm.setVisible(false);
        MENU_Admin.setVisible(true);
        jadwal.setVisible(true);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnViewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllActionPerformed
        viewS();
    }//GEN-LAST:event_btnViewAllActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        viewJadwalB.setVisible(false);
        MENU_DsnB.setVisible(true);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        viewJadwalMhs.setVisible(false);
        MENU_Mhs.setVisible(true);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void txtID2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtID2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtID2ActionPerformed

    private void boxJam2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxJam2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxJam2ActionPerformed

    private void txtRuang2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRuang2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRuang2ActionPerformed

    private void btnSubmit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmit2ActionPerformed
        String tgl=boxTgl2.getSelectedItem().toString()+" "+boxBln2.getSelectedItem().toString()+" "+boxThn2.getSelectedItem().toString();
        String s1="UPDATE jadwal SET hari='"+txtHari2.getText()+"' WHERE kode_ruang='"+txtRuang2.getText()+"' AND id_dosen='"+txtID2.getText()+"'";
        String s2="UPDATE jadwal SET tgl='"+tgl+"' WHERE kode_ruang='"+txtRuang2.getText()+"' AND id_dosen='"+txtID2.getText()+"'";
        String s3="UPDATE jadwal SET jam='"+boxJam2.getSelectedItem().toString()+"' WHERE kode_ruang='"+txtRuang2.getText()+"' AND id_dosen='"+txtID2.getText()+"'";
        db.query(s1);
        db.query(s2);
        db.query(s3);
        javax.swing.JOptionPane.showMessageDialog(null, "Jadwal telah diubah");
        txtRuang2.setText("");
        txtID2.setText("");
        txtHari2.setText("");
    }//GEN-LAST:event_btnSubmit2ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        editJadwalS.setVisible(false);
        MENU_Admin.setVisible(true);
        jadwal.setVisible(true);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void txtHari2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHari2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHari2ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        viewData.setVisible(false);
        MENU_Admin.setVisible(true);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        String s="select id_dosen,nama_dosen,status from dosen where id_dosen='"+jTextField1.getText()+"'";
        try {
            for(int i=0;i<10;i++){
                Tampil.setValueAt("", i, 0);
                Tampil.setValueAt("", i, 1);
                Tampil.setValueAt("", i, 2);
            }
            ResultSet resultset = db.getData(s);
            int j=0;
            while (resultset.next()) {
                Tampil.setValueAt(resultset.getString("id_dosen"), j, 0);
                Tampil.setValueAt(resultset.getString("nama_dosen"), j, 1);
                Tampil.setValueAt(resultset.getString("status"), j, 2);
                j++;
            }    
        } catch (SQLException ex) {}
    }//GEN-LAST:event_jButton26ActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        tampilD();
    }//GEN-LAST:event_btnViewActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        String s="select nim,nama_mhs,judul_PA from mahasiswa where nim='"+jTextField2.getText()+"'";
        try {
            for(int m=0;m<10;m++){
                Tampil1.setValueAt("", m, 0);
                Tampil1.setValueAt("", m, 1);
                Tampil1.setValueAt("", m, 2);
            }
            ResultSet resultset = db.getData(s);
            int n=0;
            while (resultset.next()) {
                Tampil1.setValueAt(resultset.getString("nim"), n, 0);
                Tampil1.setValueAt(resultset.getString("nama_mhs"), n, 1);
                Tampil1.setValueAt(resultset.getString("judul_PA"), n, 2);
                n++;
            }    
        } catch (SQLException ex) {}
    }//GEN-LAST:event_jButton27ActionPerformed

    private void btnView2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnView2ActionPerformed
        tampil();
    }//GEN-LAST:event_btnView2ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        jadwal.setVisible(false);
        utama.setVisible(true);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        MENU_Admin.setVisible(false);
        LOGIN.setVisible(true);
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        utama.setVisible(false);
        jadwal.setVisible(true);
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        MENU_Admin.setVisible(false);
        inputMhs.setVisible(true);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        MENU_Admin.setVisible(false);
        inputDsn.setVisible(true);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        MENU_Admin.setVisible(false);
        viewData.setVisible(true);
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MENU_Admin.setVisible(false);
        inputJadwalS.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        MENU_Admin.setVisible(false);
        editJadwalS.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        MENU_Admin.setVisible(false);
        viewJadwalAdm.setVisible(true);
        viewS();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        MENU_DsnS.setVisible(false);
        viewJadwalS.setVisible(true);
        viewS(akun);
        labelDsnS1.setText(akun);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        MENU_Mhs.setVisible(false);
        inputJudul.setVisible(true);
        String s="SELECT nim,nama_mhs,judul_pa FROM mahasiswa WHERE nim='"+akun+"'";
        rs=db.getData(s);
        try {
            if(rs.next()){
                txtNIM3.setText(rs.getString("nim"));
                txtNama.setText(rs.getString("nama_mhs"));
                txtJudul.setText(rs.getString("judul_pa"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        MENU_Mhs.setVisible(false);
        viewJadwalMhs.setVisible(true);
        labelNIM1.setText(akun);
        judul(akun);
        viewMB(akun);
        viewMS(akun);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        MENU_DsnB.setVisible(false);
        viewJadwalB.setVisible(true);
        viewB(akun);
        labelDsnB1.setText(akun);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        MENU_DsnB.setVisible(false);
        inputJadwalB.setVisible(true);
        txtID1.setText(akun);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        MENU_DsnB.setVisible(false);
        LOGIN.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        String s1 = "INSERT INTO akun VALUES('"+txtNIM.getText()+"','"+txtNIM.getText()+"',3)";
        String s2 = "insert into mahasiswa values('"+txtNIM.getText()+"','"+jText2.getText()+"','')";
        int dialog = JOptionPane.showConfirmDialog(null, "Anda Yakin?", "",JOptionPane.YES_NO_OPTION);
        if (dialog == JOptionPane.YES_OPTION){
            db.query(s1);
            db.query(s2);
            txtNIM.setText("");
            jText2.setText("");
            javax.swing.JOptionPane.showMessageDialog(null, "Data Berhasil Dismpan");
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        inputMhs.setVisible(false);
        MENU_Admin.setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Aplikasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aplikasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aplikasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aplikasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aplikasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LOGIN;
    public javax.swing.JPanel MENU_Admin;
    public javax.swing.JPanel MENU_DsnB;
    public javax.swing.JPanel MENU_DsnS;
    public javax.swing.JPanel MENU_Mhs;
    private javax.swing.JTable Tampil;
    private javax.swing.JTable Tampil1;
    private javax.swing.JComboBox boxBln;
    private javax.swing.JComboBox boxBln1;
    private javax.swing.JComboBox boxBln2;
    private javax.swing.JComboBox boxJam;
    private javax.swing.JComboBox boxJam1;
    private javax.swing.JComboBox boxJam2;
    private javax.swing.JComboBox boxTgl;
    private javax.swing.JComboBox boxTgl1;
    private javax.swing.JComboBox boxTgl2;
    private javax.swing.JComboBox boxThn;
    private javax.swing.JComboBox boxThn1;
    private javax.swing.JComboBox boxThn2;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnSubmit1;
    private javax.swing.JButton btnSubmit2;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btnView2;
    private javax.swing.JButton btnViewAll;
    public javax.swing.JPanel editJadwalS;
    public javax.swing.JPanel inputDsn;
    public javax.swing.JPanel inputJadwalB;
    public javax.swing.JPanel inputJadwalS;
    public javax.swing.JPanel inputJudul;
    public javax.swing.JPanel inputMhs;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jText1;
    private javax.swing.JTextField jText2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    public javax.swing.JPanel jadwal;
    public javax.swing.JLabel labelDsnB;
    public javax.swing.JLabel labelDsnB1;
    public javax.swing.JLabel labelDsnS;
    public javax.swing.JLabel labelDsnS1;
    public javax.swing.JLabel labelJudul;
    public javax.swing.JLabel labelNIM;
    public javax.swing.JLabel labelNIM1;
    private javax.swing.JTable tTampil;
    private javax.swing.JTable tblB;
    private javax.swing.JTable tblB1;
    private javax.swing.JTable tblS;
    private javax.swing.JTable tblS1;
    private javax.swing.JButton tblmasuk;
    private javax.swing.JTextField txtHari;
    private javax.swing.JTextField txtHari1;
    private javax.swing.JTextField txtHari2;
    private javax.swing.JTextField txtID;
    public javax.swing.JTextField txtID1;
    private javax.swing.JTextField txtID2;
    private javax.swing.JTextField txtJudul;
    private javax.swing.JTextField txtNIM;
    private javax.swing.JTextField txtNIM1;
    private javax.swing.JTextField txtNIM2;
    public javax.swing.JTextField txtNIM3;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtPguji;
    private javax.swing.JTextField txtRuang;
    private javax.swing.JTextField txtRuang1;
    private javax.swing.JTextField txtRuang2;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    public javax.swing.JPanel utama;
    public javax.swing.JPanel viewData;
    public javax.swing.JPanel viewJadwalAdm;
    public javax.swing.JPanel viewJadwalB;
    public javax.swing.JPanel viewJadwalMhs;
    public javax.swing.JPanel viewJadwalS;
    // End of variables declaration//GEN-END:variables

    void setId_admin(String a, String b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
