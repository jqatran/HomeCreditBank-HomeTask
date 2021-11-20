package kz.homecreditbank.homework.dto;

import lombok.Data;

@Data
public class GetDataParseDTO {
    private String text;
    private Integer number;
    private Boolean found;
    private String type;
}
