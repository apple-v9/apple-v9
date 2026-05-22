package com.av.razorhealth.api.producer;

import com.av.razorhealth.api.model.WorkerAbsenceRequest;
import org.springframework.stereotype.Service;

@Service
public class WorkerAbsenceProducer {

    public void sendAbsenceEvent(WorkerAbsenceRequest request){
        // Here you would implement the logic to send the absence event to a message broker like Kafka or RabbitMQ
        // For example, you could use KafkaTemplate to send the event to a Kafka topic
        System.out.println("Sending absence event for worker: " + request.getWorkerId() + " with type: " + request.getAbsenceType());
    }
}
