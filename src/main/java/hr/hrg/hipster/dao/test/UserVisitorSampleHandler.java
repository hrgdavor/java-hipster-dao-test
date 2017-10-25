package hr.hrg.hipster.dao.test;

import java.sql.*;
import java.util.*;

import hr.hrg.hipster.sql.*;

public class UserVisitorSampleHandler implements IResultVisitor<UserVisitorSample>{

	private IResultGetter<List<String>> _name_resultGetter;

	@SuppressWarnings("unchecked")
	public UserVisitorSampleHandler(ResultGetterSource getterSource) {
	    _name_resultGetter = (IResultGetter<List<String>>) getterSource.getFor(List.class,String.class);
	}
	
	public void visitResult(ResultSet rs, UserVisitorSample visitor) throws SQLException{
		System.err.println("Static visitor handler");
		visitor.visitUser(
				rs.getLong(1),
				(List<String>)_name_resultGetter.get(rs,2),
				rs.getInt(3)
				);	
	}

	@Override
	public String getColumnNamesStr() {
		return null;
	}
}
