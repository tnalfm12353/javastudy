package tv;

public class TV {
	
	private int channel;	// 1 ~ 255
	private int volume; 	// 0 ~ 100
	private boolean power;
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	public void power(boolean on) {
		this.power = on;
	}
	
	public void channel(boolean up) {
		channel(channel +(up? +1 : -1));
	}
	
	public void channel(int channel) {
		if(!power) {
			return ;
		}
		
		if(channel < 1) {
			channel = 255;
		} else if(channel > 255){
			channel = 1;
		}
		
		this.channel = channel;
	}
	
	public void volume(boolean up) {
		if(!power) {
			return ;
		}
		
		if(up) {
			this.volume++;
		}else{
			this.volume--;
		}
		
		checkingVolume();
	}
	
	public void volume(int volume) {
		if(!power) {
			return ;
		}
		
		this.volume = volume;
		
		checkingVolume();
	}
	
	private void checkingVolume() {
		if( volume >= 100) {
			volume = 0;
		}else if ( volume < 0) {
			volume = 100;
		}
	}

	public void status() {
		System.out.println("TV[power = " + (power? "on" : "off") + ", channel = "+channel+ " volume = "+volume+"]");
		
	}
}
