package com.josetesan.quarkus.pagila.actors;

import io.quarkus.jsonb.JsonbProducer;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Session;
import javax.json.bind.JsonbConfig;

@RequestScoped
public class ActorService {

    @Inject
    ConnectionFactory connectionFactory;

    @Inject
    JsonbProducer jsonbProducer;

    private JsonbConfig jsonbConfig;

    public ActorService() {
        jsonbConfig = new JsonbConfig();
    }


    public void publish(Actor actor) {
        try (JMSContext context = connectionFactory.createContext(Session.AUTO_ACKNOWLEDGE)) {
            context.createProducer()
                .send(context.createQueue("actors"), jsonbProducer.jsonb(jsonbConfig).toJson(actor));
        }
    }
}
