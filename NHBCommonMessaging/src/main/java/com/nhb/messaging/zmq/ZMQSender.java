package com.nhb.messaging.zmq;

import com.nhb.common.data.PuElement;

public interface ZMQSender {

	boolean isRunning();
	
	boolean isInitialized();

	void init(ZMQSocketRegistry registry, ZMQSenderConfig config);

	void start();

	void stop();

	ZMQFuture send(PuElement data);
}