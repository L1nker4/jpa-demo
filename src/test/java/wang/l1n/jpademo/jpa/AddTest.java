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
        customer.setName("王五");
        customer.setAddress("江苏镇江");
        customer.setLevel("4");
        customer.setIndustry("EE");
        customer.setPhone("13914545748");
        customer.setDelete(Boolean.FALSE);
        customer.setAvailable(Boolean.TRUE);
        customerRepository.save(customer);
    }

    @Test
    public void test02() {
        Customer customer = new Customer();
        customer.setId("297ea23e73195dfe0173195e019b0000");
        customer.setName("test");
        customer.setAddress("江苏淮安");
        customer.setLevel("10");
        customer.setDelete(Boolean.FALSE);
        customer.setAvailable(Boolean.TRUE);
        customerRepository.save(customer);
    }
}
