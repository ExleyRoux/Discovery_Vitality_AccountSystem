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
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;

import java.util.List;

@RestController
@RequestMapping("account-type")
@ComponentScan(value = "za.ac.nwu.ac.logic.flow")
public class AccountTypeController {

    private FetchAccountTypeFlow fetchAccountTypeFlow;
    private CreateAccountTypeFlow createAccountTypeFlow;

    @Autowired
    public AccountTypeController(FetchAccountTypeFlow fetchAccountTypeFlow, @Qualifier("createAccountTypeFlowName") CreateAccountTypeFlow createAccountTypeFlow){
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.createAccountTypeFlow = createAccountTypeFlow;
    }


    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account types.", notes = "Returns a list of account types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<List<AccountTypeDTO>>> getAll(){
        List<AccountTypeDTO> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<List<AccountTypeDTO>> response = new GeneralResponse<>(true, accountTypes);
        return new ResponseEntity<GeneralResponse<List<AccountTypeDTO>>>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Create a new account type", notes = "Creates a new account type in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The account type was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTypeDTO>> create(
            @ApiParam(
                    value = "Request body to create new account type.",
                    required = true)
            @RequestBody AccountTypeDTO accountType){
        AccountTypeDTO accountTypeResponse = createAccountTypeFlow.create(accountType);
        GeneralResponse<AccountTypeDTO> response = new GeneralResponse<AccountTypeDTO>(true, accountTypeResponse);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

//    @GetMapping("{mnemonic}")
//    @ApiOperation(value = "Fetches the specified AccountType.", notes = "Fetches the AccountType corresponding to the given mnemonic.")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Goal Found", response = GeneralResponse.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class),
//    })
//    public ResponseEntity<GeneralResponse<AccountTypeDTO>> getAccountType(
//            @ApiParam(value = "The mnemonic that uniquely identifies the AccountType",
//            example = "MILES",
//            name = "mnemonic",
//            required = true)
//            @PathVariable("mnemonic") final String mnemonic){
//        AccountTypeDTO accountType = fetchAccountTypeFlow.getAccountTypeByMnemonic(mnemonic);
//        GeneralResponse<AccountTypeDTO> response = new GeneralResponse<>(true, accountType);
//        return new ResponseEntity<>(response,HttpStatus.OK);
//    }
}
