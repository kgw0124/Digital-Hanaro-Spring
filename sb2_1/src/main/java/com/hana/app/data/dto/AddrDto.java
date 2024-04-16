package com.hana.app.data.dto;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddrDto {
    private Integer addrId;
    private String addrName;
    private String addrDetail;
    private String custId;
}
