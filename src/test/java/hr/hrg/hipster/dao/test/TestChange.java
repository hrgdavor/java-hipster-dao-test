package hr.hrg.hipster.dao.test;

import org.testng.annotations.*;

import hr.hrg.hipster.dao.change.*;
import hr.hrg.hipster.sql.*;

import static org.testng.Assert.*;

import java.util.concurrent.atomic.*;

@Test
public class TestChange {

	public static void main(String[] args) {
		new TestChange().testChangeListenerCall();
	}

	@Test
	public void testChangeListenerCall(){
		
		EntityEventHub hub = new EntityEventHub();

		final AtomicInteger callCount = new AtomicInteger();
		
		hub.addChangeListener(new IChangeListener<User, Long, UserEnum>() {

			@Override
			public void recordChanged(EntityEvent<User, Long, UserEnum> update, long batchId) {
				callCount.incrementAndGet();
			}
		}, User.class);
		
		User old = new UserImmutable(1L, ImmutableList.safe("name"), 22);
		
		UserUpdate update = new UserUpdate(old);
		update.age(33);
		UserMeta meta = new UserMeta(new ResultGetterSource());
		
		UserImmutable newUser = new UserImmutable(update); 

		hub.fireChange(new EntityEvent<User, Long, UserEnum>(1L, old, newUser, update, meta), 1l);
		
		assertEquals(callCount.get(), 1);
		
	}

}

