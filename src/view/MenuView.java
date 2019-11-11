package view;



import java.util.Scanner;

import controller.SubwayListController;
import dto.SubwayListDTO;


public class MenuView {
   static Scanner sc =new Scanner(System.in);
 
   /**
    * �޴�
    * */
    public static void menuChoice() {
         while(true) {
        	 System.out.println("\n---------------------------------------------------------------------------------------------------------------------");
        	 System.out.print("[ 1. ��ü�˻� ");
        	 System.out.print("| 2. ���̸��� ���� �˻� ");
        	 System.out.print("| 3. ������ ��� ");
        	 System.out.print("| 4. ������ ���� ");
        	 System.out.print("| 5. ������ ���� ");
        	 System.out.print("| 6. �� ȥ�⵵ ���� �˻� ");

         	System.out.print("| 7. ���� ]");
         	System.out.println("\n---------------------------------------------------------------------------------------------------------------------");

             
              System.out.println("���ø޴���?");
              
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
	            	  System.out.println("����Ǿ����ϴ�.");
	    			 System.exit(0);	
	    			break;
				default:
					System.out.println("�߸��Ǿ����ϴ�. �ٽ� �Է����ּ���.");
				}
	        	 
              }catch (NumberFormatException e) {
				System.out.println("�޴��� ���ڸ� �����մϴ�.");
			}
         }//while��
    	
    }
    
    private static void inputDeleteCheck() {
      	 try {
	    	 System.out.println("������ �� �̸�?");
	    	 String station = sc.next();
	    	 sc.nextLine();
	    	
	    	 SubwayListController.subwayDeleteCheck(station);
   	  }catch (NumberFormatException e) {
			System.out.println("�ùٸ� ���̸��� �Է����ּ���.");
			System.out.println("�ٽ� �ҷ���?  yes or no");
			String choice = sc.nextLine();
			if(choice.equals("yes")) {
				inputDeleteCheck();
			}
		 }
	
}

	private static void inputSubwayCongestion() {
	try {
		String sortType =null;
		System.out.println("� ������ �˰� �����Ű���? �����ο������� 1, �����ο������� 2, ȯ���ο������� 3");
		int menuNum = Integer.parseInt(sc.nextLine());
		if(menuNum == 1)sortType="��ս����ο�";
		else if(menuNum==2)sortType = "��������ο�";
		else if(menuNum==3)sortType = "���ȯ���ο�";
		else {
			System.out.println("������ ���ڸ� �Է����ּ���.");
			inputSubwayCongestion();
		}
		System.out.println("�������� �˰�ͳ���?");

		int rankNum = Integer.parseInt(sc.nextLine());
		SubwayListController.subwayCongestionRank(sortType, rankNum);
		
	}catch(NumberFormatException e) {
		System.out.println("������ ���ڸ� �Է����ּ���.");
		System.out.println("�ٽ� �ҷ���?  yes or no");
		String choice = sc.nextLine();
		if(choice.equals("yes")) {
			inputSubwayCongestion();
		}
	}
	
}

	public static void inputSubwayBystation() {
   	 try {
	    	 System.out.println("���̸�?");
	    	 String station = sc.nextLine();
	    	 SubwayListController.subwaySelectByStation(station);
   	  }catch (NumberFormatException e) {
			System.out.println("�ùٸ� ���̸��� �Է����ּ���.");
			System.out.println("�ٽ� �ҷ���?  yes or no");
			String choice = sc.nextLine();
			if(choice.equals("yes")) {
				inputSubwayBystation();
			}
		 }//catch��End
    }//�޼ҵ� end
    
    
	private static void inputInsertSubway() {
		try {
			System.out.println("���̸�?");
			String station = sc.nextLine();
			System.out.println("��ս����ο� ?");
			int getInNo = Integer.parseInt(sc.nextLine());
			System.out.println("��������ο� ?");
			int getOffNo = Integer.parseInt(sc.nextLine());
			System.out.println("���ȯ���ο� ?");
			int transferNo = Integer.parseInt(sc.nextLine());

			SubwayListDTO dto = new SubwayListDTO(station, getInNo, getOffNo, transferNo);

			SubwayListController.subwayListInsert(dto);
		} catch (NumberFormatException e) {
			System.out.println("�ο��� ���ڸ� �Է����ּ���.");
			System.out.println("�ٽ� �ҷ���?  yes or no");
			String choice = sc.nextLine();
			if (choice.equals("yes")) {
				inputInsertSubway();
			}
		}
	}

	 //���� �� ����
    private static void inputUpdateSubway() {
    	
    try {
    System.out.println("���� �� �� �̸���?");
    String station = sc.nextLine();
   	 
   	 System.out.println("������ �� ��ս����ο���?");
   	int getInNo = Integer.parseInt(sc.nextLine());
   	 
   	System.out.println("������ �� ��������ο���?");
   	int getOffNo = Integer.parseInt(sc.nextLine());
  	System.out.println("������ �� ���ȯ���ο���?");
  	 int transferNo = Integer.parseInt(sc.nextLine());
   	
   	 SubwayListDTO dto =  new SubwayListDTO(station, getInNo, getOffNo, transferNo);
   	 
   	 SubwayListController.subwayListUpdate(dto);
   	 
    }catch (Exception e) {
    	System.out.println("������ �ο��� ���ڸ� �Է����ּ���.");
		System.out.println("�ٽ� �ҷ���?  yes or no");
		String choice = sc.next();
		sc.nextLine();
		if(choice.equals("yes")) {
			inputUpdateSubway();
		}
    
    }
}


    /**
     * ����
     * */
     public static void inputDeleteBoard() {
    	 try {
    	 inputDeleteCheck();
    	 
  //  	 System.out.print("������ �� �̸��� ��Ȯ�� �Է��ϼ��� : ");
    	 
    	 String station = sc.nextLine();
    	 SubwayListController.SubwayListDelete(station);
    	 }catch (Exception e) {
    		 System.out.println("�ùٸ� ���̸��� �Է����ּ���.");
    			System.out.println("�ٽ� �ҷ���?  yes or no");
    			String choice = sc.nextLine();
    			if(choice.equals("yes")) {
    				inputDeleteBoard();
    			}
    	 }
     }
}
