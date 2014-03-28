
public class Preference {

	protected int quietTime;
	protected int music;
	protected int reading;
	protected int chatting;
	
	public Preference(int quietTime, int music, int reading, int chatting) {
		this.quietTime = quietTime;
		this.music = music;
		this.reading = reading;
		this.chatting = chatting;
	}
	
	public int getQtime() {
		return quietTime;
	}
	
	public int getMusic() {
		return music;
	}
	
	public int getReading() {
		return reading;
	}
	
	public int getChatting() {
		return chatting;
	}
	
	static public Preference InitPreferenceFromArray(int[] preferences){
		return new Preference(preferences[0], preferences[1], preferences[2], preferences[3]);
	}
	
	public int compare(Preference pref){
		int score = 0;
		score += Math.abs(this.quietTime - pref.quietTime);
		score += Math.abs(this.music - pref.music);
		score += Math.abs(this.reading - pref.reading);
		score += Math.abs(this.chatting - pref.chatting);
		return score;
	}
	
	public String toString(){
		return this.quietTime + "\t" + this.music + "\t" + this.reading + "\t" + this.chatting;
	}
}
