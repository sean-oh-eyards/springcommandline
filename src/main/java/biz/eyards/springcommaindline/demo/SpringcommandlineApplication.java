package biz.eyards.springcommaindline.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *
 * This class shows various ways to starting spring boot commandline applications
 *
 * <ul>
 *  <li>Spring will find all the CommandLineRunner interface typed beans and execute its run() method.</li>
 *  <li></li>
 * </ul>
 * @author  Sean Oh
 * @version 1.0
 * @since   2015-09-23
 */
@SpringBootApplication
public class SpringcommandlineApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringcommandlineApplication.class, args);
    }

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello from run() implemented by extending CommandLineRunner.");
    }

    @Bean
    CommandLineRunner getCommandLineRunner() {
        return (args) -> {
            System.out.println("Hello from run() implemented by lambda.");
        };
    }


}
