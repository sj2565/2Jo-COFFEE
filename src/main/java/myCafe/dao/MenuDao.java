package myCafe.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myCafe.common.SuperDao;
import myCafe.model.Cafe;

public class MenuDao extends SuperDao {

	public int DeleteData(int cid) {
		String sql = " delete from menu where cid = ? ";
		PreparedStatement pstmt = null;
		int cnt = -9999;
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

	public MenuDao() {
		super();
	}

	public Cafe GetDataById(int cid) {
		String sql = " select * from menu ";
		sql += " where cid = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Cafe bean = null;

		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new Cafe();

				bean.setCid(rs.getInt("cid"));
				bean.setCname(rs.getString("cname"));
				bean.setImage(rs.getString("image"));
				bean.setPrice(rs.getInt("price"));
				bean.setKcal(rs.getInt("kcal"));
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

	public int InsertData(Cafe bean) {
		// 게시물 테이블에 1건을 추가합니다.
		String sql = " insert into menu(cid, cname, image, price, kcal)";

		sql += " values(seqmenu.nextval, ?, ?, ?, ?) ";

		int cnt = -99999;

		PreparedStatement pstmt = null;

		try {
			if (conn == null) {
				conn = super.getConnection();
			}
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bean.getCname());
			pstmt.setString(2, bean.getImage());
			pstmt.setInt(3, bean.getPrice());
			pstmt.setInt(4, bean.getKcal());

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

	public List<Cafe> SelectDataList() {
		String sql = " select * from menu ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Cafe> lists = new ArrayList<Cafe>();
		try {
			if (conn == null) {
				conn = super.getConnection();
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Cafe bean = new Cafe();

				bean.setCid(rs.getInt("cid"));
				bean.setCname(rs.getString("cname"));
				bean.setImage(rs.getString("image"));
				bean.setPrice(rs.getInt("price"));
				bean.setKcal(rs.getInt("kcal"));
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
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lists;
	}

	public int UpdateData(Cafe bean) {
		// 해당 bean 객체를 사용하여 게시물을 수정합니다.
		String sql = " update menu set ";
		sql += " cname = ?, image = ?, price = ?, kcal = ? ";
		sql += " where cid = ? ";
		PreparedStatement pstmt = null;
		int cnt = -9999;
		try {
			conn = super.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bean.getCname());
			pstmt.setString(2, bean.getImage());
			pstmt.setInt(3, bean.getPrice());
			pstmt.setInt(4, bean.getKcal());
			pstmt.setInt(5, bean.getCid());

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
}
