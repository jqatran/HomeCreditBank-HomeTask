package kz.homecreditbank.homework.controller;

import kz.homecreditbank.homework.dto.GetDataResponseDTO;
import kz.homecreditbank.homework.service.GetDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestGetData {

    private static final String PATH_GET_DATA = "/get-data/{id}";

    private final GetDataService getDataService;

    public RestGetData(GetDataService getDataService) {
        this.getDataService = getDataService;
    }

    @GetMapping(name = "GET_DATA_BY_ID", value = PATH_GET_DATA, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetDataResponseDTO> getData(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(getDataService.getData(id), HttpStatus.OK);
    }


}
