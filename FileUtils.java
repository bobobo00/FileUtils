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
 * 1,封装拷贝
 * 2，封装释放
 * @author dell
 *
 */

public class FileUtils {
	/**
	 * 对接输入输出流
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
			//释放资源，分别关闭，先打开的后关闭。
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
		//文件到文件
		try {
			is=new FileInputStream("aaa.txt");
			OutputStream os=new FileOutputStream("aaa-copy.txt");
			copy(is,os);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//文件到字节数组
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
		//字节数组到文件
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
