package view;



import java.util.Scanner;

import controller.SubwayListController;
import dto.SubwayListDTO;


public class MenuView {
   static Scanner sc =new Scanner(System.in);
 
   /**
    * 메뉴
    * */
    public static void menuChoice() {
         while(true) {
        	 System.out.println("\n---------------------------------------------------------------------------------------------------------------------");
        	 System.out.print("[ 1. 전체검색 ");
        	 System.out.print("| 2. 역이름을 통한 검색 ");
        	 System.out.print("| 3. 역정보 등록 ");
        	 System.out.print("| 4. 역정보 수정 ");
        	 System.out.print("| 5. 역정보 삭제 ");
        	 System.out.print("| 6. 역 혼잡도 순위 검색 ");

         	System.out.print("| 7. 종료 ]");
         	System.out.println("\n---------------------------------------------------------------------------------------------------------------------");

             
              System.out.println("선택메뉴는?");
              
              try {
	              int menu = Integer.parseInt(sc.nextLine());//
	              switch (menu) {
				  case 1:
					  SubwayListController.subwaySelectAll();	
					break;
	               case 2:
	            	   inputSubwayBystation();
					break;
	               case 3:
	            	   inputInsertSubway();
	 				break;
	               case 4:
	            	   inputUpdateSubway();

	 				break;
	               case 5:
	            	   inputDeleteBoard();
	            	   
	    
	    				break;
	               case 6:
	            	   inputSubwayCongestion();
	    				break;
	               case 7:
	            	  System.out.println("종료되었습니다.");
	    			 System.exit(0);	
	    			break;
				default:
					System.out.println("잘못되었습니다. 다시 입력해주세요.");
				}
	        	 
              }catch (NumberFormatException e) {
				System.out.println("메뉴는 숫자만 가능합니다.");
			}
         }//while문
    	
    }
    
    private static void inputDeleteCheck() {
      	 try {
	    	 System.out.println("삭제할 역 이름?");
	    	 String station = sc.next();
	    	 sc.nextLine();
	    	
	    	 SubwayListController.subwayDeleteCheck(station);
   	  }catch (NumberFormatException e) {
			System.out.println("올바른 역이름을 입력해주세요.");
			System.out.println("다시 할래요?  yes or no");
			String choice = sc.nextLine();
			if(choice.equals("yes")) {
				inputDeleteCheck();
			}
		 }
	
}

	private static void inputSubwayCongestion() {
	try {
		String sortType =null;
		System.out.println("어떤 순위를 알고 싶으신가요? 승차인원순위는 1, 하차인원순위는 2, 환승인원순위는 3");
		int menuNum = Integer.parseInt(sc.nextLine());
		if(menuNum == 1)sortType="평균승차인원";
		else if(menuNum==2)sortType = "평균하차인원";
		else if(menuNum==3)sortType = "평균환승인원";
		else {
			System.out.println("정해진 숫자만 입력해주세요.");
			inputSubwayCongestion();
		}
		System.out.println("몇위까지 알고싶나요?");

		int rankNum = Integer.parseInt(sc.nextLine());
		SubwayListController.subwayCongestionRank(sortType, rankNum);
		
	}catch(NumberFormatException e) {
		System.out.println("순위는 숫자만 입력해주세요.");
		System.out.println("다시 할래요?  yes or no");
		String choice = sc.nextLine();
		if(choice.equals("yes")) {
			inputSubwayCongestion();
		}
	}
	
}

	public static void inputSubwayBystation() {
   	 try {
	    	 System.out.println("역이름?");
	    	 String station = sc.nextLine();
	    	 SubwayListController.subwaySelectByStation(station);
   	  }catch (NumberFormatException e) {
			System.out.println("올바른 역이름을 입력해주세요.");
			System.out.println("다시 할래요?  yes or no");
			String choice = sc.nextLine();
			if(choice.equals("yes")) {
				inputSubwayBystation();
			}
		 }//catch블럭End
    }//메소드 end
    
    
	private static void inputInsertSubway() {
		try {
			System.out.println("역이름?");
			String station = sc.nextLine();
			System.out.println("평균승차인원 ?");
			int getInNo = Integer.parseInt(sc.nextLine());
			System.out.println("평균하차인원 ?");
			int getOffNo = Integer.parseInt(sc.nextLine());
			System.out.println("평균환승인원 ?");
			int transferNo = Integer.parseInt(sc.nextLine());

			SubwayListDTO dto = new SubwayListDTO(station, getInNo, getOffNo, transferNo);

			SubwayListController.subwayListInsert(dto);
		} catch (NumberFormatException e) {
			System.out.println("인원은 숫자만 입력해주세요.");
			System.out.println("다시 할래요?  yes or no");
			String choice = sc.nextLine();
			if (choice.equals("yes")) {
				inputInsertSubway();
			}
		}
	}

	 //역명 별 수정
    private static void inputUpdateSubway() {
    	
    try {
    System.out.println("수정 할 역 이름은?");
    String station = sc.nextLine();
   	 
   	 System.out.println("수정할 역 평균승차인원은?");
   	int getInNo = Integer.parseInt(sc.nextLine());
   	 
   	System.out.println("수정할 역 평균하차인원은?");
   	int getOffNo = Integer.parseInt(sc.nextLine());
  	System.out.println("수정할 역 평균환승인원은?");
  	 int transferNo = Integer.parseInt(sc.nextLine());
   	
   	 SubwayListDTO dto =  new SubwayListDTO(station, getInNo, getOffNo, transferNo);
   	 
   	 SubwayListController.subwayListUpdate(dto);
   	 
    }catch (Exception e) {
    	System.out.println("수정할 인원은 숫자만 입력해주세요.");
		System.out.println("다시 할래요?  yes or no");
		String choice = sc.next();
		sc.nextLine();
		if(choice.equals("yes")) {
			inputUpdateSubway();
		}
    
    }
}


    /**
     * 삭제
     * */
     public static void inputDeleteBoard() {
    	 try {
    	 inputDeleteCheck();
    	 
  //  	 System.out.print("삭제할 역 이름을 정확히 입력하세요 : ");
    	 
    	 String station = sc.nextLine();
    	 SubwayListController.SubwayListDelete(station);
    	 }catch (Exception e) {
    		 System.out.println("올바른 역이름을 입력해주세요.");
    			System.out.println("다시 할래요?  yes or no");
    			String choice = sc.nextLine();
    			if(choice.equals("yes")) {
    				inputDeleteBoard();
    			}
    	 }
     }
}
