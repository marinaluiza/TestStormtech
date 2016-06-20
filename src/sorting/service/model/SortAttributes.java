package sorting.service.model;

public enum SortAttributes {
	AUTHOR ("Author"), TITLE("Title"), EDITION_YEAR("Edition Year");
	
	private final String name;       

    private SortAttributes(String name) {
        this.name = name;
    }

    public String toString() {
       return this.name;
    }
}
