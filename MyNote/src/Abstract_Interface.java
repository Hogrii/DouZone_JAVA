
abstract class House {
	private String roof = "House roof";
	private String wall = "House wall";
	private Door door;
	
	void setDoor(Door door) {
		this.door = door;
	}
	
	Door getDoor() {
		return door;
	}
	
	void openDoor() {
		System.out.println("Basic door opened");
	}
	
	void closeDoor() {
		System.out.println("Basic door closed");
	}
}

class BasicHouse extends House {
	
}

interface Door {
	void openDoor();
	void closeDoor();
}

class MyHouse extends House {
	@Override
	void openDoor() {
		getDoor().openDoor();
	}
	
	@Override
	void closeDoor() {
		getDoor().closeDoor();
	}
}

class MyDoor implements Door {

	@Override
	public void openDoor() {
		System.out.println("My door opened");
	}

	@Override
	public void closeDoor() {
		System.out.println("My door closed");
	}

}

public class Abstract_Interface {
	public static void main(String[] args) {
		House basicHouse = new BasicHouse();
		
		basicHouse.openDoor();
		basicHouse.closeDoor();
		
		House myHouse = new MyHouse();
		Door myDoor = new MyDoor();
		
		myHouse.setDoor(myDoor);
		myHouse.openDoor();
		myHouse.closeDoor();
	}
}
