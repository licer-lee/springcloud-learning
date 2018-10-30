package com.licerlee.eurekamqconsumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class SinkReceiver {

	
	@StreamListener(Sink.INPUT)
	public void recevie(Object obj){
		System.out.println("Received:"+ obj);
	}
	
}
