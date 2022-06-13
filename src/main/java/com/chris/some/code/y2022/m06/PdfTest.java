package com.chris.some.code.y2022.m06;

/**
 * licence.xml
 * <License>
 * <Data>
 * <Products>
 * <Product>Aspose.Total for Java</Product>
 * <Product>Aspose.Words for Java</Product>
 * </Products>
 * <EditionType>Enterprise</EditionType>
 * <SubscriptionExpiry>20991231</SubscriptionExpiry>
 * <LicenseExpiry>20991231</LicenseExpiry>
 * <SerialNumber>8bfe198c-7f0c-4ef8-8ff0-acc3237bf0d7</SerialNumber>
 * </Data>
 * <Signature>
 * sNLLKGMUdF0r8O1kKilWAGdgfs2BvJb/2Xp8p5iuDVfZXmhppo+d0Ran1P9TKdjV4ABwAgKXxJ3jcQTqE/2IRfqwnPf8itN8aFZlV3TJPYeD3yWE7IT55Gz6EijUpC7aKeoohTb4w2fpox58wWoF3SNp6sK6jDfiAUGEHYJ9pjU=
 * </Signature>
 * </License>
 *
 * <dependency>
 * <groupId>com.aspose</groupId>
 * <artifactId>aspose-pdf</artifactId>
 * <version>21.11</version>
 * <scope>system</scope>
 * <systemPath>/Users/alex/Downloads/aspose.pdf-21.11-java/lib/aspose.pdf-21.11.jar</systemPath>
 * </dependency>
 *
 * @author grt
 */
public class PdfTest {

    public static void main(String[] args) throws Exception {
        // aspose.pdf
//        InputStream is = new FileInputStream("/Users/alex/Projects/Idea/GitProject/some-code/src/main/resources/licence.xml");
//        License license = new License();
//        license.setLicense(is);
//        Document document = new Document("/Users/alex/Downloads/AAA.pdf");
//        TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("$AAA@");
//        document.getPages().accept(textFragmentAbsorber);
//        TextFragmentCollection textFragments = textFragmentAbsorber.getTextFragments();
//        for (TextFragment textFragment : textFragments) {
//            String text = textFragment.getText();
//            System.out.println("text = " + text);
//            textFragment.setText("疯狂撒娇反馈绝对是方静都是会计法");
//        }
//        document.save("/Users/alex/Downloads/AAA(create).pdf");
    }

    /**
     * 修改jar包字节码
     * <dependency>
     * <groupId>org.javassist</groupId>
     * <artifactId>javassist</artifactId>
     * <version>3.28.0-GA</version>
     * </dependency>
     */
//    public static void modifyPDFJar() {
//        try {
//            //这一步是完整的jar包路径,选择自己解压的jar目录
//            ClassPool.getDefault().insertClassPath("/Users/alex/Downloads/aspose.pdf-21.11-java/lib/aspose.pdf-21.11.jar");
//            //获取指定的class文件对象
//            CtClass zzZJJClass = ClassPool.getDefault().getCtClass("com.aspose.pdf.l9f");
//            //从class对象中解析获取所有方法
//            CtMethod[] methodA = zzZJJClass.getDeclaredMethods();
//            for (CtMethod ctMethod : methodA) {
//                //获取方法获取参数类型
//                CtClass[] ps = ctMethod.getParameterTypes();
//                //筛选同名方法，入参是Document
//                if (ps.length == 1 && ctMethod.getName().equals("lI") && ps[0].getName().equals("java.io.InputStream")) {
//                    System.out.println("ps[0].getName==" + ps[0].getName());
//                    //替换指定方法的方法体
//                    ctMethod.setBody("{this.l0if = com.aspose.pdf.l10if.lf;com.aspose.pdf.internal.imaging.internal.p71.Helper.help1();lI(this);}");
//                }
//            }
//            //这一步就是将破译完的代码放在桌面上
//            zzZJJClass.writeFile("/Users/alex/Downloads");
//
//        } catch (Exception e) {
//            System.out.println("错误==" + e);
//        }
//    }
}
