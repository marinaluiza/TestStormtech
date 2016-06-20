package sorting.service.model;

public enum SortDirection {
	ASCENDING("Ascending"), DESCENDING("Descending");
	
	private final String name;       

    private SortDirection(String name) {
        this.name = name;
    }

    public String toString() {
       return this.name;
    }
}
