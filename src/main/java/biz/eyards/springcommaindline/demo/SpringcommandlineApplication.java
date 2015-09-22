package biz.eyards.springcommaindline.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
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
public class SpringcommandlineApplication implements CommandLineRunner, Runnable {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ac = SpringApplication.run(SpringcommandlineApplication.class, args);
        try(AutoCloseable auto = () -> { System.out.println("Good Night!"); }; ) {
            Runnable runnable = ac.getBean(Runnable.class);

            runnable.run();

            CustomerRepository customerRepository = ac.getBean(CustomerRepository.class);

            customerRepository.save(new Customer("Sean"));
            customerRepository.save(new Customer("Joyce"));

            customerRepository.findAll().forEach(System.out::println);
        }
    }

    @Autowired
    CustomerRepository customerRepository;

    /** this is from CommandLineRunner */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello from run() implemented by extending CommandLineRunner.");
    }

    /** This bean's type is CommandLineRunner, so spring boot application will call this method */
    @Bean
    CommandLineRunner getCommandLineRunner() {
        return (args) -> {
            System.out.println("Hello from run() implemented by lambda.");
        };
    }

    /** this is basic bean lifecycle callback. I used old-style unnamed class instantiation */
    @Bean
    public InitializingBean beanInit() {
        return new InitializingBean() {
            @Override
            public void afterPropertiesSet() throws Exception {
                System.out.println("Bean is initialized.");
            }
        };
    }

    @Override
    public void run() {
        System.out.println("run from runnable.");
    }
}
