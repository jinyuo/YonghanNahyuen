package controller;

import java.sql.SQLException;
import java.util.List;

import dto.SubwayListDTO;
import service.SubwayListService;
import service.SubwayListServiceImpl;
import view.FailView;
import view.SuccessView;

public class SubwayListController {
	private static SubwayListService service = new SubwayListServiceImpl();

	/**
	 * 전체레코드 검색하기
	 */
	public static List<SubwayListDTO> subwaySelectAll() {
//서비스 호출
		List<SubwayListDTO> list = null;
		try {
			list = service.subwaySelectAll();
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		return list;
	}

	public static void subwaySelectByStation(String station) {

		try {
			List<SubwayListDTO> list = service.subwaySelectByStation(station);
			if (list != null) {
				SuccessView.selectPrint(list);
			}
		} catch (SQLException e) {
//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void subwayDeleteCheck(String station) {

		try {
			List<SubwayListDTO> list = service.subwaySelectByStation(station);
			if (list != null &&  list.size()==1) { //list 가 널이 아니고 dto가 1개면 
				SuccessView.deleteCheckPrint1(list);
			}
			else if (list.size()>1) {
				SuccessView.deleteCheckPrint2(list);
			}
		} catch (SQLException e) {
//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 가입하기
	 */
	public static void subwayListInsert(SubwayListDTO subwayListDTO) {
		try {
			service.subwayInsert(subwayListDTO);
			SuccessView.successMessage(subwayListDTO.getStation() + " 역 등록이 완료되었습니다.");
		} catch (Exception e) {
			FailView.errorMessage("이미 존재하는 역이름이 있습니다.");
		}
	}

	/**
	 * 정보 수정하기
	 */
	public static void subwayListUpdate(SubwayListDTO subwayListDTO) {
		try {
			service.subwayUpdate(subwayListDTO);
			SuccessView.successMessage("정보가 수정되었습니다.");
		} catch (Exception e) {
//e.printStackTrace();
			FailView.errorMessage("검색된 역이름이 없어 수정에 실패했습니다.");
		}
	}

	public static void SubwayListDelete(String station) {
		try {
			service.subwayDelete(station);
			SuccessView.successMessage("삭제에 성공했습니다.");
		} catch (Exception e) {
//e.printStackTrace();
			FailView.errorMessage("입력된 역이름이 잘못되어 삭제에 실패했습니다.");
		}
	}

	
	public static void subwayCongestionRank(String sortType, int rankNum){
		List<SubwayListDTO> list = null;
		try {
			list = service.subwayCongestionRank(sortType, rankNum);
			if(sortType.equals("평균승차인원")) {
				SuccessView.selectPrintRank(list);
			}
			else if(sortType.equals("평균하차인원")) {
				SuccessView.selectPrintRank2(list);
				
			}
			else if(sortType.equals("평균환승인원")) {
				SuccessView.selectPrintRank3(list);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage("에러");
		}
	}
}// End of class