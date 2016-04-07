/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logica;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelos.Login;

/**
 *
 * @author miguel
 */
public class LoginHelper {

    private Session session;

    public LoginHelper() {
      try {         
         session = HibernateUtil.getSessionFactory().getCurrentSession(); 
      }catch (org.hibernate.HibernateException he) {  
        session = HibernateUtil.getSessionFactory().openSession();  
      }        
        
    }
   
    public Login getLoginPorNombre(String nombre) {
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.getNamedQuery("BuscaPorNombre").setString("usuario", nombre);
            return (Login) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
