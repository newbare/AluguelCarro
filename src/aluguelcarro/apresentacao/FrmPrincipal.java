/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aluguelcarro.apresentacao;

import aluguelcarro.models.Aluguel;
import aluguelcarro.models.Carro;
import aluguelcarro.negocios.CadastroAluguel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author eriss_000
 */
public class FrmPrincipal extends javax.swing.JFrame {
    
    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        CadastroAluguel cadAluguel = new CadastroAluguel();
     
         
        String[] nomeColunas = {"Id", "Modelo","Fabricante", "Ano","Situacao", "Dt. Inicio","Dt. Fim"};  
        List<String[]> lista = new ArrayList<>();  
        ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();
        ArrayList<Carro> carros = new ArrayList<Carro>();
        carros = cadAluguel.getListaCarros();
        alugueis = cadAluguel.getListaAlugueis();
        for(Aluguel al: alugueis){
            lista.add(new String[]{
                        String.valueOf(al.getCarro().getId()),
                        al.getCarro().getModelo(),
                        al.getCarro().getFabricante(),
                        String.valueOf(al.getCarro().getAno()),
                        "Alugado",
                        al.getDtInicio(),
                        al.getDtFim()
                                   }
            );
        }
        
        for(Carro car: carros){
            boolean aux = true;
            for(Aluguel al2: alugueis){
                if(car.getId() == al2.getCarro().getId()){
                    aux = false;
                }
            }
            if(aux){
                lista.add(new String[]{
                            String.valueOf(car.getId()),
                            car.getModelo(),
                            car.getFabricante(),
                            String.valueOf(car.getAno()),
                            "Disponivel",
                            " - ",
                            " - "
                                       }
                );
            }
        }
        
       
       DefaultTableModel model = new DefaultTableModel(
        lista.toArray(new String[lista.size()][]), nomeColunas);
       
  
        tabSitCarros.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        btnCadCliente = new javax.swing.JButton();
        btnCadCarro = new javax.swing.JButton();
        btnAlugarCarro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabSitCarros = new javax.swing.JTable();
        btnConfig = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCadCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aluguelcarro.imagens/novo-cliente.png"))); // NOI18N
        btnCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadClienteActionPerformed(evt);
            }
        });

        btnCadCarro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aluguelcarro.imagens/novo-carro.png"))); // NOI18N
        btnCadCarro.setToolTipText("");
        btnCadCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadCarroActionPerformed(evt);
            }
        });

        btnAlugarCarro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aluguelcarro.imagens/alugar.png"))); // NOI18N
        btnAlugarCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarCarroActionPerformed(evt);
            }
        });

        tabSitCarros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Modelo", "Fabricante", "Ano", "Situacao", "Dt. Inicio", "Dt. Fim"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabSitCarros);

        btnConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aluguelcarro.imagens/config.png"))); // NOI18N
        btnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnCadCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAlugarCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlugarCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadCarroActionPerformed
        FrmCadCarro frmCadCarro = new FrmCadCarro();
        frmCadCarro.setLocationRelativeTo(frmCadCarro); 
        frmCadCarro.setVisible(true); 
    }//GEN-LAST:event_btnCadCarroActionPerformed

    private void btnCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadClienteActionPerformed
        FrmCadCliente frmCadCliente = new FrmCadCliente();
        frmCadCliente.setLocationRelativeTo(frmCadCliente); 
        frmCadCliente.setVisible(true);
    }//GEN-LAST:event_btnCadClienteActionPerformed

    private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed
        FrmConfig frmConfig = new FrmConfig();
        frmConfig.setLocationRelativeTo(frmConfig);
        frmConfig.setVisible(true); 
    }//GEN-LAST:event_btnConfigActionPerformed

    private void btnAlugarCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarCarroActionPerformed
        FrmAluguelCarro frmAluguel = new FrmAluguelCarro();
        frmAluguel.setLocationRelativeTo(frmAluguel);
        frmAluguel.setVisible(true); 
    }//GEN-LAST:event_btnAlugarCarroActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlugarCarro;
    private javax.swing.JButton btnCadCarro;
    private javax.swing.JButton btnCadCliente;
    private javax.swing.JButton btnConfig;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabSitCarros;
    // End of variables declaration//GEN-END:variables
}
