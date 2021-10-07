package java;

// this problem is known as clock angle problem where we
// need to find angle between hands of an analog clock
// at a given time

//Input: h = 12:00, m = 30.00
//Output: 165 degree

//Input: h = 3.00, m = 30.00
//Output 75 degree

//1) angle made by hour hand with respect to 12:00 in h
//hours and m minutes (360 in 12 hours (.5 degree in 1 minute)	
//2) angle made by minute hand with respect to 12:00 in h hours) 
// and m minutes (360 degrees in 60 minutes(6 degrees per minute)
//3) the difference between the two angles is the angle between hands

class hourAndMinuteHandAngle
{
	// Function to calculate angle
	static int calcAngle(double h, double m)
	{
		// validate the input
		if(h <0 || m < 0 || h > 12 || m > 60)
			System.out.println("Wrong input");
		
		if(h == 12)
			h = 0;
		if(m == 60)
			m = 0;
		
		// Calculate the angles moved by hour and minute hands
		// with reference to 12:00
		int hour_angle = (int)(0.5 * (h*60 + m));
		int minute_angle = (int)(6 * m);
		
		// Find the difference between 2 angles
		int angle = Math.abs(hour_angle - minute_angle);
		angle = Math.min(360 - angle, angle);
		return angle;
	}
	
	public static void main(String[] args)
	{
		System.out.println(calcAngle(9, 60)+ " degrees");
		System.out.println(calcAngle(3, 30)+ " degrees");
	}
}