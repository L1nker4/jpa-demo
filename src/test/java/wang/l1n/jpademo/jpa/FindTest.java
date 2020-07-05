package wang.l1n.jpademo.jpa;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import wang.l1n.jpademo.entity.Customer;
import wang.l1n.jpademo.repository.CustomerRepository;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

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
        Optional<Customer> customer = customerRepository.findById("297ea23e73195dfe0173195e019b0000");
        customer.ifPresent(System.out::println);
    }

    @Test
    public void test02() {
        List<Customer> customers = customerRepository.findAll();
        System.out.println(customers);
    }

    @Test
    public void test03() {
        Customer customers = customerRepository.findJPQL("jack");
//        System.out.println(customers);
        Customer customer = customerRepository.findJPQL2("jack", "9");
        System.out.println(customer);
    }

    @Test
    public void test04() {
        List<Customer> customers = customerRepository.findByNameLikeAndAddressContains("jack", "江苏");
        System.out.println(customers);
    }


    @Test
    public void test05() {
        Specification<Customer> specification = (Specification<Customer>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = Lists.newArrayList();
            predicates.add(criteriaBuilder.equal(root.get("delete"), Boolean.FALSE));
            predicates.add(criteriaBuilder.equal(root.get("available"), Boolean.TRUE));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        Pageable pageable = PageRequest.of(0, 2, Sort.Direction.DESC, "createTime");

        Page<Customer> customers = customerRepository.findAll(specification, pageable);
        long count = customerRepository.count(specification);
        System.out.println(count);
        System.out.println(customers.getContent());
        System.out.println(customers.getTotalPages());
        System.out.println(customers.getNumber());
        System.out.println(customers.getSize());
        System.out.println(customers.getTotalElements());
        System.out.println(customers.getSort());
    }

}
