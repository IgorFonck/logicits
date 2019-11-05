/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import javax.swing.JButton;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

/**
 *
 * @author Igor
 */
public class jfApoio extends javax.swing.JFrame {

    /**
     * Creates new form jfApoio
     * @param conteudo
     */
    public jfApoio(String conteudo) {
        
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        
        MouseAdapter maGrey = new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ((JButton)evt.getSource()).setBackground(new Color(207, 207, 207));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                ((JButton)evt.getSource()).setBackground(new Color(240, 240, 240));
            }
        };
        
        jbFechar.addMouseListener(maGrey);
        
        jepApoio.setEditable(false);
        HTMLEditorKit kit = new HTMLEditorKit();
        jepApoio.setEditorKit(kit);
        
        // Estilos para o HTML
        StyleSheet styleSheet = kit.getStyleSheet();
        styleSheet.addRule("body {color:#000; font-family:Arial; margin: 10px; }");
        styleSheet.addRule("span {font-size: 1.2em; }");
        styleSheet.addRule("table {font-size: 1.05em; margin: 5px 0; }");
        styleSheet.addRule("h1 {color: #009045; font-size: 1.4em;}");
        styleSheet.addRule("h2 {font-size: 1.22em;}");
        styleSheet.addRule("h3 {margin-top: 20px; font-size: 1.2em;}");
        
        // Lê arquivo inteiro para uma String
        StringBuilder contentBuilder = new StringBuilder();
        try {
            Reader fileReader = new FileReader(System.getProperty("user.dir")+"/src/pages/"+conteudo+".html");
            BufferedReader in = new BufferedReader(fileReader);
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
            System.err.println(e);
        }
        String content = contentBuilder.toString();
        
        // Cria um documento, adiciona ao jEditorPane, adiciona o HTML
        Document doc = kit.createDefaultDocument();
        jepApoio.setDocument(doc);
        jepApoio.setText(content);
        jepApoio.setCaretPosition(0);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jspApoio = new javax.swing.JScrollPane();
        jepApoio = new javax.swing.JEditorPane();
        jbFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LogicITS | Material de apoio");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(128, 128, 128));
        setBounds(new java.awt.Rectangle(10, 10, 10, 10));

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));

        jspApoio.setViewportView(jepApoio);

        jbFechar.setText("Fechar");
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspApoio, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jspApoio, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        
        dispose();
        
    }//GEN-LAST:event_jbFecharActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbFechar;
    private javax.swing.JEditorPane jepApoio;
    private javax.swing.JScrollPane jspApoio;
    // End of variables declaration//GEN-END:variables
}
