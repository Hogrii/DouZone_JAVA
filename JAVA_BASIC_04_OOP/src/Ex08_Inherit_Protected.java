import kr.or.kosa.Pclass;

/*
  private
  default >> 같은 폴더
  public
  상속 관게에서 protected
  
  protected 양면성 >> default, public
   >> 만약 상속이 없는 클래스 안에서 protected를 썼다면 default와 똑같다
   >> 결국 상속 관계에서만 의미를 갖는다 >> 상속 관게에서 public
 */

class Dclass {
	public int i;
	private int p;
	int s; // default
	protected int k; // default와 동일 >> 그래서 일반적으로는 사용하지 않는다
}

class Child2 extends Pclass{
	void method() {
		this.k = 100; // 상속 관계에서 자식은 부모의 protected 자원을 사용 가능하다
		// protected 설계자 목적 >> 재정의를 했으면 좋겠다
		System.out.println(this.k);
		// m(); 자식 안에서 접근이 가능하다
	}
	// protected 진정한 의미(함수) : 재정의를 해!

	@Override
	protected void m() {
		super.m();
	}
}

public class Ex08_Inherit_Protected {
	public static void main(String[] args) {
		Pclass pclass = new Pclass();
//		pclass.i public만 접근이 가능
		
		Child2 child = new Child2();
	}
}
