/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.designers.designerportfolios;

import com.designer.views.HomeWindow;
import com.designers.dao.Dao;
import com.formdev.flatlaf.FlatLightLaf;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author carlo
 */
public class DesignerPortfolios {

    public static void main(String[] args) {
        
        // Testing connection
//        Dao dao = new Dao();
//        Connection conn = dao.getConnection();
//        
//        if(conn != null) {
//            System.out.println("Conexion a la db  exitosa");
//            try {
//                conn.close();
//                System.out.println("Conexion cerrada con exito");
//            } catch (SQLException ex) {
//                Logger.getLogger(DesignerPortfolios.class.getName()).log(Level.SEVERE, null, ex);
//                System.out.println("Error al cerrar la conexion");
//            }
//        }

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            
        } catch (UnsupportedLookAndFeelException ex) {
            System.out.println("Error al cargar el look an feel");
        }

        new HomeWindow().setVisible(true);
        
    }
}
