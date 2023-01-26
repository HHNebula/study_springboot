package com.my.springboot.study_springboot.utils;

import java.util.UUID;

public class CommonUtils {

    public String getUniqueSequence() {

        UUID uuid = UUID.randomUUID();
        return uuid.toString();

    }

}
