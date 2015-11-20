/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Controlador.UsuarioController;
import entidades.Usuario;
import Controlador.util.JsfUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author juandiego
 */
@ManagedBean
@RequestScoped
public class UsuarioBean {

    private Usuario usuarioIngreso;

    private Usuario usuarioAgregar;

    private Usuario usuarioModificar;

    private static List<Usuario> usuarios;

    private UsuarioController controlador;

    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
        usuarioIngreso = new Usuario(0, "", "");
        usuarioAgregar = new Usuario(0, "", "");
        usuarioModificar = new Usuario(0, "", "");
        usuarios = new ArrayList<>();
        controlador = new UsuarioController();
    }

    public Usuario getUsuarioIngreso() {
        return usuarioIngreso;
    }

    public void setUsuarioIngreso(Usuario usuarioIngreso) {
        this.usuarioIngreso = usuarioIngreso;
    }

    public Usuario getUsuarioAgregar() {
        return usuarioAgregar;
    }

    public void setUsuarioAgregar(Usuario usuarioAgregar) {
        this.usuarioAgregar = usuarioAgregar;
    }

    public Usuario getUsuarioModificar() {
        return usuarioModificar;
    }

    public void setUsuarioModificar(Usuario usuarioModificar) {
        this.usuarioModificar = usuarioModificar;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void verificarIngreso() {
        System.out.println("aquiii ->1");//+controlador);
        controlador = new UsuarioController();
        ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>) controlador.getFacade().findAll();
      System.out.println("aquiii ->2");
        /* for (Usuario u : listaUsuarios) {
            if (u.getLogin().equals(usuarioIngreso.getLogin())) {
                if (u.getPassword().equals(usuarioIngreso.getPassword())) {
                    try {
                        FacesContext contex = FacesContext.getCurrentInstance();
                        contex.getExternalContext().redirect("index.xhtml");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }*/
    }
}
