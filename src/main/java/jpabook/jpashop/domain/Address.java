package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable // 잘 변경안할거라 Embeddable로. Entity로 승격해도 문제는 없다.
@Getter
public class Address {

    private  String city;
    private  String street;
    private  String zipcode;

}
