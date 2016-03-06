package com.easygame.sdk.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import net.rubyeye.xmemcached.GetsResponse;
import net.rubyeye.xmemcached.MemcachedClient;

/** 缓存处理类 */
public class MemcachedUtils {

	@Autowired
	private MemcachedClient memcachedClient;
	
	/** 玩家memcached 超时时间 */
	public static final Integer PLAYER_TIMEOUT = 60 * 60 * 24;
	/** 系统memcached 超时时间 */
	public static final Integer SYSTEM_TIMEOUT = 0;
	/** 临时数据 memcached 超时的时间 */
	public static final Integer TEMP_TIME = 15 * 60;
	/** memcached 更新失败后 最大尝试次数 */
	public static final Integer MAX_TRIES = 5;

	/**
	 * @Description: 获得指定key值的value
	 * @param @param key 键值
	 * @param @return
	 * @return Object(返回类型)
	 * @throws MemcachedException
	 * @throws InterruptedException
	 * @throws TimeoutException
	 */
	public <T> T get(String key) {
		T object = null;
		try {
			object = memcachedClient.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	/**
	 * @Description: 获得指定key集合的value集合
	 * @param @param keys 键值集合
	 * @param @return
	 * @return Map<String, T> (返回类型)
	 * @throws MemcachedException
	 * @throws InterruptedException
	 * @throws TimeoutException
	 */
	public <T> Map<String, T> get(Collection<String> keys) {
		Map<String, T> objects = null;
		try {
			objects = memcachedClient.get(keys);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	
	/**
	 * @Description: 获得指定key值的value
	 * @param @param key 键值
	 * @param @return
	 * @return Object(返回类型)
	 * @throws MemcachedException
	 * @throws InterruptedException
	 * @throws TimeoutException
	 */
	public <T> GetsResponse<T> gets(String key) {
		GetsResponse<T> getsResponse = null;
		try {
			getsResponse = memcachedClient.gets(key);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return getsResponse;
	}
	
	/**
	 * @Description: 获得指定key值的value
	 * @param @param key 键值
	 * @param @return
	 * @return Object(返回类型)
	 * @throws MemcachedException
	 * @throws InterruptedException
	 * @throws TimeoutException
	 */
	public <T> GetsResponse<T> gets(String key, long incr) {
		GetsResponse<T> getsResponse = null;
		try {
			getsResponse = memcachedClient.gets(key, incr);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return getsResponse;
	}
	
	public <T> Collection<String> getCollectionKeys(String prefix, Collection<T> keys) {
		List<String> keyList = new ArrayList<String>();

		for (Object key : keys) {
			keyList.add(prefix + key);
		}
		return keyList;
	}

	public int incr(String key, int incr) {
		int result = -1;
		try {
			Long temp = memcachedClient.incr(key, incr);
			if (temp != null) {
				result = temp.intValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int incr(String key, int incr, int init) {
		int result = -1;
		try {
			Long temp = memcachedClient.incr(key, incr, init);
			if (temp != null) {
				result = temp.intValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int decr(String key, int incr) {
		int result = -1;
		try {
			Long temp = memcachedClient.decr(key, incr);
			if (temp != null) {
				result = temp.intValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @Description: 把value 增加到指定的key中
	 * @param @param key 键值
	 * @param @param value 值
	 * @param @return
	 * @return Object(返回类型)
	 */
	public <T> boolean add(String key, T value) {
		try {
			return memcachedClient.add(key, PLAYER_TIMEOUT, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @Description: 把value 增加到指定的key中
	 * @param @param key 键值
	 * @param @param exp 失效时间(单位为秒)
	 * @param @param value 值
	 * @param @return
	 * @param @throws Exception
	 * @return Object(返回类型)
	 */
	public <T> boolean add(String key, int timeOut, T value) {
		try {
			return memcachedClient.add(key, timeOut, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @Description: 把value 设置到指定的key中
	 * @param @param key 键值
	 * @param @param value 值
	 * @param @return
	 * @param @throws Exception
	 * @return Boolean(返回类型)
	 */
	public <T> boolean put(String key, T value) {
		try {
			return memcachedClient.set(key, PLAYER_TIMEOUT, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @Description: 把value 设置到指定的key中
	 * @param @param key 键值
	 * @param @param exp 失效时间(单位为秒)
	 * @param @param value 值
	 * @param @return
	 * @param @throws Exception
	 * @return boolean(返回类型)
	 */
	public <T> boolean put(String key, int exp, T value) {
		try {
			return memcachedClient.set(key, exp, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @Description: 通过原子操作把value 设置到指定的key中
	 * @param @param key 键值
	 * @param @param value 值
	 * @param @return
	 * @param @throws Exception
	 * @return boolean(返回类型)
	 */
	public <T> boolean cas(String key, long cas, T value) {
		try {
			return memcachedClient.cas(key, SYSTEM_TIMEOUT, value, cas);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @Description: 从memcache删除指定key值
	 * @param @param key
	 * @param @return
	 * @return boolean(返回类型)
	 */
	public boolean delete(String key) {
		try {
			return memcachedClient.delete(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
