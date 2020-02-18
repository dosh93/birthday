package ru.open.birthday.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "people")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull(message = "Заполнить имя")
    @Size(min = 1, message = "Имя должно содержать минимум 1 символ")
    private String name;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Нужно заполнить ДР")
    private Date birthday;

    @OneToMany(mappedBy = "who", fetch = FetchType.EAGER)
    private List<DepositedMoney> whos;

    @OneToMany(mappedBy = "whom", fetch = FetchType.EAGER)
    private List<DepositedMoney> whoms;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<DepositedMoney> getWhos() {
        return whos;
    }

    public void setWhos(List<DepositedMoney> whos) {
        this.whos = whos;
    }

    public List<DepositedMoney> getWhoms() {
        return whoms;
    }

    public void setWhoms(List<DepositedMoney> whoms) {
        this.whoms = whoms;
    }
}
