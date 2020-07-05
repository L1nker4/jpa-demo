package wang.l1n.jpademo.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import wang.l1n.jpademo.entity.Customer;
import wang.l1n.jpademo.entity.Linkman;
import wang.l1n.jpademo.repository.CustomerRepository;
import wang.l1n.jpademo.repository.LinkmanRepository;

/**
 * @author ：L1nker4
 * @date ： 创建于  2020/7/5 14:13
 * @description：
 */

@SpringBootTest
public class OneToManyTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LinkmanRepository linkmanRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void test01(){
        Customer customer = new Customer();
        customer.setName("王琦");
        customer.setAddress("江苏泰州");
        customer.setLevel("6");
        customer.setIndustry("we");
        customer.setPhone("13454545748");
        customer.setDelete(Boolean.FALSE);
        customer.setAvailable(Boolean.TRUE);

        Linkman linkman = new Linkman();
        linkman.setName("小李");


        linkman.setCustomer(customer);
        linkman.setDelete(Boolean.FALSE);
        linkman.setAvailable(Boolean.TRUE);
        customerRepository.save(customer);
        linkmanRepository.save(linkman);

    }
}
