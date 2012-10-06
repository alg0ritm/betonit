package console;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.user.User;
import domain.user.UserDao;

@Service
public class TestUsers {

	static final Logger log = LoggerFactory.getLogger("TestDatabase");

	@Autowired
	private UserDao userDao;

	public void testDao() {
		log.info("Getting all users");
		List<User> users = userDao.findAll();
		for (User u : users) {
			log.info("User: {}", u);
		}
	}
}
