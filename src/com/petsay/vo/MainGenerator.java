package com.petsay.vo;

import java.io.IOException;

import com.petsay.vo.chat.ChatDaoGenerator;
import com.petsay.vo.petsay.petTagGenerator;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Schema;

/**
 * @author wangw
 *
 */
public class MainGenerator {
	
	public static void main(String[] args) {
		Schema schema = new Schema(2, "com.petsay.database.greendao");
		generatorTable(schema);
		try {
			new DaoGenerator().generateAll(schema, "../Chongwushuo_Android/PetSay/src-gen");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void generatorTable(Schema schema) {
		ChatDaoGenerator.generatorTable(schema);
		petTagGenerator.generatorTable(schema);
	}
}
