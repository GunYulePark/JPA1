package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter @Setter
public class Order {
    @Id
    @GeneratedValue
    @Column(name="order_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "member_id") // FK의 이름을 "member_id"로.
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    private Delivery delivery;

    private LocalDateTime orderDate;

    private OrderStatus status; // 주문상태 [ORDER, CANCEL]

}
