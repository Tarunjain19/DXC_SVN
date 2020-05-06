package com.rcom.red.datasource;

import java.beans.PropertyVetoException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.rcom.red.resource.Constants;
import com.servion.util.AppProperties;

public class DataSource {

	private static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
	
	/**
	 * @return Connection Object including connection pooling
	 */
	
	static ComboPooledDataSource getDataSource() {
		//AppProperties.setInstance(Constants.RED_Hostservice, "C:\\RCOM\\RED\\Config\\");
		try {
			comboPooledDataSource.setDriverClass(AppProperties.GetInstance(Constants.RED_Hostservice).getIVRProp(Constants.DRIVER));
		} catch (PropertyVetoException e) {
			System.out.println("Data source not loaded");
			e.printStackTrace();
		}
		comboPooledDataSource.setJdbcUrl(AppProperties.GetInstance(Constants.RED_Hostservice).getIVRProp(Constants.JDBC_URL));
		comboPooledDataSource.setUser(AppProperties.GetInstance(Constants.RED_Hostservice).getIVRProp(Constants.USERNAME));
		comboPooledDataSource.setPassword(AppProperties.GetInstance(Constants.RED_Hostservice).getIVRProp(Constants.PASSWORD));
		comboPooledDataSource.setCheckoutTimeout(Integer.parseInt(AppProperties.GetInstance(Constants.RED_Hostservice).getIVRProp(Constants.CONNECTION_TIMEOUT)));
		comboPooledDataSource.setMinPoolSize(Integer.parseInt(AppProperties.GetInstance(Constants.RED_Hostservice).getIVRProp(Constants.MIN_POOL_SIZE)));
		comboPooledDataSource.setMaxPoolSize(Integer.parseInt(AppProperties.GetInstance(Constants.RED_Hostservice).getIVRProp(Constants.MAX_POOL_SIZE)));
		//comboPooledDataSource.setCheckoutTimeout(Integer.parseInt(AppProperties.GetInstance(Constants.RED_Hostservice).getIVRProp(Constants.CONNECTION_TIMEOUT)));
		//comboPooledDataSource.setAcquireIncrement(Integer.parseInt(AppProperties.GetInstance(Constants.RED_Hostservice).getIVRProp(Constants.ACQUIRE_INCREMENT)));
		//comboPooledDataSource.setMaxConnectionAge(Integer.parseInt(AppProperties.GetInstance(Constants.RED_Hostservice).getIVRProp(Constants.MAX_CONNECTION_AGE)));
		//comboPooledDataSource.setMaxIdleTime(Integer.parseInt(AppProperties.GetInstance(Constants.RED_Hostservice).getIVRProp(Constants.MAX_IDLE_TIME)));
		//comboPooledDataSource.setUnreturnedConnectionTimeout(Integer.parseInt(AppProperties.GetInstance(Constants.RED_Hostservice).getIVRProp(Constants.UNRETURNED_CONNECTION_TIMEOUT)));
		//comboPooledDataSource.setBreakAfterAcquireFailure(true);
		
		comboPooledDataSource.setIdleConnectionTestPeriod(3);
		comboPooledDataSource.setTestConnectionOnCheckin(false);
		comboPooledDataSource.setTestConnectionOnCheckout(true);
		comboPooledDataSource.setPreferredTestQuery("SELECT 1");
		System.out.println(" comboPooledDataSource connection obtained : " + comboPooledDataSource);
		return comboPooledDataSource;
	}
	
}
