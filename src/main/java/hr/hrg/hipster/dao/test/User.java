package hr.hrg.hipster.dao.test;

import java.util.*;

import javax.persistence.*;

import hr.hrg.hipster.dao.*;

@HipsterEntity(table="user_table")
public interface User{
	
	@Id
	@Column(name="user_id")
	public Long getId();
	public List<String> getName();
	public int getAge();

}
