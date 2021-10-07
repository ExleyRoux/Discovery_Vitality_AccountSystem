package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users", schema = "account_system")
public class User implements Serializable {

    private Long memberId;
    private String memberName;
    private String memberSurname;

    public User(Long memberId, String memberName, String memberSurname) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberSurname = memberSurname;
    }

    public User() {
    }

    @Id
    @Column(name = "ID_USER")
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
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

    //set up foreign key in AccountTypes table - one user can have many accounttypes, and each accounttype can have many transactions
    @OneToMany(targetEntity = AccountType.class, fetch = FetchType.LAZY, mappedBy = "accountTypeId", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountType> getAccountTypes(){
        return getAccountTypes();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(memberId, user.memberId) && Objects.equals(memberName, user.memberName) && Objects.equals(memberSurname, user.memberSurname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, memberName, memberSurname);
    }

    @Override
    public String toString() {
        return "User{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", memberSurname='" + memberSurname + '\'' +
                '}';
    }
}