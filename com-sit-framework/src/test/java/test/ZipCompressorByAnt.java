package test;

/**
 * omplatform
 * test
 * @{#} testzip.java Create on  2013-7-17 上午9:57:06
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：
 *
 */
import java.io.File;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

public class ZipCompressorByAnt {

	private File zipFile;

	public ZipCompressorByAnt(String pathName) {
		zipFile = new File(pathName);
	}
	
	public void compress(String srcPathName) {
		File srcdir = new File(srcPathName);
		if (!srcdir.exists())
			throw new RuntimeException(srcPathName + "不存在！");
		
		Project prj = new Project();
		Zip zip = new Zip();
		zip.setProject(prj);
		zip.setDestFile(zipFile);
		FileSet fileSet = new FileSet();
		fileSet.setProject(prj);
		fileSet.setDir(srcdir);
		//fileSet.setIncludes("**/*.java"); 包括哪些文件或文件夹 eg:zip.setIncludes("*.java");
		//fileSet.setExcludes(...); 排除哪些文件或文件夹
		zip.addFileset(fileSet);
		
		zip.execute();
	}
}
