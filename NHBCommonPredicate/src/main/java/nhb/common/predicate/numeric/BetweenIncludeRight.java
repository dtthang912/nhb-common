package nhb.common.predicate.numeric;

import nhb.common.predicate.Predicate;
import nhb.common.predicate.utils.NumberComparator;
import nhb.common.predicate.value.ObjectDependence;
import nhb.common.predicate.value.Value;

public class BetweenIncludeRight implements Predicate {

	private static final long serialVersionUID = 4810722470454943505L;
	
	private NumberComparator comparator = new NumberComparator();
	private Value<? extends Number> lowerBound;
	private Value<? extends Number> upperBound;
	private Value<? extends Number> value;

	public BetweenIncludeRight(Value<? extends Number> value, Value<? extends Number> lowerBound,
			Value<? extends Number> upperBound) {
		this.value = value;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	@Override
	public boolean apply(Object object) {
		if (this.value instanceof ObjectDependence) {
			((ObjectDependence) this.value).fill(object);
		}
		return comparator.compare(this.value.get(), this.lowerBound.get()) > 0
				&& comparator.compare(this.value.get(), this.upperBound.get()) <= 0;
	}
}