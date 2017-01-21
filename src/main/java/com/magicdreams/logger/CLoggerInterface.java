package com.magicdreams.logger;

/**
 * Created by Prafful on 1/21/2017.
 * prafful.dhoke@gmail.com
 */
public interface CLoggerInterface {

    void build();

    CLoggerInterface forKey(CloggerKeys cloggerKeys, String messeage, Object... parameters);

    CLoggerInterface forMessage(String messeage, Object... parameters);

    CLoggerInterface forId(String messeage, Object... parameters);

    CLoggerInterface forUrl(String messeage, Object... parameters);
}
