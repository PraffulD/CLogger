package com.magicdreams.logger;

import org.junit.Test;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by Prafful on 1/21/2017.
 * prafful.dhoke@gmail.com
 */
public class CLoggerTest {

    private static final CLogger C_LOGGER = CLogger.getLogger(CLoggerTest.class);

    @Test
    public void test() {

        Long timeInMM = System.currentTimeMillis();
        Time currentTime = new Time(timeInMM);
        Date todayDate = new Date(timeInMM);

        C_LOGGER.trace()
                .forId("Printing trace level logs with key as ID at time {} and date {}", currentTime, todayDate)
                .forUrl("Printing trace level logs with key as URL at time {} and date {}", currentTime, todayDate)
                .forMessage("Printing trace level logs with key as Message at time {} and date {}", currentTime, todayDate)
                .forKey(CustomKeys.TITLE, "Printing trace level logs with key as Custom Key [TITLE] at time {} and date {}", currentTime, todayDate)
                .build();

        C_LOGGER.info()
                .forId("Printing info level logs with key as ID at time {} and date {}", currentTime, todayDate)
                .forUrl("Printing info level logs with key as URL at time {} and date {}", currentTime, todayDate)
                .forMessage("Printing info level logs with key as Message at time {} and date {}", currentTime, todayDate)
                .forKey(CustomKeys.TITLE, "Printing info level logs with key as Custom Key [TITLE] at time {} and date {}", currentTime, todayDate)
                .build();

        C_LOGGER.debug()
                .forId("Printing debug level logs with key as ID at time {} and date {}", currentTime, todayDate)
                .forUrl("Printing debug level logs with key as URL at time {} and date {}", currentTime, todayDate)
                .forMessage("Printing debug level logs with key as Message at time {} and date {}", currentTime, todayDate)
                .forKey(CustomKeys.TITLE, "Printing debug level logs with key as Custom Key [TITLE] at time {} and date {}", currentTime, todayDate)
                .build();

        C_LOGGER.warm()
                .forId("Printing warm level logs with key as ID at time {} and date {}", currentTime, todayDate)
                .forUrl("Printing warm level logs with key as URL at time {} and date {}", currentTime, todayDate)
                .forMessage("Printing warm level logs with key as Message at time {} and date {}", currentTime, todayDate)
                .forKey(CustomKeys.TITLE, "Printing warm level logs with key as Custom Key [TITLE] at time {} and date {}", currentTime, todayDate)
                .build();

        C_LOGGER.error()
                .forId("Printing error level logs with key as ID at time {} and date {}", currentTime, todayDate)
                .forUrl("Printing error level logs with key as URL at time {} and date {}", currentTime, todayDate)
                .forMessage("Printing error level logs with key as Message at time {} and date {}", currentTime, todayDate)
                .forKey(CustomKeys.TITLE, "Printing error level logs with key as Custom Key [TITLE] at time {} and date {}", currentTime, todayDate)
                .build();
    }

    private enum CustomKeys implements CloggerKeys {
        TITLE
    }
}
