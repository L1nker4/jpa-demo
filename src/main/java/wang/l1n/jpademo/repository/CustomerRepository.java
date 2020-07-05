package wang.l1n.jpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import wang.l1n.jpademo.entity.Customer;

import java.util.List;

/**
 * @author ：L1nker4
 * @date ： 创建于  2020/7/3 23:06
 * @description：
 */
public interface CustomerRepository extends JpaRepository<Customer, String>, JpaSpecificationExecutor<Customer> {


    /**
     * //@Query(nativeQuery = true, value = "select * from tb_customer where name = ?1")
     * @param name
     * @return
     */
    @Query(nativeQuery = true, value = "select * from tb_customer where name = :name")
    Customer findJPQL(String name);

    @Query(nativeQuery = true, value = "select * from tb_customer where name = ?1 and level = ?2")
    Customer findJPQL2(String name, String level);

    List<Customer> findByNameLikeAndAddressContains(String name, String address);

}
