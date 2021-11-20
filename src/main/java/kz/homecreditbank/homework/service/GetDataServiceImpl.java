package kz.homecreditbank.homework.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.homecreditbank.homework.dto.GetDataParseDTO;
import kz.homecreditbank.homework.dto.GetDataResponseDTO;
import kz.homecreditbank.homework.exception.ProcessingException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetDataServiceImpl implements GetDataService {

    @Value("${get-data.service.url}")
    private String getDataServiceUrl;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public GetDataServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    @SneakyThrows
    public GetDataResponseDTO getData(Long id) {
        GetDataResponseDTO responseDTO = new GetDataResponseDTO();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        String url = getDataServiceUrl + "/" + id;
        ResponseEntity<Object> result = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Object.class);

        if (result.getStatusCode() != HttpStatus.OK)
            throw new ProcessingException("Error while receive a service response: " + result.getStatusCode());

        GetDataParseDTO parseDTO = objectMapper.convertValue(result.getBody(), GetDataParseDTO.class);

        responseDTO.setMessage(parseDTO.getText());
        return responseDTO;
    }
}
