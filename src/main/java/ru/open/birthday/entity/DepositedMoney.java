package ru.open.birthday.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "deposited_money", schema = "public")
public class DepositedMoney {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "who")
    private People who;

    @ManyToOne
    @JoinColumn(name = "whom")
    private People whom;

    @Column
    @NotNull(message = "Нужно заполнить деньги")
    private Double money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public People getWho() {
        return who;
    }

    public void setWho(People who) {
        this.who = who;
    }

    public People getWhom() {
        return whom;
    }

    public void setWhom(People whom) {
        this.whom = whom;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
