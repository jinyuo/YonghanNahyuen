package dto;

public class SubwayListDTO {
	private String station;
	private int getInNo;
	private int getOffNo;
	private int transferNo;
	private int rank;
	
	
	public SubwayListDTO() {}

	
	public SubwayListDTO(String station, int getInNo, int getOffNo, int transferNo) {
		super();
		this.station = station;
		this.getInNo = getInNo;
		this.getOffNo = getOffNo;
		this.transferNo = transferNo;
	}

	public SubwayListDTO(String station, int getInNo, int getOffNo, int transferNo, int rank) {
		this(station, getInNo, getOffNo, transferNo);
		this.rank = rank;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	public String getStation() {
		return station;
	}


	public void setStation(String station) {
		this.station = station;
	}


	public int getGetInNo() {
		return getInNo;
	}


	public void setGetInNo(int getInNo) {
		this.getInNo = getInNo;
	}


	public int getGetOffNo() {
		return getOffNo;
	}


	public void setGetOffNo(int getOffNo) {
		this.getOffNo = getOffNo;
	}


	public int getTransferNo() {
		return transferNo;
	}


	public void setTransferNo(int transferNo) {
		this.transferNo = transferNo;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("¿ª¸í=");
		builder.append(station);
		builder.append(" ||  Æò±Õ½ÂÂ÷ÀÎ¿ø=");
		builder.append(getInNo);
		builder.append(" ||  Æò±ÕÇÏÂ÷ÀÎ¿ø=");
		builder.append(getOffNo);
		builder.append(" ||  Æò±ÕÈ¯½ÂÀÎ¿ø=");
		builder.append(transferNo);
		builder.append("\n");
		
		return builder.toString();
	}
	
	



}
