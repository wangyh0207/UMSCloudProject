package cn.ekgc.ums.controller;

import cn.ekgc.ums.base.controller.BaseController;
import cn.ekgc.ums.base.pojo.vo.ResponseVO;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * <b>文件上传控制</b>
 */
@RestController("fileController")
@RequestMapping("/file")
public class FileController extends BaseController {

	/**
	 * <b>文件上传</b>
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/upload")
	public ResponseVO uploadFile(@RequestParam("uploadFile") MultipartFile uploadFile) throws Exception {
		// 对于上传的文件进行重命名
		// 获得文件上传的原始名
		String fileName = uploadFile.getOriginalFilename();
		// 通过文件原始名，截取该文件的扩展名
		String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		// 对于文件进行重命名，可以使用当前时间的毫秒数作为扩展名
		fileName = System.currentTimeMillis() + suffix;
		// 根据文件名创建文件保存对象
		File file = new File("/usr/local/Cellar/nginx/1.19.2/view/ums/upload" + File.separator + fileName);
		// 根据 File 对象创建文件输出流
		OutputStream out = new FileOutputStream(file);
		// 通过 MultipartFile 对象获得文件输入流
		InputStream in = uploadFile.getInputStream();
		// 通过读取输入流中的数据，写入到输出流中
		IOUtils.copy(in, out);
		return ResponseVO.successResponse(fileName);
	}
}
