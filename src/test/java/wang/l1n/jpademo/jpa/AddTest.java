package wang.l1n.jpademo.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wang.l1n.jpademo.entity.Customer;
import wang.l1n.jpademo.repository.CustomerRepository;

import javax.persistence.Persistence;

/**
 * @author ：L1nker4
 * @date ： 创建于  2020/7/3 22:56
 * @description：
 */

@SpringBootTest
public class AddTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void test01(){
        Customer customer = new Customer();
        customer.setName("jack");
        customer.setAddress("江苏南京");
        customer.setLevel("9");
        customer.setDelete(Boolean.FALSE);
        customer.setAvailable(Boolean.TRUE);
        customerRepository.save(customer);
    }
}
