package com.gong;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.gong.customer.situation.service.LoginService;
import com.gong.listener.ExcelListener;
import com.gong.vo.TreeRoot;
import com.gong.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.tree.TreeNode;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerSituationApiApplicationTests {

	@Autowired
	private LoginService loginService;

	@Test
	public void loginAspectTest() {
		//测试正常用户登录
		loginService.login("user_2");
		//测试非法用户登录
		//loginService.login("user_1");
	}

	@Test
	public void resolveExcelTest(){
		File file = new File("D://测试.xlsx");
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			// 解析每行结果在listener中处理
			ExcelListener listener = new ExcelListener();
			ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, listener);
			excelReader.read(new Sheet(1, 1, User.class));
			System.out.println(listener.getDatas().size());
		} catch (Exception e) {

		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 研究hashMap
	 */
	@Test
	public void hashMapTest(){
		Map<String,String> map = new HashMap<>();
		map.put("ceshi","put");
	}

	@Test
	public void test(){


	}


//	public static void createTree(TreeRoot treeRoot, int value) {
//
//
//		//如果树根为空(第一次访问)，将第一个值作为根节点
//		if (treeRoot.getTreeRoot() == null) {
//			TreeNode treeNode = new TreeNode(value);
//			treeRoot.setTreeRoot(treeNode);
//
//		} else  {
//
//			//当前树根
//			TreeNode tempRoot = treeRoot.getTreeRoot();
//
//			while (tempRoot != null) {
//				//当前值大于根值，往右边走
//				if (value > tempRoot.getValue()) {
//
//					//右边没有树根，那就直接插入
//					if (tempRoot.getRightNode() == null) {
//						tempRoot.setRightNode(new TreeNode(value));
//						return ;
//					} else {
//						//如果右边有树根，到右边的树根去
//						tempRoot = tempRoot.getRightNode();
//					}
//				} else {
//					//左没有树根，那就直接插入
//					if (tempRoot.getLefTreeNode() == null) {
//						tempRoot.setLefTreeNode(new TreeNode(value));
//
//						return;
//					} else {
//						//如果左有树根，到左边的树根去
//						tempRoot = tempRoot.getLefTreeNode();
//					}
//				}
//			}
//		}
//	}
}
