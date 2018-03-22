package hr.hrg.hipster.dao.test;

import hr.hrg.hipster.dao.EntityDao;
import hr.hrg.hipster.dao.EntitySource;
import hr.hrg.hipster.sql.IHipsterConnection;

public class UserDao extends EntityDao<User, Long>{

	public UserDao(IHipsterConnection conn, EntitySource entitySource) {
		super(User.class, conn, entitySource);
	}

	
}
