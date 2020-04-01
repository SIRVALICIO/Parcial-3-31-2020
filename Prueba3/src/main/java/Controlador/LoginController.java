/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import dao.UsuarioDAO;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author VAL
 */
@Named(value = "LoginController")
@SessionScoped
public class LoginController implements Serializable {

   private  Usuario usuario;
   private Object usuarioAutenticado= null;

    List<Usuario> lista_mostrar;

    
   

   @EJB
   private UsuarioDAO ejbDao;
   
    public LoginController() {
        usuario=new Usuario();
    }
    
    public void login() throws IOException{
        
        FacesContext ctx= FacesContext.getCurrentInstance();
       usuarioAutenticado= ejbDao.econtrarUsuarioPorLogin(usuario.getCorreo(), usuario.getClave());
        
        
        
        if(usuarioAutenticado!=null){
            
              ctx.getExternalContext().redirect("home.xhtml");
        
        }else{
       
             ctx.getExternalContext().redirect("index.xhtml");
        }
        usuario=new Usuario();
      
    }
    
    public List<Usuario> getlistDo(){
        
        lista_mostrar=ejbDao.Listado();
        return lista_mostrar;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
   
    
    
}
