package ru.otus;

import lombok.extern.slf4j.Slf4j;
import ru.otus.servlet.UserAuthService;
import ru.otus.servlet.UserAuthServiceImpl;
import ru.otus.web.UsersWebServer;
import ru.otus.web.UsersWebServerWithFilterBasedSecurity;

@Slf4j
public class DbServiceDemo {

    private static final int WEB_SERVER_PORT = 5555;


    public static final String HIBERNATE_CFG_FILE = "hibernate.cfg.xml";

    public static void main(String[] args) throws Exception {

        UserAuthService authService = new UserAuthServiceImpl();

        UsersWebServer usersWebServer = new UsersWebServerWithFilterBasedSecurity(WEB_SERVER_PORT,
                authService);

        usersWebServer.start();
        usersWebServer.join();
    }
}
