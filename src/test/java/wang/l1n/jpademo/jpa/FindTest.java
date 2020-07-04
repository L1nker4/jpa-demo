package wang.l1n.jpademo.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wang.l1n.jpademo.entity.Customer;
import wang.l1n.jpademo.repository.CustomerRepository;

import java.util.List;

/**
 * @author ：L1nker4
 * @date ： 创建于  2020/7/4 18:05
 * @description：
 */

@SpringBootTest
public class FindTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void test01() {
        List<Customer> all = customerRepository.findAll();
        System.out.println(all);
    }
}
