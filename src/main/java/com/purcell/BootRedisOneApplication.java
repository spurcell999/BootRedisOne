package com.purcell;


import com.purcell.bean.Person;
import com.purcell.dao.FriendDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.purcell")
public class BootRedisOneApplication implements CommandLineRunner {

	@Autowired
	FriendDAO dao;

	private static final Logger logger = LoggerFactory.getLogger(BootRedisOneApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BootRedisOneApplication.class, args);
		//System.exit(0);
	}



	@Override
	public void run(String... strings) throws Exception {
		logger.info("running");
		Person p1 = new Person(2, "Scott", 50);
		dao.addFriend(p1);

		Long numberOfFriends = dao.getNumberOfFriends();
		logger.info("number of friends {}", numberOfFriends);
	}


}
