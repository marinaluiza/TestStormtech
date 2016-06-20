package sorting.service.model;

public class SortType {

	private SortAttributes attribute;
	private SortDirection direction;

	public SortType(SortAttributes attribute, SortDirection direction) {
		this.attribute = attribute;
		this.direction = direction;
	}

	public SortAttributes getAttribute() {
		return attribute;
	}

	public void setAttribute(SortAttributes attribute) {
		this.attribute = attribute;
	}

	public SortDirection getDirection() {
		return direction;
	}

	public void setDirection(SortDirection direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return attribute.toString() + " - " + direction.toString();
	}
}
