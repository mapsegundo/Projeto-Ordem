/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.telas;

import javax.swing.JOptionPane;

/**
 *
 * @author Shall
 */
public class FrmMenu extends javax.swing.JFrame {

    //Criando objetos
    FrmUsuarios telaUsuarios = new FrmUsuarios();
    FrmClientes telaClientes = new FrmClientes();
    FrmServicos telaServicos = new FrmServicos();
    FrmOrdemServico telaOS = new FrmOrdemServico();
    
    
    public FrmMenu() {
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
        jMenuBar1 = new javax.swing.JMenuBar();
        menuUsuarios = new javax.swing.JMenu();
        menuControleUsuarios = new javax.swing.JMenuItem();
        menuClientes = new javax.swing.JMenu();
        menuControleClientes = new javax.swing.JMenuItem();
        menuServicos = new javax.swing.JMenu();
        menuControleServicos = new javax.swing.JMenuItem();
        menuOS = new javax.swing.JMenu();
        menuControleOS = new javax.swing.JMenuItem();
        menuConfiguracoes = new javax.swing.JMenu();
        menuSobre = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem de Ordem de Serviços");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/imagens/planoDeFundo.jpg"))); // NOI18N

        menuUsuarios.setText("Usuários");
        menuUsuarios.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        menuUsuarios.setMargin(new java.awt.Insets(0, 0, 0, 15));

        menuControleUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/imagens/controleUsuarios.png"))); // NOI18N
        menuControleUsuarios.setText("Controle de Usuários");
        menuControleUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuControleUsuariosActionPerformed(evt);
            }
        });
        menuUsuarios.add(menuControleUsuarios);

        jMenuBar1.add(menuUsuarios);

        menuClientes.setText("Clientes");
        menuClientes.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        menuClientes.setMargin(new java.awt.Insets(0, 0, 0, 15));

        menuControleClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/imagens/controleClientes.png"))); // NOI18N
        menuControleClientes.setText("Controle de Clientes");
        menuControleClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuControleClientesActionPerformed(evt);
            }
        });
        menuClientes.add(menuControleClientes);

        jMenuBar1.add(menuClientes);

        menuServicos.setText("Serviços");
        menuServicos.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        menuServicos.setMargin(new java.awt.Insets(0, 0, 0, 15));

        menuControleServicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/imagens/controleServicos.png"))); // NOI18N
        menuControleServicos.setText("Controle de Serviços");
        menuControleServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuControleServicosActionPerformed(evt);
            }
        });
        menuServicos.add(menuControleServicos);

        jMenuBar1.add(menuServicos);

        menuOS.setText("Ordem de Serviços");
        menuOS.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        menuOS.setMargin(new java.awt.Insets(0, 0, 0, 15));

        menuControleOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/imagens/controleOS.png"))); // NOI18N
        menuControleOS.setText("Controle de Ordem de Serviços");
        menuControleOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuControleOSActionPerformed(evt);
            }
        });
        menuOS.add(menuControleOS);

        jMenuBar1.add(menuOS);

        menuConfiguracoes.setText("Configurações");
        menuConfiguracoes.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        menuConfiguracoes.setMargin(new java.awt.Insets(0, 0, 0, 15));

        menuSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/imagens/menuSobre.png"))); // NOI18N
        menuSobre.setText("Sobre");
        menuConfiguracoes.add(menuSobre);

        menuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/imagens/menuSair.png"))); // NOI18N
        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        menuConfiguracoes.add(menuSair);

        jMenuBar1.add(menuConfiguracoes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1044, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuControleUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuControleUsuariosActionPerformed
        // Acao do menu controle de usuarios
        //Se a tela estiver aberta
        if(telaUsuarios.isVisible()){
            //Chame a tela ja aberta
            telaUsuarios.toFront();
        } else{
            telaUsuarios.setVisible(true);
        }
    }//GEN-LAST:event_menuControleUsuariosActionPerformed

    private void menuControleClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuControleClientesActionPerformed
        if(telaClientes.isVisible()){
            //Chame a tela ja aberta
            telaClientes.toFront();
        } else{
            telaClientes.setVisible(true);
        }
    }//GEN-LAST:event_menuControleClientesActionPerformed

    private void menuControleOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuControleOSActionPerformed
        if(telaOS.isVisible()){
            //Chame a tela ja aberta
            telaOS.toFront();
        } else{
            telaOS.setVisible(true);
        }
    }//GEN-LAST:event_menuControleOSActionPerformed

    private void menuControleServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuControleServicosActionPerformed
        if(telaServicos.isVisible()){
            //Chame a tela ja aberta
            telaServicos.toFront();
        } else{
            telaServicos.setVisible(true);
        }
    }//GEN-LAST:event_menuControleServicosActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        // Fecha a janela
        int op;
            //tela de operação de escolha
            op = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Sair do Sistema", 0);
            if(op == 0){
                System.exit(0);
            }
    }//GEN-LAST:event_menuSairActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenu menuClientes;
    private javax.swing.JMenu menuConfiguracoes;
    private javax.swing.JMenuItem menuControleClientes;
    private javax.swing.JMenuItem menuControleOS;
    private javax.swing.JMenuItem menuControleServicos;
    private javax.swing.JMenuItem menuControleUsuarios;
    private javax.swing.JMenu menuOS;
    private javax.swing.JMenuItem menuSair;
    public javax.swing.JMenu menuServicos;
    private javax.swing.JMenuItem menuSobre;
    public javax.swing.JMenu menuUsuarios;
    // End of variables declaration//GEN-END:variables
}
