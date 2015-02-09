package com.petsay.vo.petsay;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * @author wangw
 *
 */
public class petTagGenerator {

//	public static void main(String[] args) {
//		Schema schema = new Schema(1, "com.petsay.vo.petalk.dao");
//		generalTable(schema);
//		try {
//			new DaoGenerator().generateAll(schema, "../Chongwushuo_Android/PetSay/src");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public static void generatorTable(Schema schema) {

		/**
		 * private String id;// 主键
    private String type;// 类型
    private String name;// 名称
    private String iconUrl;// 图标
    private String bgUrl;// 背景图
    private String detailUrl;// 详情介绍
    private String ctrl;// tab控制器
    private String deleted;// 删除
    private String createTime;// 创建时间
		 */
		Entity dt = schema.addEntity("PetTagVo");
		dt.addStringProperty("id");
		dt.addStringProperty("name");
		dt.addStringProperty("iconUrl");
		dt.addStringProperty("bgUrl");
		dt.addStringProperty("detailUrl");
		dt.addStringProperty("ctrl");
		dt.addBooleanProperty("deleted");
		dt.addStringProperty("createTime");
	}
}
