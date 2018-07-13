package com.nhb.messaging.zmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nhb.common.async.CompletableFuture;
import com.nhb.common.data.PuDataType;
import com.nhb.common.data.PuElement;
import com.nhb.common.data.PuValue;

public interface ZMQMessageProcessor {

	public static final PuValue DEFAULT_SIMPLE_RESPONSE = new PuValue(true, PuDataType.BOOLEAN);

	static ZMQMessageProcessor DEBUG_MESSAGE_PROCESSOR = new ZMQMessageProcessor() {
		private final Logger logger = LoggerFactory.getLogger("ZMQMessageProcessor.DEBUG_MESSAGE_PROCESSOR");

		@Override
		public void process(PuElement data, CompletableFuture<PuElement> future) {
			logger.debug("Processing message: {}", data);
			future.setAndDone(DEFAULT_SIMPLE_RESPONSE);
		}
	};

	static ZMQMessageProcessor SIMPLE_RESPONSE_MESSAGE_PROCESSOR = new ZMQMessageProcessor() {

		@Override
		public void process(PuElement data, CompletableFuture<PuElement> future) {
			future.setAndDone(DEFAULT_SIMPLE_RESPONSE);
		}
	};

	static ZMQMessageProcessor ECHO_MESSAGE_PROCESSOR = new ZMQMessageProcessor() {

		@Override
		public void process(PuElement data, CompletableFuture<PuElement> future) {
			future.setAndDone(data);
		}
	};

	void process(PuElement data, CompletableFuture<PuElement> future);
}
