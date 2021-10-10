package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTypeDTO;

import java.util.List;

public interface FetchAccountTypeFlow {
    List<AccountTypeDTO> getAllAccountTypes();
}
