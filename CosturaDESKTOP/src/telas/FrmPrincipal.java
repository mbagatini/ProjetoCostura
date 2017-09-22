package telas;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FrmPrincipal extends javax.swing.JFrame {

    public FrmPrincipal() {
        initComponents();
        this.setResizable(false);
        this.setTitle("Costura Virtual 1.0");
        this.setLocationRelativeTo(null);
        btn_compras_materiais.setEnabled(false);
        btn_compras_notas.setEnabled(false);
        btn_compras_fornecedores.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_vendas_pedidos = new javax.swing.JButton();
        btn_vendas_notas = new javax.swing.JButton();
        btn_vendas_clientes = new javax.swing.JButton();
        btn_vendas_pagamentos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_producao_ordens = new javax.swing.JButton();
        btn_producao_produtos = new javax.swing.JButton();
        btn_compras_fornecedores = new javax.swing.JButton();
        btn_compras_materiais = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btn_compras_notas = new javax.swing.JButton();
        btn_producao_categoria = new javax.swing.JButton();
        btn_compras_notas1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 600));

        btn_vendas_pedidos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_vendas_pedidos.setText("PEDIDOS");
        btn_vendas_pedidos.setPreferredSize(new java.awt.Dimension(80, 30));
        btn_vendas_pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vendas_pedidosActionPerformed(evt);
            }
        });

        btn_vendas_notas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_vendas_notas.setText("NOTAS");
        btn_vendas_notas.setPreferredSize(new java.awt.Dimension(80, 30));
        btn_vendas_notas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vendas_notasActionPerformed(evt);
            }
        });

        btn_vendas_clientes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_vendas_clientes.setText("CLIENTES");
        btn_vendas_clientes.setPreferredSize(new java.awt.Dimension(80, 30));
        btn_vendas_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vendas_clientesActionPerformed(evt);
            }
        });

        btn_vendas_pagamentos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_vendas_pagamentos.setText("PAGAMENTOS");
        btn_vendas_pagamentos.setPreferredSize(new java.awt.Dimension(80, 30));
        btn_vendas_pagamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vendas_pagamentosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("VENDAS");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PRODUÇÃO");

        btn_producao_ordens.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_producao_ordens.setText("ORDENS");
        btn_producao_ordens.setActionCommand("ORDEBS");
        btn_producao_ordens.setPreferredSize(new java.awt.Dimension(80, 30));
        btn_producao_ordens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_producao_ordensActionPerformed(evt);
            }
        });

        btn_producao_produtos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_producao_produtos.setText("PRODUTOS");
        btn_producao_produtos.setToolTipText("");
        btn_producao_produtos.setPreferredSize(new java.awt.Dimension(80, 30));
        btn_producao_produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_producao_produtosActionPerformed(evt);
            }
        });

        btn_compras_fornecedores.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_compras_fornecedores.setText("FORNECEDORES");
        btn_compras_fornecedores.setPreferredSize(new java.awt.Dimension(80, 30));
        btn_compras_fornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_compras_fornecedoresActionPerformed(evt);
            }
        });

        btn_compras_materiais.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_compras_materiais.setText("MATERIAIS");
        btn_compras_materiais.setPreferredSize(new java.awt.Dimension(80, 30));
        btn_compras_materiais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_compras_materiaisActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("COMPRAS");

        btn_compras_notas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_compras_notas.setText("NOTAS");
        btn_compras_notas.setPreferredSize(new java.awt.Dimension(80, 30));
        btn_compras_notas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_compras_notasActionPerformed(evt);
            }
        });

        btn_producao_categoria.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_producao_categoria.setText("CATEGORIA");
        btn_producao_categoria.setPreferredSize(new java.awt.Dimension(80, 30));
        btn_producao_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_producao_categoriaActionPerformed(evt);
            }
        });

        btn_compras_notas1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_compras_notas1.setText("BACKUP");
        btn_compras_notas1.setPreferredSize(new java.awt.Dimension(80, 30));
        btn_compras_notas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_compras_notas1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_vendas_clientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_vendas_pedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_vendas_notas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_vendas_pagamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_producao_ordens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_producao_produtos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_compras_materiais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_compras_fornecedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_compras_notas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_producao_categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_compras_notas1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_vendas_pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_vendas_notas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_vendas_pagamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_vendas_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_producao_ordens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_producao_produtos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_producao_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_compras_materiais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_compras_fornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_compras_notas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(btn_compras_notas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("COSTURA VIRTUAL");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_vendas_pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vendas_pedidosActionPerformed
        FrmPedidos frmPedidos = new FrmPedidos();
        frmPedidos.setVisible(true);
    }//GEN-LAST:event_btn_vendas_pedidosActionPerformed

    private void btn_vendas_notasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vendas_notasActionPerformed
        FrmNota frmNota = new FrmNota();
        frmNota.setVisible(true);
    }//GEN-LAST:event_btn_vendas_notasActionPerformed

    private void btn_vendas_pagamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vendas_pagamentosActionPerformed
        FrmPagamentos frmPagamentos = new FrmPagamentos();
        frmPagamentos.setVisible(true);
    }//GEN-LAST:event_btn_vendas_pagamentosActionPerformed

    private void btn_vendas_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vendas_clientesActionPerformed
        FrmClientes frmClientes = new FrmClientes();
        frmClientes.setVisible(true);
    }//GEN-LAST:event_btn_vendas_clientesActionPerformed

    private void btn_producao_ordensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_producao_ordensActionPerformed
        FrmOrdemProducao frmOrdem = new FrmOrdemProducao();
        frmOrdem.setVisible(true);
    }//GEN-LAST:event_btn_producao_ordensActionPerformed

    private void btn_producao_produtosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_producao_produtosActionPerformed
        FrmProdutos frmProdutos = new FrmProdutos();
        frmProdutos.setVisible(true);
    }//GEN-LAST:event_btn_producao_produtosActionPerformed

    private void btn_compras_materiaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_compras_materiaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_compras_materiaisActionPerformed

    private void btn_compras_fornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_compras_fornecedoresActionPerformed
        FrmFornecedores frmFornecedores = new FrmFornecedores();
        frmFornecedores.setVisible(true);
    }//GEN-LAST:event_btn_compras_fornecedoresActionPerformed

    private void btn_compras_notasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_compras_notasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_compras_notasActionPerformed

    private void btn_producao_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_producao_categoriaActionPerformed
        FrmCategoria frmCategoria = new FrmCategoria();
        frmCategoria.setVisible(true);
    }//GEN-LAST:event_btn_producao_categoriaActionPerformed

    private void btn_compras_notas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_compras_notas1ActionPerformed
        fazerBackup();
    }//GEN-LAST:event_btn_compras_notas1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_compras_fornecedores;
    private javax.swing.JButton btn_compras_materiais;
    private javax.swing.JButton btn_compras_notas;
    private javax.swing.JButton btn_compras_notas1;
    private javax.swing.JButton btn_producao_categoria;
    private javax.swing.JButton btn_producao_ordens;
    private javax.swing.JButton btn_producao_produtos;
    private javax.swing.JButton btn_vendas_clientes;
    private javax.swing.JButton btn_vendas_notas;
    private javax.swing.JButton btn_vendas_pagamentos;
    private javax.swing.JButton btn_vendas_pedidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    private void fazerBackup() {
        try {
            JFileChooser fc = new JFileChooser();
            // restringe a amostra a diretorios apenas
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int res = fc.showSaveDialog(null);
            if (res != JFileChooser.APPROVE_OPTION) {
                return;
            }
            
            File diretorio = fc.getSelectedFile();
            
            String caminhoDestino = diretorio.getPath()+ "\\costura.backup";
            ProcessBuilder pb;
            Process p;
            // ajustar o caminho do executavel de acordo com o SO
            // aqui foi considerado usuario: postgres banco: emprestimos
            // o caminho de destino pode ser solicitado ao usuário
            pb = new ProcessBuilder("\"C:\\Program Files\\PostgreSQL\\9.5\\bin\\pg_dump.exe\"", "-h", "localhost", "-p", "5432", "-U", "postgres", "-F", "c", "-b", "-v", "-f", caminhoDestino, "costura");
            // informa-se a senha: postgres
            // Carrega informações do arquivo de propriedades
            Properties prop = new Properties();
            prop.load(new FileInputStream("db.properties"));
            String dbsenha = prop.getProperty("db.senha");
            
            pb.environment().put("PGPASSWORD", dbsenha);
            pb.redirectErrorStream(true);
            p = pb.start();
            JOptionPane.showMessageDialog(null, "Backup gerado com sucesso");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar backup: " + ex);
        }
    }
}
