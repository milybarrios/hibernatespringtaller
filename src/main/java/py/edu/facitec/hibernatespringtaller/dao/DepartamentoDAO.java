package py.edu.facitec.hibernatespringtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.hibernatespringtaller.model.Departamento;

@Repository
public class DepartamentoDAO  extends DaoGenerico<Departamento>{

	
	
			public DepartamentoDAO() {
		super(Departamento.class);
		// TODO Auto-generated constructor stub
	}

			@PersistenceContext
			private EntityManager em;

			@Override
			protected EntityManager getEntityManager() {
				// TODO Auto-generated method stub
				return em;
			}
			
			
}
