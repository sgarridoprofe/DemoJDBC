/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demojdbc;

import BD.DataSource;

/**
 *
 * @author sergio
 */
public class DemoJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataSource.muestraUsuarios();
        
        if (DataSource.validaUsuario("' or '1'='1", "' or '1'='1")){
            System.out.println("El usuario existe");
        }else{
            System.out.println("El usuario no existe");
        }
        
        //DataSource.addUsuario("Luisa", "789");
        DataSource.delUsuario(3);
        
        DataSource.modifyUsuario(2, "demo", "demo456");
    }
    
}
