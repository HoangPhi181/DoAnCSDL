/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gd_hotel.QLKS;

import com.hotel.dao.ChiTietDatPhongDAO;
import com.hotel.dao.DatPhongDAO;
import com.hotel.dao.LoaiPhongDAO;
import com.hotel.dao.PhongDAO;
import com.hotel.database.DatabaseConnection;
import com.hotel.model.ChiTietDatPhong;
import com.hotel.model.DatPhong;
import com.hotel.model.LoaiPhong;
import com.hotel.model.Phong;
import gd_hotel.MANAGER_PAGE;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HOANG PHI
 */
public class DatPhong_Form extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DatPhong_Form.class.getName());

    /**
     * Creates new form DatPhong_Form
     */
    public DatPhong_Form() {
        initComponents();
        
        try (Connection conn = DatabaseConnection.getConnection()) {
            DefaultTableModel model = (DefaultTableModel) tbShowDP.getModel();
            DatPhongDAO DPD = new DatPhongDAO();
            List <DatPhong> LDP = DPD.getAll();
            
            for(DatPhong dp : LDP){
                model.addRow(new Object[] {
                    dp.getMaDP(),
                    dp.getMaKH(),
                    dp.getMaNV(),
                    dp.getNgayDat(),
                    dp.getNgayNhan(),
                    dp.getNgayTra(),
                    dp.getTrangThai()
                });
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu: " + ex.getMessage());
        }
        
        
        try (Connection conn = DatabaseConnection.getConnection()) {
            DefaultTableModel model = (DefaultTableModel) tbShowCTDP.getModel();
            ChiTietDatPhongDAO CTDPD = new ChiTietDatPhongDAO();
            List <ChiTietDatPhong> LCTDP = CTDPD.getAll();
            
            for(ChiTietDatPhong ctdp : LCTDP){
                model.addRow(new Object[] {
                    ctdp.getMaDP(),
                    ctdp.getMaPhong(),
                    ctdp.getGiaDP()
                });
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu: " + ex.getMessage());
        }
        
        try (Connection conn = DatabaseConnection.getConnection()) {
            DefaultTableModel model = (DefaultTableModel) tbShowPhong.getModel();
            PhongDAO PD = new PhongDAO();
            List <Phong> LP = PD.getAll();
            
            for(Phong p : LP){
                model.addRow(new Object[] {     
                    p.getMaPhong(),
                    p.getSoPhong(),
                    p.getTang(),
                    p.getTrangThai(),
                    p.getMaLP(),
                    p.getMaNVQL()
                });
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu: " + ex.getMessage());
        }
                
        try (Connection conn = DatabaseConnection.getConnection()) {
            DefaultTableModel model = (DefaultTableModel) tbShowLP.getModel();
            LoaiPhongDAO LPD = new LoaiPhongDAO();
            List <LoaiPhong> LLP = LPD.getAll();
            
            for(LoaiPhong lp : LLP){
                model.addRow(new Object[] {
                    lp.getMaLP(),
                    lp.getTenLP(),
                    lp.getGiaLP(),
                    lp.getSucChua(),
                    lp.getMoTa()
                });
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu: " + ex.getMessage());
        }
        
        
        
//        setTitle("Auto Resizable Layout");
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLayout(new BorderLayout());
//
//        JPanel center = new JPanel(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//
//        gbc.fill = GridBagConstraints.BOTH;
//        gbc.weightx = 1;
//        gbc.weighty = 1;
//
//
//        setExtendedState(MAXIMIZED_BOTH); // tự full và chỉnh theo màn hình
        

        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Ẩn cửa sổ hiện tại
                DatPhong_Form.this.setVisible(false);

                // Mở MANAGER_PAGE
                java.awt.EventQueue.invokeLater(() -> new MANAGER_PAGE().setVisible(true));
            }
        });
        
    }
    
    int check = 0;
    
    private void loadEmptyTable(int selected) {
        DefaultTableModel model = (DefaultTableModel) tbAdd.getModel();
        model.setRowCount(0); // Xóa bảng cũ

        switch (selected) {
            case 1 -> {
                model.setColumnIdentifiers(new String[]{"Mã DP", "Mã KH", "Mã NV", "Ngày Đặt", "Ngày Nhận", "Ngày Trả", "Trạng Thái"});
                check = 1;
            }
            case 2 -> {
                model.setColumnIdentifiers(new String[]{"Mã DP", "Mã Phòng", "Giá DP"});
                check = 2;
            }
            case 3 -> {
                model.setColumnIdentifiers(new String[]{"Mã Phòng", "Số Phòng", "Tầng", "Trạng Thái", "Mã LP", "Mã NVQL"});
                check = 3;
            }
            case 4 -> {
                model.setColumnIdentifiers(new String[]{"Mã LP", "Tên LP", "Giá LP", "Sức Chứa", "Mô Tả"});
                check = 4;
            }
        }

        // Thêm 1 dòng trống để nhập dữ liệu
        model.addRow(new Object[model.getColumnCount()]);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbShowDP = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbShowCTDP = new javax.swing.JTable();
        btnAdd1 = new javax.swing.JButton();
        btnUpdate1 = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        btnFind1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbShowPhong = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbShowLP = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbAdd = new javax.swing.JTable();
        btnChon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbShowDP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã DP", "Mã KH", "Mã NV", "Ngày Đặt", "Ngày Nhận", "Ngày Trả", "Trạng Thái"
            }
        ));
        tbShowDP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbShowDPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbShowDP);

        tbShowCTDP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã DP", "Mã Phòng", "Giá DP"
            }
        ));
        tbShowCTDP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbShowCTDPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbShowCTDP);

        btnAdd1.setText("Thêm");
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });

        btnUpdate1.setText("Sửa");
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });

        btnDelete1.setText("Xóa");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        btnFind1.setText("TÌm");
        btnFind1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFind1ActionPerformed(evt);
            }
        });

        tbShowPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phòng", "Số Phòng", "Tầng", "Trạng Thái", "Mã LP", "Mã NVQL"
            }
        ));
        tbShowPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbShowPhongMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbShowPhong);

        tbShowLP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã LP", "Tên LP", "Giá LP", "Sức Chứa", "Mô Tả"
            }
        ));
        tbShowLP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbShowLPMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbShowLP);

        tbAdd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tbAdd);

        btnChon.setText("Chọn");
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnChon)
                        .addGap(0, 42, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1077, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(btnAdd1)
                        .addGap(67, 67, 67)
                        .addComponent(btnUpdate1)
                        .addGap(67, 67, 67)
                        .addComponent(btnDelete1)
                        .addGap(67, 67, 67)
                        .addComponent(btnFind1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnChon)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd1)
                    .addComponent(btnUpdate1)
                    .addComponent(btnDelete1)
                    .addComponent(btnFind1))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed

        DatPhongDAO DPD = new DatPhongDAO();
        ChiTietDatPhongDAO CTDPD = new ChiTietDatPhongDAO();
        PhongDAO PD = new PhongDAO();
        LoaiPhongDAO LPD = new LoaiPhongDAO();
        
        DefaultTableModel modelAdd = (DefaultTableModel) tbAdd.getModel();
        
        DefaultTableModel modelShowDP = (DefaultTableModel) tbShowDP.getModel();
        DefaultTableModel modelShowCTDP = (DefaultTableModel) tbShowCTDP.getModel();
        DefaultTableModel modelShowPhong = (DefaultTableModel) tbShowPhong.getModel();
        DefaultTableModel modelShowLP = (DefaultTableModel) tbShowLP.getModel();
        
        
        switch (check){
            case 1 -> {
                String maDP = modelAdd.getValueAt(0, 0).toString().trim();
                String maKH = modelAdd.getValueAt(0, 1).toString().trim();
                String maNV = modelAdd.getValueAt(0, 2).toString().trim();
                String ngayDat = modelAdd.getValueAt(0, 3).toString();
                String ngayNhan = modelAdd.getValueAt(0, 4).toString();
                String ngayTra = modelAdd.getValueAt(0, 5).toString();
                String trangThai = modelAdd.getValueAt(0, 6).toString();
        
            }
            case 2 -> {
                String maDP = modelAdd.getValueAt(0, 0).toString().trim();
                String maPhong = modelAdd.getValueAt(0, 1).toString().trim();
                String giaDP = modelAdd.getValueAt(0, 2).toString().trim();
            }
            case 3 -> {
                String maPhong = modelAdd.getValueAt(0, 0).toString();
                String soPhong = modelAdd.getValueAt(0, 1).toString().trim();
                String tang = modelAdd.getValueAt(0, 2).toString();
                String trangThai = modelAdd.getValueAt(0, 3).toString();
                String maLP = modelAdd.getValueAt(0, 4).toString();
                String maNVQL = modelAdd.getValueAt(0, 5).toString();

            }
            case 4 -> {
                String maLP = modelAdd.getValueAt(0, 0).toString();
                String tenLP = modelAdd.getValueAt(0, 1).toString().trim();
                String giaLP = modelAdd.getValueAt(0, 2).toString();
                String sucChua = modelAdd.getValueAt(0, 3).toString();
                String moTa = modelAdd.getValueAt(0, 4).toString();

            }
        }
        
        
