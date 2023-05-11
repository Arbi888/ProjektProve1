package ProjektiProve.model;


import ProjektiProve.exception.ResourceNotFountException;
import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor

public enum Role {
    CUSTOMER("CUSTOMER"),
    ADMIN("ADMIN");

    private String value;

    public static Role fromValue(String value){
        return Arrays.asList(Role.values())
                .stream().filter(r -> r.value.equals(value))
                .findFirst()
                .orElseThrow(()-> new ResourceNotFountException(String
                        .format("Role %s not found",value)));
    }

    public String getValue() {
        return value;
    }
}


