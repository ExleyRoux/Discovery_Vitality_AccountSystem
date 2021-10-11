package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.MemberDTO;

public interface CreateMemberFlow{
    MemberDTO create(MemberDTO memberDTO);
}
