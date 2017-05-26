
package telas;

import apoio.Formatacao;
import entidades.Cidade;
import entidades.Cliente;
import gestores.GestorCidade;
import gestores.GestorCliente;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class FrmClientes extends javax.swing.JFrame {

    GestorCliente gestorcliente = new GestorCliente();
    GestorCidade gestorcidade = new GestorCidade();
    int cod = 0;
    
    public FrmClientes() {
        initComponents();
        this.setResizable(false);
        this.setTitle("Cliente");
        this.setLocationRelativeTo(null);
        carregarCombo();
        limparTela();
        gestorcliente.popularTabela(tblClientes, "");
        txtCliCodigo.setText(gestorcliente.proximoCod() + "");
        txtCliCodigo.setEnabled(false);
        txtCliNome.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCliCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCliNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCliEndereco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCliBairro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbCidade = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnCidade = new javax.swing.JButton();
        txtCliTelefone = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jLabel2.setText("Código:");

        txtCliCodigo.setFocusable(false);

        jLabel3.setText("Nome:");

        txtCliNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCliNomeFocusLost(evt);
            }
        });

        jLabel4.setText("Endereço:");

        txtCliEndereco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCliEnderecoFocusLost(evt);
            }
        });

        jLabel5.setText("Bairro");

        txtCliBairro.setPreferredSize(new java.awt.Dimension(300, 20));
        txtCliBairro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCliBairroFocusLost(evt);
            }
        });

        jLabel6.setText("Cidade:");

        cmbCidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbCidadeFocusLost(evt);
            }
        });

        jLabel7.setText("Telefone:");

        btnCidade.setText("Cidade");
        btnCidade.setPreferredSize(new java.awt.Dimension(95, 23));
        btnCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCidadeActionPerformed(evt);
            }
        });

        txtCliTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCliTelefoneFocusLost(evt);
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
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCliBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCliCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCliTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCliNome)
                    .addComponent(txtCliEndereco))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCliCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCliEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCliBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cmbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCliTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(213, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manutenção", jPanel1);

        jLabel1.setText("Nome:");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setPreferredSize(new java.awt.Dimension(95, 23));
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Cidade", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPesquisar)
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
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
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

        jMenu1.setText("Relatórios");

        jMenuItem1.setText("Relatório de Clientes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCidadeActionPerformed
        FrmCidade frmCidade = new FrmCidade();
        frmCidade.setVisible(true);
    }//GEN-LAST:event_btnCidadeActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if(ehFormularioValido()){
            Cliente cliente = new Cliente();
            cliente.setCodigo(cod);
            cliente.setNome(txtCliNome.getText());
            cliente.setEndereco(txtCliEndereco.getText());
            cliente.setBairro(txtCliBairro.getText());
            cliente.setTelefone(txtCliTelefone.getText());
            cliente.setCidade((Cidade)cmbCidade.getSelectedItem());
 
            String retorno = null;
            if (cod == 0) {
                retorno = gestorcliente.salvar(cliente);
            } else {
                retorno = gestorcliente.atualizar(cliente);
            }
            if (retorno == null){
                JOptionPane.showMessageDialog(this, "Salvo com sucesso.");
                this.limparTela();
                cod = 0;
            } else {
                JOptionPane.showMessageDialog(this, "Problemas ao salvar.\n"
                                                  + "\n"
                                                  + "Informações: " + retorno);
            }    
        }    
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        gestorcliente.popularTabela(tblClientes, txtPesquisar.getText());
        txtPesquisar.requestFocus();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        cod = Integer.parseInt(String.valueOf(tblClientes.getValueAt(tblClientes.getSelectedRow(), 0)));
        Cliente cliente = (Cliente) gestorcliente.consultarCod(cod);
        
        if (cliente != null){
            txtCliCodigo.setText(String.valueOf(cliente.getCodigo()));
            txtCliNome.setText(cliente.getNome());
            txtCliEndereco.setText(cliente.getEndereco());
            txtCliBairro.setText(cliente.getBairro());
            txtCliTelefone.setText(cliente.getTelefone());
            for (int i = 0; i < cmbCidade.getItemCount(); ++i) {
                Cidade cidade = (Cidade) cmbCidade.getItemAt(i);
                if (cliente.getCidade().getCodigo() == cidade.getCodigo()) {
                   cmbCidade.setSelectedItem(cidade);
                   break;
                }
            }
            jTabbedPane1.setSelectedIndex(0);
            txtCliNome.requestFocus();
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
            int id = Integer.parseInt(String.valueOf(tblClientes.getValueAt(tblClientes.getSelectedRow(), 0)));
            String retorno = gestorcliente.excluir(id);

            if (retorno == null) {
                JOptionPane.showMessageDialog(this, "Registro excluído!");
                gestorcliente.popularTabela(tblClientes, "");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir:\n"
                        + "\n"
                        + "Mensagem técnica:\n" + retorno);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCliNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCliNomeFocusLost
        if(!txtCliNome.getText().isEmpty()){
            txtCliNome.setBorder(new LineBorder(Color.LIGHT_GRAY));
        }
    }//GEN-LAST:event_txtCliNomeFocusLost

    private void txtCliEnderecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCliEnderecoFocusLost
        if(!txtCliEndereco.getText().isEmpty()){
            txtCliEndereco.setBorder(new LineBorder(Color.LIGHT_GRAY));
        }
    }//GEN-LAST:event_txtCliEnderecoFocusLost

    private void txtCliBairroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCliBairroFocusLost
        if(!txtCliBairro.getText().isEmpty()){
            txtCliBairro.setBorder(new LineBorder(Color.LIGHT_GRAY));
        }
    }//GEN-LAST:event_txtCliBairroFocusLost

    private void cmbCidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbCidadeFocusLost
        if(!cmbCidade.getSelectedItem().toString().isEmpty()){
            cmbCidade.setBorder(new LineBorder(Color.LIGHT_GRAY));
        }
    }//GEN-LAST:event_cmbCidadeFocusLost

    private void txtCliTelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCliTelefoneFocusLost
        if(!txtCliTelefone.getText().isEmpty()){
            txtCliTelefone.setBorder(new LineBorder(Color.LIGHT_GRAY));
        }
    }//GEN-LAST:event_txtCliTelefoneFocusLost

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FrmRelatorioClientes frmrelatorioclientes = new FrmRelatorioClientes();
        frmrelatorioclientes.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCidade;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<Object> cmbCidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtCliBairro;
    private javax.swing.JTextField txtCliCodigo;
    private javax.swing.JTextField txtCliEndereco;
    private javax.swing.JTextField txtCliNome;
    private javax.swing.JFormattedTextField txtCliTelefone;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables

    private void carregarCombo() {
        Cidade cidade = new Cidade();
        ArrayList<Object> listacidades = new ArrayList<>();
        cidade.setCodigo(0);
        cidade.setDescricao("");
        listacidades = gestorcidade.consultarTodos();
        listacidades.add(cidade);
        for(Object c: listacidades){
            cmbCidade.addItem(c);
        }
    }
    
    private void limparTela(){
        this.txtCliCodigo.setText(gestorcliente.proximoCod() + "");
        this.txtCliNome.setText("");
        this.txtCliEndereco.setText("");
        this.txtCliBairro.setText("");
        Formatacao.reformatarTelefone(txtCliTelefone);
        this.cmbCidade.setSelectedIndex(cmbCidade.getItemCount() - 1);
        gestorcliente.popularTabela(tblClientes, "");
        this.txtCliNome.requestFocus();
    }

    private boolean ehFormularioValido(){
        Boolean valido = true;
        String mensagem = "Os seguintes campos estão preenchidos de forma incorreta: \n";
        if(cmbCidade.getSelectedItem().toString().equals("")){
            valido = false;
            mensagem = mensagem + "- Cidade; \n";
            cmbCidade.setBorder(new LineBorder(Color.red));
        }
        if(this.txtCliNome.getText().isEmpty() || this.txtCliNome.getText().equals(" ")){
            valido = false;
            txtCliNome.setBorder(new LineBorder(Color.RED));
            mensagem = mensagem + "- Nome; \n";
        }
        if(this.txtCliEndereco.getText().isEmpty() || this.txtCliEndereco.getText().equals(" ")) {
            valido = false;
            txtCliEndereco.setBorder(new LineBorder(Color.RED));
            mensagem = mensagem + "- Endereço; \n";
        }
        if(this.txtCliBairro.getText().isEmpty() || this.txtCliBairro.getText().equals(" ")){
            valido = false;
            txtCliBairro.setBorder(new LineBorder(Color.RED));
            mensagem = mensagem + "- Bairro; \n";
        }
        if(Formatacao.removerFormatacao(this.txtCliTelefone.getText()).isEmpty() || 
           Formatacao.removerFormatacao(this.txtCliTelefone.getText()).equals("          ") ){
            valido = false;
            txtCliTelefone.setBorder(new LineBorder(Color.RED));
            mensagem = mensagem + "- Telefone; \n";
        }
        if (!valido) {
            JOptionPane.showMessageDialog(this, mensagem);
        }
        txtCliNome.requestFocus();
        return valido;
    }
}
