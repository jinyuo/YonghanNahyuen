package dao;

import java.sql.SQLException;
import java.util.List;

import dto.SubwayListDTO;

public interface SubwayListDAO {
	/**
	 * 레코드 전체검색
	 */
	List<SubwayListDTO> subwaySelectAll() throws SQLException;
	
	/**
	 * 제목에 특정 문자열이 포함된 레코드 검색
	 * select * from subwayview where station like ?
	 */
	List<SubwayListDTO> subwaySelectByStation(String station) throws SQLException;
	
	/**
	 * 게시물 등록하기
	 * insert into subwayview ( station,  getInNo,  getOffNo,  transferNo) 
	 * values (?, ?, ?, ?)
	 */
	int subwayInsert(SubwayListDTO subwayDTO) throws SQLException;
	
	/**
	 * 역명에 해당하는 게시물 내용 수정하기
	 * update subwayview set content = ? where station = ?
	 */
	int subwayUpdate(SubwayListDTO subwayDTO) throws SQLException;
	
	/**
	 * 글번호에 해당하는 레코드 삭제
	 * select * from subwayview where station =?
	 * delete from subwayview where station = ?
	 */
	int subwayDelete(String station) throws SQLException;
	
	/**
	 *  승차, 하차, 환승 인원별 
	 *  몇위 까지  복잡도 검색
	 */
	List<SubwayListDTO> subwayCongestionRank(String sortType, int rankNum) throws SQLException;
	
	
}