package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "account_transactions")
public class AccountTransaction implements Serializable {

    private Integer transactionId;
    private AccountType accountType;
    private User user;
    private Long amount;
    private LocalDate transactionDate;

    public AccountTransaction(Integer transactionId, AccountType accountType, User member, Long amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountType = accountType;
        this.user = member;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_TRANSACTION")
    public Integer getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    //this is how foreign keys are added, also see in AccountType class
    //many transactions for each account id
    //just use fetchtype lazy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ACCOUNT_TYPE")
    public AccountType getAccountType() {
        return accountType;
    }
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "AMOUNT")
    public Long getAmount() {
        return amount;
    }
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Column(name = "DATE_TRANSACTION")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountType, that.accountType) && Objects.equals(user, that.user) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountType, user, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionId=" + transactionId +
                ", accountType=" + accountType +
                ", user=" + user +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
