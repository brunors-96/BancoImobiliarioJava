/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ribas
 */
public class MySQLConnection
{

    private static Connection conexao;
    private static final String url = "jdbc:mysql://mysql.cs-ribas1"
            + ".centralserver.com.br:3306/csrib3br2";
    private static final String usuario = "csrib3br2";
    private static final String senha = "7ZFBjizC";

    public static Connection getConexao()
    {
        if (conexao == null)
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                conexao = (Connection) DriverManager.getConnection(url, usuario, senha);
            } catch (SQLException ex)
            {
                Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex)
            {
                Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return conexao;
    }

    public static void fecharConexao()
    {
        if (conexao != null)
        {
            try
            {
                conexao.close();
                conexao = null;
            } catch (SQLException ex)
            {
                Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
