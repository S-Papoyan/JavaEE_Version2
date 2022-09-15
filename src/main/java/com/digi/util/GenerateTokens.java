package com.digi.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class GenerateTokens {

    public static String generateVerifyCode() {

        return RandomStringUtils.random(5,false,true);

    }
}
