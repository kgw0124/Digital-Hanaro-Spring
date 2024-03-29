package com.hana.app.dto;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopDto {
    private int id;
    private String title;
    private String img;
    private double lat;
    private double lng;
}
