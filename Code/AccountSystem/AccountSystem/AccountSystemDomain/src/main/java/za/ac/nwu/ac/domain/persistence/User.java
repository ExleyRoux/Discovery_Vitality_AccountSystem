package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private Integer memberId;
    private String memberName;
    private String memberSurname;
    private Set<AccountTransaction> accountTransactions;


    public User(Integer memberId, String memberName, String memberSurname) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberSurname = memberSurname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_USER")
    public Integer getMemberId() {
        return memberId;
    }
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @Column(name = "NAME_USER")
    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Column(name = "SURNAME_USER")
    public String getMemberSurname() {
        return memberSurname;
    }
    public void setMemberSurname(String memberSurname) {
        this.memberSurname = memberSurname;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval = true, cascade = CascadeType.PERSIST)
    @ElementCollection(targetClass = AccountTransaction.class)
    public Set<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }
    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {this.accountTransactions = accountTransactions;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(memberId, user.memberId) && Objects.equals(memberName, user.memberName) && Objects.equals(memberSurname, user.memberSurname)  && Objects.equals(accountTransactions, user.accountTransactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, memberName, memberSurname, accountTransactions);
    }

    @Override
    public String toString() {
        return "User{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", memberSurname='" + memberSurname + '\'' +
                ", accountTransactions=" + accountTransactions +
                '}';
    }
}