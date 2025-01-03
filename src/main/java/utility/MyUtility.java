package utility;

import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import myCafe.common.SuperController;

public class MyUtility {

	public static Map<String, SuperController> getMapList(String configFileaPath) {
		// 해당 경로에 들어있는 모든 항목을 자바의 Map 구조로 만들어서 반환해줌.
		Properties prop = new Properties();
		FileInputStream fis = null;

		Map<String, SuperController> mapdata = new HashMap<String, SuperController>();

		try {
			fis = new FileInputStream(configFileaPath);
			// fis 객체를 prop(map)에 load 해줌
			// todolist.txt 파일에서 = 앞에 있는 변수가 K값 = 뒤에 있는 값들이 value로 map에 저장됨
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		// 현재 prop는 key가 String이고 Value도 String이다.
		// Value를 객체화 시키도록 한다.
		Enumeration<Object> enu = prop.keys();

		while (enu.hasMoreElements()) {
			String command = enu.nextElement().toString();
			String className = prop.getProperty(command);

//			System.out.println(command + "===" + className);

			try {
				// 문자열 className을 객체 형태로 변경
				Class<?> handleClass = Class.forName(className);

				// 모든 서브 컨트롤러를 SuperController 형태로 승금을 함
				SuperController instance = (SuperController) handleClass.newInstance();

				mapdata.put(command, instance);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return mapdata;
	}

	public static MultipartRequest getMultiPartReqeust(HttpServletRequest request, String uploadedPath) {
		// 파일 업로드를 위한 MultipartRequest 객체를 구해주는 static 메소드입니다.

		MultipartRequest multi = null; // 파일 업로드 객체
		int maxPostSize = 10 * 1024 * 1024;
		String encoding = "UTF-8";

		try {
			multi = new MultipartRequest(request, uploadedPath, maxPostSize, encoding, new DefaultFileRenamePolicy());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return multi;
	}

}