//        String maHD = modelAdd.getValueAt(0, 0).toString();
//        String ngayLapStr = modelAdd.getValueAt(0, 1).toString().trim();
//        String maNV = modelAdd.getValueAt(0, 2).toString();
//        String maDP = modelAdd.getValueAt(0, 3).toString();
//        
//        java.sql.Date ngayLaptmp = java.sql.Date.valueOf(ngayLapStr);
//        //Timestamp ngayLaptmp = Timestamp.valueOf(ngayLapStr + " 00:00:00");
//
//        modelShow.addRow(new Object[]{
//            maHD,
//            ngayLaptmp,
//            maNV,
//            maDP
//        });
//
//        HoaDon HD = new HoaDon();
//        HD.setMaHD(maHD);
//        HD.setNgayLap(ngayLaptmp);
//        HD.setMaNV(maNV);
//        HD.setMaDP(maDP);
//        
//        if (HDD.insert(HD)) {
//            JOptionPane.showMessageDialog(this, "Thêm thành công!");
//        } else {
//            JOptionPane.showMessageDialog(this, "Lỗi khi thêm!");
//        }
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdate1ActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnFind1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFind1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFind1ActionPerformed

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        JPopupMenu pop = new JPopupMenu();

        JMenuItem m1 = new JMenuItem("Bảng 1");
        JMenuItem m2 = new JMenuItem("Bảng 2");
        JMenuItem m3 = new JMenuItem("Bảng 3");
        JMenuItem m4 = new JMenuItem("Bảng 4");

        // Gắn các sự kiện chọn bảng
        m1.addActionListener(e -> loadEmptyTable(1));
        m2.addActionListener(e -> loadEmptyTable(2));
        m3.addActionListener(e -> loadEmptyTable(3));
        m4.addActionListener(e -> loadEmptyTable(4));

        pop.add(m1);
        pop.add(m2);
        pop.add(m3);
        pop.add(m4);

        // Hiện popup ngay dưới nút bấm
        pop.show(btnChon, 0, btnChon.getHeight());
    }//GEN-LAST:event_btnChonActionPerformed

    private void tbShowDPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbShowDPMouseClicked
        DefaultTableModel modelUpdate = (DefaultTableModel) tbAdd.getModel();
        
        int row = tbShowDP.getSelectedRow();
        
        if (row >= 0) {
            String maDP = tbShowDP.getValueAt(row, 0).toString();
            
            DatPhongDAO dao = new DatPhongDAO();
            List<DatPhong> list = (List<DatPhong>) dao.findById(maDP);

            DefaultTableModel model = (DefaultTableModel) tbShowDP.getModel();
            model.setRowCount(0);

            for (DatPhong dp : list) {
                model.addRow(new Object[]{
                    dp.getMaDP(),
                    dp.getMaKH(),
                    dp.getMaNV(),
                    dp.getNgayDat(),
                    dp.getNgayNhan(),
                    dp.getNgayTra(),
                    dp.getTrangThai()
                });
            }

            modelUpdate.setRowCount(0);
            modelUpdate.addRow(new Object[]{
                tbShowDP.getValueAt(row, 0),
                tbShowDP.getValueAt(row, 1),
                tbShowDP.getValueAt(row, 2),
                tbShowDP.getValueAt(row, 3),
                tbShowDP.getValueAt(row, 4),
                tbShowDP.getValueAt(row, 5),
                tbShowDP.getValueAt(row, 6)
            });
        }          
    }//GEN-LAST:event_tbShowDPMouseClicked

    private void tbShowCTDPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbShowCTDPMouseClicked
        
    }//GEN-LAST:event_tbShowCTDPMouseClicked

    private void tbShowPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbShowPhongMouseClicked
        
    }//GEN-LAST:event_tbShowPhongMouseClicked

    private void tbShowLPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbShowLPMouseClicked
        
    }//GEN-LAST:event_tbShowLPMouseClicked

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new DatPhong_Form().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnFind1;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tbAdd;
    private javax.swing.JTable tbShowCTDP;
    private javax.swing.JTable tbShowDP;
    private javax.swing.JTable tbShowLP;
    private javax.swing.JTable tbShowPhong;
    // End of variables declaration//GEN-END:variables
}
