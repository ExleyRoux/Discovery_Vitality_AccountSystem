package za.ac.nwu.ac.web.sb.controller;


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
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;

@RestController
@RequestMapping("account-type")
@ComponentScan(value = "za.ac.nwu.ac.logic.flow")
public class AccountTypeController {

    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final CreateAccountTypeFlow createAccountTypeFlow;

    @Autowired
    public AccountTypeController(FetchAccountTypeFlow fetchAccountTypeFlow, @Qualifier("createAccountTypeFlowName") CreateAccountTypeFlow createAccountTypeFlow) {
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.createAccountTypeFlow = createAccountTypeFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account types.", notes = "Returns a list of account types.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account types returned.", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request.", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found.", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error.", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<String>> getAll(){
        GeneralResponse<String> response = new GeneralResponse<>("No types found.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){return new ResponseEntity<String>("Test", HttpStatus.OK);}

    @PostMapping("")
    @ApiOperation(value = "Creates a new AccountType.", notes = "Creates a new AccountType in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Creation of AccountType was successful.", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request.", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Not Found.", response = GeneralResponse.class),
    })
    public ResponseEntity<GeneralResponse<AccountTypeDto>> create(
            @ApiParam(value = "Request body to create a new AccountType.", required = true)
            @RequestBody AccountTypeDto accountType){
        AccountTypeDto accountTypeResponse = createAccountTypeFlow.create(accountType);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(accountTypeResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
