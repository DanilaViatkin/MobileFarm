package by.refor.mobilefarm.storage;

import by.refor.mobilefarm.model.bo.Farm;

public interface FarmStorage {
    Farm getFarmByGLN(String gln);
    Farm getFarmById(Long id);
}
