package com.project.service;

import com.project.entity.EntityImplementation;
import org.springframework.stereotype.Component;

@Component
public class CustomObjectFactory implements EntityImplementation {
    Operation operationRequired;
    public Operation getOperationRequired() {
        return operationRequired;
    }

    public void setOperationRequired(Operation operationRequired) {
        this.operationRequired = operationRequired;
    }
}
