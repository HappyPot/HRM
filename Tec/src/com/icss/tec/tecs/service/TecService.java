package com.icss.tec.tecs.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.tec.common.Pager;
import com.icss.tec.tecs.dao.TecDao;
import com.icss.tec.tecs.pojo.Tec;



public class TecService {
	private TecDao tecDao = new TecDao();	
	
	/**
	 * 检查登录老师的密码
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
	 * 增加新教师
	 * @param tec
	 * @throws Exception 
	 */
	public void addTec(Tec tec) throws Exception {
		
		tecDao.insert(tec);
		
	}	
	/**
	 * 返回教师总数
	 * @throws SQLException 
	 */
	public int getTecCount() throws SQLException {
		
		return tecDao.getCount();
	}
	/**
	 * 分页查询教师数据 
	 * @return
	 * @throws Exception 
	 */
	public ArrayList<Tec> queryTecByPage(Pager pager) throws Exception {
		
		return tecDao.queryByPage(pager);		
	}
	/**
	 * 根据id查询教师数据
	 * @param empId
	 * @return
	 * @throws Exception 
	 */
	public Tec queryTecById(int tecId) throws Exception {
		return tecDao.queryById(tecId);
	}
	/**
	 * 修改教师数据
	 * @param emp
	 * @throws Exception 
	 */
	public void updateTec(Tec tec) throws Exception {
		System.out.println("Service!!!!!!!!!!!!!!!!");
		tecDao.update(tec);		
	}
	/**
	 * 根据id删除教师
	 * @param empId
	 * @throws Exception 
	 */
	public void deleteTec(int tecId) throws Exception {
		tecDao.delete(tecId);
	}
	/**
	 * 查询用户密码
	 * @return
	 * @throws SQLException 
	 */
	public Tec queryPwdByLoginName(String tecName) throws SQLException {
		
		return tecDao.queryByLoginName(tecName);
		
	}
	/**
	 * 修改密码
	 * @throws SQLException 
	 */
	public void updatePwd(Tec tec) throws SQLException {
		tecDao.updatePwd(tec);
	}
	/**
	 * 检查登录名是否存在
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
