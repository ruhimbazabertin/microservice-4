package com.mic.userservices.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Long departId;
    private String departName;
    private String departAddress;
    private String departCode;
}
