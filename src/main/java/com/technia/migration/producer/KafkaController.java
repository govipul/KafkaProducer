package com.technia.migration.producer;

import com.technia.migration.producer.model.Data;
import com.technia.migration.producer.model.Relationship;
import com.technia.migration.producer.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

        private final Logger LOGGER = LoggerFactory.getLogger(KafkaController.class);
        private final KafkaProducer producer;


        @Autowired
        public KafkaController(KafkaProducer producer){
            this.producer = producer;
        }

        @PostMapping("/publishObjects")
        public void sendObjectsMessage(@RequestBody Data message){
            LOGGER.info("Message from REST: {}", message);
            this.producer.sendObjectMessage(message);
        }

        @PostMapping("/publishRelationships")
        public void sendRelationshipMessage(@RequestBody Relationship message){
            LOGGER.info("Message from REST: {}", message);
            this.producer.sendRelationshipMessage(message);
        }


}
