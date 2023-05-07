/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package server;

import java.util.List;

/**
 *
 * @author Aspire-E15
 */
public interface DAONegocio 
{
    public void registrar(Negocio negocio) throws Exception;
    public void modificar(Negocio negocio) throws Exception;
    public void eliminar(Negocio negocio) throws Exception;
    public List<Negocio> listar() throws Exception;
}
