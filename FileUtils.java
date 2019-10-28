package cn.io.study02;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1,��װ����
 * 2����װ�ͷ�
 * @author dell
 *
 */

public class FileUtils {
	/**
	 * �Խ����������
	 * @param args
	 */
	
	public static void copy(InputStream is,OutputStream os) {
		try {
			byte[] flush=new byte[1024];
			int len=0;
			while((len=is.read(flush))!=-1) {
				os.write(flush,0,len);
				os.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//�ͷ���Դ���ֱ�رգ��ȴ򿪵ĺ�رա�
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(os!=null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
	}
	public static void main(String[] args) {
		InputStream is=null;
		byte[] datas=null;
		//�ļ����ļ�
		try {
			is=new FileInputStream("aaa.txt");
			OutputStream os=new FileOutputStream("aaa-copy.txt");
			copy(is,os);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//�ļ����ֽ�����
		try {
			is=new FileInputStream("des1.png");
			ByteArrayOutputStream os=new ByteArrayOutputStream();
			copy(is,os);
			datas=os.toByteArray();
			System.out.println(datas.length);	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ֽ����鵽�ļ�
		try {
			
			is=new ByteArrayInputStream(datas);
			FileOutputStream os=new FileOutputStream("des1-copy.png");
			copy(is,os);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		
		
		
	}

}
