/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejecutar;

import Controller.Controller;
import View.Login;

/**
 *
 * @author GONZALO
 */
public class ApLogin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Login abrir = new Login();
        Controller control = new Controller(abrir);
    }

}
