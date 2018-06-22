/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ribas
 */

public class JogadorModel
{

    private int idJogador;
    private String nomeJogador;
    private String senhaJogador;
    private String apelidoJogador;

    // Construtor padrão, não populado
    public JogadorModel()
    {
    }

    // Getters e Setters padrões, não foi criado o setIdJogador pois ele será gerado no banco
    public int getIdJogador()
    {
        return idJogador;
    }

    public String getNomeJogador()
    {
        return nomeJogador;
    }

    public String getSenhaJogador()
    {
        return senhaJogador;
    }

    public String getApelidoJogador()
    {
        return apelidoJogador;
    }

    public void setNomeJogador(String nomeJogador)
    {
        this.nomeJogador = nomeJogador;
    }

    public void setSenhaJogador(String senhaJogador)
    {
        this.senhaJogador = senhaJogador;
    }

    public void setApelidoJogador(String apelidoJogador)
    {
        this.apelidoJogador = apelidoJogador;
    }

    // Fim getters e setters
}