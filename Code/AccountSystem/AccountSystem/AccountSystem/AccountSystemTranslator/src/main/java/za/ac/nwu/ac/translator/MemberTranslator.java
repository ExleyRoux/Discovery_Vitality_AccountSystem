package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.MemberDTO;
import java.util.List;

public interface MemberTranslator {
    MemberDTO create(MemberDTO member);
    List<MemberDTO> getAllMembers();

}
