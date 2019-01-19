package com.devzlab.sun.springboothystrix.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfigService {
	
	@Value("${vendor.url}")
    private String vendorUrl;

    @Value("${hystrix.default.execution.timeoutEnabled: true}")
    private Boolean hxDefaultTimeoutEnabled;

    @Value("${hystrix.default.threadTimeoutInMilliseconds: 3000}")
    private String hxDefaultTimeout;

    @Value("${hystrix.default.requestVolumeThreshold: 20}")
    private String hxDefaultVolumeThreshold;

    @Value("${hystrix.default.errorThresholdPercentage: 50}")
    private String hxDefaultErrorPercent;

    @Value("${hystrix.default.sleepWindowInMilliseconds: 5000}")
    private String hxDefaultSleepWindow;

    @Value("${hystrix.default.rollingStatsTimeInMilliseconds: 10000}")
    private String hxDefaultRollingStatTime;

    @Value("${hystrix.default.threadpool.default.coreSize: 10}")
    private String hxDefaultThreadPoolCoreSize;
    
    
	public String getVendorUrl() {
		return vendorUrl;
	}

	public void setVendorUrl(String vendorUrl) {
		this.vendorUrl = vendorUrl;
	}

	public Boolean getHxDefaultTimeoutEnabled() {
		return hxDefaultTimeoutEnabled;
	}

	public void setHxDefaultTimeoutEnabled(Boolean hxDefaultTimeoutEnabled) {
		this.hxDefaultTimeoutEnabled = hxDefaultTimeoutEnabled;
	}

	public String getHxDefaultTimeout() {
		return hxDefaultTimeout;
	}

	public void setHxDefaultTimeout(String hxDefaultTimeout) {
		this.hxDefaultTimeout = hxDefaultTimeout;
	}

	public String getHxDefaultVolumeThreshold() {
		return hxDefaultVolumeThreshold;
	}

	public void setHxDefaultVolumeThreshold(String hxDefaultVolumeThreshold) {
		this.hxDefaultVolumeThreshold = hxDefaultVolumeThreshold;
	}

	public String getHxDefaultErrorPercent() {
		return hxDefaultErrorPercent;
	}

	public void setHxDefaultErrorPercent(String hxDefaultErrorPercent) {
		this.hxDefaultErrorPercent = hxDefaultErrorPercent;
	}

	public String getHxDefaultSleepWindow() {
		return hxDefaultSleepWindow;
	}

	public void setHxDefaultSleepWindow(String hxDefaultSleepWindow) {
		this.hxDefaultSleepWindow = hxDefaultSleepWindow;
	}

	public String getHxDefaultRollingStatTime() {
		return hxDefaultRollingStatTime;
	}

	public void setHxDefaultRollingStatTime(String hxDefaultRollingStatTime) {
		this.hxDefaultRollingStatTime = hxDefaultRollingStatTime;
	}

	public String getHxDefaultThreadPoolCoreSize() {
		return hxDefaultThreadPoolCoreSize;
	}

	public void setHxDefaultThreadPoolCoreSize(String hxDefaultThreadPoolCoreSize) {
		this.hxDefaultThreadPoolCoreSize = hxDefaultThreadPoolCoreSize;
	}
}
