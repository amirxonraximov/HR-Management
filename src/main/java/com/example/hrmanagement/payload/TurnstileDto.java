package com.example.hrmanagment.payload;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class TurnstileDto {

    @NotNull
    private String name;

}
