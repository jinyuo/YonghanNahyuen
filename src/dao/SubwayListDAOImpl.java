package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.SubwayListDTO;
import util.DBUtill;

public class SubwayListDAOImpl implements SubwayListDAO {
	//private Properties proFile = DBUtill.getProFile();
	@Override
	public List<SubwayListDTO> subwaySelectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<SubwayListDTO> list = new ArrayList<SubwayListDTO>();
		String sql = "select ����, ��ս����ο�, ��������ο�, ���ȯ���ο� from subway";
		try {
			con = DBUtill.getConnection();
			ps =con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				SubwayListDTO dto = new SubwayListDTO(rs.getString(1) ,
						  rs.getInt(2),rs.getInt(3),
						  rs.getInt(4));
				
				list.add(dto);
			}
			
		}finally {
			DBUtill.dbClose(con, ps, rs);
			System.out.println(list);
		}
		return list;
	}
	


	@Override
	public List<SubwayListDTO> subwaySelectByStation(String station) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<SubwayListDTO> list = new ArrayList<SubwayListDTO>();
		String sql = "select ����, ��ս����ο�, ��������ο�, ���ȯ���ο� from subway where ���� like ?";
		try {
			
			con = DBUtill.getConnection();
			ps =con.prepareStatement(sql);
			ps.setString(1, station+"%");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				SubwayListDTO dto = new SubwayListDTO(rs.getString(1) ,
						  rs.getInt(2),rs.getInt(3),
						  rs.getInt(4));
				
				list.add(dto);
			}
			
		}finally {
			DBUtill.dbClose(con, ps, rs);
			
		}
		return list;
	}

	@Override
	public int subwayInsert(SubwayListDTO subwayDTO) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		int result =0;
		String sql = "insert into subway(����,��ս����ο�,��������ο�,���ȯ���ο�) values(?,?,?,?)";
		try {
			
			con = DBUtill.getConnection();
			ps =con.prepareStatement(sql);
			ps.setString(1, subwayDTO.getStation());
			ps.setInt(2, subwayDTO.getGetInNo());
			ps.setInt(3, subwayDTO.getGetOffNo());
			ps.setInt(4, subwayDTO.getTransferNo());
			result = ps.executeUpdate();
			
			
		}finally {
			DBUtill.dbClose(con, ps);
			
		}
		return result;
	}

	@Override
	public int subwayUpdate(SubwayListDTO subwayDTO) throws SQLException {
		//update subway set ��ս����ο� = ?, ��������ο� = ?, ���ȯ���ο� = ? where ���� =?;
		Connection con = null;
		PreparedStatement ps = null;
		int result =0;
		String sql = "update subway set ��ս����ο� = ?, ��������ο� = ?, ���ȯ���ο� = ? where ���� =?";
		try {
			
			con = DBUtill.getConnection();
			ps =con.prepareStatement(sql);
			ps.setInt(1, subwayDTO.getGetInNo()); 
			ps.setInt(2, subwayDTO.getGetOffNo());
			ps.setInt(3, subwayDTO.getTransferNo());
			ps.setString(4, subwayDTO.getStation());
			result = ps.executeUpdate();
		}finally {
			DBUtill.dbClose(con, ps);
			
		}

		return result;
	}

	@Override
	public int subwayDelete(String station) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result =0;
		String sql = "delete from subway where ����=?";
		try {
			con = DBUtill.getConnection();
			ps =con.prepareStatement(sql);
			ps.setString(1, station);
			result = ps.executeUpdate();
		}finally {
			DBUtill.dbClose(con, ps);
		}
		return result;
	}


	@Override
	public List<SubwayListDTO> subwayCongestionRank(String sortType, int rankNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<SubwayListDTO> list = new ArrayList<SubwayListDTO>();
		
		String sql = "select ����, ��ս����ο�, ��������ο�, ���ȯ���ο�, rownum "
				+ "from (select * from subway order by "+sortType+ " desc) where rownum between 1 and ?";

		
		try {
			con = DBUtill.getConnection();
			ps =con.prepareStatement(sql);
			ps.setInt(1, rankNum);
			rs = ps.executeQuery();
			while(rs.next()) {
				SubwayListDTO dto = new SubwayListDTO(rs.getString("����"),
						rs.getInt("��ս����ο�"),rs.getInt("��������ο�"),
						  rs.getInt("���ȯ���ο�"),rs.getInt("rownum"));
				list.add(dto);
			}
		}finally {
			DBUtill.dbClose(con, ps, rs);
		}
		return list; 
	}
	
}
