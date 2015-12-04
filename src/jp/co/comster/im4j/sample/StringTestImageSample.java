package jp.co.comster.im4j.sample;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IMOperation;

public class StringTestImageSample {


    public static void main(String[] args) throws Exception {

		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");

    	String basePath = System.getProperty("user.dir");
    	String inimg = basePath + "/img/icon_maitama.jpg";
    	String tmp1img = basePath + "/img/tmp1.jpg";
    	String tmp2img = basePath + "/img/tmp1.jpg";
    	String outimg = basePath + "/img/icon_maitama_str_sample_out.jpg";

        File src = new File(inimg);
        File tmp1 = new File(tmp1img);
        File tmp2 = new File(tmp2img);
        File dest = new File(outimg);


        ConvertCmd cmd = new ConvertCmd();
        cmd.setSearchPath("C:\\usr\\bin\\ImageMagick-6.9.2-7-portable-Q16-x86");
//      cmd.setSearchPath("/opt/st_benesse_ne_jp/ImageMagick/bin/");

        IMOperation op = new IMOperation(); //imagemagick operator for command line tools

        //draw method
        op.addImage(src.getAbsolutePath());
//        op.resize(957, 626); //resizing image
        op.pointsize(40); //size of text
//        op.font("Times-New-Roman"); // font
//      op.font(basePath + "/font/ArmedBanana.ttf"); // font
      op.font(basePath + "/font/MEIRYO.TTC"); // font
//        op.fill("Black"); //font color
        op.fill("Red"); //font color
        op.draw("text 50,800 '１２３４５６７８９０'"); // location of text, actual text
        op.addImage(tmp1.getAbsolutePath());

        Date date = new Date();
        System.out.println("Start Time = " + sdf.format(date));
        cmd.run(op);
        System.out.println("End Time = " + sdf.format(new Date()) + "[" + (new Date().getTime() - date.getTime()) + "]" );

        op = new IMOperation(); //imagemagick operator for command line tools

        //draw method
        op.addImage(tmp1.getAbsolutePath());
//        op.resize(957, 626); //resizing image
        op.pointsize(40); //size of text
//        op.font("Times-New-Roman"); // font
//      op.font(basePath + "/font/ArmedBanana.ttf"); // font
      op.font(basePath + "/font/MEIRYO.TTC"); // font
//        op.fill("Black"); //font color
        op.fill("Red"); //font color
        op.draw("text 50,850 '１２３４５６７８９０'"); // location of text, actual text
        op.addImage(tmp2.getAbsolutePath());

        date = new Date();
        System.out.println("Start Time = " + sdf.format(date));
        cmd.run(op);
        System.out.println("End Time = " + sdf.format(new Date()) + "[" + (new Date().getTime() - date.getTime()) + "]" );

        op = new IMOperation(); //imagemagick operator for command line tools

        //draw method
        op.addImage(tmp2.getAbsolutePath());
//        op.resize(957, 626); //resizing image
        op.pointsize(40); //size of text
//        op.font("Times-New-Roman"); // font
//      op.font(basePath + "/font/ArmedBanana.ttf"); // font
      op.font(basePath + "/font/MEIRYO.TTC"); // font
//        op.fill("Black"); //font color
        op.fill("Red"); //font color
        op.draw("text 50,900 '１２３４５'"); // location of text, actual text
        op.addImage(dest.getAbsolutePath());

        date = new Date();
        System.out.println("Start Time = " + sdf.format(date));
        cmd.run(op);
        System.out.println("End Time = " + sdf.format(new Date()) + "[" + (new Date().getTime() - date.getTime()) + "]" );


        tmp1.delete();
        tmp2.delete();

    }

}
