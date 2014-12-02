package com.upcera.ddx.test.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.Configuration;
import net.sf.ehcache.config.MemoryUnit;

import org.junit.Test;

public class TestEhcache {

	@Test
	public void testDefault(){
		CacheManager cacheManager = new CacheManager();
		System.out.println(cacheManager.getActiveConfigurationText());
	}
	
	@Test
	public void test() {
		// 新建一个CacheManager的配置信息
		Configuration configuration = new Configuration();
		// 新建一个缓存的配置信息
		CacheConfiguration cacheConfiguration = new CacheConfiguration().name("test");
		// 指定当前缓存的最大堆内存值为100M
		cacheConfiguration.maxBytesLocalHeap(100, MemoryUnit.MEGABYTES);
		// 添加一个cache
		configuration.addCache(cacheConfiguration);
		configuration.dynamicConfig(false); // 不允许动态修改配置信息
		CacheManager cacheManager = new CacheManager(configuration);
		Cache cache = cacheManager.getCache("test");
		cache.put(new Element("testx", "testx"));
		System.out.println(cache.get("testx").getObjectValue());
		;
	}

}
