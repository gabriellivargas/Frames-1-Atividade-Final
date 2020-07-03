/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.DisciplinaModel;
import br.com.jsfinicio.model.AreaModel;
import br.com.jsfinicio.model.AlunoModel;
import br.com.jsfinicio.model.ProfessorModel;
import br.com.jsfinicio.repository.DisciplinaRepository;
import br.com.jsfinicio.repository.AreaRepository;
import br.com.jsfinicio.repository.AlunoRepository;
import br.com.jsfinicio.repository.ProfessorRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Gabrielli
 */
@ManagedBean
@SessionScoped
public class DisciplinaController {
   private DisciplinaModel disciplinaModel;
   private AreaModel areaModel;
   private AlunoModel alunoModel;
   private ProfessorModel professorModel;
   private DisciplinaRepository disciplinaRepository;
   private ProfessorRepository professorRepository;
   private AreaRepository areaRepository;
   private AlunoRepository alunoRepository;
   private List<AlunoModel> listaDeAlunos;
  
   private List<DisciplinaModel> listaDeDisciplinas;
  
   public DisciplinaController(){
       this.areaRepository = new AreaRepository();
       this.professorRepository = new ProfessorRepository();
       this.disciplinaModel = new DisciplinaModel();
       this.professorModel = new ProfessorModel();
       this.areaModel = new AreaModel();
       this.disciplinaRepository = new DisciplinaRepository();
       this.listaDeDisciplinas = new ArrayList<>();
   }
   public void salvar(){
        try{
             this.areaModel = this.areaRepository.buscarPorID(this.areaModel.getIdArea());
             this.disciplinaModel.setArea(this.areaModel);
             this.disciplinaRepository.salvar(this.disciplinaModel);
             this.professorModel = this.professorRepository.buscarPorID(this.professorModel.getIdpessoa());
             this.disciplinaModel.setProfessor(this.professorModel);
             this.disciplinaRepository.salvar(this.disciplinaModel);
             this.disciplinaModel = new DisciplinaModel();
            } catch(Exception e) {
        }
   } 

   public void buscarTodos(){
       this.listaDeDisciplinas = this.disciplinaRepository.buscarTodos();
   }

   public void buscarPorNome(){
       this.listaDeDisciplinas = this.disciplinaRepository.buscarPorNome(this.disciplinaModel.getNome());
   }
   
   public void excluirPorID (int idDisciplina){
       this.disciplinaRepository.excluirPorID(idDisciplina);
   }

   public String editarPorID(int idDisciplina) throws IOException{
       this.disciplinaModel = this.disciplinaRepository.buscarPorID(idDisciplina);
       
       return "editarDisciplina.xhtml?faces-redirect=true";
   }
   
      
    public void salvarAlunoDisciplina(){
        try{
            this.alunoModel = this.alunoRepository.buscarPorID(this.alunoModel.getIdpessoa());
            this.listaDeAlunos.add(alunoModel);
            this.disciplinaModel.setListaDeAlunos(listaDeAlunos);
            this.disciplinaRepository.salvar(this.disciplinaModel);
            this.disciplinaModel = new DisciplinaModel();
        }catch (Exception e){   
        }  
    }
    
    public DisciplinaModel getDisciplinaModel() {
        return disciplinaModel;
    }

    public void setDisciplinaModel(DisciplinaModel disciplinaModel) {
        this.disciplinaModel = disciplinaModel;
    }

    public DisciplinaRepository getDisciplinaRepository() {
        return disciplinaRepository;
    }

    public void setDisciplinaRepository(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<DisciplinaModel> getListaDeDisciplinas() {
        return listaDeDisciplinas;
    }

    public void setListaDeDisciplinas(List<DisciplinaModel> listaDeDisciplinas) {
        this.listaDeDisciplinas = listaDeDisciplinas;
    }    

    public AreaModel getAreaModel() {
        return areaModel;
    }

    public void setAreaModel(AreaModel areaModel) {
        this.areaModel = areaModel;
    }
    
    public AreaRepository getAreaRepository() {
        return areaRepository;
    }

    public void setAreaRepository(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public AlunoModel getAlunoModel() {
        return alunoModel;
    }

    public void setAlunoModel(AlunoModel alunoModel) {
        this.alunoModel = alunoModel;
    }

    public AlunoRepository getAlunoRepository() {
        return alunoRepository;
    }

    public void setAlunoRepository(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<AlunoModel> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public void setListaDeAlunos(List<AlunoModel> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }

    public ProfessorModel getProfessorModel() {
        return professorModel;
    }

    public void setProfessorModel(ProfessorModel professorModel) {
        this.professorModel = professorModel;
    }

    public ProfessorRepository getProfessorRepository() {
        return professorRepository;
    }

    public void setProfessorRepository(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }
}
    
    