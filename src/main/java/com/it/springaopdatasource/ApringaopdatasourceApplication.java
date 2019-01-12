package com.it.springaopdatasource;

import com.it.springaopdatasource.controller.ApiController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author limeng
 *  @date 2019/1/12 10:24
 */
@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class
})
public class ApringaopdatasourceApplication implements CommandLineRunner {
	@Autowired
	ApiController apiController;
	public static void main(String[] args) {
		SpringApplication.run(ApringaopdatasourceApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		apiController.getDs1();
		apiController.getDs2();
	}
}

