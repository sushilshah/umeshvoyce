/**
 * 
 */
package com.voyce.registration.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.voyce.infrastructure.VoyceEMF;
import com.voyce.registration.Entity.VoyceUsers;

/**
 * @author DeadCode
 *
 */
public class UserMangementDao {

  public boolean RegisterNewUser(VoyceUsers user ){
	  
	  EntityManager em = VoyceEMF.get().createEntityManager();
	  try
	  {
	    em.persist(user);
	  }
	  catch(Exception ex)
	  {
		  return false;
	  }
	  finally{
		  
		  if(em.isOpen())
			  em.close();
	  }
	  return true;
  }
	
  
  public boolean isUserExists(String userName){
		
		EntityManager em = VoyceEMF.get().createEntityManager();
		try
		{
		
		TypedQuery<VoyceUsers> query = em.createQuery(
		        "SELECT c FROM VoyceUsers c WHERE c.username = :name", VoyceUsers.class);
		VoyceUsers user = query.setParameter("name", userName).getSingleResult();
		
		if(null !=user)
			return true;
		else
		return false;
		
		}
		catch(Exception ex)
		{
			return false;
		}
		finally{
			
			if(em.isOpen())
				em.close();
		}
    }
  
  
  public VoyceUsers GetUserData(String userName){
	  
	  VoyceUsers user=null;
	  
	  EntityManager em = VoyceEMF.get().createEntityManager();
		try
		{
		
		TypedQuery<VoyceUsers> query = em.createQuery(
		        "SELECT c FROM VoyceUsers c WHERE c.username = :name", VoyceUsers.class);
	    user = query.setParameter("name", userName).getSingleResult();
	    
		return 	user;
		
		}
		catch(Exception ex)
		{
			return null;
		}
		finally{
			
			if(em.isOpen())
				em.close();
		}
	  
  }
  
}
