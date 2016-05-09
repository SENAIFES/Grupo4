/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.TarefaDAO;
import entity.Tarefa;
import entity.TarefaTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.text.html.parser.DTDConstants;

/**
 *
 * @author diego_rosa_luiz
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private Tarefa tarefa;
    private List<Tarefa> listaTarefas = new ArrayList<Tarefa>();

    public TelaPrincipal() {
        initComponents();
        carregarTabela();
    }

    private void mostrarTarefas(List<Tarefa> listaTarefa) {
        TarefaDAO dao = new TarefaDAO();
        DefaultListModel modelo = new DefaultListModel();
        for (Tarefa Tarefas : dao.listarTodos()) {
            modelo.addElement(Tarefas);

        }
        tbTarefa.setModel((TableModel) modelo);
    }

    private void carregarTabela() {
        TarefaDAO tdao = new TarefaDAO();
        TarefaTableModel tarefamodel = new TarefaTableModel();
        listaTarefas = tdao.listarTodos();
        tarefamodel.setLista(listaTarefas);
        tbTarefa.setModel(tarefamodel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTarefa = new javax.swing.JTable();
        ckbMostrarConcluidos = new javax.swing.JCheckBox();
        rbTodos = new javax.swing.JRadioButton();
        rboje = new javax.swing.JRadioButton();
        rbSemana = new javax.swing.JRadioButton();
        rbMes = new javax.swing.JRadioButton();
        btnFeito = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de tarefas");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tarefas"));

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        tbTarefa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Descrição", "Prazo", "Feito"
            }
        ));
        jScrollPane1.setViewportView(tbTarefa);

        ckbMostrarConcluidos.setText("Mostrar Concluidos");

        buttonGroup1.add(rbTodos);
        rbTodos.setText("Todos");

        buttonGroup1.add(rboje);
        rboje.setSelected(true);
        rboje.setText("Hoje");
        rboje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbojeActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbSemana);
        rbSemana.setText("Semana");

        buttonGroup1.add(rbMes);
        rbMes.setText("Mês");

        btnFeito.setText("Feito");
        btnFeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeitoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFeito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rboje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbSemana)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbMes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbTodos)
                        .addGap(31, 31, 31)
                        .addComponent(ckbMostrarConcluidos))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdicionar, btnAlterar, btnExcluir});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rboje)
                    .addComponent(rbSemana)
                    .addComponent(rbMes)
                    .addComponent(rbTodos)
                    .addComponent(ckbMostrarConcluidos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnFeito))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Lista de Tarefas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbojeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbojeActionPerformed
        carregarTabela();
    }//GEN-LAST:event_rbojeActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
              TarefaTableModel model = (TarefaTableModel) tbTarefa.getModel();
            tarefa = model.getTarefa(tbTarefa.getSelectedRow());
        TelaAdicionarTarefa tela = new TelaAdicionarTarefa(this, rootPaneCheckingEnabled, tarefa);

        carregarTabela();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
            TarefaTableModel model = (TarefaTableModel) tbTarefa.getModel();
            tarefa = model.getTarefa(tbTarefa.getSelectedRow());
        int resposta = JOptionPane.showConfirmDialog(this, "\n" + "Voce deseja excluir a Tarefa "
                + tarefa.getDescricao() + " ? ", " Excluir ", 0);
        if (resposta == 0) {
            TarefaDAO dao = new TarefaDAO();

            if (dao.delete(tarefa.getId())) {
                JOptionPane.showMessageDialog(this, " Excluido ! ");
                carregarTabela();
            }
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        TelaAdicionarTarefa te = new TelaAdicionarTarefa(this, rootPaneCheckingEnabled);
        carregarTabela();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnFeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeitoActionPerformed
        TarefaTableModel tbmodel = (TarefaTableModel) tbTarefa.getModel();
        Tarefa t = tbmodel.getTarefa(tbTarefa.getSelectedRow());
        if (t.isFeito()) {
            t.setFeito(false);
        } else {
            t.setFeito(true);
        }
        TarefaDAO tdao = new TarefaDAO();
        tdao.salvar(t);
        carregarTabela();
    }//GEN-LAST:event_btnFeitoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFeito;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox ckbMostrarConcluidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbMes;
    private javax.swing.JRadioButton rbSemana;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JRadioButton rboje;
    private javax.swing.JTable tbTarefa;
    // End of variables declaration//GEN-END:variables
}
