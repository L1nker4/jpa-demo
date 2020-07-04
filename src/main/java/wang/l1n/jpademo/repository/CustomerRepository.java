package wang.l1n.jpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import wang.l1n.jpademo.entity.Customer;

/**
 * @author ：L1nker4
 * @date ： 创建于  2020/7/3 23:06
 * @description：
 */
public interface CustomerRepository extends JpaRepository<Customer, String>, JpaSpecificationExecutor<Customer> {
}
