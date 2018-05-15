package com.test.many_to_one_test.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "phone_numbers", schema = "test")
public class PhoneNumbers implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private User user;

    private String number;

    public PhoneNumbers() {
    }

    public PhoneNumbers(String number) {
        this.number = number;
    }

    @Id
    @Column(name = "id", unique = true)
    @SequenceGenerator(name = "phone_numbers_id_seq", sequenceName = "test.phone_numbers_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "phone_numbers_id_seq")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
