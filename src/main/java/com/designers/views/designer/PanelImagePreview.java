/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.designers.views.designer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class PanelImagePreview extends javax.swing.JPanel {

    private File image;
    private byte[] fotoCargadaBytes;
    
    private AddProjectWindow addProjectWindow;

    /**
     * Creates new form PanelImagePreview
     */
    public PanelImagePreview() {
        initComponents();

    }

    public PanelImagePreview(File image, AddProjectWindow  addProjectWindow) {
        initComponents();

        this.image = image;
        this.addProjectWindow = addProjectWindow;
        initData();
    }

    private void initData() {

        try {

            this.fotoCargadaBytes = Files.readAllBytes(image.toPath());
            // Cargamos la foto
            this.panelImage.setIcon(new ImageIcon(this.fotoCargadaBytes));

            this.panelImage.revalidate();
            this.panelImage.repaint();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar la foto seleccionada");
            System.out.println("Error al cargar la foto: " + e.getMessage());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonClose = new javax.swing.JButton();
        panelImage = new org.edisoncor.gui.panel.PanelImage();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonClose.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonClose.setForeground(new java.awt.Color(153, 153, 153));
        buttonClose.setText("X");
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });
        add(buttonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 6, -1, -1));

        javax.swing.GroupLayout panelImageLayout = new javax.swing.GroupLayout(panelImage);
        panelImage.setLayout(panelImageLayout);
        panelImageLayout.setHorizontalGroup(
            panelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );
        panelImageLayout.setVerticalGroup(
            panelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );

        add(panelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        // TODO add your handling code here:
        
        this.addProjectWindow.deleteImage(this.image);
    }//GEN-LAST:event_buttonCloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClose;
    private org.edisoncor.gui.panel.PanelImage panelImage;
    // End of variables declaration//GEN-END:variables
}
