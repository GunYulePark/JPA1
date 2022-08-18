package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Address;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = 'member_id')
    private long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") // Order 의 member에 종속된다.
    private List<Order> orders = new ArrayList<>();
}
