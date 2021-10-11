package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

import java.io.Serializable;
import java.time.LocalDate;

@ApiModel(value = "AccountTransaction", description = "A Data Transfer Object that represents the Account Transactions.")
public class AccountTransactionDTO implements Serializable {

    private Integer memberId;
    private Long amount;
    private Integer accountTypeId;
    private LocalDate transactionDate;

    public AccountTransactionDTO(){}

    public AccountTransactionDTO(Integer accountTypeId, Long amount, LocalDate transactionDate){
        this.accountTypeId = accountTypeId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDTO(AccountTransaction accountTransaction){
        this.accountTypeId = accountTransaction.getAccountType().getId();
        this.amount = accountTransaction.getAmount();
        this.transactionDate = accountTransaction.getTransactionDate();
    }

    @ApiModelProperty(
            position = 1,
            value = "Account transaction type id",
            name = "AccountTypeId",
            dataType = "java.lang.Integer",
            example = "2",
            required = true
    )
    public Integer getTransactionAccountTypeId() {
        return accountTypeId;
    }
    public void setTransactionAccountTypeName(Integer accountMnemonic){this.accountTypeId = accountMnemonic;}

    @ApiModelProperty(
            position = 2,
            value = "Transaction Amount",
            name = "Amount",
            dataType = "java.lang.Long",
            example = "1000",
            required = true
    )
    public Long getTransactionAmount(){return amount;}
    public void setTransactionAmount(Long amount){this.amount = amount;}

    @ApiModelProperty(
            position = 3,
            value = "Transaction Date",
            name = "Date",
            dataType = "java.lang.LocalDate",
            example = "2020-01-01",
            required = true
    )
    public LocalDate getTransactionDate(){return transactionDate;}
    private void setTransactionDate(LocalDate date){this.transactionDate = date;}

    @ApiModelProperty(
            position = 4,
            value = "Member Id",
            name = "ID",
            dataType = "java.lang.Integer",
            example = "2",
            required = true
    )
    public Integer getMemberId(){return memberId;}
    private void setMemberId(Integer id){this.memberId = id;}

    @JsonIgnore
    public AccountTransaction getAccountTransaction(){
        return new AccountTransaction(this.getMemberId(), this.getTransactionAccountTypeId(), this.getTransactionDate(), this.getTransactionAmount());
    }
}
