package com.datn.service;

import com.datn.model.RegularPass;
import com.datn.model.dto.RegularPassSub;

public interface RegularPassSubService {
    RegularPassSub createRegularPassSub(RegularPass regularPass);
    RegularPassSub updateRegularPassSub(RegularPassSub regularPassSub);
    RegularPassSub getRegularPassSub(Long id);
    void deleteRegularPassSub(Long id);
}
