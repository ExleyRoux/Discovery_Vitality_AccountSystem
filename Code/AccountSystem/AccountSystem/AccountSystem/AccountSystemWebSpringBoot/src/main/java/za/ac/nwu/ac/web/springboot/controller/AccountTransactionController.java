package za.ac.nwu.ac.web.springboot.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account-transactions")
@ComponentScan(value = "za.ac.nwu.ac.logic.flow")
public class AccountTransactionController {
}
