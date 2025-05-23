/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.designers.views.designer;

import com.designer.views.HomeWindow;
import com.designers.dao.CareersDao;
import com.designers.dao.Dao;
import com.designers.domain.Career;
import com.designers.domain.Profile;
import com.designers.domain.Skill;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ProfileWindow extends javax.swing.JFrame {

    private Profile loggedProfile;
    
    private HomeWindow homeWindow;
    private Skill skill;
    /**
     * Creates new form ProfileWindow
     */
    public ProfileWindow() {
        initComponents();
    }
    
    public ProfileWindow(Profile loggedProfile, HomeWindow homeWindow) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.loggedProfile = loggedProfile;
        this.homeWindow = homeWindow; 
        
        initData();
    }
    
    private void initData() {
        
        this.labelName.setText(this.loggedProfile.getName());
        this.fieldName.setText(this.loggedProfile.getName());
        this.fieldLastname.setText(this.loggedProfile.getLastname());
        this.fieldPhone.setText(this.loggedProfile.getPhone());
        this.textSummary.setText(this.loggedProfile.getSummary());
        
        // Init combo box
        List<Career> careers = CareersDao.getAllCareers();
        this.comboCarrera.removeAllItems();
        
        for (Career career : careers) {
            this.comboCarrera.addItem(career.getName());
            if (this.loggedProfile.getCareerId() == career.getIdCareer())
                this.comboCarrera.setSelectedItem(career.getName());
        }
        
        this.skill = Dao.getSkillsByProfileId(this.loggedProfile.getIdProfile())
                .stream()
                .findFirst()
                .orElse(null);
        
        if (this.skill != null)
            this.textSkills.setText(this.skill.getDescription());
        
        this.comboCarrera.revalidate();
        this.comboCarrera.repaint();
        
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
        jSeparator1 = new javax.swing.JSeparator();
        labelName = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        fieldName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        fieldLastname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        fieldPhone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comboCarrera = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        buttonSave = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        buttonAddCareer = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textSummary = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textSkills = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        labelName.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        labelName.setForeground(new java.awt.Color(0, 153, 204));
        labelName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelName.setText("Nombre del perfil");

        fieldName.setBackground(new java.awt.Color(255, 255, 255));
        fieldName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fieldName.setForeground(new java.awt.Color(102, 102, 102));
        fieldName.setText("Ingresa tu nombre");
        fieldName.setBorder(null);

        jLabel2.setText("Nombre");

        fieldLastname.setBackground(new java.awt.Color(255, 255, 255));
        fieldLastname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fieldLastname.setForeground(new java.awt.Color(102, 102, 102));
        fieldLastname.setText("Ingresa tus apellidos");
        fieldLastname.setBorder(null);

        jLabel3.setText("Apellidos");

        fieldPhone.setBackground(new java.awt.Color(255, 255, 255));
        fieldPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fieldPhone.setForeground(new java.awt.Color(102, 102, 102));
        fieldPhone.setText("44213456778");
        fieldPhone.setBorder(null);

        jLabel4.setText("Telefono");

        comboCarrera.setBackground(new java.awt.Color(255, 255, 255));
        comboCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Carrera estudiada");

        buttonSave.setBackground(new java.awt.Color(0, 153, 204));
        buttonSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonSave.setForeground(new java.awt.Color(255, 255, 255));
        buttonSave.setText("Guardar");
        buttonSave.setBorderPainted(false);
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        jLabel6.setText("No encuentras tu carrera?");

        buttonAddCareer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonAddCareer.setForeground(new java.awt.Color(0, 102, 153));
        buttonAddCareer.setText("Agrega una nueva");
        buttonAddCareer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonAddCareer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAddCareerMouseClicked(evt);
            }
        });

        jLabel7.setText("Descripcion sobre ti");

        textSummary.setBackground(new java.awt.Color(255, 255, 255));
        textSummary.setColumns(20);
        textSummary.setLineWrap(true);
        textSummary.setRows(5);
        jScrollPane1.setViewportView(textSummary);

        jLabel8.setText("Aptitudes");

        textSkills.setBackground(new java.awt.Color(255, 255, 255));
        textSkills.setColumns(20);
        textSkills.setLineWrap(true);
        textSkills.setRows(5);
        jScrollPane3.setViewportView(textSkills);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                            .addComponent(labelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator2)
                                    .addComponent(fieldName)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator3)
                                    .addComponent(fieldLastname)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(fieldPhone, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboCarrera, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonAddCareer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(labelName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(buttonAddCareer))
                .addGap(18, 18, 18)
                .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
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
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        // TODO add your handling code here:

        String name = this.fieldName.getText();
        String lastname = this.fieldLastname.getText(); 
        String phone = this.fieldPhone.getText();
        String summary = this.textSummary.getText();
        String careerName = this.comboCarrera.getSelectedItem().toString();
        
        String skills = this.textSkills.getText();
        
        Career career = CareersDao.getCareerByName(careerName);
        
        this.loggedProfile.setName(name);
        this.loggedProfile.setLastname(lastname);
        this.loggedProfile.setPhone(phone);
        this.loggedProfile.setSummary(summary);
        
        this.loggedProfile.setCareerId(career.getIdCareer());
        
        if (Dao.updateProfile(loggedProfile)) {
            
            if (this.skill != null) {
                this.skill.setDescription(skills);
                
                if (!Dao.updateSkill(skill)) {
                    JOptionPane.showMessageDialog(null, "Error al actualizara las aptitudes");
                    return;
                }
            } else {
                
                Skill newSkill = new Skill(skills, skills, this.loggedProfile.getIdProfile());
                
                if (!Dao.registerSkill(newSkill)) {
                    JOptionPane.showMessageDialog(null, "Error al crear las skills");
                    return;
                }
            }
            
            JOptionPane.showMessageDialog(null, "Informacion actualizada correctamente");
            this.dispose();
            this.homeWindow.initUserData();
        } else
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar. Intentalo mas tarde");
        
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void buttonAddCareerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddCareerMouseClicked
        // TODO add your handling code here:
        
        String careerName = JOptionPane.showInputDialog(null, "Ingresa el nombre de la carrera");
        if (careerName == null || careerName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO se ingreso un nombre de carrera valido");
            return;
        }
        
        // Creamos la carrera
        Career newCareer = new Career(careerName);
        if (CareersDao.saveCareer(newCareer)) {
            JOptionPane.showMessageDialog(null, "Carrera creada con el nombre de: " + careerName);
            this.initData();
        } else 
            JOptionPane.showMessageDialog(null, "Ocurrio un error al agregar la carrera. Intentalo mas tarde");
    }//GEN-LAST:event_buttonAddCareerMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProfileWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfileWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfileWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfileWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfileWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel buttonAddCareer;
    private javax.swing.JButton buttonSave;
    private javax.swing.JComboBox<String> comboCarrera;
    private javax.swing.JTextField fieldLastname;
    private javax.swing.JTextField fieldName;
    private javax.swing.JTextField fieldPhone;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel labelName;
    private javax.swing.JTextArea textSkills;
    private javax.swing.JTextArea textSummary;
    // End of variables declaration//GEN-END:variables
}
