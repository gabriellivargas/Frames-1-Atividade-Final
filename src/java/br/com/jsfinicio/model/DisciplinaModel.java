/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsfinicio.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Gabrielli
 */
@Entity
@Table(name = "disciplina")
public class DisciplinaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDisciplina;

    private String nome;
    private String cargaHorariaTotal;
    private String descricao;
    

    @ManyToMany
    @JoinTable(name = "disciplinas_alunos",
    joinColumns = @JoinColumn(name = "idDisciplina"),
    inverseJoinColumns = @JoinColumn(name = "idPessoaAluno"))
    private List<AlunoModel> listaDeAlunos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPessoaProfessor", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private ProfessorModel professor;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idArea", insertable=true, updatable=true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private AreaModel areaDisc;

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargaHorariaTotal() {
        return cargaHorariaTotal;
    }

    public void setCargaHorariaTotal(String cargaHorariaTotal) {
        this.cargaHorariaTotal = cargaHorariaTotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    public ProfessorModel getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorModel professor) {
        this.professor = professor;
    }
    
     public AreaModel getAreaDisc() {
        return areaDisc;
    }

    public void setAreaDisc(AreaModel areaDisc) {
        this.areaDisc = areaDisc;
    }

    public AreaModel getArea() {
        return areaDisc;
    }

    public void setArea(AreaModel areaDisc) {
        this.areaDisc = areaDisc;
    }

    public List<AlunoModel> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public void setListaDeAlunos(List<AlunoModel> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }
}
