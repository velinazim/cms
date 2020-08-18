package com.example;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Pet Object",description = "My Pet")
public class Pet {

    @ApiModelProperty(value = "Pet Object Id")
    private int id;
    @ApiModelProperty(value = "Pet Object Name")
    private String name;
    @ApiModelProperty(value = "Pet Object Date")
    private Date date;
}
