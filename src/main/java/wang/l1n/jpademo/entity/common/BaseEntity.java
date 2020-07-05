package wang.l1n.jpademo.entity.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(columnDefinition="VARCHAR(32) COMMENT 'id'")
    private String id;

    /**
     * 是否删除
     */
    @Column(name = "`delete`", columnDefinition = "tinyint(1) COMMENT '是否删除'")
    private Boolean delete;

    /**
     * 是否可用
     */
    @Column(name = "`available`", columnDefinition = "tinyint(1) COMMENT '是否可用'")
    private Boolean available;

    /**
     * 创建时间
     */
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(columnDefinition = "datetime(6) COMMENT '创建时间'")
    private Date createTime;

    /**
     * 更新时间
     */
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(columnDefinition = "datetime(6) COMMENT '更新时间'")
    private Date updateTime;

}
