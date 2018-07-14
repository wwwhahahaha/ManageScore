package nb.stp.mansco.typein.service;



import nb.stp.mansco.base.service.GenericManager;
import nb.stp.mansco.typein.domain.TypeIn;

import java.util.List;


public interface TypeInManager extends GenericManager<TypeIn, Long> {
    List<TypeIn> findByCode(String code);
}
