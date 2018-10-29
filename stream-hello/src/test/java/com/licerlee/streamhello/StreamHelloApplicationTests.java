package com.licerlee.streamhello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableBinding(value = { StreamHelloApplicationTests.SinkSender.class })
public class StreamHelloApplicationTests {

	@Autowired
	private SinkSender sinkSender;

	@Test
	public void contextLoads() {
		sinkSender.output().send(MessageBuilder.withPayload("produce a message ：http://blog.didispace.com").build());
	}

	public interface SinkSender {
		/**
		 * 通过@Output(SinkSender.OUTPUT)定义了一个输出通过，
		 * 而该输出通道的名称为input，与前文中的Sink中定义的消费通道同名，
		 * 所以这里的单元测试与前文的消费者程序组成了一对生产者与消费者。
		 */
		String OUTPUT = "input";

		@Output(SinkSender.OUTPUT)
		MessageChannel output();
	}

}
