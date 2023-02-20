package com.example.hrmanagment.payload;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class TaskSetStateDto {

    @NotNull
    private String state;

}
