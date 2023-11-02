package ru.otus.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.cfg.Configuration;
import ru.otus.core.repository.DataTemplateHibernate;
import ru.otus.core.repository.HibernateUtils;
import ru.otus.core.sessionmanager.TransactionManagerHibernate;
import ru.otus.crm.model.Address;
import ru.otus.crm.model.Client;
import ru.otus.crm.model.Phone;
import ru.otus.crm.service.DBServiceClient;
import ru.otus.crm.service.DbServiceClientImpl;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.otus.DbServiceDemo.HIBERNATE_CFG_FILE;


public class UsersServlet extends HttpServlet {

    private static final String USERS_PAGE_TEMPLATE = "clients.html";

    private final DBServiceClient dbServiceClient;

    private final TemplateProcessor templateProcessor;

    public UsersServlet(TemplateProcessor templateProcessor) {
        this.templateProcessor = templateProcessor;

        var configuration = new Configuration().configure(HIBERNATE_CFG_FILE);

        var sessionFactory = HibernateUtils.buildSessionFactory(configuration, Client.class, Phone.class, Address.class);
        var transactionManager = new TransactionManagerHibernate(sessionFactory);

        var clientTemplate = new DataTemplateHibernate<>(Client.class);

        dbServiceClient = new DbServiceClientImpl(transactionManager, clientTemplate);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
        Map<String, Object> paramsMap = new HashMap<>();

        Client client = new Client();
        client.setName("1");
        client.setAddress(new Address());
        client.setId(1L);
        client.setPhones(Collections.emptyList());
        List<Client> all = dbServiceClient.findAll();

//        userDao.findRandomUser().ifPresent(randomUser -> paramsMap.put(TEMPLATE_ATTR_RANDOM_USER, randomUser));

        paramsMap.put("clients",all);
        response.setContentType("text/html");
        response.getWriter().println(templateProcessor.getPage(USERS_PAGE_TEMPLATE, paramsMap));
    }

}
