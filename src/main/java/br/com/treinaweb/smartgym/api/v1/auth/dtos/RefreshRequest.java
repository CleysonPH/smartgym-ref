package br.com.treinaweb.smartgym.api.v1.auth.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RefreshRequest {

    @NotNull
    @NotEmpty
    private String refresh;

}
