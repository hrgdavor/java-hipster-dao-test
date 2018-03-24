package hr.hrg.hipster.dao.test;
import hr.hrg.hipster.sql.BaseColumnMeta;
import hr.hrg.hipster.sql.Key;

public class SampleUsage {

	public static void main(String[] args) {
	}
	
	private static void forDao(UserDao userDao, User1Update update) {
		BaseColumnMeta<Integer> age = User1Meta.age;
		
		setValue(age, 1);
		Integer value = getValue(age, 1);
		
		
		update.getAge();
	}

	
	public static <K> void setValue(Key<K> key, K value){
		
	}
	
	public static <K> K getValue(Key<K> key, K value){
		return null;
	}

	public enum KeyEnum{
		age,
		name;
	}
}
