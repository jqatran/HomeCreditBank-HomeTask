package kz.homecreditbank.homework.service;

import kz.homecreditbank.homework.dto.GetDataParseDTO;
import kz.homecreditbank.homework.dto.GetDataResponseDTO;

public interface GetDataService {
    GetDataResponseDTO getData(Long id);
}
