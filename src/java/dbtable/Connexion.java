/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbtable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author P14A_77_Michael
 */
public class Connexion {
        PreparedStatement s;
    public Connection getConnection() throws Exception    {
         Class.forName("org.postgresql.Driver");
         Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/evaluationjuillet","postgres","michael");
         return con;
    }
}
