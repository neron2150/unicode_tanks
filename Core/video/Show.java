package video;

public class Show extends Thread{
	
	public Show(){
		start();
	}
	public void run(){
		Window window = new Window();
			while(true){
			window.update();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}