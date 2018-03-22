package hr.hrg.hipster.dao.test;
import hr.hrg.hipster.sql.BaseColumnMeta;

public class SampleUsage {

	public static void main(String[] args) {
	}
	
	private static void forDao(UserDao userDao, User1Update update) {
		BaseColumnMeta<Integer> age = User1Meta.age;
		
		update.getAge();
	}

	
	public enum KeyEnum{
		age,
		name;
	}
}
