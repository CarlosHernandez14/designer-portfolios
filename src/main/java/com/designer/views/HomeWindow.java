/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.designer.views;

import com.designers.dao.CareersDao;
import com.designers.dao.Dao;
import com.designers.dao.ProjectsDao;
import com.designers.domain.Career;
import com.designers.domain.Profile;
import com.designers.domain.Project;
import com.designers.domain.Skill;
import com.designers.domain.User;
import com.designers.utils.WrapLayout;
import com.designers.views.designer.AddProjectWindow;
import com.designers.views.designer.ProfileWindow;
import com.formdev.flatlaf.ui.FlatButtonBorder;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author carlo
 */
public class HomeWindow extends javax.swing.JFrame {

    
    private User loggedUser;
    private Profile profile;
    private Dao dao;
    
    private List<Profile> designers;
    
    /**
     * Creates new form HomeWindow
     */
    public HomeWindow() {
        initComponents();
        this.dao = new Dao();
        this.setLocationRelativeTo(null);
        WrapLayout wrapLayout = new WrapLayout();
        wrapLayout.setHgap(50);
        wrapLayout.setVgap(20);
        
        // Set the layouts for the scroll tabs
        this.containerCards.setLayout(wrapLayout);
        this.containeDesigners.setLayout(wrapLayout);
        this.containerCardsPortfolio.setLayout(wrapLayout);
        
        this.panelCareers.setLayout(new FlowLayout());
        

        this.fieldSearch.setVisible(false);
        this.buttonSearch.setVisible(false);
        
        initData();
        
        
    }
    
    public HomeWindow(User loggedUser) {
        initComponents();
        this.dao = new Dao();
        
        
        this.setLocationRelativeTo(null);
        WrapLayout wrapLayout = new WrapLayout();
        wrapLayout.setHgap(50);
        wrapLayout.setVgap(20);
        
        // Set the layouts for the scroll tabs
        this.containerCards.setLayout(wrapLayout);
        this.containeDesigners.setLayout(wrapLayout);
        this.containerCardsPortfolio.setLayout(wrapLayout);
        
        this.panelCareers.setLayout(new FlowLayout());
        
        this.loggedUser = loggedUser;
        
        this.fieldSearch.setVisible(false);
        this.buttonSearch.setVisible(false);
        // Init user data
        initUserData();
        
        initData();
        
        
    }
    
    public void initUserData() {
        // Get the profile from the logged user
        this.profile = this.dao.getProfileByUserId(this.loggedUser.getIdUser());
        
        if (profile != null) {
            this.buttonLogin.setText(this.profile.getName());
        } else 
            this.buttonLogin.setText(this.loggedUser.getEmail());
    }
    
    private void initData() {
        if (this.loggedUser == null)
            this.buttonMyPortfolio.setVisible(false);

        initCareers();
        initProjects();
        initDesigners();
//        initMyPortfolios();
        
    }
    
    public void initProjects() {
        this.containerCards.removeAll();
        
        List<Project> projects = ProjectsDao.getAllProjects();
        
        for (Project project : projects) {
            PanelCard pC = new PanelCard(project);
            this.containerCards.add(pC);
        }
        
        this.containerCards.revalidate();
        this.containerCards.repaint();
    }
    
    public void initCareers() {
        // Initalize available careers
        this.panelCareers.removeAll();
        
        List<Career> careers = CareersDao.getAllCareers();
        
        for (Career career : careers) {
            PanelCategory pCat = new PanelCategory(career.getName(), this);
            this.panelCareers.add(pCat);
        }
        
        this.panelCareers.revalidate();
        this.panelCareers.repaint();
    }
    
    public void initDesigners() {
        
        // Initialize designers
        this.containeDesigners.removeAll();
        
        this.designers = Dao.getAllProfiles();
        
        for (Profile profileDesigner : designers) {
            PanelDesigner designer = new PanelDesigner(profileDesigner);
            this.containeDesigners.add(designer);
        }
        
        this.containeDesigners.revalidate();
        this.containeDesigners.repaint();
        
    }
    
