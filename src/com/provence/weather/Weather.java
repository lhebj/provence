package com.provence.weather;

import java.util.List;

public interface Weather {
	public WeatherData getCurrentDayWeather(String cityCode);
	
	public List<WeatherData> getWeeklyWeather(String cityCode);
	
	public void fetchWeather(String cityCode);
}
