package telas;

import apoio.ConexaoBancoDados;
import apoio.Formatacao;
import entidades.Categoria;
import entidades.Produto;
import gestores.GestorCategoria;
import gestores.GestorProdutos;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class FrmProdutos extends javax.swing.JFrame {
    
    int cod = 0;
    GestorCategoria gestorcategoria = new GestorCategoria();
    GestorProdutos gestorproduto = new GestorProdutos();
    ArrayList<Object> listaprodutoseditar = new ArrayList<>();

    public FrmProdutos() {
        initComponents();
        this.setResizable(false);
        this.setTitle("Produtos");
        this.setLocationRelativeTo(null);
        this.carregarCombo();
        this.LimparTela();
        gestorproduto.popularTabela(tblProdutos, txtPesquisarDescricao.getText());
        if (tblProdutos.getRowCount() > 0) {
            tblProdutos.addRowSelectionInterval(0, 0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grp_genero = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtProReferencia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtProDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbProCategoria = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        rdbProGeneroFeminino = new javax.swing.JRadioButton();
        rdbProGeneroMasculino = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        cbxProTamanho4 = new javax.swing.JCheckBox();
        cbxProTamanho6 = new javax.swing.JCheckBox();
        cbxProTamanho8 = new javax.swing.JCheckBox();
        cbxProTamanho10 = new javax.swing.JCheckBox();
        cbxProTamanho12 = new javax.swing.JCheckBox();
        cbxProTamanho14 = new javax.swing.JCheckBox();
        cbxProTamanhoPP = new javax.swing.JCheckBox();
        cbxProTamanhoP = new javax.swing.JCheckBox();
        cbxProTamanhoM = new javax.swing.JCheckBox();
        cbxProTamanhoG = new javax.swing.JCheckBox();
        cbxProTamanho16 = new javax.swing.JCheckBox();
        cbxProTamanhoGG = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        txtProPreco = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtPesquisarDescricao = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuRelatorios = new javax.swing.JMenu();
        mnuListagemProdutos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produtos");

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jLabel1.setText("Referência:");

        txtProReferencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProReferenciaFocusLost(evt);
            }
        });

        jLabel2.setText("Descrição:");

        txtProDescricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProDescricaoFocusLost(evt);
            }
        });

        jLabel3.setText("Categoria:");

        cmbProCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProCategoriaItemStateChanged(evt);
            }
        });
        cmbProCategoria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbProCategoriaFocusLost(evt);
            }
        });

        jLabel4.setText("Gênero:");

        grp_genero.add(rdbProGeneroFeminino);
        rdbProGeneroFeminino.setText("Feminino");
        rdbProGeneroFeminino.setToolTipText("");

        grp_genero.add(rdbProGeneroMasculino);
        rdbProGeneroMasculino.setText("Masculino");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tamanho"));

        cbxProTamanho4.setText("Tamanho 4");

        cbxProTamanho6.setText("Tamanho 6");

        cbxProTamanho8.setText("Tamanho 8");

        cbxProTamanho10.setText("Tamanho 10");

        cbxProTamanho12.setText("Tamanho 12");

        cbxProTamanho14.setText("Tamanho 14");

        cbxProTamanhoPP.setText("Tamanho PP");

        cbxProTamanhoP.setText("Tamanho P");

        cbxProTamanhoM.setText("Tamanho M");

        cbxProTamanhoG.setText("Tamanho G");

        cbxProTamanho16.setText("Tamanho 16");

        cbxProTamanhoGG.setText("Tamanho GG");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxProTamanho4)
                    .addComponent(cbxProTamanho6)
                    .addComponent(cbxProTamanho8)
                    .addComponent(cbxProTamanho10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxProTamanho14)
                    .addComponent(cbxProTamanho12)
                    .addComponent(cbxProTamanho16)
                    .addComponent(cbxProTamanhoPP))
                .addGap(136, 136, 136)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(cbxProTamanhoP)
                        .addGap(53, 53, 53))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxProTamanhoM)
                            .addComponent(cbxProTamanhoG)
                            .addComponent(cbxProTamanhoGG))
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxProTamanho4)
                    .addComponent(cbxProTamanho12)
                    .addComponent(cbxProTamanhoP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxProTamanho6)
                    .addComponent(cbxProTamanho14)
                    .addComponent(cbxProTamanhoM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxProTamanho8)
                    .addComponent(cbxProTamanho16)
                    .addComponent(cbxProTamanhoG))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxProTamanho10)
                    .addComponent(cbxProTamanhoPP)
                    .addComponent(cbxProTamanhoGG))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("Preço:");

        txtProPreco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProPrecoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdbProGeneroFeminino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdbProGeneroMasculino))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbProCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtProReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtProDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbProCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtProPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rdbProGeneroFeminino)
                    .addComponent(rdbProGeneroMasculino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Categoria", "Preço", "Estoque"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblProdutos);

        jLabel6.setText("Descrição:");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setPreferredSize(new java.awt.Dimension(95, 23));
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisarDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPesquisarDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consulta", jPanel1);

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

        MenuRelatorios.setText("Relatórios");

        mnuListagemProdutos.setText("Listagem de Produtos");
        mnuListagemProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuListagemProdutosMouseClicked(evt);
            }
        });
        mnuListagemProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListagemProdutosActionPerformed(evt);
            }
        });
        MenuRelatorios.add(mnuListagemProdutos);

        jMenuBar1.add(MenuRelatorios);

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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void cmbProCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProCategoriaItemStateChanged
        Categoria categ = (Categoria)cmbProCategoria.getSelectedItem();
        System.out.println(categ.getDescricao());
    }//GEN-LAST:event_cmbProCategoriaItemStateChanged

    private void txtProPrecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProPrecoFocusLost
        if(txtProPreco.getValue() != null){
            Formatacao.formatarDecimal(txtProPreco);
        }
        txtProPreco.setBorder(new LineBorder(Color.LIGHT_GRAY));
    }//GEN-LAST:event_txtProPrecoFocusLost

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if(this.ehFormlularioValido()){
            this.cadastraProdutos();
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        gestorproduto.popularTabela(tblProdutos, txtPesquisarDescricao.getText());
        if (tblProdutos.getRowCount() > 0) {
            tblProdutos.addRowSelectionInterval(0, 0);
        }
        txtPesquisarDescricao.requestFocus();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        if(jTabbedPane1.getSelectedIndex() == 1){
            btnEditar.setEnabled(true);
            btnExcluir.setEnabled(true);
            btnConfirmar.setEnabled(false);
            if (tblProdutos.getRowCount() > 0) {
                tblProdutos.addRowSelectionInterval(0, 0);
            }
        } else {
            btnEditar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnConfirmar.setEnabled(true);
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        cod = Integer.parseInt(String.valueOf(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0)));
        listaprodutoseditar = gestorproduto.consultar("" + cod);
        
        if (listaprodutoseditar.size() > 0){
            Produto produto = new Produto();
            produto = (Produto)listaprodutoseditar.get(0);
            // Setar informações conforme produto;
            txtProReferencia.setText(produto.getReferencia() + "");
            txtProDescricao.setText(produto.getDescricao());
            txtProPreco.setText(produto.getPreco() + "");
            Formatacao.formatarDecimal(txtProPreco);
            
            for (int i = 0; i < cmbProCategoria.getItemCount(); ++i) {
                Categoria cat = (Categoria) cmbProCategoria.getItemAt(i);
                if (produto.getCategoria().getCodigo() == cat.getCodigo()) {
                   cmbProCategoria.setSelectedItem(cat);
                   break;
                }
            }
            if(produto.getGenero().equals("F")){
                rdbProGeneroFeminino.setSelected(true);
            } else {
                rdbProGeneroMasculino.setSelected(true);
            }
            for(Object pro: listaprodutoseditar){
                produto = (Produto)pro;
                cbxProTamanho4.setSelected(produto.getTamanho().trim().equals("4") ? true : cbxProTamanho4.isSelected());
                cbxProTamanho6.setSelected(produto.getTamanho().trim().equals("6") ? true : cbxProTamanho6.isSelected());
                cbxProTamanho8.setSelected(produto.getTamanho().trim().equals("8") ? true : cbxProTamanho8.isSelected());
                cbxProTamanho10.setSelected(produto.getTamanho().trim().equals("10") ? true : cbxProTamanho10.isSelected());
                cbxProTamanho12.setSelected(produto.getTamanho().trim().equals("12") ? true : cbxProTamanho12.isSelected());
                cbxProTamanho14.setSelected(produto.getTamanho().trim().equals("14") ? true : cbxProTamanho14.isSelected());
                cbxProTamanho16.setSelected(produto.getTamanho().trim().equals("16") ? true : cbxProTamanho16.isSelected());
                cbxProTamanhoPP.setSelected(produto.getTamanho().trim().equals("PP") ? true : cbxProTamanhoPP.isSelected());
                cbxProTamanhoP.setSelected(produto.getTamanho().trim().equals("P") ? true : cbxProTamanhoP.isSelected());
                cbxProTamanhoM.setSelected(produto.getTamanho().trim().equals("M") ? true : cbxProTamanhoM.isSelected());
                cbxProTamanhoG.setSelected(produto.getTamanho().trim().equals("G") ? true : cbxProTamanhoG.isSelected());
                cbxProTamanhoGG.setSelected(produto.getTamanho().trim().equals("GG") ? true : cbxProTamanhoGG.isSelected());
            }
            jTabbedPane1.setSelectedIndex(0);
            txtProReferencia.setEnabled(false);
            txtProDescricao.requestFocus();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Confirmação de exclusão", JOptionPane.YES_NO_OPTION);
        if (resposta == 0) {

            int id = Integer.parseInt(String.valueOf(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0)));
            String retorno = gestorproduto.excluir(id);

            if (retorno == null) {
                JOptionPane.showMessageDialog(this, "Registro excluído!");
                gestorproduto.popularTabela(tblProdutos, "");
                if (tblProdutos.getRowCount() > 0) {
                    tblProdutos.addRowSelectionInterval(0, 0);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir:\n"
                        + "\n"
                        + "Mensagem técnica:\n" + retorno);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtProReferenciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProReferenciaFocusLost
        txtProReferencia.setBorder(new LineBorder(Color.LIGHT_GRAY));
    }//GEN-LAST:event_txtProReferenciaFocusLost

    private void txtProDescricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProDescricaoFocusLost
        txtProDescricao.setBorder(new LineBorder(Color.LIGHT_GRAY));
    }//GEN-LAST:event_txtProDescricaoFocusLost

    private void cmbProCategoriaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbProCategoriaFocusLost
        cmbProCategoria.setBorder(new LineBorder(Color.LIGHT_GRAY));
    }//GEN-LAST:event_cmbProCategoriaFocusLost

    private void mnuListagemProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuListagemProdutosMouseClicked
        try {
            // Compila o relatorio
            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/listagemProdutos.jrxml"));

            // Mapeia campos de parametros para o relatorio, mesmo que nao existam
            Map parametros = new HashMap();

            // Executa relatoio
            JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, ConexaoBancoDados.getInstance().getConnection());

            // Exibe resultado em video
            JasperViewer.viewReport(impressao, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
    }//GEN-LAST:event_mnuListagemProdutosMouseClicked

    private void mnuListagemProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListagemProdutosActionPerformed
        try {
            // Compila o relatorio
            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/listagemProdutos.jrxml"));

            // Mapeia campos de parametros para o relatorio, mesmo que nao existam
            Map parametros = new HashMap();

            // Executa relatoio
            JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, ConexaoBancoDados.getInstance().getConnection());

            // Exibe resultado em video
            JasperViewer.viewReport(impressao, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
    }//GEN-LAST:event_mnuListagemProdutosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuRelatorios;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JCheckBox cbxProTamanho10;
    private javax.swing.JCheckBox cbxProTamanho12;
    private javax.swing.JCheckBox cbxProTamanho14;
    private javax.swing.JCheckBox cbxProTamanho16;
    private javax.swing.JCheckBox cbxProTamanho4;
    private javax.swing.JCheckBox cbxProTamanho6;
    private javax.swing.JCheckBox cbxProTamanho8;
    private javax.swing.JCheckBox cbxProTamanhoG;
    private javax.swing.JCheckBox cbxProTamanhoGG;
    private javax.swing.JCheckBox cbxProTamanhoM;
    private javax.swing.JCheckBox cbxProTamanhoP;
    private javax.swing.JCheckBox cbxProTamanhoPP;
    private javax.swing.JComboBox<Object> cmbProCategoria;
    private javax.swing.ButtonGroup grp_genero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem mnuListagemProdutos;
    private javax.swing.JRadioButton rdbProGeneroFeminino;
    private javax.swing.JRadioButton rdbProGeneroMasculino;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtPesquisarDescricao;
    private javax.swing.JTextField txtProDescricao;
    private javax.swing.JFormattedTextField txtProPreco;
    private javax.swing.JTextField txtProReferencia;
    // End of variables declaration//GEN-END:variables

    private ArrayList<String> gerarListaTamanhos(){
        ArrayList<String> listatamanhos;
        listatamanhos = new ArrayList<>();
        if(this.cbxProTamanho4.isSelected()){
            String tamanho = "4";
            listatamanhos.add(tamanho);
        }
        if(this.cbxProTamanho6.isSelected()){
            String tamanho = "6";
            listatamanhos.add(tamanho);
        }
        if(this.cbxProTamanho8.isSelected()){
            String tamanho = "8";
            listatamanhos.add(tamanho);
        }
        if(this.cbxProTamanho10.isSelected()){
            String tamanho = "10";
            listatamanhos.add(tamanho);
        }
        if(this.cbxProTamanho12.isSelected()){
            String tamanho = "12";
            listatamanhos.add(tamanho);
        }
        if(this.cbxProTamanho14.isSelected()){
            String tamanho = "14";
            listatamanhos.add(tamanho);
        }
        if(this.cbxProTamanho16.isSelected()){
            String tamanho = "16";
            listatamanhos.add(tamanho);
        }
        if(this.cbxProTamanhoPP.isSelected()){
            String tamanho = "PP";
            listatamanhos.add(tamanho);
        }
        if(this.cbxProTamanhoP.isSelected()){
            String tamanho = "P";
            listatamanhos.add(tamanho);
        }
        if(this.cbxProTamanhoM.isSelected()){
            String tamanho = "M";
            listatamanhos.add(tamanho);
        }
        if(this.cbxProTamanhoG.isSelected()){
            String tamanho = "G";
            listatamanhos.add(tamanho);
        }
        if(this.cbxProTamanhoGG.isSelected()){
            String tamanho = "GG";
            listatamanhos.add(tamanho);
        }        
        return listatamanhos;
    }
      
    private void LimparTela() {
        this.cod = 0;
        this.txtProReferencia.setText("");
        this.txtProDescricao.setText("");
        this.txtProPreco.setText("");
        this.cmbProCategoria.setSelectedIndex(cmbProCategoria.getItemCount() - 1);
        this.rdbProGeneroFeminino.setSelected(true);
        this.cbxProTamanho4.setSelected(false);
        this.cbxProTamanho6.setSelected(false);
        this.cbxProTamanho8.setSelected(false);
        this.cbxProTamanho10.setSelected(false);
        this.cbxProTamanho12.setSelected(false);
        this.cbxProTamanho14.setSelected(false);
        this.cbxProTamanho16.setSelected(false);
        this.cbxProTamanhoPP.setSelected(false);
        this.cbxProTamanhoP.setSelected(false);
        this.cbxProTamanhoM.setSelected(false);
        this.cbxProTamanhoG.setSelected(false);
        this.cbxProTamanhoGG.setSelected(false);
        this.txtProReferencia.setEnabled(true);
        this.txtProReferencia.requestFocus();
    }

    private void carregarCombo() {
        Categoria cat = new Categoria();
        ArrayList<Object> listacategorias = new ArrayList<>();
        cat.setCodigo(0);
        cat.setDescricao("");
        listacategorias = gestorcategoria.consultarTodos();
        listacategorias.add(cat);
        for(Object c: listacategorias){
            cmbProCategoria.addItem(c);
        }
    }
    
    private boolean ehFormlularioValido(){
        Boolean valido = true;
        String mensagem = "Os seguintes campos estão preenchidos de forma incorreta: \n";
        
        if(this.gerarListaTamanhos().isEmpty()){
            valido = false;
            mensagem = mensagem + "- Tamanho \n";
        }
        if(cmbProCategoria.getSelectedItem().toString().equals("")){
            valido = false;
            mensagem = mensagem + "- Categoria \n";
            cmbProCategoria.setBorder(new LineBorder(Color.red));
        }
        if(this.txtProPreco.getText().isEmpty() || Formatacao.getDecimal(txtProPreco.getText()) < 0){
            valido = false;
            txtProPreco.setBorder(new LineBorder(Color.RED));
            mensagem = mensagem + "- Preço \n";
        }
        if(this.txtProDescricao.getText().isEmpty() || this.txtProDescricao.getText().equals(" ")) {
            valido = false;
            txtProDescricao.setBorder(new LineBorder(Color.RED));
            mensagem = mensagem + "- Descrição \n";
        }
        if(this.txtProReferencia.getText().isEmpty() || this.txtProReferencia.getText().equals(" ") ||
           (this.gestorproduto.existeReferencia(Integer.parseInt(this.txtProReferencia.getText())) && this.txtProReferencia.isEnabled())){
            valido = false;
            txtProReferencia.setBorder(new LineBorder(Color.RED));
            mensagem = mensagem + "- Referência \n";
        }
        if (!valido) {
            JOptionPane.showMessageDialog(this, mensagem);
        }
        txtProReferencia.requestFocus();
        return valido;
    }

    private void cadastraProdutos(){
        String retorno = null;
        ArrayList<String> listatamanhos = this.gerarListaTamanhos();
        if(cod != 0){
            gestorproduto.excluir(cod);
        }
        for(String tam: listatamanhos){
            Produto produto = new Produto();
            produto.setCodigo(cod);
            produto.setReferencia(Integer.parseInt(txtProReferencia.getText()));
            produto.setDescricao(txtProDescricao.getText());
            produto.setCategoria((Categoria)cmbProCategoria.getSelectedItem());
            produto.setPreco(Formatacao.getDecimal(txtProPreco.getText()));
            produto.setGenero(rdbProGeneroFeminino.isSelected() ? "F" : "M");
            produto.setTamanho(tam);
            retorno = gestorproduto.salvar(produto);
        }
        if (retorno == null){
            JOptionPane.showMessageDialog(this, "Salvo com sucesso.");
            gestorproduto.popularTabela(tblProdutos, "");
            if (tblProdutos.getRowCount() > 0) {
                tblProdutos.addRowSelectionInterval(0, 0);
            }
            LimparTela();
        } else {
            JOptionPane.showMessageDialog(this, "Problemas ao salvar.\n"
                                              + "\n"
                                              + "Informações: " + retorno);
        }
    }
    
}


