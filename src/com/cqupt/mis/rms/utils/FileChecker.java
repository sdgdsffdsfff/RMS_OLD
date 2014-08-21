package com.cqupt.mis.rms.utils;

import java.io.File;
/**
*<p>Title:实现删除某一个文件夹里的所有文件</p>
*<p>Description:实现删除某一个文件夹里的所有文件</p>
*@author HuangHaiyan
*@version 1.0
**/
public class FileChecker {
	/**
	 * 删除某一个文件夹里的所有文件
	 * @param folder 文件夹所在路径
	 * @return  删除完后 true  失败返回false
	 */
    public boolean deleteFileinFolder(String folder){
        boolean b = true;
        File dir = new File(folder);
        
        String[] list = dir.list();
        
        if(list.length == 0){
            return false;
        }
        File fileDelete;
        
        for(String filename : list){
            String temp = new StringBuffer(folder).append(File.separator).append(filename).toString();
            fileDelete = new File(temp);
            b = fileDelete.delete();
        }
        return b;
    }
    
  

}