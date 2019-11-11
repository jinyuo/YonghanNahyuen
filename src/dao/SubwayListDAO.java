package dao;

import java.sql.SQLException;
import java.util.List;

import dto.SubwayListDTO;

public interface SubwayListDAO {
	/**
	 * ���ڵ� ��ü�˻�
	 */
	List<SubwayListDTO> subwaySelectAll() throws SQLException;
	
	/**
	 * ���� Ư�� ���ڿ��� ���Ե� ���ڵ� �˻�
	 * select * from subwayview where station like ?
	 */
	List<SubwayListDTO> subwaySelectByStation(String station) throws SQLException;
	
	/**
	 * �Խù� ����ϱ�
	 * insert into subwayview ( station,  getInNo,  getOffNo,  transferNo) 
	 * values (?, ?, ?, ?)
	 */
	int subwayInsert(SubwayListDTO subwayDTO) throws SQLException;
	
	/**
	 * ���� �ش��ϴ� �Խù� ���� �����ϱ�
	 * update subwayview set content = ? where station = ?
	 */
	int subwayUpdate(SubwayListDTO subwayDTO) throws SQLException;
	
	/**
	 * �۹�ȣ�� �ش��ϴ� ���ڵ� ����
	 * select * from subwayview where station =?
	 * delete from subwayview where station = ?
	 */
	int subwayDelete(String station) throws SQLException;
	
	/**
	 *  ����, ����, ȯ�� �ο��� 
	 *  ���� ����  ���⵵ �˻�
	 */
	List<SubwayListDTO> subwayCongestionRank(String sortType, int rankNum) throws SQLException;
	
	
}