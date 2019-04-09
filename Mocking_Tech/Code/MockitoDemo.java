package priyanka.javaupgradesexamples.mockitodemo;


import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import priyanka.javaupgradesexamples.Portfolio;
import priyanka.javaupgradesexamples.Stock;
import priyanka.javaupgradesexamples.StockService;

public class MockitoDemo {
	
	public static void main(String[] args) {
		
		Portfolio portfolio = new Portfolio();
		
		List<Stock> stocks = new ArrayList<>();
		Stock microsoft = new Stock("1","Microsoft",1);
		Stock apple = new Stock("2","Apple",1);
		Stock samsung = new Stock("3","Samsung",1);
		
		stocks.add(microsoft);
		stocks.add(apple);
		stocks.add(samsung);
		
		StockService stockServiceMock = mock(StockService.class);
		
		when(stockServiceMock.getPrice(microsoft)).thenReturn(20.00);
		when(stockServiceMock.getPrice(apple)).thenReturn(30.00);
		when(stockServiceMock.getPrice(samsung)).thenReturn(20.00);
		
		portfolio.setStocks(stocks);
		
		portfolio.setStockService(stockServiceMock);
		
		double marketValue = portfolio.getMarketValue();
		
		System.out.println(marketValue);
		

	}
	

}
