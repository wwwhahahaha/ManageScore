package nb.stp.mansco.inquire.service;

import nb.stp.mansco.base.service.GenericManager;
import nb.stp.mansco.inquire.domain.Inquire;

import java.util.List;


public interface InquireManager extends GenericManager<Inquire, Long> {
    List<Inquire> findByCode(String code);
}
