package com.technia.migration.producer.producer;

import com.technia.migration.producer.model.Data;
import com.technia.migration.producer.model.Relationship;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

        private static final Logger logger =  LoggerFactory.getLogger(KafkaProducer.class);
        private static final String TOPIC_OBJECTS = "objects_json";
        private static final String TOPIC_RELATIONSHIP = "relationship_json";

        @Autowired
        private KafkaTemplate<Object, Data> objectsTemplate;

        @Autowired
        private KafkaTemplate<Object, Relationship> relationshipTemplate;

        public void sendObjectMessage(Data data){
            logger.info("Message is: {}", data);
            this.objectsTemplate.send(TOPIC_OBJECTS, data);
        }

        public void sendRelationshipMessage(Relationship relationship){
            logger.info("Message is: {}", relationship);
            this.relationshipTemplate.send(TOPIC_RELATIONSHIP, relationship);
        }

}
