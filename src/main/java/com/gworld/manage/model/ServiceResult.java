package com.gworld.manage.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServiceResult {
    private boolean result;
    private String message;

    public ServiceResult(boolean result, String message) {
        this.result = result;
        this.message = message;
    }
    public ServiceResult(boolean result){ this.result = result; }
}
