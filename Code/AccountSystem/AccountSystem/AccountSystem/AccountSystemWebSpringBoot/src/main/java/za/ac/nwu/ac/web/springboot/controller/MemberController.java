package za.ac.nwu.ac.web.springboot.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTypeDTO;
import za.ac.nwu.ac.domain.dto.MemberDTO;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.CreateMemberFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.FetchMemberFlow;

import java.util.List;

@RestController
@RequestMapping("member")
@ComponentScan(value = "za.ac.nwu.ac.logic.flow")
public class MemberController {

    private FetchMemberFlow fetchMemberFlow;
    private CreateMemberFlow createMemberFlow;

    @Autowired
    public MemberController(FetchMemberFlow fetchmemberFlow, @Qualifier("createMemberFlowName") CreateMemberFlow createMemberFlow){
        this.fetchMemberFlow = fetchMemberFlow;
        this.createMemberFlow = createMemberFlow;
    }



    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured members.", notes = "Returns a list of members")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Members returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<List<MemberDTO>>> getAll(){
        try {
            List<MemberDTO> member = fetchMemberFlow.getAllMembers();
            GeneralResponse<List<MemberDTO>> response = new GeneralResponse<>(true, member);
            return new ResponseEntity<GeneralResponse<List<MemberDTO>>>(response, HttpStatus.OK);
        } catch (Exception e){
            throw new RuntimeException("Something went wrong:" + e);
        }
    }


    @PostMapping("")
    @ApiOperation(value = "Create a new member", notes = "Creates a new member in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The member was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MemberDTO>> create(
            @ApiParam(
                    value = "Request body to create new account type.",
                    required = true)
            @RequestBody MemberDTO member){
        MemberDTO memberResponse = createMemberFlow.create(member);
        GeneralResponse<MemberDTO> response = new GeneralResponse<MemberDTO>(true, memberResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
