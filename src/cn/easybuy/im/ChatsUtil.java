package cn.easybuy.im;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/*
 * 人工智能聊天室
 * @author 刘东阳
 * 
 * ****/
public class ChatsUtil {
	
	
	public static String getResult(String message)
	{
		URL urlObj=null;
		StringBuffer buffer= new StringBuffer();
		InputStreamReader reader=null;
		BufferedReader br=null;
		
		try {
			//设置编码格式
			String question=URLEncoder.encode(message,"utf-8");
			//请求url对接图灵机器人接口
			String requestUrl="http://www.tuling123.com/openapi/api?key=a90401566e0242299c6009255b59a1a5&info="+question;
			//获取网络链接
			urlObj=new URL(requestUrl);
			//获取链接对象
			URLConnection uc=urlObj.openConnection();
			//直接链接
			uc.connect();
			//获取请求结果
			reader=new InputStreamReader(uc.getInputStream(),"utf-8");
			//建立缓存流
			br=new BufferedReader(reader);
            String temp=null;
		  while((temp=br.readLine())!=null)
		    {
			  buffer.append(temp);
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			if(br!=null)
			try {
				
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(reader!=null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		
		
		return buffer.toString();
		
	}
	
	public static void main(String []arg)
	{
		String message="你是男的？";
		String str=getResult(message);
		System.out.println(str);
	}

}
