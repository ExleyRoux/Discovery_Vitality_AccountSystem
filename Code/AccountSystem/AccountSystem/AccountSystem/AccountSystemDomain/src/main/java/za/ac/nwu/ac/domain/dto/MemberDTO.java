package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.Member;

import java.io.Serializable;

@ApiModel(value = "Member", description = "A Data Transfer Object that represents the Member")
public class MemberDTO implements Serializable {

    private Integer memberId;
    private String firstName;
    private String lastName;

    public MemberDTO() {
    }

    public MemberDTO(Integer memberId, String firstName, String lastName) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public MemberDTO(Member member) {
        this.firstName = member.getFirstName();
        this.lastName = member.getLastName();
        this.memberId = member.getMemberId();
    }


    @ApiModelProperty(
            position = 1,
            value = "Member First Name",
            name = "Name",
            dataType = "java.lang.String",
            example = "John",
            required = true
    )
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @ApiModelProperty(
            position = 2,
            value = "Member Last Name",
            name = "LastName",
            dataType = "java.lang.String",
            example = "Travolta",
            required = true
    )
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonIgnore
    public Integer getId() {
        return memberId;
    }
    public void setId(Integer Id) {
        this.memberId = Id;
    }

    @JsonIgnore
    public Member getMember(){
        return new Member(this.getId(), this.getFirstName(), this.getLastName());
    }
}
