/**
 * 무기에 대한 수평적 규격 역할의 인터페이스
 * 
 * @author 최재민
 *
 */
public interface Weapon {
	public static final int WEIGHT = 10;

	public abstract void attack(); 
	// java compile 시 자동으로 추가되는 것:
	// default 생성자, super, 인터페이스 접근제한자 public, 인터페이스 메소드 public abstract, 인터페이스 상수 public static final
	
}
