/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.modelos;

/**
 *
 * @author Shall
 */
public class OrdemServicos {

    private int idOrdem;
    private int fkCodCliente;
    private int fkCodServico;
    private String descricaoServico;
    private String dataCadastro;
    private String horaServico;

    public int getIdOrdem() {
        return idOrdem;
    }

    public void setIdOrdem(int idOrdem) {
        this.idOrdem = idOrdem;
    }

    public int getFkCodCliente() {
        return fkCodCliente;
    }

    public void setFkCodCliente(int fkCodCliente) {
        this.fkCodCliente = fkCodCliente;
    }

    public int getFkCodServico() {
        return fkCodServico;
    }

    public void setFkCodServico(int fkCodServico) {
        this.fkCodServico = fkCodServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getHoraServico() {
        return horaServico;
    }

    public void setHoraServico(String horaServico) {
        this.horaServico = horaServico;
    }

}
