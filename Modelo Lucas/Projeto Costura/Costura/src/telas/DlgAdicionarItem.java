package telas;

import apoio.ConexaoBancoDados;
import entidades.ItemPedido;
import entidades.Produto;
import gestores.GestorProdutos;
import java.awt.Color;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class DlgAdicionarItem extends javax.swing.JDialog {

    private Produto        produto        = new Produto();
    private GestorProdutos gestorprodutos = new GestorProdutos();
    private ItemPedido     itempedido;

    public DlgAdicionarItem(java.awt.Frame parent, boolean modal, ItemPedido itempedido) {
        super(parent, modal);
        initComponents();
        this.itempedido = itempedido;
        this.carregaTela(this.itempedido);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbTamanho = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        btnEscolherItem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Referência:");

        txtReferencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtReferenciaFocusLost(evt);
            }
        });

        jLabel3.setText("Tamanho:");

        cmbTamanho.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbTamanhoFocusLost(evt);
            }
        });

        jLabel4.setText("Quantidade:");

        txtQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantidadeFocusLost(evt);
            }
        });

        btnConfirmar.setText("Confirmar");
        btnConfirmar.setPreferredSize(new java.awt.Dimension(95, 23));
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(95, 23));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("Descrição:");

        txtDescricao.setFocusable(false);

        btnEscolherItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        btnEscolherItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscolherItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTamanho, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDescricao)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEscolherItem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 237, Short.MAX_VALUE)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEscolherItem, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtReferenciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtReferenciaFocusLost
        if (!txtReferencia.getText().isEmpty()) {
            popularCombobox();
            if (gestorprodutos.existeReferencia(Integer.parseInt(txtReferencia.getText()))) {
                txtDescricao.setText(gestorprodutos.retornaNome(Integer.parseInt(txtReferencia.getText())));
            } else {
                JOptionPane.showMessageDialog(this, "Referência inválida");
                txtReferencia.requestFocus();
                txtReferencia.selectAll();
            }
        }
        txtDescricao.setBorder(new LineBorder(Color.LIGHT_GRAY));
    }//GEN-LAST:event_txtReferenciaFocusLost

    private void cmbTamanhoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbTamanhoFocusLost
        cmbTamanho.setBorder(new LineBorder(Color.LIGHT_GRAY));
    }//GEN-LAST:event_cmbTamanhoFocusLost

    private void txtQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantidadeFocusLost
        txtQuantidade.setBorder(new LineBorder(Color.LIGHT_GRAY));
    }//GEN-LAST:event_txtQuantidadeFocusLost

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if (atualizarItemPedido()){
            this.dispose();
        }   
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.itempedido = null;
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEscolherItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscolherItemActionPerformed
        DlgItem dlgitem = new DlgItem(this, rootPaneCheckingEnabled);
        dlgitem.setVisible(true);
        String referenciaadd = dlgitem.getReferencia();
        if (dlgitem.getAlteracao()){
            this.txtReferencia.setText(referenciaadd);
            this.txtReferenciaFocusLost(null);
        } 
    }//GEN-LAST:event_btnEscolherItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnEscolherItem;
    private javax.swing.JComboBox<Object> cmbTamanho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtReferencia;
    // End of variables declaration//GEN-END:variables

    private void popularCombobox() {
        cmbTamanho.removeAllItems();
        String tam = "";
        ArrayList<Object> listatamanhos = new ArrayList<>();
        listatamanhos = consultarTamanhos();
        listatamanhos.add(tam);
        for(Object c: listatamanhos){
            cmbTamanho.addItem(c);
        }
        if(itempedido == null){
            cmbTamanho.setSelectedIndex(cmbTamanho.getItemCount() - 1);
        }
    }

    private ArrayList<Object> consultarTamanhos() {
        ResultSet resultadoQ;
        ArrayList<Object> listatamanhos;
        listatamanhos = new ArrayList<Object>();
        String referencia = txtReferencia.getText();
        try {
            String sql = " Select pro_tamanho from tb_produtos ";
            if(!referencia.isEmpty() && !referencia.equals("")){
                sql = sql + "  where pro_referencia = " + referencia + " ";
            }
            resultadoQ = ConexaoBancoDados.getInstance().getConnection().createStatement().executeQuery(sql);
            while (resultadoQ.next()) {
                listatamanhos.add(resultadoQ.getString(1));
            }
        } catch (Exception ex) {
            System.out.println("Erro ao consultar tamanho: " + ex);
        }
        return listatamanhos;
    }
    
    // Metodo para carregar as informações da tela
    private void carregaTela(ItemPedido itempedido) {
        this.setResizable(false);
        this.setTitle("Item do pedido");
        this.setLocationRelativeTo(null);
        this.popularCombobox();
        if (itempedido != null){
            this.txtReferencia.setText(itempedido.getProduto().getReferencia() + "");
            this.txtQuantidade.setText(itempedido.getQuantidade() + "");
            this.txtDescricao.setText(itempedido.getProduto().getDescricao());
            for (int i = 0; i < cmbTamanho.getItemCount(); ++i) {
                String tamanho = cmbTamanho.getItemAt(i).toString();
                if (tamanho.equals(itempedido.getProduto().getTamanho())) {
                   cmbTamanho.setSelectedIndex(i);
                   break;
                }
            }
        }
    }

    // Metodo para validar o formulário
    private boolean ehFormularioValido() {
        Boolean valido = true;
        String mensagem = "Os seguintes campos estão preenchidos de forma incorreta: \n";

        if(cmbTamanho.getItemCount() <= 0 || cmbTamanho.getSelectedItem().toString().equals("")){
            valido = false;
            mensagem = mensagem + "- Tamanho; \n";
            cmbTamanho.setBorder(new LineBorder(Color.red));
        }
        if(this.txtQuantidade.getText().isEmpty() || Integer.parseInt(txtQuantidade.getText()) <= 0){
            valido = false;
            txtQuantidade.setBorder(new LineBorder(Color.RED));
            mensagem = mensagem + "- Quantidade; \n";
        }
        if(this.txtReferencia.getText().isEmpty() || this.txtReferencia.getText().equals(" ")) {
            valido = false;
            txtReferencia.setBorder(new LineBorder(Color.RED));
            mensagem = mensagem + "- Referência; \n";
        }
        if (!valido) {
            JOptionPane.showMessageDialog(this, mensagem);
        }
        txtQuantidade.requestFocus();
        return valido;
    }
    
    public ItemPedido getItemPedido(){
        return this.itempedido;
    }

    private boolean atualizarItemPedido() {
        if (ehFormularioValido()) {
            if (this.itempedido == null){
                this.itempedido = new ItemPedido();
            }
            this.produto =(Produto) gestorprodutos.consultarCod(Integer.parseInt(this.txtReferencia.getText()), this.cmbTamanho.getSelectedItem().toString());
            this.itempedido.setProduto(this.produto);
            this.itempedido.setPreco(this.produto.getPreco());
            this.itempedido.setQuantidade(Integer.parseInt(this.txtQuantidade.getText()));
            return true;
        } else {
            return false;
        }
    }
}