    public void initMyPortfolios() {
        
        this.containerCardsPortfolio.removeAll();
        
        List<Project> projects = ProjectsDao.getProjectsByProfileId(this.profile.getIdProfile());
        
        for (Project project : projects) {
            System.out.println("INIT MY PORTFOLIOS");
            System.out.println(project);
            PanelCard pC = new PanelCard(project);
            this.containerCardsPortfolio.add(pC);
        }
        
        this.containerCardsPortfolio.revalidate();
        this.containerCardsPortfolio.repaint();
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupProfile = new javax.swing.JPopupMenu();
        itemEditProfile = new javax.swing.JMenuItem();
        itemLogout = new javax.swing.JMenuItem();
        itemCv = new javax.swing.JMenuItem();
        panelFram = new javax.swing.JPanel();
        panelNavbar = new javax.swing.JPanel();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        buttonProjects = new javax.swing.JButton();
        buttonDesigners = new javax.swing.JButton();
        buttonLogin = new javax.swing.JButton();
        buttonMyPortfolio = new javax.swing.JButton();
        fieldSearch = new javax.swing.JTextField();
        buttonSearch = new javax.swing.JButton();
        containerSubMenu = new javax.swing.JPanel();
        scrollCareers = new javax.swing.JScrollPane();
        panelCareers = new javax.swing.JPanel();
        tabbedPainBody = new javax.swing.JTabbedPane();
        scrollCards = new javax.swing.JScrollPane();
        containerCards = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        scrollDesigners = new javax.swing.JScrollPane();
        containeDesigners = new javax.swing.JPanel();
        containerMyPortfolio = new javax.swing.JPanel();
        buttonAddProjects = new javax.swing.JButton();
        scrollMyPortfolio = new javax.swing.JScrollPane();
        containerCardsPortfolio = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        itemEditProfile.setText("Editar Perfil");
        itemEditProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditProfileActionPerformed(evt);
            }
        });
        popupProfile.add(itemEditProfile);

        itemLogout.setText("Cerrar sesion");
        itemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLogoutActionPerformed(evt);
            }
        });
        popupProfile.add(itemLogout);

        itemCv.setText("Mi CV");
        itemCv.setToolTipText("");
        itemCv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCvActionPerformed(evt);
            }
        });
        popupProfile.add(itemCv);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFram.setBackground(new java.awt.Color(247, 247, 247));
        panelFram.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelNavbar.setBackground(new java.awt.Color(255, 255, 255));
        panelNavbar.setBorder(new org.edisoncor.gui.util.DropShadowBorder());

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/DesignersLogo.png"))); // NOI18N

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        buttonProjects.setBackground(new java.awt.Color(255, 255, 255));
        buttonProjects.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        buttonProjects.setForeground(new java.awt.Color(102, 102, 102));
        buttonProjects.setText("Proyectos");
        buttonProjects.setBorder(new FlatButtonBorder());
        buttonProjects.setBorderPainted(false);
        buttonProjects.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonProjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonProjectsMouseClicked(evt);
            }
        });
        buttonProjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProjectsActionPerformed(evt);
            }
        });

        buttonDesigners.setBackground(new java.awt.Color(255, 255, 255));
        buttonDesigners.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        buttonDesigners.setForeground(new java.awt.Color(102, 102, 102));
        buttonDesigners.setText("Diseñadores");
        buttonDesigners.setBorder(new FlatButtonBorder());
        buttonDesigners.setBorderPainted(false);
        buttonDesigners.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonDesigners.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonDesignersMouseClicked(evt);
            }
        });

        buttonLogin.setBackground(new java.awt.Color(255, 255, 255));
        buttonLogin.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        buttonLogin.setForeground(new java.awt.Color(0, 102, 153));
        buttonLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon-profile.png"))); // NOI18N
        buttonLogin.setText("Iniciar sesion");
        buttonLogin.setBorder(new FlatButtonBorder());
        buttonLogin.setBorderPainted(false);
        buttonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonLogin.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        buttonMyPortfolio.setBackground(new java.awt.Color(255, 255, 255));
        buttonMyPortfolio.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        buttonMyPortfolio.setForeground(new java.awt.Color(102, 102, 102));
        buttonMyPortfolio.setText("Mi Portafolio");
        buttonMyPortfolio.setBorder(new FlatButtonBorder());
        buttonMyPortfolio.setBorderPainted(false);
        buttonMyPortfolio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonMyPortfolio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonMyPortfolioMouseClicked(evt);
            }
        });
        buttonMyPortfolio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMyPortfolioActionPerformed(evt);
            }
        });

        fieldSearch.setBackground(new java.awt.Color(255, 255, 255));
        fieldSearch.setForeground(new java.awt.Color(102, 102, 102));
        fieldSearch.setText("Buscar aptitud..");
        fieldSearch.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                fieldSearchInputMethodTextChanged(evt);
            }
        });

        buttonSearch.setBackground(new java.awt.Color(255, 255, 255));
        buttonSearch.setForeground(new java.awt.Color(102, 102, 102));
        buttonSearch.setText("Buscar");
        buttonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelNavbarLayout = new javax.swing.GroupLayout(panelNavbar);
        panelNavbar.setLayout(panelNavbarLayout);
        panelNavbarLayout.setHorizontalGroup(
            panelNavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNavbarLayout.createSequentialGroup()
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonProjects, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonDesigners, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonMyPortfolio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonLogin)
                .addContainerGap())
        );
        panelNavbarLayout.setVerticalGroup(
            panelNavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNavbarLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(panelNavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonProjects, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDesigners, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMyPortfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSearch))
                .addGap(23, 23, 23))
        );

        panelFram.add(panelNavbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, -1));

        containerSubMenu.setBackground(new java.awt.Color(247, 247, 247));

        scrollCareers.setBorder(null);
        scrollCareers.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        panelCareers.setBackground(new java.awt.Color(247, 247, 247));

        javax.swing.GroupLayout panelCareersLayout = new javax.swing.GroupLayout(panelCareers);
        panelCareers.setLayout(panelCareersLayout);
        panelCareersLayout.setHorizontalGroup(
            panelCareersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 899, Short.MAX_VALUE)
        );
        panelCareersLayout.setVerticalGroup(
            panelCareersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 79, Short.MAX_VALUE)
        );

        scrollCareers.setViewportView(panelCareers);

        javax.swing.GroupLayout containerSubMenuLayout = new javax.swing.GroupLayout(containerSubMenu);
        containerSubMenu.setLayout(containerSubMenuLayout);
        containerSubMenuLayout.setHorizontalGroup(
            containerSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
            .addGroup(containerSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(containerSubMenuLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(scrollCareers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        containerSubMenuLayout.setVerticalGroup(
            containerSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 79, Short.MAX_VALUE)
            .addGroup(containerSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(containerSubMenuLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(scrollCareers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panelFram.add(containerSubMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 75, 910, -1));

        scrollCards.setBackground(new java.awt.Color(255, 255, 255));
        scrollCards.setBorder(null);
        scrollCards.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollCards.setMaximumSize(new java.awt.Dimension(897, 32767));
        scrollCards.setMinimumSize(new java.awt.Dimension(897, 5));
        scrollCards.setPreferredSize(new java.awt.Dimension(897, 100));

        containerCards.setBackground(new java.awt.Color(247, 247, 247));
        containerCards.setMaximumSize(new java.awt.Dimension(897, 32767));
        containerCards.setMinimumSize(new java.awt.Dimension(897, 110));

        jPanel1.setPreferredSize(new java.awt.Dimension(300, 200));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout containerCardsLayout = new javax.swing.GroupLayout(containerCards);
        containerCards.setLayout(containerCardsLayout);
        containerCardsLayout.setHorizontalGroup(
            containerCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerCardsLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(604, Short.MAX_VALUE))
        );
        containerCardsLayout.setVerticalGroup(
            containerCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerCardsLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(248, 248, 248))
        );

        scrollCards.setViewportView(containerCards);

        tabbedPainBody.addTab("ProjectsTab", scrollCards);

        scrollDesigners.setBackground(new java.awt.Color(255, 255, 255));
        scrollDesigners.setBorder(null);
        scrollDesigners.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollDesigners.setToolTipText("");

        containeDesigners.setBackground(new java.awt.Color(247, 247, 247));

        javax.swing.GroupLayout containeDesignersLayout = new javax.swing.GroupLayout(containeDesigners);
        containeDesigners.setLayout(containeDesignersLayout);
        containeDesignersLayout.setHorizontalGroup(
            containeDesignersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 909, Short.MAX_VALUE)
        );
        containeDesignersLayout.setVerticalGroup(
            containeDesignersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );

        scrollDesigners.setViewportView(containeDesigners);

        tabbedPainBody.addTab("DesignersTab", scrollDesigners);

        containerMyPortfolio.setBackground(new java.awt.Color(247, 247, 247));

        buttonAddProjects.setBackground(new java.awt.Color(0, 153, 204));
        buttonAddProjects.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonAddProjects.setForeground(new java.awt.Color(255, 255, 255));
        buttonAddProjects.setText("Agregar projecto");
        buttonAddProjects.setBorderPainted(false);
        buttonAddProjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddProjectsActionPerformed(evt);
            }
        });

        scrollMyPortfolio.setBackground(new java.awt.Color(255, 255, 255));
        scrollMyPortfolio.setBorder(null);
        scrollMyPortfolio.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollMyPortfolio.setMaximumSize(new java.awt.Dimension(897, 32767));
        scrollMyPortfolio.setMinimumSize(new java.awt.Dimension(897, 5));
        scrollMyPortfolio.setPreferredSize(new java.awt.Dimension(897, 100));

        containerCardsPortfolio.setBackground(new java.awt.Color(247, 247, 247));
        containerCardsPortfolio.setMaximumSize(new java.awt.Dimension(897, 32767));
        containerCardsPortfolio.setMinimumSize(new java.awt.Dimension(897, 110));

        jPanel2.setPreferredSize(new java.awt.Dimension(300, 200));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout containerCardsPortfolioLayout = new javax.swing.GroupLayout(containerCardsPortfolio);
        containerCardsPortfolio.setLayout(containerCardsPortfolioLayout);
        containerCardsPortfolioLayout.setHorizontalGroup(
            containerCardsPortfolioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerCardsPortfolioLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(594, Short.MAX_VALUE))
        );
        containerCardsPortfolioLayout.setVerticalGroup(
            containerCardsPortfolioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerCardsPortfolioLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(248, 248, 248))
        );

        scrollMyPortfolio.setViewportView(containerCardsPortfolio);

        javax.swing.GroupLayout containerMyPortfolioLayout = new javax.swing.GroupLayout(containerMyPortfolio);
        containerMyPortfolio.setLayout(containerMyPortfolioLayout);
        containerMyPortfolioLayout.setHorizontalGroup(
            containerMyPortfolioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerMyPortfolioLayout.createSequentialGroup()
                .addContainerGap(744, Short.MAX_VALUE)
                .addComponent(buttonAddProjects, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(containerMyPortfolioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scrollMyPortfolio, javax.swing.GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE))
        );
        containerMyPortfolioLayout.setVerticalGroup(
            containerMyPortfolioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerMyPortfolioLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(buttonAddProjects, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(418, Short.MAX_VALUE))
            .addGroup(containerMyPortfolioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerMyPortfolioLayout.createSequentialGroup()
                    .addGap(0, 74, Short.MAX_VALUE)
                    .addComponent(scrollMyPortfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tabbedPainBody.addTab("tab4", containerMyPortfolio);

        panelFram.add(tabbedPainBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 115, -1, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFram, javax.swing.GroupLayout.DEFAULT_SIZE, 913, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFram, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        // TODO add your handling code here:
        if (this.loggedUser != null) {
            this.popupProfile.show(this.buttonLogin, 0, this.buttonLogin.getHeight());
        } else
            new SignInWindow(this).setVisible(true);
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void buttonProjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonProjectsMouseClicked
        // TODO add your handling code here:
        this.tabbedPainBody.setSelectedIndex(0);
        this.fieldSearch.setVisible(false);
        this.buttonSearch.setVisible(false);
        initProjects();
    }//GEN-LAST:event_buttonProjectsMouseClicked

    private void buttonDesignersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDesignersMouseClicked
        // TODO add your handling code here:
        this.tabbedPainBody.setSelectedIndex(1);
        this.fieldSearch.setVisible(true);
        this.buttonSearch.setVisible(true);
        initDesigners();
    }//GEN-LAST:event_buttonDesignersMouseClicked

    private void buttonMyPortfolioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMyPortfolioMouseClicked
        // TODO add your handling code here:
        this.tabbedPainBody.setSelectedIndex(2);
        this.fieldSearch.setVisible(false);
        this.buttonSearch.setVisible(false);
        initMyPortfolios();
    }//GEN-LAST:event_buttonMyPortfolioMouseClicked

    private void buttonAddProjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddProjectsActionPerformed
        // TODO add your handling code here:
        
        new AddProjectWindow(loggedUser, this).setVisible(true);
    }//GEN-LAST:event_buttonAddProjectsActionPerformed

    private void buttonMyPortfolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMyPortfolioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonMyPortfolioActionPerformed

    private void itemEditProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditProfileActionPerformed
        // TODO add your handling code here:
        
        new ProfileWindow(this.profile, this).setVisible(true);
    }//GEN-LAST:event_itemEditProfileActionPerformed

    private void itemCvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCvActionPerformed
        // TODO add your handling code here:
        new CvWindow(this.profile).setVisible(true);
    }//GEN-LAST:event_itemCvActionPerformed

    private void itemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLogoutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new HomeWindow().setVisible(true);
    }//GEN-LAST:event_itemLogoutActionPerformed

    private void buttonProjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProjectsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonProjectsActionPerformed

    private void fieldSearchInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_fieldSearchInputMethodTextChanged
        // TODO add your handling code here:
        System.out.println("INPUT TEXT CHANGED");
        List<Profile> designersFiltered = new ArrayList<>();
        
        for (Profile designer : this.designers) {
            Skill skills = Dao.getSkillsByProfileId(designer.getIdProfile())
                    .stream()
                    .findFirst()
                    .orElse(null);
            if (skills != null && skills.getDescription().contains(this.fieldSearch.getText()))
                designersFiltered.add(designer);
        }
        
        this.containeDesigners.removeAll();
        
        for (Profile profileDesigner : designersFiltered) {
            PanelDesigner designer = new PanelDesigner(profileDesigner);
            this.containeDesigners.add(designer);
        }
        
        this.containeDesigners.revalidate();
        this.containeDesigners.repaint();
        
    }//GEN-LAST:event_fieldSearchInputMethodTextChanged

    private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed
        // TODO add your handling code here:
        
        this.fieldSearchInputMethodTextChanged(null);
        
    }//GEN-LAST:event_buttonSearchActionPerformed

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
            java.util.logging.Logger.getLogger(HomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddProjects;
    private javax.swing.JButton buttonDesigners;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JButton buttonMyPortfolio;
    private javax.swing.JButton buttonProjects;
    private javax.swing.JButton buttonSearch;
    private javax.swing.JPanel containeDesigners;
    private javax.swing.JPanel containerCards;
    private javax.swing.JPanel containerCardsPortfolio;
    private javax.swing.JPanel containerMyPortfolio;
    private javax.swing.JPanel containerSubMenu;
    private javax.swing.JTextField fieldSearch;
    private javax.swing.JMenuItem itemCv;
    private javax.swing.JMenuItem itemEditProfile;
    private javax.swing.JMenuItem itemLogout;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelCareers;
    private javax.swing.JPanel panelFram;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JPanel panelNavbar;
    private javax.swing.JPopupMenu popupProfile;
    private javax.swing.JScrollPane scrollCards;
    private javax.swing.JScrollPane scrollCareers;
    private javax.swing.JScrollPane scrollDesigners;
    private javax.swing.JScrollPane scrollMyPortfolio;
    private javax.swing.JTabbedPane tabbedPainBody;
    // End of variables declaration//GEN-END:variables
}
