package uk.co.hejp.listviewexample;

public class Landmark {

	/**
	 * A class to hold the landmark data.
	 */

	private String name, location;
	private int drawableId;

	public Landmark(String name, int drawableId, String location) {
		this.name = name;
		this.drawableId = drawableId;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public int getDrawableId() {
		return drawableId;
	}

	public String getLocation() {
		return location;
	}

}
