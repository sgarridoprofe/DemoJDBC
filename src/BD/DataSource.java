/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author sergio
 */
public class DataSource {
    private static final String url="jdbc:mysql://localhost:3306/centroeducativo";
    private static final String user="usercentroeducativo";
    private static final String pass="1234";
    private static Connection cn;

    
    
public static void muestraUsuarios(){

    try{
        //Cargamos Driver        
        //Class.forName("com.mysql.cj.jdbc.Driver");
        cn=DriverManager.getConnection(url,user,pass);
        
        Statement stmt=cn.createStatement();
        
        String sql="SELECT * FROM usuario";
        ResultSet rs=stmt.executeQuery(sql);
        
        String sregistro="ID\tUSER\tPASS\n";
                
        while (rs.next()){
            sregistro+=rs.getInt("id");
            sregistro+="\t"+rs.getString("usuario");
            sregistro+="\t"+rs.getString("password");
            sregistro+="\n";
        }
        System.out.println(sregistro+"\n");                    
            
        rs.close();
        stmt.close();
        cn.close();
        System.out.println("Conexión correcta");
        
        
    }catch(Exception e){
        System.out.println("Error:"+e.getMessage());
    }

}

public static boolean validaUsuario(String usuario, String password){

    try{
        //Cargamos Driver        
        //Class.forName("com.mysql.cj.jdbc.Driver");
        cn=DriverManager.getConnection(url,user,pass);
        
        Statement stmt=cn.createStatement();
        usuario=usuario.replaceAll("'", "");
        password=password.replaceAll("'", "");
        String sql="SELECT * FROM usuario where "
                + " usuario='" + usuario + "'"+
                        " and password ='" + password +"'";
        
        ResultSet rs=stmt.executeQuery(sql);
        //stmt.executeUpdate(sql)
               
        if (rs.next()){
            return true;
        }
        
        rs.close();
        stmt.close();
        cn.close();
        
        return false;
        
    }catch(Exception e){
        System.out.println("Error:"+e.getMessage());
    }
    
    
    return true;
}

public static void  addUsuario(String usuario, String passwd){

     try{
        //Cargamos Driver        
        //Class.forName("com.mysql.cj.jdbc.Driver");
        cn=DriverManager.getConnection(url,user,pass);
        
        Statement stmt=cn.createStatement();
               
        String sql="insert into usuario (usuario,password) values ("
                + "'" + usuario +"','" + passwd + "')";
        
        stmt.executeUpdate(sql);
        
        stmt.close();
        cn.close();
               
        
    }catch(Exception e){
        System.out.println("Error:"+e.getMessage());
    }
    
   
    
}

public static void delUsuario(int iduser){
    
    try{
        //Cargamos Driver        
        //Class.forName("com.mysql.cj.jdbc.Driver");
        cn=DriverManager.getConnection(url,user,pass);
        
        Statement stmt=cn.createStatement();
               
        String sql="delete from usuario where "
                + "id=" + iduser ;
        
        stmt.executeUpdate(sql);
        
        stmt.close();
        cn.close();
               
        
    }catch(Exception e){
        System.out.println("Error:"+e.getMessage());
    }

}

public static void modifyUsuario(int iduser, String usuario, String passwd){
    try {
        //Cargamos Driver        
        //Class.forName("com.mysql.cj.jdbc.Driver");
        cn=DriverManager.getConnection(url,user,pass);
        
        Statement stmt=cn.createStatement();
        
        
        
        String sql="update usuario "
                + " set usuario='" + usuario + "'"
                + " , password='" + pass + "'"
                + " where "
                + "id=" + iduser ;
        
        stmt.executeUpdate(sql);
        
        stmt.close();
        cn.close();
               
        
    }catch(Exception e){
        System.out.println("Error:"+e.getMessage());
    }
}

}