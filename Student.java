
public class Student {

	protected String name;
	protected char gender;
	protected Date birthDay;
	protected Preference pref;
	protected boolean match;
	
	public Student(String name, char gender, Date birthDay, Preference pref, boolean match) {
		this.name = name;
		if(gender == 'M' || gender == 'F'){
			this.gender = gender;
		}
		this.gender = gender;
		this.birthDay = birthDay;
		this.pref = pref;
		this.match = false;
	}
	
	public String getName() {
		return name;
	}
	
	public char getGender() {
		return gender;
	}
	
	public Date getBirth() {
		return birthDay;
	}
	
	public Preference getPref() {
		return pref;
	}
	
	public boolean getMatch() {
		return match;
	}
	
	public void setMatch(boolean newMatch) {
		this.match = newMatch;
	}
	
	public int compare(Student st) {
		int score = 0;
		if (this.gender != st.getGender())
			return score;
		else {
			score = ((40 - this.pref.compare(st.pref)) + (60 - this.birthDay.compare(st.birthDay)));
			return score;
		}
	}
}


