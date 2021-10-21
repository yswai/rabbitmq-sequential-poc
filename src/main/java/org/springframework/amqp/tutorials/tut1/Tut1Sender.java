/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.amqp.tutorials.tut1;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author Gary Russell
 * @author Scott Deeg
 */
public class Tut1Sender {

	@Autowired
	private ConnectionFactory connectionFactory;

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private AmqpAdmin amqpAdmin;

	@Autowired
	@Qualifier("productA")
	private Queue queueProductA;

	@Autowired
	@Qualifier("productB")
	private Queue queueProductB;

	@Scheduled(fixedDelay = 1000, initialDelay = 500)
	public void takeProductAUser1() {
		String message = "takeProductA command User1";
		this.template.convertAndSend(queueProductA.getName(), message);
		System.out.println(" [x] Sent '" + message + "'");
	}

	@Scheduled(fixedDelay = 1000, initialDelay = 500)
	public void takeProductAUser2() {
		String message = "takeProductA command User2";
		this.template.convertAndSend(queueProductA.getName(), message);
		System.out.println(" [x] Sent '" + message + "'");
	}

	@Scheduled(fixedDelay = 1000, initialDelay = 500)
	public void takeProductB() {
		String message = "takeProductB command";
		this.template.convertAndSend(queueProductB.getName(), message);
		System.out.println(" [x] Sent '" + message + "'");
	}

}
