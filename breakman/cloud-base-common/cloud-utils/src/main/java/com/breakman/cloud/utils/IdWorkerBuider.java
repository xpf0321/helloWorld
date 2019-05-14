package com.breakman.cloud.utils;


import com.breakman.cloud.common.model.IdWorker;

/**
 * 创建IdWorker实例
 * 
 * @author
 */
public enum IdWorkerBuider {

	IDWORKER;

	private volatile IdWorker idWorker;

	private final static long WORKERID = 1;
	private final static long DATACENTERID = 1;

	/**
	 * @param workerId
	 *            工作机器ID
	 * @param datacenterId
	 *            序列号
	 */
	public void build(long workerId, long datacenterId) {
		try {
			this.idWorker = new IdWorker(workerId, datacenterId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public void build() {
		try {
			this.idWorker = new IdWorker(WORKERID, DATACENTERID);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public IdWorker getIdWorker() {
		return this.idWorker;
	}

	public long nextId() {
		return this.idWorker.nextId();
	}

}
