package com.xworkz.snapbasket.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name ="product_info")
@NamedQuery(name = "getAll", query = "select s from SnapbasketEntity s")
@NamedQuery(name="findNameById", query = "select s from SnapbasketEntity s where s.id=:id")
@NamedQuery(name = "updateById" , query = "select s from SnapbasketEntity s where s.id=:id")
public class SnapbasketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "user_Name")
    private  String userName;
    @Column(name = "email")
    private String email;
    @Column(name ="phone_Num")
    private long phoneNumber;


}
