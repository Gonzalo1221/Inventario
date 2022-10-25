/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ListaUsuario;
import Model.Usuario;
import View.Asistencia;
import View.CrearRol;
import View.Login;
import View.MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author SENA
 */
public class Controller implements ActionListener {

    Login log;
    MenuPrincipal menu = new MenuPrincipal();
    Asistencia asis = new Asistencia();
    CrearRol crear = new CrearRol();

    /*
    Variables
     */
    private String usuario;
    private String pass;
    private String apellido;
    private String correo;
    private int celular;
    private String rol;

    public Controller(Login log) {
        this.log = log;
        this.iniciar();
        this.log.BtnIngresar.addActionListener(this);

        this.menu.ItemIngresar.addActionListener(this);
        this.menu.ItemCrearRoles.addActionListener(this);
        this.menu.CerrarSesion.addActionListener(this);

        this.crear.btnregistrar.addActionListener(this);
        this.crear.btnsalir.addActionListener(this);

    }

    public void iniciar() {
        this.log.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        usuario = this.log.TxtUsuario.getText();
        pass = this.log.TxtPass.getText();

        if (e.getSource() == this.log.BtnIngresar) {

            int pos = Usuario.verificarLogin(usuario, pass);

            if (usuario.equals("admin") && pass.equals("123")) {

//          JOptionPane.showMessageDialog(this, "!USUARIO Y CONTRASEÑA CORRECTOS¡");
                this.menu.setVisible(true);
                this.log.dispose();

                this.log.TxtUsuario.setText("");
                this.log.TxtPass.setText("");
            } else if (pos == -1) {

                JOptionPane.showMessageDialog(null, "!USUARIO Y CONTRASEÑA INCORRECTOS¡");

            } else {
//              JOptionPane.showMessageDialog(this, "!USUARIO Y CONTRASEÑA CORRECTOS¡");

                this.menu.setVisible(true);
                this.log.dispose();

                this.log.TxtUsuario.setText("");
                this.log.TxtPass.setText("");

            }
        }

        if (e.getSource() == this.menu.CerrarSesion) {
            this.menu.dispose();
        }

        if (e.getSource() == this.menu.ItemIngresar) {
            this.asis.setVisible(true);
        }

        if (e.getSource() == this.menu.ItemCrearRoles) {
            this.crear.setVisible(true);
        }

        if (e.getSource() == this.menu.CerrarSesion) {
            this.menu.dispose();
            this.log.setVisible(true);
        }

        if (e.getSource() == this.crear.btnregistrar) {

            usuario = this.crear.TxtUsuario.getText();
            apellido = this.crear.TxtApellido.getText();
            pass = this.crear.TxtPass.getText();
            correo = this.crear.TxtCorreo.getText();
            celular = Integer.parseInt(this.crear.TxtCelular.getText());
            rol = this.crear.TxtRol.getText();

            Usuario obj = new Usuario();
            if (Usuario.verificarUsuarioNuevo(usuario) == -1) {
                obj.setUsuario(usuario);
                obj.setPass(pass);
                obj.setRol(rol);
                ListaUsuario.agregar(obj);
                JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
            } else {
                JOptionPane.showMessageDialog(null, "USERNAME YA EXISTE");
            }

            this.crear.TxtUsuario.setText("");
            this.crear.TxtPass.setText("");
            this.crear.TxtApellido.setText("");
            this.crear.TxtCorreo.setText("");
            this.crear.TxtCelular.setText("");
        }

        if (e.getSource() == this.crear.btnsalir) {
            this.crear.dispose();
        }
    }

}
