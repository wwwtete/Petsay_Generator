package com.petsay.vo.petsay;

import java.io.IOException;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * @author wangw
 *
 */
public class DecorationGenerator {

//	public static void main(String[] args) {
//		Schema schema = new Schema(1, "com.petsay.vo.decoration.dao");
//		generalTable(schema);
//		try {
//			new DaoGenerator().generateAll(schema, "../Chongwushuo_Android/PetSay/src");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public static void generatorTable(Schema schema) {
		
		/**
		 * private String id;// ID
	private String name;// 名称
	private String type;// 细类
	private String thumbnail;// 缩略图

	private String url;// 资源标识
	private String hash;// 资源HASH
	private String fileName;// 资源文件名
	private String fileType;// 资源文件类型
	private String fileCount;// 资源数量
	private String createTime;// 创建时间
	private boolean isDownloaded;
	private boolean assetsed;
	private transient boolean downloading;
		 */
		
		//饰品表
		Entity dt = schema.addEntity("DecorationBean");
		dt.addStringProperty("id");
		dt.addStringProperty("name");
		dt.addStringProperty("type");
		dt.addStringProperty("thumbnail");
		dt.addStringProperty("hash");
		dt.addStringProperty("fileName");
		dt.addStringProperty("fileType");
		dt.addIntProperty("fileCount");
		dt.addStringProperty("createTime");
		dt.addStringProperty("files");
		dt.addBooleanProperty("isDownloaded");
		dt.addBooleanProperty("assetsed");
		
		
	}
}
