package com.hana.app.data.msg;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Msg {
    private String sendid;
    private String receiveid;
    private String content1;
}
