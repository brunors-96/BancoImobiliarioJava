/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author ribas
 */
public class PartidaModel
{

    private int idPartida;
    private String nomePartida;
    private Date dataPartida;
    private int statusPartida;
    
    public PartidaModel()
    {
        
    }

    public int getIdPartida()
    {
        return idPartida;
    }

    public void setIdPartida(int idPartida)
    {
        this.idPartida = idPartida;
    }

    public String getNomePartida()
    {
        return nomePartida;
    }

    public void setNomePartida(String nomePartida)
    {
        this.nomePartida = nomePartida;
    }

    public Date getDataPartida()
    {
        return dataPartida;
    }

    public void setDataPartida(Date dataPartida)
    {
        this.dataPartida = dataPartida;
    }

    public int getStatusPartida()
    {
        return statusPartida;
    }

    public void setStatusPartida(int statusPartida)
    {
        this.statusPartida = statusPartida;
    }
    
    
}
