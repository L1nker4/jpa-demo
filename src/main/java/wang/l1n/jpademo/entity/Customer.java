package wang.l1n.jpademo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_customer")
public class Customer extends BaseEntity{

  @Column(name = "name")
  private String name;

  @Column(name = "source")
  private String source;

  @Column(name = "level")
  private String level;

  @Column(name = "industry")
  private String industry;

  @Column(name = "phone",columnDefinition = "VARCHAR(11) COMMENT '手机号码'")
  private String phone;

  @Column(name = "address")
  private String address;


}