package myCafe.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myCafe.common.SuperDao;
import myCafe.model.Cafe;
import myCafe.model.CafeMiniBean;

public class OrderDao extends SuperDao {

	public int InsertOrder(Cafe bean) {
		String sql = " insert into orders(oid, id, cid) ";
		sql += " values(seqorder.nextval, ?, ?) ";
		int cnt = -99999;

		PreparedStatement pstmt = null;

		try {
			if (conn == null) {
				conn = super.getConnection();
			}
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bean.getId());
			pstmt.setInt(2, bean.getCid());

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
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return cnt;
	}

	public List<CafeMiniBean> SelectDataList(String id) {
		// 회원 목록을 컬렉션에 담아서 반환
		String sql = " SELECT MENU.CID as cid, MENU.CNAME as name, count(*) as cnt, SUM(MENU.PRICE) as amount FROM MENU ";
		sql += " INNER JOIN ORDERS ON MENU.CID = ORDERS.CID ";
		sql += " INNER JOIN CUSTOMERS ON ORDERS.ID = CUSTOMERS.ID ";
		sql += " WHERE CUSTOMERS.ID = ? ";
		sql += " GROUP BY MENU.CID, MENU.CNAME ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<CafeMiniBean> lists = new ArrayList<CafeMiniBean>();
		System.out.println("DB 연결 됨");

		try {
			if (conn == null) {
				conn = this.getConnection();
			}

			// pstmt 객체는 문장을 처리해주는 객체입니다.
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CafeMiniBean bean = new CafeMiniBean();

				bean.setCid(rs.getInt("cid"));
				bean.setName(rs.getString("name"));
				bean.setCnt(rs.getInt("cnt"));
				bean.setAmount(rs.getInt("amount"));

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

	public int DeleteData(int cid) {
		String sql = " delete from orders where CID = ? ";
		PreparedStatement pstmt = null;
		int cnt = -99999;

		try {
			conn = super.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
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

	public int DeleteDataAll(String id) {
		String sql = " delete from orders where ID = ? ";
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

	public int UpdateData(String id, int total, int balance) {
		String sql = " update CUSTOMERS SET ";
		sql += " balance = ? - ? ";
		sql += " where id = ? ";

		PreparedStatement pstmt = null;
		int cnt = -99999;

		try {
			conn = super.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, balance);
			pstmt.setInt(2, total);
			pstmt.setString(3, id);

			cnt = pstmt.executeUpdate();

			conn.commit();
			System.out.println(balance);
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

	public Cafe GetDataById(String id, int total, int balance) {
		String sql = " select balance from CUSTOMERS where id= ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Cafe bean = null;
		OrderDao dao = new OrderDao();

		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new Cafe();

				dao.UpdateData(id, total, balance);

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
				this.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean;
	}
}
