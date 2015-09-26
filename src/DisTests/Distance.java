package DisTests;

public class Distance {
	
	private static final double EARTH_RADIUS = 6378137.0;//单位m
	/*
	public static void main(String[] args) {
		
		double lo1 = 108.90, la1 = 34.1;// 第一个经纬度
		double lo2 = 115.4648060, la2 = 38.8738910;// 第二个经纬度
		System.out.println("经纬度结果:" + getDistance(lo1, la1, lo2, la2));
		System.out.println("经纬度结果:" + getDistance(0, 0, 0, 0));
	}
	*/

	// 返回单位是米
	public static double getDistance(double latitude1, double longitude1, double latitude2, double longitude2){
		
		double Lat1 = rad(latitude1);
		double Lat2 = rad(latitude2);
		double a = Lat1 - Lat2;
		double b = rad(longitude1) - rad(longitude2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) 
					+ Math.cos(Lat1) * Math.cos(Lat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		//单位为米，不需要再进行进行处理
		System.out.println(s);
		return s;
	}
	
	private static double rad(double d) {
		return d * Math.PI / 180.0;
		}
	
}