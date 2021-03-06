package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "members")
public class Member implements Serializable {
    private Integer memberId;
    private String firstName;
    private String lastName;
    private Set<AccountTransaction>  accountTransactions;

    public Member(){}

    public Member(Integer memberId, String firstName, String lastName, Set<AccountTransaction> accountTransactions) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountTransactions = accountTransactions;
    }

    public Member(Integer id, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberId = id;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID_MEMBERS")
    public Integer getMemberId() {
        return memberId;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "member", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        Member member = (Member) o;
        return Objects.equals(memberId, member.memberId) && Objects.equals(firstName, member.firstName) && Objects.equals(lastName, member.lastName) && Objects.equals(accountTransactions, member.accountTransactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, firstName, lastName, accountTransactions);
    }

    @Override
    public String toString() {
        return "Member{" +
                "ID=" + memberId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountTransactions=" + accountTransactions +
                '}';
    }
}
