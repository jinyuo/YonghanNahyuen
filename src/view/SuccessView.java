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
			System.out.print("순위 = "+dto.getRank()+", ");
			System.out.print("역명 = "+dto.getStation()+",  ");
			System.out.println("평균 승차 인원 = " +dto.getGetInNo());
		}
		
	}
	public static void selectPrintRank2(List<SubwayListDTO> list) {
		for(SubwayListDTO dto : list) {
			System.out.print("순위 = "+dto.getRank()+", ");
			System.out.print("역명 = "+dto.getStation()+",  ");
			System.out.println("평균 하차 인원 = " +dto.getGetOffNo());
		}
		
	}
	public static void selectPrintRank3(List<SubwayListDTO> list) {
		for(SubwayListDTO dto : list) {
			System.out.print("순위 = "+dto.getRank()+", ");
			System.out.print("역명 = "+dto.getStation()+",  ");
			System.out.println("평균 환승 인원 = " +dto.getTransferNo());
		}
		
	}

	public static void deleteCheckPrint2(List<SubwayListDTO> list) {
		System.out.println("입력한 역을 포함한 데이터가 2개 이상입니다.");
		for(SubwayListDTO dto : list) {
			System.out.print("역명  =  "+dto.getStation()+"\n");
		}
		System.out.println("검색된 데이터 중 삭제하실 지하철명을 다시한번 정확히 입력해주세요 :");
	}
	public static void deleteCheckPrint1(List<SubwayListDTO> list) {
		
		//for(SubwayListDTO dto : list) {
			System.out.println("삭제하실 역이름을 다시한번 입력하세요");
		
		
	}
	
	
	
	
}
			