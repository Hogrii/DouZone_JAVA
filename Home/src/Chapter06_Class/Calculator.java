package Chapter06_Class;

public class Calculator {
	// ���ϰ��� ���� �޼ҵ�
	void powerOn() {
		System.out.println("������ �մϴ�");
	}
	
	// ���ϰ��� ���� �޼ҵ�
	void powerOf() {
		System.out.println("������ ���ϴ�");
	}
	
	// ȣ�� �� �� ���� ���� ���޹ް�
	// ȣ���� ������ ����� int�� �����ϴ� �޼ҵ�
	int plus(int x, int y) {
		int result = x + y;
		return result;
	}
	
	// ȣ�� �� �� ���� ���� ���޹ް�
	// ȣ���� ������ �����  double�� �����ϴ� �޼ҵ�
	double divide(int x, int y) {
		double result = (double)x / (double)y;
		return result;
	}
}
