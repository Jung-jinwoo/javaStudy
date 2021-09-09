package tv;

public class TV {

	private int channel; // 1~255
	private int volume; // 0~100
	private boolean power;

	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public void power(boolean on) {
		if(on == true) {
			this.power = true;
			System.out.println("TV가 켜졌습니다.");
		}else {
			this.power = false;
			System.out.println("TV가 꺼졌습니다.");
		}
	}
	
	public void channel(int channel) {
		if(0<channel && channel<256) {
			this.channel = channel;
			System.out.println("채널이" + channel + "로 변경되었습니다");
		}else {
			System.out.println("잘못된 채널 정보 입니다.");
		}
	}
	
	public void channel(boolean up) {
		if(up && -1<channel && channel<255) {
			this.channel++;
			System.out.println("현재 채널은" + channel + "입니다.");
		}else {
			return;
		}
	}
	
	public void volume(int volume) {
		if(-1<volume && volume < 101) {
			this.volume = volume;
			System.out.println("볼륨이" + volume + "으로 변경되었습니다.");
		}else {
			System.out.println("볼륨은 100을 넘길수 없습니다.");
		}
	}
	
	public void volume(boolean up) {
		if(up && -1<volume && volume < 100) {
			this.volume++;
			System.out.println("볼륨이 증가하였습니다.");
		}else {
			this.volume--;
			System.out.println("볼륨이 감소하였습니다.");
		}
	}
	
	public void status() {
		System.out.println("TV [channel=" + channel + ", volume=" + volume + ", power=" + power + "]");
	}
	
}
