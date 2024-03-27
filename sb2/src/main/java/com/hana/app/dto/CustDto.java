package com.hana.app.dto;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustDto {
    private String id;
    private String pwd;
    private String name;
}
