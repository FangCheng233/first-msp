//package com.fc.msp.admin.mybatis;
//
///**
// * @ClassName Generator
// * @Description TODO
// * @Author fangcheng
// * @Date 2020/7/27 6:08 下午
// * @Version 1.0
// */
//
//import org.mybatis.generator.api.ShellRunner;
//
//public class Generator {
//    public static void main(String[] args) {
//        args = new String[] { "-configfile", "/Users/fangcheng/project/GitHub/first-msp/user-service/src/main/resources/mybatis/mybatis-generator.xml", "-overwrite" };
//        ShellRunner.main(args);
//
//    }
//
////      这两个main方法都可以执行生成JavaEntity不过喜欢上面那个简洁的方法
////	public static void main(String[] args) throws Exception {
////		File configFile = ResourceUtils.getFile("classpath:mybatis-generator-config.xml");
////		List<String> warnings = new ArrayList<String>();
////		ConfigurationParser cp = new ConfigurationParser(warnings);
////		Configuration config = cp.parseConfiguration(configFile);
////		DefaultShellCallback callback = new DefaultShellCallback(true);
////		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
////		myBatisGenerator.generate(null);
////
////	}
//
//}
