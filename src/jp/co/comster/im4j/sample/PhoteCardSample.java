package jp.co.comster.im4j.sample;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IMOperation;

public class PhoteCardSample {


    public static void main(String[] args) throws Exception {

		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");

    	String basePath = System.getProperty("user.dir");
    	String inimg = basePath + "/img/icon_maitama.jpg";
    	String miximg = basePath + "/img/flower-back0557.png";
    	String img_first = basePath + "/img/tmp1.jpg";
    	String img_second = basePath + "/img/tmp2.jpg";
    	String img_final = basePath + "/img/photocard.jpg";

        File org = new File(inimg);
        File background = new File(miximg);
        File tmp1 = new File(img_first);
        File tmp2 = new File(img_second);
        File photefile = new File(img_final);

        ConvertCmd cmd = new ConvertCmd();
//      cmd.setSearchPath("C:\\usr\\bin\\ImageMagick-6.9.2-7-portable-Q16-x86");
        cmd.setSearchPath("/opt/st_benesse_ne_jp/ImageMagick/bin/");


        //ImageCut
        IMOperation op;
        op = new IMOperation();
        op.addImage(org.getAbsolutePath());
        op.gravity("northwest");
        //      横幅 縦幅 開始横 開始縦
        op.crop(300, 500, 200, 300);
        op.addImage(tmp1.getAbsolutePath());
        System.out.println(op.toString());

        Date date;;
        date = new Date();
        System.out.println("Start Time = " + sdf.format(date));
        cmd.run(op);
        System.out.println("End Time = " + sdf.format(new Date()) + "[" + (new Date().getTime() - date.getTime()) + "]" );

        //ImageMix
        op = new IMOperation();
        op.addImage(tmp1.getAbsolutePath());
        op.addImage(background.getAbsolutePath());
//        op.resize(1024, 1024, '^');
        op.resize(300, 500, '!');
        op.gravity("northwest");
        op.composite();
        op.addImage(tmp2.getAbsolutePath());
        System.out.println(op.toString());

        date = new Date();
        System.out.println("Start Time = " + sdf.format(date));
        cmd.run(op);
        System.out.println("End Time = " + sdf.format(new Date()) + "[" + (new Date().getTime() - date.getTime()) + "]" );
        tmp1.delete();

        //ImageString
        op = new IMOperation();
        op.addImage(tmp2.getAbsolutePath());
      op.pointsize(28); //size of text
//      op.font("Times-New-Roman"); // font
      op.font(basePath + "/font/ArmedBanana.ttf"); // font
//      op.font(basePath + "/font/MEIRYO.TTC"); // font
//      op.fill("Black"); //font color
      op.fill("#8888ff"); //font color
      op.draw("text 10,400 'BSH医院で生まれました'"); // location of text, actual text
      op.addImage(tmp1.getAbsolutePath());
        System.out.println(op.toString());

        date = new Date();
        System.out.println("Start Time = " + sdf.format(date));
        cmd.run(op);
        System.out.println("End Time = " + sdf.format(new Date()) + "[" + (new Date().getTime() - date.getTime()) + "]" );


        //ImageString
        op = new IMOperation();
        op.addImage(tmp1.getAbsolutePath());
      op.pointsize(20); //size of text
//      op.font("Times-New-Roman"); // font
      op.font(basePath + "/font/ArmedBanana.ttf"); // font
//      op.font(basePath + "/font/MEIRYO.TTC"); // font
//      op.fill("Black"); //font color
      op.fill("#ff0000"); //font color
      op.draw("text 10,450 '平成27年12月1日午後1時頃'"); // location of text, actual text
      op.addImage(photefile.getAbsolutePath());
        System.out.println(op.toString());

        date = new Date();
        System.out.println("Start Time = " + sdf.format(date));
        cmd.run(op);
        System.out.println("End Time = " + sdf.format(new Date()) + "[" + (new Date().getTime() - date.getTime()) + "]" );

        tmp1.delete();
        tmp2.delete();

    }

}
