/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsfinicio.repository;

import br.com.jsfinicio.model.CidadeModel;
import br.com.jsfinicio.util.Conexao;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Gabrielli 
 */
public class CidadeRepository extends Conexao {
    public List<CidadeModel> buscarTodos(){
        List<CidadeModel> listaDeCidades = new ArrayList<>();
        super.inicializa();
        listaDeCidades = super.getSess().createQuery("from CidadeModel").list();
        super.executar();
        return listaDeCidades;
    }
    
    public CidadeModel buscarPorID (int cidadeId){
        CidadeModel cidade = new CidadeModel();
        super.inicializa();
        cidade = (CidadeModel) super.getSess().get(CidadeModel.class, cidadeId);
        super.executar();
        return cidade;
    }
}