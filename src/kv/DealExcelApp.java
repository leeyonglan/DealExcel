package kv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.regex.*;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class DealExcelApp
{

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		heroConfig();
//		return;
//		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//		String outfilePath = "F:\\sg\\client\\trunk\\battle\\src\\functions\\battle\\";
//		String fileName = "技能动画基准位置"+ ".xls";
//		String outfileName = "BattleSkillConfig.as";
//		try
//		{
//			Workbook wwb = Workbook.getWorkbook(new File(fileName));
//			Sheet sheet =  wwb.getSheet(0);
//			String str = "package functions.battle\n{\n	import flash.utils.Dictionary;\n	public class BattleSkillConfig\n	{\n		public static var  _dict:Dictionary = new Dictionary;\n		public function BattleSkillConfig()\n		{";
//			for( int i = 1;i<sheet.getRows();i++)
//			{
//				Cell cell1 = sheet.getCell(0, i);
//				Cell cell2 = sheet.getCell(4, i);
//				String line = "\t\t\t_dict[";
//				String id = cell1.getContents().trim();
//				line +=id+"]=";
//				String pos = "0";
//				if(cell2.getContents().trim().hashCode()=="头上".hashCode())
//				{
//					pos = "0";
//				}
//				if(cell2.getContents().trim().hashCode()=="中心".hashCode())
//				{
//					pos = "1";
//				}
//				if(cell2.getContents().trim().hashCode()=="脚下".hashCode())
//				{
//					pos = "2";
//				}
//				line +=pos+";\n";
//				str += line;
//			}
//			str +="}\n		public static function getConfig(id:int):int\n		{\n			if(!_dict.hasOwnProperty(id))\n			{\n				return 2;\n			}\n			return _dict[id];\n		}\n	}\n}";
//			System.out.println(str);
//			File file = new File(outfilePath+outfileName);
//			if(!file.exists())
//			{
//				file.createNewFile();
//			}
//			FileOutputStream out = new FileOutputStream(file);
//			out.write(str.getBytes("utf-8"));
////					.createWorkbook(new FileOutputStream(Configuration
////							.getPath()
////							+ "/out/" + fileName));
//
//		}
//		catch (FileNotFoundException e)
//		{
//			e.printStackTrace();
//		}
//		catch (IOException e)
//		{
//			e.printStackTrace();
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
	}
	public static void heroConfig()
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String filePath = "F:\\英雄学院\\svnroot\\策划专用\\配置表\\";
		String outputPath = "F:\\项目code\\Hungry-Hero\\src\\data\\";
		String fileName = filePath+"兵种配置"+ ".xls";
		String outfileName = "soldier.as";
		try
		{
			Workbook wwb = Workbook.getWorkbook(new File(fileName));
			Sheet sheet =  wwb.getSheet(0);
			String str = "package data{\n public class soldier{\n";
			Pattern pattern = Pattern.compile("[^a-zA-Z]+");
			String func = "";
			for( int i = 0;i<sheet.getColumns();i++)
			{
				Cell cell1 = sheet.getCell(i, 0);
				String line = "\t\t private var _";
				String id = cell1.getContents().trim();
				Matcher mat = pattern.matcher(id);
				id = mat.replaceAll("");
				if(id.isEmpty()) continue;
				line =line+id+";\n";
				String funcc = "\t\t public function get "+id+"():String\n";
				funcc +="\t\t{\n \t\t\t return _"+id+";\n\t\t}\n";
				System.out.println(line);
				str +=line;
				func +=funcc;
			}
			str +=func;
			str +="}\n}";
			System.out.println(str);
			File file = new File(outputPath+outfileName);
			if(!file.exists())
			{
				file.createNewFile();
			}
			FileOutputStream out = new FileOutputStream(file);
			out.write(str.getBytes("utf-8"));
//			.createWorkbook(new FileOutputStream(Configuration
//							.getPath()
//							+ "/out/" + fileName));

		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
		
		}
}
}
