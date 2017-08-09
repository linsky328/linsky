package cn.com.common;

import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class JpgTest {

	/**
	 * 测试函数
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		// 图片文件夹路径
		String pathName = "D:/testImage";

		// 存放文件名的集合
		ArrayList<String> fileNameList = getFileName(pathName);

		// 遍历文件名集合
		Iterator<String> iter = fileNameList.iterator();

		while (iter.hasNext()) {

			String fileName = iter.next();

			File file = new File(pathName + "/" + fileName);

			// 判断是否为图片
			boolean result = true;//isImage(file);

			if (result) {

				// 获取图片的格式
				String format = getExtension(file);

				System.out.println("图片格式为:" + format);

				// 将图片格式转换为JPEG
				if (format != "JPEG") {

					// 需要修改的文件路径
					String input = pathName + "/" + fileName;

					// 将文件路径改为.jpg
					String[] stringSplit = fileName.split("\\.");
					String output = pathName + "/" + stringSplit[0] + "desc.jpg";

					// 转换图片格式
					forJpg(input, output);

				}
			}
		}
	}

	/**
	 * 获取文件夹内所有的文件名
	 * 
	 * @param pathName
	 */
	public static ArrayList<String> getFileName(String pathName) {

		// 存放遍历出来的文件名字
		ArrayList<String> nameList = new ArrayList<String>();

		File dirFile = new File(pathName);

		// 获取此目录下的所有文件名与目录名
		String[] fileList = dirFile.list();

		for (int i = 0; i < fileList.length; i++) {

			// 遍历文件目录
			String string = fileList[i];

			File file = new File(dirFile.getPath(), string);

			String name = file.getName();

			nameList.add(name);
		}

		return nameList;
	}

	/**
	 * 获取图片格式函数
	 * 
	 * @param file
	 * @return
	 */
	public static String getExtension(File file) {
		// 图片格式
		String format = "";

		ImageInputStream iis = null;

		try {

			iis = ImageIO.createImageInputStream(file);

			Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);

			if (iter.hasNext()) {

				format = iter.next().getFormatName();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (iis != null) {
				try {
					iis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return format;

	}

	/**
	 * 判断是否为图片函数
	 * 
	 * @param file
	 * @return
	 */
	public static boolean isImage(File resFile) {

		ImageInputStream iis = null;

		try {

			iis = ImageIO.createImageInputStream(resFile);

			Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);

			// 文件是不是图片
			if (iter.hasNext()) {

				return true;

			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {
			if (iis != null) {
				try {
					iis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	/**
	 * 将图片格式转换为JPG格式
	 * 
	 * @param input
	 * @param output
	 * @throws IOException
	 */
	public static void forJpg(String input, String output) throws IOException {
		File fi = new File(input);
		BufferedImage im = ImageIO.read(fi);
		File fo = new File(output);
		ImageIO.write(im, "jpg", fo);
	}
}