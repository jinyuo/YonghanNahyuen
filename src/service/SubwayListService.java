package service;

import java.sql.SQLException;
import java.util.List;
import dto.SubwayListDTO;

public interface SubwayListService {
	/**
	 * ��ü���ڵ� �˻��ϱ�
	 * */
	List<SubwayListDTO> subwaySelectAll()throws SQLException;
	
	/**
	 *   @return : true�̸� �ߺ�, false�̸� �ߺ��ƴ�.
	 *   
	 * */
	List<SubwayListDTO> subwaySelectByStation(String station) throws SQLException;
	
	/**
	 * �����ϱ�
	 * */
	int subwayInsert(SubwayListDTO subwayDTO)throws SQLException;
	
	/**
	 * �����ϱ�
	 * (ID�� �ش��ϴ� �̸�,����, �ּ� ����) 
	 * */
	int subwayUpdate(SubwayListDTO subwayDTO)throws SQLException;
	
	/**
	 * �����ϱ�
	 * (ID�� �ش��ϴ� ���ڵ� ����)
	 * */
	int subwayDelete(String station) throws SQLException;
	
	
	List<SubwayListDTO> subwayCongestionRank(String sortType, int rankNum) throws SQLException;
}
