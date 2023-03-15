package com.cafe.POJO;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

//po spustení aplikácie sa nám na základe týchto údajov vytvorí tabuľka a ked budete pridavat alebo mazat userov
//tak sa podla toho bude updetovat
//akurát si sami musíme v sql vytvoriť databázu v názmov cafe : create database cafe;

@NamedQuery(name = "User.findByEmailId", query = "select u from User u where u.email=:email")
//toto je select príkaz kde u je alias a User je meno tabuľky, preto je s velkym pismenom (musí byť User s velkym U, inak to
//skončí chybou

@NamedQuery(name = "User.getAllUser", query = "select new com.cafe.wrapper.UserWrapper(u.id, u.name, u.email," +
        "u.contactNumber, u.status) from User u where u.role='user'")
//vyber požadované hodnoty z tabuľky User kde rola je user - toto sa volá metódou getAllUser z triedy UserServiceImpl
//nejako to ide cez triedy UserServiceImpl a UserRestImpl a cez ich interfacy...

@NamedQuery(name = "User.updateStatus", query = "update User u set u.status=:status where u.id=:id")

@NamedQuery(name = "User.getAllAdmin", query = "select u.email from User u where u.role='admin'")

@Data
//@Data - táto anotácia sa nám stara o gettery a settery, čiže nemusíme ich vobec pisat a vieme ich pouziť
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //autoincrement
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "contactNumber")
    private String contactNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private String status;

    @Column(name = "role")
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User() {
    }

    public User(String name, String contactNumber, String email, String password, String status, String role) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.password = password;
        this.status = status;
        this.role = role;
    }
}
