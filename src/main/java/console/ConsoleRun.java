package console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConsoleRun {
	
	public static void main(String[] args) throws Exception {

		final Logger log = LoggerFactory
				.getLogger("ConsoleRun");

		log.info("Starting application");
		

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("*");
		ctx.refresh();

		TestUsers testUsers = ctx.getBean(TestUsers.class);
		testUsers.testDao();
		
	}

}
