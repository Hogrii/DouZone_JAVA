package Chapter06_Class;

public class CarExample {
	public static void main(String[] args) {
		// Car ��ü ����
		Car myCar = new Car();
		
		// Car ��ü�� �ʵ尪 �б� -> �⺻�� ���
		System.out.println("�𵨸� : " + myCar.model);	// null
		System.out.println("�õ����� : " + myCar.start);	// false
		System.out.println("����ӵ� : " + myCar.speed);	// 0
		System.out.println();
		
		// Car ��ü�� �ʵ尪 �б� -> �ʱⰪ ���
		System.out.println("����ȸ�� : " + myCar.company);		// �����ڵ���
		System.out.println("���� : " + myCar.color);			// ����
		System.out.println("�ְ�ӵ� : " + myCar.maxSpeed);	// 350
		System.out.println("����ӵ� : " + myCar.speed);		// 0
		System.out.println();
		
		// Car ��ü�� �ʵ尪 ����
		myCar.speed = 60;
		System.out.println("����ӵ� : " + myCar.speed);	// 0 -> 60
		System.out.println();
		
		/////////////////////////////////////////////////////////////
		
		// 1�� ������ ȣ��
		Car3 car1 = new Car3();
		System.out.println("car1.company : " + car1.company);
		System.out.println();
		
		// 2�� ������ ȣ��
		Car3 car2 = new Car3("�ڰ���");
		System.out.println("car2.company : " + car2.company);
		System.out.println("car2.model : " + car2.model);
		System.out.println();
		
		// 3�� ������ ȣ��
		Car3 car3 = new Car3("�ڰ���", "����");
		System.out.println("car3.company : " + car3.company);
		System.out.println("car3.model : " + car3.model);
		System.out.println("car3.color : " + car3.color);
		System.out.println();
		
		// 4�� ������ ȣ��
		Car3 car4 = new Car3("�ý�", "����", 200);
		System.out.println("car4.company : " + car4.company);
		System.out.println("car4.model : " + car4.model);
		System.out.println("car4.color : " + car4.color);
		System.out.println("car4.maxSpeed : " + car4.maxSpeed);
	}
}
