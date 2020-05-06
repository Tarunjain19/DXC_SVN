package com.rcom.prepaid.datasource;

import java.beans.PropertyVetoException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.servion.util.AppConstant;
import com.servion.util.AppProperties;

public class DataSource {

	private static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
	
	/**
	 * @return Connection Object including connection pooling
	 */
	
	static ComboPooledDataSource getDataSource() {
		AppProperties.setInstance(AppConstant.IVR_CONFIG, "C:\\RCOM\\Prepaid\\");
		try {
			
			comboPooledDataSource.setDriverClass(AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp("DRIVER"));
		} catch (PropertyVetoException e) {
			System.out.println("Data source not loaded");
			e.printStackTrace();
		}
		comboPooledDataSource.setJdbcUrl(AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp("JDBC_URL"));
		comboPooledDataSource.setUser(AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp("USERNAME"));
		comboPooledDataSource.setPassword(AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp("PASSWORD"));
		comboPooledDataSource.setMinPoolSize(Integer.parseInt(AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp("MIN_POOL_SIZE")));
		comboPooledDataSource.setMaxPoolSize(Integer.parseInt(AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp("MAX_POOL_SIZE")));
		comboPooledDataSource.setCheckoutTimeout(Integer.parseInt(AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp("CONNECTION_TIMEOUT")));
		/*comboPooledDataSource.setAcquireIncrement(Integer.parseInt(AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp("ACQUIRE_INCREMENT")));
		comboPooledDataSource.setMaxConnectionAge(Integer.parseInt(AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp("MAX_CONNECTION_AGE")));
		comboPooledDataSource.setMaxIdleTime(Integer.parseInt(AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp("MAX_IDLE_TIME")));
		comboPooledDataSource.setUnreturnedConnectionTimeout(Integer.parseInt(AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp("UNRETURNED_CONNECTION_TIMEOUT")));*/
		comboPooledDataSource.setIdleConnectionTestPeriod(3);
		comboPooledDataSource.setTestConnectionOnCheckin(false);
		comboPooledDataSource.setTestConnectionOnCheckout(true);
		comboPooledDataSource.setPreferredTestQuery("SELECT 1");
		//comboPooledDataSource.setBreakAfterAcquireFailure(false);
		System.out.println(" comboPooledDataSource connection obtained : " + comboPooledDataSource);
		return comboPooledDataSource;
	}
	
}
