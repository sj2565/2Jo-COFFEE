package myCafe.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myCafe.common.SuperDao;
import myCafe.model.Cafe;

public class CafeDao extends SuperDao {

	public Cafe GetCustomerInfo(String id, String password) {
		// TODO Auto-generated method stub
		String sql = " select * from customers ";
		sql += " where id = ? and password = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Cafe bean = null;

		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			if (rs.next()) { // 회원 존재
				bean = new Cafe();

				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setHphone(rs.getString("hphone"));
				bean.setBalance(rs.getInt("balance"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
					super.closeConnection();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean;
	}

	public int InsertData(Cafe bean) {
		// 데이터 베이스에 데이터를 추가합니다.
		// 문장 객체 생성
		String sql = " insert into customers(id, name, password, hphone, balance) ";
		sql += " values(?, ?, ?, ?, ?)";

		int cnt = -99999;

		PreparedStatement pstmt = null;

		try {
			if (conn == null) {
				conn = this.getConnection();
			}
			conn.setAutoCommit(false);

			// pstmt 객체는 문장을 처리해주는 객체입니다.
			pstmt = this.conn.prepareStatement(sql);

			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getPassword());
			pstmt.setString(4, bean.getHphone());
			pstmt.setInt(5, bean.getBalance());

			cnt = pstmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				this.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		// 데이터 처리
		// 접속 종료
		return cnt;
	}

	public List<Cafe> SelectDataList() {
		// 회원 목록을 컬렉션에 담아서 반환
		String sql = "select * from customers";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Cafe> lists = new ArrayList<Cafe>();

		try {
			if (conn == null) {
				conn = this.getConnection();
			}

			// pstmt 객체는 문장을 처리해주는 객체입니다.
			pstmt = this.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Cafe bean = new Cafe();

				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setHphone(rs.getString("hphone"));
				bean.setBalance(rs.getInt("balance"));
				lists.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				this.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lists;
	}

	public Cafe GetDataById(String id) {
		String sql = " select * from customers ";
		sql += " where id = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Cafe bean = null;

		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new Cafe();

				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setHphone(rs.getString("hphone"));
				bean.setBalance(rs.getInt("balance"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return bean;
	}

	public int UpdateData(Cafe bean) {
		String sql = " update customers set ";
		sql += " name = ?, password = ?, hphone = ?, balance = ? ";
		sql += " where id = ? ";

		PreparedStatement pstmt = null;
		int cnt = -99999;

		try {
			if (conn == null) {
				conn = this.getConnection();
			}
			conn.setAutoCommit(false);

			pstmt = this.conn.prepareStatement(sql);

			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getPassword());
			pstmt.setString(3, bean.getHphone());
			pstmt.setInt(4, bean.getBalance());
			pstmt.setString(5, bean.getId());

			cnt = pstmt.executeUpdate();

			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return cnt;
	}

	public int DeleteData(String id) {
		String sql = " delete from customers where id = ? ";
		PreparedStatement pstmt = null;
		int cnt = -99999;

		try {
			conn = super.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			cnt = pstmt.executeUpdate();

			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt;
	}
}
