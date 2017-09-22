
package telas;

import apoio.Formatacao;
import entidades.Cidade;
import gestores.GestorCidade;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class FrmCidade extends javax.swing.JFrame {

    GestorCidade gestorcidade;
    int cod = 0;
    
    public FrmCidade() {
        initComponents();
        this.setResizable(false);
        this.setTitle("Cidade");
        this.setLocationRelativeTo(null);
        gestorcidade = new GestorCidade();
        gestorcidade.popularTabela(tblCidades, "");
        txtCidCodigo.setText(gestorcidade.proximoCod() + "");
        txtCidCodigo.setEnabled(false);
        txtCidDescricao.requestFocus();
        Formatacao.reformatarCEP(txtCidCep);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCidCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCidDescricao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCidCep = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCidUf = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        txtPesquisarDescricao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCidades = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jLabel2.setText("Código:");

        txtCidCodigo.setFocusable(false);

        jLabel3.setText("Descrição:");

        txtCidDescricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCidDescricaoFocusLost(evt);
            }
        });

        jLabel4.setText("CEP:");

        txtCidCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCidCepFocusLost(evt);
            }
        });

        jLabel5.setText("UF:");

        txtCidUf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCidUfFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCidCep, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtCidUf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCidDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(158, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCidCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCidDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtCidUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtCidCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(172, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manutenção", jPanel1);

        jLabel1.setText("Descrição:");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setPreferredSize(new java.awt.Dimension(95, 23));
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tblCidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblCidades);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPesquisarDescricao)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisarDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consulta", jPanel2);

        btnCancelar.setText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(95, 23));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnConfirmar.setText("Confirmar");
        btnConfirmar.setPreferredSize(new java.awt.Dimension(95, 23));
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.setPreferredSize(new java.awt.Dimension(95, 23));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setPreferredSize(new java.awt.Dimension(95, 23));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if(ehFormularioValido()){
            Cidade cidade = new Cidade();
            cidade.setCodigo(cod);
            cidade.setDescricao(txtCidDescricao.getText().toUpperCase());
            cidade.setCep(Formatacao.removerFormatacao(txtCidCep.getText()));
            cidade.setUf(txtCidUf.getText().toUpperCase());

            String retorno = null;
            if (cod == 0) {
                retorno = gestorcidade.salvar(cidade);
            } else {
                retorno = gestorcidade.atualizar(cidade);
            }
            if (retorno == null){
                JOptionPane.showMessageDialog(this, "Salvo com sucesso.");
                gestorcidade.popularTabela(tblCidades, "");
                txtCidCodigo.setText("");
                txtCidDescricao.setText("");
                txtCidCep.setText("");
                txtCidUf.setText("");
                txtCidDescricao.requestFocus();
                cod = 0;
                txtCidCodigo.setText(gestorcidade.proximoCod() + "");
            } else {
                JOptionPane.showMessageDialog(this, "Problemas ao salvar.\n"
                                                  + "\n"
                                                  + "Informações: " + retorno);
            }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        gestorcidade.popularTabela(tblCidades, txtPesquisarDescricao.getText());
        txtPesquisarDescricao.requestFocus();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        cod = Integer.parseInt(String.valueOf(tblCidades.getValueAt(tblCidades.getSelectedRow(), 0)));
        Cidade cidade = (Cidade) gestorcidade.consultarCod(cod);
        
        if (cidade != null){
            txtCidCodigo.setText(String.valueOf(cidade.getCodigo()));
            txtCidDescricao.setText(cidade.getDescricao());
            txtCidCep.setText(cidade.getCep());
            txtCidUf.setText(cidade.getUf());
            jTabbedPane1.setSelectedIndex(0);
            txtCidDescricao.requestFocus();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        if(jTabbedPane1.getSelectedIndex() == 1){
            btnEditar.setEnabled(true);
            btnExcluir.setEnabled(true);
            btnConfirmar.setEnabled(false);
        } else {
            btnEditar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnConfirmar.setEnabled(true);
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Confirmação de exclusão", JOptionPane.YES_NO_OPTION);
        if (resposta == 0) {

            int id = Integer.parseInt(String.valueOf(tblCidades.getValueAt(tblCidades.getSelectedRow(), 0)));
            String retorno = gestorcidade.excluir(id);

            if (retorno == null) {
                JOptionPane.showMessageDialog(this, "Registro excluído!");
                gestorcidade.popularTabela(tblCidades, "");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir:\n"
                        + "\n"
                        + "Mensagem técnica:\n" + retorno);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtCidDescricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCidDescricaoFocusLost
        if(!txtCidDescricao.getText().isEmpty()){
            txtCidDescricao.setBorder(new LineBorder(Color.LIGHT_GRAY));
        }
    }//GEN-LAST:event_txtCidDescricaoFocusLost

    private void txtCidCepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCidCepFocusLost
        if(!txtCidCep.getText().isEmpty()){
            txtCidCep.setBorder(new LineBorder(Color.LIGHT_GRAY));
        }
    }//GEN-LAST:event_txtCidCepFocusLost

    private void txtCidUfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCidUfFocusLost
        if(!txtCidUf.getText().isEmpty()){
            txtCidUf.setBorder(new LineBorder(Color.LIGHT_GRAY));
        }
    }//GEN-LAST:event_txtCidUfFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblCidades;
    private javax.swing.JFormattedTextField txtCidCep;
    private javax.swing.JTextField txtCidCodigo;
    private javax.swing.JTextField txtCidDescricao;
    private javax.swing.JTextField txtCidUf;
    private javax.swing.JTextField txtPesquisarDescricao;
    // End of variables declaration//GEN-END:variables

    private boolean ehFormularioValido(){
        boolean valido = true;
        String mensagem = "Os campos a seguir estão preenchidos de forma incorreta: ";
        if(txtCidDescricao.getText().trim().isEmpty()){
            valido = false;
            txtCidDescricao.setBorder(new LineBorder(Color.RED));
            mensagem = mensagem + "\n Descrição";
        }
        if(Formatacao.removerFormatacao(txtCidCep.getText()).trim().isEmpty()){
            valido = false;
            txtCidCep.setBorder(new LineBorder(Color.RED));
            mensagem = mensagem + "\n CEP";
        }
        if(txtCidUf.getText().trim().isEmpty()){
            valido = false;
            txtCidUf.setBorder(new LineBorder(Color.RED));
            mensagem = mensagem + "\n UF";
        }
        if(!valido){
            JOptionPane.showMessageDialog(this, mensagem);
        }
        txtCidDescricao.requestFocus();
        return valido;
    }

}
