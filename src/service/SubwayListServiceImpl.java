package service;

import java.sql.SQLException;
import java.util.List;

import dao.SubwayListDAO;
import dao.SubwayListDAOImpl;
import dto.SubwayListDTO;

public class SubwayListServiceImpl implements SubwayListService {
	SubwayListDAO dao = new SubwayListDAOImpl();
	@Override
	public List<SubwayListDTO> subwaySelectAll() throws SQLException {
		List<SubwayListDTO> list = dao.subwaySelectAll();
		if(list==null||list.isEmpty()) {
			throw new SQLException("�˻��� ���ڵ尡 �����ϴ�.");
		}
		return list;
	}

	@Override
	public List<SubwayListDTO> subwaySelectByStation(String station) throws SQLException {
		// TODO Auto-generated method stub
		List<SubwayListDTO> list = dao.subwaySelectByStation(station);
		
		if(list.isEmpty()) {
			throw new SQLException("�˻��� ���ڵ尡 �����ϴ�.");
		}
		return list;
	}

	@Override
	public int subwayInsert(SubwayListDTO subwayDTO) throws SQLException {
		int result = dao.subwayInsert(subwayDTO);
		if(result==0) throw new SQLException("��Ͽ� �����߽��ϴ�.");
		
		return result;
		
		
	}

	@Override
	public int subwayUpdate(SubwayListDTO subwayDTO) throws SQLException {
		int result = dao.subwayUpdate(subwayDTO);
		if(result==0) throw new SQLException("������ �����߽��ϴ�.");
		
		return result;
		
	}

	@Override
	public int subwayDelete(String station) throws SQLException {
		int result = dao.subwayDelete(station);
		if(result==0) throw new SQLException("������ �����߽��ϴ�.");
		return result;
	}

	@Override
	public List<SubwayListDTO> subwayCongestionRank(String sortType, int rankNum) throws SQLException {
		List<SubwayListDTO> list = dao.subwayCongestionRank(sortType, rankNum);
		if(list.isEmpty()) {
			throw new SQLException("�˻��� ���ڵ尡 �����ϴ�.");
		}
		return list;
	}

	
}
