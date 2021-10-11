package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "AccountBalance", description = "A Data Transfer Object that represents the user's balance per account")
public class AccountBalanceDTO implements Serializable {

    private Long balance;
    private Integer accountId;

    public AccountBalanceDTO(Long balance, Integer accountId) {
        this.balance = balance;
        this.accountId = accountId;
    }

    @JsonIgnore
    public Long getBalance() {
        return balance;
    }
    public void setBalance(Long balance) {
        this.balance = balance;
    }


    @ApiModelProperty(
            position = 1,
            value = "accountTypeId",
            name = "accountTypeId",
            dataType = "java.lang.Integer",
            example = "5",
            required = true
    )
    public Integer getAccountId() {
        return accountId;
    }
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
