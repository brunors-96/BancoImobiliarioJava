/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.JogadorDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.JogadorModel;

/**
 *
 * @author bruno
 */
@SessionScoped
@ManagedBean
public class JogadorBean
{

    private JogadorModel jogador = new JogadorModel();
    private List<JogadorModel> jogadores = new ArrayList<>();
    private String apelidoJogador;
    private String senhaJogador;

    public JogadorModel getJogador()
    {
        return jogador;
    }

    public void setJogador(JogadorModel jogador)
    {
        this.jogador = jogador;
    }

    public List<JogadorModel> getJogadores()
    {
        return jogadores;
    }

    public void setJogadores(List<JogadorModel> jogadores)
    {
        this.jogadores = jogadores;
    }

    public String getApelidoJogador()
    {
        return apelidoJogador;
    }

    public void setApelidoJogador(String apelidoJogador)
    {
        this.apelidoJogador = apelidoJogador;
    }

    public String getSenhaJogador()
    {
        return senhaJogador;
    }

    public void setSenhaJogador(String senhaJogador)
    {
        this.senhaJogador = senhaJogador;
    }

    public void cadastrar()
    {
        jogadores.add(jogador);
        boolean cadastrarJogador = new JogadorDao().cadastrarJogador(jogador);

        if (cadastrarJogador == true)
        {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_INFO, "SUCESSO!",
                            "Cadastro realizado com Sucesso!! xD"));
        } else
        {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, "FALHA!",
                            "Falha ao cadastrar no banco!! =,C"));
        }
        jogador = new JogadorModel();
    }

    public String login()
    {
        boolean login = new JogadorDao().login(getApelidoJogador(), getSenhaJogador());
        if (login == true)
        {
            return "prejogo";

        } else
        {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, "FALHA!",
                            "Usuário ou senha incorretos!! =,C"));
            return null;
        }
    }
    
    public String sair()
    {
        
        return "index";
    }
}
