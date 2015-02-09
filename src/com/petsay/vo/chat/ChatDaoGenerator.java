package com.petsay.vo.chat;

import java.io.IOException;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

/**
 * @author wangw
 * 宠物说的GreenDAO数据库DAO生成器
 */
public class ChatDaoGenerator {
	
//	public static void main(String[] args) {
//		Schema schema = new Schema(1, "com.petsay.vo.chat");
//		generatorTable(schema);
//		try {
//			new DaoGenerator().generateAll(schema, "../Chongwushuo_Android/PetSay/src-gen");
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	private static String daoPackage = "com.petsay.database.greendao.chat";
	private static String javaPackage = "com.petsay.vo.chat";
	public static void generatorTable(Schema schema) {
		//联系人数据表
		Entity user = schema.addEntity("ChatContacts");
		user.setJavaPackage(javaPackage);
		user.setJavaPackageDao(daoPackage);
//		user.addIdProperty().autoincrement();
		//用户ID
		Property userId = user.addStringProperty("petId").primaryKey().getProperty();
		//用户头像地址
		user.addStringProperty("headPortrait");
		//用户昵称
		user.addStringProperty("nickName");

		//聊天信息数据表
		Entity msg = schema.addEntity("ChatMsgEntity");
		msg.setJavaPackage(javaPackage);
		msg.setJavaPackageDao(daoPackage);
		msg.addIdProperty().autoincrement();
		//时间
		msg.addDateProperty("date");
		//文本内容
		msg.addStringProperty("text");
		//音频时长
		msg.addIntProperty("mediaTime");
		//消息类型
		msg.addStringProperty("type");
		//是否为接受的消息
		msg.addBooleanProperty("isComMeg");
		//发送人ID
		msg.addStringProperty("accFromId");
		//接收人ID
		msg.addStringProperty("accToId");
		//状态
		msg.addIntProperty("states");
		//联系人的ID
		Property msg_UserId = msg.addStringProperty("petId").notNull().getProperty();
		//一条消息里有一个联系人的主键
		msg.addToOne(user, msg_UserId);
		
		//联系人里有多条消息内容
		user.addToMany(msg, msg_UserId);
		
		//最新聊天信息表(只保存一条聊天信息)
		Entity newest = schema.addEntity("NewestMsg");
		newest.setJavaPackage(javaPackage);
		newest.setJavaPackageDao(daoPackage);
		Property contactsKey = newest.addStringProperty("petId").primaryKey().getProperty();
		Property msgId = newest.addLongProperty("chatMsgEntityId").notNull().getProperty();
		newest.addIntProperty("msgCount");
		newest.addDateProperty("date").notNull();
		newest.addToOne(user, contactsKey);
		newest.addToOne(msg, msgId);
		
		//黑名单列表
		Entity blacklist = schema.addEntity("ChatBlack");
		blacklist.setJavaPackage(javaPackage);
		blacklist.setJavaPackageDao(daoPackage);
		blacklist.addIdProperty().autoincrement();
		blacklist.addStringProperty("petId");
		
	}
}
