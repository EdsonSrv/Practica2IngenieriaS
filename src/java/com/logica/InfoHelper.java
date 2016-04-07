/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logica;


import modelos.Usuario;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author mauricio
 */
public class InfoHelper {
      private Session session;
      
       public InfoHelper() {
      try {         
         session = HibernateUtil.getSessionFactory().getCurrentSession();  
      }catch (org.hibernate.HibernateException he) {  
        session = HibernateUtil.getSessionFactory().openSession();     
      }        
        
    }

     public Usuario getInfoPorNombre(String nombre) {
        Usuario usuario;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.getNamedQuery("BuscaInfo").setString("usuario", nombre);
            return (Usuario) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
