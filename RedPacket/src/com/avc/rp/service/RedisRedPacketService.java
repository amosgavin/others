package com.avc.rp.service;

public interface RedisRedPacketService {
	/**
	 * ����redis������б�
	 * @param redPacketId   --������
	 * @param unitAmount --������
	 * */
	public void saveUserRedPacketByRedis(Integer redPacketId, Double unitAmount);
}
