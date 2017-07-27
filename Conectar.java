/*
 * conectar.java
 *
 * Created on 11 de febrero de 2010, 03:30 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.diagnosticnet.bdd;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.*;


import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.*;


import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.*;


/**
 *
 * @author USER
 */
public class Conectar {

    //variables de coneccion
    static Connection c;
    static Statement s;
    static ResultSet r;
    //ruta, datos del driver
    static String controladorBD = "org.postgresql.Driver";
    //String jdbcUsr = "postgres";
    //String jdbcPwd = "diagnosticnetbdd";
    String jdbcUsr = "postgres";
    String jdbcPwd = "sa";
    String cadena = "jdbc:postgresql://localhost:5432/";

    /**
     * Creates a new instance of conectar
     */
    public Conectar(String instancia) {
        cadena+=instancia;
        coneccion();
    }

    /**
     *
     */
    public void coneccion() {
        try {
            Class.forName(controladorBD);
            System.out.println("Se cargó el driver con exito");
            c = DriverManager.getConnection(cadena, jdbcUsr, jdbcPwd);
            s = c.createStatement();
            System.out.println("se conecto");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede cargar el driver JDBC",
                    "Conexion de Base de Datos", JOptionPane.WARNING_MESSAGE);
        } catch (Exception i) {
            JOptionPane.showMessageDialog(null, "Error en conexion",
                    "Conexion de Base de Datos", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     *
     */
    public void desconectar() {
        try {
            c.close();

            System.out.println("se desconecto");
        } catch (SQLException e) {
        } catch (Exception i) {
        }
    }

    public Connection getConexion() {
        return this.c;
    }

}
