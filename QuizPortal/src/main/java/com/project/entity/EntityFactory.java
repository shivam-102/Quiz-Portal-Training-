package com.project.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityFactory {
    @Getter
    @Setter
    EntityImplementation entityImplementation;
}
