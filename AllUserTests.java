package texnologia.logismikou;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class AllUserTests {

	@Autowired
	private UserRepository repo;
	
	
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateAndEditUser() {
		User user = new User();
		user.setEmail("404@404");
		user.setPassword("404");
		user.setFirstName("404");
		user.setLastname("403+1");
		User savedUser = repo.save(user);
		user.setEmail("500@500");
		user.setPassword("500");
		user.setFirstName("500");
		user.setLastname("500");
	
		savedUser = repo.save(user);
		User exisUser = entityManager.find(User.class, savedUser.getId());
		assertThat(exisUser.getEmail()).isEqualTo(user.getEmail());
	}
	
	
	@Test
	public void testCreateAndDeleteUser() {
		User user = new User();
		user.setEmail("404@404");
		user.setPassword("404");
		user.setFirstName("404");
		user.setLastname("403+1");
	
		User savedUser = repo.save(user);
		User exisUser = entityManager.find(User.class, savedUser.getId());
		repo.delete(savedUser);
		assertThat(exisUser.getEmail()).isEqualTo(user.getEmail());
	}
	
	@Test
	
	public void testCreateAndSaveUser() {
		User user = new User();
		user.setEmail("NotRealMail@test.com");
		user.setPassword("password");
		user.setFirstName("NotRealUser");
		user.setLastname("!Real");
	
		User savedUser = repo.save(user);
		
		User exisUser = entityManager.find(User.class, savedUser.getId());
		assertThat(exisUser.getEmail()).isEqualTo(user.getEmail());
	}
}
