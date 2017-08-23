package com.icss.tec.tecs.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.tec.common.Pager;
import com.icss.tec.tecs.dao.TecDao;
import com.icss.tec.tecs.pojo.Tec;



public class TecService {
	private TecDao tecDao = new TecDao();	
	
	/**
	 * ����¼��ʦ������
	 * @param tecName
	 * @param tecPwd
	 * @return
	 * @throws SQLException
	 */
	public int checkLogin(String tecName,String tecPwd) throws SQLException {
			
			Tec tec = tecDao.queryByLoginName(tecName);
			System.out.println(tec);
			if (tec == null){
				return 1;
			}else if (!tecPwd.equals(tec.getTecPwd())){
				return 2;
			};
			return 3;	
	}
	/**
	 * �����½�ʦ
	 * @param tec
	 * @throws Exception 
	 */
	public void addTec(Tec tec) throws Exception {
		
		tecDao.insert(tec);
		
	}	
	/**
	 * ���ؽ�ʦ����
	 * @throws SQLException 
	 */
	public int getTecCount() throws SQLException {
		
		return tecDao.getCount();
	}
	/**
	 * ��ҳ��ѯ��ʦ���� 
	 * @return
	 * @throws Exception 
	 */
	public ArrayList<Tec> queryTecByPage(Pager pager) throws Exception {
		
		return tecDao.queryByPage(pager);		
	}
	/**
	 * ����id��ѯ��ʦ����
	 * @param empId
	 * @return
	 * @throws Exception 
	 */
	public Tec queryTecById(int tecId) throws Exception {
		return tecDao.queryById(tecId);
	}
	/**
	 * �޸Ľ�ʦ����
	 * @param emp
	 * @throws Exception 
	 */
	public void updateTec(Tec tec) throws Exception {
		System.out.println("Service!!!!!!!!!!!!!!!!");
		tecDao.update(tec);		
	}
	/**
	 * ����idɾ����ʦ
	 * @param empId
	 * @throws Exception 
	 */
	public void deleteTec(int tecId) throws Exception {
		tecDao.delete(tecId);
	}
	/**
	 * ��ѯ�û�����
	 * @return
	 * @throws SQLException 
	 */
	public Tec queryPwdByLoginName(String tecName) throws SQLException {
		
		return tecDao.queryByLoginName(tecName);
		
	}
	/**
	 * �޸�����
	 * @throws SQLException 
	 */
	public void updatePwd(Tec tec) throws SQLException {
		tecDao.updatePwd(tec);
	}
	/**
	 * ����¼���Ƿ����
	 * @param empLoginName
	 * @return
	 * @throws SQLException 
	 */
	public boolean checkLoginName(String tecName) throws SQLException {
		
		Tec tec = tecDao.queryByLoginName(tecName);
		
		if (tec == null)
			return false;
		
		return true;		
	}
}
