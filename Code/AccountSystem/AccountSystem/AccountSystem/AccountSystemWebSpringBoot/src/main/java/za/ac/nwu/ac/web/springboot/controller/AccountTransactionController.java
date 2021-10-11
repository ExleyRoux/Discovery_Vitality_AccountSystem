package za.ac.nwu.ac.web.springboot.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTransactionDTO;
import za.ac.nwu.ac.domain.dto.AccountTypeDTO;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.CreateTransactionFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.FetchTransactionFlow;

import java.util.List;

@RestController
@RequestMapping("account-transactions")
@ComponentScan(value = "za.ac.nwu.ac.logic.flow")
public class AccountTransactionController {

    private FetchTransactionFlow fetchTransactionFlow;
    private CreateTransactionFlow createTransactionFlow;

    @Autowired
    public AccountTransactionController(FetchTransactionFlow fetchTransactionFlow, @Qualifier("createTransactionFlowName") CreateTransactionFlow createTransactionFlow) {
        this.fetchTransactionFlow = fetchTransactionFlow;
        this.createTransactionFlow = createTransactionFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Transactions.", notes = "Returns a list of transactions")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Transactions returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<List<AccountTransactionDTO>>> getAll(){
        List<AccountTransactionDTO> accountTransactions = fetchTransactionFlow.getAllTransactions();
        GeneralResponse<List<AccountTransactionDTO>> response = new GeneralResponse<>(true, accountTransactions);
        return new ResponseEntity<GeneralResponse<List<AccountTransactionDTO>>>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Create a new transaction", notes = "Creates a new transaction in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The transaction was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTransactionDTO>> create(
            @ApiParam(
                    value = "Request body to create new transaction.",
                    required = true)
            @RequestBody AccountTransactionDTO accountTransactionDTO){
        AccountTransactionDTO accountTransactionResponse = createTransactionFlow.create(accountTransactionDTO);
        GeneralResponse<AccountTransactionDTO> response = new GeneralResponse<AccountTransactionDTO>(true, accountTransactionResponse);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }


}
