/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import server.DAONegocio;
import server.DataBase;
import server.Negocio;

/**
 *
 * @author Aspire-E15
 */
public class DAONegociolmp extends DataBase implements DAONegocio{

    public void registrar(Negocio negocio) throws Exception {
       try{
           this.Conectar();
           PreparedStatement st = this.conexion.prepareStatement("INSERT INTO negocio(ID,Nombre,Precio,Stock)VALUES(?,?,?,?);");
           st.setInt(1, negocio.getId());
           st.setString(2, negocio.getNombre());
           st.setInt(3, negocio.getPrecio());
           st.setInt(4, negocio.getStock());
           st.executeUpdate();
           st.close();
       } catch(Exception e){
           throw e;
       }finally{
           this.Cerrar();
       }
    }

    public void modificar(Negocio negocio) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Negocio negocio) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Negocio> listar() throws Exception {
        List<Negocio> lista = null;
        try{
           this.Conectar();
           PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM negocio;");
           lista = new ArrayList();
           ResultSet rs = st.executeQuery();
           while(rs.next()){
               Negocio negocio = new Negocio();
               negocio.setId(rs.getInt("ID"));
               negocio.setNombre(rs.getString("Nombre"));
               negocio.setPrecio(rs.getInt("Precio"));
               negocio.setStock(rs.getInt("Stock"));
               lista.add(negocio);
           }
           rs.close();
           st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            this.Cerrar();
        }
        return lista;
    }
    
}
