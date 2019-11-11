package service;

import java.sql.SQLException;
import java.util.List;
import dto.SubwayListDTO;

public interface SubwayListService {
	/**
	 * 전체레코드 검색하기
	 * */
	List<SubwayListDTO> subwaySelectAll()throws SQLException;
	
	/**
	 *   @return : true이면 중복, false이면 중복아님.
	 *   
	 * */
	List<SubwayListDTO> subwaySelectByStation(String station) throws SQLException;
	
	/**
	 * 가입하기
	 * */
	int subwayInsert(SubwayListDTO subwayDTO)throws SQLException;
	
	/**
	 * 수정하기
	 * (ID에 해당하는 이름,나이, 주소 수정) 
	 * */
	int subwayUpdate(SubwayListDTO subwayDTO)throws SQLException;
	
	/**
	 * 삭제하기
	 * (ID에 해당하는 레코드 삭제)
	 * */
	int subwayDelete(String station) throws SQLException;
	
	
	List<SubwayListDTO> subwayCongestionRank(String sortType, int rankNum) throws SQLException;
}
