package nb.stp.mansco.typein.service;



import nb.stp.mansco.base.service.GenericManager;
import nb.stp.mansco.typein.domain.TypeIn;

import java.util.List;


public interface TypeInManager extends GenericManager<TypeIn, Long> {
    public Object[] getDetails();
    public void updataDetails(TypeIn a);
    public void createDetails(TypeIn a);
    public void deleteDetails(Long id);
}
