package wang.l1n.jpademo.entity;

import lombok.Data;
import lombok.ToString;
import wang.l1n.jpademo.entity.common.BaseEntity;

import javax.persistence.*;

/**
 * @author ：L1nker4
 * @date ： 创建于  2020/7/5 13:43
 * @description：
 */

@Entity
@Data
@Table(name = "tb_linkman")
@ToString(callSuper = true)
public class Linkman extends BaseEntity {


    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @ManyToOne(targetEntity = Customer.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "cust_id", columnDefinition = "VARCHAR(32) COMMENT '所属客户'")
    private Customer customer;
}
