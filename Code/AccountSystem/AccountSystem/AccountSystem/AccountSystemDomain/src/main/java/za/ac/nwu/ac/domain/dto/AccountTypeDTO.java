package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountType", description = "A Data Transfer Object that represents the Account Type.")
public class AccountTypeDTO implements Serializable {

    private String mnemonic;
    private String accountTypeName;
    private LocalDate creationDate;

    public AccountTypeDTO() {
    }

    public AccountTypeDTO(String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }

    public AccountTypeDTO(AccountType accountType) {
        this.mnemonic = accountType.getMnemonic();
        this.accountTypeName = accountType.getName();
        this.creationDate = accountType.getCreationDate();
    }

    @ApiModelProperty(
            position = 1,
            value = "Account type Mnemonic",
            name = "Mnemonic",
            dataType = "java.lang.String",
            example = "Miles",
            required = true
    )
    public String getMnemonic() {
        return mnemonic;
    }

    @ApiModelProperty(
            position = 2,
            value = "Account type Name",
            name = "Name",
            dataType = "java.lang.String",
            example = "Miles",
            allowEmptyValue = false,
            required = false
    )
    public String getAccountTypeName() {
        return accountTypeName;
    }

    @ApiModelProperty(
            position = 3,
            value = "Account type Creation Date",
            name = "CreationDate",
            notes = "The date on which the Account type was created",
            dataType = "java.time.LocalDate",
            example = "2020-01-01",
            allowEmptyValue = true,
            required = false
    )
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @JsonIgnore
    public AccountType getAccountType()
    {
        return new AccountType(this.getMnemonic(), this.getAccountTypeName(), this.getCreationDate());
    }
}
