package com.hana.app.data.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private int itemId;
    private String itemName;
    private long itemPrice;
    private String imgName;
    private LocalDate regDate;
    private LocalDate updateDate;
}
