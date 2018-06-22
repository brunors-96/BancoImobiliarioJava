/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.MySQLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.JogadorModel;

/**
 *
 * @author ribas
 */
public class JogadorDao
{

    // Metodo para inserir um jogador no banco
    public boolean cadastrarJogador(JogadorModel jogador)
    {
        try
        {
            Connection connection = MySQLConnection.getConexao();
            String sql = "INSERT INTO tb_Jogador ( jognome,"
                    + "jogsenha, jognick)"
                    + "VALUES (?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, jogador.getNomeJogador());
            statement.setString(2, jogador.getSenhaJogador());
            statement.setString(3, jogador.getApelidoJogador());
            statement.executeUpdate();
            MySQLConnection.fecharConexao();
            return true;
        } catch (SQLException ex)
        {
            Logger.getLogger(JogadorDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean login(String pApelidoJogador, String pSenhaJogador)
    {
        try
        {
            Connection connection = MySQLConnection.getConexao();
            String sql = "select jognick, jogsenha from tb_Jogador "
                    + "where jognick=? and jogsenha=?";
            ResultSet rs;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pApelidoJogador);
            statement.setString(2, pSenhaJogador);
            rs = statement.executeQuery();
            if (rs == null)
            {
                MySQLConnection.fecharConexao();
                
                return false;
            } else
            {
                MySQLConnection.fecharConexao();
                return true;
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(JogadorDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
