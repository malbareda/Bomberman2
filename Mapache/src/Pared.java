
public class Pared extends Coso {

	public Pared(int x, int y) {
		this.x=x;
		this.y=y;
		img = 1;
	}
	@Override
	protected boolean hit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean move() {
		// TODO Auto-generated method stub
		System.out.println("pop");
		return false;
	}

}