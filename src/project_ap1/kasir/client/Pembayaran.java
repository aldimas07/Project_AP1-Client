/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_ap1.kasir.client;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rjial
 */
public class Pembayaran extends javax.swing.JFrame {
    private Connection con  = ConfigDB.ambil_koneksi();
    public HashMap<String, Menu> daftarPilih;
    public List<Menu> listMenuSelected;
    private Menu mnuSel;
    private int totalPesan;
    private HashMap<String, Integer> mapBayar = new HashMap<>();

    public void setDaftarPilih(HashMap<String, Menu> daftarPilih) {
        this.daftarPilih = daftarPilih;
    }

    public void setListMenuSelected(List<Menu> daftarMenu) {
        this.listMenuSelected = daftarMenu;
    }

    public void setTotalPesan(int totalPesan) {
        this.totalPesan = totalPesan;
    }

    /**
     * Creates new form Pembayaran
     */
    public Pembayaran() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_ap1/kasir/client/gambar/.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_ap1/kasir/client/PEMBAYARAN.png"))); // NOI18N

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(138, 138, 138)
                        .addComponent(jLabel2)
                        .addGap(0, 157, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(499, 661));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        PreparedStatement stmtBayar;
        DefaultListModel modelList = new DefaultListModel();
        mapBayar.clear();
        try {
            stmtBayar = con.prepareStatement("select * from pembayaran");
            ResultSet rslt = stmtBayar.executeQuery();
            while(rslt.next()) {
//                jPanel1.add(new PembayaranButton(rslt.getInt("ID_PEMBAYARAN"), rslt.getString("NAMA"), this));
                modelList.addElement(rslt.getString("NAMA"));
                mapBayar.put(rslt.getString("NAMA"), rslt.getInt("ID_PEMBAYARAN"));
            }
            jList1.setModel(modelList);
        } catch (SQLException ex) {
            Logger.getLogger(Pembayaran.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_formComponentShown

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            
            ProsesPesan prosesPesan = new ProsesPesan();
            prosesPesan.setDaftarPilih(daftarPilih);
            prosesPesan.setListMenuSelected(listMenuSelected);
            prosesPesan.setTotalPesan(totalPesan);
            prosesPesan.setIdPembayaran(mapBayar.get(jList1.getSelectedValue().toString()));
            prosesPesan.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jList1MouseClicked

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
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pembayaran().setVisible(true);
            }
        });
    }
    
    public class PembayaranButton extends JButton{
        private int idPembayaran;
        public PembayaranButton(int idPembayaran, String namaPembayaran, JFrame com) {
            this.idPembayaran = idPembayaran;
            this.setText(namaPembayaran);
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    System.out.println(idPembayaran);
                    action(e, idPembayaran, com);
                }
            });
        }
        public void action(ActionEvent e, int idPem, JFrame com) {
            ProsesPesan prosesPesan = new ProsesPesan();
            prosesPesan.setDaftarPilih(daftarPilih);
            prosesPesan.setListMenuSelected(listMenuSelected);
            prosesPesan.setTotalPesan(totalPesan);
            prosesPesan.setIdPembayaran(idPembayaran);
            prosesPesan.setVisible(true);
            com.dispose();
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
