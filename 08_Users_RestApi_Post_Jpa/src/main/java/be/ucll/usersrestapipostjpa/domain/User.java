package be.ucll.usersrestapipostjpa.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public long id;
    private String name;
    private int age;
    @Transient
    private List<Integer> membershipYears = new ArrayList<Integer>();

    public int countMembershipYearsAfter1999() {
        int result = 0;
        for (Integer year : membershipYears) {
            if (year > 1999)
                result++;
        }
        return result;
    }

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        if (age >= 0)
            this.age = age;
    }

    public int countYearsOfMembership() {
        return membershipYears.size();
    }

    public void addMembershipYear(int year) {
        membershipYears.add(year);
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

}