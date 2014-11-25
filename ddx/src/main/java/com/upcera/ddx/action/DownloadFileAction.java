/**   
 * @Title: DownloadFileAction.java 
 * @Package com.upcera.ddx.action 
 * @author ERIC
 * @company UPCERA
 * @date 2014-7-23 上午08:49:22 
 * @version V1.0   
 */
package com.upcera.ddx.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upcera.ddx.common.util.StringUtil;
import com.upcera.ddx.constans.Constans;

/**
 * @ClassName: DownloadFileAction
 * @Description: 文件下载通用类
 * @author ERIC
 * @date 2014-7-23 上午08:49:22
 * 
 */
@Controller
@RequestMapping("/downloadFileAction")
public class DownloadFileAction extends BaseAction {
	private String download;
	private String fileName;

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return this.fileName;
	}

	public String getDownload() {
		return download;
	}

	public void setDownload(String download) {
		this.download = download;
	}

	public String getFileSavePath(HttpServletRequest request) {
		String spath = request.getRealPath("");
		int index = spath.lastIndexOf("\\");
		return spath.substring(0, index + 1);
	}

	public void initParam(HttpServletRequest request) {
		setDownload(StringUtil.stringUncode(request.getParameter("download")));
		setFileName(StringUtil.stringUncode(request.getParameter("fileName")));
	}

	/**
	 * 
	 * @Title: downLoad 
	 * @Description: 下载
	 * @author ERIC 
	 * @date 2014-7-23上午08:53:08
	 * @return String
	 * @throws Exception 
	 */
	@RequestMapping("download")
	public String download(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (getSessionUserByLoginEmail() == null) {
			return "error";
		}
		initParam(request);
		
		// 创建file对象
		File file = new File(Constans.FILE_DOWNLAOD_PATH + getDownload());
		// 设置response的编码方式
		response.setContentType("application/x-msdownload;charset=UTF-8");
		// 写明要下载的文件的大小
		response.setContentLength((int) file.length());
		// 解决中文乱码
		response.setHeader("Content-Disposition", "attachment;filename=" + StringUtil.toUtf8(getFileName()));
		FileInputStream fis = null;
		BufferedInputStream buff = null;
		try {
			// 读出文件到i/o流
			fis = new FileInputStream(file);
			buff = new BufferedInputStream(fis);
			byte[] b = new byte[1024];// 相当于我们的缓存
			long k = 0;// 该值用于计算当前实际下载了多少字节
			// 从response对象中得到输出流,准备下载
			response.setCharacterEncoding("UTF-8");
			OutputStream myout = response.getOutputStream();
			// 开始循环下载
			while (k < file.length()) {
				int j = buff.read(b, 0, 1024);
				k += j;
				// 将b中的数据写到客户端的内存
				myout.write(b, 0, j);
			}
			// 将写入到客户端的内存的数据,刷新到磁盘
			myout.flush();
			myout.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				buff.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
