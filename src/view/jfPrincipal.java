/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.Exercicio;
import control.Tutor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Atividade;
import model.AtividadeDAO;

/**
 *
 * @author igorfonseca
 */
public class jfPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form jfPrincipal
     */
    public jfPrincipal() {

        initComponents();
        
        // Seleciona a atividade a ser mostrada
        ativ = Tutor.selecAtividade();
        
        // Formata a fórmula da atividade para ser exibida
        String exercicio = "<html><font face='Roboto'>" + ativ.getPremissas() + " |- " + ativ.getConclusao() + "</font></html>";
        exercicio = Exercicio.formatarFormula(exercicio);
        jlAtivAtual.setText(exercicio);
        
        // Mostra as premissas da atividade na resolução
        String premissas[] = Exercicio.getPremissas(exercicio);
        DefaultTableModel dtm = (DefaultTableModel) jtResolucao.getModel();
        
        
        int i = 0;
        for (String s : premissas) {
            dtm.addRow(new Object[]{++i + ".", s, "Premissa"});
        }
        
        // Configura a tabela
        jtResolucao.getTableHeader().setUI(null);
        jtResolucao.getColumnModel().getColumn(0).setMaxWidth(40);
        jtResolucao.getColumnModel().getColumn(2).setMaxWidth(85);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        jtResolucao.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        
        // Configura o painel de regras
        jbAplicarRegra.setEnabled(false);
        jbLimparLinhas.setEnabled(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSistemaProva = new javax.swing.ButtonGroup();
        jpAtividade = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jlAtivAtual = new javax.swing.JLabel();
        jpFeedback = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jbRevisar = new javax.swing.JButton();
        jbAjuda = new javax.swing.JButton();
        jpResolucao = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtResolucao = new javax.swing.JTable();
        tpRegras = new javax.swing.JTabbedPane();
        jpRegras = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btIntroConju = new javax.swing.JButton();
        btElimConju = new javax.swing.JButton();
        btIntroDisju = new javax.swing.JButton();
        btElimDisju = new javax.swing.JButton();
        btIntroImpl = new javax.swing.JButton();
        btElimImpl = new javax.swing.JButton();
        btIntroNeg = new javax.swing.JButton();
        btElimNeg = new javax.swing.JButton();
        jpConfigRegra = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jbCancelarRegra = new javax.swing.JButton();
        jlNomeRegra = new javax.swing.JLabel();
        jlLinhasSelecionadas = new javax.swing.JLabel();
        jbAplicarRegra = new javax.swing.JButton();
        jbLimparLinhas = new javax.swing.JButton();
        jmMenuSuperior = new javax.swing.JMenuBar();
        jmArquivo = new javax.swing.JMenu();
        miNovo = new javax.swing.JMenuItem();
        miAbrir = new javax.swing.JMenuItem();
        miSalvar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miUsuario = new javax.swing.JMenuItem();
        miSair = new javax.swing.JMenuItem();
        jmConfig = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmSistemaProva = new javax.swing.JMenu();
        miProposicional = new javax.swing.JRadioButtonMenuItem();
        miPredicaodos = new javax.swing.JRadioButtonMenuItem();
        miIdioma = new javax.swing.JMenuItem();
        jmAjuda = new javax.swing.JMenu();
        miGuia = new javax.swing.JMenuItem();
        miSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jpAtividade.setBackground(new java.awt.Color(218, 231, 240));

        jLabel2.setText("Atividade");

        jlAtivAtual.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlAtivAtual.setText("a -> b");

        javax.swing.GroupLayout jpAtividadeLayout = new javax.swing.GroupLayout(jpAtividade);
        jpAtividade.setLayout(jpAtividadeLayout);
        jpAtividadeLayout.setHorizontalGroup(
            jpAtividadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAtividadeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAtividadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jlAtivAtual))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpAtividadeLayout.setVerticalGroup(
            jpAtividadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAtividadeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jlAtivAtual)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jpFeedback.setBackground(new java.awt.Color(245, 228, 228));

        jLabel4.setText("Feedback");

        jbRevisar.setText("Revisar material");

        jbAjuda.setText("Solicitar ajuda");

        javax.swing.GroupLayout jpFeedbackLayout = new javax.swing.GroupLayout(jpFeedback);
        jpFeedback.setLayout(jpFeedbackLayout);
        jpFeedbackLayout.setHorizontalGroup(
            jpFeedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFeedbackLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFeedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbRevisar, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addGroup(jpFeedbackLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jbAjuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpFeedbackLayout.setVerticalGroup(
            jpFeedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFeedbackLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbAjuda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbRevisar)
                .addContainerGap())
        );

        jpResolucao.setBackground(new java.awt.Color(232, 244, 232));

        jLabel3.setText("Resolução");

        jtResolucao.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jtResolucao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtResolucao.setFillsViewportHeight(true);
        jtResolucao.setRowHeight(22);
        jtResolucao.setRowSelectionAllowed(false);
        jtResolucao.setShowHorizontalLines(false);
        jtResolucao.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jtResolucao);

        javax.swing.GroupLayout jpResolucaoLayout = new javax.swing.GroupLayout(jpResolucao);
        jpResolucao.setLayout(jpResolucaoLayout);
        jpResolucaoLayout.setHorizontalGroup(
            jpResolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpResolucaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpResolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpResolucaoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jpResolucaoLayout.setVerticalGroup(
            jpResolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpResolucaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpRegras.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        tpRegras.setEnabled(false);

        jpRegras.setBackground(new java.awt.Color(228, 213, 231));

        jLabel1.setText("Regras de inferência");

        btIntroConju.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btIntroConju.setText("<html><font face='Roboto'>∧<sub>i</sub></font></html>");
        btIntroConju.setToolTipText("Introdução da conjunção");
        btIntroConju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIntroConjuActionPerformed(evt);
            }
        });

        btElimConju.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btElimConju.setText("<html><font face='Roboto'>∧<sub>e</sub></font></html>");
        btElimConju.setToolTipText("Eliminação da conjunção");

        btIntroDisju.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btIntroDisju.setText("<html>∨<sub>i</sub></html>");
        btIntroDisju.setToolTipText("Introdução da disjunção");

        btElimDisju.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btElimDisju.setText("<html>∨<sub>e</sub></html>");
        btElimDisju.setToolTipText("Eliminação da disjunção");

        btIntroImpl.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btIntroImpl.setText("<html>→<sub>i</sub></html>");
        btIntroImpl.setToolTipText("Introdução da implicação");

        btElimImpl.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btElimImpl.setText("<html>→<sub>e</sub></html>");
        btElimImpl.setToolTipText("Eliminação da implicação");

        btIntroNeg.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btIntroNeg.setText("<html>¬<sub>i</sub></html>");
        btIntroNeg.setToolTipText("Introdução da negação");

        btElimNeg.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btElimNeg.setText("<html>¬<sub>e</sub></html>");
        btElimNeg.setToolTipText("Eliminação da negação");

        javax.swing.GroupLayout jpRegrasLayout = new javax.swing.GroupLayout(jpRegras);
        jpRegras.setLayout(jpRegrasLayout);
        jpRegrasLayout.setHorizontalGroup(
            jpRegrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegrasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpRegrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jpRegrasLayout.createSequentialGroup()
                        .addGroup(jpRegrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btIntroConju, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(btElimConju, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpRegrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btIntroDisju, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(btElimDisju, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpRegrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btIntroImpl, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(btElimImpl, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpRegrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btElimNeg, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(btIntroNeg, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))))
                .addContainerGap(438, Short.MAX_VALUE))
        );
        jpRegrasLayout.setVerticalGroup(
            jpRegrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegrasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpRegrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btIntroConju, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btIntroDisju, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btIntroImpl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btIntroNeg, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpRegrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btElimConju, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btElimDisju, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btElimImpl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btElimNeg, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        tpRegras.addTab("", jpRegras);

        jpConfigRegra.setBackground(new java.awt.Color(228, 213, 231));

        jLabel5.setText("Selecione as linhas para aplicar a regra");

        jbCancelarRegra.setText("Cancelar");
        jbCancelarRegra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarRegraActionPerformed(evt);
            }
        });

        jlNomeRegra.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jlNomeRegra.setText("<nome>");

        jlLinhasSelecionadas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlLinhasSelecionadas.setText("<selecionadas>");

        jbAplicarRegra.setText("Aplicar");
        jbAplicarRegra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAplicarRegraActionPerformed(evt);
            }
        });

        jbLimparLinhas.setText("Limpar");
        jbLimparLinhas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparLinhasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpConfigRegraLayout = new javax.swing.GroupLayout(jpConfigRegra);
        jpConfigRegra.setLayout(jpConfigRegraLayout);
        jpConfigRegraLayout.setHorizontalGroup(
            jpConfigRegraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpConfigRegraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpConfigRegraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpConfigRegraLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(4, 4, 4)
                        .addComponent(jlNomeRegra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbCancelarRegra))
                    .addComponent(jlLinhasSelecionadas)
                    .addGroup(jpConfigRegraLayout.createSequentialGroup()
                        .addComponent(jbAplicarRegra, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbLimparLinhas, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(363, Short.MAX_VALUE))
        );
        jpConfigRegraLayout.setVerticalGroup(
            jpConfigRegraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpConfigRegraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpConfigRegraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jbCancelarRegra)
                    .addComponent(jlNomeRegra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlLinhasSelecionadas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jpConfigRegraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAplicarRegra, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbLimparLinhas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tpRegras.addTab("", jpConfigRegra);

        jmArquivo.setText("Arquivo");

        miNovo.setText("Nova prova");
        jmArquivo.add(miNovo);

        miAbrir.setText("Abrir");
        jmArquivo.add(miAbrir);

        miSalvar.setText("Salvar");
        jmArquivo.add(miSalvar);
        jmArquivo.add(jSeparator1);

        miUsuario.setText("Selecionar usuário");
        miUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miUsuarioActionPerformed(evt);
            }
        });
        jmArquivo.add(miUsuario);

        miSair.setText("Sair");
        jmArquivo.add(miSair);

        jmMenuSuperior.add(jmArquivo);

        jmConfig.setText("Configurações");

        jMenuItem1.setText("Alterar domínio");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmConfig.add(jMenuItem1);

        jmSistemaProva.setText("Sistema de prova");

        bgSistemaProva.add(miProposicional);
        miProposicional.setSelected(true);
        miProposicional.setText("Lógica proposicional");
        jmSistemaProva.add(miProposicional);

        bgSistemaProva.add(miPredicaodos);
        miPredicaodos.setText("Lógica de predicados");
        jmSistemaProva.add(miPredicaodos);

        jmConfig.add(jmSistemaProva);

        miIdioma.setText("Idioma");
        jmConfig.add(miIdioma);

        jmMenuSuperior.add(jmConfig);

        jmAjuda.setText("Ajuda");

        miGuia.setText("Guia do usuário");
        jmAjuda.add(miGuia);

        miSobre.setText("Sobre");
        miSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSobreActionPerformed(evt);
            }
        });
        jmAjuda.add(miSobre);

        jmMenuSuperior.add(jmAjuda);

        setJMenuBar(jmMenuSuperior);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpAtividade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpResolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tpRegras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpResolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpRegras, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jpFeedback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
        
    private void btIntroConjuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIntroConjuActionPerformed
        
        // Configura texto das linhas selecionadas
        jlNomeRegra.setText("<html><font face='Roboto'>∧<sub>i</sub></font></html>");
        textoLinhas = "<html>";
        jlLinhasSelecionadas.setText(textoLinhas);
        contLinhas = 0;
        lastSelectedRow = -1;
        jtResolucao.clearSelection();
        linhasSelec = new int[2];
        
        
        // Muda para a aba de selecionar linhas
        tpRegras.setSelectedIndex(1);
        
        // Verifica a seleção de linhas na tabela
        tableListener = new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent event) {
                // Adiciona a linha selecionada à lista
                if(contLinhas < 2 && jtResolucao.getSelectedRow() != lastSelectedRow) {
                    // Adiciona texto aos labels
                    String col1 = jtResolucao.getValueAt(jtResolucao.getSelectedRow(), 0).toString();
                    String col2 = jtResolucao.getValueAt(jtResolucao.getSelectedRow(), 1).toString();
                    textoLinhas = textoLinhas + col1 + " " + col2 + "<br>";
                    jlLinhasSelecionadas.setText(textoLinhas);
                    // Adiciona índice ao array
                    linhasSelec[contLinhas] = jtResolucao.getSelectedRow();
                    contLinhas++;
                }
                else if (jtResolucao.getSelectedRow() == lastSelectedRow)
                    System.out.print("");
                else
                    System.out.println("Número máximo de linhas para esta regra excedido.");
                
                lastSelectedRow = jtResolucao.getSelectedRow();
                jbLimparLinhas.setEnabled(true);
                
                System.out.println("Selecionou linha " + jtResolucao.getSelectedRow() + ".");
                
                if(contLinhas >= 2) {
                    jbAplicarRegra.setEnabled(true);
                    //System.out.println("["+linhasSelec[0]+"], ["+linhasSelec[1]+"]");
                }
            }
        };
        
        jtResolucao.getSelectionModel().addListSelectionListener(tableListener);
        
    }//GEN-LAST:event_btIntroConjuActionPerformed

    // umaFormula()
    // duasFormulas()
    // tresFormulas()
    
    private void miSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSobreActionPerformed
        
        new jfSobre().setVisible(true);
        
    }//GEN-LAST:event_miSobreActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        new jfDominio().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void miUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miUsuarioActionPerformed
        
        try {
            new jfInicial().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(jfPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
        
    }//GEN-LAST:event_miUsuarioActionPerformed

    private void jbCancelarRegraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarRegraActionPerformed
        
        fecharConfig();
        
    }//GEN-LAST:event_jbCancelarRegraActionPerformed

    private void jbLimparLinhasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparLinhasActionPerformed
        
        limparLinhas();
        
    }//GEN-LAST:event_jbLimparLinhasActionPerformed

    private void jbAplicarRegraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAplicarRegraActionPerformed
        
        // Introdução da conjunção
        String col1 = jtResolucao.getRowCount()+1 + ".";
        String col2 = "<html>(" + jtResolucao.getValueAt(linhasSelec[0], 1).toString() + ") ∧ (" + jtResolucao.getValueAt(linhasSelec[1], 1).toString() + ")";
        String col3 = "<html>∧<sub>i</sub> " + (linhasSelec[0]+1) + ", " + (linhasSelec[1]+1) + "";
        
        DefaultTableModel dtm = (DefaultTableModel) jtResolucao.getModel();
        dtm.addRow(new Object[]{col1, col2, col3});
        
        fecharConfig();
        
    }//GEN-LAST:event_jbAplicarRegraActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgSistemaProva;
    private javax.swing.JButton btElimConju;
    private javax.swing.JButton btElimDisju;
    private javax.swing.JButton btElimImpl;
    private javax.swing.JButton btElimNeg;
    private javax.swing.JButton btIntroConju;
    private javax.swing.JButton btIntroDisju;
    private javax.swing.JButton btIntroImpl;
    private javax.swing.JButton btIntroNeg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JButton jbAjuda;
    private javax.swing.JButton jbAplicarRegra;
    private javax.swing.JButton jbCancelarRegra;
    private javax.swing.JButton jbLimparLinhas;
    private javax.swing.JButton jbRevisar;
    private javax.swing.JLabel jlAtivAtual;
    private javax.swing.JLabel jlLinhasSelecionadas;
    private javax.swing.JLabel jlNomeRegra;
    private javax.swing.JMenu jmAjuda;
    private javax.swing.JMenu jmArquivo;
    private javax.swing.JMenu jmConfig;
    private javax.swing.JMenuBar jmMenuSuperior;
    private javax.swing.JMenu jmSistemaProva;
    private javax.swing.JPanel jpAtividade;
    private javax.swing.JPanel jpConfigRegra;
    private javax.swing.JPanel jpFeedback;
    private javax.swing.JPanel jpRegras;
    private javax.swing.JPanel jpResolucao;
    private javax.swing.JTable jtResolucao;
    private javax.swing.JMenuItem miAbrir;
    private javax.swing.JMenuItem miGuia;
    private javax.swing.JMenuItem miIdioma;
    private javax.swing.JMenuItem miNovo;
    private javax.swing.JRadioButtonMenuItem miPredicaodos;
    private javax.swing.JRadioButtonMenuItem miProposicional;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JMenuItem miSalvar;
    private javax.swing.JMenuItem miSobre;
    private javax.swing.JMenuItem miUsuario;
    private javax.swing.JTabbedPane tpRegras;
    // End of variables declaration//GEN-END:variables

    private Atividade ativ = new Atividade();
    private AtividadeDAO ativ_dao = new AtividadeDAO();
    
    // Variáveis da aplicação de regras
    private String textoLinhas;
    private int contLinhas;
    private int lastSelectedRow;
    private int linhasSelec[];
    
    private ListSelectionListener tableListener;
    
    private void limparLinhas() {
        jtResolucao.getSelectionModel().removeListSelectionListener(tableListener);
        
        textoLinhas = "<html>";
        jlLinhasSelecionadas.setText(textoLinhas);
        contLinhas = 0;
        lastSelectedRow = -1;
        jtResolucao.clearSelection();
        
        jbAplicarRegra.setEnabled(false);
        jbLimparLinhas.setEnabled(false);
        
        jtResolucao.getSelectionModel().addListSelectionListener(tableListener);
    }
    
    private void fecharConfig() {
        limparLinhas();
        jtResolucao.getSelectionModel().removeListSelectionListener(tableListener);
        tpRegras.setSelectedIndex(0);        
    }

}
