package br.com.suco.doce.mel.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ssdm");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		
		System.out.println("Open Transaction");
		
		//em.getTransaction().commit();
		
//		private static EntityManagerFactory emf = Persistence
//				.createEntityManagerFactory("livraria");
//
//		public EntityManager getEntityManager() {
//			return emf.createEntityManager();
//		}
		
	}

}
