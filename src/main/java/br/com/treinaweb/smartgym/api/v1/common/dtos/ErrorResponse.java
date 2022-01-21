package br.com.treinaweb.smartgym.api.v1.common.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private Integer status;
    private String cause;
    private String message;
    private LocalDateTime timestamp;
    private String path;
    private Map<String, List<String>> errors;

}
