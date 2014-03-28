
public class Date {

	protected int year;
	protected int month;
	protected int day;
	
	public Date(int year, int month, int day) {
		if(year >= 1900 && year <=3000)
			this.year = year;
		if(month >= 0 && month <=12)
			this.month = month;
		if(day >=1 && day <= numDaysInMonth(month, day))
			this.day = day;
	}
	
	static public Date InitDateFromString(String dateStringFormat){
		int year, month, day;
		String dateInitparams[] = dateStringFormat.split("-",-1);
		year = Integer.parseInt(dateInitparams[2]);
		month = Integer.parseInt(dateInitparams[0]);
		day = Integer.parseInt(dateInitparams[1]);
		return new Date(year, month, day);
	}
	
	public int getYear() {
		return year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
	public int dayOfYear() { 
		int totalDays = 0; 
		switch (month) { 
		case 12: totalDays += 30; 
		case 11: totalDays += 31; 
		case 10: totalDays += 30; 
		case 9 : totalDays += 31; 
		case 8 : totalDays += 31; 
		case 7 : totalDays += 30; 
		case 6 : totalDays += 31; 
		case 5 : totalDays += 30; 
		case 4 : totalDays += 31; 
		case 3 : totalDays += 28; 
		case 2 : totalDays += 31; 
		}  totalDays += day; 
		return totalDays; 
	} 
	
	private int numDaysInMonth(int month, int day){
		int totalDays = 0;
		switch (month) {
			case 12: totalDays = 30;
			case 11: totalDays = 31;
			case 10: totalDays = 30;
			case 9 : totalDays = 31;
			case 8 : totalDays = 31;
			case 7 : totalDays = 30;
			case 6 : totalDays = 31;
			case 5 : totalDays = 30;
			case 4 : totalDays = 31;
			case 3 : totalDays = 28;
			case 2 : totalDays = 31;
			case 1 : totalDays = 31;
		}
		return totalDays; 
	}

	public String toString(){
		return this.month + "-" + this.day+ "-" + this.year;
	}

	public int compare(Date date){
		int daysDifference =  Math.abs ( (this.dayOfYear() + (365 * this.getYear()) - (date.dayOfYear() + (365 * date.getYear()))));
		int monthsDifference = daysDifference / 30;
		if(monthsDifference > 60)
			return 60;
		else
			return monthsDifference;
	}
}
