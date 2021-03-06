/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.JogadorDao;
import dao.PartidaDao;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.JogadorModel;
import model.PartidaModel;
import model.PinoModel;

/**
 *
 * @author bruno
 */
@SessionScoped
@ManagedBean
public class PartidaBean extends JogadorBean
{

    private String pino;
    private List<String> pinos;
    private String nomePartida;
    private PartidaModel partida = new PartidaModel();
    private PinoModel pinoModel = new PinoModel();  
    
    @PostConstruct
    public void init() {
        pinos = new ArrayList<String>();
        pinos.add("Porquinho");
        pinos.add("Maleta de dinheiro");
        pinos.add("Monte de Moedas");
        pinos.add("Moeda");
        pinos.add("Prédio do Banco");
        pinos.add("Saco de Dinheiro");
    }

    public String getPino() {
        return pino;
    }

    public void setPino(String pino) {
        this.pino = pino;
    }

    public List<String> getPinos() {
        return pinos;
    }

    public void setPinos(List<String> pinos) {
        this.pinos = pinos;
    }

    public String getNomePartida()
    {
        return nomePartida;
    }

    public void setNomePartida(String nomePartida)
    {
        this.nomePartida = nomePartida;
    }

    public PartidaModel getPartida()
    {
        return partida;
    }

    public void setPartida(PartidaModel partida)
    {
        this.partida = partida;
    }

    public PinoModel getPinoModel()
    {
        return pinoModel;
    }

    public void setPinoModel(PinoModel pinoModel)
    {
        this.pinoModel = pinoModel;
    }
        
    public void criarPartida(String pApelido, String pNomeJogo, String pPino)
    {
        String partida = pNomeJogo;
        String apelidoJogador = pApelido;
        String Pino = pPino;
        
        boolean criaNomePartida = new PartidaDao().cadastrarNomePartida(partida);
        boolean criaPartida = new PartidaDao().cadastrarPartida(apelidoJogador, partida, Pino);
        if (criaPartida == true && criaNomePartida == true)
        {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_INFO, "SUCESSO!",
                            "Partida Criada"));

        } else
        {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, "FALHA!",
                            "Falha ao criar a partida"));
        }
        
    }
    public String sair()
    {
        return "index";
    }

}
