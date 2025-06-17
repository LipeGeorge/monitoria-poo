package modificadores_Acesso.Relogio;

public class Time {

	private int hour;
	private int minute;
	private int second;

	public Time(int hour, int minute, int second){

		setHour(hour);
		setMinute(minute);
		setSecond(second);

	}


	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		
		if(hour < 0 || hour > 23){
			System.out.println("fail: hora invalida");

		} else {	
			this.hour = hour;
		
		}
	}


	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		
		if(minute < 0 || minute > 59){
			System.out.println("fail: minuto invalido");

		} else {
			this.minute = minute;
		}
		

	}


	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {

		if(second < 0 || second > 59){
			System.out.println("fail: segundo invalido");

		} else {
			this.second = second;

		}
		

	}


	public void nextSecond(){

		if(second > 58){

			setSecond(0);
			if(minute > 58){

				setMinute(0);
				if(hour > 22){
					setHour(0);

				} else {
					setHour(hour + 1);
				}

			} else {
				setMinute(minute + 1);
			}

		} else {
			setSecond(second + 1);

		}

	}

	public String toString() {
  		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
	
	
}
