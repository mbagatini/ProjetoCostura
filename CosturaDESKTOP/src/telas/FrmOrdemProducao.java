package telas;

import apoio.Formatacao;
import entidades.ItemPedido;
import entidades.OrdemProducao;
import gestores.GestorOrdem;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmOrdemProducao extends javax.swing.JFrame {

    private final GestorOrdem gestorordem = new GestorOrdem();
    private OrdemProducao ordemproducao = new OrdemProducao();
    
    public FrmOrdemProducao() {
        initComponents();
        inicializarTela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtOrdemCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPedidoCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtOrdemDataIni = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItensOrdem = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtOrdemDataFim = new javax.swing.JFormattedTextField();
        btnIniciarOrdem = new javax.swing.JButton();
        btnFinalizarOrdem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        txtPesquisaCodigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrdens = new javax.swing.JTable();
        btnVisualisar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Ordem:");

        txtOrdemCodigo.setFocusable(false);

        jLabel3.setText("Pedido:");

        txtPedidoCodigo.setFocusable(false);

        jLabel4.setText("Data Início:");

        txtOrdemDataIni.setFocusable(false);

        tblItensOrdem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descrição", "Tamanho", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblItensOrdem.setOpaque(false);
        tblItensOrdem.setPreferredSize(new java.awt.Dimension(100, 64));
        tblItensOrdem.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblItensOrdem);

        jLabel8.setText("Data Término:");

        txtOrdemDataFim.setFocusable(false);

        btnIniciarOrdem.setText("Iniciar Ordem");
        btnIniciarOrdem.setEnabled(false);
        btnIniciarOrdem.setPreferredSize(new java.awt.Dimension(125, 23));
        btnIniciarOrdem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarOrdemActionPerformed(evt);
            }
        });

        btnFinalizarOrdem.setText("Finalizar Ordem");
        btnFinalizarOrdem.setEnabled(false);
        btnFinalizarOrdem.setPreferredSize(new java.awt.Dimension(125, 23));
        btnFinalizarOrdem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarOrdemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtOrdemDataIni, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOrdemCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtOrdemDataFim, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                    .addComponent(txtPedidoCodigo)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnIniciarOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnFinalizarOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtOrdemCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtPedidoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtOrdemDataIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtOrdemDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciarOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizarOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Visualização", jPanel1);

        jLabel1.setText("Código:");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setPreferredSize(new java.awt.Dimension(95, 23));
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tblOrdens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ordem", "Pedido", "Data Início", "Data Términol", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrdens.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblOrdens);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisaCodigo)
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
                    .addComponent(txtPesquisaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consulta", jPanel2);

        btnVisualisar.setText("Visualizar");
        btnVisualisar.setPreferredSize(new java.awt.Dimension(95, 23));
        btnVisualisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualisarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(95, 23));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

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
                        .addComponent(btnVisualisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(btnVisualisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        String pesquisa = txtPesquisaCodigo.getText();
        if (pesquisa.isEmpty()){
            pesquisa = null;
        }
        gestorordem.popularTabela(tblOrdens, pesquisa, null);
        txtPesquisaCodigo.requestFocus();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnVisualisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualisarActionPerformed
        try {
            visualizarOrdem(Integer.parseInt(tblOrdens.getValueAt(tblOrdens.getSelectedRow(), 0).toString()));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao exibir ordem de produção.");
        }
    }//GEN-LAST:event_btnVisualisarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnIniciarOrdemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarOrdemActionPerformed
        try {
            iniciarOrdem();
            visualizarOrdem(Integer.parseInt(tblOrdens.getValueAt(tblOrdens.getSelectedRow(), 0).toString()));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao iniciar ordem de produção.");
        }
    }//GEN-LAST:event_btnIniciarOrdemActionPerformed

    private void btnFinalizarOrdemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarOrdemActionPerformed
        try {
            finalizarOrdem();
            visualizarOrdem(Integer.parseInt(tblOrdens.getValueAt(tblOrdens.getSelectedRow(), 0).toString()));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao finalizar ordem de produção.");
        }
    }//GEN-LAST:event_btnFinalizarOrdemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinalizarOrdem;
    private javax.swing.JButton btnIniciarOrdem;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnVisualisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblItensOrdem;
    private javax.swing.JTable tblOrdens;
    private javax.swing.JTextField txtOrdemCodigo;
    private javax.swing.JFormattedTextField txtOrdemDataFim;
    private javax.swing.JFormattedTextField txtOrdemDataIni;
    private javax.swing.JTextField txtPedidoCodigo;
    private javax.swing.JTextField txtPesquisaCodigo;
    // End of variables declaration//GEN-END:variables

    private void inicializarTela() {
        this.setResizable(false);
        this.setTitle("Ordens de produção");
        this.setLocationRelativeTo(null);
        limparTela();
        gestorordem.popularTabela(tblOrdens, null, null);
    }

    private void limparTela() {
        this.txtOrdemCodigo.setText("");
        this.txtOrdemDataFim.setText("");
        this.txtOrdemDataIni.setText("");
        this.txtPedidoCodigo.setText("");
        this.txtPesquisaCodigo.setText("");
        this.btnIniciarOrdem.setEnabled(false);
        this.btnFinalizarOrdem.setEnabled(false);
        this.excluirLinhasTabelaItens();
    }

    private void visualizarOrdem(int ordCodigo) throws ParseException {
        ordemproducao = (OrdemProducao)gestorordem.consultarCod(ordCodigo);
        if (ordemproducao != null){
            txtOrdemCodigo.setText(ordemproducao.getOrd_ordcodigo() + "");
            txtPedidoCodigo.setText(ordemproducao.getPedido().getPed_codigo() + "");
            if (ordemproducao.getData_ini() != null){
                txtOrdemDataIni.setText(Formatacao.retornaDataFormatada(ordemproducao.getData_ini()));
            }
            if (ordemproducao.getData_fim() != null) {
                txtOrdemDataFim.setText(Formatacao.retornaDataFormatada(ordemproducao.getData_fim()));
            }
            popularTabelaItens(ordemproducao);
            switch(ordemproducao.getOrd_situacao()){
                case 'E':
                    this.btnIniciarOrdem.setEnabled(true);
                    this.btnFinalizarOrdem.setEnabled(false);
                    break;
                case 'P':
                    this.btnIniciarOrdem.setEnabled(false);
                    this.btnFinalizarOrdem.setEnabled(true);
                    break;
                case 'F':
                    this.btnIniciarOrdem.setEnabled(false);
                    this.btnFinalizarOrdem.setEnabled(false);
                    break;
            }
            jTabbedPane1.setSelectedIndex(0);
        }
    }

    private void popularTabelaItens(OrdemProducao ordem) {
        for (int i = 0; i < ordem.getItens_ordem().size(); i++) {
            adicionaLinhaTabela(ordem.getItens_ordem().get(i));
        }
        tblItensOrdem.setRowSelectionInterval(0, 0);
    }

    private void adicionaLinhaTabela(ItemPedido itemOrdem){
        boolean existe = false;
        DefaultTableModel model = (DefaultTableModel) tblItensOrdem.getModel();
        int linha = model.getRowCount();
        
        
        // Testa se tem alguma linha na tabela
        if (linha > 0) {
            // Testa se em alguma linha da tabela já tem o item a ser adicionad
            for (int i = 0; i < model.getRowCount(); i++) {
                // Se for a mesma referência e tamnah, adiciona a quantidade
                if (Integer.parseInt(model.getValueAt(i, 0).toString()) == itemOrdem.getProduto().getReferencia() 
                  &&  model.getValueAt(i, 2).toString().equals(itemOrdem.getProduto().getTamanho())){
                    linha = i;
                    existe = true;
                    itemOrdem.setQuantidade(itemOrdem.getQuantidade() + Integer.parseInt(model.getValueAt(linha, 3).toString()));
                }
            }
        }
        if (!existe){
            model.setNumRows(model.getRowCount() + 1);
            linha = model.getRowCount() - 1;
        }
        model.setValueAt(itemOrdem.getProduto().getReferencia(), linha, 0);
        model.setValueAt(itemOrdem.getProduto().getDescricao(), linha, 1);
        model.setValueAt(itemOrdem.getProduto().getTamanho(), linha, 2);
        model.setValueAt(itemOrdem.getQuantidade(), linha, 3);
    }
    
    private void excluirLinhasTabelaItens(){
        DefaultTableModel model = (DefaultTableModel) tblItensOrdem.getModel();  
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

    private void iniciarOrdem() throws ParseException {
        String retorno = null;
        String data = Formatacao.getDataAtual();
        ordemproducao.setData_ini(Formatacao.retornaDataString(data));
        ordemproducao.setOrd_situacao('P');
        retorno = gestorordem.atualizar(ordemproducao);
        if (retorno == null){
            txtOrdemDataIni.setText(Formatacao.retornaDataFormatada(ordemproducao.getData_ini()));
            gestorordem.popularTabela(tblOrdens, null, null);
            JOptionPane.showMessageDialog(this, "Ordem de produção foi incializada com sucesso.");
        } else {
            JOptionPane.showMessageDialog(this, "Problemas ao inicializar ordem.\n"
                                                  + "\n"
                                                  + "Informações: " + retorno);
        }
    }

    private void finalizarOrdem() throws ParseException {
        String retorno = null;
        String data = Formatacao.getDataAtual();
        ordemproducao.setData_fim(Formatacao.retornaDataString(data));
        ordemproducao.setOrd_situacao('F');
        retorno = gestorordem.atualizar(ordemproducao);
        if (retorno == null){
            txtOrdemDataFim.setText(Formatacao.retornaDataFormatada(ordemproducao.getData_fim()));
            gestorordem.popularTabela(tblOrdens, null, null);
            JOptionPane.showMessageDialog(this, "Ordem de produção foi finalizada com sucesso.");
        } else {
            JOptionPane.showMessageDialog(this, "Problemas ao finalizar ordem.\n"
                                                  + "\n"
                                                  + "Informações: " + retorno);
        }
    }

}
