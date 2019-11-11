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
	 * ��ü���ڵ� �˻��ϱ�
	 */
	public static List<SubwayListDTO> subwaySelectAll() {
//���� ȣ��
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
			if (list != null &&  list.size()==1) { //list �� ���� �ƴϰ� dto�� 1���� 
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
	 * �����ϱ�
	 */
	public static void subwayListInsert(SubwayListDTO subwayListDTO) {
		try {
			service.subwayInsert(subwayListDTO);
			SuccessView.successMessage(subwayListDTO.getStation() + " �� ����� �Ϸ�Ǿ����ϴ�.");
		} catch (Exception e) {
			FailView.errorMessage("�̹� �����ϴ� ���̸��� �ֽ��ϴ�.");
		}
	}

	/**
	 * ���� �����ϱ�
	 */
	public static void subwayListUpdate(SubwayListDTO subwayListDTO) {
		try {
			service.subwayUpdate(subwayListDTO);
			SuccessView.successMessage("������ �����Ǿ����ϴ�.");
		} catch (Exception e) {
//e.printStackTrace();
			FailView.errorMessage("�˻��� ���̸��� ���� ������ �����߽��ϴ�.");
		}
	}

	public static void SubwayListDelete(String station) {
		try {
			service.subwayDelete(station);
			SuccessView.successMessage("������ �����߽��ϴ�.");
		} catch (Exception e) {
//e.printStackTrace();
			FailView.errorMessage("�Էµ� ���̸��� �߸��Ǿ� ������ �����߽��ϴ�.");
		}
	}

	
	public static void subwayCongestionRank(String sortType, int rankNum){
		List<SubwayListDTO> list = null;
		try {
			list = service.subwayCongestionRank(sortType, rankNum);
			if(sortType.equals("��ս����ο�")) {
				SuccessView.selectPrintRank(list);
			}
			else if(sortType.equals("��������ο�")) {
				SuccessView.selectPrintRank2(list);
				
			}
			else if(sortType.equals("���ȯ���ο�")) {
				SuccessView.selectPrintRank3(list);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage("����");
		}
	}
}// End of class