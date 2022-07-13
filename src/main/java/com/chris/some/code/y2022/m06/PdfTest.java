package com.chris.some.code.y2022.m06;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

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
//        Document document = new Document("/Users/alex/Downloads/融资租赁合同（售后回租）06281640.pdf");
//
//        Map<String, String> map = new HashMap<>();
//        map.put("#{leaseTerm}#", "24");
//        map.put("#{typeNameA}#", "车辆融资");
//        map.put("#{typePriceC}#", "/");
//        map.put("#{typeNameB}#", "/");
//        map.put("#{typePriceD}#", "/");
//        map.put("#{typeNameC}#", "/");
//        map.put("#{typePriceE}#", "/");
//        map.put("#{typeNameD}#", "/");
//        map.put("#{handCarBrand}#", "/");
//        map.put("#{handCarModel}#", "/");
//        map.put("#{lesAdd}#", "地址XXXXXXXXXXXXXXXXXXXXXXXX");
//        map.put("#{warAdd}#", "似懂非懂发送到发个");
//        map.put("#{contractType}#", "RZZL");
//        map.put("#{typePriceA}#", "90,000.00");
//        map.put("#{lesIdNo}#", "210105199303200665");
//        map.put("#{typePriceB}#", "/");
//        map.put("#{rentTotal}#", "壹拾万零壹佰柒拾贰元壹角陆分");
//        map.put("#{warNameTwo}#", "保证人");
//        map.put("#{vin}#", "XXXXXXXXXXXXXXXXXXXXX");
//        map.put("#{cutAccountName}#", "中信面签九");
//        map.put("#{annSignleRate}#", "10.34");
//        map.put("#{carBrand}#", "东风本田");
//        map.put("#{handCarVin}#", "/");
//        map.put("#{joinName}#", "曾烈平有");
//        map.put("#{cuD}#", String.valueOf(17));
//        map.put("#{cutBank}#", "农业银行");
//        map.put("#{joinAdd}#", "家运巷社区6栋3单元4号");
//        map.put("#{cutBankAccount}#", "6228481423289317110");
//        map.put("#{warPhoneTwo}#", "13280105206");
//        map.put("#{warIdNo}#", "181404198609077044");
//        map.put("#{warAddTwo}#", "保证人现住房地址");
//        map.put("#{leasePri}#", "玖万元");
//        map.put("#{eachRent}#", "4,173.84");
//        map.put("#{deposit}#", "/");
//        map.put("#{cuY}#", String.valueOf(2022));
//        map.put("#{otherxz}#", "/");
//        map.put("#{annRate}#", "10.50");
//        map.put("#{annRatePoin}#", String.valueOf(650));
//        map.put("#{poundage}#", "/");
//        map.put("#{warIdNoTwo}#", "37020319890116015X");
//        map.put("#{depositS}#", "/           ");
//        map.put("#{joinPhone}#", "15555555555");
//        map.put("#{getAccountNameA}#", "这个地方也改了");
//        map.put("#{rentTotalS}#", "/           ");
//        map.put("#{getAccountE}#", "/");
//        map.put("#{getAccountD}#", "/");
//        map.put("#{getAccountC}#", "/");
//        map.put("#{ectrDefCde}#", "00000001");
//        map.put("#{getAccountB}#", "/");
//        map.put("#{lesPhone}#", "15106111701");
//        map.put("#{getAccountA}#", "6222021103020537770");
//        map.put("#{engNum}#", "23344");
//        map.put("#{leavePriS}#", "/           ");
//        map.put("#{getBankB}#", "/");
//        map.put("#{leasePriS}#", "/           ");
//        map.put("#{getBankC}#", "/");
//        map.put("#{getBankD}#", "/");
//        map.put("#{getBankE}#", "/");
//        map.put("#{warName}#", "公孙胜");
//        map.put("#{cuM}#", String.valueOf(6));
//        map.put("#{getAccountNameB}#", "/");
//        map.put("#{lessee}#", "中信面签九");
//        map.put("#{getAccountNameC}#", "/");
//        map.put("#{getAccountNameD}#", "/");
//        map.put("#{joinIdNo}#", "370119197712283333");
//        map.put("#{getAccountNameE}#", "/");
//        map.put("#{contracNo}#", "ZXZL-CAXS-ZL-20220611-00004");
//        map.put("#{htContracNo}#", "ZXZL-CAXS-ZL-20220611-00009");
//        map.put("#{warPhone}#", "15633338888");
//        map.put("#{poundageS}#", "/           ");
//        map.put("#{overDue}#", "0.02");
//        map.put("#{leavePri}#", "壹元");
//        map.put("#{ectrName}#", "融资租赁合同");
//        map.put("#{typeNameE}#", "/");
//        map.put("#{carModel}#", "CR-V思威1.5T-MT-240TURBO经典版前驱(国Ⅴ)|CR-V思威1.5T-MT-240TURBO经典版前驱(国Ⅴ)|CR-V思威1.5T-MT-240TURBO经典版前驱(国Ⅴ)|");
//        map.put("#{getBankA}#", "中国人民银行元氏县支行");
//        map.put("#{anSR}#", "0.55");
//        map.put("#{anRP}#", "6.00");
//        map.put("#{fSAmt}#", "0.55");
//        map.put("#{sAAmt}#", "0.66");
//        map.put("#{contractSignArea}#", "山东省青岛市苗岭路打货款打货款的哈客户好久好久大师大所");
//
//        System.out.println(System.currentTimeMillis());
//        TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("#\\{[a-zA-Z]*}#");
//        TextSearchOptions textSearchOptions = new TextSearchOptions(true);
//        textFragmentAbsorber.setTextSearchOptions(textSearchOptions);
//        document.getPages().accept(textFragmentAbsorber);
//        TextFragmentCollection textFragments = textFragmentAbsorber.getTextFragments();
//        for (TextFragment textFragment : textFragments) {
//            String text = textFragment.getText();
//            String s = map.get(text);
//            if (StringUtils.isNotBlank(s)) {
//                textFragment.setText(s);
//            }
//        }
//        document.save("/Users/alex/Downloads/合同.pdf");
//        System.out.println(System.currentTimeMillis());
//        modifyPDFJar();
    }

    /**
     * 修改jar包字节码
     * <dependency>
     * <groupId>org.javassist</groupId>
     * <artifactId>javassist</artifactId>
     * <version>3.28.0-GA</version>
     * </dependency>
     */
    public static void modifyPDFJar() {
        try {
            //这一步是完整的jar包路径,选择自己解压的jar目录
            ClassPool.getDefault().insertClassPath("/Users/alex/Downloads/aspose-pdf-22.5.jar");
            //获取指定的class文件对象
            CtClass zzZJJClass = ClassPool.getDefault().getCtClass("com.aspose.pdf.l10y");
            //从class对象中解析获取所有方法
            CtMethod[] methodA = zzZJJClass.getDeclaredMethods();
            for (CtMethod ctMethod : methodA) {
                //获取方法获取参数类型
                CtClass[] ps = ctMethod.getParameterTypes();
                //筛选同名方法，入参是Document
                if (ps.length == 1 && ctMethod.getName().equals("lI") && ps[0].getName().equals("java.io.InputStream")) {
                    System.out.println("ps[0].getName==" + ps[0].getName());
                    //替换指定方法的方法体
                    ctMethod.setBody("{this.l0if = com.aspose.pdf.l10n.lf;com.aspose.pdf.internal.l132u.lf.lI();lI(this);}");
                }
            }
            //这一步就是将破译完的代码放在桌面上
            zzZJJClass.writeFile("/Users/alex/Downloads");

        } catch (Exception e) {
            System.out.println("错误==" + e);
        }
    }
}
