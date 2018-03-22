package hr.hrg.hipster.dao.test;

import hr.hrg.hipster.BaseEntityMeta;
import hr.hrg.hipster.sql.BaseColumnMeta;
import hr.hrg.hipster.sql.IResultGetter;
import hr.hrg.hipster.sql.ImmutableList;
import hr.hrg.hipster.sql.ResultGetterSource;
import java.lang.Class;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class User1Meta extends BaseEntityMeta<User1, Long, BaseColumnMeta<?>> {

	private static final Class<User1> ENTITY_CLASS = User1.class;
	private static final String TABLE_NAME = "user_table";

	public static final BaseColumnMeta<Long> id = new BaseColumnMeta<Long>(0,"user_id","id","getId",ENTITY_CLASS,Long.class,null,TABLE_NAME,"");
	public static final BaseColumnMeta<List> name = new BaseColumnMeta<>(1,"name","name","getName",ENTITY_CLASS,List.class,null,TABLE_NAME,"",String.class);
	public static final BaseColumnMeta<Integer> age  = new BaseColumnMeta<Integer>(2,"age","age","getAge",ENTITY_CLASS,Integer.class,int.class,TABLE_NAME,"");
		
	private static final String COLUMNS_STR = "\"user_id\",\"name\",\"age\"";
	
	private static final ImmutableList<String> COLUMN_NAMES = ImmutableList.safe("user_id","name","age");
	
	private static final BaseColumnMeta<?>[] COLUMN_ARRAY = {id,name,age};
	
	private static final ImmutableList<BaseColumnMeta<?>> COLUMNS = ImmutableList.safe(COLUMN_ARRAY);
	
	private static final BaseColumnMeta<?>[] COLUMN_ARRAY_SORTED = {age,id,name};
	
	private static final String[] COLUMN_ARRAY_SORTED_STR = {"age","id","name"};
  
/*
	public static enum User1Enum {
		id(User1Meta.id),
		name(User1Meta.name),
		age(User1Meta.age);

		private final BaseColumnMeta<?> column;
		private User1Enum(BaseColumnMeta<?> column){
			this.column = column;
		}
	}
*/
	
	public final IResultGetter<List<String>> _name_resultGetter;

	public User1Meta(ResultGetterSource getterSource, int ordinal) {
		super(ordinal);
		_name_resultGetter = getterSource == null ? null : (IResultGetter<List<String>>) getterSource.getFor(List.class, String.class);
	}

  public final User1 fromResultSet(ResultSet rs) throws SQLException {
    Long id = rs.getLong(1);
    List<String> name = (List<String>)_name_resultGetter.get(rs,2);
    int age = rs.getInt(3);

    return new User1Immutable(
    id, name, age);}

  @Override
  public final User1Update mutableCopy(Object v) {
    return new User1Update((User1)v);
  }

  @Override
  public final Class<User1> getEntityClass() {
    return ENTITY_CLASS;
  }

  @Override
  public final String getEntityName() {
    return "User1";
  }

  @Override
  public final String getTableName() {
    return TABLE_NAME;
  }

  @Override
  public final int getColumnCount() {
    return 3;
  }

  @Override
  public final String getColumnNamesStr() {
    return COLUMNS_STR;
  }

  public final ImmutableList<String> getColumnNames() {
    return COLUMN_NAMES;
  }

  public final boolean containsColumn(String columnName) {
    return Arrays.binarySearch(COLUMN_ARRAY_SORTED_STR, columnName) != -1;
  }

  @Override
  public final List<BaseColumnMeta<?>> getColumns() {
    return COLUMNS;
  }

  @Override
  public final BaseColumnMeta<?> getPrimaryColumn() {
    return id;
  }

  @Override
  public final BaseColumnMeta<?> getColumn(String columnName) {
    int pos = Arrays.binarySearch(COLUMN_ARRAY_SORTED_STR, columnName);
    return pos == -1 ? null: COLUMN_ARRAY_SORTED[pos];
  }

  @Override
  public final BaseColumnMeta<?> getColumn(int ordinal) {
    return COLUMN_ARRAY[ordinal];
  }

  @Override
  public final Long entityGetPrimary(User1 instance) {
    return instance.getId();}
}