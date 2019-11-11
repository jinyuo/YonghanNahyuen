package view;

import java.util.List;

import dto.SubwayListDTO;

public class SuccessView {
	public static void successMessage(String message){
		System.out.println(message);
	   }

	public static void selectPrint(List<SubwayListDTO> list) {
		for(SubwayListDTO dto : list) System.out.println(dto);
		
	}
	
	public static void selectPrintRank(List<SubwayListDTO> list) {
		for(SubwayListDTO dto : list) {
			System.out.print("���� = "+dto.getRank()+", ");
			System.out.print("���� = "+dto.getStation()+",  ");
			System.out.println("��� ���� �ο� = " +dto.getGetInNo());
		}
		
	}
	public static void selectPrintRank2(List<SubwayListDTO> list) {
		for(SubwayListDTO dto : list) {
			System.out.print("���� = "+dto.getRank()+", ");
			System.out.print("���� = "+dto.getStation()+",  ");
			System.out.println("��� ���� �ο� = " +dto.getGetOffNo());
		}
		
	}
	public static void selectPrintRank3(List<SubwayListDTO> list) {
		for(SubwayListDTO dto : list) {
			System.out.print("���� = "+dto.getRank()+", ");
			System.out.print("���� = "+dto.getStation()+",  ");
			System.out.println("��� ȯ�� �ο� = " +dto.getTransferNo());
		}
		
	}

	public static void deleteCheckPrint2(List<SubwayListDTO> list) {
		System.out.println("�Է��� ���� ������ �����Ͱ� 2�� �̻��Դϴ�.");
		for(SubwayListDTO dto : list) {
			System.out.print("����  =  "+dto.getStation()+"\n");
		}
		System.out.println("�˻��� ������ �� �����Ͻ� ����ö���� �ٽ��ѹ� ��Ȯ�� �Է����ּ��� :");
	}
	public static void deleteCheckPrint1(List<SubwayListDTO> list) {
		
		//for(SubwayListDTO dto : list) {
			System.out.println("�����Ͻ� ���̸��� �ٽ��ѹ� �Է��ϼ���");
		
		
	}
	
	
	
	
}
			