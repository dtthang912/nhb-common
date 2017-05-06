package com.nhb.common.predicate.object;

import com.nhb.common.predicate.Predicate;
import com.nhb.common.predicate.value.BooleanValue;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public abstract class ObjectDependencePredicate extends ObjectDependenceValue<Boolean>
		implements ObjectDependence, Predicate, BooleanValue {

	private static final long serialVersionUID = 4665949298760960451L;

	@Setter
	@Getter(AccessLevel.PROTECTED)
	private Object object;

	@Override
	public final boolean apply(Object obj) {
		this.fill(obj);
		return this.get();
	}

	@Override
	public final void fill(Object object) {
		this.object = object;
		this.fill();
	}

	protected abstract void fill();
}
