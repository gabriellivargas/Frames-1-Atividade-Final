/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.PessoaModel;
import br.com.jsfinicio.repository.UsuarioRepository;
import br.com.jsfinicio.util.Usuario;
import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Gabrielli
 */
@ManagedBean
@ViewScoped
public class UsuarioController {

    private Usuario usuario;
    private UsuarioRepository usuarioRepository;

    public UsuarioController() {
        this.usuario = new Usuario();
        this.usuarioRepository = new UsuarioRepository();
    }

    public void login() throws IOException {
        List<PessoaModel> listaDePessoas = this.usuarioRepository.buscar(this.usuario.getLogin());
        if (listaDePessoas == null || listaDePessoas.isEmpty()) {
            //avisem que não encontraram ninguém com o login x
            FacesContext.getCurrentInstance().addMessage("mensagem_login_incorreto",new FacesMessage("Login inexistente!"));
            System.out.println("no login errado");
        } else {
            //pego a posição 0, pois só teremos um usuário com o login inserido
            //vocês deverão garantir que não teremos login´s iguais no banco de dados
            if (listaDePessoas.get(0).getSenha().equals(this.usuario.getSenha())) {
                //como o login e senha estão corretos posso então salvar o usuário como logado com sucesso
                FacesContext.getCurrentInstance().addMessage("mensagem_login_correto", new FacesMessage("Logado com sucesso!"));
                usuario.setNome(listaDePessoas.get(0).getNome());
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentUser", this.usuario);//usuario.getLogin());
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            }else{
                //Avisem que apesar do login estar correto a senha não está
                FacesContext.getCurrentInstance().addMessage("mensagem_senha_incorreta", new FacesMessage("Login correto,mas senha invalida!"));
            }
        }
    }
    
    public void logout() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("currentUser");
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

}
