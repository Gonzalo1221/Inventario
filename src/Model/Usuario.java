/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.ListaUsuario;
import java.util.Vector;

/**
 *
 * @author GONZALO
 */
public class Usuario{

private String Usuario;
private String Pass;
private String Rol;

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getRol() {
        return Rol;
    }
    public static int verificarUsuarioNuevo(String usuario){
    
        Vector lista = mostrar();
        Usuario obj;
        for(int i=0;i<lista.size();i++){
            obj =(Usuario)lista.elementAt(i);
            if (obj.getUsuario().equalsIgnoreCase(usuario)){
            return i;
            }
        }
        return -1;
    }
    public static int verificarLogin(String usuario, String pass){
       
       Vector lista = mostrar();
       Usuario obj;
       for(int i=0;i<lista.size();i++){
        obj = (Usuario)lista.elementAt(i);
        if (obj.getUsuario().equalsIgnoreCase(usuario) && obj.getPass().equalsIgnoreCase(pass)){
           return i;
       }
    }
       return -1;
       
        
    }
    public void setRol(String Rol) {
        this.Rol = Rol;
    }
public static Vector mostrar(){
    return ListaUsuario.mostrar();
}
    
}
    
    
    
    
    
   