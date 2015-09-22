package biz.eyards.springcommaindline.demo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by enshahar on 23/09/2015.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
