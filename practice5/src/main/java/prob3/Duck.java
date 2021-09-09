package prob3;

public class Duck extends Bird{

	@Override
	public void fly() {
		super.setFly("날지 않습니다.");
	}

	@Override
	public void sing() {
		super.setSing("소리내어 웁니다");
	}

	public String toString() {
		return "오리(" + name + ")는 " + getFly() + "\n" + 
				"오리(" + name + ")가 " + getSing() + "\n"+
				"오리의 이름은 " + name + " 입니다.";
	}
	
}
