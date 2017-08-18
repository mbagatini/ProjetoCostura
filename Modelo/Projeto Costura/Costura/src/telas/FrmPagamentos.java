package telas;

import apoio.Formatacao;
import apoio.Validacao;
import entidades.Categoria;
import entidades.Nota;
import entidades.Pagamento;
import gestores.GestorNota;
import gestores.GestorPagamento;
import java.awt.Color;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class FrmPagamentos extends javax.swing.JFrame {

    private final GestorPagamento  gestorpagamento = new GestorPagamento();
    private final GestorNota gestornota = new GestorNota();
    int cod = 0;
    
    public FrmPagamentos() {
        initComponents();
        iniciarTela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPagCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNotCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPagValor = new javax.swing.JFormattedTextField();
        txtSaldoNota = new javax.swing.JFormattedTextField();
        btnEscolherClientes = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        txtPedData = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        txtPesquisarNota = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPagamentos = new javax.swing.JTable();
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

        txtPagCodigo.setFocusable(false);

        jLabel3.setText("Nota:");

        txtNotCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNotCodigoFocusLost(evt);
            }
        });

        jLabel4.setText("Data:");

        jLabel5.setText("Valor:");

        jLabel6.setText("Saldo:");

        txtPagValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPagValorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPagValorFocusLost(evt);
            }
        });

        txtSaldoNota.setFocusable(false);

        btnEscolherClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        btnEscolherClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscolherClientesActionPerformed(evt);
            }
        });

        jLabel8.setText("Cliente:");

        txtNomeCliente.setFocusable(false);

        txtPedData.setFocusable(false);
        txtPedData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPedDataFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel5))
                            .addGap(10, 10, 10))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNotCodigo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPagCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEscolherClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtPedData, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPagValor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtSaldoNota, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPagCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNotCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addComponent(btnEscolherClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPedData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPagValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtSaldoNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manutenção", jPanel1);

        jLabel1.setText("Pesquisar:");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setPreferredSize(new java.awt.Dimension(95, 23));
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tblPagamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nota", "Cliente", "Data", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPagamentos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblPagamentos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPesquisarNota)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(txtPesquisarNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            Pagamento pagamento = new Pagamento();
            pagamento.setCodigo(cod);
            pagamento.setValor(Formatacao.getDecimal(txtPagValor.getText()));
            pagamento.setNota((Nota)gestornota.consultarCod(Integer.parseInt(txtNotCodigo.getText())));
            try {
                pagamento.setData(Formatacao.retornaDataString(Formatacao.getDataAtual()));
            } catch (ParseException ex) {
                System.out.println("erro na data");
            }

            String retorno = null;
            if (cod == 0) {
                retorno = gestorpagamento.salvar(pagamento);
            } else {
                retorno = gestorpagamento.atualizar(pagamento);
            }
            if (retorno == null){
                JOptionPane.showMessageDialog(this, "Salvo com sucesso.");
                limparTela();
                cod = 0;
            } else {
                JOptionPane.showMessageDialog(this, "Problemas ao salvar.\n"
                                                  + "\n"
                                                  + "Informações: " + retorno);
            }    
        }        
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        gestorpagamento.popularTabela(tblPagamentos, txtPesquisarNota.getText());
        txtPesquisarNota.requestFocus();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        cod = Integer.parseInt(String.valueOf(tblPagamentos.getValueAt(tblPagamentos.getSelectedRow(), 0)));
        Pagamento pag = (Pagamento) gestorpagamento.consultarCod(cod);
        
        if (pag != null){
            txtPagCodigo.setText(String.valueOf(pag.getCodigo()));
            txtNotCodigo.setText(pag.getNota().getNot_codigo() + "");
            txtNomeCliente.setText(pag.getNota().getPedido().getCliente().getNome());
            txtPagValor.setText(Formatacao.formatarDecimal2(pag.getValor()));
            txtSaldoNota.setText(Formatacao.formatarDecimal2(pag.getNota().getNot_valor()));
            jTabbedPane1.setSelectedIndex(0);
            txtNotCodigo.setFocusable(false);
            txtPagValor.setFocusable(false);
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

            int id = Integer.parseInt(String.valueOf(tblPagamentos.getValueAt(tblPagamentos.getSelectedRow(), 0)));
            String retorno = gestorpagamento.excluir(id);

            if (retorno == null) {
                JOptionPane.showMessageDialog(this, "Registro excluído!");
                gestorpagamento.popularTabela(tblPagamentos, "");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir:\n"
                        + "\n"
                        + "Mensagem técnica:\n" + retorno);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtNotCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNotCodigoFocusLost
        if(!txtNotCodigo.getText().isEmpty()){
            txtNotCodigo.setBorder(new LineBorder(Color.LIGHT_GRAY));
            if (!consultaNota()){
                txtNotCodigo.requestFocus();
                txtNotCodigo.selectAll();
            }
        }
    }//GEN-LAST:event_txtNotCodigoFocusLost

    private void btnEscolherClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscolherClientesActionPerformed
        Nota notaadd = new Nota();
        DlgNotas dlgnota = new DlgNotas(this, rootPaneCheckingEnabled);
        dlgnota.setVisible(true);
        notaadd = dlgnota.getNota();
        if (dlgnota.getAlteracao()){
            this.limparTela();
            this.txtNotCodigo.setText(notaadd.getNot_codigo()+ "");
            this.txtNomeCliente.setText(notaadd.getPedido().getCliente().getNome());
            this.txtSaldoNota.setText(Formatacao.formatarDecimal2(notaadd.getNot_valor()));
            this.txtPagValor.requestFocus();
            this.txtPagValor.selectAll();
        }
    }//GEN-LAST:event_btnEscolherClientesActionPerformed

    private void txtPedDataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPedDataFocusLost
        txtPedData.setBorder(new LineBorder(Color.LIGHT_GRAY));
    }//GEN-LAST:event_txtPedDataFocusLost

    private void txtPagValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPagValorFocusLost
        txtPagValor.setBorder(new LineBorder(Color.LIGHT_GRAY));
        if (!txtPagValor.getText().isEmpty()) {
            Formatacao.formatarDecimal(txtPagValor);
        }
    }//GEN-LAST:event_txtPagValorFocusLost

    private void txtPagValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPagValorFocusGained
        txtPagValor.selectAll();
    }//GEN-LAST:event_txtPagValorFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEscolherClientes;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblPagamentos;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNotCodigo;
    private javax.swing.JTextField txtPagCodigo;
    private javax.swing.JFormattedTextField txtPagValor;
    private javax.swing.JFormattedTextField txtPedData;
    private javax.swing.JTextField txtPesquisarNota;
    private javax.swing.JFormattedTextField txtSaldoNota;
    // End of variables declaration//GEN-END:variables


    private boolean ehFormularioValido(){
        Boolean valido = true;
        String mensagem = "Os seguintes campos estão preenchidos de forma incorreta: \n";

        if(this.txtNotCodigo.getText().trim().isEmpty()){
            valido = false;
            txtNotCodigo.setBorder(new LineBorder(Color.RED));
            mensagem = mensagem + "- Código da nota; \n";
        }
        if (!Validacao.validarDataFormatada(txtPedData.getText())){
            valido = false;
            txtPedData.setBorder(new LineBorder(Color.RED));
            mensagem = mensagem + "- Data; \n";
        }
        if(this.txtPagValor.getText().trim().isEmpty() || Formatacao.getDecimal(this.txtPagValor.getText()) <= 0){
            valido = false;
            txtPagValor.setBorder(new LineBorder(Color.RED));
            mensagem = mensagem + "- Valor nota; \n";
        }
        if (!valido) {
            JOptionPane.showMessageDialog(this, mensagem);
            txtNotCodigo.requestFocus();
        }
        
        return valido;
    }
    
    private void limparTela(){
        txtNotCodigo.setFocusable(true);
        txtPagValor.setFocusable(true);
        cod = 0;
        gestorpagamento.popularTabela(tblPagamentos, "");
        txtPagCodigo.setText(gestorpagamento.proximoCod() + "");
        txtNotCodigo.setText("");
        txtNomeCliente.setText("");
        txtPedData.setText(Formatacao.getDataAtual());
        txtPagValor.setText(Formatacao.formatarDecimal2(0.0));
        txtSaldoNota.setText(Formatacao.formatarDecimal2(0.0));
        txtNotCodigo.requestFocus();
        
    }

    private void iniciarTela() {
        this.setResizable(false);
        this.setTitle("Pagamentos");
        this.setLocationRelativeTo(null);
        this.limparTela();
    }

    private boolean consultaNota() {
        Nota notaconsulta = new Nota();
        notaconsulta = (Nota)gestornota.consultarCod(Integer.parseInt(txtNotCodigo.getText()));
        if (notaconsulta != null){
            txtNotCodigo.setText(notaconsulta.getNot_codigo() + "");
            txtNomeCliente.setText(notaconsulta.getPedido().getCliente().getNome());
            txtSaldoNota.setText(Formatacao.formatarDecimal2(notaconsulta.getNot_valor()));
            return true;
        } else {
            return false;
        }
    }
}
