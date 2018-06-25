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
public class PartidaDao
{

    // Metodo para inserir um jogador no banco
    public boolean cadastrarPartida(String pApelido, String pNomeJogo, String pPino)
    {
        String partida = pNomeJogo;
        String apelidoJogador = pApelido;
        String Pino = pPino;
        try
        {
            Connection connection = MySQLConnection.getConexao();
            String sql = "SELECT criarPartida(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pApelido);
            statement.setString(2, pNomeJogo);
            statement.setString(3, pPino);
            ResultSet rs = statement.executeQuery();
            MySQLConnection.fecharConexao();
            if (rs == null)
            {
                return false;
            }
            return true;
        } catch (SQLException ex)
        {
            Logger.getLogger(PartidaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean cadastrarNomePartida(String pNomeJogo)
    {
        try
        {
            Connection connection = MySQLConnection.getConexao();
            String sql = "insert into tb_Partida (parnome) values(?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pNomeJogo);
            statement.executeUpdate();
            MySQLConnection.fecharConexao();
            return true;
        } catch (SQLException ex)
        {
            Logger.getLogger(PartidaDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PartidaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
