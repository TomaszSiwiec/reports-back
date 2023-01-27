package com.storkfit.reportsback.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE");

    private String gender;

    public String getGender() {
        return gender;
    }
}
