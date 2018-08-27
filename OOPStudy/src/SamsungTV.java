import java.rmi.Remote;

/**
 * 다중구현을 이용한 클래스 정의
 * 
 * @author 최재민
 *
 */
public class SamsungTV implements RemoteControl, Browsable {

	private int currentChannel;
	private int currentVolume;

	public SamsungTV() {

	}

	public SamsungTV(int currentChannel, int currentVolume) {
		super();
		this.currentChannel = currentChannel;
		this.currentVolume = currentVolume;
	}

	public int getCurrentChannel() {
		return currentChannel;
	}

	public void setCurrentChannel(int currentChannel) {
		this.currentChannel = currentChannel;
	}

	public int getCurrentVolume() {
		return currentVolume;
	}

	public void setCurrentVolume(int currentVolume) {
		this.currentVolume = currentVolume;
	}

	@Override
	public void surfing(String url) {
		System.out.println(url + "을 화면에 렌더링(번역해서 출력)합니다.");
	}

	@Override
	public void turnOn() {
		System.out.println("TV 전원을 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV 전원을 끕니다.");
	}

	@Override
	public void volumeUp() {
		if (!(currentVolume >= MAX_VOLUME)) {
			currentVolume++;
		}
	}

	@Override
	public void volumeDown() {
		currentVolume--;
	}

	@Override
	public void setVolume(int volume) {
		currentVolume = volume;
	}

	@Override
	public void setChannel(int channel) {
		currentChannel = channel;
	}
	
	public static void main(String[] args) {
		RemoteControl tv = new SamsungTV();
		tv.turnOn();
		tv.setChannel(15);
		
		System.out.println(((SamsungTV)tv).getCurrentChannel());
		
		tv.volumeUp();
		tv.volumeUp();
		tv.volumeUp();
		
		System.out.println(((SamsungTV)tv).getCurrentVolume());
		System.out.println(RemoteControl.MAX_CHANNEL);
		
		tv.turnOff();
		
		
	}

}
