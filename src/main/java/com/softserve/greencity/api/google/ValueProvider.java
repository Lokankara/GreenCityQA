package com.softserve.greencity.api.google;

import lombok.NonNull;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

import static com.softserve.greencity.api.google.GoogleSheet.getRow;

public class ValueProvider {
    protected static final Logger logger = LoggerFactory.getLogger(ValueProvider.class);

    @BeforeMethod
    private void logGetterInfo(Method method) {
        logger.info(method.getName());
    }

    @SneakyThrows

    public static String getinvalidPassDigit() {
        return (String) getRow(1).get(1);
    }

    @SneakyThrows
    public static String getdefaultName() {
        return (String) getRow(2).get(1);
    }

    @SneakyThrows
    public static String getemailForRegistration() {
        return (String) getRow(3).get(1);
    }

    @SneakyThrows
    public static String getdefaultPass() {
        return (String) getRow(4).get(1);
    }

    @SneakyThrows
    public static String gettemporaryPass() {
        return (String) getRow(5).get(1);
    }

    @SneakyThrows
    public static String getinvalidName() {
        return (String) getRow(6).get(1);
    }

    @SneakyThrows
    public static String getinvalidPassLowercase() {
        return (String) getRow(7).get(1);
    }

    @SneakyThrows
    public static String getnameForRegistration() {
        return (String) getRow(8).get(1);
    }

    @SneakyThrows
    public static String getinvalidPass() {
        return (String) getRow(9).get(1);
    }

    @SneakyThrows
    public static String getinvalidPassSpecChar() {
        return (String) getRow(10).get(1);
    }

    @SneakyThrows
    public static String getinvalidPassSpace() {
        return (String) getRow(11).get(1);
    }

    @SneakyThrows
    public static String getinvalidPassLength() {
        return (String) getRow(12).get(1);
    }

    @SneakyThrows
    public static String getcomfTemporaryPass() {
        return (String) getRow(13).get(1);
    }

    @SneakyThrows
    public static String getgoogleEmail() {
        return (String) getRow(14).get(1);
    }

    @SneakyThrows
    @NonNull
    public static String getgooglePass() {
        return (String) getRow(15).get(1);
    }

    @SneakyThrows
    public static String getinvalidPassUppercase() {
        return (String) getRow(16).get(1);
    }

    @SneakyThrows
    public static String getvalidIncorrectPassword() {
        return (String) getRow(17).get(1);
    }

    @SneakyThrows
    public static String gettemporaryLoginName() {
        return (String) getRow(18).get(1);
    }

    @SneakyThrows
    public static String getdefaultEmail() {
        return (String) getRow(19).get(1);
    }

    @SneakyThrows
    public static String getinvalidEmail() {
        return (String) getRow(20).get(1);
    }

    @SneakyThrows
    public static String getpasswordForRegistration() {
        return (String) getRow(21).get(1);
    }

    @SneakyThrows
    public static String getvalidUnregisterEmail() {
        return (String) getRow(22).get(1);
    }

    @SneakyThrows
    public static String getUnregisterEmailPassword() {
        return (String) getRow(23).get(1);
    }

    @SneakyThrows
    public static String getComfUnregisterEmailPassword() {
        return (String) getRow(24).get(1);
    }

    @SneakyThrows
    public static String getAdminEmail() {
        return (String) getRow(31).get(1);
    }

    @SneakyThrows
    public static String getAdminPass() {
        return (String) getRow(32).get(1);
    }

    @SneakyThrows
    public static String getExistUser() {
        return (String) getRow(29).get(1);
    }

    @SneakyThrows
    public static String getExistUserPassword() {
        return (String) getRow(30).get(1);
    }

    @SneakyThrows
    public static Boolean remote() {
        try {
            logger.info("remote: " + Boolean.valueOf((String) getRow(25).get(1)));
            return Boolean.valueOf((String) getRow(25).get(1));
            //return false;
        } catch (NullPointerException e) {
            throw new Exception("Please add remote: TRUE/FALSE credential to google sheet");
        }
    }

    @SneakyThrows
    public static String getBaseUrl() {
        try {
            return (String) getRow(26).get(1);
        } catch (NullPointerException e) {
            logger.error("Fail to get link from google sheet, used hardcode link");
            return "https://ita-social-projects.github.io/GreenCityClient/#/welcome";
        }
    }
}
