package onlineTrainMVC;

public class ticketModel {
	@Override
	public String toString() {
		return "{\"tktno\":\"" + tktno + "\", \"pnrno\":\"" + pnrno + "\", \"tno\":\"" + tno + "\", \"to\":\"" + to
				+ "\", \"from\":\"" + from + "\", \"Date\":\"" + Date + "\", \"totalFare\":\"" + totalFare
				+ "\", \"tr_class\":\"" + tr_class + "\"}";
	}

	private int tktno, pnrno;

	public ticketModel(String tno, String to, String from, String tr_class, String date, String totalFare) {
		super();

		this.tno = Integer.parseInt(tno);
		this.to = to;
		this.from = from;
		Date = date;
		this.totalFare = Double.parseDouble(totalFare);
		this.tr_class = tr_class;
	}

	public void setTktno(int tktno) {
		this.tktno = tktno;
	}

	public void setPnrno(int pnrno) {
		this.pnrno = pnrno;
	}

	public int getTktno() {
		return tktno;
	}

	public int getPnrno() {
		return pnrno;
	}

	private int tno;
	private String to;
	private String from;
	private String Date;
	private double totalFare;
	private String tr_class;

	public String getTr_class() {
		return tr_class;
	}

	public void setTr_class(String tr_class) {
		this.tr_class = tr_class;
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
}
