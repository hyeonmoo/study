package exercise0926;

public class Ex08_07_DaoEx {
	public static void dbWork(DataAccessObject dao) {
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
	}
	public static void main(String[] args) {
		dbWork(new OracleDao());
		dbWork(new MySqlDao());
	}
}
interface DataAccessObject{
	public void select();
	public void insert();
	public void update();
	public void delete();
}
class OracleDao implements DataAccessObject{
	private String oracle="Oracle DB";
	@Override public void select() {System.out.println(oracle+"에서 검색");}
	@Override public void insert() {System.out.println(oracle+"에 삽입");}
	@Override public void update() {System.out.println(oracle+"를 수정");}
	@Override public void delete() {System.out.println(oracle+"에서 삭제");}
}
class MySqlDao implements DataAccessObject{
	private String sql="MySQL DB";
	@Override public void select() {System.out.println(sql+"에서 검색");}
	@Override public void insert() {System.out.println(sql+"에 삽입");}
	@Override public void update() {System.out.println(sql+"를 수정");}
	@Override public void delete() {System.out.println(sql+"에서 삭제");}
}