package wang.l1n.jpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wang.l1n.jpademo.entity.Linkman;

/**
 * @author ：L1nker4
 * @date ： 创建于  2020/7/5 13:55
 * @description：
 */
public interface LinkmanRepository extends JpaRepository<Linkman, String> {
}
