package prob3;

public class Sparrow extends Bird{
	@Override
	public void fly() {
		super.setFly("날아 다닙니다.");
	}

	@Override
	public void sing() {
		super.setSing("소리내어 웁니다");
	}

	public String toString() {
		return "참새(" + name + ")는 " + getFly() + "\n" + 
				"참새(" + name + ")가 " + getSing() + "\n"+
				"참새의 이름은 " + name + " 입니다.";
	}
}
