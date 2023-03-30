// 두개의 설계도

class Tv {
	boolean power;
	int ch;
	
	void power() { // 두개의 기능을 하나의 함수로 처리
		// boolean
		// toggling 
		this.power = !this.power; // 전원 스위치
	}
	
	void chUp() {
		this.ch++;
	}
	
	void chDown() {
		this.ch--;
	}
}

class Vcr { // 비디오 플레이어
	boolean power;
	
	void  power() {
		this.power = !this.power;
	}
	
	void play() {
		System.out.println("재생하기");
	}
	
	void stop() {
		System.out.println("정지하기");
	}
	
	void rew() {}
	
	void ff() {}
}

// 설계도 2개
/*
class Tv
class Vcr

제품
Tv와 Vcr이 합쳐진 제품(TvVcr)을 만들고 싶다

class TvVcr extends Tv, Vcr (x) >> 다중 상속이 안된다
 >> 굳이 다중 상속을 하고 싶으면 계층적 상속을 해주면 된다
 >> 계층적 상속의 문제점
   >> 할아버지, 아버지 계층구조 파악이 힘들다
   >> 자원의 이름이 같으면 충돌된다
1. class TvVcr extends Tv { Vcr vcr; }
2. class TvVcr { Tv tv; Vcr vcr; }

하나는 상속, 하나는 포함
둘다 포함

TvVcr 메인 기능 >> 기능의 가중치를 따져서 상속을 먼저 생각한다
 */

class TvVcr {
	Tv tv;
	Vcr vcr;
	
	TvVcr() {
		this.tv = new Tv(); // 초기화(주소값 할당)
		this.vcr = new Vcr();
	}
}

// 일반적으로는 여러 개가 있으면 하나는 상속한다
class TvVcr2 extends Tv {
	Vcr vcr;
	
	TvVcr2() {
		this.vcr = new Vcr();
	}
}

public class Ex03_Inherit {
	public static void main(String[] args) {
		TvVcr my = new TvVcr();
		my.tv.power();
		my.vcr.power();
		System.out.println(my.tv.power);
		System.out.println(my.vcr.power);
		//------------------------------------------
		
		TvVcr2 tv2 = new TvVcr2();
		tv2.power();
		System.out.println("TV 전원 : " + tv2.power);
		tv2.vcr.power();
		System.out.println("VCR 전원 : " + tv2.vcr.power);
	}
}
