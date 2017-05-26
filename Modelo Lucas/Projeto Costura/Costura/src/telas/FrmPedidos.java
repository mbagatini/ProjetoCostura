package telas;

import apoio.Formatacao;
import apoio.Validacao;
import entidades.*;
import gestores.*;
import java.awt.Color;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class FrmPedidos extends javax.swing.JFrame{

    private int cod = 0;
    private final GestorPedido   gestorpedido  = new GestorPedido();
    private final GestorCliente  gestorcliente = new GestorCliente();
    private final GestorProdutos gestorproduto = new GestorProdutos();
    private final GestorOrdem    gestorordem   = new GestorOrdem();
    private final Pedido         pedido        = new Pedido();
    private final Cliente        cliente       = new Cliente();
    private       ItemPedido     itempedido;
    
    public FrmPedidos() {
        initComponents();
        iniciarTela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrpSituacao = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPedCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPedCodCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPedData = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        rdbEmEspera = new javax.swing.JRadioButton();
        rdbEmProducao = new javax.swing.JRadioButton();
        rdbFinalizado = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItensPedido = new javax.swing.JTable();
        btnTabelaAdicionar = new javax.swing.JButton();
        btnTabelaEditar = new javax.swing.JButton();
        btnTabelaExcluir = new javax.swing.JButton();
        txtNomeCliente = new javax.swing.JTextField();
        txtValorTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnEscolherClientes = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        txtPesquisaCodigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtPesquisarData = new javax.swing.JFormattedTextField();
        btnCancelar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuRelatorioPedidos = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jLabel2.setText("Código:");

        txtPedCodigo.setFocusable(false);

        jLabel3.setText("Cliente:");

        txtPedCodCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPedCodClienteFocusLost(evt);
            }
        });

        jLabel4.setText("Data:");

        txtPedData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPedDataFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPedDataFocusLost(evt);
            }
        });

        jLabel5.setText("Situação:");

        GrpSituacao.add(rdbEmEspera);
        rdbEmEspera.setText("Em espera");
        rdbEmEspera.setEnabled(false);
        rdbEmEspera.setFocusable(false);

        GrpSituacao.add(rdbEmProducao);
        rdbEmProducao.setText("Em produção");
        rdbEmProducao.setEnabled(false);
        rdbEmProducao.setFocusable(false);

        GrpSituacao.add(rdbFinalizado);
        rdbFinalizado.setText("Finalizado");
        rdbFinalizado.setEnabled(false);
        rdbFinalizado.setFocusable(false);

        tblItensPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descrição", "Tamanho", "Quantidade", "Preço Untário", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblItensPedido.setOpaque(false);
        tblItensPedido.setPreferredSize(new java.awt.Dimension(100, 64));
        tblItensPedido.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblItensPedido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblItensPedidoFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(tblItensPedido);

        btnTabelaAdicionar.setText("Adicionar");
        btnTabelaAdicionar.setPreferredSize(new java.awt.Dimension(95, 23));
        btnTabelaAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTabelaAdicionarActionPerformed(evt);
            }
        });

        btnTabelaEditar.setText("Editar");
        btnTabelaEditar.setPreferredSize(new java.awt.Dimension(95, 23));
        btnTabelaEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTabelaEditarActionPerformed(evt);
            }
        });

        btnTabelaExcluir.setText("Excluir");
        btnTabelaExcluir.setPreferredSize(new java.awt.Dimension(95, 23));
        btnTabelaExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTabelaExcluirActionPerformed(evt);
            }
        });

        txtNomeCliente.setFocusable(false);

        txtValorTotal.setFocusable(false);

        jLabel7.setText("Valor Total:");

        btnEscolherClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        btnEscolherClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscolherClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTabelaAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTabelaEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTabelaExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValorTotal))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPedData, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPedCodCliente, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPedCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEscolherClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNomeCliente))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdbEmEspera)
                        .addGap(18, 18, 18)
                        .addComponent(rdbEmProducao)
                        .addGap(18, 18, 18)
                        .addComponent(rdbFinalizado)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPedCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPedCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEscolherClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPedData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rdbEmEspera)
                    .addComponent(rdbEmProducao)
                    .addComponent(rdbFinalizado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTabelaAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTabelaEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTabelaExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Manutenção", jPanel1);

        jLabel1.setText("Código:");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setPreferredSize(new java.awt.Dimension(95, 23));
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cliente", "Data", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPedidos);

        jLabel6.setText("Data:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisaCodigo)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisarData, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(txtPesquisaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtPesquisarData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
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

        btnEditar.setText("Editar/Ver");
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

        MenuRelatorioPedidos.setText("Relatórios");

        jMenuItem1.setText("Relatório de Pedidos por Período");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MenuRelatorioPedidos.add(jMenuItem1);

        jMenuBar1.add(MenuRelatorioPedidos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        if(this.ehFormularioValido()){
            try {
                if (rdbEmEspera.isSelected()){
                    this.cadastraPedido();
                }else{
                    JOptionPane.showMessageDialog(this, "Ordem de produção em andamento ou encerrada portanto o pedido não pode mais ser alterado");
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar pedido");
            }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        gestorpedido.popularTabela(tblPedidos, txtPesquisaCodigo.getText(), txtPesquisarData.getText());
        txtPesquisaCodigo.requestFocus();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        cod = Integer.parseInt(String.valueOf(tblPedidos.getValueAt(tblPedidos.getSelectedRow(), 0)));
        Pedido pedido = (Pedido) gestorpedido.consultarCod(cod);
        
        if (pedido != null){
            txtPedCodigo.setText(String.valueOf(pedido.getPed_codigo()));
            txtPedCodCliente.setText(String.valueOf(pedido.getCliente().getCodigo()));
            txtNomeCliente.setText(pedido.getCliente().getNome());
            switch(pedido.getPed_situacao()){
                case 'E':
                    rdbEmEspera.setSelected(true);
                    break;
                case 'P':
                    rdbEmProducao.setSelected(true);
                    break;
                case 'F':
                    rdbFinalizado.setSelected(true);
                    break;
            }
            try {
                txtPedData.setText(Formatacao.retornaDataFormatada(pedido.getPed_data()));
            } catch (ParseException ex) {
                Logger.getLogger(FrmPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
            popularTabelaItens(pedido);
            jTabbedPane1.setSelectedIndex(0);
            txtPedCodCliente.requestFocus();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        if(jTabbedPane1.getSelectedIndex() == 1){
            btnEditar.setEnabled(true);
            btnExcluir.setEnabled(true);
            btnConfirmar.setEnabled(false);
            if (tblPedidos.getRowCount() > 0) {
                tblPedidos.addRowSelectionInterval(0, 0);
            }
        } else {
            btnEditar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnConfirmar.setEnabled(true);
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (rdbEmEspera.isSelected()){
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Confirmação de exclusão", JOptionPane.YES_NO_OPTION);
            if (resposta == 0) {

                int id = Integer.parseInt(String.valueOf(tblPedidos.getValueAt(tblPedidos.getSelectedRow(), 0)));
                String retorno_ordem = gestorordem.excluir(gestorordem.getOrdCodigo(cod));
                String retorno_pedido = gestorpedido.excluir(id);

                if (retorno_pedido == null && retorno_ordem == null) {
                    JOptionPane.showMessageDialog(this, "Registro excluído!");
                    gestorpedido.popularTabela(tblPedidos, txtPesquisaCodigo.getText(), txtPesquisarData.getText());
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir:\n"
                            + "\n"
                            + "Mensagem técnica:\n" + retorno_pedido
                            + "\n"
                            + "Mensagem técnica:\n" + retorno_ordem);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pedido não pode mais ser excluído");
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtPedCodClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPedCodClienteFocusLost
        if(!txtPedCodCliente.getText().isEmpty()){
            txtPedCodCliente.setBorder(new LineBorder(Color.LIGHT_GRAY));
            GestorCliente gestorcliente = new GestorCliente();
            Cliente cliente = new Cliente();
            cliente = (Cliente) gestorcliente.consultarCod(Integer.parseInt(txtPedCodCliente.getText()));
            if(cliente != null){
                txtNomeCliente.setText(cliente.getNome());
            } else {
                txtNomeCliente.setText("");
            }
        } else {
            txtNomeCliente.setText("");
        }
    }//GEN-LAST:event_txtPedCodClienteFocusLost

    private void btnTabelaAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTabelaAdicionarActionPerformed
        ItemPedido itempedidoadd = new ItemPedido();
        DlgAdicionarItem dlgadicionaritem = new DlgAdicionarItem(this, rootPaneCheckingEnabled, null);
        dlgadicionaritem.setVisible(true);
        itempedidoadd = dlgadicionaritem.getItemPedido();
        if (itempedidoadd != null){
            adicionaLinhaTabela(itempedidoadd);
        }
        calcularPedido();
    }//GEN-LAST:event_btnTabelaAdicionarActionPerformed

    private void btnTabelaEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTabelaEditarActionPerformed
        int ref = Integer.parseInt(tblItensPedido.getValueAt(tblItensPedido.getSelectedRow(), 0).toString());
        String tam = tblItensPedido.getValueAt(tblItensPedido.getSelectedRow(), 2).toString();
        int qtde = Integer.parseInt(tblItensPedido.getValueAt(tblItensPedido.getSelectedRow(), 3).toString());
        ItemPedido itempedidoedit = new ItemPedido();
        itempedidoedit.setProduto((Produto)gestorproduto.consultarCod(ref, tam));
        itempedidoedit.setQuantidade(qtde);
        DlgAdicionarItem dlgeditaritem = new DlgAdicionarItem(this, rootPaneCheckingEnabled, itempedidoedit);
        dlgeditaritem.setVisible(true);
        System.out.println("teste com parametros");
        itempedidoedit = dlgeditaritem.getItemPedido();
        if (itempedidoedit != null){
            adicionaLinhaTabela(itempedidoedit);
        }
        calcularPedido();
    }//GEN-LAST:event_btnTabelaEditarActionPerformed

    private void btnTabelaExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTabelaExcluirActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblItensPedido.getModel();
        model.removeRow(tblItensPedido.getSelectedRow());
        calcularPedido();
    }//GEN-LAST:event_btnTabelaExcluirActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FrmRelatorioPedidos frmrelatoriopedidos = new FrmRelatorioPedidos();
        frmrelatoriopedidos.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txtPedDataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPedDataFocusLost
        txtPedData.setBorder(new LineBorder(Color.LIGHT_GRAY));
    }//GEN-LAST:event_txtPedDataFocusLost

    private void tblItensPedidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblItensPedidoFocusLost
        tblItensPedido.setBorder(new LineBorder(Color.LIGHT_GRAY));
    }//GEN-LAST:event_tblItensPedidoFocusLost

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        calcularPedido();
    }//GEN-LAST:event_formFocusGained

    private void btnEscolherClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscolherClientesActionPerformed
        Cliente clienteadd = new Cliente();
        DlgCliente dlgcliente = new DlgCliente(this, rootPaneCheckingEnabled);
        dlgcliente.setVisible(true);
        clienteadd = dlgcliente.getCliente();
        if (dlgcliente.getAlteracao()){
            this.txtPedCodCliente.setText(clienteadd.getCodigo() + "");
            this.txtNomeCliente.setText(clienteadd.getNome());
        }
        
    }//GEN-LAST:event_btnEscolherClientesActionPerformed

    private void txtPedDataFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPedDataFocusGained
        txtPedData.selectAll();
    }//GEN-LAST:event_txtPedDataFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrpSituacao;
    private javax.swing.JMenu MenuRelatorioPedidos;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEscolherClientes;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnTabelaAdicionar;
    private javax.swing.JButton btnTabelaEditar;
    private javax.swing.JButton btnTabelaExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdbEmEspera;
    private javax.swing.JRadioButton rdbEmProducao;
    private javax.swing.JRadioButton rdbFinalizado;
    private javax.swing.JTable tblItensPedido;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtPedCodCliente;
    private javax.swing.JTextField txtPedCodigo;
    private javax.swing.JFormattedTextField txtPedData;
    private javax.swing.JTextField txtPesquisaCodigo;
    private javax.swing.JFormattedTextField txtPesquisarData;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables

    private void limparTela(){
        txtPedCodigo.setText(gestorpedido.proximoCod() + "");
        txtPedCodCliente.setText("");
        txtNomeCliente.setText("");
        rdbEmEspera.setSelected(true);
        Formatacao.reformatarData(txtPedData);
        Formatacao.reformatarData(txtPesquisarData);
        txtPedData.setText(Formatacao.getDataAtual());
        gestorpedido.popularTabela(tblPedidos, txtPesquisaCodigo.getText(), txtPesquisarData.getText());
        txtPedCodCliente.requestFocus();
    }

    private void popularTabelaItens(Pedido pedido) {
        for (int i = 0; i < pedido.getItens_pedido().size(); i++) {
            adicionaLinhaTabela(pedido.getItens_pedido().get(i));
        }
        tblItensPedido.setRowSelectionInterval(0, 0);
    }

    private boolean ehFormularioValido() {
        Boolean valido = true;
        String mensagem = "Os seguintes campos estão preenchidos de forma incorreta: \n";

        if(this.txtPedCodCliente.getText().isEmpty() || this.txtPedCodCliente.getText().equals(" ")){
            valido = false;
            txtPedCodCliente.setBorder(new LineBorder(Color.RED));
            mensagem = mensagem + "- Cód. Cliente; \n";
        }
        if (!Validacao.validarDataFormatada(txtPedData.getText())){
            valido = false;
            txtPedData.setBorder(new LineBorder(Color.RED));
            mensagem = mensagem + "- Data; \n";
        }
        if (tblItensPedido.getRowCount() > 0) {
            boolean sair = false;
            for (int i = 0; i < tblItensPedido.getRowCount(); i++) {
                for (int j = 0; j < tblItensPedido.getRowCount(); j++) {
                    if (i != j) {
                        String referencia_i = tblItensPedido.getValueAt(i, 0).toString();
                        String referencia_j = tblItensPedido.getValueAt(j, 0).toString();
                        String tamanho_i = tblItensPedido.getValueAt(j, 2).toString();
                        String tamanho_j = tblItensPedido.getValueAt(j, 2).toString();
                        if (referencia_i.equals(referencia_j) && tamanho_i.equals(tamanho_j)){
                            valido = false;
                            tblItensPedido.setBorder(new LineBorder(Color.RED));
                            mensagem = mensagem + "- Itens repetidos no pedido; \n";
                            sair = true;
                        }
                    }
                    if (sair) {
                        break;
                    }
                }
                if (sair) {
                    break;
                }
            }
        }else{
            valido = false;
            tblItensPedido.setBorder(new LineBorder(Color.RED));
            mensagem = mensagem + "- Pedido sem itens; \n";
        }
        if (!valido) {
            JOptionPane.showMessageDialog(this, mensagem);
        }
        txtPedCodCliente.requestFocus();
        return valido;
    }

    private void cadastraPedido() throws ParseException {
        Pedido pedido = new Pedido();
        OrdemProducao ordem = (OrdemProducao)gestorordem.consultarCod(gestorordem.getOrdCodigo(cod));
        String retorno_pedido = null;
        String retorno_ordem  = null;
        
        if (ehFormularioValido()) {
            pedido.setItens_pedido(this.gerarListaItensPedido());
            if(cod != 0){
                gestorpedido.excluir(cod);
                gestorordem.excluir(gestorordem.getOrdCodigo(cod));
            } else{
                rdbEmEspera.setSelected(true);
            }
            pedido.setPed_codigo(cod);
            pedido.setCliente((Cliente) gestorcliente.consultarCod(Integer.parseInt(txtPedCodCliente.getText())));
            pedido.setPed_data(Formatacao.retornaDataString(txtPedData.getText()));
            if(rdbEmEspera.isSelected()){
                pedido.setPed_situacao('E');
            }
            if(rdbEmProducao.isSelected()){
                pedido.setPed_situacao('P');
            }
            if(rdbFinalizado.isSelected()){
                pedido.setPed_situacao('F');
            }
            
            retorno_pedido = gestorpedido.salvar(pedido);
            
            if (ordem == null){
                pedido.setPed_codigo(gestorpedido.proximoCod() - 1);
                ordem = new OrdemProducao();
                ordem.setPedido(pedido);
                ordem.setOrd_ordcodigo(gestorordem.proximoCod());
                ordem.setOrd_situacao('E');
                ordem.setData_fim(null);
                ordem.setData_ini(null);
            }
            ordem.setItens_ordem(pedido.getItens_pedido());
            
            retorno_ordem  = gestorordem.salvar(ordem);
            if (retorno_pedido == null && retorno_ordem == null){
                JOptionPane.showMessageDialog(this, "Salvo com sucesso.");
                excluirLinhasTabelaItens();
                limparTela();
            } else {
                JOptionPane.showMessageDialog(this, "Problemas ao salvar.\n"
                                                  + "\n"
                                                  + "Informações: " + retorno_pedido
                                                  + "\n"
                                                  + "Informações: " + retorno_ordem);
            }
        }
    }

    private ArrayList<ItemPedido> gerarListaItensPedido() {
        ArrayList<ItemPedido> itens_pedido = new ArrayList();
        GestorProdutos gestorproduto = new GestorProdutos();
        for (int i = 0; i < tblItensPedido.getRowCount(); i++) {
            tblItensPedido.setRowSelectionInterval(i, i);
            Object obj = tblItensPedido.getValueAt(tblItensPedido.getSelectedRow(), 0 );
            if( obj != null && obj.toString().trim().length() > 0){
                ItemPedido item = new ItemPedido();
                Produto produto = new Produto();
                int referencia = Integer.parseInt(String.valueOf(tblItensPedido.getValueAt(tblItensPedido.getSelectedRow(), 0)));
                String tamanho = tblItensPedido.getValueAt(tblItensPedido.getSelectedRow(), 2).toString();
                produto = (Produto)gestorproduto.consultarCod(gestorproduto.consultarCodigoPorReferencia(referencia, tamanho));
                item.setProduto(produto);
                item.setPreco(item.getProduto().getPreco());
                item.setQuantidade(Integer.parseInt(String.valueOf(tblItensPedido.getValueAt(tblItensPedido.getSelectedRow(), 3))));
                itens_pedido.add(item);                
            }
        }
        return itens_pedido;
    }
    
    private void adicionaLinhaTabela(ItemPedido itemPedido){
        boolean existe = false;
        DefaultTableModel model = (DefaultTableModel) tblItensPedido.getModel();
        int linha = model.getRowCount();
        
        
        // Testa se tem alguma linha na tabela
        if (linha > 0) {
            // Testa se em alguma linha da tabela já tem o item a ser adicionad
            for (int i = 0; i < model.getRowCount(); i++) {
                // Se for a mesma referência e tamnah, adiciona a quantidade
                if (Integer.parseInt(model.getValueAt(i, 0).toString()) == itemPedido.getProduto().getReferencia() 
                  &&  model.getValueAt(i, 2).toString().equals(itemPedido.getProduto().getTamanho())){
                    linha = i;
                    existe = true;
                    itemPedido.setQuantidade(itemPedido.getQuantidade() + Integer.parseInt(model.getValueAt(linha, 3).toString()));
                }
            }
        }
        if (!existe){
            model.setNumRows(model.getRowCount() + 1);
            linha = model.getRowCount() - 1;
        }
        model.setValueAt(itemPedido.getProduto().getReferencia(), linha, 0);
        model.setValueAt(itemPedido.getProduto().getDescricao(), linha, 1);
        model.setValueAt(itemPedido.getProduto().getTamanho(), linha, 2);
        model.setValueAt(itemPedido.getQuantidade(), linha, 3);
        model.setValueAt(itemPedido.getPreco(), linha, 4);
        model.setValueAt(itemPedido.getPreco() * itemPedido.getQuantidade(), linha, 5);
    }

    private void excluirLinhasTabelaItens(){
        DefaultTableModel model = (DefaultTableModel) tblItensPedido.getModel();  
        int teste = model.getRowCount();
        for (int i = 0; i < teste; i++) {
            if (model.getRowCount() == 1){
                model.setValueAt("", 0, 0);
                model.setValueAt("", 0, 1);
                model.setValueAt("", 0, 2);
                model.setValueAt("", 0, 3);
                model.setValueAt("", 0, 4);
                model.setValueAt("", 0, 5);
            } else {
                model.removeRow(i);
            }
        }
    }

    private void calcularPedido() {
        double valor_total = 0;
        for (int i = 0; i < tblItensPedido.getRowCount(); i++) {
            valor_total = valor_total + Double.parseDouble(tblItensPedido.getValueAt(i, 5).toString());
        }
        System.out.println("" + valor_total);
        txtValorTotal.setText(Formatacao.formatarDecimal2(valor_total));
    }

    private void iniciarTela() {
        this.setResizable(false);
        this.setTitle("Pedidos");
        this.setLocationRelativeTo(null);
        this.limparTela();
    }

}
