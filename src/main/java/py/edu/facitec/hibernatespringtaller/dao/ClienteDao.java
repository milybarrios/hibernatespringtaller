package py.edu.facitec.hibernatespringtaller.dao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import py.edu.facitec.hibernatespringtaller.model.Cliente;
@Repository
public class ClienteDAO extends DaoGenerico<Cliente> {

	@PersistenceContext
	private EntityManager manager;
	
	
	public ClienteDAO() {
		super(Cliente.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}
	
}