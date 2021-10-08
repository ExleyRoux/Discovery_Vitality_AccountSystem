package za.ac.nwu.ac.logic.flow;

import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;

public interface CreateAccountTypeFlow{
    AccountTypeDto create(AccountTypeDto accountType);
}
