package com.nhb.common.workflow.statemachine.impl;

import com.nhb.common.workflow.statemachine.State;
import com.nhb.common.workflow.statemachine.Transition;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SimpleTransition implements Transition {

	private int id;
	@Builder.Default
	private State from = State.ASTERISK;
	@Builder.Default
	private State to = State.ASTERISK;
}
