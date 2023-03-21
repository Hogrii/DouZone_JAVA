package kr.or.kosa.common;

// 사용자의 데이터를 담는 클래스
// VO, DTO, DOMAIN(업무, 지식)
// 사원 한 명의 데이터를 담을 수 있는 클래스
// 사원 한 명 생성 : Emp emp = new Emp(사번, 이름, 직종, 급여);
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int sal;
	
	// 생성자(Overloading Constructor)
	public Emp(int empno, String ename, String job, int sal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
	}
	
	// Alt + Shift + S
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename + "님"; // return시 이름 뒤에 ~"님"이 붙어서 호출된다.
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}

	// 입력한 값이 맞는지 판단
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", sal=" + sal + "]";
	}
	
}
