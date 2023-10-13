package by.refor.mobilefarm.service;

import by.refor.mobilefarm.model.bo.Nutrients;
import by.refor.mobilefarm.model.bo.Ration;
import by.refor.mobilefarm.model.dto.CalculatedRation;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface RationService {
   List<CalculatedRation> calculateRation(Ration ration, Long geneticGroupId);
   void deleteRationById(Long rationId);
   List<Integer> findByOrganizationName(String organization);

   List <Ration> getAll();
}
